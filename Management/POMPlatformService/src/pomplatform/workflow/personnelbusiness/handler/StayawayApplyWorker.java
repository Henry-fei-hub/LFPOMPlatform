package pomplatform.workflow.personnelbusiness.handler;

import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.PersonnelBusines;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.date.util.DateUtil;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import delicacy.workflow.dao.Project;
import org.apache.log4j.Logger;
import pomplatform.common.utils.StaticUtils;
import pomplatform.role.bean.BaseGetProjectManagersByEmployeeId;
import pomplatform.role.bean.ConditionGetProjectManagersByEmployeeId;
import pomplatform.role.query.QueryGetProjectManagersByEmployeeId;
import pomplatform.shift.business.OnShiftManageProcess;
import pomplatform.workflow.business.OnWrokflowProcess;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

public class StayawayApplyWorker implements GenericWorkflowProcessor {


	protected BasePersonnelBusines bean = new BasePersonnelBusines();
	private Logger logger = Logger.getLogger(StayawayApplyWorker.class);

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dataValidate(dao, false);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
		//同步考勤
		OnShiftManageProcess.syncAttendance(bean);
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
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				bean.setIsCompleted(true);
			}
			//同步考勤
			OnShiftManageProcess.syncAttendance(bean);
		}
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		if(dao.getProjectType().equals(StaticUtils.STAY_AWAY_APPLY_TYPE_3)){
			if(null != dao.getProjectId()){
				dao.setProjectId(null);
			}
			if(null != dao.getProjectCode()){
				dao.setProjectCode(null);
			}
			if(null != dao.getProjectName()){
				dao.setProjectName(null);
			}
		}
		if(modified) {
			dataValidate(dao, true);
		}
		dao.update();
		if(modified) {
			//同步考勤
			OnShiftManageProcess.syncAttendance(bean);
		}
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		String type = "";
		if(null != bean.getProjectType()){
			if(bean.getProjectType().equals(StaticUtils.STAY_AWAY_APPLY_TYPE_1)){
				type = "项目外出";
			}else if(bean.getProjectType().equals(StaticUtils.STAY_AWAY_APPLY_TYPE_2)){
				type = "前期项目外出";
			}else{
				type = "非项目外出";
			}
		}
		e = OnWrokflowProcess.setExpression(expression, e, employeeId,null,null,null);
		e.setValue("外出类型", type);
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		if(null != roleId && roleId.equals(StaticUtils.ROLE_PROJECT_MANAGER)){
			//① 串行，返回用户自己选定的项目的专业负责人
			if(null != poolType && poolType.equals(1)){
				Project dao = new Project();
				dao.unsetSelectFlags();
				dao.setSelectProjectManageId(true);
				dao.setProjectId(bean.getProjectId());
				if(dao.load()){
					return new int[] {dao.getProjectManageId()};
				}
				return new int[0];
			}else{
				//② 并行，返回申请者所参与的所有项目的专业负责人（排除掉自己自定义选定的专业负责人）
				ConditionGetProjectManagersByEmployeeId condition = new ConditionGetProjectManagersByEmployeeId();
				condition.setEmployeeId(processCreator);
				if(!BaseHelpUtils.isNullOrZero(bean.getProjectId())){
					Project dao = new Project();
					dao.unsetSelectFlags();
					dao.setSelectProjectManageId(true);
					dao.setProjectId(bean.getProjectId());
					if(dao.load()){
						if(null != dao.getProjectManageId()){
							condition.setExcluder(dao.getProjectManageId());
						}
					}
				}
				QueryGetProjectManagersByEmployeeId query = new QueryGetProjectManagersByEmployeeId();
				BaseCollection<BaseGetProjectManagersByEmployeeId> bc = query.executeQuery(null, condition);
				if(null != bc && null != bc.getCollections()){
					List<BaseGetProjectManagersByEmployeeId> list = bc.getCollections();
					int size = list.size();
					int[] arr = new int[size];
					for(int i = 0; i < size; i++){
						arr[i] = list.get(i).getProjectManageId();
					}
					return arr;
				}
			}
		}
		if(null != roleId && roleId.equals(StaticUtils.ROLE_CUSTOM_AUDITOR)){
			if(null != bean.getNextAuditor()){
				return new int[] {bean.getNextAuditor()};
			}else{
				return new int[0];
			}
		}
		//考勤管理专员做特殊处理 产讯所有的考勤专员 不区分部门
		if(null != roleId && roleId.equals(StaticUtils.ROLE_ATTENDANCE_ADMINISTRATOR)){
			Set<Integer> ownerSet = new HashSet<>();
			EmployeeRole employeeRole = new EmployeeRole();
			employeeRole.setConditionRoleId("=", 16);
			List<BaseEmployeeRole> baseEmployeeRoles = employeeRole.conditionalLoad();
			if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeRoles)) {
				int size = baseEmployeeRoles.size();

				int i = 0;
				for (BaseEmployeeRole role : baseEmployeeRoles) {
					Integer employeeId1 = role.getEmployeeId();
					if(employeeId1>0){
						ownerSet.add(employeeId1);
					}
				}
				int[] ints = new int[ownerSet.size()];
				for (Iterator iter = ownerSet.iterator(); iter.hasNext();) {
					Integer str = (Integer)iter.next();
					ints[i] = str;
					i++;
				}
				return ints;
			} else {
				return new int[0];
			}
		}
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}
	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		return dao.generateBase().toJSON();
	}

	private void dataValidate(PersonnelBusines dao, boolean isUpdate) throws Exception{
		if(BaseHelpUtils.isNullOrZero(dao.getProcessType())){
			throw new Exception("流程类型错误");
		}
		if(BaseHelpUtils.isNullOrZero(dao.getEmployeeId())){
			throw new Exception("申请人不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getEmployeeNo())){
			throw new Exception("工号不能为空");
		}
		if(BaseHelpUtils.isNullOrZero(dao.getDepartmentId())){
			throw new Exception("部门不能为空");
		}
		Date date = dao.getStartDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		date = calendar.getTime();
		if(BaseHelpUtils.isNullOrEmpty(date)){
			throw new Exception("外出日期不能为空");
		}else if(!isUpdate){
//			calendar.setTime(new Date());
//			calendar.set(Calendar.HOUR_OF_DAY, 0);
//			calendar.set(Calendar.MINUTE, 0);
//			calendar.set(Calendar.SECOND, 0);
//			calendar.set(Calendar.MILLISECOND, 0);
//			if(calendar.get(Calendar.DATE) <= 5){
//				calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
//			}
//			calendar.set(Calendar.DATE, 1);
//			Date startDate = calendar.getTime();
//			if((new Date()).getDate() <= 5){
//				calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 2);
//			}else{
//				calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
//			}
//			calendar.set(Calendar.DATE, 5);
//			Date endDate = calendar.getTime();
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			if(!DateUtil.isBetween(date, startDate, endDate)){
//				throw new Exception("当前可申请的外出日期范围为：<br><font style=\"color:red\">"+format.format(startDate)+"</font>至<font style=\"color:red\">"+format.format(endDate)+"</font>");
//			}
		}
		//验证外出开始日期不能早于当前日期，即外出只能当天或者提前申请，而不能延后申请
		int days = DateUtil.generateDaysBetween(DateUtil.getDateOfDay(new Date()), DateUtil.getDateOfDay(date));
		logger.info("---------------------------------- now date："+DateUtil.getDateOfDay(new Date()));
		logger.info("---------------------------------- start date："+DateUtil.getDateOfDay(date));
		logger.info("---------------------------------- days："+days);
		if(days > 1){//说明当前日期晚于外出开始日期，即延后申请
			throw new Exception("外出日期不可延后申请，即外出开始日期不可早于昨日日期");
		}
		Date endDate = dao.getEndDate();
		if(BaseHelpUtils.isNullOrEmpty(endDate)){
			throw new Exception("预期返回日期不能为空");
		}else{
			calendar.setTime(endDate);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			endDate = calendar.getTime();
			if(date.getTime() - endDate.getTime() > 0){
				throw new Exception("外出日期必须小于等于预期返回日期");
			}
		}
		if(null == dao.getDays() || dao.getDays().compareTo(BigDecimal.ZERO) <= 0){
			throw new Exception("外出天数必须大于0");
		}
		if(null == dao.getProjectType()){
			throw new Exception("请选择外出类型");
		}
		if(dao.getProjectType().equals(StaticUtils.STAY_AWAY_APPLY_TYPE_1) || dao.getProjectType().equals(StaticUtils.STAY_AWAY_APPLY_TYPE_2)){
			if(null == dao.getProjectId() || null == dao.getProjectCode() || null == dao.getProjectName()){
				throw new Exception("请选择外出项目");
			}
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getReason())){
			throw new Exception("申请缘由不能为空");
		}
	}
}
