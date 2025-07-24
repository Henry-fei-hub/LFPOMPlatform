package pomplatform.common.business;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseCompanyArea;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.dao.CompanyArea;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectEmployee;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.BaseSystemProcess;
import delicacy.system.bean.BaseSystemProcessDepartment;
import delicacy.system.bean.BaseSystemProcessType;
import delicacy.system.dao.Employee;
import delicacy.system.dao.SystemProcess;
import delicacy.system.dao.SystemProcessDepartment;
import delicacy.system.dao.SystemProcessType;
import pomplatform.common.bean.UserProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.payment.bean.BaseOnLoadEmployeePayment;
import pomplatform.payment.bean.ConditionOnLoadEmployeePayment;
import pomplatform.payment.query.QueryOnLoadEmployeePayment;
import pomplatform.workflow.contractstatus.bean.BaseContractStatusMonth;
import pomplatform.workflow.contractstatus.bean.ConditionContractStatusMonth;
import pomplatform.workflow.contractstatus.query.QueryContractStatusMonth;
public class GetUserInfoByIdProcessor implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取登录用户ID
		int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
		String optType = BaseHelpUtils.getString(param.get("optType"));
		switch (optType) {
		case "departmentId":
			return getDepartmentIdByEmployeeId(employeeId);
		case "getProjectName":
			return getProjectNameByEmployeeId(employeeId);
		case "getProcessId":
			return getProcessId(employeeId);
		case "getPreProject":
			return getPreProject(employeeId);
		case "getCompanyAndArea":
			return getCompanyAndArea(employeeId);
		case "getBasicInfo":
			return getBasicInfo(employeeId);
		case "getSalary":
			return getSalary(employeeId);
		case "getMainProjectName":
			return getMainProjectName(param);
		default:
			return null;
		}
	}
	
	/**
	 * 报销加载项目维度的项目名称
	 * @param param
	 * @return
	 * @throws Exception
	 */
	private String getMainProjectName(Map<String, Object> param) throws Exception{
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		MainProject dao = new MainProject();
		dao.unsetSelectFlags();
		dao.setSelectMainProjectId(Boolean.TRUE);
		dao.setSelectProjectCode(Boolean.TRUE);
		dao.setSelectProjectName(Boolean.TRUE);
		dao.setConditionProcessStatus("=", 2);
		List<BaseMainProject> list = dao.conditionalLoad("order by main_project_id desc");
		//定义map来存放返回的数据集
		Map<Integer,String> userMap = new HashMap<>();
		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0) {
			for(BaseMainProject e : list) {
				int mainProjectId = BaseHelpUtils.getIntValue(e.getMainProjectId());
				if(mainProjectId <= 0) {
					continue;
				}
				String projectCode = BaseHelpUtils.getString(e.getProjectCode());
				String projectName = BaseHelpUtils.getString(e.getProjectName());
				String name = "";
				if(BaseHelpUtils.isNullOrEmpty(projectCode) && BaseHelpUtils.isNullOrEmpty(projectName)) {
					continue;
				}
				if(BaseHelpUtils.isNullOrEmpty(projectCode)) {
					name = projectName;
				}else if(BaseHelpUtils.isNullOrEmpty(projectName)) {
					name = projectCode;
				}else {
					name = projectCode+"--"+projectName;
				}
				userMap.put(mainProjectId, name);
			}
		}
		bc.setUserData(userMap);
		return bc.toJSON();
	}

	/**
	 * 通过员工ID，返回员工的部门ID
	 * 
	 * @param employeeId
	 */
	private String getDepartmentIdByEmployeeId(int employeeId) throws Exception {
		Employee dao = new Employee();
		dao.setConditionEmployeeId("=", employeeId);
		dao.unsetSelectFlags();
		dao.setSelectDepartmentId(true);
		List<BaseEmployee> list = dao.conditionalLoad();
		BaseCollection<BaseEmployee> bc = new BaseCollection<>();
		bc.setCollections(list);
		return bc.toJSON();
	}
	/**
	 * 检索出前期项目
	 * @param employeeId
	 * @return
	 * @throws Exception
	 */
	private String getPreProject(int employeeId)throws Exception{
		MainProject mp=new MainProject();
		mp.unsetSelectFlags();
		mp.setConditionProjectCode("=", "");
		mp.setSelectMainProjectId(true);
		mp.setSelectProjectName(true);
		mp.setSelectInfoCode(true);
		List<BaseMainProject> list=mp.conditionalLoad(" order by main_project_id ");
		BaseCollection<BaseMainProject> bc = new BaseCollection<>();
		bc.setCollections(list);
		return bc.toJSON();
	}
	
	private String getProjectNameByEmployeeId(int employeeId) throws Exception{
		BaseCollection<BaseProject> bc = new BaseCollection<>();
		ProjectEmployee peDao = new ProjectEmployee();
		peDao.unsetSelectFlags();
		peDao.setSelectProjectId(true);
		peDao.setConditionEmployeeId("=", employeeId);
		List<BaseProjectEmployee> peList = peDao.conditionalLoad();
		if(null != peList && !peList.isEmpty()){
			int size = peList.size();
			Object[] arr = new Object[size];
			for(int i = 0; i < size; i++){
				arr[i] = peList.get(i).getProjectId();
			}
			// 处于以下订单状态的订单不能参与报销：订单终止—结算中、订单终止、订单暂停、订单结束
			Object[] projectStatusArr = {StaticUtils.PROJECT_STATUS_14, StaticUtils.PROJECT_STATUS_15,
					StaticUtils.PROJECT_STATUS_10, StaticUtils.PROJECT_STATUS_11};
			//落标超过3个月的订单不能参与报销
			ConditionContractStatusMonth condition = new ConditionContractStatusMonth();
			condition.setNewStatus(StaticUtils.CONTRACT_STATUS_2);
			condition.setContractMonth(3);
			QueryContractStatusMonth query = new QueryContractStatusMonth();
			BaseCollection<BaseContractStatusMonth> collection = query.executeQuery(null, condition);
			Set<Integer> contractIds = null;
			if(null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()) {
				contractIds = new HashSet<>();
				for(BaseContractStatusMonth obj : collection.getCollections()) {
					contractIds.add(obj.getContractId());
				}
			}
			Project pDao = new Project();
			pDao.unsetSelectFlags();
			pDao.setSelectProjectId(true);
			pDao.setSelectProjectName(true);
			pDao.setSelectContractCode(true);
			pDao.setSelectPlateId(true);
			pDao.addCondition(BaseProject.CS_PROJECT_ID, "in", arr);
			pDao.addCondition(BaseProject.CS_STATUS, "not in", projectStatusArr);
			if(null != contractIds) {
				pDao.addCondition(BaseProject.CS_CONTRACT_ID, "not in", contractIds.toArray());
			}
			List<BaseProject> list = pDao.conditionalLoad();
			if(null != list && !list.isEmpty()){
				for(BaseProject bean : list){
					StringBuilder sb = new StringBuilder();
					if(!BaseHelpUtils.isNullOrEmpty(bean.getContractCode())){
						sb.append(bean.getContractCode()).append("--");
					}
					sb.append(bean.getProjectName()).append("--");
					if(!BaseHelpUtils.isNullOrEmpty(bean.getPlateId())){
						sb.append(bean.getPlateId());
					}
					bean.setProjectName(sb.toString());
				}
				bc.setCollections(list);
			}
		}
		return bc.toJSON();
	}
	
	private String getProcessId(int employeeId) throws Exception{
		Employee eDao = new Employee();
		eDao.unsetSelectFlags();
		eDao.setSelectDepartmentId(true);
		eDao.setConditionEmployeeId("=", employeeId);
		BaseEmployee employee = eDao.executeQueryOneRow();
		BaseCollection<UserProcess> bc = new BaseCollection<>();
		//找到该用户所在的部门，如果部门为空，则不进行下述操作
		if(null != employee && null != employee.getDepartmentId()){
			UserProcess bean = new UserProcess();
			int departmentId = employee.getDepartmentId();
			//找出报销流程下面的所有报销类型
			SystemProcessType processTypeDao = new SystemProcessType();
			processTypeDao.unsetSelectFlags();
			processTypeDao.setSelectProcessTypeId(true);
			processTypeDao.setSelectProcessExecuteName(true);
			processTypeDao.setConditionParentProcessTypeId("=", 1);
			List<BaseSystemProcessType> processTypeList = processTypeDao.conditionalLoad();
			for(BaseSystemProcessType type : processTypeList){
				//根据报销类型，找到相对应的流程实例
				SystemProcess processDao = new SystemProcess();
				processDao.unsetSelectFlags();
				processDao.setSelectProcessId(true);
				processDao.setConditionProcessTypeId("=", type.getProcessTypeId());
				List<BaseSystemProcess> processList = processDao.conditionalLoad();
				if(null != processList && !processList.isEmpty()){
					//根据流程实例和员工所在部门，检索出用户所能使用的流程实例列表，并返回第一个可用的流程实例Id
					int size = processList.size();
					Object[] processIdArr = new Object[size];
					for(int i = 0; i < size; i++){
						processIdArr[i] = processList.get(i).getProcessId();
					}
					SystemProcessDepartment dao = new SystemProcessDepartment();
					dao.addCondition(BaseSystemProcessDepartment.CS_PROCESS_ID, "in", processIdArr);
					dao.setConditionDepartmentId("=", departmentId);
					dao.setConditionIsEnable("=", true);
					List<BaseSystemProcessDepartment> list = dao.conditionalLoad();
					if(null != list && !list.isEmpty()){
						switch(type.getProcessExecuteName()){
						case "Project_normal_reimbursement":
							bean.setProjectNormalReimbursement(list.get(0).getProcessId());
							break;
						case "Common_normal_reimbursement":
							bean.setCommonNormalReimbursement(list.get(0).getProcessId());
							break;
						case "Project_travel_reimbursement":
							bean.setProjectTravelReimbursement(list.get(0).getProcessId());
							break;
						case "Common_travel_reimbursement":
							bean.setCommonTravelReimbursement(list.get(0).getProcessId());
							break;
						case "Borrow_money_manage":
							bean.setBorrowMoneyManage(list.get(0).getProcessId());
							break;
						case "Pay_money_manage":
							bean.setPayMoneyManage(list.get(0).getProcessId());
							break;
						default:
							break;
						}
					}
				}
			}
			List<UserProcess> list = new ArrayList<>();
			list.add(bean);
			bc.setCollections(list);
		}
		return bc.toJSON();
	}
	
	/**
	 * 获取员工的归属公司和公司所在区域名称
	 * @param employeeId
	 * @return
	 * @throws Exception
	 */
	public String getCompanyAndArea(int employeeId) throws Exception{
		BaseCollection<BaseCompanyArea> bc = new BaseCollection<>();
		Employee eDao = new Employee();
		eDao.setEmployeeId(employeeId);
		eDao.unsetSelectFlags();
		eDao.setSelectCompanyId(true);
		if(eDao.load()){
			CompanyArea dao = new CompanyArea();
			dao.setConditionCompanyId("=", eDao.getCompanyId());
			List<BaseCompanyArea> list = dao.conditionalLoad();
			bc.setCollections(list);
			return bc.toJSON();
		}
		return bc.toJSON(-1,"获取数据失败");
	}
	
	/**
	 * 根据员工ID，查找该员工的基础信息
	 * @param employeeId
	 * @return
	 * @throws Exception
	 */
	public String getBasicInfo(int employeeId) throws Exception{
		BaseCollection<BaseEmployee> bc = new BaseCollection<>();
		Employee dao = new Employee();
		dao.setEmployeeId(employeeId);
		if(dao.load()){
			List<BaseEmployee> list = new ArrayList<>();
			list.add(dao.generateBase());
			bc.setCollections(list);
			return bc.toJSON();
		}else{
			return bc.toJSON(-1, "没有找到该员工");
		}
	}
	
	public String getSalary(int employeeId) throws Exception{
		QueryOnLoadEmployeePayment dao = new QueryOnLoadEmployeePayment();
        ConditionOnLoadEmployeePayment condition = new ConditionOnLoadEmployeePayment();
        condition.setEnabled(Boolean.TRUE);
        condition.setEmployeeId(employeeId);
        BaseCollection<BaseOnLoadEmployeePayment> result = dao.executeQuery(null, condition);
		return result.toJSON();
	}
}