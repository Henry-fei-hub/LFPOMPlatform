package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseExchangeRate;
import com.pomplatform.db.dao.ExchangeRate;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ExchangeRateHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ExchangeRateHandler.class);

	public static BaseExchangeRate getExchangeRateById( 
		java.lang.Integer exchange_rate_id
	) throws Exception
	{
		ExchangeRate dao = new ExchangeRate();
		dao.setExchangeRateId(exchange_rate_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isExchangeRateExists( com.pomplatform.db.bean.BaseExchangeRate bean, String additional ) throws Exception {

		ExchangeRate dao = new ExchangeRate();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countExchangeRate( com.pomplatform.db.bean.BaseExchangeRate bean, String additional ) throws Exception {

		ExchangeRate dao = new ExchangeRate();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseExchangeRate> queryExchangeRate( com.pomplatform.db.bean.BaseExchangeRate bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ExchangeRate dao = new ExchangeRate();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseExchangeRate> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseExchangeRate> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseExchangeRate addToExchangeRate ( BaseExchangeRate exchangerate )  throws Exception {
		return addToExchangeRate ( exchangerate , false);
	}

	public static BaseExchangeRate addToExchangeRate ( BaseExchangeRate exchangerate, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ExchangeRate dao = new ExchangeRate();
		dao.setDataFromBase(exchangerate);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseExchangeRate addUpdateExchangeRate ( BaseExchangeRate exchangerate ) throws Exception {
		return addUpdateExchangeRate ( exchangerate , false);
	}

	public static BaseExchangeRate addUpdateExchangeRate ( BaseExchangeRate exchangerate, boolean singleTransaction  ) throws Exception {
		if(exchangerate.getExchangeRateId() == null) return addToExchangeRate(exchangerate);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ExchangeRate dao = new ExchangeRate();
		dao.setDataFromBase(exchangerate);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(exchangerate); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteExchangeRate ( BaseExchangeRate bean ) throws Exception {
		ExchangeRate dao = new ExchangeRate();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseExchangeRate updateExchangeRate ( BaseExchangeRate exchangerate ) throws Exception {
		ExchangeRate dao = new ExchangeRate();
		dao.setExchangeRateId( exchangerate.getExchangeRateId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(exchangerate);
			result = dao.update();
		}
		return result == 1 ? exchangerate : null ;
	}

	public static BaseExchangeRate updateExchangeRateDirect( BaseExchangeRate exchangerate ) throws Exception {
		ExchangeRate dao = new ExchangeRate();
		int result = 0;
		dao.setDataFromBase(exchangerate);
		result = dao.update();
		return result == 1 ? exchangerate : null ;
	}

	public static int setDeleteConditions(BaseExchangeRate bean, ExchangeRate dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getExchangeRateId() != null) {
			dao.setConditionExchangeRateId("=", bean.getExchangeRateId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCurrencyId() != null) {
				dao.setConditionCurrencyId("=", bean.getCurrencyId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseExchangeRate bean, ExchangeRate dao){
		int count = 0;
		if(bean.getExchangeRateId() != null) {
			dao.setConditionExchangeRateId("=", bean.getExchangeRateId());
			count++;
		}
		if(bean.getCurrencyId() != null) {
			dao.setConditionCurrencyId("=", bean.getCurrencyId());
			count++;
		}
		if(bean.getExchangeRate() != null) {
			dao.setConditionExchangeRate("=", bean.getExchangeRate());
			count++;
		}
		if(bean.getExchangeDate() != null) {
			dao.setConditionExchangeDate(">=", bean.getExchangeDate());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseExchangeRate bean = new BaseExchangeRate();
		bean.setDataFromJSON(json);
		ExchangeRate dao = new ExchangeRate();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseExchangeRate> rlist = new BaseCollection<>();
		BaseExchangeRate bean = new BaseExchangeRate();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ExchangeRate dao = new ExchangeRate();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseExchangeRate> result = dao.conditionalLoad(addtion);
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
		BaseExchangeRate bean = new BaseExchangeRate();
		bean.setDataFromJSON(json);
		ExchangeRate dao = new ExchangeRate();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseExchangeRate bean = new BaseExchangeRate();
		bean.setDataFromJSON(json);
		ExchangeRate dao = new ExchangeRate();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseExchangeRate bean = new BaseExchangeRate();
		bean.setDataFromJSON(json);
		ExchangeRate dao = new ExchangeRate();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseExchangeRate bean = new BaseExchangeRate();
		bean.setDataFromJSON(json);
		ExchangeRate dao = new ExchangeRate();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


