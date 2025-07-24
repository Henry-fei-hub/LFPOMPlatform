package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseFinancialAccountInitAmount;
import java.util.List;
import com.pomplatform.db.dao.FinancialAccountInitAmount;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class FinancialAccountInitAmountHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(FinancialAccountInitAmountHandler.class);

	public static BaseFinancialAccountInitAmount getFinancialAccountInitAmountById( 
		java.lang.Integer financial_account_init_amount_id
	) throws Exception
	{
		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		dao.setFinancialAccountInitAmountId(financial_account_init_amount_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isFinancialAccountInitAmountExists( com.pomplatform.db.bean.BaseFinancialAccountInitAmount bean, String additional ) throws Exception {

		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countFinancialAccountInitAmount( com.pomplatform.db.bean.BaseFinancialAccountInitAmount bean, String additional ) throws Exception {

		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseFinancialAccountInitAmount> queryFinancialAccountInitAmount( com.pomplatform.db.bean.BaseFinancialAccountInitAmount bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseFinancialAccountInitAmount> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseFinancialAccountInitAmount> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseFinancialAccountInitAmount addToFinancialAccountInitAmount ( BaseFinancialAccountInitAmount financialaccountinitamount )  throws Exception {
		return addToFinancialAccountInitAmount ( financialaccountinitamount , false);
	}

	public static BaseFinancialAccountInitAmount addToFinancialAccountInitAmount ( BaseFinancialAccountInitAmount financialaccountinitamount, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		dao.setDataFromBase(financialaccountinitamount);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseFinancialAccountInitAmount addUpdateFinancialAccountInitAmount ( BaseFinancialAccountInitAmount financialaccountinitamount ) throws Exception {
		return addUpdateFinancialAccountInitAmount ( financialaccountinitamount , false);
	}

	public static BaseFinancialAccountInitAmount addUpdateFinancialAccountInitAmount ( BaseFinancialAccountInitAmount financialaccountinitamount, boolean singleTransaction  ) throws Exception {
		if(financialaccountinitamount.getFinancialAccountInitAmountId() == null) return addToFinancialAccountInitAmount(financialaccountinitamount);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		dao.setDataFromBase(financialaccountinitamount);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(financialaccountinitamount); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteFinancialAccountInitAmount ( BaseFinancialAccountInitAmount bean ) throws Exception {
		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseFinancialAccountInitAmount updateFinancialAccountInitAmount ( BaseFinancialAccountInitAmount financialaccountinitamount ) throws Exception {
		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		dao.setFinancialAccountInitAmountId( financialaccountinitamount.getFinancialAccountInitAmountId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(financialaccountinitamount);
			result = dao.update();
		}
		return result == 1 ? financialaccountinitamount : null ;
	}

	public static BaseFinancialAccountInitAmount updateFinancialAccountInitAmountDirect( BaseFinancialAccountInitAmount financialaccountinitamount ) throws Exception {
		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		int result = 0;
		dao.setDataFromBase(financialaccountinitamount);
		result = dao.update();
		return result == 1 ? financialaccountinitamount : null ;
	}

	public static int setDeleteConditions(BaseFinancialAccountInitAmount bean, FinancialAccountInitAmount dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getFinancialAccountInitAmountId() != null) {
			dao.setConditionFinancialAccountInitAmountId("=", bean.getFinancialAccountInitAmountId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFinancialTransactionAccountId() != null) {
				dao.setConditionFinancialTransactionAccountId("=", bean.getFinancialTransactionAccountId());
				count++;
			}
			if(bean.getCurrencyType() != null) {
				dao.setConditionCurrencyType("=", bean.getCurrencyType());
				count++;
			}
			if(bean.getSummary() != null) {
				dao.setConditionSummary("=", bean.getSummary());
				count++;
			}
			if(bean.getAttachmentId() != null) {
				dao.setConditionAttachmentId("=", bean.getAttachmentId());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseFinancialAccountInitAmount bean, FinancialAccountInitAmount dao){
		int count = 0;
		if(bean.getFinancialAccountInitAmountId() != null) {
			dao.setConditionFinancialAccountInitAmountId("=", bean.getFinancialAccountInitAmountId());
			count++;
		}
		if(bean.getFinancialTransactionAccountId() != null) {
			dao.setConditionFinancialTransactionAccountId("=", bean.getFinancialTransactionAccountId());
			count++;
		}
		if(bean.getCurrencyType() != null) {
			dao.setConditionCurrencyType("=", bean.getCurrencyType());
			count++;
		}
		if(bean.getOriginalDebit() != null) {
			dao.setConditionOriginalDebit("=", bean.getOriginalDebit());
			count++;
		}
		if(bean.getOriginalCredit() != null) {
			dao.setConditionOriginalCredit("=", bean.getOriginalCredit());
			count++;
		}
		if(bean.getExchangeRate() != null) {
			dao.setConditionExchangeRate("=", bean.getExchangeRate());
			count++;
		}
		if(bean.getStandardDebit() != null) {
			dao.setConditionStandardDebit("=", bean.getStandardDebit());
			count++;
		}
		if(bean.getStandardCredit() != null) {
			dao.setConditionStandardCredit("=", bean.getStandardCredit());
			count++;
		}
		if(bean.getSummary() != null) {
			if(bean.getSummary().indexOf("%") >= 0)
				dao.setConditionSummary("like", bean.getSummary());
			else
				dao.setConditionSummary("=", bean.getSummary());
			count++;
		}
		if(bean.getAttachmentId() != null) {
			dao.setConditionAttachmentId("=", bean.getAttachmentId());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseFinancialAccountInitAmount bean = new BaseFinancialAccountInitAmount();
		bean.setDataFromJSON(json);
		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseFinancialAccountInitAmount> rlist = new BaseCollection<>();
		BaseFinancialAccountInitAmount bean = new BaseFinancialAccountInitAmount();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseFinancialAccountInitAmount> result = dao.conditionalLoad(addtion);
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
		BaseFinancialAccountInitAmount bean = new BaseFinancialAccountInitAmount();
		bean.setDataFromJSON(json);
		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseFinancialAccountInitAmount bean = new BaseFinancialAccountInitAmount();
		bean.setDataFromJSON(json);
		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseFinancialAccountInitAmount bean = new BaseFinancialAccountInitAmount();
		bean.setDataFromJSON(json);
		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseFinancialAccountInitAmount bean = new BaseFinancialAccountInitAmount();
		bean.setDataFromJSON(json);
		FinancialAccountInitAmount dao = new FinancialAccountInitAmount();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


