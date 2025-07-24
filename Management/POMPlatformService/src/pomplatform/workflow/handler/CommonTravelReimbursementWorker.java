package pomplatform.workflow.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BaseTravelReimbursementDetail;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.ExpressionData;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import pomplatform.common.utils.CommonUtils;
import pomplatform.workflow.bean.BaseTravelReimbursementWithT;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.dao.TravelReimbursementWithT;

public class CommonTravelReimbursementWorker implements GenericWorkflowProcessor {

	protected BaseTravelReimbursementWithT bean = new BaseTravelReimbursementWithT();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setDrafter(employeeId);
		dataValidate();
		TravelReimbursementWithT dao = new TravelReimbursementWithT();
		dao.setDataFromBase(bean);
		dao.setCode(OnWrokflowProcess.getNewCode(BaseHelpUtils.getIntValue(pd.getProcessTypeId())));
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getTravelReimbursementId(), bean.getTitle());
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed)
			throws Exception {
		if (!completed) {
			bean.setDataFromMap(params);
			dataValidate();
			TravelReimbursementWithT dao = new TravelReimbursementWithT();
			dao.setPrimaryKeyFromBase(bean);
			if (!dao.load())
				throw new SQLException("Business data not found");
			dao.setDataFromBase(bean);
			dao.update();
			BusinessAbstract ba = new BusinessAbstract(dao.getTravelReimbursementId(), bean.getTitle());
			return ba;
		}
		return null;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		e.setValue("金额", bean.getAmount() == null ? 0.0 : bean.getAmount().doubleValue());
		e.setValue("公司", CommonUtils.getCompanyShortName(bean.getCompanyId()));
		ExpressionData ed = e.evaluateExpression();
		return ed.getBooleanValue();
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		TravelReimbursementWithT dao = new TravelReimbursementWithT();
		dao.setTravelReimbursementId(businessId);
		dao.load();
		return dao.generateBaseExt().toJSON();
	}

	public void dataValidate() throws Exception {
		if (BaseHelpUtils.isNullOrEmpty(bean.getTitle())) {
			throw new Exception("请填写主题");
		}
		if (BaseHelpUtils.isNullOrZero(bean.getDrafter())) {
			throw new Exception("起草人出错");
		}
		if (BaseHelpUtils.isNullOrZero(bean.getApplicant())) {
			throw new Exception("请选择报销人");
		}
		if (bean.getEndDate().getTime() - bean.getStartDate().getTime() < 0) {
			throw new Exception("出差结束日期必须大于等于开始日期");
		}
		if (null == bean.getAmount() || bean.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
			throw new Exception("报销金额必须大于0");
		}
		if (BaseHelpUtils.isNullOrEmpty(bean.getRemark())) {
			throw new Exception("请填写备注");
		}
		List<BaseTravelReimbursementDetail> list = bean.getDetailTravelReimbursementDetail();
		if (null == list || list.isEmpty()) {
			throw new Exception("请填写差旅报销明细");
		}
	}

}
