package pomplatform.workflow.personnelbusiness.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseWorkHandover;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.WorkHandover;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericBase;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Employee;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import message.common.OnTelMobile;
import message.common.SendEmailTemplate;
import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseOnGetLeftIntegralOfEmployee;
import pomplatform.account.bean.ConditionOnGetLeftIntegralOfEmployee;
import pomplatform.account.query.QueryOnGetLeftIntegralOfEmployee;
import pomplatform.common.utils.StaticUtils;
import pomplatform.role.bean.BaseGetProjectManagersByEmployeeId;
import pomplatform.role.bean.ConditionGetProjectManagersByEmployeeId;
import pomplatform.role.query.QueryGetProjectManagersByEmployeeId;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.contractstatus.handler.GetAttenEmpByContractStatusHandler;

public class ResignationApplyWorker implements GenericWorkflowProcessor {
	public static String SEND_MOBILE_MSG_START = "";
	public static String SEND_MOBILE_MSG_END = "";
	public static String SEND_EMAIL_MSG_START = "";
	public static String SEND_EMAIL_MSG_END = "";
	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	private static final Logger __logger = Logger.getLogger(ResignationApplyWorker.class);

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		__logger.info("------------------------------------- params :" + params);
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		__logger.info("------------------------------------- bean :" + bean);
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		__logger.info("------------------------------------- dao :" + dao);
		dataValidate(dao);
		dao.save();
		List<com.pomplatform.db.bean.BaseWorkHandover> list = GenericBase.__getList(
				params.get("list"), com.pomplatform.db.bean.BaseWorkHandover.newInstance());
		if(null != list){
			for(BaseWorkHandover obj : list){
				obj.setLinkId(dao.getPersonnelBusinessId());
			}
			WorkHandover workDao = new WorkHandover();
			workDao.save(list);
		}
		boolean testProcessor = BaseHelpUtils.getBoolean(params.get(StaticUtils.TEST_PROCESSOR));
		//如果是测试流程，就不走下面的方法
		if(!testProcessor) {
			Employee employeeDao = new Employee();
			employeeDao.setEmployeeId(bean.getEmployeeId());
			employeeDao.unsetSelectFlags();
			employeeDao.setSelectMobile(true);
			employeeDao.setSelectEmployeeName(true);
			employeeDao.setSelectCompanyEmail(true);
			if(employeeDao.load()){
				if(!BaseHelpUtils.isNullOrEmpty(SEND_MOBILE_MSG_START)&&!BaseHelpUtils.isNullOrEmpty(SEND_MOBILE_MSG_END)) {
					OnTelMobile.onTelMobileSendMeg(bean.getEmployeeId(),String.format("%1$s%2$s%3$s",SEND_MOBILE_MSG_START,employeeDao.getEmployeeName(),SEND_MOBILE_MSG_END));
				}
				if(null != employeeDao.getCompanyEmail()&&!BaseHelpUtils.isNullOrEmpty(SEND_EMAIL_MSG_START)&&!BaseHelpUtils.isNullOrEmpty(SEND_EMAIL_MSG_END)){
					SendEmailTemplate.sendEmail(employeeDao.getCompanyEmail(), null, SEND_EMAIL_MSG_START, SEND_EMAIL_MSG_END);
				}
			}
		}
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
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				bean.setIsCompleted(true);
				dao.setIsCompleted(true);
				//流程走完的时候，重新计算最后账户余额和离职奖金
				ConditionOnGetLeftIntegralOfEmployee condition = new ConditionOnGetLeftIntegralOfEmployee();
		    	condition.setEmployeeId(bean.getEmployeeId());
		    	QueryOnGetLeftIntegralOfEmployee query = new QueryOnGetLeftIntegralOfEmployee();
		    	BaseCollection<BaseOnGetLeftIntegralOfEmployee> result = query.executeQuery(null, condition);
		    	if(null != result && null != result.getCollections() && !result.getCollections().isEmpty()) {
		    		BaseOnGetLeftIntegralOfEmployee employeeInteger = result.getCollections().get(0);
		    		dao.setLivingExpenses(BaseHelpUtils.getBigDecimalValue(employeeInteger.getIntegral()));
		    		BigDecimal fee = dao.getLivingExpenses().subtract(BaseHelpUtils.getBigDecimalValue(dao.getHousingFinance()));
		    		if(fee.compareTo(BigDecimal.ZERO) < 0) {
		    			fee = BigDecimal.ZERO;
		    		}
		    		dao.setFee(fee);
		    	}
			}
		}
		dao.update();
		List<com.pomplatform.db.bean.BaseWorkHandover> list = GenericBase.__getList(
				params.get("list"), com.pomplatform.db.bean.BaseWorkHandover.newInstance());
		if(null != list){
			WorkHandover workDao = new WorkHandover();
			for(BaseWorkHandover obj : list){
				workDao.clear();
				workDao.setPrimaryKeyFromBase(obj);
				if(workDao.isPrimaryKeyNull()) {
					obj.setLinkId(dao.getPersonnelBusinessId());
					workDao.setDataFromBase(obj);
					workDao.save();
				}else if(dao.load()) {
					workDao.setDataFromBase(obj);
					workDao.update();
				}
			}
		}
		String deleteId = BaseHelpUtils.getString(params.get("deleteIds"));
		if(!BaseHelpUtils.isNullOrEmpty(deleteId)){
			String[] idString = deleteId.split(",");
			int length = idString.length;
			Integer[] ids = new Integer[length];
			for(int i = 0; i < length; i++){
				ids[i] = BaseHelpUtils.getIntValue(idString[i]);
			}
			WorkHandover workDao = new WorkHandover();
			workDao.addCondition(BaseWorkHandover.CS_WORK_HANDOVER_ID, "in", (Object[]) ids);
			workDao.conditionalDelete();
		}
		//		if(completed){
		//			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
		//				//关闭ERP的账户
		//				Employee employeeDao = new Employee();
		//				employeeDao.setEmployeeId(dao.getEmployeeId());
		//				if(employeeDao.load()){
		//					employeeDao.setStatus(StaticUtils.EMPLOYEE_DIMISSION);
		//					employeeDao.setResignationDate(dao.getEndDate());
		//					employeeDao.update();
		//					//关闭薪酬记录表数据
		//					EmployeePayment epDao = new EmployeePayment();
		//					epDao.setConditionEmployeeId("=",bean.getEmployeeId());
		//					epDao.setConditionEnabled("=",Boolean.TRUE);
		//					if(epDao.countRows() > 0){
		//						epDao.setEnabled(Boolean.FALSE);
		//						epDao.conditionalUpdate();
		//					}
		//				}
		//				//流程通过，关闭各个平台的账户
		//				UserAccountUtils.deleteUserAccount(dao.getEmployeeId());
		//				//删除下发到考勤机的该员工的数据
		//				ClockMsgProcess.deleteEmployeeOfAllClock(dao.getEmployeeId().intValue());
		//			}
		//		}
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());

		e =OnWrokflowProcess.setExpression(expression, e, employeeId, null, null, null);
		if(expression.contains("人事状态")){
			Employee employee = new Employee();
			employee.setEmployeeId(employeeId);
			if(employee.load()){
				if(!BaseHelpUtils.isNullOrEmpty(employee.getOnboardStatus())&& employee.getOnboardStatus()==0){
					e.setValue("人事状态","实习生");
				}else{
					e.setValue("人事状态","");
				}
			}
		}

		if(expression.contains("离职类型")){
			e.setValue("离职类型", null == bean.getType() ? "暂无" : (1 == bean.getType().intValue() ? "主动离职" : "辞退员工"));
		}
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		//专业负责人
		/*if(null != roleId && roleId.equals(StaticUtils.ROLE_PROJECT_MANAGER)){
			ConditionGetProjectManagersByEmployeeId condition = new ConditionGetProjectManagersByEmployeeId();
			condition.setEmployeeId(processCreator);
			QueryGetProjectManagersByEmployeeId query = new QueryGetProjectManagersByEmployeeId();
			BaseCollection<BaseGetProjectManagersByEmployeeId> bc = query.executeQuery(null, condition);
			if(null != bc && null != bc.getCollections()){
				List<BaseGetProjectManagersByEmployeeId> list = bc.getCollections();
				Set<Integer> set = new HashSet<>();
				for(BaseGetProjectManagersByEmployeeId base : list){
					if(!BaseHelpUtils.isNullOrEmpty(base.getProjectManageId())) {
						set.add(base.getProjectManageId());
					}
				}
				if(set.isEmpty()){
					return new int[0];
				}
				int size = set.size();
				int[] arr = new int[size];
				int i = 0;
				for(Integer id : set){
					arr[i++] = id;
				}
				return arr;
			}
		}*/
		//部门经理
		/*if (null != roleId && roleId.intValue() == StaticUtils.ROLE_DEPARTMENT_MANAGER) {
			Project dao = new Project();
			dao.unsetSelectFlags();
			dao.setSelectDepartmentManagerId(true);
			dao.setConditionProjectManageId("=", bean.getEmployeeId());
			List<BaseProject> list = dao.conditionalLoad();
			Set<Integer> set = new HashSet<>();
			for(BaseProject base : list){
				if(!BaseHelpUtils.isNullOrEmpty(base.getDepartmentManagerId())) {
					set.add(base.getDepartmentManagerId());
				}
			}
			if(set.isEmpty()){
				return new int[0];
			}
			int size = set.size();
			int[] arr = new int[size];
			int i = 0;
			for(Integer id : set){
				arr[i++] = id;
			}
			return arr;
		}*/
		//分管合伙人（人力）
		/*if (null != roleId && roleId.intValue() == StaticUtils.MANAGING_PARTNER_HR) {

		}*/

		//自定义审核人节点回到申请人
		if(null != roleId && roleId.equals(StaticUtils.ROLE_CUSTOM_AUDITOR)){
			return new int[] {bean.getEmployeeId()};
		}
		return ProcessUtil.findNextOwner(bean.getEmployeeId(), employeeId, departmentId, roleId);
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
			throw new Exception("离职员工不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getEmployeeNo())){
			throw new Exception("离职员工工号不能为空");
		}
		if(BaseHelpUtils.isNullOrZero(dao.getDepartmentId())){
			throw new Exception("离职员工所在部门不能为空");
		}
		Date date = dao.getStartDate();
		if(BaseHelpUtils.isNullOrEmpty(date)){
			throw new Exception("入职日期不能为空");
		}
		Date endDate = dao.getEndDate();
		if(BaseHelpUtils.isNullOrEmpty(endDate)){
			throw new Exception("最后工作日不能为空");
		}else{
			if(dao.getStartDate().getTime() - endDate.getTime() > 0){
				throw new Exception("入职日期必须小于等于最后工作日");
			}
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getReason())){
			throw new Exception("申请缘由不能为空");
		}
	}
}
