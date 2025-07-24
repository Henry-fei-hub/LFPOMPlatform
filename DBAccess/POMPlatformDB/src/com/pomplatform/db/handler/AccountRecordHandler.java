package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAccountRecord;
import com.pomplatform.db.dao.AccountRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AccountRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AccountRecordHandler.class);

	public static BaseAccountRecord getAccountRecordById( 
		java.lang.Integer account_record_id
	) throws Exception
	{
		AccountRecord dao = new AccountRecord();
		dao.setAccountRecordId(account_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAccountRecordExists( com.pomplatform.db.bean.BaseAccountRecord bean, String additional ) throws Exception {

		AccountRecord dao = new AccountRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countAccountRecord( com.pomplatform.db.bean.BaseAccountRecord bean, String additional ) throws Exception {

		AccountRecord dao = new AccountRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseAccountRecord> queryAccountRecord( com.pomplatform.db.bean.BaseAccountRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		AccountRecord dao = new AccountRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseAccountRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseAccountRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseAccountRecord addToAccountRecord ( BaseAccountRecord accountrecord )  throws Exception {
		return addToAccountRecord ( accountrecord , false);
	}

	public static BaseAccountRecord addToAccountRecord ( BaseAccountRecord accountrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		AccountRecord dao = new AccountRecord();
		dao.setDataFromBase(accountrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseAccountRecord addUpdateAccountRecord ( BaseAccountRecord accountrecord ) throws Exception {
		return addUpdateAccountRecord ( accountrecord , false);
	}

	public static BaseAccountRecord addUpdateAccountRecord ( BaseAccountRecord accountrecord, boolean singleTransaction  ) throws Exception {
		if(accountrecord.getAccountRecordId() == null) return addToAccountRecord(accountrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		AccountRecord dao = new AccountRecord();
		dao.setDataFromBase(accountrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(accountrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteAccountRecord ( BaseAccountRecord bean ) throws Exception {
		AccountRecord dao = new AccountRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseAccountRecord updateAccountRecord ( BaseAccountRecord accountrecord ) throws Exception {
		AccountRecord dao = new AccountRecord();
		dao.setAccountRecordId( accountrecord.getAccountRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(accountrecord);
			result = dao.update();
		}
		return result == 1 ? accountrecord : null ;
	}

	public static BaseAccountRecord updateAccountRecordDirect( BaseAccountRecord accountrecord ) throws Exception {
		AccountRecord dao = new AccountRecord();
		int result = 0;
		dao.setDataFromBase(accountrecord);
		result = dao.update();
		return result == 1 ? accountrecord : null ;
	}

	public static int setDeleteConditions(BaseAccountRecord bean, AccountRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAccountRecordId() != null) {
			dao.setConditionAccountRecordId("=", bean.getAccountRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getAccountId() != null) {
				dao.setConditionAccountId("=", bean.getAccountId());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
			if(bean.getBusinessTypeId() != null) {
				dao.setConditionBusinessTypeId("=", bean.getBusinessTypeId());
				count++;
			}
			if(bean.getAccountTypeId() != null) {
				dao.setConditionAccountTypeId("=", bean.getAccountTypeId());
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

	public static int setConditions(BaseAccountRecord bean, AccountRecord dao){
		int count = 0;
		if(bean.getAccountRecordId() != null) {
			dao.setConditionAccountRecordId("=", bean.getAccountRecordId());
			count++;
		}
		if(bean.getAccountId() != null) {
			dao.setConditionAccountId("=", bean.getAccountId());
			count++;
		}
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		if(bean.getBusinessTypeId() != null) {
			dao.setConditionBusinessTypeId("=", bean.getBusinessTypeId());
			count++;
		}
		if(bean.getAccountTypeId() != null) {
			dao.setConditionAccountTypeId("=", bean.getAccountTypeId());
			count++;
		}
		if(bean.getAchieveIntegral() != null) {
			dao.setConditionAchieveIntegral("=", bean.getAchieveIntegral());
			count++;
		}
		if(bean.getPayIntegral() != null) {
			dao.setConditionPayIntegral("=", bean.getPayIntegral());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
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
		BaseAccountRecord bean = new BaseAccountRecord();
		bean.setDataFromJSON(json);
		AccountRecord dao = new AccountRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseAccountRecord> rlist = new BaseCollection<>();
		BaseAccountRecord bean = new BaseAccountRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		AccountRecord dao = new AccountRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseAccountRecord> result = dao.conditionalLoad(addtion);
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
		BaseAccountRecord bean = new BaseAccountRecord();
		bean.setDataFromJSON(json);
		AccountRecord dao = new AccountRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseAccountRecord bean = new BaseAccountRecord();
		bean.setDataFromJSON(json);
		AccountRecord dao = new AccountRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseAccountRecord bean = new BaseAccountRecord();
		bean.setDataFromJSON(json);
		AccountRecord dao = new AccountRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseAccountRecord bean = new BaseAccountRecord();
		bean.setDataFromJSON(json);
		AccountRecord dao = new AccountRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


