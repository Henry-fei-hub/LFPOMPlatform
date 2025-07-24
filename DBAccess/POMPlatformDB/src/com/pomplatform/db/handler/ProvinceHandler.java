package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProvince;
import com.pomplatform.db.dao.Province;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProvinceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProvinceHandler.class);

	public static BaseProvince getProvinceById( 
		java.lang.Integer province_id
	) throws Exception
	{
		Province dao = new Province();
		dao.setProvinceId(province_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProvinceExists( com.pomplatform.db.bean.BaseProvince bean, String additional ) throws Exception {

		Province dao = new Province();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProvince( com.pomplatform.db.bean.BaseProvince bean, String additional ) throws Exception {

		Province dao = new Province();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProvince> queryProvince( com.pomplatform.db.bean.BaseProvince bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Province dao = new Province();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProvince> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProvince> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProvince addToProvince ( BaseProvince province )  throws Exception {
		return addToProvince ( province , false);
	}

	public static BaseProvince addToProvince ( BaseProvince province, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Province dao = new Province();
		dao.setDataFromBase(province);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProvince addUpdateProvince ( BaseProvince province ) throws Exception {
		return addUpdateProvince ( province , false);
	}

	public static BaseProvince addUpdateProvince ( BaseProvince province, boolean singleTransaction  ) throws Exception {
		if(province.getProvinceId() == null) return addToProvince(province);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Province dao = new Province();
		dao.setDataFromBase(province);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(province); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProvince ( BaseProvince bean ) throws Exception {
		Province dao = new Province();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProvince updateProvince ( BaseProvince province ) throws Exception {
		Province dao = new Province();
		dao.setProvinceId( province.getProvinceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(province);
			result = dao.update();
		}
		return result == 1 ? province : null ;
	}

	public static BaseProvince updateProvinceDirect( BaseProvince province ) throws Exception {
		Province dao = new Province();
		int result = 0;
		dao.setDataFromBase(province);
		result = dao.update();
		return result == 1 ? province : null ;
	}

	public static int setDeleteConditions(BaseProvince bean, Province dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProvinceId() != null) {
			dao.setConditionProvinceId("=", bean.getProvinceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProvinceNameEn() != null) {
				dao.setConditionProvinceNameEn("=", bean.getProvinceNameEn());
				count++;
			}
			if(bean.getProvinceNameCn() != null) {
				dao.setConditionProvinceNameCn("=", bean.getProvinceNameCn());
				count++;
			}
			if(bean.getCountryId() != null) {
				dao.setConditionCountryId("=", bean.getCountryId());
				count++;
			}
			if(bean.getProvinceIsEnable() != null) {
				dao.setConditionProvinceIsEnable("=", bean.getProvinceIsEnable());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProvince bean, Province dao){
		int count = 0;
		if(bean.getProvinceId() != null) {
			dao.setConditionProvinceId("=", bean.getProvinceId());
			count++;
		}
		if(bean.getProvinceNameEn() != null) {
			if(bean.getProvinceNameEn().indexOf("%") >= 0)
				dao.setConditionProvinceNameEn("like", bean.getProvinceNameEn());
			else
				dao.setConditionProvinceNameEn("=", bean.getProvinceNameEn());
			count++;
		}
		if(bean.getProvinceNameCn() != null) {
			if(bean.getProvinceNameCn().indexOf("%") >= 0)
				dao.setConditionProvinceNameCn("like", bean.getProvinceNameCn());
			else
				dao.setConditionProvinceNameCn("=", bean.getProvinceNameCn());
			count++;
		}
		if(bean.getCountryId() != null) {
			dao.setConditionCountryId("=", bean.getCountryId());
			count++;
		}
		if(bean.getProvinceIsEnable() != null) {
			dao.setConditionProvinceIsEnable("=", bean.getProvinceIsEnable());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProvince bean = new BaseProvince();
		bean.setDataFromJSON(json);
		Province dao = new Province();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProvince> rlist = new BaseCollection<>();
		BaseProvince bean = new BaseProvince();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Province dao = new Province();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProvince> result = dao.conditionalLoad(addtion);
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
		BaseProvince bean = new BaseProvince();
		bean.setDataFromJSON(json);
		Province dao = new Province();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProvince bean = new BaseProvince();
		bean.setDataFromJSON(json);
		Province dao = new Province();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProvince bean = new BaseProvince();
		bean.setDataFromJSON(json);
		Province dao = new Province();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProvince bean = new BaseProvince();
		bean.setDataFromJSON(json);
		Province dao = new Province();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


