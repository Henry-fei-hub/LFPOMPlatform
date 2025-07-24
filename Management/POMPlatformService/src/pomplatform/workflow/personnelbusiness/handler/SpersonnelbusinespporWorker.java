package pomplatform.workflow.personnelbusiness.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
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
import pomplatform.common.utils.StaticUtils;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.shift.business.OnShiftManageProcess;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.personnelbusiness.bean.BaseGetOvertimeApplyHours;
import pomplatform.workflow.personnelbusiness.bean.ConditionGetOvertimeApplyHours;
import pomplatform.workflow.personnelbusiness.query.QueryGetOvertimeApplyHours;

public class SpersonnelbusinespporWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
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
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		if(!BaseHelpUtils.isNullOrEmpty(bean.getHours()) && bean.getHours().compareTo(BigDecimal.ZERO) > 0){
			validateHours(true, dao);
		}
		ColumnChangedData attachmentIdData = dao.getColumnChangedData(BasePersonnelBusines.CS_ATTACHMENT_ID);
		//修改附件的引用次数
		FileManageProcessor.upadteTimesByColumnChangedData(attachmentIdData);
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
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e = OnWrokflowProcess.setExpression(expression, e, employeeId,null,null,null);
		e.setValue("天数", bean.getDays() == null ? 0.0 : bean.getDays().doubleValue());
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		if(null!= roleId){
			//项目经理审批节点----查询所有的项目的项目经理
			if (roleId == StaticUtils.ROLE_MAIN_PROJECT_MANAGER) {
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
			//考勤管理员审批
			if (null != roleId && roleId.equals(StaticUtils.ROLE_ATTENDANCE_ADMINISTRATOR)) {
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


	private void validateHours(boolean isUpdate, PersonnelBusines dao) throws Exception{
		BigDecimal hours = BigDecimal.ZERO;
		BigDecimal twenty = new BigDecimal(20);
		BigDecimal maxHours = BigDecimal.ZERO;
		ConditionGetOvertimeApplyHours condition = new ConditionGetOvertimeApplyHours();
		condition.setEmployeeId(bean.getEmployeeId());
		Calendar c = Calendar.getInstance();
		if(isUpdate){
			c.setTime(dao.getCreateTime());
		}else{
			c.setTime(new Date());
		}
		c.set(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Date startTime = c.getTime();
		c.set(Calendar.YEAR, c.get(Calendar.YEAR) + 1);
		Date endTime = c.getTime();
		condition.setStartTime(startTime);
		condition.setEndTime(endTime);
		QueryGetOvertimeApplyHours query = new QueryGetOvertimeApplyHours();
		BaseCollection<BaseGetOvertimeApplyHours> bc = query.executeQuery(null, condition);
		if(null != bc.getCollections() && null != bc.getCollections().get(0) && null != bc.getCollections().get(0).getHours()){
			hours = bc.getCollections().get(0).getHours();
		}
		if(isUpdate){
			//修改的，需要减去原有的小时数，再加上本次的小时数
			if(null != dao && null != dao.getHours()){
				hours = hours.subtract(dao.getHours());
				maxHours = twenty.subtract(hours);
			}
			hours = hours.add(bean.getHours());
		}else{
			maxHours = twenty.subtract(hours);
			//新增的，只需要加上本次的小时数
			hours = hours.add(bean.getHours());
		}
		//减去已经使用的小时数
		PersonnelBusines pbDao = new PersonnelBusines();
		pbDao.setConditionProcessType("=", StaticUtils.PROCESS_TYPE_13);
		pbDao.setConditionType("=", StaticUtils.LEAVE_TYPE_21);
		pbDao.setConditionIsCompleted("=", true);
		pbDao.setConditionEmployeeId("=", bean.getEmployeeId());
		List<BasePersonnelBusines> list = pbDao.conditionalLoad();
		for (BasePersonnelBusines bqlad : list) {
			if(null != bqlad.getDays()){
				hours = hours.subtract(bqlad.getDays().multiply(StaticUtils.TOTAL_HOURS));
				maxHours = maxHours.add(bqlad.getDays().multiply(StaticUtils.TOTAL_HOURS));
			}
			if(null != bqlad.getHours()){
				hours = hours.subtract(bqlad.getHours());
				maxHours = maxHours.add(bqlad.getHours());
			}
		}
		//控制，1年内，总的加班时数最多只能有20个小时
		if(hours.compareTo(twenty) > 0){
			if(maxHours.compareTo(BigDecimal.ZERO) > 0){
				throw new Exception("对不起，您本次最多只能申请"+maxHours+"小时");
			}else{
				throw new Exception("对不起，您申请的加班时间已达上限，无法继续申请");
			}
		}
	}
}
