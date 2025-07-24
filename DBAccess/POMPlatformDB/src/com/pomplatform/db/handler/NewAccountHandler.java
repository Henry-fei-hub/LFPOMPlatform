package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseNewAccount;
import com.pomplatform.db.dao.NewAccount;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class NewAccountHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(NewAccountHandler.class);

	public static BaseNewAccount getNewAccountById( 
		java.lang.Integer account_id
	) throws Exception
	{
		NewAccount dao = new NewAccount();
		dao.setAccountId(account_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isNewAccountExists( com.pomplatform.db.bean.BaseNewAccount bean, String additional ) throws Exception {

		NewAccount dao = new NewAccount();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countNewAccount( com.pomplatform.db.bean.BaseNewAccount bean, String additional ) throws Exception {

		NewAccount dao = new NewAccount();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseNewAccount> queryNewAccount( com.pomplatform.db.bean.BaseNewAccount bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		NewAccount dao = new NewAccount();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseNewAccount> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseNewAccount> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseNewAccount addToNewAccount ( BaseNewAccount newaccount )  throws Exception {
		return addToNewAccount ( newaccount , false);
	}

	public static BaseNewAccount addToNewAccount ( BaseNewAccount newaccount, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		NewAccount dao = new NewAccount();
		dao.setDataFromBase(newaccount);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseNewAccount addUpdateNewAccount ( BaseNewAccount newaccount ) throws Exception {
		return addUpdateNewAccount ( newaccount , false);
	}

	public static BaseNewAccount addUpdateNewAccount ( BaseNewAccount newaccount, boolean singleTransaction  ) throws Exception {
		if(newaccount.getAccountId() == null) return addToNewAccount(newaccount);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		NewAccount dao = new NewAccount();
		dao.setDataFromBase(newaccount);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(newaccount); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteNewAccount ( BaseNewAccount bean ) throws Exception {
		NewAccount dao = new NewAccount();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseNewAccount updateNewAccount ( BaseNewAccount newaccount ) throws Exception {
		NewAccount dao = new NewAccount();
		dao.setAccountId( newaccount.getAccountId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(newaccount);
			result = dao.update();
		}
		return result == 1 ? newaccount : null ;
	}

	public static BaseNewAccount updateNewAccountDirect( BaseNewAccount newaccount ) throws Exception {
		NewAccount dao = new NewAccount();
		int result = 0;
		dao.setDataFromBase(newaccount);
		result = dao.update();
		return result == 1 ? newaccount : null ;
	}

	public static int setDeleteConditions(BaseNewAccount bean, NewAccount dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAccountId() != null) {
			dao.setConditionAccountId("=", bean.getAccountId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getAccountType() != null) {
				dao.setConditionAccountType("=", bean.getAccountType());
				count++;
			}
			if(bean.getAccountCode() != null) {
				dao.setConditionAccountCode("=", bean.getAccountCode());
				count++;
			}
			if(bean.getAccountName() != null) {
				dao.setConditionAccountName("=", bean.getAccountName());
				count++;
			}
			if(bean.getOwnerId() != null) {
				dao.setConditionOwnerId("=", bean.getOwnerId());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getOrderId() != null) {
				dao.setConditionOrderId("=", bean.getOrderId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseNewAccount bean, NewAccount dao){
		int count = 0;
		if(bean.getAccountId() != null) {
			dao.setConditionAccountId("=", bean.getAccountId());
			count++;
		}
		if(bean.getAccountType() != null) {
			dao.setConditionAccountType("=", bean.getAccountType());
			count++;
		}
		if(bean.getAccountCode() != null) {
			if(bean.getAccountCode().indexOf("%") >= 0)
				dao.setConditionAccountCode("like", bean.getAccountCode());
			else
				dao.setConditionAccountCode("=", bean.getAccountCode());
			count++;
		}
		if(bean.getAccountName() != null) {
			if(bean.getAccountName().indexOf("%") >= 0)
				dao.setConditionAccountName("like", bean.getAccountName());
			else
				dao.setConditionAccountName("=", bean.getAccountName());
			count++;
		}
		if(bean.getOwnerId() != null) {
			dao.setConditionOwnerId("=", bean.getOwnerId());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getBalance() != null) {
			dao.setConditionBalance("=", bean.getBalance());
			count++;
		}
		if(bean.getFreezingBalance() != null) {
			dao.setConditionFreezingBalance("=", bean.getFreezingBalance());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getOrderId() != null) {
			if(bean.getOrderId().indexOf("%") >= 0)
				dao.setConditionOrderId("like", bean.getOrderId());
			else
				dao.setConditionOrderId("=", bean.getOrderId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseNewAccount bean = new BaseNewAccount();
		bean.setDataFromJSON(json);
		NewAccount dao = new NewAccount();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseNewAccount> rlist = new BaseCollection<>();
		BaseNewAccount bean = new BaseNewAccount();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		NewAccount dao = new NewAccount();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseNewAccount> result = dao.conditionalLoad(addtion);
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
		BaseNewAccount bean = new BaseNewAccount();
		bean.setDataFromJSON(json);
		NewAccount dao = new NewAccount();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseNewAccount bean = new BaseNewAccount();
		bean.setDataFromJSON(json);
		NewAccount dao = new NewAccount();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseNewAccount bean = new BaseNewAccount();
		bean.setDataFromJSON(json);
		NewAccount dao = new NewAccount();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseNewAccount bean = new BaseNewAccount();
		bean.setDataFromJSON(json);
		NewAccount dao = new NewAccount();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


