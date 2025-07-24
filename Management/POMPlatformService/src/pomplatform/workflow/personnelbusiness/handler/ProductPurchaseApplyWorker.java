package pomplatform.workflow.personnelbusiness.handler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BasePurchaseProductDetail;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.PurchasePlan;
import com.pomplatform.db.dao.PurchaseProductDetail;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericBase;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.business.OnWrokflowProcess;

public class ProductPurchaseApplyWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dataValidate(dao);
		dao.save();
		params.put("personnelBusinessId", dao.getPersonnelBusinessId());
		saveOrUpdateChildData(params, false);
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
		return ba;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		dataValidate(dao);
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				dao.setIsCompleted(Boolean.TRUE);
				//更新业务字表数据集
				int personnelBusinessId= BaseHelpUtils.getIntValue(bean.getPersonnelBusinessId());
				//获取业务主表id
				int mainProjectId = BaseHelpUtils.getIntValue(bean.getProjectId());
				PurchasePlan ppDao = new PurchasePlan();
				ppDao.setConditionOriPersonnelBusinessId("=", personnelBusinessId);
				ppDao.setConditionMainProjectId("=",mainProjectId);
				if(ppDao.isExist()) {
					ppDao.setIsComplete(true);
					ppDao.conditionalUpdate();
				}
			}
		}
		if(modified) {
			saveOrUpdateChildData(params, true);
		}
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
		return ba;
	}
	
	
	/**
	 * 保存或更改字表数据集
	 * @param params
	 * @param isUpdate
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public static void saveOrUpdateChildData(Map<String, Object> params, boolean isUpdate) throws SQLException{
		BasePersonnelBusines bean = new BasePersonnelBusines();
		bean.setDataFromMap(params);
		List<BasePurchaseProductDetail> list = GenericBase.__getList(params.get("productPurchaseApplyDetails"), BasePurchaseProductDetail.newInstance());
		PurchaseProductDetail dao = new PurchaseProductDetail();
		int personnelBusinessId = bean.getPersonnelBusinessId();
		int employeeId = bean.getEmployeeId();
		Date currentDate = new Date();
		if(isUpdate){//先进行删除
			dao.setConditionPersonnelBusinessId("=", personnelBusinessId);
			dao.conditionalDelete();
		}
		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
			//获取项目id
			int mainProjectId = bean.getProjectId();
			List<BasePurchaseProductDetail> addList = new ArrayList<>();
			for (BasePurchaseProductDetail ownBean : list) {
				ownBean.setMainProjectId(mainProjectId);
				ownBean.setPersonnelBusinessId(personnelBusinessId);
				ownBean.setCreateEmployeeId(employeeId);
				ownBean.setCreateTime(currentDate);
				addList.add(ownBean);
			}
			if(addList.size() > 0){
				dao.save(addList);
			}
		}
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		int companyId = bean.getCompanyId();
		int departmentId = bean.getDepartmentId();
		e = OnWrokflowProcess.setExpression(expression, e, employeeId, companyId, departmentId, null, null, null);
		int nextAuditor = BaseHelpUtils.getIntValue(bean.getNextAuditor());
		if(expression.contains("采购类型")){
			if(!BaseHelpUtils.isNullOrEmpty(bean.getNextAuditor())){
				if(nextAuditor==1){
					e.setValue("采购类型","低值易耗品");
				}else if(nextAuditor==0){
					e.setValue("采购类型","IT物品");
				}else if (nextAuditor==2){
					e.setValue("采购类型","电子产品");
				}
			}else{
				e.setValue("物品类型","");
			}

		}
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
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

	private void dataValidate(PersonnelBusines dao) throws Exception{
		if(BaseHelpUtils.isNullOrZero(dao.getProcessType())){
			throw new Exception("流程类型错误");
		}
		if(BaseHelpUtils.isNullOrZero(dao.getEmployeeId())){
			throw new Exception("申请人不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getEmployeeNo())){
			throw new Exception("工号不能为空");
		}
	}

}
