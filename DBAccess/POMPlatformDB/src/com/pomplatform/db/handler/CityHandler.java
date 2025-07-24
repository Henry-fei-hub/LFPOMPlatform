package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCity;
import com.pomplatform.db.dao.City;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CityHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CityHandler.class);

	public static BaseCity getCityById( 
		java.lang.Integer city_id
	) throws Exception
	{
		City dao = new City();
		dao.setCityId(city_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCityExists( com.pomplatform.db.bean.BaseCity bean, String additional ) throws Exception {

		City dao = new City();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCity( com.pomplatform.db.bean.BaseCity bean, String additional ) throws Exception {

		City dao = new City();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCity> queryCity( com.pomplatform.db.bean.BaseCity bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		City dao = new City();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCity> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCity> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCity addToCity ( BaseCity city )  throws Exception {
		return addToCity ( city , false);
	}

	public static BaseCity addToCity ( BaseCity city, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		City dao = new City();
		dao.setDataFromBase(city);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCity addUpdateCity ( BaseCity city ) throws Exception {
		return addUpdateCity ( city , false);
	}

	public static BaseCity addUpdateCity ( BaseCity city, boolean singleTransaction  ) throws Exception {
		if(city.getCityId() == null) return addToCity(city);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		City dao = new City();
		dao.setDataFromBase(city);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(city); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCity ( BaseCity bean ) throws Exception {
		City dao = new City();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCity updateCity ( BaseCity city ) throws Exception {
		City dao = new City();
		dao.setCityId( city.getCityId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(city);
			result = dao.update();
		}
		return result == 1 ? city : null ;
	}

	public static BaseCity updateCityDirect( BaseCity city ) throws Exception {
		City dao = new City();
		int result = 0;
		dao.setDataFromBase(city);
		result = dao.update();
		return result == 1 ? city : null ;
	}

	public static int setDeleteConditions(BaseCity bean, City dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCityId() != null) {
			dao.setConditionCityId("=", bean.getCityId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCityNameEn() != null) {
				dao.setConditionCityNameEn("=", bean.getCityNameEn());
				count++;
			}
			if(bean.getCityNameCn() != null) {
				dao.setConditionCityNameCn("=", bean.getCityNameCn());
				count++;
			}
			if(bean.getProvinceId() != null) {
				dao.setConditionProvinceId("=", bean.getProvinceId());
				count++;
			}
			if(bean.getCityIsEnable() != null) {
				dao.setConditionCityIsEnable("=", bean.getCityIsEnable());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCity bean, City dao){
		int count = 0;
		if(bean.getCityId() != null) {
			dao.setConditionCityId("=", bean.getCityId());
			count++;
		}
		if(bean.getCityNameEn() != null) {
			if(bean.getCityNameEn().indexOf("%") >= 0)
				dao.setConditionCityNameEn("like", bean.getCityNameEn());
			else
				dao.setConditionCityNameEn("=", bean.getCityNameEn());
			count++;
		}
		if(bean.getCityNameCn() != null) {
			if(bean.getCityNameCn().indexOf("%") >= 0)
				dao.setConditionCityNameCn("like", bean.getCityNameCn());
			else
				dao.setConditionCityNameCn("=", bean.getCityNameCn());
			count++;
		}
		if(bean.getProvinceId() != null) {
			dao.setConditionProvinceId("=", bean.getProvinceId());
			count++;
		}
		if(bean.getCityIsEnable() != null) {
			dao.setConditionCityIsEnable("=", bean.getCityIsEnable());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCity bean = new BaseCity();
		bean.setDataFromJSON(json);
		City dao = new City();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCity> rlist = new BaseCollection<>();
		BaseCity bean = new BaseCity();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		City dao = new City();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCity> result = dao.conditionalLoad(addtion);
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
		BaseCity bean = new BaseCity();
		bean.setDataFromJSON(json);
		City dao = new City();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCity bean = new BaseCity();
		bean.setDataFromJSON(json);
		City dao = new City();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCity bean = new BaseCity();
		bean.setDataFromJSON(json);
		City dao = new City();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCity bean = new BaseCity();
		bean.setDataFromJSON(json);
		City dao = new City();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


