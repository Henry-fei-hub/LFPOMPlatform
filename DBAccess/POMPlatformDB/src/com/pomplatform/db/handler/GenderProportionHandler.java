package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseGenderProportion;
import com.pomplatform.db.dao.GenderProportion;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class GenderProportionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(GenderProportionHandler.class);

	public static BaseGenderProportion getGenderProportionById( 
		java.lang.Integer gender_proportion_id
	) throws Exception
	{
		GenderProportion dao = new GenderProportion();
		dao.setGenderProportionId(gender_proportion_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isGenderProportionExists( com.pomplatform.db.bean.BaseGenderProportion bean, String additional ) throws Exception {

		GenderProportion dao = new GenderProportion();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countGenderProportion( com.pomplatform.db.bean.BaseGenderProportion bean, String additional ) throws Exception {

		GenderProportion dao = new GenderProportion();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseGenderProportion> queryGenderProportion( com.pomplatform.db.bean.BaseGenderProportion bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		GenderProportion dao = new GenderProportion();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseGenderProportion> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseGenderProportion> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseGenderProportion addToGenderProportion ( BaseGenderProportion genderproportion )  throws Exception {
		return addToGenderProportion ( genderproportion , false);
	}

	public static BaseGenderProportion addToGenderProportion ( BaseGenderProportion genderproportion, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		GenderProportion dao = new GenderProportion();
		dao.setDataFromBase(genderproportion);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseGenderProportion addUpdateGenderProportion ( BaseGenderProportion genderproportion ) throws Exception {
		return addUpdateGenderProportion ( genderproportion , false);
	}

	public static BaseGenderProportion addUpdateGenderProportion ( BaseGenderProportion genderproportion, boolean singleTransaction  ) throws Exception {
		if(genderproportion.getGenderProportionId() == null) return addToGenderProportion(genderproportion);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		GenderProportion dao = new GenderProportion();
		dao.setDataFromBase(genderproportion);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(genderproportion); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteGenderProportion ( BaseGenderProportion bean ) throws Exception {
		GenderProportion dao = new GenderProportion();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseGenderProportion updateGenderProportion ( BaseGenderProportion genderproportion ) throws Exception {
		GenderProportion dao = new GenderProportion();
		dao.setGenderProportionId( genderproportion.getGenderProportionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(genderproportion);
			result = dao.update();
		}
		return result == 1 ? genderproportion : null ;
	}

	public static BaseGenderProportion updateGenderProportionDirect( BaseGenderProportion genderproportion ) throws Exception {
		GenderProportion dao = new GenderProportion();
		int result = 0;
		dao.setDataFromBase(genderproportion);
		result = dao.update();
		return result == 1 ? genderproportion : null ;
	}

	public static int setDeleteConditions(BaseGenderProportion bean, GenderProportion dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getGenderProportionId() != null) {
			dao.setConditionGenderProportionId("=", bean.getGenderProportionId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getMaleProportionStr() != null) {
				dao.setConditionMaleProportionStr("=", bean.getMaleProportionStr());
				count++;
			}
			if(bean.getFemaleProportionStr() != null) {
				dao.setConditionFemaleProportionStr("=", bean.getFemaleProportionStr());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseGenderProportion bean, GenderProportion dao){
		int count = 0;
		if(bean.getGenderProportionId() != null) {
			dao.setConditionGenderProportionId("=", bean.getGenderProportionId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getMaleProportionStr() != null) {
			if(bean.getMaleProportionStr().indexOf("%") >= 0)
				dao.setConditionMaleProportionStr("like", bean.getMaleProportionStr());
			else
				dao.setConditionMaleProportionStr("=", bean.getMaleProportionStr());
			count++;
		}
		if(bean.getFemaleProportionStr() != null) {
			if(bean.getFemaleProportionStr().indexOf("%") >= 0)
				dao.setConditionFemaleProportionStr("like", bean.getFemaleProportionStr());
			else
				dao.setConditionFemaleProportionStr("=", bean.getFemaleProportionStr());
			count++;
		}
		if(bean.getMaleProportion() != null) {
			dao.setConditionMaleProportion("=", bean.getMaleProportion());
			count++;
		}
		if(bean.getFemaleProportion() != null) {
			dao.setConditionFemaleProportion("=", bean.getFemaleProportion());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseGenderProportion bean = new BaseGenderProportion();
		bean.setDataFromJSON(json);
		GenderProportion dao = new GenderProportion();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseGenderProportion> rlist = new BaseCollection<>();
		BaseGenderProportion bean = new BaseGenderProportion();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		GenderProportion dao = new GenderProportion();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseGenderProportion> result = dao.conditionalLoad(addtion);
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
		BaseGenderProportion bean = new BaseGenderProportion();
		bean.setDataFromJSON(json);
		GenderProportion dao = new GenderProportion();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseGenderProportion bean = new BaseGenderProportion();
		bean.setDataFromJSON(json);
		GenderProportion dao = new GenderProportion();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseGenderProportion bean = new BaseGenderProportion();
		bean.setDataFromJSON(json);
		GenderProportion dao = new GenderProportion();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseGenderProportion bean = new BaseGenderProportion();
		bean.setDataFromJSON(json);
		GenderProportion dao = new GenderProportion();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


