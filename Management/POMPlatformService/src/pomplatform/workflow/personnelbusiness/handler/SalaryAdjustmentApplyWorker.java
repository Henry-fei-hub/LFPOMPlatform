package pomplatform.workflow.personnelbusiness.handler;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import com.pomplatform.db.bean.BaseEmployeePayment;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.PersonnelBusines;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import pomplatform.common.utils.StaticUtils;
import pomplatform.personnelbusiness.bean.BaseDecryptPersonnelBusiness;
import pomplatform.personnelbusiness.bean.ConditionDecryptPersonnelBusiness;
import pomplatform.personnelbusiness.query.QueryDecryptPersonnelBusiness;
import pomplatform.workflow.business.OnWrokflowProcess;

public class SalaryAdjustmentApplyWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();
	protected BaseEmployeePayment payBean = new BaseEmployeePayment();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dataValidate(dao);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified,
			boolean completed) throws Exception {
		bean.setDataFromMap(params);
		if(!modified) {
			ProcessInstance pIns = pi.getProcessInstance();
			if(BaseHelpUtils.isNullOrEmpty(pIns)) {
				return null;
			}

			//获取当前审批节点
			ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
			if(BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
				return null;
			}
			//获取当前节点类型
			int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			//只有处理节点才可以更改数据
			if(!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {//处理节点
				return null;
			}
		}
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dataValidate(dao);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e =OnWrokflowProcess.setExpression(expression, e, employeeId, null, null, null);

		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		if(null != roleId && roleId.equals(StaticUtils.ROLE_CUSTOM_AUDITOR)){
			return new int[] {bean.getEmployeeId()};
		}    
		return ProcessUtil.findNextOwner(bean.getEmployeeId(), employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		ConditionDecryptPersonnelBusiness condition = new ConditionDecryptPersonnelBusiness();
		condition.setPersonnelBusinessId(businessId);
		QueryDecryptPersonnelBusiness query = new QueryDecryptPersonnelBusiness();
		BaseCollection<BaseDecryptPersonnelBusiness> bc = query.executeQuery(null, condition);
		if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()){
			return bc.getCollections().get(0).toJSON();
		}
		BasePersonnelBusines bean = new BasePersonnelBusines();
		return bean.toJSON();
	}

	private void dataValidate(PersonnelBusines dao) throws Exception{
		if(BaseHelpUtils.isNullOrZero(dao.getProcessType())){
			throw new Exception("流程类型错误");
		}
		if(BaseHelpUtils.isNullOrZero(dao.getEmployeeId())){
			throw new Exception("调薪员工不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getEmployeeNo())){
			throw new Exception("调薪员工工号不能为空");
		}
		if(BaseHelpUtils.isNullOrZero(dao.getDepartmentId())){
			throw new Exception("调薪员工所在部门不能为空");
		}
		Date date = dao.getEndDate();
		if(BaseHelpUtils.isNullOrEmpty(date)){
			throw new Exception("调薪日期不能为空");	
		}
		if(BaseHelpUtils.isNullOrZero(dao.getSeverance())){
			throw new Exception("本次调薪金额不能为空或0");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getMonthPay())){
			throw new Exception("调整后薪资总额不能为空");
		}
	}
}
