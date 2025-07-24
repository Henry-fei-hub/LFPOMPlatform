package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateDepartment;
import com.pomplatform.db.dao.PlateDepartment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlateDepartmentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateDepartmentHandler.class);

	public static BasePlateDepartment getPlateDepartmentById( 
		java.lang.Integer plate_department_id
	) throws Exception
	{
		PlateDepartment dao = new PlateDepartment();
		dao.setPlateDepartmentId(plate_department_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateDepartmentExists( com.pomplatform.db.bean.BasePlateDepartment bean, String additional ) throws Exception {

		PlateDepartment dao = new PlateDepartment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateDepartment( com.pomplatform.db.bean.BasePlateDepartment bean, String additional ) throws Exception {

		PlateDepartment dao = new PlateDepartment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateDepartment> queryPlateDepartment( com.pomplatform.db.bean.BasePlateDepartment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateDepartment dao = new PlateDepartment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateDepartment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateDepartment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateDepartment addToPlateDepartment ( BasePlateDepartment platedepartment )  throws Exception {
		return addToPlateDepartment ( platedepartment , false);
	}

	public static BasePlateDepartment addToPlateDepartment ( BasePlateDepartment platedepartment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateDepartment dao = new PlateDepartment();
		dao.setDataFromBase(platedepartment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateDepartment addUpdatePlateDepartment ( BasePlateDepartment platedepartment ) throws Exception {
		return addUpdatePlateDepartment ( platedepartment , false);
	}

	public static BasePlateDepartment addUpdatePlateDepartment ( BasePlateDepartment platedepartment, boolean singleTransaction  ) throws Exception {
		if(platedepartment.getPlateDepartmentId() == null) return addToPlateDepartment(platedepartment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateDepartment dao = new PlateDepartment();
		dao.setDataFromBase(platedepartment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(platedepartment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateDepartment ( BasePlateDepartment bean ) throws Exception {
		PlateDepartment dao = new PlateDepartment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateDepartment updatePlateDepartment ( BasePlateDepartment platedepartment ) throws Exception {
		PlateDepartment dao = new PlateDepartment();
		dao.setPlateDepartmentId( platedepartment.getPlateDepartmentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(platedepartment);
			result = dao.update();
		}
		return result == 1 ? platedepartment : null ;
	}

	public static BasePlateDepartment updatePlateDepartmentDirect( BasePlateDepartment platedepartment ) throws Exception {
		PlateDepartment dao = new PlateDepartment();
		int result = 0;
		dao.setDataFromBase(platedepartment);
		result = dao.update();
		return result == 1 ? platedepartment : null ;
	}

	public static int setDeleteConditions(BasePlateDepartment bean, PlateDepartment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateDepartmentId() != null) {
			dao.setConditionPlateDepartmentId("=", bean.getPlateDepartmentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePlateDepartment bean, PlateDepartment dao){
		int count = 0;
		if(bean.getPlateDepartmentId() != null) {
			dao.setConditionPlateDepartmentId("=", bean.getPlateDepartmentId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePlateDepartment bean = new BasePlateDepartment();
		bean.setDataFromJSON(json);
		PlateDepartment dao = new PlateDepartment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateDepartment> rlist = new BaseCollection<>();
		BasePlateDepartment bean = new BasePlateDepartment();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateDepartment dao = new PlateDepartment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateDepartment> result = dao.conditionalLoad(addtion);
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
		BasePlateDepartment bean = new BasePlateDepartment();
		bean.setDataFromJSON(json);
		PlateDepartment dao = new PlateDepartment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateDepartment bean = new BasePlateDepartment();
		bean.setDataFromJSON(json);
		PlateDepartment dao = new PlateDepartment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateDepartment bean = new BasePlateDepartment();
		bean.setDataFromJSON(json);
		PlateDepartment dao = new PlateDepartment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateDepartment bean = new BasePlateDepartment();
		bean.setDataFromJSON(json);
		PlateDepartment dao = new PlateDepartment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


