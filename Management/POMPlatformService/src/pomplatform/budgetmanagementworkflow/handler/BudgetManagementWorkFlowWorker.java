package pomplatform.budgetmanagementworkflow.handler;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

import com.pomplatform.db.bean.BaseBudgetManagement;
import com.pomplatform.db.bean.BaseBudgetManagementDetail;
import com.pomplatform.db.bean.BaseBudgetManagementLinkProcess;
import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.dao.*;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericBase;
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
import pomplatform.budgetendcode.bean.BaseBudgetEndCode;
import pomplatform.budgetendcode.bean.ConditionBudgetEndCode;
import pomplatform.budgetendcode.query.QueryBudgetEndCode;
import pomplatform.budgetmanagementworkflow.bean.BaseBudgetManagementWithB;
import pomplatform.budgetmanagementworkflow.dao.BudgetManagementWithB;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.personnelbusiness.business.SendMSGCommon;

public class BudgetManagementWorkFlowWorker implements GenericWorkflowProcessor {

	protected BaseBudgetManagementWithB bean = new BaseBudgetManagementWithB();
	protected BaseBudgetManagementDetail detailBean=new BaseBudgetManagementDetail();
	protected BaseBudgetManagement  mBbean =new BaseBudgetManagement();
	private static final Logger __logger = Logger.getLogger("");

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		@SuppressWarnings("unchecked")
		List<Map> mainList=(List<Map>) params.get("mainValue");
		@SuppressWarnings("unchecked")
		Map<String,Object>  mainMap=mainList.get(0);
		bean.setDataFromMap(mainMap);
		Object val;
		if((val = params.get("detailBudgetManagementDetail")) != null) bean.setDetailBudgetManagementDetail(GenericBase.__getList(val, BaseBudgetManagementDetail.newInstance()));
		BudgetManagementWithB dao = new BudgetManagementWithB();
		bean.setBdStatus(StaticUtils.BD_BILL_STATUS_ONGOING);//立项进行中
		dao.setDataFromBase(bean);
		//生成预算编号
		Date currentDate = new Date();
		String year = DateUtil.getYear(currentDate)+"";
		int month = DateUtil.getMonth(currentDate);
		QueryBudgetEndCode query=new QueryBudgetEndCode();
		ConditionBudgetEndCode condition=new ConditionBudgetEndCode();
		condition.setYear(DateUtil.getYear(currentDate));
		condition.setMonth(month);
		BaseCollection<BaseBudgetEndCode> numlist=query.executeQuery(null, condition); 
		List<BaseBudgetEndCode>  resultlist=numlist.getCollections();
		int endNumber = BaseHelpUtils.getIntValue(resultlist.get(0).getEndNumber())+1;
		String onePossible="00";
		String twoPossible="0";
		String endNumbers="";
		if(endNumber>=0&&endNumber<=9) {
			endNumbers=onePossible+endNumber;
		}
		if(endNumber>=10&&endNumber<=99) {
			endNumbers=twoPossible+endNumber;
		}
		if(endNumber>=100) {
			endNumbers=endNumber+"";
		}
		String code="BD."+year.substring(2, 4)+String.format("%02d", month)+endNumbers;
		bean.setBdCode(code);
		bean.setBdApplyTime(currentDate);
		bean.setBdRestAmount(bean.getBdTotalAmount());
		dao.setDataFromBase(bean);
		dao.save();
		BudgetManagementDetail detailDao=new BudgetManagementDetail();
		detailDao.setConditionBudgetManagementId("=",dao.getBudgetManagementId());
		detailDao.setBdCode(bean.getBdCode());
		detailDao.setProjectId(bean.getProjectId());
		detailDao.conditionalUpdate();
		
		//插入关联流程业务表
		if(params.containsKey("detailBudgetProess")) {
			@SuppressWarnings("unchecked")
			List<Map> proessList=(List<Map>) params.get("detailBudgetProess");
			BudgetManagementLinkProcess  bpDao=new BudgetManagementLinkProcess();
			BaseBudgetManagementLinkProcess  bpbean=new BaseBudgetManagementLinkProcess();
			for (Map map : proessList) {
				bpbean.setDataFromMap(map);
				bpbean.setBudgetManagementId(dao.getBudgetManagementId());
				bpDao.setDataFromBase(bpbean);
				bpDao.save();
			}
		}
		BusinessAbstract ba = new BusinessAbstract(dao.getBudgetManagementId(), "");
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
		BudgetManagementWithB dao = new BudgetManagementWithB();
		//获取预算管理Id
		int budgetManagementId=BaseHelpUtils.getIntValue(bean.getBudgetManagementId());
		BudgetManagementDetail detailDao=new BudgetManagementDetail();
		detailDao.setConditionBudgetManagementId("=",budgetManagementId);
		List<BaseBudgetManagementDetail> detailList=bean.getDetailBudgetManagementDetail();
		if(BaseHelpUtils.isNullOrEmpty(detailList)){//如果预算详情为空
			List<BaseBudgetManagementDetail> listManagementDetail=detailDao.conditionalLoad();
			bean.setDetailBudgetManagementDetail(listManagementDetail);
		}
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				dao.setBdStatus(StaticUtils.BD_BILL_STATUS_ALREADYUSE);//已立项


			}

			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)){
				dao.setBdStatus(StaticUtils.BD_BILL_STATUS_REFUSE);//被驳回
				//流程被驳回则消息通知发起人
				String code = bean.getBdCode();
				ProcessInstance processInstance = pi.getProcessInstance();
				Integer processType = processInstance.getProcessType(); 
				int applyEmpId = BaseHelpUtils.getIntValue(bean.getBdApplyEmployeeId());
				SendMSGCommon sendMSGCommon =new SendMSGCommon();
				Map map =new HashMap<String, Object>();
				map.put("code", code);
				map.put("processType", processType);
				map.put("applyEmpId", applyEmpId);
				sendMSGCommon.sendWXMsgToUser(map);

			}
		}
		dao.update();
		detailDao.setBdCode(bean.getBdCode());
		detailDao.setProjectId(bean.getProjectId());
		detailDao.conditionalUpdate();
		BusinessAbstract ba = new BusinessAbstract(dao.getBudgetManagementId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		if(expression.contains("预算类型")){
			e.setValue("预算类型", null == bean.getBdType() ? "暂无" : (1 == bean.getBdType().intValue() ? "采买预算":2 == bean.getBdType().intValue() ?"行政预算":3 == bean.getBdType().intValue() ?"部门预算":4==bean.getBdType().intValue()?"外包预算":"找不到预算类型"));
		}
		if(expression.contains("外包类型")){
			e.setValue("外包类型", null == bean.getOutSourceType() ? "暂无" :(1==bean.getOutSourceType().intValue()?"公司外包":2==bean.getOutSourceType()?"项目外包":"找不到外包类型"));
		}
		CompanyRecord cr = new CompanyRecord();
		if(bean.getCompanyId()>0){
			cr.setCompanyRecordId(bean.getCompanyId());
			cr.load();
		}
		if(expression.contains(StaticUtils.BELONGING_COMPANY)){
			if(BaseHelpUtils.isNullOrEmpty(cr)){
				e.setValue(StaticUtils.BELONGING_COMPANY,"");
			}else{
				e.setValue(StaticUtils.BELONGING_COMPANY,cr.getCompanyName());
			}
		}

		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
//		if(!BaseHelpUtils.isNullOrEmpty(roleId) && Objects.equals(roleId, StaticUtils.ROLE_PROJECT_MANAGER)) {//专业负责人
//			Project pDao = new Project();
//			int projectId=BaseHelpUtils.getIntValue(bean.getProjectId());
//			if(projectId>0) {
//				pDao.setProjectId(bean.getProjectId());
//				pDao.unsetSelectFlags();
//				pDao.setSelectProjectManageId(true);
//				if(pDao.load()) {
//					int[] employeeArr = new int[1];
//					int projectManageId=BaseHelpUtils.getIntValue(pDao.getProjectManageId());
//					if(projectManageId>0) {
//						employeeArr[0] = projectManageId;
//						return employeeArr;
//					}else {
//						throw new Exception(String.format("操作异常：找不到专业负责人(%1$s)", projectManageId));
//					}
//				}else {
//					return new int[0];
//				}
//			}else {
//				throw new Exception(String.format("操作异常：找不到项目id(%1$s)", projectId));
//			}
//		}
//		if(!BaseHelpUtils.isNullOrEmpty(roleId) && Objects.equals(roleId, StaticUtils.ROLE_OPERATIONS_MANAGER)) {//部门经理
//			Project pDao = new Project();
//			int projectId=BaseHelpUtils.getIntValue(bean.getProjectId());
//			pDao.setProjectId(projectId);
//			if(!pDao.load()) {
//				__logger.info(String.format("操作异常：未加载到项目信息，项目ID(%1$s)", projectId));
//				return null;
//			}
//			//获取业务部门ID
//			int plateId=BaseHelpUtils.getIntValue(pDao.getPlateId());
//			Department deDao=new Department();
//			deDao.setConditionDeleteFlag("=", 0);
//			deDao.setConditionPlateId("=", plateId);
//			List<BaseDepartment> delist=deDao.conditionalLoad("order by parent_id");
//			Set<Integer> set=new HashSet<>();
//			for (BaseDepartment debean : delist) {
//				//获取部门ID
//				int departmentIds=BaseHelpUtils.getIntValue(debean.getDepartmentId());
//				EmployeeRole emDao=new EmployeeRole();
//				emDao.setConditionDepartmentId("=", departmentIds);
//				emDao.setConditionRoleId("=",StaticUtils.ROLE_OPERATIONS_MANAGER);
//				List<BaseEmployeeRole>  erlist=emDao.conditionalLoad();
//				for (BaseEmployeeRole bean : erlist) {
//					set.add(bean.getEmployeeId());
//				}
//			}
//			int[] arr = new int[set.size()];
//			int i = 0;
//			for (Integer value : set) {
//				arr[i++] = BaseHelpUtils.getIntValue(value);
//			}
//			return arr;
//		}
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		BudgetManagementWithB dao = new BudgetManagementWithB();
		dao.setBudgetManagementId(businessId);
		dao.load();
		return dao.generateBaseExt().toJSON();
	}

}
