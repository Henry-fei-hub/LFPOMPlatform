package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseNewAccountTransation;
import com.pomplatform.db.dao.NewAccountTransation;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class NewAccountTransationHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(NewAccountTransationHandler.class);

	public static BaseNewAccountTransation getNewAccountTransationById( 
		java.lang.Integer account_transaction_id
	) throws Exception
	{
		NewAccountTransation dao = new NewAccountTransation();
		dao.setAccountTransactionId(account_transaction_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isNewAccountTransationExists( com.pomplatform.db.bean.BaseNewAccountTransation bean, String additional ) throws Exception {

		NewAccountTransation dao = new NewAccountTransation();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countNewAccountTransation( com.pomplatform.db.bean.BaseNewAccountTransation bean, String additional ) throws Exception {

		NewAccountTransation dao = new NewAccountTransation();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseNewAccountTransation> queryNewAccountTransation( com.pomplatform.db.bean.BaseNewAccountTransation bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		NewAccountTransation dao = new NewAccountTransation();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseNewAccountTransation> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseNewAccountTransation> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseNewAccountTransation addToNewAccountTransation ( BaseNewAccountTransation newaccounttransation )  throws Exception {
		return addToNewAccountTransation ( newaccounttransation , false);
	}

	public static BaseNewAccountTransation addToNewAccountTransation ( BaseNewAccountTransation newaccounttransation, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		NewAccountTransation dao = new NewAccountTransation();
		dao.setDataFromBase(newaccounttransation);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseNewAccountTransation addUpdateNewAccountTransation ( BaseNewAccountTransation newaccounttransation ) throws Exception {
		return addUpdateNewAccountTransation ( newaccounttransation , false);
	}

	public static BaseNewAccountTransation addUpdateNewAccountTransation ( BaseNewAccountTransation newaccounttransation, boolean singleTransaction  ) throws Exception {
		if(newaccounttransation.getAccountTransactionId() == null) return addToNewAccountTransation(newaccounttransation);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		NewAccountTransation dao = new NewAccountTransation();
		dao.setDataFromBase(newaccounttransation);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(newaccounttransation); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteNewAccountTransation ( BaseNewAccountTransation bean ) throws Exception {
		NewAccountTransation dao = new NewAccountTransation();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseNewAccountTransation updateNewAccountTransation ( BaseNewAccountTransation newaccounttransation ) throws Exception {
		NewAccountTransation dao = new NewAccountTransation();
		dao.setAccountTransactionId( newaccounttransation.getAccountTransactionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(newaccounttransation);
			result = dao.update();
		}
		return result == 1 ? newaccounttransation : null ;
	}

	public static BaseNewAccountTransation updateNewAccountTransationDirect( BaseNewAccountTransation newaccounttransation ) throws Exception {
		NewAccountTransation dao = new NewAccountTransation();
		int result = 0;
		dao.setDataFromBase(newaccounttransation);
		result = dao.update();
		return result == 1 ? newaccounttransation : null ;
	}

	public static int setDeleteConditions(BaseNewAccountTransation bean, NewAccountTransation dao){
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
			if(bean.getItemCategory() != null) {
				dao.setConditionItemCategory("=", bean.getItemCategory());
				count++;
			}
			if(bean.getMainProjectCode() != null) {
				dao.setConditionMainProjectCode("=", bean.getMainProjectCode());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getAccountCode() != null) {
				dao.setConditionAccountCode("=", bean.getAccountCode());
				count++;
			}
			if(bean.getRunningAccount() != null) {
				dao.setConditionRunningAccount("=", bean.getRunningAccount());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseNewAccountTransation bean, NewAccountTransation dao){
		int count = 0;
		if(bean.getAccountTransactionId() != null) {
			dao.setConditionAccountTransactionId("=", bean.getAccountTransactionId());
			count++;
		}
		if(bean.getAccountId() != null) {
			dao.setConditionAccountId("=", bean.getAccountId());
			count++;
		}
		if(bean.getOriginalCurrencyDebit() != null) {
			dao.setConditionOriginalCurrencyDebit("=", bean.getOriginalCurrencyDebit());
			count++;
		}
		if(bean.getOriginalCurrencyLoan() != null) {
			dao.setConditionOriginalCurrencyLoan("=", bean.getOriginalCurrencyLoan());
			count++;
		}
		if(bean.getExchangeRate() != null) {
			dao.setConditionExchangeRate("=", bean.getExchangeRate());
			count++;
		}
		if(bean.getStandardMoneyDebit() != null) {
			dao.setConditionStandardMoneyDebit("=", bean.getStandardMoneyDebit());
			count++;
		}
		if(bean.getStandardMoneyLoan() != null) {
			dao.setConditionStandardMoneyLoan("=", bean.getStandardMoneyLoan());
			count++;
		}
		if(bean.getItemCategory() != null) {
			dao.setConditionItemCategory("=", bean.getItemCategory());
			count++;
		}
		if(bean.getMainProjectCode() != null) {
			if(bean.getMainProjectCode().indexOf("%") >= 0)
				dao.setConditionMainProjectCode("like", bean.getMainProjectCode());
			else
				dao.setConditionMainProjectCode("=", bean.getMainProjectCode());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getAffiliationDate() != null) {
			dao.setConditionAffiliationDate(">=", bean.getAffiliationDate());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getAccountCode() != null) {
			if(bean.getAccountCode().indexOf("%") >= 0)
				dao.setConditionAccountCode("like", bean.getAccountCode());
			else
				dao.setConditionAccountCode("=", bean.getAccountCode());
			count++;
		}
		if(bean.getRunningAccount() != null) {
			if(bean.getRunningAccount().indexOf("%") >= 0)
				dao.setConditionRunningAccount("like", bean.getRunningAccount());
			else
				dao.setConditionRunningAccount("=", bean.getRunningAccount());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseNewAccountTransation bean = new BaseNewAccountTransation();
		bean.setDataFromJSON(json);
		NewAccountTransation dao = new NewAccountTransation();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseNewAccountTransation> rlist = new BaseCollection<>();
		BaseNewAccountTransation bean = new BaseNewAccountTransation();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		NewAccountTransation dao = new NewAccountTransation();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseNewAccountTransation> result = dao.conditionalLoad(addtion);
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
		BaseNewAccountTransation bean = new BaseNewAccountTransation();
		bean.setDataFromJSON(json);
		NewAccountTransation dao = new NewAccountTransation();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseNewAccountTransation bean = new BaseNewAccountTransation();
		bean.setDataFromJSON(json);
		NewAccountTransation dao = new NewAccountTransation();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseNewAccountTransation bean = new BaseNewAccountTransation();
		bean.setDataFromJSON(json);
		NewAccountTransation dao = new NewAccountTransation();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseNewAccountTransation bean = new BaseNewAccountTransation();
		bean.setDataFromJSON(json);
		NewAccountTransation dao = new NewAccountTransation();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


