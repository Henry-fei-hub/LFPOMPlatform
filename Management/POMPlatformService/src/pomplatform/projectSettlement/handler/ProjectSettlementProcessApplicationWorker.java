package pomplatform.projectSettlement.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseMainProjectEmployee;
import com.pomplatform.db.bean.BasePlateProjectAccountRecord;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectSettlement;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectEmployee;
import com.pomplatform.db.dao.PlateProjectAccountRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectSettlement;

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
import delicacy.system.executor.SelectValueCache;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.department.bean.BaseOnLoadDepartmentByParentId;
import pomplatform.department.bean.ConditionOnLoadDepartmentByParentId;
import pomplatform.department.query.QueryOnLoadDepartmentByParentId;
import pomplatform.project.bean.BaseOnLoadMainProjectEmployee;
import pomplatform.project.bean.ConditionOnLoadMainProjectEmployee;
import pomplatform.project.query.QueryOnLoadMainProjectEmployee;
import pomplatform.projectSettlement.bean.BaseOnLoadProjectSettlementEmployees;
import pomplatform.projectSettlement.bean.BaseProjectSettlementWithP;
import pomplatform.projectSettlement.dao.ProjectSettlementWithP;
import pomplatform.workflow.business.OnWrokflowProcess;

public class ProjectSettlementProcessApplicationWorker implements GenericWorkflowProcessor {

	protected BaseProjectSettlementWithP bean = new BaseProjectSettlementWithP();
	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
//		String ourEmployees = BaseHelpUtils.getString(params.get("ourEmployees"));
		bean.setDataFromMap(params);
//		bean.setOurEmployees(ourEmployees);
		Date settlementDate = bean.getSettlementDate();
		List<BaseProjectSettlementDetail> detail = bean.getDetailProjectSettlementDetail();
		BigDecimal a =BigDecimal.ZERO;
		if(detail.size()>0) {
			List<BaseProjectSettlementDetail> newdetail  =new ArrayList<>();
			for (BaseProjectSettlementDetail baseProjectSettlementDetail : detail) {
				BigDecimal finalAmount = BaseHelpUtils.getBigDecimalValue(baseProjectSettlementDetail.getRealAmount()).subtract(BaseHelpUtils.getBigDecimalValue(baseProjectSettlementDetail.getCost()));
				baseProjectSettlementDetail.setSettlementStatus(1);
				baseProjectSettlementDetail.setFinalAmount(finalAmount);
				baseProjectSettlementDetail.setSettlementDate(settlementDate);
				if(BaseHelpUtils.getBigDecimalValue(baseProjectSettlementDetail.getRealAmount()).compareTo(BigDecimal.ZERO)!=0) {
					newdetail.add(baseProjectSettlementDetail);
					a=a.add(BaseHelpUtils.getBigDecimalValue(baseProjectSettlementDetail.getRealAmount()));
				}
			}
			bean.setDetailProjectSettlementDetail(newdetail);
		}
		
		//本次计算积分
		BigDecimal b = BaseHelpUtils.getBigDecimalValue(bean.getTotalAmount());
		BigDecimal c = BaseHelpUtils.getBigDecimalValue(bean.getProjectAmount());
		if(a.compareTo(b)!=0 || a.compareTo(c)!=0) {
			throw new SQLException("本次结算积分与成员分配积分之和不一致，请重新打开页面进行分配");
		}
		ProjectSettlementWithP dao = new ProjectSettlementWithP();
		dao.setDataFromBase(bean);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getSettlementId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		bean.setDataFromMap(params);
		Integer projectId = bean.getProjectId();
		Date settlementDate = bean.getSettlementDate();
		List<BaseProjectSettlementDetail> detail = bean.getDetailProjectSettlementDetail();
		BigDecimal a =BigDecimal.ZERO;
		if(detail.size()>0) {
			List<BaseProjectSettlementDetail> newdetail  =new ArrayList<>();
			for (BaseProjectSettlementDetail baseProjectSettlementDetail : detail) {
				BigDecimal finalAmount = BaseHelpUtils.getBigDecimalValue(baseProjectSettlementDetail.getRealAmount()).subtract(BaseHelpUtils.getBigDecimalValue(baseProjectSettlementDetail.getCost()));
				baseProjectSettlementDetail.setFinalAmount(finalAmount);
				baseProjectSettlementDetail.setSettlementDate(settlementDate);
				if(BaseHelpUtils.getBigDecimalValue(baseProjectSettlementDetail.getRealAmount()).compareTo(BigDecimal.ZERO)!=0) {
					newdetail.add(baseProjectSettlementDetail);
					a=a.add(BaseHelpUtils.getBigDecimalValue(baseProjectSettlementDetail.getRealAmount()));
				}
			}
			bean.setDetailProjectSettlementDetail(newdetail);
		}
		//本次计算积分
		BigDecimal b = BaseHelpUtils.getBigDecimalValue(bean.getTotalAmount());
		if(a.compareTo(b)!=0) {
			throw new SQLException("本次结算积分与成员分配积分之和不一致，请重新打开页面进行分配");
		}
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
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				Project pDao =new Project();
				pDao.setConditionProjectId("=", projectId);
				BaseProject baseProject = pDao.executeQueryOneRow();
				if(BaseHelpUtils.isNullOrEmpty(baseProject)) {
					throw new SQLException("订单信息不存在");
				}
				
				bean.setSettlementStatus(2);//已完成
				List<BaseProjectSettlementDetail> detailProjectSettlementDetail = bean.getDetailProjectSettlementDetail();
				for (BaseProjectSettlementDetail baseProjectSettlementDetail : detailProjectSettlementDetail) {
					baseProjectSettlementDetail.setSettlementStatus(2);
				}
				
				bean.setDetailProjectSettlementDetail(detailProjectSettlementDetail);
				String settlementRemark = bean.getRemark();
				for (BaseProjectSettlementDetail baseProjectSettlementDetail : detailProjectSettlementDetail) {
					if(baseProjectSettlementDetail.getSettlementStatus() == 2){
						//获取主键ID，即业务ID
						int businessId = baseProjectSettlementDetail.getSettlementDetailId();
						Integer empId = baseProjectSettlementDetail.getEmployeeId();
						BigDecimal realAmount = BaseHelpUtils.getBigDecimalValue(baseProjectSettlementDetail.getRealAmount());
						//确认积分插入个人账户表
						if(realAmount.compareTo(BigDecimal.ZERO) != 0){
							AccountManageProcess.onSaveEmployeeAccount(empId, businessId, AccountManageProcess.EMP_BT_SURE_INTEGRAL, realAmount, settlementDate, settlementRemark, -1);
						}
					}
				}
				
				//部门预留积分
				//检索该项目部门上已经确认的确认积分
				BigDecimal totalPlateSureIntegral = BigDecimal.ZERO;
				PlateProjectAccountRecord plateProjectAccountRecordDao = new PlateProjectAccountRecord();
				plateProjectAccountRecordDao.setConditionProjectId("=",bean.getProjectId());
				List<BasePlateProjectAccountRecord> pparList = plateProjectAccountRecordDao.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(pparList) && pparList.size() > 0){
					for(BasePlateProjectAccountRecord e : pparList){
						BigDecimal plateSureIntegral = BaseHelpUtils.getBigDecimalValue(e.getAccountIntegral());
						totalPlateSureIntegral = totalPlateSureIntegral.add(plateSureIntegral);
					}
				}
				//计算部门累计可确认积分=项目累计确认积分/项目积分*预留积分
				BigDecimal totalCanSureIntegral = BaseHelpUtils.getBigDecimalValue(bean.getReserveAmount());
				//设置当前可结算积分=累计可确认积分-部门已确认积分
				BigDecimal currentSureIntegral = totalCanSureIntegral.subtract(totalPlateSureIntegral);
				if (currentSureIntegral.compareTo(BigDecimal.ZERO) > 0) {
					// 往部门项目的结算预留积分的记录表中插入一条记录
					plateProjectAccountRecordDao.clear();
					plateProjectAccountRecordDao.setPlateId(pDao.getPlateId());
					plateProjectAccountRecordDao.setProjectId(projectId);
					plateProjectAccountRecordDao.setAccountIntegral(currentSureIntegral);
					plateProjectAccountRecordDao.setAccountDate(settlementDate);
					plateProjectAccountRecordDao.setStageId(-1);
					plateProjectAccountRecordDao.setRemark(settlementRemark);
					plateProjectAccountRecordDao.setSettlementId(bean.getSettlementId());
					plateProjectAccountRecordDao.save();
					int businessId = plateProjectAccountRecordDao.getPlateProjectAccountRecordId();
					// 往部门账户表中插入数据
					AccountManageProcess.onSavePlateAccount(pDao.getPlateId(), businessId,
							AccountManageProcess.PLATE_BT_SURE_INTEGRAL, currentSureIntegral, settlementDate,
							settlementRemark, -1);

				}
				
				BigDecimal projectIntegral = baseProject.getProjectIntegral();
				// 获取订单已确认总积分
				BigDecimal assignedTotalIntegral = getProjectAssignedTotalIntegral(projectId);
				//计算订单完成百分比=已确认积分/项目积分
				BigDecimal projectFinishPercent = (projectIntegral.compareTo(BigDecimal.ZERO) > 0)?assignedTotalIntegral.multiply(BigDecimal.valueOf(100)).divide(projectIntegral, 2, BigDecimal.ROUND_DOWN) : BigDecimal.ZERO;
				// 更新该项目的完成百分比
				pDao.clear();
				pDao.setProjectId(projectId);
				pDao.load();
				pDao.setProjectFinishPercent(projectFinishPercent);
				pDao.update();
				
			}else if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {
				bean.setSettlementStatus(3);//已驳回
				List<BaseProjectSettlementDetail> detailProjectSettlementDetail = bean.getDetailProjectSettlementDetail();
				for (BaseProjectSettlementDetail baseProjectSettlementDetail : detailProjectSettlementDetail) {
					baseProjectSettlementDetail.setSettlementStatus(3);
				}
				bean.setDetailProjectSettlementDetail(detailProjectSettlementDetail);
			}
		}
		ProjectSettlementWithP dao = new ProjectSettlementWithP();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getSettlementId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
//		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e = OnWrokflowProcess.setExpression(expression, e, employeeId,null,null,null);
		if(expression.contains("部门")) {
			Employee dao = new Employee();
			dao.unsetSelectFlags();
			dao.setSelectDutyId(true);
			dao.setSelectDepartmentId(true);
			dao.setSelectCompanyId(true);
			dao.setSelectEmployeeName(true);
			dao.setSelectPlateId(true);
			dao.setEmployeeId(employeeId);
			if(dao.load()) {
				Integer departmentId = dao.getDepartmentId();
				QueryOnLoadDepartmentByParentId query =new  QueryOnLoadDepartmentByParentId();
	    		ConditionOnLoadDepartmentByParentId condition =new ConditionOnLoadDepartmentByParentId();
	    		condition.setDepartmentId(StaticUtils.DEPARTMENT_7);
	    		BaseCollection<BaseOnLoadDepartmentByParentId> execute = query.execute(null, condition);
	    		if(!BaseHelpUtils.isNullOrEmpty(execute)&&execute.getCollections().size()>0) {
	    			List<BaseOnLoadDepartmentByParentId> collections = execute.getCollections();
	    			for (BaseOnLoadDepartmentByParentId baseOnLoadDepartmentByParentId : collections) {
	    				Integer depId = baseOnLoadDepartmentByParentId.getDepartmentId();
	    				if(departmentId == depId) {
	    					String name = BaseHelpUtils.getString(SelectValueCache.getSelectValue("departments",departmentId+""));
	    					e.setValue("部门","方案设计中心");
	    					break;
	    				}
					}
	    		}else {
	    			e.setValue("部门","");
	    		}
			}
		}
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
		
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		Integer projectId = bean.getProjectId();
		if (projectId <= 0) {
			throw new SQLException("项目信息丢失！");
		}
		
		if(!BaseHelpUtils.isNullOrEmpty(roleId)&&roleId==StaticUtils.ROLE_OPERATIONS_MANAGER) {//部门经理
			Project dao =new Project();
			dao.setConditionProjectId("=", projectId);
			dao.setProjectId(projectId);
			if(dao.load()) {
				return ProcessUtil.findNextOwner(0, 0, dao.getDepartmentId(), roleId);
			}else {
				return new int[0];
			}
		}else if(!BaseHelpUtils.isNullOrEmpty(roleId)&&roleId==StaticUtils.ROLE_93) {//审核人
			String ourEmployees = bean.getOurEmployees();
			String[] str = ourEmployees.replaceAll("\\[", "").replaceAll("\\]", "").trim().split(",");
			if(!BaseHelpUtils.isNullOrEmpty(str)&&str.length>0) {
				int[] activityOwners = new int[str.length];
				for (int i = 0; i < str.length; i++) {
					activityOwners[i] = BaseHelpUtils.getIntValue(str[i].trim());
				}
				return activityOwners;
			}else {
				return new int[0];
			}
		}else if(!BaseHelpUtils.isNullOrEmpty(roleId)&&roleId==StaticUtils.ROLE_143){//项目秘书1
			QueryOnLoadMainProjectEmployee query =new QueryOnLoadMainProjectEmployee();
			ConditionOnLoadMainProjectEmployee condition =new ConditionOnLoadMainProjectEmployee();
			condition.setProjectId(projectId);
			condition.setRelation(1);
			BaseCollection<BaseOnLoadMainProjectEmployee> execute = query.execute(null, condition);
			if (!BaseHelpUtils.isNullOrEmpty(execute) && execute.getCollections().size() > 0) {
				List<BaseOnLoadMainProjectEmployee> collections = execute.getCollections();
				int[] activityOwners = new int[collections.size()];
				for (int i = 0; i < collections.size(); i++) {
					activityOwners[i] = BaseHelpUtils.getIntValue(collections.get(i).getEmployeeId());
				}
				return activityOwners;
			}else {
				return new int[0];
			}
			
		}else if(!BaseHelpUtils.isNullOrEmpty(roleId)&&roleId==StaticUtils.ROLE_152) {//项目负责人5
			QueryOnLoadMainProjectEmployee query =new QueryOnLoadMainProjectEmployee();
			ConditionOnLoadMainProjectEmployee condition =new ConditionOnLoadMainProjectEmployee();
			condition.setProjectId(projectId);
			condition.setRelation(5);
			BaseCollection<BaseOnLoadMainProjectEmployee> execute = query.execute(null, condition);
			if (!BaseHelpUtils.isNullOrEmpty(execute) && execute.getCollections().size() > 0) {
				List<BaseOnLoadMainProjectEmployee> collections = execute.getCollections();
				int[] activityOwners = new int[collections.size()];
				for (int i = 0; i < collections.size(); i++) {
					activityOwners[i] = BaseHelpUtils.getIntValue(collections.get(i).getEmployeeId());
				}
				return activityOwners;
			}else {
				return new int[0];
			}
		}else{
			return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
		}
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		ProjectSettlementWithP dao = new ProjectSettlementWithP();
		dao.setSettlementId(businessId);
		dao.load();
		return dao.generateBaseExt().toJSON();
	}
	
	
	
	private void executeBean(Map params) throws SQLException {
		int projectId = BaseHelpUtils.getIntValue(params, "projectId");
		int settlementStatus = 1;
		String settlementRemark = BaseHelpUtils.getString(params.get("settlementRemark"));
		List<BaseOnLoadProjectSettlementEmployees> projectEmployeesList = GenericBase.__getList(params.get("projectEmployees"),BaseOnLoadProjectSettlementEmployees.newInstance());
		int operateEmployeeId =BaseHelpUtils.getIntValue(params, "employeeId");
		//当前的可结算预留积分
		BigDecimal reserveAmount = BaseHelpUtils.getBigDecimalValue(params.get("reserveAmount"));
		
		Project p = new Project();
		p.setProjectId(projectId);
		p.setConditionProjectId("=",projectId);
		boolean isHave = p.load();
		if (!isHave) {
			throw new SQLException("没有这个项目");
		}
//		if (BaseHelpUtils.isNullOrEmpty(projectEmployeesList)||projectEmployeesList.size()<=0) {
//			throw new SQLException("没有可结算的成员");
//		}
		// 获取当次结算时输入的总的实际积分
		BigDecimal totalAmountToSettle = BigDecimal.ZERO;
		for(BaseOnLoadProjectSettlementEmployees e : projectEmployeesList){
			BigDecimal sureIntegral = BaseHelpUtils.getBigDecimalValue(e.getRealAmount());
			totalAmountToSettle = totalAmountToSettle.add(sureIntegral);
		}
		
		List<BaseProjectSettlementDetail> projectSettlementDetailList =new ArrayList<>();
		for (BaseOnLoadProjectSettlementEmployees e : projectEmployeesList) {
			int settlementDetailId = BaseHelpUtils.getIntValue(e.getSettlementDetailId());
			// 获取职员id
			int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
			// 获取当次结算时确认给成员的积分
			BigDecimal realIntegral = e.getRealAmount()==null?BigDecimal.ZERO:e.getRealAmount();
			// 如果人员未分配积分和分摊成本，则不进行操作
			if (realIntegral.compareTo(BigDecimal.ZERO) != 0) {
				BaseProjectSettlementDetail psd = new BaseProjectSettlementDetail();
				if(settlementDetailId>0) {
					psd.setSettlementDetailId(settlementDetailId);
				}
				psd.setProjectId(projectId);
				psd.setEmployeeId(empId);
				psd.setWorkContent(e.getWorkContent());
				psd.setPlanAmount(BigDecimal.ZERO);
				psd.setRealAmount(e.getRealAmount());
				psd.setProjectCost(BigDecimal.ZERO);
				psd.setFinalAmount(realIntegral);
				psd.setSettlementDate(new Date());
				psd.setSettlementStatus(settlementStatus);
				projectSettlementDetailList.add(psd);
			}
		}
		
		bean.setDataFromMap(params);
		bean.setRemark(settlementRemark);
		bean.setFlag(2);//新的结算状态，1：历史数据结算；2：新方式数据结算
		bean.setTotalAmount(totalAmountToSettle);//本次计算的积分总和
		bean.setTotalCost(BigDecimal.ZERO);
		bean.setProjectAmount(p.getProjectIntegral());
		bean.setDetailProjectSettlementDetail(projectSettlementDetailList);
		
	}
	

	
	/**
	 * 获取该项目已确认的积分
	 * 
	 * @param assignedTotalIntegral
	 * @param projectId
	 * @return
	 * @throws SQLException
	 */
	public BigDecimal getProjectAssignedTotalIntegral(Integer projectId) throws SQLException {
		BigDecimal assignedTotalIntegral = BigDecimal.ZERO;
		ProjectSettlement dao = new ProjectSettlement();
		dao.setConditionProjectId("=", projectId);
		dao.setConditionSettlementStatus("=", 2);
		List<BaseProjectSettlement> listBean = dao.conditionalLoad();
		if (!BaseHelpUtils.isNullOrEmpty(listBean) && listBean.size() > 0) {
			for (BaseProjectSettlement bean : listBean) {
				BigDecimal sureIntegral = bean.getTotalAmount()==null?BigDecimal.ZERO:bean.getTotalAmount();
				assignedTotalIntegral = assignedTotalIntegral.add(sureIntegral);
			}
		}
		return assignedTotalIntegral;
	}
	
	
	public static void main(String[] args) {
		
	}
	
	
	
}
