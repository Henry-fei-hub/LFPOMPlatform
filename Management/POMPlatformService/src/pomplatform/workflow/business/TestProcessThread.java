package pomplatform.workflow.business;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pomplatform.db.bean.BaseBudgetAttachment;
import com.pomplatform.db.bean.BaseBudgetManagementDetail;
import com.pomplatform.db.bean.BaseCarCostAllocation;
import com.pomplatform.db.bean.BaseCostAllocation;
import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseLeaveType;
import com.pomplatform.db.bean.BaseMainProjectEmployee;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkDepartment;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkMainProject;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkProject;
import com.pomplatform.db.bean.BasePersonnelBusinessLinkEquipment;
import com.pomplatform.db.bean.BasePreProject;
import com.pomplatform.db.bean.BasePreProjectReimbursementNumber;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectAttachment;
import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.bean.BaseTravelReimbursementDetail;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkDepartment;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkMainProject;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkProject;
import com.pomplatform.db.dao.BudgetAttachment;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.LeaveType;
import com.pomplatform.db.dao.PreProject;
import com.pomplatform.db.dao.PreProjectReimbursementNumber;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectAttachment;
import com.pomplatform.db.dao.SystemDictionary;
import com.pomplatform.db.dao.ThreadTaskManage;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.MapUtils;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.BaseSystemProcess;
import delicacy.system.bean.BaseSystemProcessDepartment;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.dao.Employee;
import delicacy.system.dao.ProcessorTestResult;
import delicacy.system.dao.SystemProcess;
import delicacy.system.dao.SystemProcessDepartment;
import delicacy.system.executor.NewCreateWorkFlow;
import pomplatform.common.utils.StaticUtils;
import pomplatform.getEmployeeIdByRoleId.bean.BasegetEmployeeIdByRoleId;
import pomplatform.getEmployeeIdByRoleId.bean.ConditiongetEmployeeIdByRoleId;
import pomplatform.getEmployeeIdByRoleId.query.QuerygetEmployeeIdByRoleId;

public class TestProcessThread extends Thread{

	private Integer threadId;
	private String processId;
	
	public void run() {
		if(null == threadId) {
			return;
		}
		try {
			if(BaseHelpUtils.isNullOrEmpty(processId)) {
				SystemProcess dao = new SystemProcess();
				dao.unsetSelectFlags();
				dao.setSelectProcessId(true);
				List<BaseSystemProcess> list = dao.conditionalLoad();
				if(null == list || list.isEmpty()) {
					updateThreadTask(StaticUtils.THREAD_TASK_MANAGE_STATUS_3, "没有需要测试的流程");
				}
				for(BaseSystemProcess bean : list) {
					testByProcessId(bean.getProcessId());
				}
				updateThreadTask(StaticUtils.THREAD_TASK_MANAGE_STATUS_2, null);
			}else {
				String[] ids = processId.split(",");
				for(String id : ids) {
					testByProcessId(BaseHelpUtils.getIntValue(id));
				}
				updateThreadTask(StaticUtils.THREAD_TASK_MANAGE_STATUS_2, null);
			}
		}catch(Exception e) {
			e.printStackTrace();
			try {
				updateThreadTask(StaticUtils.THREAD_TASK_MANAGE_STATUS_3, e.getMessage());
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void testByProcessId(int processId) throws Exception{
		if(processId <= 0) {
			updateThreadTask(StaticUtils.THREAD_TASK_MANAGE_STATUS_3, "流程ID为空");
		}
		SystemProcess spDao = new SystemProcess();
		spDao.setProcessId(processId);
		if(!spDao.load()) {
			saveProcessorTestResult(null, processId, null, "无法获取流程相关信息");
		}
		Map map = new HashMap<>();
		Map<String, Integer> processInfoMap = new HashMap<>();
		processInfoMap.put("processId", processId);
		map.put("processDefinition", processInfoMap);
		SystemProcessDepartment spdDao = new SystemProcessDepartment();
		spdDao.setConditionProcessId("=", processId);
		List<BaseSystemProcessDepartment> spdList = spdDao.conditionalLoad();
		if(null == spdList || spdList.isEmpty()) {
			saveProcessorTestResult(null, processId, null, "没有部门使用这个流程，无需测试");
		}
		NewCreateWorkFlow createWorkFlow = new NewCreateWorkFlow();
		BaseCollection<BaseSystemProcessInstance> bc = new BaseCollection<>();
		for(BaseSystemProcessDepartment spdBean : spdList) {
			Employee eDao = new Employee();
			eDao.setConditionDepartmentId("=", spdBean.getDepartmentId());
			eDao.setConditionStatus("=", StaticUtils.EMPLOYEE_NORMAL);
			eDao.setConditionEmployeeId(">", 0);
			eDao.setConditionCompanyId(">=", 0);
			eDao.unsetSelectFlags();
			eDao.setSelectEmployeeId(true);
			eDao.setSelectCompanyId(true);
			eDao.setSelectDepartmentId(true);
			eDao.setSelectPlateId(true);
			eDao.setSelectEmployeeNo(true);
			BaseEmployee eBean = eDao.executeQueryOneRow();
			if(null == eBean)
				continue;
			map.remove("userData");
			switch(spDao.getProcessTypeId()) {
			case StaticUtils.PROCESS_TYPE_2:
			case StaticUtils.PROCESS_TYPE_3:
			case StaticUtils.PROCESS_TYPE_8:
			case StaticUtils.PROCESS_TYPE_10:
				//日常报销
				normalReimbursement(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_4:
			case StaticUtils.PROCESS_TYPE_5:
			case StaticUtils.PROCESS_TYPE_9:
				//差旅报销
				travelReimbursement(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_6:
				//借款申请
				borrowMoneyApply(map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_7:
				//预付款申请
				payMoneyApply(map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_28:
				//员工还款申请
			case StaticUtils.PROCESS_TYPE_41:
				//外部公司还款申请
				employeeRepaymentApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_33:
				//用车申请
				carsApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_34:
				//名片申请
				businessCardApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_35:
				//刻章申请
				stampCarvingApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_36:
				//采购申请
			case StaticUtils.PROCESS_TYPE_31:
				//物品申请
				purchaseApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_40:
				//网络权限
				networkPrivileges(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_24:
				//入职申请
				Department depDao = new Department();
				depDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
				depDao.unsetSelectFlags();
				depDao.setSelectDepartmentId(true);
				depDao.setSelectPlateId(true);
				List<BaseDepartment> depList = depDao.conditionalLoad();
				for(BaseDepartment depBean : depList) {
					employeeOnboardApply(spDao.getProcessTypeId(), map, eBean, depBean);
					if(!map.containsKey("userData")) {
						continue;
					}
					String testData = MapUtils.toJSON(map);
					ProcessorTestResult testResultDao = generateProcessorTestResult(eBean, processId, testData, null);
					ThreadConnection.beginTransaction();
					try {
						System.out.println("测试数据如下：");
						System.out.println(MapUtils.toJSON(map));
						bc.setDataFromJSON(ProcessInstance.newInstance(), createWorkFlow.execute(MapUtils.toJSON(map), eBean.getEmployeeId(), false));
						if(bc.getMessage().equals("success")) {
							testResultDao.setTestResult(StaticUtils.PROCESSOR_TEST_RESULT_1);
						}else {
							testResultDao.setTestResult(StaticUtils.PROCESSOR_TEST_RESULT_2);
							testResultDao.setErrorMsg(bc.getMessage());
						}
					}catch(Exception e) {
						e.printStackTrace();
						testResultDao.setTestResult(StaticUtils.PROCESSOR_TEST_RESULT_2);
						testResultDao.setErrorMsg(e.getMessage());
					}
					ThreadConnection.rollback();
					testResultDao.setEndTime(new Date());
					testResultDao.save();
				}
				map.remove("userData");
				break;
			case StaticUtils.PROCESS_TYPE_26:
				//转岗申请
				applyForTransfer(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_25:
				//离职申请
				resignationApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_29:
				//转正申请
				regularEmployeeApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_30:
				//调薪申请
				salaryAdjustmentApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_37:
				//薪资发放申请
				payrollApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_45:
				//工资异常申请
				salaryExceptions(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_13:
				// 请假申请
				leaveApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_15:
				// 打卡申请
				fillCheckApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_16:
				// 外出申请
				stayAwayApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_17:
				// 加班申请
				overTimeApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_18:
				// 项目出差申请
			case StaticUtils.PROCESS_TYPE_19:
				// 出差延期申请
			case StaticUtils.PROCESS_TYPE_20:
				// 出差更改行程申请
				businessProjectTripApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_21:
				//项目派驻申请
			case StaticUtils.PROCESS_TYPE_22:
				//项目派驻延期申请
			case StaticUtils.PROCESS_TYPE_23:
				//项目派驻确认申请
				projectAccreditApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_14:
				//非项目出差申请
				businessTripApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_39:
				//成本调节
				costAllocation(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_42:
				//项目报备
				preProjectReport(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_43:
				//前期项目立项
				beProjectApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_44:
				//前期项目关闭
				closeProjectApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_46:
				//前期项目转单
				preProjectTransferRecord(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_27:
				//确认函申请
				attachmentApply(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_51:
				//订单跨阶段评审流程
				projectStageAudit(spDao.getProcessTypeId(), map, eBean);
				break;
			case StaticUtils.PROCESS_TYPE_52:
				//预算单立项
				budgetManagement(map, eBean);
				break;
//			case StaticUtils.PROCESS_TYPE_54:
//				//预算附件审批
//				attachmentApproval(map, eBean);
//				break;
			default:
				break;
			}
			if(!map.containsKey("userData")) {
				continue;
			}
			String testData = MapUtils.toJSON(map);
			ProcessorTestResult testResultDao = generateProcessorTestResult(eBean, processId, testData, null);
			ThreadConnection.beginTransaction();
			try {
				System.out.println("测试数据如下：");
				System.out.println(MapUtils.toJSON(map));
				bc.setDataFromJSON(ProcessInstance.newInstance(), createWorkFlow.execute(testData, eBean.getEmployeeId(), false));
				if(bc.getMessage().equals("success")) {
					testResultDao.setTestResult(StaticUtils.PROCESSOR_TEST_RESULT_1);
				}else {
					testResultDao.setTestResult(StaticUtils.PROCESSOR_TEST_RESULT_2);
					testResultDao.setErrorMsg(bc.getMessage());
				}
				testResultDao.setEndTime(new Date());
			}catch(Exception e) {
				e.printStackTrace();
				testResultDao.setTestResult(StaticUtils.PROCESSOR_TEST_RESULT_2);
				testResultDao.setErrorMsg(e.getMessage());
				testResultDao.setEndTime(new Date());
			}
			ThreadConnection.rollback();
			testResultDao.save();
		}
	}
	
	public void normalReimbursement(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = new HashMap<>();
		userData.put("applyEmployeeId", eBean.getEmployeeId());
		userData.put("employeeId", eBean.getEmployeeId());
		BigDecimal amount = BaseHelpUtils.getBigDecimalValue(Math.random() * 50000 + 1).setScale(2, BigDecimal.ROUND_DOWN);
		userData.put("reimbursementName", "主题");
		userData.put("amount", amount);
		userData.put("companyId", eBean.getCompanyId());
		userData.put("remark", "备注");
		List<BaseProjectNormalReimbursementDetail> detailList = new ArrayList<>();
		BaseProjectNormalReimbursementDetail detailBean = new BaseProjectNormalReimbursementDetail();
		detailBean.setAmount(amount);
		detailList.add(detailBean);
		userData.put("detailProjectNormalReimbursementDetail", detailList);
		switch(processType) {
		case StaticUtils.PROCESS_TYPE_2:
			List<BaseNormalReimbursementLinkProject> projectList = new ArrayList<>();
			List<BaseProject> pList = randomProject(3);
			int pSize = pList.size();
			if(pSize > 0) {
				BigDecimal avgAmount = null;
				if(pSize > 1) {
					avgAmount = amount.divide(new BigDecimal(pSize), 2, BigDecimal.ROUND_DOWN);
				}
				for(int i = 0; i < pSize; i++) {
					BaseNormalReimbursementLinkProject projectBean = new BaseNormalReimbursementLinkProject();
					if(pSize == 1) {
						projectBean.setAmount(amount);
					}else {
						if(i == pSize - 1)
							projectBean.setAmount(amount.subtract(avgAmount.multiply(new BigDecimal(pSize - 1))));
						else
							projectBean.setAmount(avgAmount);
					}
					projectBean.setProjectId(pList.get(i).getProjectId());
					projectList.add(projectBean);
				}
			}
			userData.put("detailNormalReimbursementLinkProject", projectList);
			break;
		case StaticUtils.PROCESS_TYPE_3:
		case StaticUtils.PROCESS_TYPE_10:
			List<BaseNormalReimbursementLinkDepartment> departmentList = new ArrayList<>();
			BaseNormalReimbursementLinkDepartment departmentBean = new BaseNormalReimbursementLinkDepartment();
			departmentBean.setAmount(amount);
			departmentBean.setDepartmentId(eBean.getDepartmentId());
			departmentList.add(departmentBean);
			userData.put("detailNormalReimbursementLinkDepartment", departmentList);
			break;
		case StaticUtils.PROCESS_TYPE_8:
			List<BaseNormalReimbursementLinkMainProject> preProjectList = new ArrayList<>();
			List<BasePreProjectReimbursementNumber> prePList = randomPreProject(3);
			int prePSize = prePList.size();
			if(prePSize > 0) {
				BigDecimal avgAmount = null;
				if(prePSize > 1) {
					avgAmount = amount.divide(new BigDecimal(prePSize), 2, BigDecimal.ROUND_DOWN);
				}
				for(int i = 0; i < prePSize; i++) {
					BaseNormalReimbursementLinkMainProject preProjectBean = new BaseNormalReimbursementLinkMainProject();
					if(prePSize == 1) {
						preProjectBean.setAmount(amount);
					}else {
						if(i == prePSize - 1)
							preProjectBean.setAmount(amount.subtract(avgAmount.multiply(new BigDecimal(prePSize - 1))));
						else
							preProjectBean.setAmount(avgAmount);
					}
					preProjectBean.setMainProjectId(prePList.get(i).getPreProjectReimbursementNumberId());
					preProjectList.add(preProjectBean);
				}
			}
			userData.put("detailNormalReimbursementLinkMainProject", preProjectList);
			userData.put("projectManager", eBean.getEmployeeId());
			break;
		}
		map.put("userData", userData);
	}
	
	public void travelReimbursement(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = new HashMap<>();
		userData.put("drafter", eBean.getEmployeeId());
		userData.put("applicant", eBean.getEmployeeId());
		BigDecimal amount = BaseHelpUtils.getBigDecimalValue(Math.random() * 50000 + 1).setScale(2, BigDecimal.ROUND_DOWN);
		userData.put("title", "主题");
		userData.put("amount", amount);
		userData.put("companyId", eBean.getCompanyId());
		userData.put("remark", "备注");
		Calendar c = Calendar.getInstance();
		userData.put("startDate", c.getTime());
		c.set(Calendar.DATE, c.get(Calendar.DATE) + BaseHelpUtils.getIntValue(Math.random() * 10) + 1);
		userData.put("endDate", c.getTime());
		List<BaseTravelReimbursementDetail> detailList = new ArrayList<>();
		BaseTravelReimbursementDetail detailBean = new BaseTravelReimbursementDetail();
		detailBean.setSum(amount);
		detailList.add(detailBean);
		userData.put("detailTravelReimbursementDetail", detailList);
		switch(processType) {
		case StaticUtils.PROCESS_TYPE_4:
			List<BaseTravelReimbursementLinkProject> projectList = new ArrayList<>();
			List<BaseProject> pList = randomProject(3);
			int pSize = pList.size();
			if(pSize > 0) {
				BigDecimal avgAmount = null;
				if(pSize > 1) {
					avgAmount = amount.divide(new BigDecimal(pSize), 2, BigDecimal.ROUND_DOWN);
				}
				for(int i = 0; i < pSize; i++) {
					BaseTravelReimbursementLinkProject projectBean = new BaseTravelReimbursementLinkProject();
					if(pSize == 1) {
						projectBean.setAmount(amount);
					}else {
						if(i == pSize - 1)
							projectBean.setAmount(amount.subtract(avgAmount.multiply(new BigDecimal(pSize - 1))));
						else
							projectBean.setAmount(avgAmount);
					}
					projectBean.setProjectId(pList.get(i).getProjectId());
					projectList.add(projectBean);
				}
			}
			userData.put("detailTravelReimbursementLinkProject", projectList);
			break;
		case StaticUtils.PROCESS_TYPE_5:
			List<BaseTravelReimbursementLinkDepartment> departmentList = new ArrayList<>();
			BaseTravelReimbursementLinkDepartment departmentBean = new BaseTravelReimbursementLinkDepartment();
			departmentBean.setAmount(amount);
			departmentBean.setDepartmentId(eBean.getDepartmentId());
			departmentList.add(departmentBean);
			userData.put("detailTravelReimbursementLinkDepartment", departmentList);
			break;
		case StaticUtils.PROCESS_TYPE_9:
			List<BaseTravelReimbursementLinkMainProject> preProjectList = new ArrayList<>();
			List<BasePreProjectReimbursementNumber> prePList = randomPreProject(3);
			int prePSize = prePList.size();
			if(prePSize > 0) {
				BigDecimal avgAmount = null;
				if(prePSize > 1) {
					avgAmount = amount.divide(new BigDecimal(prePSize), 2, BigDecimal.ROUND_DOWN);
				}
				for(int i = 0; i < prePSize; i++) {
					BaseTravelReimbursementLinkMainProject preProjectBean = new BaseTravelReimbursementLinkMainProject();
					if(prePSize == 1) {
						preProjectBean.setAmount(amount);
					}else {
						if(i == prePSize - 1)
							preProjectBean.setAmount(amount.subtract(avgAmount.multiply(new BigDecimal(prePSize - 1))));
						else
							preProjectBean.setAmount(avgAmount);
					}
					preProjectBean.setMainProjectId(prePList.get(i).getPreProjectReimbursementNumberId());
					preProjectList.add(preProjectBean);
				}
			}
			userData.put("detailTravelReimbursementLinkMainProject", preProjectList);
			userData.put("projectManager", eBean.getEmployeeId());
			break;
		}
		map.put("userData", userData);
	}
	
	public void borrowMoneyApply(Map map, BaseEmployee eBean) throws Exception{
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = new HashMap<>();
		userData.put("operateEmployeeId", eBean.getEmployeeId());
		userData.put("employeeId", eBean.getEmployeeId());
		BigDecimal amount = BaseHelpUtils.getBigDecimalValue(Math.random() * 50000 + 1).setScale(2, BigDecimal.ROUND_DOWN);
		userData.put("titleName", "主题");
		userData.put("borrowMoney", amount);
		userData.put("companyId", eBean.getCompanyId());
		userData.put("departmentId", eBean.getDepartmentId());
		userData.put("borrowDate", new Date());
		userData.put("reason", "借款事由");
		userData.put("falg", StaticUtils.BORROW_MONEY);
		map.put("userData", userData);
	}
	
	/**
	 * 生成预付款申请业务数据
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void payMoneyApply(Map map, BaseEmployee eBean) throws Exception{
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = new HashMap<>();
		userData.put("operateEmployeeId", eBean.getEmployeeId());
		userData.put("employeeId", eBean.getEmployeeId());
		BigDecimal amount = BaseHelpUtils.getBigDecimalValue(Math.random() * 50000 + 1).setScale(2, BigDecimal.ROUND_DOWN);
		userData.put("titleName", "主题");
		userData.put("payAmount", amount);
		userData.put("companyId", eBean.getCompanyId());
		userData.put("departmentId", eBean.getDepartmentId());
		userData.put("reason", "付款原因");
		map.put("userData", userData);
	}
	
	/**
	 * 生成【员工还款申请/外部公司还款申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void employeeRepaymentApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, false);
		BigDecimal amount = BaseHelpUtils.getBigDecimalValue(Math.random() * 50000 + 1).setScale(2, BigDecimal.ROUND_DOWN);
		userData.put("fee", amount);
		map.put("userData", userData);
	}
	
	/**
	 * 生成【用车申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void carsApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, false);
		userData.put("card", "13111111111");
		userData.put("type", 1);
		userData.put("unit", "同行人数");
		userData.put("address", "申请用车车型");
		userData.put("projectName", "出发地");
		userData.put("projectCode", "目的地");
		userData.put("reason", "用车目的");
		int detailType = BaseHelpUtils.getIntValue(Math.random()*3 + 1);
		userData.put("startDateDetail", detailType);
		BigDecimal amount = BaseHelpUtils.getBigDecimalValue(Math.random() * 1000 + 1).setScale(2, BigDecimal.ROUND_DOWN);
		userData.put("livingExpenses", amount);
		userData.put("fee", amount);
		List<BaseCarCostAllocation> list = new ArrayList<>();
		switch(detailType) {
		case StaticUtils.PROJECT_USE_CAR:
			List<BaseProject> pList = randomProject(3);
			int pSize = pList.size();
			if(pSize > 0) {
				BigDecimal avgAmount = null;
				if(pSize > 1) {
					avgAmount = amount.divide(new BigDecimal(pSize), 2, BigDecimal.ROUND_DOWN);
				}
				for(int i = 0; i < pSize; i++) {
					BaseCarCostAllocation costAllocation = new BaseCarCostAllocation();
					if(pSize == 1) {
						costAllocation.setCostAllocation(amount);
					}else {
						if(i == pSize - 1)
							costAllocation.setCostAllocation(amount.subtract(avgAmount.multiply(new BigDecimal(pSize - 1))));
						else
							costAllocation.setCostAllocation(avgAmount);
					}
					costAllocation.setType(StaticUtils.PROJECT_USE_CAR);
					costAllocation.setId(pList.get(i).getProjectId());
					costAllocation.setCost(amount);
					list.add(costAllocation);
				}
			}
			break;
		case StaticUtils.PRE_PROJECT_USE_CAR:
			userData.put("nextAuditor", eBean.getEmployeeId());
			List<BasePreProjectReimbursementNumber> prePList = randomPreProject(3);
			int prePSize = prePList.size();
			if(prePSize > 0) {
				BigDecimal avgAmount = null;
				if(prePSize > 1) {
					avgAmount = amount.divide(new BigDecimal(prePSize), 2, BigDecimal.ROUND_DOWN);
				}
				for(int i = 0; i < prePSize; i++) {
					BaseCarCostAllocation costAllocation = new BaseCarCostAllocation();
					if(prePSize == 1) {
						costAllocation.setCostAllocation(amount);
					}else {
						if(i == prePSize - 1)
							costAllocation.setCostAllocation(amount.subtract(avgAmount.multiply(new BigDecimal(prePSize - 1))));
						else
							costAllocation.setCostAllocation(avgAmount);
					}
					costAllocation.setType(StaticUtils.PRE_PROJECT_USE_CAR);
					costAllocation.setId(prePList.get(i).getPreProjectReimbursementNumberId());
					costAllocation.setCost(amount);
					list.add(costAllocation);
				}
			}
			break;
		case StaticUtils.DEPARTMENT_USE_CAR:
			BaseCarCostAllocation costAllocation = new BaseCarCostAllocation();
			costAllocation.setType(StaticUtils.DEPARTMENT_USE_CAR);
			costAllocation.setId(eBean.getDepartmentId());
			costAllocation.setCost(amount);
			costAllocation.setCostAllocation(amount);
			list.add(costAllocation);
			break;
		}
		userData.put("detailCarCostAllocation", list);
		map.put("userData", userData);
	}
	
	/**
	 * 生成【名片申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void businessCardApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, false);
		userData.put("card", "13111111111");
		userData.put("plan", "职位");
		userData.put("unit", "英文名称");
		userData.put("address", "邮箱");
		userData.put("projectName", "传真机号码");
		userData.put("projectCode", "座机号码");
		userData.put("reason", "申请原因");
		map.put("userData", userData);
	}
	
	/**
	 * 生成【刻章申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void stampCarvingApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, false);
		userData.put("subType", "印章尺寸");
		userData.put("subTypeStr", "印章形状");
		userData.put("address", "印章种类");
		userData.put("projectName", "刻章字样");
		userData.put("projectCode", "刻章内容");
		userData.put("reason", "申请原因");
		map.put("userData", userData);
	}
	
	/**
	 * 生成【采购申请/物品申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void purchaseApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, false);
		BigDecimal amount = BaseHelpUtils.getBigDecimalValue(Math.random() * 50000 + 1).setScale(2, BigDecimal.ROUND_DOWN);
		userData.put("fee", amount);
		userData.put("reason", "申请缘由");
		BasePersonnelBusinessLinkEquipment detailBean = new BasePersonnelBusinessLinkEquipment();
		detailBean.setTotalPrice(amount);
		List<BasePersonnelBusinessLinkEquipment> list = new ArrayList<>();
		list.add(detailBean);
		userData.put("detailPersonnelBusinessLinkEquipment", list);
		map.put("userData", userData);
	}
	
	/**
	 * 生成【网络权限申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void networkPrivileges(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, false);
		userData.put("subType", 1);
		userData.put("reason", "申请缘由");
		map.put("userData", userData);
	}
	
	/**
	 * 生成【入职申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean	发起人
	 * @param depBean 入职员工所在部门
	 * @throws Exception
	 */
	public void employeeOnboardApply(Integer processType, Map map, BaseEmployee eBean, BaseDepartment depBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = new HashMap<>();
		String code = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
		userData.put(StaticUtils.TEST_PROCESSOR, true);
		userData.put("employeeNo", code);
		userData.put("employeeName", code);
		userData.put("mobile", code);
		userData.put("departmentId", depBean.getDepartmentId());
		userData.put("plateId", depBean.getPlateId());
		userData.put("ownedCompany", eBean.getCompanyId());
		userData.put("companyEmail", code + "@jaid.cn");
		map.put("userData", userData);
	}
	
	/**
	 * 生成【转岗申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void applyForTransfer(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, true);
		userData.put("oriCompanyId", eBean.getCompanyId());
		userData.put("parentId", eBean.getPlateId());
		userData.put("nextAuditor", eBean.getEmployeeId());
		map.put("userData", userData);
	}
	
	/**
	 * 生成【离职申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void resignationApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, true);
		userData.put("type", BaseHelpUtils.getIntValue(Math.random() * 2) + 1);
		userData.put("reason", "申请缘由");
		map.put("userData", userData);
	}
	
	/**
	 * 生成【转正申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void regularEmployeeApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, true);
		userData.put("type", BaseHelpUtils.getIntValue(Math.random() * 2) + 1);
		map.put("userData", userData);
	}
	
	/**
	 * 生成【调薪申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void salaryAdjustmentApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, true);
		BigDecimal amount = BaseHelpUtils.getBigDecimalValue(Math.random() * 1000 + 1).setScale(2, BigDecimal.ROUND_DOWN);
		userData.put("severance", amount);
		userData.put("monthPay", amount.add(amount));
		map.put("userData", userData);
	}
	
	/**
	 * 生成【薪资发放申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void payrollApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, true);
		userData.put("type", BaseHelpUtils.getIntValue(Math.random() * 3 + 1));
		userData.put("companyProvince", DateUtil.getYear());
		userData.put("targetProvince", DateUtil.getMonth() - 2);
		map.put("userData", userData);
	}
	
	/**
	 * 生成【工资异常申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void salaryExceptions(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, true);
		map.put("userData", userData);
	}
	
	/**
	 * 生成【请假申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void leaveApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, true);
		LeaveType ltDao = new LeaveType();
		ltDao.setConditionParentId("=", 0);
		ltDao.unsetSelectFlags();
		ltDao.setSelectLeaveTypeId(true);
		BaseLeaveType ltBean = ltDao.executeQueryOneRow("order by random()");
		userData.put("type", ltBean.getLeaveTypeId());
		userData.put("reason", "申请缘由");
		map.put("userData", userData);
	}
	
	/**
	 * 生成【打卡申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void fillCheckApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, true);
		userData.put("type", BaseHelpUtils.getIntValue(Math.random() * 2));
		userData.put("reason", "申请缘由");
		userData.put("nextAuditor", eBean.getEmployeeId());
		map.put("userData", userData);
	}
	
	/**
	 * 生成【外出申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void stayAwayApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, true);
		int type = BaseHelpUtils.getIntValue(Math.random() * 3 + 1);
		userData.put("projectType", type);
		if(type == StaticUtils.STAY_AWAY_APPLY_TYPE_1) {
			List<BaseProject> pList = randomProject(1);
			if(null != pList && !pList.isEmpty()) {
				BaseProject pBean = pList.get(0);
				userData.put("projectId", pBean.getProjectId());
				userData.put("projectCode", pBean.getContractCode());
				userData.put("projectName", pBean.getProjectName());
			}
		}else if(type == StaticUtils.STAY_AWAY_APPLY_TYPE_2) {
			List<BasePreProjectReimbursementNumber> pList = randomPreProject(1);
			if(null != pList && !pList.isEmpty()) {
				BasePreProjectReimbursementNumber pBean = pList.get(0);
				userData.put("projectId", pBean.getPreProjectReimbursementNumberId());
				userData.put("projectCode", BaseHelpUtils.getString(pBean.getPreProjectReimbursementNumberId()));
				userData.put("projectName", BaseHelpUtils.getString(pBean.getPreProjectReimbursementNumberId()));
			}
		}
		userData.put("days", 1);
		userData.put("reason", "申请缘由");
		userData.put("nextAuditor", eBean.getEmployeeId());
		map.put("userData", userData);
	}
	
	/**
	 * 生成【加班申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void overTimeApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, true);
		int type = BaseHelpUtils.getIntValue(Math.random() * 3 + 1);
		userData.put("projectType", type);
		if(type == StaticUtils.OVER_TIME_APPLY_TYPE_1) {
			List<BaseProject> pList = randomProject(1);
			if(null != pList && !pList.isEmpty()) {
				BaseProject pBean = pList.get(0);
				userData.put("projectId", pBean.getProjectId());
				userData.put("projectCode", pBean.getContractCode());
				userData.put("projectName", pBean.getProjectName());
			}
		}else if(type == StaticUtils.OVER_TIME_APPLY_TYPE_2) {
			List<BasePreProjectReimbursementNumber> pList = randomPreProject(1);
			if(null != pList && !pList.isEmpty()) {
				BasePreProjectReimbursementNumber pBean = pList.get(0);
				userData.put("projectId", pBean.getPreProjectReimbursementNumberId());
				userData.put("projectCode", BaseHelpUtils.getString(pBean.getPreProjectReimbursementNumberId()));
				userData.put("projectName", BaseHelpUtils.getString(pBean.getPreProjectReimbursementNumberId()));
			}
		}
		userData.put("hours", 1);
		userData.put("reason", "申请缘由");
		userData.put("nextAuditor", eBean.getEmployeeId());
		map.put("userData", userData);
	}
	
	/**
	 * 生成【项目出差申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void businessProjectTripApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, false);
		Calendar c = Calendar.getInstance();
		userData.put("startDate", c.getTime());
		int days = BaseHelpUtils.getIntValue(Math.random() * 10) + 1;
		c.set(Calendar.DATE, c.get(Calendar.DATE) + days);
		userData.put("endDate", c.getTime());
		userData.put("days", days);
		userData.put("address", "出差地址");
		userData.put("transportation", "交通工具");
		userData.put("plan", "行程安排");
		int type = BaseHelpUtils.getIntValue(Math.random() * 2 + 1);
		userData.put("projectType", type);
		if(type == StaticUtils.BUSINESS_PROJECT_TRIP_APPLY_TYPE_1) {
			List<BaseProject> pList = randomProject(1);
			if(null != pList && !pList.isEmpty()) {
				BaseProject pBean = pList.get(0);
				userData.put("projectId", pBean.getProjectId());
				userData.put("projectCode", pBean.getContractCode());
				userData.put("projectName", pBean.getProjectName());
			}
		}else if(type == StaticUtils.BUSINESS_PROJECT_TRIP_APPLY_TYPE_2) {
			List<BasePreProjectReimbursementNumber> pList = randomPreProject(1);
			if(null != pList && !pList.isEmpty()) {
				BasePreProjectReimbursementNumber pBean = pList.get(0);
				userData.put("projectId", pBean.getPreProjectReimbursementNumberId());
				userData.put("projectCode", BaseHelpUtils.getString(pBean.getPreProjectReimbursementNumberId()));
				userData.put("projectName", BaseHelpUtils.getString(pBean.getPreProjectReimbursementNumberId()));
			}
		}
		userData.put("reason", "申请缘由");
		userData.put("nextAuditor", eBean.getEmployeeId());
		map.put("userData", userData);
	}
	
	/**
	 * 生成【项目派驻申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void projectAccreditApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, false);
		Calendar c = Calendar.getInstance();
		userData.put("startDate", c.getTime());
		int days = BaseHelpUtils.getIntValue(Math.random() * 10) + 1;
		c.set(Calendar.DATE, c.get(Calendar.DATE) + days);
		userData.put("endDate", c.getTime());
		userData.put("days", days);
		List<BaseProject> pList = randomProject(1);
		if(null != pList && !pList.isEmpty()) {
			BaseProject pBean = pList.get(0);
			userData.put("projectId", pBean.getProjectId());
			userData.put("projectCode", pBean.getContractCode());
			userData.put("projectName", pBean.getProjectName());
		}
		userData.put("nextAuditor", eBean.getEmployeeId());
		userData.put("contactPerson", "派驻项目甲方名称");
		userData.put("address", "驻场地址");
		map.put("userData", userData);
	}
	
	/**
	 * 生成【非项目出差申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void businessTripApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, false);
		Calendar c = Calendar.getInstance();
		userData.put("startDate", c.getTime());
		int days = BaseHelpUtils.getIntValue(Math.random() * 10) + 1;
		c.set(Calendar.DATE, c.get(Calendar.DATE) + days);
		userData.put("endDate", c.getTime());
		userData.put("days", days);
		userData.put("nextAuditor", eBean.getEmployeeId());
		userData.put("transportation", "交通工具");
		userData.put("address", "出差地址");
		userData.put("reason", "申请缘由");
		userData.put("plan", "行程安排");
		map.put("userData", userData);
	}
	
	/**
	 * 生成【成本调节】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void costAllocation(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = new HashMap<>();
		userData.put("drafter", eBean.getEmployeeId());
		BigDecimal amount = BaseHelpUtils.getBigDecimalValue(Math.random() * 50000 + 1).setScale(2, BigDecimal.ROUND_DOWN);
		userData.put("cost", amount);
		List<BaseCostAllocation> detailList = new ArrayList<>();
		int type = BaseHelpUtils.getIntValue(Math.random() * 2);
		if(type == 0) {
			List<BaseProject> pList = randomProject(3);
			if(null != pList && !pList.isEmpty()) {
				int size = pList.size();
				BigDecimal avgAmount = amount.divide(new BigDecimal(size), 2, BigDecimal.ROUND_DOWN);
				for(int i = 0; i < size; i++) {
					BaseCostAllocation costBean = new BaseCostAllocation();
					costBean.setType(StaticUtils.PROJECT_COST);
					BaseProject pBean = pList.get(i);
					costBean.setId(pBean.getProjectId());
					costBean.setCode(pBean.getContractCode());
					costBean.setName(pBean.getProjectName());
					if(i == size - 1) {
						costBean.setCost(amount.subtract(avgAmount.multiply(new BigDecimal(size - 1))));
					}else {
						costBean.setCost(avgAmount);
					}
					detailList.add(costBean);
				}
			}
		}else {
			List<BaseDepartment> depList = randomDepartment(3);
			if(null != depList && !depList.isEmpty()) {
				int size = depList.size();
				BigDecimal avgAmount = amount.divide(new BigDecimal(size), 2, BigDecimal.ROUND_DOWN);
				for(int i = 0; i < size; i++) {
					BaseCostAllocation costBean = new BaseCostAllocation();
					costBean.setType(StaticUtils.DEPARTMENT_COST);
					costBean.setId(depList.get(i).getDepartmentId());
					costBean.setName(depList.get(i).getDepartmentName());
					if(i == size - 1) {
						costBean.setCost(amount.subtract(avgAmount.multiply(new BigDecimal(size - 1))));
					}else {
						costBean.setCost(avgAmount);
					}
					detailList.add(costBean);
				}
			}
		}
		userData.put("detailCostAllocation", detailList);
		map.put("userData", userData);
	}
	
	/**
	 * 生成【项目报备】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void preProjectReport(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = new HashMap<>();
		userData.put(StaticUtils.TEST_PROCESSOR, true);
		userData.put("applyEmployeeId", eBean.getEmployeeId());
		userData.put("customerName", "客户名称");
		userData.put("projectName", "项目名称");
		userData.put("province", "省份");
		userData.put("city", "城市");
		userData.put("detailAddress", "详细地址");
		userData.put("contactName", "联系人");
		userData.put("grade", "职位");
		userData.put("contactPhone", "联系电话");
		ConditiongetEmployeeIdByRoleId condition = new ConditiongetEmployeeIdByRoleId();
		condition.setRoleId(StaticUtils.ROLE_PROJECT_LEADER);
		QuerygetEmployeeIdByRoleId query = new QuerygetEmployeeIdByRoleId();
		BaseCollection<BasegetEmployeeIdByRoleId> bc = query.executeQuery(null, condition);
		if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
			BasegetEmployeeIdByRoleId bean = bc.getCollections().get(0);
			userData.put("ourEmployees", "[" + bean.getEmployeeId() + "]");
			userData.put("ourEmployeesName", bean.getEmployeeName());
		}
		map.put("userData", userData);
	}
	
	/**
	 * 生成【前期项目立项】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void beProjectApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = new HashMap<>();
		userData.put(StaticUtils.TEST_PROCESSOR, true);
		userData.put("applyEmployeeId", eBean.getEmployeeId());
		userData.put("activityId", eBean.getEmployeeId());
		userData.put("customerName", "客户名称");
		userData.put("projectName", "项目名称");
		userData.put("province", "省份");
		userData.put("city", "城市");
		userData.put("detailAddress", "详细地址");
		userData.put("contactName", "联系人");
		userData.put("grade", "职位");
		userData.put("contactPhone", "联系电话");
		SystemDictionary dicDao = new SystemDictionary();
		dicDao.setConditionDicTypeId("=", StaticUtils.SYSTEM_DICTIONARY_PROJECT_BASE_ON);
		BaseSystemDictionary dicBean = dicDao.executeQueryOneRow("order by random()");
		userData.put("projectBaseOn", dicBean.getDicTypeValueId());
		//项目营销专员
		List<BaseMainProjectEmployee> salePersonList = new ArrayList<>();
		BaseMainProjectEmployee salePersonBean = new BaseMainProjectEmployee();
		salePersonBean.setEmployeeId(eBean.getEmployeeId());
		salePersonBean.setMainAndAssistance(1);
		salePersonList.add(salePersonBean);
		userData.put("salePersonReocrd", salePersonList);
		//运营董事
		List<BaseMainProjectEmployee> saleLeaderList = new ArrayList<>();
		BaseMainProjectEmployee saleLeaderBean = new BaseMainProjectEmployee();
		saleLeaderBean.setEmployeeId(eBean.getEmployeeId());
		saleLeaderList.add(saleLeaderBean);
		userData.put("saleLeaderReocrd", saleLeaderList);
		//项目经理
		List<BaseMainProjectEmployee> projectManageList = new ArrayList<>();
		BaseMainProjectEmployee projectManageBean = new BaseMainProjectEmployee();
		projectManageBean.setEmployeeId(eBean.getEmployeeId());
		projectManageList.add(projectManageBean);
		userData.put("projectManageReocrd", projectManageList);
		//项目主管领导
		List<BaseMainProjectEmployee> projectLeaderList = new ArrayList<>();
		BaseMainProjectEmployee projectLeaderBean = new BaseMainProjectEmployee();
		projectLeaderBean.setEmployeeId(eBean.getEmployeeId());
		projectLeaderBean.setIsPlateManager(true);
		projectLeaderList.add(projectLeaderBean);
		userData.put("projectLeaderReocrd", projectLeaderList);
		map.put("userData", userData);
	}

	/**
	 * 生成【前期项目关闭】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void closeProjectApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		PreProject preDao = new PreProject();
		BasePreProject preBean = preDao.executeQueryOneRow("order by random()");
		if(null == preBean) {
			return;
		}
		Map<String, Object> userData = new HashMap<>();
		userData.put(StaticUtils.TEST_PROCESSOR, true);
		userData.put("applyEmployeeId", preBean.getApplyEmployeeId());
		userData.put("status", preBean.getStatus());
		userData.put("preProjectId", preBean.getPreProjectId());
		map.put("userData", userData);
	}
	
	/**
	 * 生成【前期项目转单】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void preProjectTransferRecord(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		PreProject preDao = new PreProject();
		preDao.unsetSelectFlags();
		preDao.setSelectPreProjectId(true);
		preDao.setSelectApplyEmployeeId(true);
		BasePreProject preBean = preDao.executeQueryOneRow("order by random()");
		if(null == preBean) {
			return;
		}
		Map<String, Object> userData = new HashMap<>();
		userData.put(StaticUtils.TEST_PROCESSOR, true);
		userData.put("preProjectId", preBean.getPreProjectId());
		userData.put("employeeId", preBean.getApplyEmployeeId());
		userData.put("operateEmployeeId", eBean.getEmployeeId());
		userData.put("operateTime", new Date());
		Employee eDao = new Employee();
		eDao.unsetSelectFlags();
		eDao.setSelectEmployeeId(true);
		BaseEmployee transferBean = eDao.executeQueryOneRow("order by random()");
		if(null == transferBean || null == transferBean.getEmployeeId()) {
			userData.put("transferEmployeeId", eBean.getEmployeeId());
		}else {
			userData.put("transferEmployeeId", transferBean.getEmployeeId());
		}
		map.put("userData", userData);
	}
	
	/**
	 * 生成【确认函申请】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void attachmentApply(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, false);
		userData.put("days", BaseHelpUtils.getIntValue(Math.random() * 10 + 1));
		map.put("userData", userData);
	}
	
	/**
	 * 生成【订单跨阶段评审流程】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void projectStageAudit(Integer processType, Map map, BaseEmployee eBean) throws Exception{
		if(null == processType) {
			return;
		}
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = generateCommonPersonnelBusinessData(processType, eBean, false);
		List<BaseProject> list = randomProject(1);
		if(null == list || list.isEmpty()) {
			return;
		}
		BaseProject projectBean = list.get(0);
		userData.put("contractId", projectBean.getContractId());
		userData.put("projectId", projectBean.getProjectId());
		userData.put("stageId", BaseHelpUtils.getIntValue(Math.random() * 100 + 1));
		userData.put("contractCode", projectBean.getContractCode());
		userData.put("contractName", projectBean.getContractCode());
		userData.put("sheetCode", projectBean.getContractCode());
		userData.put("sheetName", projectBean.getProjectName());
		userData.put("remark", projectBean.getRemark());
		userData.put("operateEmployeeId", eBean.getEmployeeId());
		userData.put("operateTime", new Date());
		ProjectAttachment paDao = new ProjectAttachment();
		paDao.setConditionIsQualified("=", true);
		BaseProjectAttachment paBean = paDao.executeQueryOneRow("order by random()");
		userData.put("uploadTime", paBean.getUploadTime());
		userData.put("attachmentManageId", paBean.getProjectAttachmentId());
		userData.put("attachmentFile", paBean.getAttachmentFile());
		userData.put("attachmentAddress", "attachmentAddress");
		userData.put("attachmentName", "attachmentName");
		userData.put("attachmentCode", "attachmentCode");
		map.put("userData", userData);
	}
	
	/**
	 * 生成【预算单立项】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void budgetManagement(Map map, BaseEmployee eBean) throws Exception{
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = new HashMap<>();
		userData.put("bdApplyTime", new Date());
		userData.put("bdApplyEmployeeId", eBean.getEmployeeId());
		userData.put("companyId", eBean.getCompanyId());
		SystemDictionary dicDao = new SystemDictionary();
		dicDao.setConditionDicTypeId("=", StaticUtils.SYSTEM_DICTIONARY_BUDGET_TYPE);
		BaseSystemDictionary dicBean = dicDao.executeQueryOneRow("order by random()");
		if(null != dicBean) {
			userData.put("bdType", dicBean.getDicTypeValueId());
		}
		List<BaseProject> pList = randomProject(1);
		if(null == pList || pList.isEmpty()) {
			return;
		}
		BaseProject projectBean = pList.get(0);
		userData.put("projectId", projectBean.getProjectId());
		userData.put("departmentId", projectBean.getPlateId());
		userData.put("signingMoneySum", projectBean.getSheetAmount());
		userData.put("bdRemark", "备注");
		BigDecimal amount = BaseHelpUtils.getBigDecimalValue(Math.random() * 1000 + 1);
		userData.put("bdTotalAmount", amount);
		userData.put("costBearing", "费用承担");
		List<BaseBudgetManagementDetail> detailList = new ArrayList<>();
		BaseBudgetManagementDetail detailBean = new BaseBudgetManagementDetail();
		detailBean.setBddType("预算类别");
		detailBean.setBddAmount(amount);
		detailList.add(detailBean);
		userData.put("detailBudgetManagementDetail", detailList);
		map.put("userData", userData);
	}
	
	/**
	 * 生成【预算附件审批】业务数据
	 * @param processType
	 * @param map
	 * @param eBean
	 * @throws Exception
	 */
	public void attachmentApproval(Map map, BaseEmployee eBean) throws Exception{
		if(null == map) {
			return;
		}
		if(null == eBean) {
			return;
		}
		Map<String, Object> userData = new HashMap<>();
		BudgetAttachment dao = new BudgetAttachment();
		dao.unsetSelectFlags();
		dao.setSelectBudgetAttachmentId(true);
		dao.setSelectBudgetManagementId(true);
		BaseBudgetAttachment bean = dao.executeQueryOneRow("order by random()");
		if(null == bean) {
			return;
		}
		userData.put("budgetManagementId", bean.getBudgetManagementId());
		userData.put("budgetAttachmentId", bean.getBudgetAttachmentId());
		map.put("userData", userData);
	}
	
	/**
	 * 生成PersonnelBusiness实体的基础信息
	 * @param processType
	 * @param eBean
	 * @param needDate true:返回的map中包含startDate和endDate；false则不包含
	 * @return
	 */
	public Map<String, Object> generateCommonPersonnelBusinessData(Integer processType, BaseEmployee eBean, boolean needDate) {
		Map<String, Object> userData = new HashMap<>();
		userData.put(StaticUtils.TEST_PROCESSOR, true);
		userData.put("processType", processType);
		userData.put("drafter", eBean.getEmployeeId());
		userData.put("employeeId", eBean.getEmployeeId());
		userData.put("employeeNo", eBean.getEmployeeNo());
		userData.put("departmentId", eBean.getDepartmentId());
		userData.put("companyId", eBean.getCompanyId());
		if(needDate) {
			Calendar c = Calendar.getInstance();
			userData.put("startDate", c.getTime());
			c.set(Calendar.DATE, c.get(Calendar.DATE) + BaseHelpUtils.getIntValue(Math.random() * 10) + 1);
			userData.put("endDate", c.getTime());
		}
		return userData;
	}
	
	public List<BaseProject> randomProject(int limitNum) throws SQLException{
		Project dao = new Project();
		dao.setConditionProjectManageId(">", 0);
		dao.setConditionDepartmentManagerId(">", 0);
		dao.setConditionPlateManagerId(">", 0);
		dao.unsetSelectFlags();
		dao.setSelectProjectId(true);
		dao.setSelectContractCode(true);
		dao.setSelectProjectName(true);
		dao.setSelectPlateId(true);
		dao.setSelectSheetAmount(true);
		return dao.conditionalLoad("order by random() limit " + limitNum);
	}
	
	public List<BasePreProjectReimbursementNumber> randomPreProject(int limitNum) throws SQLException{
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		dao.unsetSelectFlags();
		dao.setSelectPreProjectReimbursementNumberId(true);
		return dao.conditionalLoad("order by random() limit " + limitNum);
	}
	
	public List<BaseDepartment> randomDepartment(int limitNum) throws SQLException{
		Department dao = new Department();
		dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		dao.unsetSelectFlags();
		dao.setSelectDepartmentId(true);
		dao.setSelectDepartmentName(true);
		return dao.conditionalLoad("order by random() limit " + limitNum);
	}

	public void updateThreadTask(Integer taskStatus, String errorMsg) throws SQLException{
		if(null == threadId) {
			return;
		}
		ThreadTaskManage dao = new ThreadTaskManage();
		dao.setThreadTaskManageId(threadId);
		if(dao.load()) {
			dao.setStatus(taskStatus);
			dao.setErrorMsg(errorMsg);
			dao.setEndTime(new Date());
			dao.update();
		}
	}
	
	public ProcessorTestResult generateProcessorTestResult(BaseEmployee eBean, Integer processId, String testData, String errorMsg) throws SQLException{
		ProcessorTestResult dao = new ProcessorTestResult();
		if(null != eBean) {
			dao.setDrafter(eBean.getEmployeeId());
			dao.setDepartmentId(eBean.getDepartmentId());
			dao.setPlateId(eBean.getPlateId());
			dao.setCompanyId(eBean.getCompanyId());
		}
		dao.setThreadTaskManageId(threadId);
		dao.setProcessId(processId);
		dao.setTestData(testData);
		if(!BaseHelpUtils.isNullOrEmpty(errorMsg)) {
			dao.setTestResult(StaticUtils.PROCESSOR_TEST_RESULT_2);
			dao.setErrorMsg(errorMsg);
		}
		return dao;
	}
	
	public void saveProcessorTestResult(BaseEmployee eBean, Integer processId, String testData, String errorMsg) throws SQLException{
		ProcessorTestResult dao = new ProcessorTestResult();
		if(null != eBean) {
			dao.setDrafter(eBean.getEmployeeId());
			dao.setDepartmentId(eBean.getDepartmentId());
			dao.setPlateId(eBean.getPlateId());
			dao.setCompanyId(eBean.getCompanyId());
		}
		dao.setThreadTaskManageId(threadId);
		dao.setProcessId(processId);
		dao.setTestData(testData);
		if(!BaseHelpUtils.isNullOrEmpty(errorMsg)) {
			dao.setTestResult(StaticUtils.PROCESSOR_TEST_RESULT_2);
			dao.setErrorMsg(errorMsg);
		}
	}
	
	public Integer getThreadId() {
		return threadId;
	}

	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}
	
}
