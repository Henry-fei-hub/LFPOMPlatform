package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseFinancialTransactionWarning;
import com.pomplatform.db.dao.FinancialTransactionWarning;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class FinancialTransactionWarningHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(FinancialTransactionWarningHandler.class);

	public static BaseFinancialTransactionWarning getFinancialTransactionWarningById( 
		java.lang.Integer financial_transaction_warning_id
	) throws Exception
	{
		FinancialTransactionWarning dao = new FinancialTransactionWarning();
		dao.setFinancialTransactionWarningId(financial_transaction_warning_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isFinancialTransactionWarningExists( com.pomplatform.db.bean.BaseFinancialTransactionWarning bean, String additional ) throws Exception {

		FinancialTransactionWarning dao = new FinancialTransactionWarning();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countFinancialTransactionWarning( com.pomplatform.db.bean.BaseFinancialTransactionWarning bean, String additional ) throws Exception {

		FinancialTransactionWarning dao = new FinancialTransactionWarning();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseFinancialTransactionWarning> queryFinancialTransactionWarning( com.pomplatform.db.bean.BaseFinancialTransactionWarning bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		FinancialTransactionWarning dao = new FinancialTransactionWarning();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseFinancialTransactionWarning> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseFinancialTransactionWarning> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseFinancialTransactionWarning addToFinancialTransactionWarning ( BaseFinancialTransactionWarning financialtransactionwarning )  throws Exception {
		return addToFinancialTransactionWarning ( financialtransactionwarning , false);
	}

	public static BaseFinancialTransactionWarning addToFinancialTransactionWarning ( BaseFinancialTransactionWarning financialtransactionwarning, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		FinancialTransactionWarning dao = new FinancialTransactionWarning();
		dao.setDataFromBase(financialtransactionwarning);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseFinancialTransactionWarning addUpdateFinancialTransactionWarning ( BaseFinancialTransactionWarning financialtransactionwarning ) throws Exception {
		return addUpdateFinancialTransactionWarning ( financialtransactionwarning , false);
	}

	public static BaseFinancialTransactionWarning addUpdateFinancialTransactionWarning ( BaseFinancialTransactionWarning financialtransactionwarning, boolean singleTransaction  ) throws Exception {
		if(financialtransactionwarning.getFinancialTransactionWarningId() == null) return addToFinancialTransactionWarning(financialtransactionwarning);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		FinancialTransactionWarning dao = new FinancialTransactionWarning();
		dao.setDataFromBase(financialtransactionwarning);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(financialtransactionwarning); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteFinancialTransactionWarning ( BaseFinancialTransactionWarning bean ) throws Exception {
		FinancialTransactionWarning dao = new FinancialTransactionWarning();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseFinancialTransactionWarning updateFinancialTransactionWarning ( BaseFinancialTransactionWarning financialtransactionwarning ) throws Exception {
		FinancialTransactionWarning dao = new FinancialTransactionWarning();
		dao.setFinancialTransactionWarningId( financialtransactionwarning.getFinancialTransactionWarningId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(financialtransactionwarning);
			result = dao.update();
		}
		return result == 1 ? financialtransactionwarning : null ;
	}

	public static BaseFinancialTransactionWarning updateFinancialTransactionWarningDirect( BaseFinancialTransactionWarning financialtransactionwarning ) throws Exception {
		FinancialTransactionWarning dao = new FinancialTransactionWarning();
		int result = 0;
		dao.setDataFromBase(financialtransactionwarning);
		result = dao.update();
		return result == 1 ? financialtransactionwarning : null ;
	}

	public static int setDeleteConditions(BaseFinancialTransactionWarning bean, FinancialTransactionWarning dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getFinancialTransactionWarningId() != null) {
			dao.setConditionFinancialTransactionWarningId("=", bean.getFinancialTransactionWarningId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFinancialTransactionAccountId() != null) {
				dao.setConditionFinancialTransactionAccountId("=", bean.getFinancialTransactionAccountId());
				count++;
			}
			if(bean.getWarningContent() != null) {
				dao.setConditionWarningContent("=", bean.getWarningContent());
				count++;
			}
			if(bean.getIsEnabled() != null) {
				dao.setConditionIsEnabled("=", bean.getIsEnabled());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseFinancialTransactionWarning bean, FinancialTransactionWarning dao){
		int count = 0;
		if(bean.getFinancialTransactionWarningId() != null) {
			dao.setConditionFinancialTransactionWarningId("=", bean.getFinancialTransactionWarningId());
			count++;
		}
		if(bean.getFinancialTransactionAccountId() != null) {
			dao.setConditionFinancialTransactionAccountId("=", bean.getFinancialTransactionAccountId());
			count++;
		}
		if(bean.getWarningContent() != null) {
			if(bean.getWarningContent().indexOf("%") >= 0)
				dao.setConditionWarningContent("like", bean.getWarningContent());
			else
				dao.setConditionWarningContent("=", bean.getWarningContent());
			count++;
		}
		if(bean.getIsEnabled() != null) {
			dao.setConditionIsEnabled("=", bean.getIsEnabled());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseFinancialTransactionWarning bean = new BaseFinancialTransactionWarning();
		bean.setDataFromJSON(json);
		FinancialTransactionWarning dao = new FinancialTransactionWarning();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseFinancialTransactionWarning> rlist = new BaseCollection<>();
		BaseFinancialTransactionWarning bean = new BaseFinancialTransactionWarning();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		FinancialTransactionWarning dao = new FinancialTransactionWarning();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseFinancialTransactionWarning> result = dao.conditionalLoad(addtion);
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
		BaseFinancialTransactionWarning bean = new BaseFinancialTransactionWarning();
		bean.setDataFromJSON(json);
		FinancialTransactionWarning dao = new FinancialTransactionWarning();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseFinancialTransactionWarning bean = new BaseFinancialTransactionWarning();
		bean.setDataFromJSON(json);
		FinancialTransactionWarning dao = new FinancialTransactionWarning();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseFinancialTransactionWarning bean = new BaseFinancialTransactionWarning();
		bean.setDataFromJSON(json);
		FinancialTransactionWarning dao = new FinancialTransactionWarning();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseFinancialTransactionWarning bean = new BaseFinancialTransactionWarning();
		bean.setDataFromJSON(json);
		FinancialTransactionWarning dao = new FinancialTransactionWarning();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


