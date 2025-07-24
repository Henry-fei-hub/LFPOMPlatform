package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAccountLinkBusinessType;
import com.pomplatform.db.dao.AccountLinkBusinessType;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AccountLinkBusinessTypeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AccountLinkBusinessTypeHandler.class);

	public static BaseAccountLinkBusinessType getAccountLinkBusinessTypeById( 
		java.lang.Integer account_link_business_type_id
	) throws Exception
	{
		AccountLinkBusinessType dao = new AccountLinkBusinessType();
		dao.setAccountLinkBusinessTypeId(account_link_business_type_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAccountLinkBusinessTypeExists( com.pomplatform.db.bean.BaseAccountLinkBusinessType bean, String additional ) throws Exception {

		AccountLinkBusinessType dao = new AccountLinkBusinessType();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countAccountLinkBusinessType( com.pomplatform.db.bean.BaseAccountLinkBusinessType bean, String additional ) throws Exception {

		AccountLinkBusinessType dao = new AccountLinkBusinessType();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseAccountLinkBusinessType> queryAccountLinkBusinessType( com.pomplatform.db.bean.BaseAccountLinkBusinessType bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		AccountLinkBusinessType dao = new AccountLinkBusinessType();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseAccountLinkBusinessType> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseAccountLinkBusinessType> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseAccountLinkBusinessType addToAccountLinkBusinessType ( BaseAccountLinkBusinessType accountlinkbusinesstype )  throws Exception {
		return addToAccountLinkBusinessType ( accountlinkbusinesstype , false);
	}

	public static BaseAccountLinkBusinessType addToAccountLinkBusinessType ( BaseAccountLinkBusinessType accountlinkbusinesstype, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		AccountLinkBusinessType dao = new AccountLinkBusinessType();
		dao.setDataFromBase(accountlinkbusinesstype);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseAccountLinkBusinessType addUpdateAccountLinkBusinessType ( BaseAccountLinkBusinessType accountlinkbusinesstype ) throws Exception {
		return addUpdateAccountLinkBusinessType ( accountlinkbusinesstype , false);
	}

	public static BaseAccountLinkBusinessType addUpdateAccountLinkBusinessType ( BaseAccountLinkBusinessType accountlinkbusinesstype, boolean singleTransaction  ) throws Exception {
		if(accountlinkbusinesstype.getAccountLinkBusinessTypeId() == null) return addToAccountLinkBusinessType(accountlinkbusinesstype);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		AccountLinkBusinessType dao = new AccountLinkBusinessType();
		dao.setDataFromBase(accountlinkbusinesstype);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(accountlinkbusinesstype); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteAccountLinkBusinessType ( BaseAccountLinkBusinessType bean ) throws Exception {
		AccountLinkBusinessType dao = new AccountLinkBusinessType();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseAccountLinkBusinessType updateAccountLinkBusinessType ( BaseAccountLinkBusinessType accountlinkbusinesstype ) throws Exception {
		AccountLinkBusinessType dao = new AccountLinkBusinessType();
		dao.setAccountLinkBusinessTypeId( accountlinkbusinesstype.getAccountLinkBusinessTypeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(accountlinkbusinesstype);
			result = dao.update();
		}
		return result == 1 ? accountlinkbusinesstype : null ;
	}

	public static BaseAccountLinkBusinessType updateAccountLinkBusinessTypeDirect( BaseAccountLinkBusinessType accountlinkbusinesstype ) throws Exception {
		AccountLinkBusinessType dao = new AccountLinkBusinessType();
		int result = 0;
		dao.setDataFromBase(accountlinkbusinesstype);
		result = dao.update();
		return result == 1 ? accountlinkbusinesstype : null ;
	}

	public static int setDeleteConditions(BaseAccountLinkBusinessType bean, AccountLinkBusinessType dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAccountLinkBusinessTypeId() != null) {
			dao.setConditionAccountLinkBusinessTypeId("=", bean.getAccountLinkBusinessTypeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getAccountType() != null) {
				dao.setConditionAccountType("=", bean.getAccountType());
				count++;
			}
			if(bean.getBusinessTypeId() != null) {
				dao.setConditionBusinessTypeId("=", bean.getBusinessTypeId());
				count++;
			}
			if(bean.getIsDebit() != null) {
				dao.setConditionIsDebit("=", bean.getIsDebit());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseAccountLinkBusinessType bean, AccountLinkBusinessType dao){
		int count = 0;
		if(bean.getAccountLinkBusinessTypeId() != null) {
			dao.setConditionAccountLinkBusinessTypeId("=", bean.getAccountLinkBusinessTypeId());
			count++;
		}
		if(bean.getAccountType() != null) {
			dao.setConditionAccountType("=", bean.getAccountType());
			count++;
		}
		if(bean.getBusinessTypeId() != null) {
			dao.setConditionBusinessTypeId("=", bean.getBusinessTypeId());
			count++;
		}
		if(bean.getIsDebit() != null) {
			dao.setConditionIsDebit("=", bean.getIsDebit());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseAccountLinkBusinessType bean = new BaseAccountLinkBusinessType();
		bean.setDataFromJSON(json);
		AccountLinkBusinessType dao = new AccountLinkBusinessType();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseAccountLinkBusinessType> rlist = new BaseCollection<>();
		BaseAccountLinkBusinessType bean = new BaseAccountLinkBusinessType();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		AccountLinkBusinessType dao = new AccountLinkBusinessType();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseAccountLinkBusinessType> result = dao.conditionalLoad(addtion);
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
		BaseAccountLinkBusinessType bean = new BaseAccountLinkBusinessType();
		bean.setDataFromJSON(json);
		AccountLinkBusinessType dao = new AccountLinkBusinessType();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseAccountLinkBusinessType bean = new BaseAccountLinkBusinessType();
		bean.setDataFromJSON(json);
		AccountLinkBusinessType dao = new AccountLinkBusinessType();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseAccountLinkBusinessType bean = new BaseAccountLinkBusinessType();
		bean.setDataFromJSON(json);
		AccountLinkBusinessType dao = new AccountLinkBusinessType();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseAccountLinkBusinessType bean = new BaseAccountLinkBusinessType();
		bean.setDataFromJSON(json);
		AccountLinkBusinessType dao = new AccountLinkBusinessType();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


