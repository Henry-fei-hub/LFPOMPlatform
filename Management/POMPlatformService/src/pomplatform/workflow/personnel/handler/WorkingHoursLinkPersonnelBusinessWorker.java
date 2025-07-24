package pomplatform.workflow.personnel.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.dao.*;
import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseWorkingHour;
import com.pomplatform.db.bean.BaseWorkingHourLinkPersonnelBusines;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericBase;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;

public class WorkingHoursLinkPersonnelBusinessWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	private static final Logger logger = Logger.getLogger(WorkingHoursLinkPersonnelBusinessWorker.class);

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		logger.info("---------------------------------- params :" + params);
		bean.setDataFromMap(params);
		bean.setProcessType(84);
		bean.setDrafter(bean.getEmployeeId());
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dao.save();
		//获取流程业务表的主键
		Integer personnelBusinessId = dao.getPersonnelBusinessId();
		//获取工时流程表数据保存
		List<Map<String, Object>> list = (List<Map<String, Object>>) params.get("workHoursDetails");
		if(BaseHelpUtils.isNullOrEmpty(list)){
			list = getListByBusinessId(BaseHelpUtils.getIntValue(params.get("personnelBusinessId")));
		}
		List<BaseWorkingHourLinkPersonnelBusines> baseWorkingHourLinkPersonnelBusiness = GenericBase.__getList(list, BaseWorkingHourLinkPersonnelBusines::new);
		for (BaseWorkingHourLinkPersonnelBusines workingHourLinkPersonnelBusiness : baseWorkingHourLinkPersonnelBusiness) {
			workingHourLinkPersonnelBusiness.setPersonnelBusinessId(personnelBusinessId);
		}
		dataValidate(baseWorkingHourLinkPersonnelBusiness);
		WorkingHourLinkPersonnelBusines workingHourLinkPersonnelBusines = new WorkingHourLinkPersonnelBusines();
		workingHourLinkPersonnelBusines.save(baseWorkingHourLinkPersonnelBusiness);
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		bean.setDataFromMap(params);
		logger.info("-----------------------------------params :" + params);
		if(!modified) {
			ProcessInstance pIns = pi.getProcessInstance();
			if(BaseHelpUtils.isNullOrEmpty(pIns)) {
				return null;
			}
			ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
			if(BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
				return null;
			}
			int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			if(!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {
				return null;
			}
		}

		if (completed) {
			//流程完成时将数据复制到工时表中
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				Employee eDao =new Employee();
				MainProject project = new MainProject();
				List<Map<String, Object>> list = (List<Map<String, Object>>) params.get("workHoursDetails");
				WorkingHour workingHour = new WorkingHour();
				List<BaseWorkingHour> workHourList = new ArrayList<>();
				int personnelBusinessId = BaseHelpUtils.getIntValue(params.get("personnelBusinessId"));
				int userId = BaseHelpUtils.getIntValue(params.get("employeeId"));
				String employeeNo = "";
				String employeeName ="";
				int departmentId = BaseHelpUtils.getIntValue(params.get("departmentId"));
				int plateId = 0;
				int companyId = BaseHelpUtils.getIntValue(params.get("companyId"));
				Date startDate = GenericBase.__getDate(params.get("startDate"));
				String remark = BaseHelpUtils.getString(params.get("remark"));
				if(BaseHelpUtils.isNullOrEmpty(list)){
					list = getListByBusinessId(personnelBusinessId);
				}
				eDao.setConditionEmployeeId("=", userId);
				eDao.setEmployeeId( userId);
				if(eDao.load()) {
					plateId=eDao.getPlateId();
					employeeNo=eDao.getEmployeeNo();
					employeeName = eDao.getEmployeeName();
				}
				for (Map<String, Object> map : list) {
					BaseWorkingHour baseWorkingHour = new BaseWorkingHour();
					int mainProjectId = BaseHelpUtils.getIntValue(map.get("projectId"));

					//查询订单的信息
					project.clear();
					project.setConditionMainProjectId("=", mainProjectId);
					BaseMainProject baseProject = project.executeQueryOneRow();

					BigDecimal workHours = BaseHelpUtils.getBigDecimalValue(map.get("workHour"));
					baseWorkingHour.setEmployeeId(userId);
					baseWorkingHour.setEmployeeNo(employeeNo);
					baseWorkingHour.setEmployeeName(employeeName);
					baseWorkingHour.setPlateId(plateId);
					baseWorkingHour.setDepartmentId(departmentId);
					baseWorkingHour.setCompanyId(companyId);
					baseWorkingHour.setWorkDate(startDate);
					baseWorkingHour.setRemark(remark);
					baseWorkingHour.setProjectId(mainProjectId);
					baseWorkingHour.setProjectCode(baseProject.getProjectCode());
					baseWorkingHour.setProjectName(baseProject.getProjectName());
					baseWorkingHour.setWorkHour(workHours);
					baseWorkingHour.setPersonnelBusinessId(personnelBusinessId);

					workHourList.add(baseWorkingHour);
				}
				workingHour.save(workHourList);
			}
		}

		PersonnelBusines dao = new PersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dao.update();
		//更新工时业务流程表的数据
		List<Map<String, Object>> list = (List<Map<String, Object>>) params.get("workHoursDetails");
		if(BaseHelpUtils.isNullOrEmpty(list)){
			list = getListByBusinessId(BaseHelpUtils.getIntValue(params.get("personnelBusinessId")));
		}
		Integer personnelBusinessId = dao.getPersonnelBusinessId();
		WorkingHourLinkPersonnelBusines workingHourLinkPersonnelBusines = new WorkingHourLinkPersonnelBusines();
		workingHourLinkPersonnelBusines.setConditionPersonnelBusinessId("=", personnelBusinessId);
		workingHourLinkPersonnelBusines.conditionalDelete();
		workingHourLinkPersonnelBusines.clear();
		List<BaseWorkingHourLinkPersonnelBusines> baseWorkingHourLinkPersonnelBusiness = GenericBase.__getList(list, BaseWorkingHourLinkPersonnelBusines::new);
		for (BaseWorkingHourLinkPersonnelBusines workingHourLinkPersonnelBusiness : baseWorkingHourLinkPersonnelBusiness) {
			workingHourLinkPersonnelBusiness.setPersonnelBusinessId(personnelBusinessId);
		}
		dataValidate(baseWorkingHourLinkPersonnelBusiness);
		workingHourLinkPersonnelBusines.save(baseWorkingHourLinkPersonnelBusiness);

		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
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

	private void dataValidate(List<BaseWorkingHourLinkPersonnelBusines> baseWorkingHourLinkPersonnelBusiness) throws Exception{
		for (BaseWorkingHourLinkPersonnelBusines bean :baseWorkingHourLinkPersonnelBusiness){
			MainProject mainProject = new MainProject();
			mainProject.setMainProjectId(bean.getProjectId());
			if (!mainProject.load()){
				throw new Exception("请填写正确的项目名称");
			}
			if(BaseHelpUtils.isNullOrEmpty(bean.getWorkHour())){
				throw new Exception("请填写工时");
			}
		}
	}

	private List getListByBusinessId(int personnelBusinessId) throws SQLException {
			List list = new ArrayList<Map<String, Object>>();
			WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
			dao.setConditionPersonnelBusinessId("=",personnelBusinessId);
			List<BaseWorkingHourLinkPersonnelBusines> BaseWorkingHourLinkPersonnelBusiness =  dao.conditionalLoad();
			for(BaseWorkingHourLinkPersonnelBusines bean :BaseWorkingHourLinkPersonnelBusiness){
				Map<String, Object> map = bean.toMap();
				map.put("projectCode",bean.getProjectId());
				list.add(map);
			}
		return list;
	}

}
