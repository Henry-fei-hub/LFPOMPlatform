package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseFinancialTransactionAccount;
import com.pomplatform.db.dao.FinancialTransactionAccount;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class FinancialTransactionAccountHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(FinancialTransactionAccountHandler.class);

	public static BaseFinancialTransactionAccount getFinancialTransactionAccountById( 
		java.lang.Integer financial_transaction_account_id
	) throws Exception
	{
		FinancialTransactionAccount dao = new FinancialTransactionAccount();
		dao.setFinancialTransactionAccountId(financial_transaction_account_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isFinancialTransactionAccountExists( com.pomplatform.db.bean.BaseFinancialTransactionAccount bean, String additional ) throws Exception {

		FinancialTransactionAccount dao = new FinancialTransactionAccount();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countFinancialTransactionAccount( com.pomplatform.db.bean.BaseFinancialTransactionAccount bean, String additional ) throws Exception {

		FinancialTransactionAccount dao = new FinancialTransactionAccount();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseFinancialTransactionAccount> queryFinancialTransactionAccount( com.pomplatform.db.bean.BaseFinancialTransactionAccount bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		FinancialTransactionAccount dao = new FinancialTransactionAccount();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseFinancialTransactionAccount> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseFinancialTransactionAccount> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseFinancialTransactionAccount addToFinancialTransactionAccount ( BaseFinancialTransactionAccount financialtransactionaccount )  throws Exception {
		return addToFinancialTransactionAccount ( financialtransactionaccount , false);
	}

	public static BaseFinancialTransactionAccount addToFinancialTransactionAccount ( BaseFinancialTransactionAccount financialtransactionaccount, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		FinancialTransactionAccount dao = new FinancialTransactionAccount();
		dao.setDataFromBase(financialtransactionaccount);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseFinancialTransactionAccount addUpdateFinancialTransactionAccount ( BaseFinancialTransactionAccount financialtransactionaccount ) throws Exception {
		return addUpdateFinancialTransactionAccount ( financialtransactionaccount , false);
	}

	public static BaseFinancialTransactionAccount addUpdateFinancialTransactionAccount ( BaseFinancialTransactionAccount financialtransactionaccount, boolean singleTransaction  ) throws Exception {
		if(financialtransactionaccount.getFinancialTransactionAccountId() == null) return addToFinancialTransactionAccount(financialtransactionaccount);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		FinancialTransactionAccount dao = new FinancialTransactionAccount();
		dao.setDataFromBase(financialtransactionaccount);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(financialtransactionaccount); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteFinancialTransactionAccount ( BaseFinancialTransactionAccount bean ) throws Exception {
		FinancialTransactionAccount dao = new FinancialTransactionAccount();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseFinancialTransactionAccount updateFinancialTransactionAccount ( BaseFinancialTransactionAccount financialtransactionaccount ) throws Exception {
		FinancialTransactionAccount dao = new FinancialTransactionAccount();
		dao.setFinancialTransactionAccountId( financialtransactionaccount.getFinancialTransactionAccountId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(financialtransactionaccount);
			result = dao.update();
		}
		return result == 1 ? financialtransactionaccount : null ;
	}

	public static BaseFinancialTransactionAccount updateFinancialTransactionAccountDirect( BaseFinancialTransactionAccount financialtransactionaccount ) throws Exception {
		FinancialTransactionAccount dao = new FinancialTransactionAccount();
		int result = 0;
		dao.setDataFromBase(financialtransactionaccount);
		result = dao.update();
		return result == 1 ? financialtransactionaccount : null ;
	}

	public static int setDeleteConditions(BaseFinancialTransactionAccount bean, FinancialTransactionAccount dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getFinancialTransactionAccountId() != null) {
			dao.setConditionFinancialTransactionAccountId("=", bean.getFinancialTransactionAccountId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getAccountType() != null) {
				dao.setConditionAccountType("=", bean.getAccountType());
				count++;
			}
			if(bean.getFinanceNo() != null) {
				dao.setConditionFinanceNo("=", bean.getFinanceNo());
				count++;
			}
			if(bean.getAccountName() != null) {
				dao.setConditionAccountName("=", bean.getAccountName());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getReimbursable() != null) {
				dao.setConditionReimbursable("=", bean.getReimbursable());
				count++;
			}
			if(bean.getAccountStatus() != null) {
				dao.setConditionAccountStatus("=", bean.getAccountStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseFinancialTransactionAccount bean, FinancialTransactionAccount dao){
		int count = 0;
		if(bean.getFinancialTransactionAccountId() != null) {
			dao.setConditionFinancialTransactionAccountId("=", bean.getFinancialTransactionAccountId());
			count++;
		}
		if(bean.getAccountType() != null) {
			dao.setConditionAccountType("=", bean.getAccountType());
			count++;
		}
		if(bean.getFinanceNo() != null) {
			if(bean.getFinanceNo().indexOf("%") >= 0)
				dao.setConditionFinanceNo("like", bean.getFinanceNo());
			else
				dao.setConditionFinanceNo("=", bean.getFinanceNo());
			count++;
		}
		if(bean.getAccountName() != null) {
			if(bean.getAccountName().indexOf("%") >= 0)
				dao.setConditionAccountName("like", bean.getAccountName());
			else
				dao.setConditionAccountName("=", bean.getAccountName());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getReimbursable() != null) {
			dao.setConditionReimbursable("=", bean.getReimbursable());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getAccountStatus() != null) {
			dao.setConditionAccountStatus("=", bean.getAccountStatus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseFinancialTransactionAccount bean = new BaseFinancialTransactionAccount();
		bean.setDataFromJSON(json);
		FinancialTransactionAccount dao = new FinancialTransactionAccount();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseFinancialTransactionAccount> rlist = new BaseCollection<>();
		BaseFinancialTransactionAccount bean = new BaseFinancialTransactionAccount();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		FinancialTransactionAccount dao = new FinancialTransactionAccount();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseFinancialTransactionAccount> result = dao.conditionalLoad(addtion);
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
		BaseFinancialTransactionAccount bean = new BaseFinancialTransactionAccount();
		bean.setDataFromJSON(json);
		FinancialTransactionAccount dao = new FinancialTransactionAccount();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseFinancialTransactionAccount bean = new BaseFinancialTransactionAccount();
		bean.setDataFromJSON(json);
		FinancialTransactionAccount dao = new FinancialTransactionAccount();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseFinancialTransactionAccount bean = new BaseFinancialTransactionAccount();
		bean.setDataFromJSON(json);
		FinancialTransactionAccount dao = new FinancialTransactionAccount();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseFinancialTransactionAccount bean = new BaseFinancialTransactionAccount();
		bean.setDataFromJSON(json);
		FinancialTransactionAccount dao = new FinancialTransactionAccount();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


