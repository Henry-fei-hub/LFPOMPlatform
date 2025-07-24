package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAccount;
import com.pomplatform.db.dao.Account;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AccountHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AccountHandler.class);

	public static BaseAccount getAccountById( 
		java.lang.Integer account_id
	) throws Exception
	{
		Account dao = new Account();
		dao.setAccountId(account_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAccountExists( com.pomplatform.db.bean.BaseAccount bean, String additional ) throws Exception {

		Account dao = new Account();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countAccount( com.pomplatform.db.bean.BaseAccount bean, String additional ) throws Exception {

		Account dao = new Account();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseAccount> queryAccount( com.pomplatform.db.bean.BaseAccount bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Account dao = new Account();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseAccount> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseAccount> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseAccount addToAccount ( BaseAccount account )  throws Exception {
		return addToAccount ( account , false);
	}

	public static BaseAccount addToAccount ( BaseAccount account, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Account dao = new Account();
		dao.setDataFromBase(account);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseAccount addUpdateAccount ( BaseAccount account ) throws Exception {
		return addUpdateAccount ( account , false);
	}

	public static BaseAccount addUpdateAccount ( BaseAccount account, boolean singleTransaction  ) throws Exception {
		if(account.getAccountId() == null) return addToAccount(account);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Account dao = new Account();
		dao.setDataFromBase(account);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(account); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteAccount ( BaseAccount bean ) throws Exception {
		Account dao = new Account();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseAccount updateAccount ( BaseAccount account ) throws Exception {
		Account dao = new Account();
		dao.setAccountId( account.getAccountId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(account);
			result = dao.update();
		}
		return result == 1 ? account : null ;
	}

	public static BaseAccount updateAccountDirect( BaseAccount account ) throws Exception {
		Account dao = new Account();
		int result = 0;
		dao.setDataFromBase(account);
		result = dao.update();
		return result == 1 ? account : null ;
	}

	public static int setDeleteConditions(BaseAccount bean, Account dao){
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
			if(bean.getLeavel() != null) {
				dao.setConditionLeavel("=", bean.getLeavel());
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
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getIsDefault() != null) {
				dao.setConditionIsDefault("=", bean.getIsDefault());
				count++;
			}
			if(bean.getCanSum() != null) {
				dao.setConditionCanSum("=", bean.getCanSum());
				count++;
			}
			if(bean.getDestoryEmployeeId() != null) {
				dao.setConditionDestoryEmployeeId("=", bean.getDestoryEmployeeId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseAccount bean, Account dao){
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
		if(bean.getLeavel() != null) {
			dao.setConditionLeavel("=", bean.getLeavel());
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
		if(bean.getFrozenAmount() != null) {
			dao.setConditionFrozenAmount("=", bean.getFrozenAmount());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getDestoryTime() != null) {
			dao.setConditionDestoryTime(">=", bean.getDestoryTime());
			count++;
		}
		if(bean.getIsDefault() != null) {
			dao.setConditionIsDefault("=", bean.getIsDefault());
			count++;
		}
		if(bean.getCanSum() != null) {
			dao.setConditionCanSum("=", bean.getCanSum());
			count++;
		}
		if(bean.getDestoryEmployeeId() != null) {
			dao.setConditionDestoryEmployeeId("=", bean.getDestoryEmployeeId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseAccount bean = new BaseAccount();
		bean.setDataFromJSON(json);
		Account dao = new Account();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseAccount> rlist = new BaseCollection<>();
		BaseAccount bean = new BaseAccount();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Account dao = new Account();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseAccount> result = dao.conditionalLoad(addtion);
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
		BaseAccount bean = new BaseAccount();
		bean.setDataFromJSON(json);
		Account dao = new Account();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseAccount bean = new BaseAccount();
		bean.setDataFromJSON(json);
		Account dao = new Account();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseAccount bean = new BaseAccount();
		bean.setDataFromJSON(json);
		Account dao = new Account();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseAccount bean = new BaseAccount();
		bean.setDataFromJSON(json);
		Account dao = new Account();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


