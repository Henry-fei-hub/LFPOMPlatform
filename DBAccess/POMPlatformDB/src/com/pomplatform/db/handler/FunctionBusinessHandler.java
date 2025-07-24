package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseFunctionBusiness;
import com.pomplatform.db.dao.FunctionBusiness;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class FunctionBusinessHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(FunctionBusinessHandler.class);

	public static BaseFunctionBusiness getFunctionBusinessById( 
		java.lang.Integer function_business_id
	) throws Exception
	{
		FunctionBusiness dao = new FunctionBusiness();
		dao.setFunctionBusinessId(function_business_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isFunctionBusinessExists( com.pomplatform.db.bean.BaseFunctionBusiness bean, String additional ) throws Exception {

		FunctionBusiness dao = new FunctionBusiness();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countFunctionBusiness( com.pomplatform.db.bean.BaseFunctionBusiness bean, String additional ) throws Exception {

		FunctionBusiness dao = new FunctionBusiness();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseFunctionBusiness> queryFunctionBusiness( com.pomplatform.db.bean.BaseFunctionBusiness bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		FunctionBusiness dao = new FunctionBusiness();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseFunctionBusiness> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseFunctionBusiness> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseFunctionBusiness addToFunctionBusiness ( BaseFunctionBusiness functionbusiness )  throws Exception {
		return addToFunctionBusiness ( functionbusiness , false);
	}

	public static BaseFunctionBusiness addToFunctionBusiness ( BaseFunctionBusiness functionbusiness, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		FunctionBusiness dao = new FunctionBusiness();
		dao.setDataFromBase(functionbusiness);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseFunctionBusiness addUpdateFunctionBusiness ( BaseFunctionBusiness functionbusiness ) throws Exception {
		return addUpdateFunctionBusiness ( functionbusiness , false);
	}

	public static BaseFunctionBusiness addUpdateFunctionBusiness ( BaseFunctionBusiness functionbusiness, boolean singleTransaction  ) throws Exception {
		if(functionbusiness.getFunctionBusinessId() == null) return addToFunctionBusiness(functionbusiness);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		FunctionBusiness dao = new FunctionBusiness();
		dao.setDataFromBase(functionbusiness);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(functionbusiness); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteFunctionBusiness ( BaseFunctionBusiness bean ) throws Exception {
		FunctionBusiness dao = new FunctionBusiness();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseFunctionBusiness updateFunctionBusiness ( BaseFunctionBusiness functionbusiness ) throws Exception {
		FunctionBusiness dao = new FunctionBusiness();
		dao.setFunctionBusinessId( functionbusiness.getFunctionBusinessId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(functionbusiness);
			result = dao.update();
		}
		return result == 1 ? functionbusiness : null ;
	}

	public static BaseFunctionBusiness updateFunctionBusinessDirect( BaseFunctionBusiness functionbusiness ) throws Exception {
		FunctionBusiness dao = new FunctionBusiness();
		int result = 0;
		dao.setDataFromBase(functionbusiness);
		result = dao.update();
		return result == 1 ? functionbusiness : null ;
	}

	public static int setDeleteConditions(BaseFunctionBusiness bean, FunctionBusiness dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getFunctionBusinessId() != null) {
			dao.setConditionFunctionBusinessId("=", bean.getFunctionBusinessId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getFunctionId() != null) {
				dao.setConditionFunctionId("=", bean.getFunctionId());
				count++;
			}
			if(bean.getFunctionType() != null) {
				dao.setConditionFunctionType("=", bean.getFunctionType());
				count++;
			}
			if(bean.getIsCompleted() != null) {
				dao.setConditionIsCompleted("=", bean.getIsCompleted());
				count++;
			}
			if(bean.getIsForever() != null) {
				dao.setConditionIsForever("=", bean.getIsForever());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseFunctionBusiness bean, FunctionBusiness dao){
		int count = 0;
		if(bean.getFunctionBusinessId() != null) {
			dao.setConditionFunctionBusinessId("=", bean.getFunctionBusinessId());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getFunctionId() != null) {
			dao.setConditionFunctionId("=", bean.getFunctionId());
			count++;
		}
		if(bean.getFunctionType() != null) {
			dao.setConditionFunctionType("=", bean.getFunctionType());
			count++;
		}
		if(bean.getStartDate() != null) {
			dao.setConditionStartDate(">=", bean.getStartDate());
			count++;
		}
		if(bean.getEndDate() != null) {
			dao.setConditionEndDate(">=", bean.getEndDate());
			count++;
		}
		if(bean.getDays() != null) {
			dao.setConditionDays("=", bean.getDays());
			count++;
		}
		if(bean.getIsCompleted() != null) {
			dao.setConditionIsCompleted("=", bean.getIsCompleted());
			count++;
		}
		if(bean.getIsForever() != null) {
			dao.setConditionIsForever("=", bean.getIsForever());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseFunctionBusiness bean = new BaseFunctionBusiness();
		bean.setDataFromJSON(json);
		FunctionBusiness dao = new FunctionBusiness();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseFunctionBusiness> rlist = new BaseCollection<>();
		BaseFunctionBusiness bean = new BaseFunctionBusiness();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		FunctionBusiness dao = new FunctionBusiness();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseFunctionBusiness> result = dao.conditionalLoad(addtion);
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
		BaseFunctionBusiness bean = new BaseFunctionBusiness();
		bean.setDataFromJSON(json);
		FunctionBusiness dao = new FunctionBusiness();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseFunctionBusiness bean = new BaseFunctionBusiness();
		bean.setDataFromJSON(json);
		FunctionBusiness dao = new FunctionBusiness();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseFunctionBusiness bean = new BaseFunctionBusiness();
		bean.setDataFromJSON(json);
		FunctionBusiness dao = new FunctionBusiness();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseFunctionBusiness bean = new BaseFunctionBusiness();
		bean.setDataFromJSON(json);
		FunctionBusiness dao = new FunctionBusiness();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


