package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAccountWeightRecord;
import com.pomplatform.db.dao.AccountWeightRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AccountWeightRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AccountWeightRecordHandler.class);

	public static BaseAccountWeightRecord getAccountWeightRecordById( 
		java.lang.Integer account_weight_record_id
	) throws Exception
	{
		AccountWeightRecord dao = new AccountWeightRecord();
		dao.setAccountWeightRecordId(account_weight_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAccountWeightRecordExists( com.pomplatform.db.bean.BaseAccountWeightRecord bean, String additional ) throws Exception {

		AccountWeightRecord dao = new AccountWeightRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countAccountWeightRecord( com.pomplatform.db.bean.BaseAccountWeightRecord bean, String additional ) throws Exception {

		AccountWeightRecord dao = new AccountWeightRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseAccountWeightRecord> queryAccountWeightRecord( com.pomplatform.db.bean.BaseAccountWeightRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		AccountWeightRecord dao = new AccountWeightRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseAccountWeightRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseAccountWeightRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseAccountWeightRecord addToAccountWeightRecord ( BaseAccountWeightRecord accountweightrecord )  throws Exception {
		return addToAccountWeightRecord ( accountweightrecord , false);
	}

	public static BaseAccountWeightRecord addToAccountWeightRecord ( BaseAccountWeightRecord accountweightrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		AccountWeightRecord dao = new AccountWeightRecord();
		dao.setDataFromBase(accountweightrecord);
		int result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseAccountWeightRecord addUpdateAccountWeightRecord ( BaseAccountWeightRecord accountweightrecord ) throws Exception {
		return addUpdateAccountWeightRecord ( accountweightrecord , false);
	}

	public static BaseAccountWeightRecord addUpdateAccountWeightRecord ( BaseAccountWeightRecord accountweightrecord, boolean singleTransaction  ) throws Exception {
		if(accountweightrecord.getAccountWeightRecordId() == null) return addToAccountWeightRecord(accountweightrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		AccountWeightRecord dao = new AccountWeightRecord();
		dao.setDataFromBase(accountweightrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(accountweightrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteAccountWeightRecord ( BaseAccountWeightRecord bean ) throws Exception {
		AccountWeightRecord dao = new AccountWeightRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseAccountWeightRecord updateAccountWeightRecord ( BaseAccountWeightRecord accountweightrecord ) throws Exception {
		AccountWeightRecord dao = new AccountWeightRecord();
		dao.setAccountWeightRecordId( accountweightrecord.getAccountWeightRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(accountweightrecord);
			result = dao.update();
		}
		return result == 1 ? accountweightrecord : null ;
	}

	public static BaseAccountWeightRecord updateAccountWeightRecordDirect( BaseAccountWeightRecord accountweightrecord ) throws Exception {
		AccountWeightRecord dao = new AccountWeightRecord();
		int result = 0;
		dao.setDataFromBase(accountweightrecord);
		result = dao.update();
		return result == 1 ? accountweightrecord : null ;
	}

	public static int setDeleteConditions(BaseAccountWeightRecord bean, AccountWeightRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAccountWeightRecordId() != null) {
			dao.setConditionAccountWeightRecordId("=", bean.getAccountWeightRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTypeId() != null) {
				dao.setConditionTypeId("=", bean.getTypeId());
				count++;
			}
			if(bean.getTypeName() != null) {
				dao.setConditionTypeName("=", bean.getTypeName());
				count++;
			}
			if(bean.getPercentView() != null) {
				dao.setConditionPercentView("=", bean.getPercentView());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getLevel() != null) {
				dao.setConditionLevel("=", bean.getLevel());
				count++;
			}
			if(bean.getSettlementLevel() != null) {
				dao.setConditionSettlementLevel("=", bean.getSettlementLevel());
				count++;
			}
			if(bean.getOrderFlag() != null) {
				dao.setConditionOrderFlag("=", bean.getOrderFlag());
				count++;
			}
			if(bean.getEnabled() != null) {
				dao.setConditionEnabled("=", bean.getEnabled());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseAccountWeightRecord bean, AccountWeightRecord dao){
		int count = 0;
		if(bean.getAccountWeightRecordId() != null) {
			dao.setConditionAccountWeightRecordId("=", bean.getAccountWeightRecordId());
			count++;
		}
		if(bean.getTypeId() != null) {
			dao.setConditionTypeId("=", bean.getTypeId());
			count++;
		}
		if(bean.getTypeName() != null) {
			if(bean.getTypeName().indexOf("%") >= 0)
				dao.setConditionTypeName("like", bean.getTypeName());
			else
				dao.setConditionTypeName("=", bean.getTypeName());
			count++;
		}
		if(bean.getPercent() != null) {
			dao.setConditionPercent("=", bean.getPercent());
			count++;
		}
		if(bean.getPercentView() != null) {
			if(bean.getPercentView().indexOf("%") >= 0)
				dao.setConditionPercentView("like", bean.getPercentView());
			else
				dao.setConditionPercentView("=", bean.getPercentView());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getLevel() != null) {
			dao.setConditionLevel("=", bean.getLevel());
			count++;
		}
		if(bean.getSettlementLevel() != null) {
			dao.setConditionSettlementLevel("=", bean.getSettlementLevel());
			count++;
		}
		if(bean.getOrderFlag() != null) {
			dao.setConditionOrderFlag("=", bean.getOrderFlag());
			count++;
		}
		if(bean.getEnabled() != null) {
			dao.setConditionEnabled("=", bean.getEnabled());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseAccountWeightRecord bean = new BaseAccountWeightRecord();
		bean.setDataFromJSON(json);
		AccountWeightRecord dao = new AccountWeightRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseAccountWeightRecord> rlist = new BaseCollection<>();
		BaseAccountWeightRecord bean = new BaseAccountWeightRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		AccountWeightRecord dao = new AccountWeightRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseAccountWeightRecord> result = dao.conditionalLoad(addtion);
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
		BaseAccountWeightRecord bean = new BaseAccountWeightRecord();
		bean.setDataFromJSON(json);
		AccountWeightRecord dao = new AccountWeightRecord();
		dao.setDataFromBase(bean);
		int num = dao.save(false);
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseAccountWeightRecord bean = new BaseAccountWeightRecord();
		bean.setDataFromJSON(json);
		AccountWeightRecord dao = new AccountWeightRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseAccountWeightRecord bean = new BaseAccountWeightRecord();
		bean.setDataFromJSON(json);
		AccountWeightRecord dao = new AccountWeightRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseAccountWeightRecord bean = new BaseAccountWeightRecord();
		bean.setDataFromJSON(json);
		AccountWeightRecord dao = new AccountWeightRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(false); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


