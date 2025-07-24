package pomplatform.workflow.personnelbusiness.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BaseMainProjectEmployee;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectEmployee;
import com.pomplatform.db.dao.PersonnelBusines;

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
import pomplatform.common.utils.StaticUtils;
import pomplatform.shift.business.OnShiftManageProcess;
import pomplatform.workflow.business.OnWrokflowProcess;

public class BusinessTripApplyWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

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
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dataValidate(dao, true);
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				dao.setIsCompleted(Boolean.TRUE);
			}
			//同步考勤
			OnShiftManageProcess.syncAttendance(bean);
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
		e = OnWrokflowProcess.setExpression(expression, e, employeeId,null,null,null);
		if(expression.contains("天数")){
			if(!BaseHelpUtils.isNullOrEmpty(bean.getDays())){
				e.setValue("天数",  bean.getDays());
			}else{
				e.setValue("天数",0.00);
			}
		}
		if (expression.contains("出差类型")) {
			if(!BaseHelpUtils.isNullOrEmpty(bean.getProjectType())){
				int intValue = BaseHelpUtils.getIntValue(bean.getProjectType());
				if (intValue == 1) {
					e.setValue("出差类型",  "项目出差");
				} else if (intValue == 2) {
					e.setValue("出差类型",  "前期项目出差");
				}

			}else{
				e.setValue("出差类型","");
			}
		}
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		Set<Integer> ownerSet = new HashSet<>();
		if (null != roleId && roleId.equals(StaticUtils.ROLE_CUSTOM_AUDITOR)) {
			return new int[]{bean.getNextAuditor()};
		}
		//合伙人审批节点-----查询所有的合伙人的角色
		else if (null != roleId && roleId.equals(StaticUtils.MANAGING_PARTNER)) {
			EmployeeRole employeeRole = new EmployeeRole();
			employeeRole.setConditionRoleId("=", StaticUtils.MANAGING_PARTNER);
			List<BaseEmployeeRole> baseEmployeeRoles = employeeRole.conditionalLoad();
			if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeRoles) && baseEmployeeRoles.size() != 0) {
				for (BaseEmployeeRole baseEmployeeRole : baseEmployeeRoles) {
					ownerSet.add(baseEmployeeRole.getEmployeeId());
				}
				if (ownerSet.size() != 0) {
					int[] arr = new int[ownerSet.size()];
					int count = 0;
					for (Integer integer : ownerSet) {
						arr[count] = integer;
						count++;
					}
					return arr;
				}
			}
			return new int[0];
		}
		//考勤管理员审批节点----只查询角色不关联部门
		else if (null != roleId && roleId.equals(StaticUtils.ROLE_ATTENDANCE_ADMINISTRATOR)) {
			EmployeeRole role = new EmployeeRole();
			role.setConditionRoleId("=", roleId);
			List<BaseEmployeeRole> list = role.conditionalLoad();
			if (BaseHelpUtils.isNullOrEmpty(list)) {
				return new int[0];
			} else {
				int i = 0;
				for (BaseEmployeeRole ee : list) {
					Integer employeeId1 = ee.getEmployeeId();
					if (employeeId1 > 0) {
						ownerSet.add(employeeId1);
					}

				}
				int[] ints = new int[ownerSet.size()];
				for (Iterator iter = ownerSet.iterator(); iter.hasNext(); ) {
					Integer str = (Integer) iter.next();
					ints[i] = str;
					i++;
				}
				return ints;
			}
		} else if (null != roleId && roleId == StaticUtils.ROLE_MAIN_PROJECT_MANAGER) {
			MainProject mainProject =new MainProject();
			mainProject.setConditionMainProjectId("=", bean.getProjectId());
			mainProject.setMainProjectId(bean.getProjectId());
			if (mainProject.load()) {
				MainProjectEmployee mainProjectEmployee =new MainProjectEmployee();
				mainProjectEmployee.setConditionMainProjectId("=", bean.getProjectId());
				mainProjectEmployee.setConditionRelation("=", 3);
				List<BaseMainProjectEmployee> baseMainProjectEmployees = mainProjectEmployee.conditionalLoad();
				if (!BaseHelpUtils.isNullOrEmpty(baseMainProjectEmployees) && baseMainProjectEmployees.size() != 0) {
					int[] arr = new int[baseMainProjectEmployees.size()];
					Set<Integer> sets = new HashSet<>();
					for (BaseMainProjectEmployee baseMainProjectEmployee : baseMainProjectEmployees) {
						if(BaseHelpUtils.getIntValue(baseMainProjectEmployee.getEmployeeId())>0) {
							sets.add(baseMainProjectEmployee.getEmployeeId());
						}
					}
					int count = 0;
					for (Integer set : sets) {
						arr[count] = set;
						count++;
					}
					return arr;
				}
			}
			throw new Exception("项目经理节点找不到审批人");
		}
		// 工作交接人
		else if (null != roleId && roleId == StaticUtils.ROLE_CUSTOM_AUDITOR) {
			Integer nextAuditor = bean.getNextAuditor();
			int[] arr = new int[1];
			arr[0] = nextAuditor;
			return arr;
			
		//项目负责人
		}else if (null != roleId && roleId == StaticUtils.ROLE_152) {
			MainProject mainProject =new MainProject();
			mainProject.setConditionMainProjectId("=", bean.getProjectId());
			mainProject.setMainProjectId(bean.getProjectId());
			if (mainProject.load()) {
				MainProjectEmployee mainProjectEmployee =new MainProjectEmployee();
				mainProjectEmployee.setConditionMainProjectId("=", bean.getProjectId());
				mainProjectEmployee.setConditionRelation("=", 5);
				List<BaseMainProjectEmployee> baseMainProjectEmployees = mainProjectEmployee.conditionalLoad();
				if (!BaseHelpUtils.isNullOrEmpty(baseMainProjectEmployees) && baseMainProjectEmployees.size() != 0) {
					int[] arr = new int[baseMainProjectEmployees.size()];
					Set<Integer> sets = new HashSet<>();
					for (BaseMainProjectEmployee baseMainProjectEmployee : baseMainProjectEmployees) {
						if(BaseHelpUtils.getIntValue(baseMainProjectEmployee.getEmployeeId())>0) {
							sets.add(baseMainProjectEmployee.getEmployeeId());
						}
					}
					int count = 0;
					for (Integer set : sets) {
						arr[count] = set;
						count++;
					}
					return arr;
				}
			}
			throw new Exception("项目负责人节点找不到审批人");
		}else
		//专业负责人节点查询申请人所在部门的专业负责人
		if (roleId != null && roleId == StaticUtils.ROLE_PROJECT_MANAGER) {
			Integer depId = bean.getDepartmentId();
			EmployeeRole employeeRole = new EmployeeRole();
			employeeRole.setConditionRoleId("=", roleId);
			employeeRole.setConditionDepartmentId("=", depId);
			List<BaseEmployeeRole> baseEmployeeRoles = employeeRole.conditionalLoad();
			if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeRoles) && baseEmployeeRoles.size() != 0) {
				int[] arr = new int[baseEmployeeRoles.size()];
				Set<Integer> sets = new HashSet<>();
				for (BaseEmployeeRole baseEmployeeRole : baseEmployeeRoles) {
					sets.add(baseEmployeeRole.getEmployeeId());
				}
				int count = 0;
				for (Integer set : sets) {
					arr[count] = set;
					count++;
				}
				return arr;
			}
			throw new SQLException("专业负责人节点找不到审批人");
		}

		else {
			return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
		}


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
		if(BaseHelpUtils.isNullOrEmpty(dao.getCompanyId())){
			throw new Exception("归属公司不能为空");
		}
		Date date = dao.getStartDate();
		Calendar calendar = Calendar.getInstance();
		if(BaseHelpUtils.isNullOrEmpty(date)){
			throw new Exception("开始日期不能为空");
		}else{
			calendar.setTime(date);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			date = calendar.getTime();
//			if(!isUpdate){
//				calendar.setTime(new Date());
//				calendar.set(Calendar.HOUR_OF_DAY, 0);
//				calendar.set(Calendar.MINUTE, 0);
//				calendar.set(Calendar.SECOND, 0);
//				calendar.set(Calendar.MILLISECOND, 0);
//				if(calendar.get(Calendar.DATE) <= 5){
//					calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
//				}
//				calendar.set(Calendar.DATE, 1);
//				Date startDate = calendar.getTime();
//				if((new Date()).getDate() <= 5){
//					calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 2);
//				}else{
//					calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
//				}
//				calendar.set(Calendar.DATE, 5);
//				Date endDate = calendar.getTime();
//				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//				if(!DateUtil.isBetween(date, startDate, endDate)){
//					throw new Exception("当前可申请的开始日期范围为：<br><font style=\"color:red\">"+format.format(startDate)+"</font>至<font style=\"color:red\">"+format.format(endDate)+"</font>");
//				}
//			}
		}
		Date endDate = dao.getEndDate();
		if(BaseHelpUtils.isNullOrEmpty(endDate)){
			throw new Exception("结束日期不能为空");
		}else{
			calendar.setTime(endDate);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			endDate = calendar.getTime();
			if(date.getTime() - endDate.getTime() > 0){
				throw new Exception("开始日期必须小于等于结束日期");
			}
		}
		if(null == dao.getDays() || dao.getDays().compareTo(BigDecimal.ZERO) <= 0){
			throw new Exception("天数必须大于0");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getAddress())){
			throw new Exception("出差地址不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getTransportation())){
			throw new Exception("交通工具不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getReason())){
			throw new Exception("申请缘由不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getPlan())){
			throw new Exception("行程安排不能为空");
		}
	}

}
