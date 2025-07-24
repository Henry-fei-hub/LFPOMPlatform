package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseFinancialTransactionDetail;
import java.util.List;
import com.pomplatform.db.dao.FinancialTransactionDetail;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class FinancialTransactionDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(FinancialTransactionDetailHandler.class);

	public static BaseFinancialTransactionDetail getFinancialTransactionDetailById( 
		java.lang.Integer financial_transaction_detail_id
	) throws Exception
	{
		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		dao.setFinancialTransactionDetailId(financial_transaction_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isFinancialTransactionDetailExists( com.pomplatform.db.bean.BaseFinancialTransactionDetail bean, String additional ) throws Exception {

		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countFinancialTransactionDetail( com.pomplatform.db.bean.BaseFinancialTransactionDetail bean, String additional ) throws Exception {

		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseFinancialTransactionDetail> queryFinancialTransactionDetail( com.pomplatform.db.bean.BaseFinancialTransactionDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseFinancialTransactionDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseFinancialTransactionDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseFinancialTransactionDetail addToFinancialTransactionDetail ( BaseFinancialTransactionDetail financialtransactiondetail )  throws Exception {
		return addToFinancialTransactionDetail ( financialtransactiondetail , false);
	}

	public static BaseFinancialTransactionDetail addToFinancialTransactionDetail ( BaseFinancialTransactionDetail financialtransactiondetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		dao.setDataFromBase(financialtransactiondetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseFinancialTransactionDetail addUpdateFinancialTransactionDetail ( BaseFinancialTransactionDetail financialtransactiondetail ) throws Exception {
		return addUpdateFinancialTransactionDetail ( financialtransactiondetail , false);
	}

	public static BaseFinancialTransactionDetail addUpdateFinancialTransactionDetail ( BaseFinancialTransactionDetail financialtransactiondetail, boolean singleTransaction  ) throws Exception {
		if(financialtransactiondetail.getFinancialTransactionDetailId() == null) return addToFinancialTransactionDetail(financialtransactiondetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		dao.setDataFromBase(financialtransactiondetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(financialtransactiondetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteFinancialTransactionDetail ( BaseFinancialTransactionDetail bean ) throws Exception {
		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseFinancialTransactionDetail updateFinancialTransactionDetail ( BaseFinancialTransactionDetail financialtransactiondetail ) throws Exception {
		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		dao.setFinancialTransactionDetailId( financialtransactiondetail.getFinancialTransactionDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(financialtransactiondetail);
			result = dao.update();
		}
		return result == 1 ? financialtransactiondetail : null ;
	}

	public static BaseFinancialTransactionDetail updateFinancialTransactionDetailDirect( BaseFinancialTransactionDetail financialtransactiondetail ) throws Exception {
		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		int result = 0;
		dao.setDataFromBase(financialtransactiondetail);
		result = dao.update();
		return result == 1 ? financialtransactiondetail : null ;
	}

	public static int setDeleteConditions(BaseFinancialTransactionDetail bean, FinancialTransactionDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getFinancialTransactionDetailId() != null) {
			dao.setConditionFinancialTransactionDetailId("=", bean.getFinancialTransactionDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFinancialTransactionAccountId() != null) {
				dao.setConditionFinancialTransactionAccountId("=", bean.getFinancialTransactionAccountId());
				count++;
			}
			if(bean.getSummary() != null) {
				dao.setConditionSummary("=", bean.getSummary());
				count++;
			}
			if(bean.getCurrencyType() != null) {
				dao.setConditionCurrencyType("=", bean.getCurrencyType());
				count++;
			}
			if(bean.getOperatorAccountId() != null) {
				dao.setConditionOperatorAccountId("=", bean.getOperatorAccountId());
				count++;
			}
			if(bean.getIsLocked() != null) {
				dao.setConditionIsLocked("=", bean.getIsLocked());
				count++;
			}
			if(bean.getIsHumanAdd() != null) {
				dao.setConditionIsHumanAdd("=", bean.getIsHumanAdd());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
			if(bean.getProcessInstanceId() != null) {
				dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
				count++;
			}
			if(bean.getProcessBillListId() != null) {
				dao.setConditionProcessBillListId("=", bean.getProcessBillListId());
				count++;
			}
			if(bean.getIsCompleted() != null) {
				dao.setConditionIsCompleted("=", bean.getIsCompleted());
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

	public static int setConditions(BaseFinancialTransactionDetail bean, FinancialTransactionDetail dao){
		int count = 0;
		if(bean.getFinancialTransactionDetailId() != null) {
			dao.setConditionFinancialTransactionDetailId("=", bean.getFinancialTransactionDetailId());
			count++;
		}
		if(bean.getFinancialTransactionAccountId() != null) {
			dao.setConditionFinancialTransactionAccountId("=", bean.getFinancialTransactionAccountId());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getSummary() != null) {
			if(bean.getSummary().indexOf("%") >= 0)
				dao.setConditionSummary("like", bean.getSummary());
			else
				dao.setConditionSummary("=", bean.getSummary());
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
		if(bean.getOperatorAccountId() != null) {
			dao.setConditionOperatorAccountId("=", bean.getOperatorAccountId());
			count++;
		}
		if(bean.getIsLocked() != null) {
			dao.setConditionIsLocked("=", bean.getIsLocked());
			count++;
		}
		if(bean.getIsHumanAdd() != null) {
			dao.setConditionIsHumanAdd("=", bean.getIsHumanAdd());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		if(bean.getProcessInstanceId() != null) {
			dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
			count++;
		}
		if(bean.getProcessBillListId() != null) {
			dao.setConditionProcessBillListId("=", bean.getProcessBillListId());
			count++;
		}
		if(bean.getIsCompleted() != null) {
			dao.setConditionIsCompleted("=", bean.getIsCompleted());
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
		BaseFinancialTransactionDetail bean = new BaseFinancialTransactionDetail();
		bean.setDataFromJSON(json);
		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseFinancialTransactionDetail> rlist = new BaseCollection<>();
		BaseFinancialTransactionDetail bean = new BaseFinancialTransactionDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseFinancialTransactionDetail> result = dao.conditionalLoad(addtion);
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
		BaseFinancialTransactionDetail bean = new BaseFinancialTransactionDetail();
		bean.setDataFromJSON(json);
		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseFinancialTransactionDetail bean = new BaseFinancialTransactionDetail();
		bean.setDataFromJSON(json);
		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseFinancialTransactionDetail bean = new BaseFinancialTransactionDetail();
		bean.setDataFromJSON(json);
		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseFinancialTransactionDetail bean = new BaseFinancialTransactionDetail();
		bean.setDataFromJSON(json);
		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


