package pomplatform.workflow.personnelbusiness.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.CompanyRecord;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.ReceiveUnitManage;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.personnelbusiness.business.SendMSGCommon;

public class ReceiveUnitRepaymentWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dataValidate(dao);
		dao.save();
		params.put("personnelBusinessId", dao.getPersonnelBusinessId());
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
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
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				dao.setIsCompleted(Boolean.TRUE);
				ReceiveUnitManage rumDao = new ReceiveUnitManage();
				rumDao.setReceiveUnitManageId(dao.getParentId());
				rumDao.load();
				//往资金表插入员工还款数据
				Capital cDao = new Capital();
				cDao.setHappenDate(dao.getStartDate());
				cDao.setBorrowMoney(dao.getFee());
				cDao.setSelfName(dao.getProjectId());
				cDao.setSelfBankAccount(dao.getProjectCode());
				cDao.setSelfBankName(dao.getProjectName());
				cDao.setOtherName(rumDao.getReceiveUnit());
				cDao.setMoneyAttribute(bean.getType());//各种款项
				cDao.setOperator(dao.getEmployeeId()); 
				cDao.setOtherBankAccount(rumDao.getBankAccount());
				cDao.setOtherBankName(rumDao.getBankName());
				cDao.setCapitalType(1);//流入资金
				cDao.setProcessType(bean.getProcessType());
				cDao.setBusinessId(bean.getPersonnelBusinessId());
				cDao.setExchangeRate(new BigDecimal("1"));
				cDao.setOriginalCurrency(dao.getFee());
				cDao.save();
			}
			
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)){//被驳回
				//流程被驳回则消息通知发起人
//				String code = bean.getCode();
				ProcessInstance processInstance = pi.getProcessInstance();
				Integer processType = processInstance.getProcessType(); 
				int applyEmpId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
				SendMSGCommon sendMSGCommon =new SendMSGCommon();
				Map map =new HashMap<String, Object>();
//				map.put("code", code);
				map.put("processType", processType);
				map.put("applyEmpId", applyEmpId);
				sendMSGCommon.sendWXMsgToUser(map);
				}
			
			
		}
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e =OnWrokflowProcess.setExpression(expression, e, employeeId, null, null, null);
		e.setValue("天数", bean.getDays() == null ? 0.0 : bean.getDays().doubleValue());
		CompanyRecord cr = new CompanyRecord();
		if(bean.getCompanyId()>0){
			cr.setCompanyRecordId(bean.getCompanyId());
			cr.load();
		}
		if(expression.contains(StaticUtils.BELONGING_COMPANY)){
			if(BaseHelpUtils.isNullOrEmpty(cr)){
				e.setValue(StaticUtils.BELONGING_COMPANY,"");
			}else{
				e.setValue(StaticUtils.BELONGING_COMPANY,cr.getCompanyName());
			}
		}
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		return dao.generateBase().toJSON();
	}

	private void dataValidate(PersonnelBusines dao) throws Exception{
		if(BaseHelpUtils.isNullOrZero(dao.getProcessType())){
			throw new Exception("流程类型错误");
		}
		if(BaseHelpUtils.isNullOrZero(dao.getEmployeeId())){
			throw new Exception("申请人不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getEmployeeNo())){
			throw new Exception("工号不能为空");
		}
	}

	public static void main(String[] args) throws SQLException {
		PersonnelBusines pb = new PersonnelBusines();
		pb.setConditionProcessType("=", 41);
		List<BasePersonnelBusines> list = pb.conditionalLoad();
		ReceiveUnitManage rumDao = new ReceiveUnitManage();
		Capital cDao = new Capital();
		for (BasePersonnelBusines basePersonnelBusines : list) {
			cDao.clear();
			cDao.setConditionProcessType("=", basePersonnelBusines.getProcessType());
			cDao.setConditionBusinessId("=", basePersonnelBusines.getPersonnelBusinessId());
			if(cDao.countRows() <= 0){
				rumDao.clear();
				rumDao.setReceiveUnitManageId(basePersonnelBusines.getParentId());
				rumDao.load();
				cDao.clear();
				cDao.setHappenDate(basePersonnelBusines.getStartDate());
				cDao.setBorrowMoney(basePersonnelBusines.getFee());
				cDao.setSelfName(basePersonnelBusines.getProjectId());
				cDao.setSelfBankAccount(basePersonnelBusines.getProjectCode());
				cDao.setSelfBankName(basePersonnelBusines.getProjectName());
				cDao.setOtherName(rumDao.getReceiveUnit());
				cDao.setMoneyAttribute(basePersonnelBusines.getType());//各种款项
				cDao.setOperator(basePersonnelBusines.getEmployeeId()); 
				cDao.setOtherBankAccount(rumDao.getBankAccount());
				cDao.setOtherBankName(rumDao.getBankName());
				cDao.setCapitalType(1);//流入资金
				cDao.setProcessType(basePersonnelBusines.getProcessType());
				cDao.setBusinessId(basePersonnelBusines.getPersonnelBusinessId());
				cDao.save();
			}
		}
	}
}
