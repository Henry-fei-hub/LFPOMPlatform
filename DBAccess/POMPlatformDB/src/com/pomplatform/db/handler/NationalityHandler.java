package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseNationality;
import com.pomplatform.db.dao.Nationality;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class NationalityHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(NationalityHandler.class);

	public static BaseNationality getNationalityById( 
		java.lang.Integer nationality_id
	) throws Exception
	{
		Nationality dao = new Nationality();
		dao.setNationalityId(nationality_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isNationalityExists( com.pomplatform.db.bean.BaseNationality bean, String additional ) throws Exception {

		Nationality dao = new Nationality();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countNationality( com.pomplatform.db.bean.BaseNationality bean, String additional ) throws Exception {

		Nationality dao = new Nationality();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseNationality> queryNationality( com.pomplatform.db.bean.BaseNationality bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Nationality dao = new Nationality();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseNationality> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseNationality> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseNationality addToNationality ( BaseNationality nationality )  throws Exception {
		return addToNationality ( nationality , false);
	}

	public static BaseNationality addToNationality ( BaseNationality nationality, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Nationality dao = new Nationality();
		dao.setDataFromBase(nationality);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseNationality addUpdateNationality ( BaseNationality nationality ) throws Exception {
		return addUpdateNationality ( nationality , false);
	}

	public static BaseNationality addUpdateNationality ( BaseNationality nationality, boolean singleTransaction  ) throws Exception {
		if(nationality.getNationalityId() == null) return addToNationality(nationality);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Nationality dao = new Nationality();
		dao.setDataFromBase(nationality);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(nationality); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteNationality ( BaseNationality bean ) throws Exception {
		Nationality dao = new Nationality();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseNationality updateNationality ( BaseNationality nationality ) throws Exception {
		Nationality dao = new Nationality();
		dao.setNationalityId( nationality.getNationalityId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(nationality);
			result = dao.update();
		}
		return result == 1 ? nationality : null ;
	}

	public static BaseNationality updateNationalityDirect( BaseNationality nationality ) throws Exception {
		Nationality dao = new Nationality();
		int result = 0;
		dao.setDataFromBase(nationality);
		result = dao.update();
		return result == 1 ? nationality : null ;
	}

	public static int setDeleteConditions(BaseNationality bean, Nationality dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getNationalityId() != null) {
			dao.setConditionNationalityId("=", bean.getNationalityId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getNationalityName() != null) {
				dao.setConditionNationalityName("=", bean.getNationalityName());
				count++;
			}
			if(bean.getIsEnabled() != null) {
				dao.setConditionIsEnabled("=", bean.getIsEnabled());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseNationality bean, Nationality dao){
		int count = 0;
		if(bean.getNationalityId() != null) {
			dao.setConditionNationalityId("=", bean.getNationalityId());
			count++;
		}
		if(bean.getNationalityName() != null) {
			if(bean.getNationalityName().indexOf("%") >= 0)
				dao.setConditionNationalityName("like", bean.getNationalityName());
			else
				dao.setConditionNationalityName("=", bean.getNationalityName());
			count++;
		}
		if(bean.getIsEnabled() != null) {
			dao.setConditionIsEnabled("=", bean.getIsEnabled());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseNationality bean = new BaseNationality();
		bean.setDataFromJSON(json);
		Nationality dao = new Nationality();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseNationality> rlist = new BaseCollection<>();
		BaseNationality bean = new BaseNationality();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Nationality dao = new Nationality();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseNationality> result = dao.conditionalLoad(addtion);
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
		BaseNationality bean = new BaseNationality();
		bean.setDataFromJSON(json);
		Nationality dao = new Nationality();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseNationality bean = new BaseNationality();
		bean.setDataFromJSON(json);
		Nationality dao = new Nationality();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseNationality bean = new BaseNationality();
		bean.setDataFromJSON(json);
		Nationality dao = new Nationality();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseNationality bean = new BaseNationality();
		bean.setDataFromJSON(json);
		Nationality dao = new Nationality();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


