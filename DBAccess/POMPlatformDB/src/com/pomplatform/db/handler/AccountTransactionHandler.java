package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAccountTransaction;
import com.pomplatform.db.dao.AccountTransaction;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AccountTransactionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AccountTransactionHandler.class);

	public static BaseAccountTransaction getAccountTransactionById( 
		java.lang.Integer account_transaction_id
	) throws Exception
	{
		AccountTransaction dao = new AccountTransaction();
		dao.setAccountTransactionId(account_transaction_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAccountTransactionExists( com.pomplatform.db.bean.BaseAccountTransaction bean, String additional ) throws Exception {

		AccountTransaction dao = new AccountTransaction();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countAccountTransaction( com.pomplatform.db.bean.BaseAccountTransaction bean, String additional ) throws Exception {

		AccountTransaction dao = new AccountTransaction();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseAccountTransaction> queryAccountTransaction( com.pomplatform.db.bean.BaseAccountTransaction bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		AccountTransaction dao = new AccountTransaction();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseAccountTransaction> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseAccountTransaction> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseAccountTransaction addToAccountTransaction ( BaseAccountTransaction accounttransaction )  throws Exception {
		return addToAccountTransaction ( accounttransaction , false);
	}

	public static BaseAccountTransaction addToAccountTransaction ( BaseAccountTransaction accounttransaction, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		AccountTransaction dao = new AccountTransaction();
		dao.setDataFromBase(accounttransaction);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseAccountTransaction addUpdateAccountTransaction ( BaseAccountTransaction accounttransaction ) throws Exception {
		return addUpdateAccountTransaction ( accounttransaction , false);
	}

	public static BaseAccountTransaction addUpdateAccountTransaction ( BaseAccountTransaction accounttransaction, boolean singleTransaction  ) throws Exception {
		if(accounttransaction.getAccountTransactionId() == null) return addToAccountTransaction(accounttransaction);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		AccountTransaction dao = new AccountTransaction();
		dao.setDataFromBase(accounttransaction);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(accounttransaction); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteAccountTransaction ( BaseAccountTransaction bean ) throws Exception {
		AccountTransaction dao = new AccountTransaction();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseAccountTransaction updateAccountTransaction ( BaseAccountTransaction accounttransaction ) throws Exception {
		AccountTransaction dao = new AccountTransaction();
		dao.setAccountTransactionId( accounttransaction.getAccountTransactionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(accounttransaction);
			result = dao.update();
		}
		return result == 1 ? accounttransaction : null ;
	}

	public static BaseAccountTransaction updateAccountTransactionDirect( BaseAccountTransaction accounttransaction ) throws Exception {
		AccountTransaction dao = new AccountTransaction();
		int result = 0;
		dao.setDataFromBase(accounttransaction);
		result = dao.update();
		return result == 1 ? accounttransaction : null ;
	}

	public static int setDeleteConditions(BaseAccountTransaction bean, AccountTransaction dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAccountTransactionId() != null) {
			dao.setConditionAccountTransactionId("=", bean.getAccountTransactionId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getAccountId() != null) {
				dao.setConditionAccountId("=", bean.getAccountId());
				count++;
			}
			if(bean.getBusinessTypeId() != null) {
				dao.setConditionBusinessTypeId("=", bean.getBusinessTypeId());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
			if(bean.getDetailBusinessId() != null) {
				dao.setConditionDetailBusinessId("=", bean.getDetailBusinessId());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseAccountTransaction bean, AccountTransaction dao){
		int count = 0;
		if(bean.getAccountTransactionId() != null) {
			dao.setConditionAccountTransactionId("=", bean.getAccountTransactionId());
			count++;
		}
		if(bean.getAccountId() != null) {
			dao.setConditionAccountId("=", bean.getAccountId());
			count++;
		}
		if(bean.getBusinessTypeId() != null) {
			dao.setConditionBusinessTypeId("=", bean.getBusinessTypeId());
			count++;
		}
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		if(bean.getDetailBusinessId() != null) {
			dao.setConditionDetailBusinessId("=", bean.getDetailBusinessId());
			count++;
		}
		if(bean.getOriginalCurrencyDebit() != null) {
			dao.setConditionOriginalCurrencyDebit("=", bean.getOriginalCurrencyDebit());
			count++;
		}
		if(bean.getOriginalCurrencyCredit() != null) {
			dao.setConditionOriginalCurrencyCredit("=", bean.getOriginalCurrencyCredit());
			count++;
		}
		if(bean.getExchangeRate() != null) {
			dao.setConditionExchangeRate("=", bean.getExchangeRate());
			count++;
		}
		if(bean.getStandardCurrencyDebit() != null) {
			dao.setConditionStandardCurrencyDebit("=", bean.getStandardCurrencyDebit());
			count++;
		}
		if(bean.getStandardCurrencyCredit() != null) {
			dao.setConditionStandardCurrencyCredit("=", bean.getStandardCurrencyCredit());
			count++;
		}
		if(bean.getBalance() != null) {
			dao.setConditionBalance("=", bean.getBalance());
			count++;
		}
		if(bean.getRecordTime() != null) {
			dao.setConditionRecordTime(">=", bean.getRecordTime());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseAccountTransaction bean = new BaseAccountTransaction();
		bean.setDataFromJSON(json);
		AccountTransaction dao = new AccountTransaction();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseAccountTransaction> rlist = new BaseCollection<>();
		BaseAccountTransaction bean = new BaseAccountTransaction();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		AccountTransaction dao = new AccountTransaction();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseAccountTransaction> result = dao.conditionalLoad(addtion);
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
		BaseAccountTransaction bean = new BaseAccountTransaction();
		bean.setDataFromJSON(json);
		AccountTransaction dao = new AccountTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseAccountTransaction bean = new BaseAccountTransaction();
		bean.setDataFromJSON(json);
		AccountTransaction dao = new AccountTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseAccountTransaction bean = new BaseAccountTransaction();
		bean.setDataFromJSON(json);
		AccountTransaction dao = new AccountTransaction();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseAccountTransaction bean = new BaseAccountTransaction();
		bean.setDataFromJSON(json);
		AccountTransaction dao = new AccountTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


