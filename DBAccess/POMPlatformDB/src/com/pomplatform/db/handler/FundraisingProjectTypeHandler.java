package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseFundraisingProjectType;
import com.pomplatform.db.dao.FundraisingProjectType;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class FundraisingProjectTypeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(FundraisingProjectTypeHandler.class);

	public static BaseFundraisingProjectType getFundraisingProjectTypeById( 

	) throws Exception
	{
		FundraisingProjectType dao = new FundraisingProjectType();
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isFundraisingProjectTypeExists( com.pomplatform.db.bean.BaseFundraisingProjectType bean, String additional ) throws Exception {

		FundraisingProjectType dao = new FundraisingProjectType();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countFundraisingProjectType( com.pomplatform.db.bean.BaseFundraisingProjectType bean, String additional ) throws Exception {

		FundraisingProjectType dao = new FundraisingProjectType();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseFundraisingProjectType> queryFundraisingProjectType( com.pomplatform.db.bean.BaseFundraisingProjectType bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		FundraisingProjectType dao = new FundraisingProjectType();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseFundraisingProjectType> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseFundraisingProjectType> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseFundraisingProjectType addToFundraisingProjectType ( BaseFundraisingProjectType fundraisingprojecttype )  throws Exception {
		return addToFundraisingProjectType ( fundraisingprojecttype , false);
	}

	public static BaseFundraisingProjectType addToFundraisingProjectType ( BaseFundraisingProjectType fundraisingprojecttype, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		FundraisingProjectType dao = new FundraisingProjectType();
		dao.setDataFromBase(fundraisingprojecttype);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseFundraisingProjectType addUpdateFundraisingProjectType ( BaseFundraisingProjectType fundraisingprojecttype ) throws Exception {
		return addUpdateFundraisingProjectType ( fundraisingprojecttype , false);
	}

	public static BaseFundraisingProjectType addUpdateFundraisingProjectType ( BaseFundraisingProjectType fundraisingprojecttype, boolean singleTransaction  ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		FundraisingProjectType dao = new FundraisingProjectType();
		dao.setDataFromBase(fundraisingprojecttype);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(fundraisingprojecttype); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteFundraisingProjectType ( BaseFundraisingProjectType bean ) throws Exception {
		FundraisingProjectType dao = new FundraisingProjectType();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseFundraisingProjectType updateFundraisingProjectType ( BaseFundraisingProjectType fundraisingprojecttype ) throws Exception {
		FundraisingProjectType dao = new FundraisingProjectType();
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(fundraisingprojecttype);
			result = dao.update();
		}
		return result == 1 ? fundraisingprojecttype : null ;
	}

	public static BaseFundraisingProjectType updateFundraisingProjectTypeDirect( BaseFundraisingProjectType fundraisingprojecttype ) throws Exception {
		FundraisingProjectType dao = new FundraisingProjectType();
		int result = 0;
		dao.setDataFromBase(fundraisingprojecttype);
		result = dao.update();
		return result == 1 ? fundraisingprojecttype : null ;
	}

	public static int setDeleteConditions(BaseFundraisingProjectType bean, FundraisingProjectType dao){
		int count = 0;
		boolean foundKey = false;
		if(!foundKey) {
			if(bean.getFundraisingProjectTypeId() != null) {
				dao.setConditionFundraisingProjectTypeId("=", bean.getFundraisingProjectTypeId());
				count++;
			}
			if(bean.getFundraisingProjectTypeName() != null) {
				dao.setConditionFundraisingProjectTypeName("=", bean.getFundraisingProjectTypeName());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseFundraisingProjectType bean, FundraisingProjectType dao){
		int count = 0;
		if(bean.getFundraisingProjectTypeId() != null) {
			dao.setConditionFundraisingProjectTypeId("=", bean.getFundraisingProjectTypeId());
			count++;
		}
		if(bean.getFundraisingProjectTypeName() != null) {
			if(bean.getFundraisingProjectTypeName().indexOf("%") >= 0)
				dao.setConditionFundraisingProjectTypeName("like", bean.getFundraisingProjectTypeName());
			else
				dao.setConditionFundraisingProjectTypeName("=", bean.getFundraisingProjectTypeName());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseFundraisingProjectType bean = new BaseFundraisingProjectType();
		bean.setDataFromJSON(json);
		FundraisingProjectType dao = new FundraisingProjectType();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseFundraisingProjectType> rlist = new BaseCollection<>();
		BaseFundraisingProjectType bean = new BaseFundraisingProjectType();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		FundraisingProjectType dao = new FundraisingProjectType();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseFundraisingProjectType> result = dao.conditionalLoad(addtion);
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
		BaseFundraisingProjectType bean = new BaseFundraisingProjectType();
		bean.setDataFromJSON(json);
		FundraisingProjectType dao = new FundraisingProjectType();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseFundraisingProjectType bean = new BaseFundraisingProjectType();
		bean.setDataFromJSON(json);
		FundraisingProjectType dao = new FundraisingProjectType();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseFundraisingProjectType bean = new BaseFundraisingProjectType();
		bean.setDataFromJSON(json);
		FundraisingProjectType dao = new FundraisingProjectType();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseFundraisingProjectType bean = new BaseFundraisingProjectType();
		bean.setDataFromJSON(json);
		FundraisingProjectType dao = new FundraisingProjectType();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


