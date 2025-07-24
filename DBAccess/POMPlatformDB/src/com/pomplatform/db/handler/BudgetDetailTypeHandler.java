package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBudgetDetailType;
import com.pomplatform.db.dao.BudgetDetailType;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class BudgetDetailTypeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(BudgetDetailTypeHandler.class);

	public static BaseBudgetDetailType getBudgetDetailTypeById( 
		java.lang.Integer budget_detail_type
	) throws Exception
	{
		BudgetDetailType dao = new BudgetDetailType();
		dao.setBudgetDetailType(budget_detail_type);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isBudgetDetailTypeExists( com.pomplatform.db.bean.BaseBudgetDetailType bean, String additional ) throws Exception {

		BudgetDetailType dao = new BudgetDetailType();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countBudgetDetailType( com.pomplatform.db.bean.BaseBudgetDetailType bean, String additional ) throws Exception {

		BudgetDetailType dao = new BudgetDetailType();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseBudgetDetailType> queryBudgetDetailType( com.pomplatform.db.bean.BaseBudgetDetailType bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		BudgetDetailType dao = new BudgetDetailType();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseBudgetDetailType> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseBudgetDetailType> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseBudgetDetailType addToBudgetDetailType ( BaseBudgetDetailType budgetdetailtype )  throws Exception {
		return addToBudgetDetailType ( budgetdetailtype , false);
	}

	public static BaseBudgetDetailType addToBudgetDetailType ( BaseBudgetDetailType budgetdetailtype, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		BudgetDetailType dao = new BudgetDetailType();
		dao.setDataFromBase(budgetdetailtype);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseBudgetDetailType addUpdateBudgetDetailType ( BaseBudgetDetailType budgetdetailtype ) throws Exception {
		return addUpdateBudgetDetailType ( budgetdetailtype , false);
	}

	public static BaseBudgetDetailType addUpdateBudgetDetailType ( BaseBudgetDetailType budgetdetailtype, boolean singleTransaction  ) throws Exception {
		if(budgetdetailtype.getBudgetDetailType() == null) return addToBudgetDetailType(budgetdetailtype);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		BudgetDetailType dao = new BudgetDetailType();
		dao.setDataFromBase(budgetdetailtype);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(budgetdetailtype); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteBudgetDetailType ( BaseBudgetDetailType bean ) throws Exception {
		BudgetDetailType dao = new BudgetDetailType();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseBudgetDetailType updateBudgetDetailType ( BaseBudgetDetailType budgetdetailtype ) throws Exception {
		BudgetDetailType dao = new BudgetDetailType();
		dao.setBudgetDetailType( budgetdetailtype.getBudgetDetailType() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(budgetdetailtype);
			result = dao.update();
		}
		return result == 1 ? budgetdetailtype : null ;
	}

	public static BaseBudgetDetailType updateBudgetDetailTypeDirect( BaseBudgetDetailType budgetdetailtype ) throws Exception {
		BudgetDetailType dao = new BudgetDetailType();
		int result = 0;
		dao.setDataFromBase(budgetdetailtype);
		result = dao.update();
		return result == 1 ? budgetdetailtype : null ;
	}

	public static int setDeleteConditions(BaseBudgetDetailType bean, BudgetDetailType dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getBudgetDetailType() != null) {
			dao.setConditionBudgetDetailType("=", bean.getBudgetDetailType());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBudgetDetailTypeKey() != null) {
				dao.setConditionBudgetDetailTypeKey("=", bean.getBudgetDetailTypeKey());
				count++;
			}
			if(bean.getBudgetDetailTypeValue() != null) {
				dao.setConditionBudgetDetailTypeValue("=", bean.getBudgetDetailTypeValue());
				count++;
			}
			if(bean.getIsEnable() != null) {
				dao.setConditionIsEnable("=", bean.getIsEnable());
				count++;
			}
			if(bean.getTypeId() != null) {
				dao.setConditionTypeId("=", bean.getTypeId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseBudgetDetailType bean, BudgetDetailType dao){
		int count = 0;
		if(bean.getBudgetDetailType() != null) {
			dao.setConditionBudgetDetailType("=", bean.getBudgetDetailType());
			count++;
		}
		if(bean.getBudgetDetailTypeKey() != null) {
			if(bean.getBudgetDetailTypeKey().indexOf("%") >= 0)
				dao.setConditionBudgetDetailTypeKey("like", bean.getBudgetDetailTypeKey());
			else
				dao.setConditionBudgetDetailTypeKey("=", bean.getBudgetDetailTypeKey());
			count++;
		}
		if(bean.getBudgetDetailTypeValue() != null) {
			if(bean.getBudgetDetailTypeValue().indexOf("%") >= 0)
				dao.setConditionBudgetDetailTypeValue("like", bean.getBudgetDetailTypeValue());
			else
				dao.setConditionBudgetDetailTypeValue("=", bean.getBudgetDetailTypeValue());
			count++;
		}
		if(bean.getIsEnable() != null) {
			dao.setConditionIsEnable("=", bean.getIsEnable());
			count++;
		}
		if(bean.getTypeId() != null) {
			dao.setConditionTypeId("=", bean.getTypeId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseBudgetDetailType bean = new BaseBudgetDetailType();
		bean.setDataFromJSON(json);
		BudgetDetailType dao = new BudgetDetailType();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseBudgetDetailType> rlist = new BaseCollection<>();
		BaseBudgetDetailType bean = new BaseBudgetDetailType();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		BudgetDetailType dao = new BudgetDetailType();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseBudgetDetailType> result = dao.conditionalLoad(addtion);
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
		BaseBudgetDetailType bean = new BaseBudgetDetailType();
		bean.setDataFromJSON(json);
		BudgetDetailType dao = new BudgetDetailType();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseBudgetDetailType bean = new BaseBudgetDetailType();
		bean.setDataFromJSON(json);
		BudgetDetailType dao = new BudgetDetailType();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseBudgetDetailType bean = new BaseBudgetDetailType();
		bean.setDataFromJSON(json);
		BudgetDetailType dao = new BudgetDetailType();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseBudgetDetailType bean = new BaseBudgetDetailType();
		bean.setDataFromJSON(json);
		BudgetDetailType dao = new BudgetDetailType();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


