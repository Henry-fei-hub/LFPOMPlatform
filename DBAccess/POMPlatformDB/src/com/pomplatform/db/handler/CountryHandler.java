package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCountry;
import com.pomplatform.db.dao.Country;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CountryHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CountryHandler.class);

	public static BaseCountry getCountryById( 
		java.lang.Integer country_id
	) throws Exception
	{
		Country dao = new Country();
		dao.setCountryId(country_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCountryExists( com.pomplatform.db.bean.BaseCountry bean, String additional ) throws Exception {

		Country dao = new Country();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCountry( com.pomplatform.db.bean.BaseCountry bean, String additional ) throws Exception {

		Country dao = new Country();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCountry> queryCountry( com.pomplatform.db.bean.BaseCountry bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Country dao = new Country();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCountry> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCountry> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCountry addToCountry ( BaseCountry country )  throws Exception {
		return addToCountry ( country , false);
	}

	public static BaseCountry addToCountry ( BaseCountry country, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Country dao = new Country();
		dao.setDataFromBase(country);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCountry addUpdateCountry ( BaseCountry country ) throws Exception {
		return addUpdateCountry ( country , false);
	}

	public static BaseCountry addUpdateCountry ( BaseCountry country, boolean singleTransaction  ) throws Exception {
		if(country.getCountryId() == null) return addToCountry(country);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Country dao = new Country();
		dao.setDataFromBase(country);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(country); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCountry ( BaseCountry bean ) throws Exception {
		Country dao = new Country();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCountry updateCountry ( BaseCountry country ) throws Exception {
		Country dao = new Country();
		dao.setCountryId( country.getCountryId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(country);
			result = dao.update();
		}
		return result == 1 ? country : null ;
	}

	public static BaseCountry updateCountryDirect( BaseCountry country ) throws Exception {
		Country dao = new Country();
		int result = 0;
		dao.setDataFromBase(country);
		result = dao.update();
		return result == 1 ? country : null ;
	}

	public static int setDeleteConditions(BaseCountry bean, Country dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCountryId() != null) {
			dao.setConditionCountryId("=", bean.getCountryId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCountryNameEn() != null) {
				dao.setConditionCountryNameEn("=", bean.getCountryNameEn());
				count++;
			}
			if(bean.getCountryNameCn() != null) {
				dao.setConditionCountryNameCn("=", bean.getCountryNameCn());
				count++;
			}
			if(bean.getLevel() != null) {
				dao.setConditionLevel("=", bean.getLevel());
				count++;
			}
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getCode() != null) {
				dao.setConditionCode("=", bean.getCode());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCountry bean, Country dao){
		int count = 0;
		if(bean.getCountryId() != null) {
			dao.setConditionCountryId("=", bean.getCountryId());
			count++;
		}
		if(bean.getCountryNameEn() != null) {
			if(bean.getCountryNameEn().indexOf("%") >= 0)
				dao.setConditionCountryNameEn("like", bean.getCountryNameEn());
			else
				dao.setConditionCountryNameEn("=", bean.getCountryNameEn());
			count++;
		}
		if(bean.getCountryNameCn() != null) {
			if(bean.getCountryNameCn().indexOf("%") >= 0)
				dao.setConditionCountryNameCn("like", bean.getCountryNameCn());
			else
				dao.setConditionCountryNameCn("=", bean.getCountryNameCn());
			count++;
		}
		if(bean.getLevel() != null) {
			dao.setConditionLevel("=", bean.getLevel());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getCode() != null) {
			if(bean.getCode().indexOf("%") >= 0)
				dao.setConditionCode("like", bean.getCode());
			else
				dao.setConditionCode("=", bean.getCode());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCountry bean = new BaseCountry();
		bean.setDataFromJSON(json);
		Country dao = new Country();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCountry> rlist = new BaseCollection<>();
		BaseCountry bean = new BaseCountry();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Country dao = new Country();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCountry> result = dao.conditionalLoad(addtion);
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
		BaseCountry bean = new BaseCountry();
		bean.setDataFromJSON(json);
		Country dao = new Country();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCountry bean = new BaseCountry();
		bean.setDataFromJSON(json);
		Country dao = new Country();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCountry bean = new BaseCountry();
		bean.setDataFromJSON(json);
		Country dao = new Country();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCountry bean = new BaseCountry();
		bean.setDataFromJSON(json);
		Country dao = new Country();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


