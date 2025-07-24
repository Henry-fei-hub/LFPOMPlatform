package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBudgetManagementDetail;
import com.pomplatform.db.dao.BudgetManagementDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class BudgetManagementDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(BudgetManagementDetailHandler.class);

	public static BaseBudgetManagementDetail getBudgetManagementDetailById( 
		java.lang.Integer budget_management_detail_id
	) throws Exception
	{
		BudgetManagementDetail dao = new BudgetManagementDetail();
		dao.setBudgetManagementDetailId(budget_management_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isBudgetManagementDetailExists( com.pomplatform.db.bean.BaseBudgetManagementDetail bean, String additional ) throws Exception {

		BudgetManagementDetail dao = new BudgetManagementDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countBudgetManagementDetail( com.pomplatform.db.bean.BaseBudgetManagementDetail bean, String additional ) throws Exception {

		BudgetManagementDetail dao = new BudgetManagementDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseBudgetManagementDetail> queryBudgetManagementDetail( com.pomplatform.db.bean.BaseBudgetManagementDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		BudgetManagementDetail dao = new BudgetManagementDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseBudgetManagementDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseBudgetManagementDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseBudgetManagementDetail addToBudgetManagementDetail ( BaseBudgetManagementDetail budgetmanagementdetail )  throws Exception {
		return addToBudgetManagementDetail ( budgetmanagementdetail , false);
	}

	public static BaseBudgetManagementDetail addToBudgetManagementDetail ( BaseBudgetManagementDetail budgetmanagementdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		BudgetManagementDetail dao = new BudgetManagementDetail();
		dao.setDataFromBase(budgetmanagementdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseBudgetManagementDetail addUpdateBudgetManagementDetail ( BaseBudgetManagementDetail budgetmanagementdetail ) throws Exception {
		return addUpdateBudgetManagementDetail ( budgetmanagementdetail , false);
	}

	public static BaseBudgetManagementDetail addUpdateBudgetManagementDetail ( BaseBudgetManagementDetail budgetmanagementdetail, boolean singleTransaction  ) throws Exception {
		if(budgetmanagementdetail.getBudgetManagementDetailId() == null) return addToBudgetManagementDetail(budgetmanagementdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		BudgetManagementDetail dao = new BudgetManagementDetail();
		dao.setDataFromBase(budgetmanagementdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(budgetmanagementdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteBudgetManagementDetail ( BaseBudgetManagementDetail bean ) throws Exception {
		BudgetManagementDetail dao = new BudgetManagementDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseBudgetManagementDetail updateBudgetManagementDetail ( BaseBudgetManagementDetail budgetmanagementdetail ) throws Exception {
		BudgetManagementDetail dao = new BudgetManagementDetail();
		dao.setBudgetManagementDetailId( budgetmanagementdetail.getBudgetManagementDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(budgetmanagementdetail);
			result = dao.update();
		}
		return result == 1 ? budgetmanagementdetail : null ;
	}

	public static BaseBudgetManagementDetail updateBudgetManagementDetailDirect( BaseBudgetManagementDetail budgetmanagementdetail ) throws Exception {
		BudgetManagementDetail dao = new BudgetManagementDetail();
		int result = 0;
		dao.setDataFromBase(budgetmanagementdetail);
		result = dao.update();
		return result == 1 ? budgetmanagementdetail : null ;
	}

	public static int setDeleteConditions(BaseBudgetManagementDetail bean, BudgetManagementDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getBudgetManagementDetailId() != null) {
			dao.setConditionBudgetManagementDetailId("=", bean.getBudgetManagementDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBudgetManagementId() != null) {
				dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
				count++;
			}
			if(bean.getBdCode() != null) {
				dao.setConditionBdCode("=", bean.getBdCode());
				count++;
			}
			if(bean.getBddType() != null) {
				dao.setConditionBddType("=", bean.getBddType());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseBudgetManagementDetail bean, BudgetManagementDetail dao){
		int count = 0;
		if(bean.getBudgetManagementDetailId() != null) {
			dao.setConditionBudgetManagementDetailId("=", bean.getBudgetManagementDetailId());
			count++;
		}
		if(bean.getBudgetManagementId() != null) {
			dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
			count++;
		}
		if(bean.getBdCode() != null) {
			if(bean.getBdCode().indexOf("%") >= 0)
				dao.setConditionBdCode("like", bean.getBdCode());
			else
				dao.setConditionBdCode("=", bean.getBdCode());
			count++;
		}
		if(bean.getBddType() != null) {
			if(bean.getBddType().indexOf("%") >= 0)
				dao.setConditionBddType("like", bean.getBddType());
			else
				dao.setConditionBddType("=", bean.getBddType());
			count++;
		}
		if(bean.getBddAmount() != null) {
			dao.setConditionBddAmount("=", bean.getBddAmount());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseBudgetManagementDetail bean = new BaseBudgetManagementDetail();
		bean.setDataFromJSON(json);
		BudgetManagementDetail dao = new BudgetManagementDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseBudgetManagementDetail> rlist = new BaseCollection<>();
		BaseBudgetManagementDetail bean = new BaseBudgetManagementDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		BudgetManagementDetail dao = new BudgetManagementDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseBudgetManagementDetail> result = dao.conditionalLoad(addtion);
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
		BaseBudgetManagementDetail bean = new BaseBudgetManagementDetail();
		bean.setDataFromJSON(json);
		BudgetManagementDetail dao = new BudgetManagementDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseBudgetManagementDetail bean = new BaseBudgetManagementDetail();
		bean.setDataFromJSON(json);
		BudgetManagementDetail dao = new BudgetManagementDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseBudgetManagementDetail bean = new BaseBudgetManagementDetail();
		bean.setDataFromJSON(json);
		BudgetManagementDetail dao = new BudgetManagementDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseBudgetManagementDetail bean = new BaseBudgetManagementDetail();
		bean.setDataFromJSON(json);
		BudgetManagementDetail dao = new BudgetManagementDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


