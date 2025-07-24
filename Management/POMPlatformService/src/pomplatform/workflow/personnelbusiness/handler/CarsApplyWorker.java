package pomplatform.workflow.personnelbusiness.handler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.SystemDictionary;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.ExpressionData;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Employee;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import message.common.OnTelMobile;

public class CarsApplyWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		dataValidate();
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified,
			boolean completed) throws Exception {
		bean.setDataFromMap(params);
		dataValidate();
		PersonnelBusines dao = new PersonnelBusines();
		if (completed) {
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				bean.setIsCompleted(true);
			}
			StringBuilder sb1 = new StringBuilder();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			sb1.append("您的用车申请已通过审批，详情信息如下：出发地：").append(bean.getProjectName()).append("；目的地：")
					.append(bean.getProjectCode()).append("；出发时间：").append(format.format(bean.getStartDate()));
			StringBuilder sb2 = new StringBuilder();
			sb2.append("您好，公司于").append(format.format(bean.getStartDate())).append("需要派车，车辆信息：");
			if (null == bean.getTargetProvince()) {
				sb1.append("。公司已帮您预定了神州专车，专车的车牌号码、司机联系方式等信息，将于出发前半小时由神州专车平台发送短信到您的手机上，请留意稍后的短信通知。祝您一路顺风！");
			} else {
				sb1.append("；车辆信息：");
				SystemDictionary dicDao = new SystemDictionary();
				dicDao.setConditionDicTypeId("=", 106);
				dicDao.setConditionDicTypeValueId("=", bean.getTargetProvince());
				dicDao.unsetSelectFlags();
				dicDao.setSelectDicTypeValue(true);
				String carInfo = dicDao.executeQueryOneRow().getDicTypeValue();
				sb1.append(carInfo);
				sb2.append(carInfo);
				Employee empDao = new Employee();
				empDao.setEmployeeId(BaseHelpUtils.getIntValue(bean.getContactPerson()));
				empDao.unsetSelectFlags();
				empDao.setSelectEmployeeName(true);
				if (empDao.load()) {
					sb1.append("；随行司机：").append(empDao.getEmployeeName());
				}
				sb1.append("。祝您一路顺风！");
				sb2.append("；出发地：").append(bean.getProjectName()).append("；目的地：").append(bean.getProjectCode());
				empDao.clear();
				empDao.setEmployeeId(bean.getEmployeeId());
				empDao.unsetSelectFlags();
				empDao.setSelectEmployeeName(true);
				if (empDao.load()) {
					sb2.append("；出行人：").append(empDao.getEmployeeName());
				}
				sb2.append("；出行人联系方式：").append(bean.getCard()).append("。祝您一路顺风！");
				// 发消息给司机
				OnTelMobile.onTelMobileSendMeg(BaseHelpUtils.getIntValue(bean.getContactPerson()), sb2.toString());
			}
			// 发送信息给申请人
			OnTelMobile.onTelMobileSendMeg(bean.getCard(), sb1.toString());
		}
		dao.setPrimaryKeyFromBase(bean);
		if (!dao.load())
			throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		e.setValue("用车范围", bean.getType().intValue() == 0 ? "市内用车" : "");
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
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		return dao.generateBase().toJSON();
	}

	private void dataValidate() throws Exception {
		if (BaseHelpUtils.isNullOrZero(bean.getProcessType())) {
			throw new Exception("流程类型错误");
		}
		if (BaseHelpUtils.isNullOrZero(bean.getEmployeeId())) {
			throw new Exception("申请人不能为空");
		}
		if (BaseHelpUtils.isNullOrEmpty(bean.getCard())) {
			throw new Exception("请填写手机号码");
		}
		if (BaseHelpUtils.isNullOrEmpty(bean.getType())) {
			throw new Exception("请选择用车范围");
		}
		if (BaseHelpUtils.isNullOrEmpty(bean.getUnit())) {
			throw new Exception("请填写同行人数");
		}
		if (BaseHelpUtils.isNullOrEmpty(bean.getAddress())) {
			throw new Exception("请填写申请用车车型");
		}
		Date startDate = bean.getStartDate();
		if (BaseHelpUtils.isNullOrEmpty(startDate)) {
			throw new Exception("用车开始时间不能为空");
		}
		Date endDate = bean.getEndDate();
		if (BaseHelpUtils.isNullOrEmpty(endDate)) {
			throw new Exception("用车结束时间不能为空");
		}
		if (startDate.getTime() >= endDate.getTime()) {
			throw new Exception("用车结束时间必须晚于用车开始时间");
		}
		if (BaseHelpUtils.isNullOrEmpty(bean.getProjectName())) {
			throw new Exception("请填写出发地");
		}
		if (BaseHelpUtils.isNullOrEmpty(bean.getProjectCode())) {
			throw new Exception("请填写目的地");
		}
		if (BaseHelpUtils.isNullOrEmpty(bean.getReason())) {
			throw new Exception("请填写用车目的");
		}
	}
}
