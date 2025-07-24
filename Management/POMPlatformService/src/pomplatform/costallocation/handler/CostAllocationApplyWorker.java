package pomplatform.costallocation.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.pomplatform.db.bean.BaseCostAllocation;
import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.dao.CostAllocation;
import com.pomplatform.db.dao.PlateAccountRecord;
import com.pomplatform.db.dao.PlateCostRecord;
import com.pomplatform.db.dao.PreProjectReimbursementNumber;
import com.pomplatform.db.dao.ProjectCost;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Department;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.costallocation.bean.BaseResetCostWithC;
import pomplatform.costallocation.dao.ResetCostWithC;
import pomplatform.project.bean.BaseGetProjectManagerByProjectId;
import pomplatform.project.bean.ConditionGetProjectManagerByProjectId;
import pomplatform.project.query.QueryGetProjectManagerByProjectId;
import pomplatform.workflow.commonNormalReimbursement.handler.NormalReimbursementWithDepartmentWorker;

public class CostAllocationApplyWorker implements GenericWorkflowProcessor {

	protected BaseResetCostWithC bean = new BaseResetCostWithC();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		ResetCostWithC dao = new ResetCostWithC();
		dao.setDataFromBase(bean);
		if(Objects.equals(dao.getCostType(), StaticUtils.PROJECT_COST)) {
			//如果是项目成本，要先判断项目成本的状态是否为调节中或已结算，如果是，那么不允许发起本次调节；如果不是，那就将成本的状态设置为调节中
			ProjectCost costDao = new ProjectCost();
			costDao.setConditionProcessInstanceId("=", dao.getProcessInstanceId());
			costDao.setConditionProjectId("=", dao.getId());
			costDao.setConditionAmount("=", dao.getCost());
			BaseProjectCost costBean = costDao.executeQueryOneRow();
			if(null == costBean) {
				throw new Exception("找不到原成本记录，无法发起成本调节");
			}else if(Objects.equals(costBean.getStatus(), StaticUtils.SETTLEMENT_STATUS_YES)) {
				throw new Exception("原成本已结算，无法发起成本调节");
			}else if(Objects.equals(costBean.getStatus(), StaticUtils.SETTLEMENT_STATUS_ADJUSTING)) {
				throw new Exception("原成本已发起成本调节，请不要重复发起");
			}
			costDao.clear();
			costDao.setDataFromBase(costBean);
			costDao.clearModifiedFlags();
			costDao.setStatus(StaticUtils.SETTLEMENT_STATUS_ADJUSTING);
			costDao.update();
		}
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getResetCostId(), "成本调节");
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
		ResetCostWithC dao = new ResetCostWithC();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		if(!bean.getBusinessId().equals(dao.getBusinessId())){
			bean.setBusinessId(null);
		}
		if(!bean.getProcessId().equals(dao.getProcessId())){
			bean.setProcessId(null);
		}
		if(!bean.getProcessType().equals(dao.getProcessType())){
			bean.setProcessType(null);
		}
		if(!bean.getProcessInstanceId().equals(dao.getProcessInstanceId())){
			bean.setProcessInstanceId(null);
		}
		dao.setDataFromBase(bean);
		if(null == dao.getDetailCostAllocation()){
			CostAllocation costDao = new CostAllocation();
			costDao.setConditionResetCostId("=", dao.getResetCostId());
			dao.setDetailCostAllocation(costDao.conditionalLoad());
		}
		dao.update();
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)){
				//流程被驳回，且调节的是项目成本，则需要将项目成本还原为未结算状态
				if(Objects.equals(dao.getCostType(), StaticUtils.PROJECT_COST)) {
					ProjectCost costDao = new ProjectCost();
					costDao.setConditionProcessInstanceId("=", dao.getProcessInstanceId());
					costDao.setConditionProjectId("=", dao.getId());
					costDao.setConditionAmount("=", dao.getCost());
					BaseProjectCost costBean = costDao.executeQueryOneRow();
					if(null == costBean) {
						throw new Exception("找不到原成本记录");
					}
					costDao.clear();
					costDao.setDataFromBase(costBean);
					costDao.clearModifiedFlags();
					costDao.setStatus(StaticUtils.SETTLEMENT_STATUS_NO);
					costDao.update();
				}
			}else if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				//流程正常走完
				//成本归属
				if(Objects.equals(dao.getCostType(), StaticUtils.PROJECT_COST)) {
					ProjectCost costDao = new ProjectCost();
					costDao.setConditionProcessInstanceId("=", dao.getProcessInstanceId());
					costDao.setConditionProjectId("=", dao.getId());
					costDao.setConditionAmount("=", dao.getCost());
					BaseProjectCost costBean = costDao.executeQueryOneRow();
					if(null == costBean) {
						throw new Exception("找不到原成本记录");
					}
					costDao.clear();
					costDao.setDataFromBase(costBean);
					costDao.clearModifiedFlags();
					costDao.setStatus(StaticUtils.SETTLEMENT_STATUS_YES);
					costDao.update();
				}
				if(null != dao.getDetailCostAllocation() && !dao.getDetailCostAllocation().isEmpty()){
					Integer costEmployeeId = dao.getDrafter();
					BigDecimal rate = null == dao.getExchangeRate() ? BigDecimal.ONE : dao.getExchangeRate();
					List<BaseCostAllocation> list = dao.getDetailCostAllocation();
					Integer processTypeId = pi.getProcessInstance().getProcessType();
					Integer businessId = dao.getResetCostId();
					String remark = dao.getReason();
					Integer processId = pi.getProcessInstance().getProcessId();
					Integer processInstanceId = pi.getProcessInstance().getProcessInstanceId();
					//先取原有成本的相反数保存到系统成本中
					if(null != dao.getCostType() && dao.getCostType().equals(StaticUtils.DEPARTMENT_COST)){
						//保存部门成本
						departmentCost(costEmployeeId, processTypeId, businessId, remark, processId, processInstanceId,
								dao.getCost().negate().multiply(rate).setScale(2, BigDecimal.ROUND_DOWN), dao.getId());
					}else if(null != dao.getCostType() && dao.getCostType().equals(StaticUtils.PROJECT_COST)){
						//项目成本挂钩到项目上去
						projectCost(processTypeId, businessId, processId, processInstanceId, costEmployeeId, dao.getId(), dao.getCost().negate().multiply(rate).setScale(2, BigDecimal.ROUND_DOWN), true);
					}else if(null != dao.getCostType() && dao.getCostType().equals(StaticUtils.PRE_PROJECT_COST)){
						//前期项目成本先判断是否挂钩到部门上了，如果已挂钩，则取相反数保存到部门账户中
						PlateCostRecord costRecordDao = new PlateCostRecord();
						costRecordDao.setConditionProcessInstanceId("=", dao.getProcessInstanceId());
						if(costRecordDao.countRows() > 0){
							preProjectCost(costEmployeeId, processTypeId, businessId, remark, processId, processInstanceId,
									dao.getCost().negate().multiply(rate).setScale(2, BigDecimal.ROUND_DOWN), dao.getId());
						}
					}
					//然后再添加本次调整后的成本
					for(BaseCostAllocation obj : list){
						if(null != obj.getType() && obj.getType().equals(StaticUtils.DEPARTMENT_COST)){
							//保存部门成本
							departmentCost(costEmployeeId, processTypeId, businessId, remark, processId, processInstanceId,
									obj.getCost().multiply(rate).setScale(2, BigDecimal.ROUND_DOWN), obj.getId());
						}else if(null != obj.getType() && obj.getType().equals(StaticUtils.PROJECT_COST)){
							//项目成本挂钩到项目上去
							projectCost(processTypeId, businessId, processId, processInstanceId, costEmployeeId, obj.getId(), obj.getCost().multiply(rate).setScale(2, BigDecimal.ROUND_DOWN), false);
						}
					}
				}
			}
		}
		BusinessAbstract ba = new BusinessAbstract(dao.getResetCostId(), "成本调节");
		return ba;
	}

	/**
	 * 插入项目成本
	 * @param processTypeId
	 * @param businessId
	 * @param processId
	 * @param processInstanceId
	 * @param employeeId
	 * @param projectId
	 * @param cost
	 * @param autoSettlementCost	是否自动结算成本
	 * @throws SQLException
	 */
	public void projectCost(Integer processTypeId, Integer businessId, Integer processId,
			Integer processInstanceId, Integer employeeId, Integer projectId, BigDecimal cost, boolean autoSettlementCost) throws SQLException {
		ProjectCost costDao = new ProjectCost();
		costDao.setAmount(cost);
		costDao.setProjectId(projectId);
		costDao.setCostDate(new Date());
		costDao.setEmployeeId(employeeId);
		if(autoSettlementCost) {
			costDao.setStatus(StaticUtils.SETTLEMENT_STATUS_YES);
		}else {
			costDao.setStatus(StaticUtils.SETTLEMENT_STATUS_NO);
		}
		costDao.setProcessType(processTypeId);
		costDao.setBusinessId(businessId);
		costDao.setProcessId(processId);
		costDao.setProcessInstanceId(processInstanceId);
		costDao.save();
	}

	//插入部门成本
	public void departmentCost(int employeeId, Integer processTypeId, Integer businessId, String remark,
			Integer processId, Integer processInstanceId, BigDecimal cost, Integer departmentId) throws SQLException {
		Calendar c = Calendar.getInstance();
		PlateCostRecord plateCostRecord=new PlateCostRecord();
		Department department=new Department();
		department.setDepartmentId(departmentId);
		department.unsetSelectFlags();
		department.setSelectPlateId(true);
		if(department.load()){
			plateCostRecord.setPlateId(department.getPlateId());
		}
		plateCostRecord.setCostIntegral(cost);
		plateCostRecord.setSalaryIntegral(BigDecimal.ZERO);
		plateCostRecord.setIsSettlement(false);
		//获取当前的年月
		plateCostRecord.setYear(c.get(Calendar.YEAR));
		plateCostRecord.setMonth(c.get(Calendar.MONTH)+1);
		plateCostRecord.setCostDate(c.getTime());
		plateCostRecord.setProcessType(processTypeId);
		plateCostRecord.setBusinessId(businessId);
		plateCostRecord.setProcessId(processId);
		plateCostRecord.setProcessInstanceId(processInstanceId);
		plateCostRecord.setRemark(remark);
		plateCostRecord.save();
		//同时更新数据到部门积分汇总表中
		PlateAccountRecord plateAccountRecordDao = new PlateAccountRecord();
		plateAccountRecordDao.setBusinessTypeId(AccountManageProcess.PLATE_BT_PLATE_COST);
		plateAccountRecordDao.setBusinessId(plateCostRecord.getPlateCostRecordId());
		plateAccountRecordDao.setPlateId(plateCostRecord.getPlateId());
		plateAccountRecordDao.setIntegral(plateCostRecord.getCostIntegral());
		plateAccountRecordDao.setRecordDate(plateCostRecord.getCostDate());
		plateAccountRecordDao.setOperateEmployeeId(employeeId);
		plateAccountRecordDao.setOperateTime(c.getTime());
		plateAccountRecordDao.setRemark(remark);
		plateAccountRecordDao.save();
	}

	//插入前期项目成本
	public void preProjectCost(int employeeId, Integer processTypeId, Integer businessId, String remark,
			Integer processId, Integer processInstanceId, BigDecimal cost, Integer preProjectId) throws SQLException {
		Calendar c = Calendar.getInstance();
		PreProjectReimbursementNumber plateDao = new PreProjectReimbursementNumber();
		plateDao.setPreProjectReimbursementNumberId(preProjectId);
		plateDao.unsetSelectFlags();
		plateDao.setSelectPlateId(true);
		if(plateDao.load()){
			Integer plateId = plateDao.getPlateId();
			PlateCostRecord plateCostRecord=new PlateCostRecord();
			plateCostRecord.setPlateId(plateId);
			plateCostRecord.setCostIntegral(cost);
			plateCostRecord.setSalaryIntegral(BigDecimal.ZERO);
			plateCostRecord.setIsSettlement(false);
			//获取当前的年月
			plateCostRecord.setYear(c.get(Calendar.YEAR));
			plateCostRecord.setMonth(c.get(Calendar.MONTH)+1);
			plateCostRecord.setCostDate(c.getTime());
			plateCostRecord.setProcessType(processTypeId);
			plateCostRecord.setBusinessId(businessId);
			plateCostRecord.setProcessId(processId);
			plateCostRecord.setProcessInstanceId(processInstanceId);
			plateCostRecord.setRemark(remark);
			plateCostRecord.save();
			//同时更新数据到部门积分汇总表中
			PlateAccountRecord plateAccountRecordDao = new PlateAccountRecord();
			plateAccountRecordDao.setBusinessTypeId(AccountManageProcess.PLATE_BT_PLATE_COST);
			plateAccountRecordDao.setBusinessId(plateCostRecord.getPlateCostRecordId());
			plateAccountRecordDao.setPlateId(plateId);
			plateAccountRecordDao.setIntegral(cost);
			plateAccountRecordDao.setRecordDate(plateCostRecord.getCostDate());
			plateAccountRecordDao.setOperateEmployeeId(employeeId);
			plateAccountRecordDao.setOperateTime(c.getTime());
			plateAccountRecordDao.setRemark(remark);
			plateAccountRecordDao.save();
		}
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		if(null != roleId && roleId.equals(StaticUtils.ROLE_CUSTOM_AUDITOR)){
			List<BaseCostAllocation> list = bean.getDetailCostAllocation();
			if(null != list && !list.isEmpty()){
				Set<Integer> set = new HashSet<>();
				for(BaseCostAllocation obj : list){
					if(obj.getType().equals(StaticUtils.DEPARTMENT_COST)){
						int[] arr = NormalReimbursementWithDepartmentWorker.findNextOwner(obj.getId(), StaticUtils.ROLE_DEPARTMENT_CHARGE_LEADER);
						if(arr.length > 0){
							int length = arr.length;
							for(int i = 0; i < length; i++){
								set.add(arr[i]);
							}
						}else{
							return new int[0];
						}
					}else if(obj.getType().equals(StaticUtils.PROJECT_COST)){
						ConditionGetProjectManagerByProjectId condition = new ConditionGetProjectManagerByProjectId();
						condition.setProjectId(obj.getId());
						QueryGetProjectManagerByProjectId query = new QueryGetProjectManagerByProjectId();
						BaseCollection<BaseGetProjectManagerByProjectId> bc = query.executeQuery(null, condition);
						if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty() && null != bc.getCollections().get(0).getProjectManageId()){
							set.add(bc.getCollections().get(0).getProjectManageId());
						}else{
							return new int[0];
						}
					}
				}
				if(set.size() > 0){
					int size = set.size();
					int[] ids = new int[size];
					int i = 0;
					for(Integer id : set){
						if(i < size){
							ids[i++] = id;
						}
					}
					return ids;
				}else{
					return new int[0];
				}
			}else{
				return new int[0];
			}
		}
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		ResetCostWithC dao = new ResetCostWithC();
		dao.setResetCostId(businessId);
		dao.load();
		return dao.generateBaseExt().toJSON();
	}

}
