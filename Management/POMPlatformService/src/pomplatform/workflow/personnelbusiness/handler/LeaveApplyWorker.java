package pomplatform.workflow.personnelbusiness.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import delicacy.date.util.DateUtil;
import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAnnualLeave;
import com.pomplatform.db.bean.BaseCompensatoryLeave;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseEmployeeMonthCheck;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseMainProjectEmployee;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.dao.AnnualLeave;
import com.pomplatform.db.dao.CompensatoryLeave;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.Employee;
import com.pomplatform.db.dao.EmployeeMonthCheck;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectEmployee;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectEmployee;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.CommonUtils;
import pomplatform.common.utils.StaticUtils;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.shift.business.OnShiftManageProcess;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.personnelbusiness.bean.BaseUsedVacationLeave;
import pomplatform.workflow.personnelbusiness.bean.ConditionUsedVacationLeave;
import pomplatform.workflow.personnelbusiness.query.QueryUsedVacationLeave;

public class LeaveApplyWorker implements GenericWorkflowProcessor {

	private Logger logger = Logger.getLogger(LeaveApplyWorker.class);

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dataValidate(dao, false);
		/***************************年假做特殊的处理**********************************/
		int type = BaseHelpUtils.getIntValue(bean.getType());
		if (type == StaticUtils.LEAVE_TYPE_22) {
			updateAnnualLeave();
		}

		/*************************年假处理完毕***************************************/

		dao.save();
		/*** ***********************调休做特殊处理*****************************************/
		if (type == StaticUtils.LEAVE_TYPE_21){
			updateCompensatoryLeave(dao);
		}
		/*************************调休处理完毕***************************************/

		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
		//增加附件的引用次数
		FileManageProcessor.addTimesById(bean.getAttachmentId());
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
			//流程驳回对年假做特殊处理
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {
				int type = BaseHelpUtils.getIntValue(bean.getType());
				if (type == StaticUtils.LEAVE_TYPE_22) {
					logger.info("---------------------------------- 进入驳回方法");
					deleteAnnualLeave(bean);
				}
				if(type ==StaticUtils.LEAVE_TYPE_21){
					Integer personnelBusinessId = bean.getPersonnelBusinessId();
					CompensatoryLeave cl = new CompensatoryLeave();
					cl.setConditionBusinessId("=",personnelBusinessId);
					List<BaseCompensatoryLeave> list = cl.conditionalLoad();
					if(!BaseHelpUtils.isNullOrEmpty(list)){
						for (BaseCompensatoryLeave b:list){
							b.setStatus(2);
							cl.clear();
							cl.setDataFromBase(b);
							cl.update();
						}
					}
				}
			}
			//同步考勤
			OnShiftManageProcess.syncAttendance(bean);
		}
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		if(modified) {
			dataValidate(dao, true);
		}
		ColumnChangedData attachmentIdData = dao.getColumnChangedData(BasePersonnelBusines.CS_ATTACHMENT_ID);
		//修改附件的引用次数
		FileManageProcessor.upadteTimesByColumnChangedData(attachmentIdData);
		/***************************年假做特殊的处理**********************************/
		if (modified) {
			int type = BaseHelpUtils.getIntValue(bean.getType());
			if (type == StaticUtils.LEAVE_TYPE_22) {
				//查询原来的数据
				Integer personnelBusinessId = bean.getPersonnelBusinessId();
				PersonnelBusines personnelBusines = new PersonnelBusines();
				personnelBusines.setPersonnelBusinessId(personnelBusinessId);
				if (personnelBusines.load()) {
					BasePersonnelBusines oldBean = personnelBusines.generateBase();
					deleteAnnualLeave(oldBean);
					updateAnnualLeave();
				}
			}
			if(type ==StaticUtils.LEAVE_TYPE_21){
				updateCompensatoryLeave(dao);
			}
		}
		/*************************年假处理完毕***************************************/
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
		e.setValue("天数", bean.getDays() == null? 0.0 : bean.getDays().doubleValue());
		if(expression.contains("请假类型")){
			e.setValue("请假类型", CommonUtils.getLeaveType(bean.getType()));
		}
		//根据姓名匹配节点
		if (expression.contains("姓名")) {
			Employee employee = new Employee();
			employee.setEmployeeId(bean.getEmployeeId());
			if (employee.load()) {
				String employeeName = employee.getEmployeeName();
				e.setValue("姓名", employeeName);
			}
		}
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		System.out.println("roleId======"+roleId);

		//考勤管理员审批
		if (!BaseHelpUtils.isNullOrEmpty(roleId) && roleId == StaticUtils.ROLE_ATTENDANCE_ADMINISTRATOR) {
			System.out.println("考勤管理员======");
			//找寻所有的考勤管理员
			EmployeeRole employeeRole = new EmployeeRole();
			employeeRole.setConditionRoleId("=", StaticUtils.ROLE_ATTENDANCE_ADMINISTRATOR);
			List<BaseEmployeeRole> baseEmployeeRoles = employeeRole.conditionalLoad();
			if (BaseHelpUtils.isNullOrEmpty(baseEmployeeRoles) || baseEmployeeRoles.size() == 0) {
				throw new Exception("考勤管理员节点找不到审批人");
			}
			int[] arr = new int[baseEmployeeRoles.size()];
			int i = 0;
			for (BaseEmployeeRole baseEmployeeRole : baseEmployeeRoles) {
				Integer empId = baseEmployeeRole.getEmployeeId();
				arr[i] = empId;
				i++;
			}
			return arr;
		}
		//项目经理审批---查询申请人所在的项目的所有的项目经理 / 项目负责人审批节点----查询申请人所在的部门的所有的项目负责人
		if (!BaseHelpUtils.isNullOrEmpty(roleId) && ((roleId == StaticUtils.ROLE_MAIN_PROJECT_MANAGER) || roleId == (StaticUtils.ROLE_152))) {
			System.out.println("项目经理审批======");
			ProjectEmployee projectEmployee = new ProjectEmployee();
			projectEmployee.setConditionEmployeeId("=", bean.getEmployeeId());
			projectEmployee.setConditionFlag("=", 2);
			List<BaseProjectEmployee> baseProjectEmployees = projectEmployee.conditionalLoad();
			Set<Integer> mainProjectManagerIds = new HashSet<>();
			Set<Integer> contractIds = new HashSet<>();
			if (!BaseHelpUtils.isNullOrEmpty(baseProjectEmployees) && baseProjectEmployees.size() != 0) {
				Contract contract = new Contract();
				Project project = new Project();
				MainProject mainProject = new MainProject();
				MainProjectEmployee mainProjectEmployee = new MainProjectEmployee();
				for (BaseProjectEmployee baseProjectEmployee : baseProjectEmployees) {
					Integer projectId = baseProjectEmployee.getProjectId();
					project.clear();
					project.setProjectId(projectId);
					if (project.load()) {
						BaseProject baseProject = project.generateBase();
						int contractId = BaseHelpUtils.getIntValue(baseProject.getContractId());
						contractIds.add(contractId);
					}
				}
				for (Integer contractId : contractIds) {
					contract.clear();
					contract.setContractId(contractId);
					if (contract.load()) {
						BaseContract baseContract = contract.generateBase();
						String projectCode = baseContract.getProjectCode();
						mainProject.clear();
						mainProject.setConditionProjectCode("=", projectCode);
						BaseMainProject baseMainProject1 = mainProject.executeQueryOneRow();
						if (null != baseMainProject1) {
							Integer mainProjectId = baseMainProject1.getMainProjectId();
							mainProjectEmployee.clear();
							mainProjectEmployee.setConditionMainProjectId("=", mainProjectId);
							//项目经理
							if (roleId.equals(StaticUtils.ROLE_MAIN_PROJECT_MANAGER)) {
								mainProjectEmployee.setConditionRelation("=", 3);
							}//项目负责人
							else {
								mainProjectEmployee.setConditionRelation("=", 5);
							}
							List<BaseMainProjectEmployee> baseMainProjectEmployees = mainProjectEmployee.conditionalLoad();
							if (!BaseHelpUtils.isNullOrEmpty(baseMainProjectEmployees) && baseMainProjectEmployees.size() != 0) {
								for (BaseMainProjectEmployee baseMainProjectEmployee : baseMainProjectEmployees) {
									mainProjectManagerIds.add(baseMainProjectEmployee.getEmployeeId());
								}
							}
						}
					}
				}
				int count = 0;
				if (mainProjectManagerIds.size() != 0) {
					int[] arr = new int[mainProjectManagerIds.size()];
					for (Integer mainProjectManagerId : mainProjectManagerIds) {
						arr[count] = mainProjectManagerId;
						count++;
					}
					return arr;
				} else {
					return new int[0];
				}

			} else {
				if (roleId.equals(StaticUtils.ROLE_MAIN_PROJECT_MANAGER)) {
					return new int[0];
				} else {
					return new int[0];
				}
			}
		}

		//合伙人审批节点----- 查询所有的合伙人
		if (!BaseHelpUtils.isNullOrEmpty(roleId) && roleId == StaticUtils.MANAGING_PARTNER) {
			System.out.println("合伙人审批节点----- 查询所有的合伙人");
			EmployeeRole employeeRole = new EmployeeRole();
			employeeRole.setConditionRoleId("=", StaticUtils.MANAGING_PARTNER);
			List<BaseEmployeeRole> baseEmployeeRoles = employeeRole.conditionalLoad();
			if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeRoles) && baseEmployeeRoles.size() != 0) {
				Set<Integer> partnerIds = new HashSet<>();
				for (BaseEmployeeRole baseEmployeeRole : baseEmployeeRoles) {
					Integer empID = baseEmployeeRole.getEmployeeId();
					partnerIds.add(empID);
				}
				int[] arr = new int[partnerIds.size()];
				int count = 0;
				for (Integer partnerId : partnerIds) {
					arr[count] = partnerId;
					count++;
				}
				return arr;
			} else {
				return new int[0];
			}
		}

		//运营董事审批节点----- 查询所有的运营董事
		if (!BaseHelpUtils.isNullOrEmpty(roleId) && roleId == StaticUtils.OPERATE_DIRECTOR) {
			System.out.println("运营董事审批节点----- 查询所有的运营董事");
			EmployeeRole employeeRole = new EmployeeRole();
			employeeRole.setConditionRoleId("=", StaticUtils.OPERATE_DIRECTOR);
			List<BaseEmployeeRole> baseEmployeeRoles = employeeRole.conditionalLoad();
			if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeRoles) && baseEmployeeRoles.size() != 0) {
				Set<Integer> partnerIds = new HashSet<>();
				for (BaseEmployeeRole baseEmployeeRole : baseEmployeeRoles) {
					Integer empID = baseEmployeeRole.getEmployeeId();
					partnerIds.add(empID);
				}
				int[] arr = new int[partnerIds.size()];
				int count = 0;
				for (Integer partnerId : partnerIds) {
					arr[count] = partnerId;
					count++;
				}
				return arr;
			} else {
				return new int[0];
			}
		}

		//自定义审核人角色，查询的是请假的交接人
		if (!BaseHelpUtils.isNullOrEmpty(roleId) && roleId == StaticUtils.ROLE_CUSTOM_AUDITOR) {
			System.out.println("自定义审核人角色，查询的是请假的交接人");
			//获取选择的请假交接人
			Integer nextAuditor = bean.getNextAuditor();
			if (!BaseHelpUtils.isNullOrEmpty(nextAuditor)) {
				int[] ints = new int[1];
				ints[0] = nextAuditor;
				return ints;
			} else {
				return new int[0];
			}
		}
		//合伙人（职能）
		/*if (!BaseHelpUtils.isNullOrEmpty(roleId) && roleId == StaticUtils.MANAGING_PARTNER_160) {
			EmployeeRole employeeRole = new EmployeeRole();
			employeeRole.setConditionRoleId("=", StaticUtils.MANAGING_PARTNER_160);
			List<BaseEmployeeRole> baseEmployeeRoles = employeeRole.conditionalLoad();
			if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeRoles) && baseEmployeeRoles.size() != 0) {
				Set<Integer> partnerIds = new HashSet<>();
				for (BaseEmployeeRole baseEmployeeRole : baseEmployeeRoles) {
					Integer empID = baseEmployeeRole.getEmployeeId();
					partnerIds.add(empID);
				}
				int[] arr = new int[partnerIds.size()];
				int count = 0;
				for (Integer partnerId : partnerIds) {
					arr[count] = partnerId;
					count++;
				}
				return arr;
			} else {
				throw new Exception("合伙人(职能)节点找不到审批人");
			}
		}*/
		//专业负责人节点查询申请人所在部门的专业负责人
		if (!BaseHelpUtils.isNullOrEmpty(roleId) && roleId == StaticUtils.ROLE_PROJECT_MANAGER) {
			System.out.println("专业负责人节点查询申请人所在部门的专业负责人");
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
			return new int[0];
		}
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		dao.setAttachment(FileManageProcessor.getFileUrlById(dao.getAttachmentId()));
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
//		Calendar calendar = Calendar.getInstance();
		if(BaseHelpUtils.isNullOrEmpty(date)){
			throw new Exception("开始日期不能为空");
		}else{
//			calendar.setTime(date);
//			calendar.set(Calendar.HOUR_OF_DAY, 0);
//			calendar.set(Calendar.MINUTE, 0);
//			calendar.set(Calendar.SECOND, 0);
//			calendar.set(Calendar.MILLISECOND, 0);
//			date = calendar.getTime();
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
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			if(date.getTime() - startDate.getTime() < 0){
//				throw new Exception("当前可申请的开始日期最小值为：<br><font style=\"color:red\">"+format.format(startDate)+"</font>");
//			}
		}
		//请假类型
		int type = BaseHelpUtils.getIntValue(dao.getType());
		//验证请假开始日期不能早于当前日期，即请假只能当天或者提前申请，而不能延后申请
		int days = DateUtil.generateDaysBetween(DateUtil.getDateOfDay(new Date()), DateUtil.getDateOfDay(date));
		logger.info("---------------------------------- now date："+DateUtil.getDateOfDay(new Date()));
		logger.info("---------------------------------- start date："+DateUtil.getDateOfDay(date));
		logger.info("---------------------------------- days："+days);
		//除年假和事假可以不限日期，其他假类，可以只能延后一天申请，即今天可以申请昨天的数据
		if(days > 1 && type != 22 && type != 19){
			throw new Exception("请假日期不可延后申请，即请假开始日期不可早于昨日日期");
		}
		Date endDate = dao.getEndDate();
		if(BaseHelpUtils.isNullOrEmpty(endDate)){
			throw new Exception("结束日期不能为空");
		}else{
			if(dao.getStartDate().getTime() - endDate.getTime() > 0){
				throw new Exception("开始日期必须小于等于结束日期");
			}
		}
		if(!BaseHelpUtils.isNullOrEmpty(dao.getType())){
			if(type==9){
				if(BaseHelpUtils.isNullOrEmpty(dao.getUnit())){
					throw new Exception("丧假缘由不能为空");
				}
			}else {
				//调休不需要验证该字段
				if(type!=21 && BaseHelpUtils.isNullOrEmpty(dao.getReason())){
					throw new Exception("申请缘由不能为空");
				}
			}
		}

	}


	/**
	 *
	 */

	private static void updateCompensatoryLeave(PersonnelBusines dao) throws Exception{
		Date startDate = dao.getStartDate();
		Date endDate = dao.getEndDate();
		int	employeeId = dao.getEmployeeId();
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		if (!employee.load()) {
			return;
//			throw new Exception("数据异常: 没有查询到员工的数据");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		//获取请假开始时间的年份和月份
		int startDateYear = calendar.get(Calendar.YEAR);
		int startDateMonth = calendar.get(Calendar.MONTH) + 1;
		//获取请假结束时间的年份和月份
		calendar.clear();
		calendar.setTime(endDate);
		int endDateYear = calendar.get(Calendar.YEAR);
		int endDateMonth = calendar.get(Calendar.MONTH) + 1;
		if (startDateYear != endDateYear && startDateMonth != endDateMonth) {
			throw new Exception( "调休假时间必须在同一个月内");
		}
		int plateId = BaseHelpUtils.getIntValue(employee.getPlateId());
		if (plateId == 0) {
			throw new Exception( "请假员工没有归属的业务部门!");
		}
		//员工加班的总时长
		BigDecimal overtimeHours = BigDecimal.ZERO;
		//员工的使用的调休假的时间
		BigDecimal userEd = BigDecimal.ZERO;
		//查询员工的加班时长
		EmployeeMonthCheck employeeMonthCheck = new EmployeeMonthCheck();
		List<BaseEmployeeMonthCheck> baseEmployeeMonthChecks = new ArrayList<>();
		//查询员工的使用的调休假的时长
		QueryUsedVacationLeave queryUsedVacationLeave = new QueryUsedVacationLeave();
		ConditionUsedVacationLeave conditionUsedVacationLeave = new ConditionUsedVacationLeave();
		//获取请假的天数
		BigDecimal days = BaseHelpUtils.getBigDecimalValue(dao.getDays());
		//获取请假小时数
		BigDecimal hours = BaseHelpUtils.getBigDecimalValue(dao.getHours());
		//如果部门是人力资源部，行政部，财务部,加班时间是不清空的
//            if (plateId == 57 || plateId == 56 || plateId == 58) {
		if (plateId == -999) {
			employeeMonthCheck.clear();
			//查询员工所有的加班时长
			employeeMonthCheck.setConditionEmployeeId("=", employeeId);
			baseEmployeeMonthChecks = employeeMonthCheck.conditionalLoad();
			//查询员工所有的申请的调休假的时间
			conditionUsedVacationLeave.setEmployeeId(employeeId);
			BaseCollection<BaseUsedVacationLeave> baseUsedVacationLeaveBaseCollection = queryUsedVacationLeave.executeQuery(null, conditionUsedVacationLeave);
			if (!BaseHelpUtils.isNullOrEmpty(baseUsedVacationLeaveBaseCollection) && baseUsedVacationLeaveBaseCollection.getCollections().size() != 0) {
				List<BaseUsedVacationLeave> collections = baseUsedVacationLeaveBaseCollection.getCollections();
				for (BaseUsedVacationLeave baseUsedVacationLeave : collections) {
					BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(baseUsedVacationLeave.getUsed());
					userEd = userEd.add(bigDecimalValue);
				}

			}
			if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecks) && baseEmployeeMonthChecks.size() != 0) {
				for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecks) {
					//平时加班时长
					BigDecimal nornalOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getNornalOvertimeHours());
					//周末加班时长
					BigDecimal weekendOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getWeekendOvertimeHours());
					//节假日加班时长
					BigDecimal holidayOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getHolidayOvertimeHours());
					//计算总的加班的时长
					overtimeHours = overtimeHours.add(nornalOvertimeHours.add(weekendOvertimeHours).add(holidayOvertimeHours));
				}
			}
			if(overtimeHours.compareTo(userEd)<0){
				throw new Exception( "加班时长不足以抵扣本次申请时长");
			}
		}else{

			CompensatoryLeave cl = new CompensatoryLeave();
			cl.setConditionBusinessId("=",dao.getPersonnelBusinessId());
			List<BaseCompensatoryLeave> list = cl.conditionalLoad();
			//查询员工的使用的调休假的时长
			List<BaseCompensatoryLeave> baseCompensatoryLeaves = new ArrayList<>();
			baseEmployeeMonthChecks = new ArrayList<>();
			if (startDateMonth == 1) {
				employeeMonthCheck.clear();
				employeeMonthCheck.setConditionYear("=", startDateYear - 1);
				employeeMonthCheck.setConditionEmployeeId("=", employeeId);
				employeeMonthCheck.setConditionMonth("=", 12);
				List<BaseEmployeeMonthCheck> baseEmployeeMonthChecksTemp1 = employeeMonthCheck.conditionalLoad();
				if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecksTemp1) && baseEmployeeMonthChecksTemp1.size() != 0) {
					for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecksTemp1) {
						baseEmployeeMonthChecks.add(baseEmployeeMonthCheck);
					}
				}
				employeeMonthCheck.clear();
				employeeMonthCheck.setConditionYear("=", startDateYear);
				employeeMonthCheck.setConditionEmployeeId("=", employeeId);
				employeeMonthCheck.setConditionMonth("=", 1);
				List<BaseEmployeeMonthCheck> baseEmployeeMonthChecksTemp2 = employeeMonthCheck.conditionalLoad();
				if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecksTemp2) && baseEmployeeMonthChecksTemp2.size() != 0) {
					for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecksTemp2) {
						baseEmployeeMonthChecks.add(baseEmployeeMonthCheck);
					}
				}
			} else {
				employeeMonthCheck.setConditionYear("=", startDateYear);
				employeeMonthCheck.setConditionEmployeeId("=", employeeId);
				String month = startDateMonth + "," + (startDateMonth - 1);
				baseEmployeeMonthChecks = employeeMonthCheck.conditionalLoad("month in (" + month + ")");
			}

			//查询员工请假时间相近的两个月的使用的加班的时长
			if (startDateMonth == 1) {
				cl.clear();
				cl.setConditionEmployeeId("=",employeeId);
				cl.setConditionYear("=",startDateYear - 1);
				cl.setConditionMonth("=",12);
				cl.setConditionStatus("=",1);
				List<BaseCompensatoryLeave> listTow = cl.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(listTow)){
					for (BaseCompensatoryLeave b:listTow){
						baseCompensatoryLeaves.add(b);
					}
				}
				cl.clear();
				cl.setConditionEmployeeId("=",employeeId);
				cl.setConditionYear("=",startDateYear);
				cl.setConditionMonth("=",startDateMonth);
				cl.setConditionStatus("=",1);
				List<BaseCompensatoryLeave> baseList = cl.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(baseList)){
					for (BaseCompensatoryLeave b:baseList){
						baseCompensatoryLeaves.add(b);
					}
				}

			}else{
				cl.clear();
				cl.setConditionEmployeeId("=",employeeId);
				cl.setConditionYear("=",startDateYear);
				cl.setConditionMonth("=",startDateMonth);
				cl.setConditionStatus("=",1);
				List<BaseCompensatoryLeave> baseList = cl.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(baseList)){
					for (BaseCompensatoryLeave b:baseList){
						baseCompensatoryLeaves.add(b);
					}
				}

				cl.clear();
				cl.setConditionEmployeeId("=",employeeId);
				cl.setConditionYear("=",startDateYear);
				cl.setConditionMonth("=",startDateMonth-1);
				cl.setConditionStatus("=",1);
				List<BaseCompensatoryLeave> listTow = cl.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(listTow)){
					for (BaseCompensatoryLeave b:listTow){
						baseCompensatoryLeaves.add(b);
					}
				}
			}
			userEd=BigDecimal.ZERO;
			if (!BaseHelpUtils.isNullOrEmpty(baseCompensatoryLeaves) && baseCompensatoryLeaves.size() != 0) {
				for (BaseCompensatoryLeave baseUsedVacationLeave : baseCompensatoryLeaves) {
					BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(baseUsedVacationLeave.getTotalCompensatoryLeave());
					userEd = userEd.add(bigDecimalValue);
				}
			}
			if(days.compareTo(BigDecimal.ZERO)>0){
				userEd = userEd.add(days.multiply(new BigDecimal("7")));
			}
			if(hours.compareTo(BigDecimal.ZERO)>0){
				userEd = userEd.add(hours);
			}

			if (userEd.compareTo(new BigDecimal("3.5")) == -1) {
				calendar.setTime(startDate);
				int hour = calendar.get(Calendar.HOUR_OF_DAY);
				int  minute = calendar.get(Calendar.MINUTE);
				if(hour>9 ){
					throw new Exception( "调休假少于3.5小时,请从9点开始");
				}else if (hour==9 && minute>0){
					throw new Exception( "调休假少于3.5小时,请从9点开始");
				}
			}

			//如果是流程发起
			if(BaseHelpUtils.isNullOrEmpty(list)){
				overtimeHours = BigDecimal.ZERO;
				if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecks) && baseEmployeeMonthChecks.size() != 0) {
					for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecks) {
						//平时加班时长
						BigDecimal nornalOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getNornalOvertimeHours());
						//周末加班时长
						BigDecimal weekendOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getWeekendOvertimeHours());
						//节假日加班时长
						BigDecimal holidayOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getHolidayOvertimeHours());
						//计算总的加班的时长
						overtimeHours = overtimeHours.add(nornalOvertimeHours.add(weekendOvertimeHours).add(holidayOvertimeHours));
					}
				}
				//剩余的调休的时长
				BigDecimal remainingTime = overtimeHours.subtract(userEd);
				if(remainingTime.compareTo(BigDecimal.ZERO)<0){
					throw new Exception( "加班时长不足以抵扣本次申请时长");
				}else{
					employeeMonthCheck.clear();
					if(startDateMonth==1){
						employeeMonthCheck.setConditionYear("=", startDateYear-1);
						employeeMonthCheck.setConditionMonth("=",12);
					}else{
						employeeMonthCheck.setConditionYear("=", startDateYear);
						employeeMonthCheck.setConditionMonth("=",startDateMonth - 1);
					}
					employeeMonthCheck.setConditionEmployeeId("=", employeeId);
					baseEmployeeMonthChecks = new ArrayList<>();
					baseEmployeeMonthChecks = employeeMonthCheck.conditionalLoad();
					overtimeHours = BigDecimal.ZERO;
					userEd = BigDecimal.ZERO;
					if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecks) && baseEmployeeMonthChecks.size() != 0) {
						for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecks) {
							//平时加班时长
							BigDecimal nornalOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getNornalOvertimeHours());
							//周末加班时长
							BigDecimal weekendOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getWeekendOvertimeHours());
							//节假日加班时长
							BigDecimal holidayOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getHolidayOvertimeHours());
							//计算总的加班的时长
							overtimeHours = overtimeHours.add(nornalOvertimeHours.add(weekendOvertimeHours).add(holidayOvertimeHours));
						}
					}
					cl.clear();
					cl.setConditionEmployeeId("=",employeeId);
					if(startDateMonth==1){
						cl.setConditionYear("=",startDateYear-1);
						cl.setConditionMonth("=",12);
					}else{
						cl.setConditionYear("=",startDateYear);
						cl.setConditionMonth("=",startDateMonth-1);
					}
					cl.setConditionStatus("=",1);
					baseCompensatoryLeaves = new ArrayList<>();
					List<BaseCompensatoryLeave> listTow = cl.conditionalLoad();
					if(!BaseHelpUtils.isNullOrEmpty(listTow)){
						for (BaseCompensatoryLeave b:listTow){
							baseCompensatoryLeaves.add(b);
						}
					}
					if (!BaseHelpUtils.isNullOrEmpty(baseCompensatoryLeaves) && baseCompensatoryLeaves.size() != 0) {
						for (BaseCompensatoryLeave baseUsedVacationLeave : baseCompensatoryLeaves) {
							BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(baseUsedVacationLeave.getTotalCompensatoryLeave());
							userEd = userEd.add(bigDecimalValue);
						}
					}
					BigDecimal userE = userEd;
					if(days.compareTo(BigDecimal.ZERO)>0){
						userEd = userEd.add(days.multiply(new BigDecimal("7")));
					}
					if(hours.compareTo(BigDecimal.ZERO)>0){
						userEd = userEd.add(hours);
					}

					BigDecimal subtract = overtimeHours.subtract(userEd);
					//如果上个月分的足够抵扣本次申请
					if(subtract.compareTo(BigDecimal.ZERO)>=0){
						userEd = BigDecimal.ZERO;
						if(days.compareTo(BigDecimal.ZERO)>0){
							userEd = userEd.add(days.multiply(new BigDecimal("7")));
						}
						if(hours.compareTo(BigDecimal.ZERO)>0){
							userEd = userEd.add(hours);
						}
						cl.clear();
						cl.setBusinessId(dao.getPersonnelBusinessId());
						cl.setStatus(1);
						if(startDateMonth==1){
							cl.setYear(startDateYear-1);
							cl.setMonth(12);
						}else{
							cl.setYear(startDateYear);
							cl.setMonth(startDateMonth-1);
						}

						cl.setEmployeeId(employeeId);
						cl.setTotalCompensatoryLeave(userEd);
						cl.save();
					}
					//如果不足够则需要扣除当前月
					else{
						cl.clear();
						cl.setBusinessId(dao.getPersonnelBusinessId());
						cl.setStatus(1);
						if(startDateMonth==1){
							cl.setYear(startDateYear-1);
							cl.setMonth(12);
						}else{
							cl.setYear(startDateYear);
							cl.setMonth(startDateMonth-1);
						}
						cl.setEmployeeId(employeeId);
						cl.setTotalCompensatoryLeave(overtimeHours.subtract(userE));
						cl.save();
						cl.clear();
						cl.setBusinessId(dao.getPersonnelBusinessId());
						cl.setStatus(1);
						cl.setYear(startDateYear);
						cl.setMonth(startDateMonth);
						cl.setEmployeeId(employeeId);
						cl.setTotalCompensatoryLeave(userEd.subtract(overtimeHours));
						cl.save();
					}
				}
			}else{
				//减去修改前的调休时间
				userEd=BigDecimal.ZERO;
				if(days.compareTo(BigDecimal.ZERO)>0){
					userEd = userEd.add(days.multiply(new BigDecimal("7")));
				}
				if(hours.compareTo(BigDecimal.ZERO)>0){
					userEd = userEd.add(hours);
				}

				for (BaseCompensatoryLeave b:list){
					userEd=userEd.subtract(b.getTotalCompensatoryLeave());
				}
				System.out.println("shij    ===== "+userEd);
				//如果是减少
				if(userEd.compareTo(BigDecimal.ZERO)<0){
					cl.clear();
					cl.setConditionBusinessId("=",dao.getPersonnelBusinessId());
					cl.setConditionStatus("=",1);
					cl.setConditionYear("=",startDateYear);
					cl.setConditionMonth("=",startDateMonth);
					cl.setConditionEmployeeId("=",employeeId);
					BaseCompensatoryLeave base = cl.executeQueryOneRow();
					//如果没有扣除到本月,则直接扣减上月份
					if(BaseHelpUtils.isNullOrEmpty(base)){
						cl.clear();
						cl.setConditionBusinessId("=",dao.getPersonnelBusinessId());
						cl.setConditionStatus("=",1);
						if(startDateMonth==1){
							cl.setConditionYear("=",startDateYear-1);
							cl.setConditionMonth("=",12);
						}else{
							cl.setConditionYear("=",startDateYear);
							cl.setConditionMonth("=",startDateMonth-1);
						}
						cl.setConditionEmployeeId("=",employeeId);
						BaseCompensatoryLeave bases = cl.executeQueryOneRow();
						if(BaseHelpUtils.isNullOrEmpty(bases)){
							return;
//							throw new Exception( "数据异常!!");
						}else{
							bases.setTotalCompensatoryLeave(bases.getTotalCompensatoryLeave().add(userEd));
							cl.clear();
							cl.setDataFromBase(bases);
							cl.update();
						}
					}else{
						if(userEd.add(base.getTotalCompensatoryLeave()).compareTo(BigDecimal.ZERO)>0){
							base.setTotalCompensatoryLeave(base.getTotalCompensatoryLeave().add(userEd));
							cl.clear();
							cl.setDataFromBase(base);
							cl.update();
						}else if(userEd.add(base.getTotalCompensatoryLeave()).compareTo(BigDecimal.ZERO)==0){
							cl.clear();
							cl.setDataFromBase(base);
							cl.delete();
						}else{
							BigDecimal totalCompensatoryLeave = base.getTotalCompensatoryLeave();
							cl.clear();
							cl.setDataFromBase(base);
							cl.delete();
							cl.clear();
							cl.setConditionBusinessId("=",dao.getPersonnelBusinessId());
							cl.setConditionStatus("=",1);
							if(startDateMonth==1){
								cl.setConditionYear("=",startDateYear-1);
								cl.setConditionMonth("=",12);
							}else{
								cl.setConditionYear("=",startDateYear);
								cl.setConditionMonth("=",startDateMonth-1);
							}
							cl.setConditionEmployeeId("=",employeeId);
							BaseCompensatoryLeave bases = cl.executeQueryOneRow();
							if(BaseHelpUtils.isNullOrEmpty(bases)){
								return;
//								throw new Exception( "数据异常!!");
							}else{
								bases.setTotalCompensatoryLeave(bases.getTotalCompensatoryLeave().add(userEd).subtract(totalCompensatoryLeave));
								cl.clear();
								cl.setDataFromBase(bases);
								cl.update();
							}
						}
					}
					//如果是增多
				}else if(userEd.compareTo(BigDecimal.ZERO)>0){
					BigDecimal userEdd = userEd;
					cl.clear();
					cl.setConditionEmployeeId("=",employeeId);
					cl.setConditionYear("=",startDateYear);
					cl.setConditionMonth("=",startDateMonth);
					cl.setConditionStatus("=",1);
					cl.setConditionBusinessId("=",dao.getPersonnelBusinessId());
					BaseCompensatoryLeave bb = cl.executeQueryOneRow();
					if(!BaseHelpUtils.isNullOrEmpty(bb)) {
						bb.setTotalCompensatoryLeave(bb.getTotalCompensatoryLeave().add(userEdd));
						cl.clear();
						cl.setDataFromBase(bb);
						cl.update();
					}	else {
						cl.clear();
						cl.setConditionEmployeeId("=",employeeId);
						if(startDateMonth==1) {
							cl.setConditionYear("=",startDateYear-1);
							cl.setConditionMonth("=",12);
						}else {
							cl.setConditionYear("=",startDateYear);
							cl.setConditionMonth("=",startDateMonth-1);
						}

						cl.setConditionStatus("=",1);
						List<BaseCompensatoryLeave> listTow = cl.conditionalLoad();
						employeeMonthCheck.clear();
						if(startDateMonth==1){
							employeeMonthCheck.setConditionYear("=", startDateYear-1);
							employeeMonthCheck.setConditionMonth("=",12);
						}else{
							employeeMonthCheck.setConditionYear("=", startDateYear);
							employeeMonthCheck.setConditionMonth("=",startDateMonth-1);
						}
						employeeMonthCheck.setConditionEmployeeId("=", employeeId);
						baseEmployeeMonthChecks = new ArrayList<>();
						baseEmployeeMonthChecks = employeeMonthCheck.conditionalLoad();
						overtimeHours = BigDecimal.ZERO;
						if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecks) && baseEmployeeMonthChecks.size() != 0) {
							for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecks) {
								//平时加班时长
								BigDecimal nornalOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getNornalOvertimeHours());
								//周末加班时长
								BigDecimal weekendOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getWeekendOvertimeHours());
								//节假日加班时长
								BigDecimal holidayOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getHolidayOvertimeHours());
								//计算总的加班的时长
								overtimeHours = overtimeHours.add(nornalOvertimeHours.add(weekendOvertimeHours).add(holidayOvertimeHours));
							}
						}
						userEd = BigDecimal.ZERO;
						if (!BaseHelpUtils.isNullOrEmpty(baseCompensatoryLeaves) && baseCompensatoryLeaves.size() != 0) {
							for (BaseCompensatoryLeave baseUsedVacationLeave : baseCompensatoryLeaves) {
								BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(baseUsedVacationLeave.getTotalCompensatoryLeave());
								userEd = userEd.add(bigDecimalValue);
							}
						}
						BigDecimal subtract = overtimeHours.subtract(userEd);
						if(subtract.subtract(userEdd).compareTo(BigDecimal.ZERO)>=0) {
							cl.clear();
							cl.setConditionBusinessId("=",dao.getPersonnelBusinessId());
							cl.setConditionStatus("=",1);
							if(startDateMonth==1){
								cl.setConditionYear("=",startDateYear-1);
								cl.setConditionMonth("=",12);
							}else{
								cl.setConditionYear("=",startDateYear);
								cl.setConditionMonth("=",startDateMonth-1);
							}
							cl.setConditionYear("=",startDateYear);
							cl.setConditionMonth("=",startDateMonth-1);
							cl.setConditionEmployeeId("=",employeeId);
							BaseCompensatoryLeave bases = cl.executeQueryOneRow();
							if(BaseHelpUtils.isNullOrEmpty(bases)){
								throw new Exception( "数据异常!!");
							}else{
								bases.setTotalCompensatoryLeave(bases.getTotalCompensatoryLeave().add(userEdd));
								cl.clear();
								cl.setDataFromBase(bases);
								cl.update();
							}
						}else {
							cl.clear();
							cl.setConditionBusinessId("=",dao.getPersonnelBusinessId());
							cl.setConditionStatus("=",1);
							if(startDateMonth==1){
								cl.setConditionYear("=",startDateYear-1);
								cl.setConditionMonth("=",12);
							}else{
								cl.setConditionYear("=",startDateYear);
								cl.setConditionMonth("=",startDateMonth-1);
							}

							cl.setConditionEmployeeId("=",employeeId);
							BaseCompensatoryLeave bases = cl.executeQueryOneRow();
							if(BaseHelpUtils.isNullOrEmpty(bases)){
								throw new Exception( "数据异常!!");
							}else{
								bases.setTotalCompensatoryLeave(bases.getTotalCompensatoryLeave().add(subtract));
								cl.clear();
								cl.setDataFromBase(bases);
								cl.update();
							}

							userEdd = userEdd.subtract(subtract);
							employeeMonthCheck.clear();
							employeeMonthCheck.setConditionYear("=", startDateYear);
							employeeMonthCheck.setConditionEmployeeId("=", employeeId);
							employeeMonthCheck.setConditionMonth("=",startDateMonth);
							baseEmployeeMonthChecks = new ArrayList<>();
							baseEmployeeMonthChecks = employeeMonthCheck.conditionalLoad();
							overtimeHours = BigDecimal.ZERO;
							if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecks) && baseEmployeeMonthChecks.size() != 0) {
								for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecks) {
									//平时加班时长
									BigDecimal nornalOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getNornalOvertimeHours());
									//周末加班时长
									BigDecimal weekendOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getWeekendOvertimeHours());
									//节假日加班时长
									BigDecimal holidayOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getHolidayOvertimeHours());
									//计算总的加班的时长
									overtimeHours = overtimeHours.add(nornalOvertimeHours.add(weekendOvertimeHours).add(holidayOvertimeHours));
								}
							}

							cl.clear();
							cl.setConditionEmployeeId("=",employeeId);
							cl.setConditionYear("=",startDateYear);
							cl.setConditionMonth("=",startDateMonth);
							cl.setConditionStatus("=",1);
							List<BaseCompensatoryLeave> baselist = cl.conditionalLoad();
							baseCompensatoryLeaves = new ArrayList<>();
							if(!BaseHelpUtils.isNullOrEmpty(baselist)){
								for (BaseCompensatoryLeave b:baselist){
									baseCompensatoryLeaves.add(b);
								}
							}
							userEd = BigDecimal.ZERO;
							if (!BaseHelpUtils.isNullOrEmpty(baseCompensatoryLeaves) && baseCompensatoryLeaves.size() != 0) {
								for (BaseCompensatoryLeave baseUsedVacationLeave : baseCompensatoryLeaves) {
									BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(baseUsedVacationLeave.getTotalCompensatoryLeave());
									userEd = userEd.add(bigDecimalValue);
								}
							}
							subtract = overtimeHours.subtract(userEd);
							if(subtract.subtract(userEdd).compareTo(BigDecimal.ZERO)>=0){
								cl.clear();
								cl.setBusinessId(dao.getPersonnelBusinessId());
								cl.setStatus(1);
								cl.setYear(startDateYear);
								cl.setMonth(startDateMonth);
								cl.setEmployeeId(employeeId);
								cl.setTotalCompensatoryLeave(subtract.subtract(userEdd));
								cl.save();
							}
						}

					}
				}

			}
		}
	}
	/**
	 * @author liubin
	 * @date 2019/12/17 11:09
	 * @param
	 * @return
	 * @description: 更新年假的数据
	 */
	private void updateAnnualLeave() throws SQLException {
		//获取请假的开始时间和结束时间
		Date startDate = bean.getStartDate();
		Date endDate = bean.getEndDate();
		Integer employeeId = bean.getEmployeeId();
		//获取请假的天数
		BigDecimal days = BaseHelpUtils.getBigDecimalValue(bean.getDays());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		//获取请假开始时间的年份和月份
		int startDateYear = calendar.get(Calendar.YEAR);
		int startDateMonth = calendar.get(Calendar.MONTH) + 1;
		//获取请假结束时间的年份和月份
		calendar.clear();
		calendar.setTime(endDate);
		int endDateYear = calendar.get(Calendar.YEAR);
		int endDateMonth = calendar.get(Calendar.MONTH) + 1;
		//获取当前时间的年份和月份
		calendar.clear();
		calendar.setTime(new Date());
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		if (startDateYear != endDateYear) {
			throw new SQLException("请假开始时间和结束时间必须在同一年");
		}
		if (startDateMonth <= 3 && endDateMonth > 3) {
			throw new SQLException("请假开始时间和结束时间不能跨过三月份");
		}
		AnnualLeave annualLeave = new AnnualLeave();
		//初始化当年的年假的数据
		BigDecimal currentTotalDay = BigDecimal.ZERO;
		BigDecimal currentUserDay = BigDecimal.ZERO;
		BigDecimal currentRemainingDay = BigDecimal.ZERO;
		//初始化上一年年假的数据
		BigDecimal lastTotalDay = BigDecimal.ZERO;
		BigDecimal lastUserDay = BigDecimal.ZERO;
		BigDecimal lastRemainingDay = BigDecimal.ZERO;
		annualLeave.clear();
		annualLeave.setConditionYear("=", startDateYear);
		annualLeave.setConditionEmployeeId("=", employeeId);
		if (annualLeave.isExist()) {
			BaseAnnualLeave baseAnnualLeave = annualLeave.executeQueryOneRow();
			currentTotalDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getTotalAnnualLeave());
			currentUserDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getUsageAmountAnnual());
			//今年剩余的年假
			currentRemainingDay = currentTotalDay.subtract(currentUserDay);
		}
		//上一年度的年假信息
		annualLeave.clear();
		annualLeave.setConditionYear("=", startDateYear - 1);
		annualLeave.setConditionEmployeeId("=", employeeId);
		if (annualLeave.isExist()) {
			BaseAnnualLeave baseAnnualLeave = annualLeave.executeQueryOneRow();
			lastTotalDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getTotalAnnualLeave());
			lastUserDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getUsageAmountAnnual());
			//上一年剩余的年假
			lastRemainingDay = lastTotalDay.subtract(lastUserDay);
		}
		if (lastRemainingDay.compareTo(BigDecimal.ZERO) == -1 || currentRemainingDay.compareTo(BigDecimal.ZERO) == -1) {
			throw new SQLException("数据异常: 已使用的年假数量大于当前的年假的总数量,请核查!");
		}
		//根据请假时间归档数据
		if (startDate.compareTo(new Date()) == -1) {
			//请假时间在同一年的情况
			if (currentYear == startDateYear) {
				//请假时间以及当前时间都在3月之内则可以用两年的年假
				if (currentMonth <= 3 && startDateMonth <= 3) {
					if ((currentRemainingDay.add(lastRemainingDay)).compareTo(days) == -1) {
						throw new SQLException("剩余的年假时长不够,请重新选择请假时间");
					}
					//上一年的剩余的年假的时长够本次请假的时间---- 使用的年假全部结算到上一年
					if (lastRemainingDay.compareTo(days) >= 0) {
						lastUserDay = lastUserDay.add(days);
					} else {
						//上一年的年假已经使用完---- 使用的年假全部归档到今年
						if (lastRemainingDay.compareTo(BigDecimal.ZERO) == 0) {
							currentUserDay = currentUserDay.add(days);
						}
						//一部分归档到上一年，一部分归档到当年
						else {
							BigDecimal subtract = days.subtract(lastRemainingDay);
							lastUserDay = lastTotalDay;
							currentUserDay = currentUserDay.add(subtract);
						}

					}
				}
				//其他情况都是只能使用一年的年假
				else {
					if (currentRemainingDay.compareTo(days) == -1) {
						throw new SQLException("剩余的年假时长不够,请重新选择请假时间");
					}
					//年假的数据全部归档到当年
					currentUserDay = currentUserDay.add(days);
				}
			}
			//请假的年份在当前年份之前---都只能使用一年的年假
			else if (currentYear > startDateYear) {
				if (currentRemainingDay.compareTo(days) == -1) {
					throw new SQLException("剩余的年假时长不够,请重新选择请假时间");
				}
				//年假的数据全部归档到当年
				currentUserDay = currentUserDay.add(days);
			}
		}//请假时间在当前时间之后的情况---不需要判断当前时间
		else {
			//请假时间可以使用两年
			if (startDateMonth <= 3) {
				if ((currentRemainingDay.add(lastRemainingDay)).compareTo(days) == -1) {
					throw new SQLException("剩余的年假时长不够,请重新选择请假时间");
				}
				//上一年的剩余的年假的时长够本次请假的时间---- 使用的年假全部结算到上一年
				if (lastRemainingDay.compareTo(days) >= 0) {
					lastUserDay = lastUserDay.add(days);
				} else {
					//上一年的年假已经使用完---- 使用的年假全部归档到今年
					if (lastRemainingDay.compareTo(BigDecimal.ZERO) == 0) {
						currentUserDay = currentUserDay.add(days);
					}
					//一部分归档到上一年，一部分归档到当年
					else {
						BigDecimal subtract = days.subtract(lastRemainingDay);
						lastUserDay = lastTotalDay;
						currentUserDay = currentUserDay.add(subtract);
					}

				}
			}//请假时间只能使用一年
			else {
				if (currentRemainingDay.compareTo(days) == -1) {
					throw new SQLException("剩余的年假时长不够,请重新选择请假时间");
				}
				//年假的数据全部归档到当年
				currentUserDay = currentUserDay.add(days);
			}
		}
		annualLeave.clear();
		//更新当年的年假
		annualLeave.setConditionEmployeeId("=", employeeId);
		annualLeave.setConditionYear("=", startDateYear);
		annualLeave.setUsageAmountAnnual(currentUserDay);
		annualLeave.conditionalUpdate();
		//更新上一年的年假
		annualLeave.clear();
		annualLeave.setConditionEmployeeId("=", employeeId);
		annualLeave.setConditionYear("=", startDateYear - 1);
		annualLeave.setUsageAmountAnnual(lastUserDay);
		annualLeave.conditionalUpdate();
	}

	private void deleteAnnualLeave(BasePersonnelBusines bean) throws SQLException {
		//获取请假的开始时间和结束时间
		Date startDate = bean.getStartDate();
		Date endDate = bean.getEndDate();
		//获取请假的天数
		BigDecimal days = BaseHelpUtils.getBigDecimalValue(bean.getDays());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		//获取请假开始时间的年份和月份
		int startDateYear = calendar.get(Calendar.YEAR);
		AnnualLeave annualLeave = new AnnualLeave();
		//初始化当年的年假的数据
		BigDecimal currentTotalDay = BigDecimal.ZERO;
		BigDecimal currentUserDay = BigDecimal.ZERO;
		BigDecimal currentRemainingDay = BigDecimal.ZERO;
		//初始化上一年年假的数据
		BigDecimal lastTotalDay = BigDecimal.ZERO;
		BigDecimal lastUserDay = BigDecimal.ZERO;
		BigDecimal lastRemainingDay = BigDecimal.ZERO;
		annualLeave.clear();
		annualLeave.setConditionYear("=", startDateYear);
		annualLeave.setConditionEmployeeId("=", bean.getEmployeeId());
		if (annualLeave.isExist()) {
			BaseAnnualLeave baseAnnualLeave = annualLeave.executeQueryOneRow();
			currentTotalDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getTotalAnnualLeave());
			currentUserDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getUsageAmountAnnual());
			//今年剩余的年假
			currentRemainingDay = currentTotalDay.subtract(currentUserDay);
		}
		//上一年度的年假信息
		annualLeave.clear();
		annualLeave.setConditionYear("=", startDateYear - 1);
		annualLeave.setConditionEmployeeId("=", bean.getEmployeeId());
		if (annualLeave.isExist()) {
			BaseAnnualLeave baseAnnualLeave = annualLeave.executeQueryOneRow();
			lastTotalDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getTotalAnnualLeave());
			lastUserDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getUsageAmountAnnual());
			//上一年剩余的年假
			lastRemainingDay = lastTotalDay.subtract(lastUserDay);
		}
		//回退的规则都是优先退回请假当年的数据让后再回退上一年的数据
		//当年使用的年假够本次退回的---- 直接退回到当年
		if (currentUserDay.compareTo(days) == 1) {
			currentUserDay = currentUserDay.subtract(days);
		}
		//当年的已用请假时间不够本次退回---- 则先退回当年的数据然后再退回上一年的数据
		else {
			BigDecimal subtract = days.subtract(currentUserDay);
			lastUserDay = lastUserDay.subtract(subtract);
			currentUserDay = BigDecimal.ZERO;
		}
		annualLeave.clear();
		//更新当年的年假
		annualLeave.setConditionEmployeeId("=", bean.getEmployeeId());
		annualLeave.setConditionYear("=", startDateYear);
		annualLeave.setUsageAmountAnnual(currentUserDay);
		annualLeave.conditionalUpdate();
		//更新上一年的年假
		annualLeave.clear();
		annualLeave.setConditionEmployeeId("=", bean.getEmployeeId());
		annualLeave.setConditionYear("=", startDateYear - 1);
		annualLeave.setUsageAmountAnnual(lastUserDay);
		annualLeave.conditionalUpdate();
	}

	public static void main(String[] args)throws Exception {

//		CompensatoryLeave cl = new CompensatoryLeave();
//		cl.setConditionYear("=",2020);
//		cl.setConditionMonth("=",5);
//
//
//		cl.setConditionEmployeeId("=",141);
//
//		PersonnelBusines p = new PersonnelBusines();
//		SystemProcessInstance spi = new SystemProcessInstance();
//		List<BaseCompensatoryLeave> list = cl.conditionalLoad();
//		if(!BaseHelpUtils.isNullOrEmpty(list)){
//			for (BaseCompensatoryLeave b:list) {
//				p.clear();
//				p.setPersonnelBusinessId(b.getBusinessId());
//				if(p.load()){
//					spi.setConditionBusinessId("=",p.getPersonnelBusinessId());
//					spi.setConditionDeleteFlag("=",0);
//					spi.setConditionProcessType("=",13);
//					BaseSystemProcessInstance base = spi.executeQueryOneRow();
//					if(BaseHelpUtils.isNullOrEmpty(base)){
//						cl.clear();
//						cl.setDataFromBase(b);
//						cl.delete();
//					}else{
//
//					}
//				}
//			}
//
//		}
//
//
//		BigDecimal userEd = BigDecimal.ZERO;
//		BigDecimal overtimeHours = BigDecimal.ZERO;
//		//查询员工的加班时长
//		EmployeeMonthCheck employeeMonthCheck = new EmployeeMonthCheck();
//		List<BaseEmployeeMonthCheck> baseEmployeeMonthChecks = new ArrayList<>();
//		//查询员工的使用的调休假的时长
//		List<BaseCompensatoryLeave> baseCompensatoryLeaves = new ArrayList<>();
//		if(!BaseHelpUtils.isNullOrEmpty(list)){
//			for (BaseCompensatoryLeave b:list){
//				p.clear();
//				p.setPersonnelBusinessId(b.getBusinessId());
//				if(p.load()){
//					if(p.getType()==21){
//						Calendar calendar = Calendar.getInstance();
//						calendar.setTime(p.getStartDate());
//						//获取请假开始时间的年份和月份
//						int startDateMonth = calendar.get(Calendar.MONTH) + 1;
//						if(b.getMonth().equals(startDateMonth)){
//							userEd = BigDecimal.ZERO;
//							overtimeHours = BigDecimal.ZERO;
//							baseEmployeeMonthChecks = new ArrayList<>();
//							baseCompensatoryLeaves = new ArrayList<>();
//							if( !BaseHelpUtils.isNullOrEmpty(p.getDays()) && p.getDays().compareTo(BigDecimal.ZERO)>0){
//								userEd = userEd.add(p.getDays().multiply(new BigDecimal("7")));
//							}
//							if(!BaseHelpUtils.isNullOrEmpty(p.getHours()) &&p.getHours().compareTo(BigDecimal.ZERO)>0){
//								userEd = userEd.add(p.getHours());
//							}
//
//							employeeMonthCheck.clear();
//							employeeMonthCheck.setConditionYear("=", b.getYear());
//							employeeMonthCheck.setConditionEmployeeId("=",b.getEmployeeId());
//							employeeMonthCheck.setConditionMonth("=", b.getMonth()-1);
//							List<BaseEmployeeMonthCheck> baseEmployeeMonthChecksTemp2 = employeeMonthCheck.conditionalLoad();
//							if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecksTemp2) && baseEmployeeMonthChecksTemp2.size() != 0) {
//								for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecksTemp2) {
//									baseEmployeeMonthChecks.add(baseEmployeeMonthCheck);
//								}
//							}
//
//							cl.clear();
//							cl.setConditionEmployeeId("=",b.getEmployeeId());
//							cl.setConditionYear("=",b.getYear());
//							cl.setConditionMonth("=",b.getMonth()-1);
//							cl.setConditionStatus("=",1);
//							List<BaseCompensatoryLeave> baseList = cl.conditionalLoad();
//							if(!BaseHelpUtils.isNullOrEmpty(baseList)){
//								for (BaseCompensatoryLeave bb:baseList){
//									baseCompensatoryLeaves.add(bb);
//								}
//							}
//
//							if (!BaseHelpUtils.isNullOrEmpty(baseCompensatoryLeaves) && baseCompensatoryLeaves.size() != 0) {
//								for (BaseCompensatoryLeave baseUsedVacationLeave : baseCompensatoryLeaves) {
//									BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(baseUsedVacationLeave.getTotalCompensatoryLeave());
//									userEd = userEd.add(bigDecimalValue);
//								}
//							}
//
//							if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeMonthChecks) && baseEmployeeMonthChecks.size() != 0) {
//								for (BaseEmployeeMonthCheck baseEmployeeMonthCheck : baseEmployeeMonthChecks) {
//									//平时加班时长
//									BigDecimal nornalOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getNornalOvertimeHours());
//									//周末加班时长
//									BigDecimal weekendOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getWeekendOvertimeHours());
//									//节假日加班时长
//									BigDecimal holidayOvertimeHours = BaseHelpUtils.getBigDecimalValue(baseEmployeeMonthCheck.getHolidayOvertimeHours());
//									//计算总的加班的时长
//									overtimeHours = overtimeHours.add(nornalOvertimeHours.add(weekendOvertimeHours).add(holidayOvertimeHours));
//								}
//							}
//							if(overtimeHours.compareTo(userEd)>=0){
//								cl.clear();
//								b.setMonth(b.getMonth()-1);
//								cl.setDataFromBase(b);
//								cl.update();
//							}
//						}
//
//
//					}
//
//
//				}
//			}
//		}





		PersonnelBusines p = new PersonnelBusines();
		p.setConditionProcessType("=",13);
		p.setConditionType("=",21);
//		p.setConditionEmployeeId("=",141);
//		p.setConditionPersonnelBusinessId("=",8055);
		List<BasePersonnelBusines> list = p.conditionalLoad();
		CompensatoryLeave cl = new CompensatoryLeave();
		if(!BaseHelpUtils.isNullOrEmpty(list)){
			for (BasePersonnelBusines b :list){
				cl.clear();
				cl.setConditionBusinessId("=",b.getPersonnelBusinessId());
				BaseCompensatoryLeave base = cl.executeQueryOneRow();
				if(BaseHelpUtils.isNullOrEmpty(base)){
					p.clear();
					p.setDataFromBase(b);
					updateCompensatoryLeave(p);
				}

			}
		}
//		p.setPersonnelBusinessId(53672);
//		p.load();
//		updateCompensatoryLeave(p);
	}
}
