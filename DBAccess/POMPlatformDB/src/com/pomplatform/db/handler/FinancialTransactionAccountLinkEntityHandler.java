package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseFinancialTransactionAccountLinkEntity;
import com.pomplatform.db.dao.FinancialTransactionAccountLinkEntity;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class FinancialTransactionAccountLinkEntityHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(FinancialTransactionAccountLinkEntityHandler.class);

	public static BaseFinancialTransactionAccountLinkEntity getFinancialTransactionAccountLinkEntityById( 
		java.lang.Integer financial_transaction_account_link_entity_id
	) throws Exception
	{
		FinancialTransactionAccountLinkEntity dao = new FinancialTransactionAccountLinkEntity();
		dao.setFinancialTransactionAccountLinkEntityId(financial_transaction_account_link_entity_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isFinancialTransactionAccountLinkEntityExists( com.pomplatform.db.bean.BaseFinancialTransactionAccountLinkEntity bean, String additional ) throws Exception {

		FinancialTransactionAccountLinkEntity dao = new FinancialTransactionAccountLinkEntity();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countFinancialTransactionAccountLinkEntity( com.pomplatform.db.bean.BaseFinancialTransactionAccountLinkEntity bean, String additional ) throws Exception {

		FinancialTransactionAccountLinkEntity dao = new FinancialTransactionAccountLinkEntity();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseFinancialTransactionAccountLinkEntity> queryFinancialTransactionAccountLinkEntity( com.pomplatform.db.bean.BaseFinancialTransactionAccountLinkEntity bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		FinancialTransactionAccountLinkEntity dao = new FinancialTransactionAccountLinkEntity();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseFinancialTransactionAccountLinkEntity> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseFinancialTransactionAccountLinkEntity> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseFinancialTransactionAccountLinkEntity addToFinancialTransactionAccountLinkEntity ( BaseFinancialTransactionAccountLinkEntity financialtransactionaccountlinkentity )  throws Exception {
		return addToFinancialTransactionAccountLinkEntity ( financialtransactionaccountlinkentity , false);
	}

	public static BaseFinancialTransactionAccountLinkEntity addToFinancialTransactionAccountLinkEntity ( BaseFinancialTransactionAccountLinkEntity financialtransactionaccountlinkentity, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		FinancialTransactionAccountLinkEntity dao = new FinancialTransactionAccountLinkEntity();
		dao.setDataFromBase(financialtransactionaccountlinkentity);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseFinancialTransactionAccountLinkEntity addUpdateFinancialTransactionAccountLinkEntity ( BaseFinancialTransactionAccountLinkEntity financialtransactionaccountlinkentity ) throws Exception {
		return addUpdateFinancialTransactionAccountLinkEntity ( financialtransactionaccountlinkentity , false);
	}

	public static BaseFinancialTransactionAccountLinkEntity addUpdateFinancialTransactionAccountLinkEntity ( BaseFinancialTransactionAccountLinkEntity financialtransactionaccountlinkentity, boolean singleTransaction  ) throws Exception {
		if(financialtransactionaccountlinkentity.getFinancialTransactionAccountLinkEntityId() == null) return addToFinancialTransactionAccountLinkEntity(financialtransactionaccountlinkentity);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		FinancialTransactionAccountLinkEntity dao = new FinancialTransactionAccountLinkEntity();
		dao.setDataFromBase(financialtransactionaccountlinkentity);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(financialtransactionaccountlinkentity); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteFinancialTransactionAccountLinkEntity ( BaseFinancialTransactionAccountLinkEntity bean ) throws Exception {
		FinancialTransactionAccountLinkEntity dao = new FinancialTransactionAccountLinkEntity();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseFinancialTransactionAccountLinkEntity updateFinancialTransactionAccountLinkEntity ( BaseFinancialTransactionAccountLinkEntity financialtransactionaccountlinkentity ) throws Exception {
		FinancialTransactionAccountLinkEntity dao = new FinancialTransactionAccountLinkEntity();
		dao.setFinancialTransactionAccountLinkEntityId( financialtransactionaccountlinkentity.getFinancialTransactionAccountLinkEntityId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(financialtransactionaccountlinkentity);
			result = dao.update();
		}
		return result == 1 ? financialtransactionaccountlinkentity : null ;
	}

	public static BaseFinancialTransactionAccountLinkEntity updateFinancialTransactionAccountLinkEntityDirect( BaseFinancialTransactionAccountLinkEntity financialtransactionaccountlinkentity ) throws Exception {
		FinancialTransactionAccountLinkEntity dao = new FinancialTransactionAccountLinkEntity();
		int result = 0;
		dao.setDataFromBase(financialtransactionaccountlinkentity);
		result = dao.update();
		return result == 1 ? financialtransactionaccountlinkentity : null ;
	}

	public static int setDeleteConditions(BaseFinancialTransactionAccountLinkEntity bean, FinancialTransactionAccountLinkEntity dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getFinancialTransactionAccountLinkEntityId() != null) {
			dao.setConditionFinancialTransactionAccountLinkEntityId("=", bean.getFinancialTransactionAccountLinkEntityId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFinancialTransactionAccountId() != null) {
				dao.setConditionFinancialTransactionAccountId("=", bean.getFinancialTransactionAccountId());
				count++;
			}
			if(bean.getAccountType() != null) {
				dao.setConditionAccountType("=", bean.getAccountType());
				count++;
			}
			if(bean.getEntityId() != null) {
				dao.setConditionEntityId("=", bean.getEntityId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseFinancialTransactionAccountLinkEntity bean, FinancialTransactionAccountLinkEntity dao){
		int count = 0;
		if(bean.getFinancialTransactionAccountLinkEntityId() != null) {
			dao.setConditionFinancialTransactionAccountLinkEntityId("=", bean.getFinancialTransactionAccountLinkEntityId());
			count++;
		}
		if(bean.getFinancialTransactionAccountId() != null) {
			dao.setConditionFinancialTransactionAccountId("=", bean.getFinancialTransactionAccountId());
			count++;
		}
		if(bean.getAccountType() != null) {
			dao.setConditionAccountType("=", bean.getAccountType());
			count++;
		}
		if(bean.getEntityId() != null) {
			dao.setConditionEntityId("=", bean.getEntityId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseFinancialTransactionAccountLinkEntity bean = new BaseFinancialTransactionAccountLinkEntity();
		bean.setDataFromJSON(json);
		FinancialTransactionAccountLinkEntity dao = new FinancialTransactionAccountLinkEntity();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseFinancialTransactionAccountLinkEntity> rlist = new BaseCollection<>();
		BaseFinancialTransactionAccountLinkEntity bean = new BaseFinancialTransactionAccountLinkEntity();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		FinancialTransactionAccountLinkEntity dao = new FinancialTransactionAccountLinkEntity();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseFinancialTransactionAccountLinkEntity> result = dao.conditionalLoad(addtion);
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
		BaseFinancialTransactionAccountLinkEntity bean = new BaseFinancialTransactionAccountLinkEntity();
		bean.setDataFromJSON(json);
		FinancialTransactionAccountLinkEntity dao = new FinancialTransactionAccountLinkEntity();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseFinancialTransactionAccountLinkEntity bean = new BaseFinancialTransactionAccountLinkEntity();
		bean.setDataFromJSON(json);
		FinancialTransactionAccountLinkEntity dao = new FinancialTransactionAccountLinkEntity();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseFinancialTransactionAccountLinkEntity bean = new BaseFinancialTransactionAccountLinkEntity();
		bean.setDataFromJSON(json);
		FinancialTransactionAccountLinkEntity dao = new FinancialTransactionAccountLinkEntity();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseFinancialTransactionAccountLinkEntity bean = new BaseFinancialTransactionAccountLinkEntity();
		bean.setDataFromJSON(json);
		FinancialTransactionAccountLinkEntity dao = new FinancialTransactionAccountLinkEntity();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


