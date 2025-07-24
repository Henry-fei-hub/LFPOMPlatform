package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCardManage;
import com.pomplatform.db.dao.CardManage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CardManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CardManageHandler.class);

	public static BaseCardManage getCardManageById( 
		java.lang.Integer card_manage_id
	) throws Exception
	{
		CardManage dao = new CardManage();
		dao.setCardManageId(card_manage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCardManageExists( com.pomplatform.db.bean.BaseCardManage bean, String additional ) throws Exception {

		CardManage dao = new CardManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCardManage( com.pomplatform.db.bean.BaseCardManage bean, String additional ) throws Exception {

		CardManage dao = new CardManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCardManage> queryCardManage( com.pomplatform.db.bean.BaseCardManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CardManage dao = new CardManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCardManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCardManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCardManage addToCardManage ( BaseCardManage cardmanage )  throws Exception {
		return addToCardManage ( cardmanage , false);
	}

	public static BaseCardManage addToCardManage ( BaseCardManage cardmanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CardManage dao = new CardManage();
		dao.setDataFromBase(cardmanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCardManage addUpdateCardManage ( BaseCardManage cardmanage ) throws Exception {
		return addUpdateCardManage ( cardmanage , false);
	}

	public static BaseCardManage addUpdateCardManage ( BaseCardManage cardmanage, boolean singleTransaction  ) throws Exception {
		if(cardmanage.getCardManageId() == null) return addToCardManage(cardmanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CardManage dao = new CardManage();
		dao.setDataFromBase(cardmanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cardmanage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCardManage ( BaseCardManage bean ) throws Exception {
		CardManage dao = new CardManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCardManage updateCardManage ( BaseCardManage cardmanage ) throws Exception {
		CardManage dao = new CardManage();
		dao.setCardManageId( cardmanage.getCardManageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cardmanage);
			result = dao.update();
		}
		return result == 1 ? cardmanage : null ;
	}

	public static BaseCardManage updateCardManageDirect( BaseCardManage cardmanage ) throws Exception {
		CardManage dao = new CardManage();
		int result = 0;
		dao.setDataFromBase(cardmanage);
		result = dao.update();
		return result == 1 ? cardmanage : null ;
	}

	public static int setDeleteConditions(BaseCardManage bean, CardManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCardManageId() != null) {
			dao.setConditionCardManageId("=", bean.getCardManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getObjectId() != null) {
				dao.setConditionObjectId("=", bean.getObjectId());
				count++;
			}
			if(bean.getObjectType() != null) {
				dao.setConditionObjectType("=", bean.getObjectType());
				count++;
			}
			if(bean.getBankId() != null) {
				dao.setConditionBankId("=", bean.getBankId());
				count++;
			}
			if(bean.getBankAccount() != null) {
				dao.setConditionBankAccount("=", bean.getBankAccount());
				count++;
			}
			if(bean.getBankAddress() != null) {
				dao.setConditionBankAddress("=", bean.getBankAddress());
				count++;
			}
			if(bean.getCardType() != null) {
				dao.setConditionCardType("=", bean.getCardType());
				count++;
			}
			if(bean.getDefaultCard() != null) {
				dao.setConditionDefaultCard("=", bean.getDefaultCard());
				count++;
			}
			if(bean.getEnabled() != null) {
				dao.setConditionEnabled("=", bean.getEnabled());
				count++;
			}
			if(bean.getCurrencyType() != null) {
				dao.setConditionCurrencyType("=", bean.getCurrencyType());
				count++;
			}
			if(bean.getCmbcCodeId() != null) {
				dao.setConditionCmbcCodeId("=", bean.getCmbcCodeId());
				count++;
			}
			if(bean.getTruePayment() != null) {
				dao.setConditionTruePayment("=", bean.getTruePayment());
				count++;
			}
			if(bean.getBankName() != null) {
				dao.setConditionBankName("=", bean.getBankName());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCardManage bean, CardManage dao){
		int count = 0;
		if(bean.getCardManageId() != null) {
			dao.setConditionCardManageId("=", bean.getCardManageId());
			count++;
		}
		if(bean.getObjectId() != null) {
			dao.setConditionObjectId("=", bean.getObjectId());
			count++;
		}
		if(bean.getObjectType() != null) {
			dao.setConditionObjectType("=", bean.getObjectType());
			count++;
		}
		if(bean.getBankId() != null) {
			dao.setConditionBankId("=", bean.getBankId());
			count++;
		}
		if(bean.getBankAccount() != null) {
			if(bean.getBankAccount().indexOf("%") >= 0)
				dao.setConditionBankAccount("like", bean.getBankAccount());
			else
				dao.setConditionBankAccount("=", bean.getBankAccount());
			count++;
		}
		if(bean.getBankAddress() != null) {
			if(bean.getBankAddress().indexOf("%") >= 0)
				dao.setConditionBankAddress("like", bean.getBankAddress());
			else
				dao.setConditionBankAddress("=", bean.getBankAddress());
			count++;
		}
		if(bean.getCardType() != null) {
			dao.setConditionCardType("=", bean.getCardType());
			count++;
		}
		if(bean.getDefaultCard() != null) {
			dao.setConditionDefaultCard("=", bean.getDefaultCard());
			count++;
		}
		if(bean.getEnabled() != null) {
			dao.setConditionEnabled("=", bean.getEnabled());
			count++;
		}
		if(bean.getCurrencyType() != null) {
			dao.setConditionCurrencyType("=", bean.getCurrencyType());
			count++;
		}
		if(bean.getCmbcCodeId() != null) {
			dao.setConditionCmbcCodeId("=", bean.getCmbcCodeId());
			count++;
		}
		if(bean.getTruePayment() != null) {
			dao.setConditionTruePayment("=", bean.getTruePayment());
			count++;
		}
		if(bean.getBankName() != null) {
			if(bean.getBankName().indexOf("%") >= 0)
				dao.setConditionBankName("like", bean.getBankName());
			else
				dao.setConditionBankName("=", bean.getBankName());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCardManage bean = new BaseCardManage();
		bean.setDataFromJSON(json);
		CardManage dao = new CardManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCardManage> rlist = new BaseCollection<>();
		BaseCardManage bean = new BaseCardManage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CardManage dao = new CardManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCardManage> result = dao.conditionalLoad(addtion);
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
		BaseCardManage bean = new BaseCardManage();
		bean.setDataFromJSON(json);
		CardManage dao = new CardManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCardManage bean = new BaseCardManage();
		bean.setDataFromJSON(json);
		CardManage dao = new CardManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCardManage bean = new BaseCardManage();
		bean.setDataFromJSON(json);
		CardManage dao = new CardManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCardManage bean = new BaseCardManage();
		bean.setDataFromJSON(json);
		CardManage dao = new CardManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


