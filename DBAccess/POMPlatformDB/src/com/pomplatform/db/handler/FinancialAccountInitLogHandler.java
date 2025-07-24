package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseFinancialAccountInitLog;
import com.pomplatform.db.dao.FinancialAccountInitLog;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class FinancialAccountInitLogHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(FinancialAccountInitLogHandler.class);

	public static BaseFinancialAccountInitLog getFinancialAccountInitLogById( 
		java.lang.Integer financial_account_init_logs_id
	) throws Exception
	{
		FinancialAccountInitLog dao = new FinancialAccountInitLog();
		dao.setFinancialAccountInitLogsId(financial_account_init_logs_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isFinancialAccountInitLogExists( com.pomplatform.db.bean.BaseFinancialAccountInitLog bean, String additional ) throws Exception {

		FinancialAccountInitLog dao = new FinancialAccountInitLog();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countFinancialAccountInitLog( com.pomplatform.db.bean.BaseFinancialAccountInitLog bean, String additional ) throws Exception {

		FinancialAccountInitLog dao = new FinancialAccountInitLog();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseFinancialAccountInitLog> queryFinancialAccountInitLog( com.pomplatform.db.bean.BaseFinancialAccountInitLog bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		FinancialAccountInitLog dao = new FinancialAccountInitLog();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseFinancialAccountInitLog> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseFinancialAccountInitLog> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseFinancialAccountInitLog addToFinancialAccountInitLog ( BaseFinancialAccountInitLog financialaccountinitlog )  throws Exception {
		return addToFinancialAccountInitLog ( financialaccountinitlog , false);
	}

	public static BaseFinancialAccountInitLog addToFinancialAccountInitLog ( BaseFinancialAccountInitLog financialaccountinitlog, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		FinancialAccountInitLog dao = new FinancialAccountInitLog();
		dao.setDataFromBase(financialaccountinitlog);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseFinancialAccountInitLog addUpdateFinancialAccountInitLog ( BaseFinancialAccountInitLog financialaccountinitlog ) throws Exception {
		return addUpdateFinancialAccountInitLog ( financialaccountinitlog , false);
	}

	public static BaseFinancialAccountInitLog addUpdateFinancialAccountInitLog ( BaseFinancialAccountInitLog financialaccountinitlog, boolean singleTransaction  ) throws Exception {
		if(financialaccountinitlog.getFinancialAccountInitLogsId() == null) return addToFinancialAccountInitLog(financialaccountinitlog);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		FinancialAccountInitLog dao = new FinancialAccountInitLog();
		dao.setDataFromBase(financialaccountinitlog);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(financialaccountinitlog); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteFinancialAccountInitLog ( BaseFinancialAccountInitLog bean ) throws Exception {
		FinancialAccountInitLog dao = new FinancialAccountInitLog();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseFinancialAccountInitLog updateFinancialAccountInitLog ( BaseFinancialAccountInitLog financialaccountinitlog ) throws Exception {
		FinancialAccountInitLog dao = new FinancialAccountInitLog();
		dao.setFinancialAccountInitLogsId( financialaccountinitlog.getFinancialAccountInitLogsId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(financialaccountinitlog);
			result = dao.update();
		}
		return result == 1 ? financialaccountinitlog : null ;
	}

	public static BaseFinancialAccountInitLog updateFinancialAccountInitLogDirect( BaseFinancialAccountInitLog financialaccountinitlog ) throws Exception {
		FinancialAccountInitLog dao = new FinancialAccountInitLog();
		int result = 0;
		dao.setDataFromBase(financialaccountinitlog);
		result = dao.update();
		return result == 1 ? financialaccountinitlog : null ;
	}

	public static int setDeleteConditions(BaseFinancialAccountInitLog bean, FinancialAccountInitLog dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getFinancialAccountInitLogsId() != null) {
			dao.setConditionFinancialAccountInitLogsId("=", bean.getFinancialAccountInitLogsId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContent() != null) {
				dao.setConditionContent("=", bean.getContent());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseFinancialAccountInitLog bean, FinancialAccountInitLog dao){
		int count = 0;
		if(bean.getFinancialAccountInitLogsId() != null) {
			dao.setConditionFinancialAccountInitLogsId("=", bean.getFinancialAccountInitLogsId());
			count++;
		}
		if(bean.getContent() != null) {
			if(bean.getContent().indexOf("%") >= 0)
				dao.setConditionContent("like", bean.getContent());
			else
				dao.setConditionContent("=", bean.getContent());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseFinancialAccountInitLog bean = new BaseFinancialAccountInitLog();
		bean.setDataFromJSON(json);
		FinancialAccountInitLog dao = new FinancialAccountInitLog();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseFinancialAccountInitLog> rlist = new BaseCollection<>();
		BaseFinancialAccountInitLog bean = new BaseFinancialAccountInitLog();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		FinancialAccountInitLog dao = new FinancialAccountInitLog();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseFinancialAccountInitLog> result = dao.conditionalLoad(addtion);
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
		BaseFinancialAccountInitLog bean = new BaseFinancialAccountInitLog();
		bean.setDataFromJSON(json);
		FinancialAccountInitLog dao = new FinancialAccountInitLog();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseFinancialAccountInitLog bean = new BaseFinancialAccountInitLog();
		bean.setDataFromJSON(json);
		FinancialAccountInitLog dao = new FinancialAccountInitLog();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseFinancialAccountInitLog bean = new BaseFinancialAccountInitLog();
		bean.setDataFromJSON(json);
		FinancialAccountInitLog dao = new FinancialAccountInitLog();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseFinancialAccountInitLog bean = new BaseFinancialAccountInitLog();
		bean.setDataFromJSON(json);
		FinancialAccountInitLog dao = new FinancialAccountInitLog();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


