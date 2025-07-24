package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBudgetManagementLinkProcess;
import com.pomplatform.db.dao.BudgetManagementLinkProcess;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class BudgetManagementLinkProcessHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(BudgetManagementLinkProcessHandler.class);

	public static BaseBudgetManagementLinkProcess getBudgetManagementLinkProcessById( 
		java.lang.Integer budget_management_link_process_id
	) throws Exception
	{
		BudgetManagementLinkProcess dao = new BudgetManagementLinkProcess();
		dao.setBudgetManagementLinkProcessId(budget_management_link_process_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isBudgetManagementLinkProcessExists( com.pomplatform.db.bean.BaseBudgetManagementLinkProcess bean, String additional ) throws Exception {

		BudgetManagementLinkProcess dao = new BudgetManagementLinkProcess();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countBudgetManagementLinkProcess( com.pomplatform.db.bean.BaseBudgetManagementLinkProcess bean, String additional ) throws Exception {

		BudgetManagementLinkProcess dao = new BudgetManagementLinkProcess();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseBudgetManagementLinkProcess> queryBudgetManagementLinkProcess( com.pomplatform.db.bean.BaseBudgetManagementLinkProcess bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		BudgetManagementLinkProcess dao = new BudgetManagementLinkProcess();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseBudgetManagementLinkProcess> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseBudgetManagementLinkProcess> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseBudgetManagementLinkProcess addToBudgetManagementLinkProcess ( BaseBudgetManagementLinkProcess budgetmanagementlinkprocess )  throws Exception {
		return addToBudgetManagementLinkProcess ( budgetmanagementlinkprocess , false);
	}

	public static BaseBudgetManagementLinkProcess addToBudgetManagementLinkProcess ( BaseBudgetManagementLinkProcess budgetmanagementlinkprocess, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		BudgetManagementLinkProcess dao = new BudgetManagementLinkProcess();
		dao.setDataFromBase(budgetmanagementlinkprocess);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseBudgetManagementLinkProcess addUpdateBudgetManagementLinkProcess ( BaseBudgetManagementLinkProcess budgetmanagementlinkprocess ) throws Exception {
		return addUpdateBudgetManagementLinkProcess ( budgetmanagementlinkprocess , false);
	}

	public static BaseBudgetManagementLinkProcess addUpdateBudgetManagementLinkProcess ( BaseBudgetManagementLinkProcess budgetmanagementlinkprocess, boolean singleTransaction  ) throws Exception {
		if(budgetmanagementlinkprocess.getBudgetManagementLinkProcessId() == null) return addToBudgetManagementLinkProcess(budgetmanagementlinkprocess);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		BudgetManagementLinkProcess dao = new BudgetManagementLinkProcess();
		dao.setDataFromBase(budgetmanagementlinkprocess);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(budgetmanagementlinkprocess); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteBudgetManagementLinkProcess ( BaseBudgetManagementLinkProcess bean ) throws Exception {
		BudgetManagementLinkProcess dao = new BudgetManagementLinkProcess();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseBudgetManagementLinkProcess updateBudgetManagementLinkProcess ( BaseBudgetManagementLinkProcess budgetmanagementlinkprocess ) throws Exception {
		BudgetManagementLinkProcess dao = new BudgetManagementLinkProcess();
		dao.setBudgetManagementLinkProcessId( budgetmanagementlinkprocess.getBudgetManagementLinkProcessId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(budgetmanagementlinkprocess);
			result = dao.update();
		}
		return result == 1 ? budgetmanagementlinkprocess : null ;
	}

	public static BaseBudgetManagementLinkProcess updateBudgetManagementLinkProcessDirect( BaseBudgetManagementLinkProcess budgetmanagementlinkprocess ) throws Exception {
		BudgetManagementLinkProcess dao = new BudgetManagementLinkProcess();
		int result = 0;
		dao.setDataFromBase(budgetmanagementlinkprocess);
		result = dao.update();
		return result == 1 ? budgetmanagementlinkprocess : null ;
	}

	public static int setDeleteConditions(BaseBudgetManagementLinkProcess bean, BudgetManagementLinkProcess dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getBudgetManagementLinkProcessId() != null) {
			dao.setConditionBudgetManagementLinkProcessId("=", bean.getBudgetManagementLinkProcessId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBudgetManagementId() != null) {
				dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
			if(bean.getProcessId() != null) {
				dao.setConditionProcessId("=", bean.getProcessId());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getProcessInstanceId() != null) {
				dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getReason() != null) {
				dao.setConditionReason("=", bean.getReason());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseBudgetManagementLinkProcess bean, BudgetManagementLinkProcess dao){
		int count = 0;
		if(bean.getBudgetManagementLinkProcessId() != null) {
			dao.setConditionBudgetManagementLinkProcessId("=", bean.getBudgetManagementLinkProcessId());
			count++;
		}
		if(bean.getBudgetManagementId() != null) {
			dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
			count++;
		}
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		if(bean.getProcessId() != null) {
			dao.setConditionProcessId("=", bean.getProcessId());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getProcessInstanceId() != null) {
			dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getTotalPrice() != null) {
			dao.setConditionTotalPrice("=", bean.getTotalPrice());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getReason() != null) {
			if(bean.getReason().indexOf("%") >= 0)
				dao.setConditionReason("like", bean.getReason());
			else
				dao.setConditionReason("=", bean.getReason());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseBudgetManagementLinkProcess bean = new BaseBudgetManagementLinkProcess();
		bean.setDataFromJSON(json);
		BudgetManagementLinkProcess dao = new BudgetManagementLinkProcess();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseBudgetManagementLinkProcess> rlist = new BaseCollection<>();
		BaseBudgetManagementLinkProcess bean = new BaseBudgetManagementLinkProcess();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		BudgetManagementLinkProcess dao = new BudgetManagementLinkProcess();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseBudgetManagementLinkProcess> result = dao.conditionalLoad(addtion);
		rlist.setCollections(result);
		rlist.setTotalPages(dao.getTotalPages());
		rlist.setCurrentPage(dao.getCurrentPage());
		rlist.setPageLines(dao.getPageLines());
		rlist.setTotalLines(dao.getTotalLines());
		rlist.setRecordNumber(result.size());
		return rlist.toJSON(null);
	}

	@Override
	public String save(String json) throws Exception{
		BaseBudgetManagementLinkProcess bean = new BaseBudgetManagementLinkProcess();
		bean.setDataFromJSON(json);
		BudgetManagementLinkProcess dao = new BudgetManagementLinkProcess();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseBudgetManagementLinkProcess bean = new BaseBudgetManagementLinkProcess();
		bean.setDataFromJSON(json);
		BudgetManagementLinkProcess dao = new BudgetManagementLinkProcess();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseBudgetManagementLinkProcess bean = new BaseBudgetManagementLinkProcess();
		bean.setDataFromJSON(json);
		BudgetManagementLinkProcess dao = new BudgetManagementLinkProcess();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseBudgetManagementLinkProcess bean = new BaseBudgetManagementLinkProcess();
		bean.setDataFromJSON(json);
		BudgetManagementLinkProcess dao = new BudgetManagementLinkProcess();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


