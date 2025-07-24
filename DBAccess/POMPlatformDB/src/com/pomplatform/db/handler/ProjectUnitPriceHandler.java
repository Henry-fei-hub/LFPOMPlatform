package com.pomplatform.db.handler;

import java.util.List;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectUnitPrice;
import com.pomplatform.db.dao.ProjectUnitPrice;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;

public class ProjectUnitPriceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectUnitPriceHandler.class);

	public static BaseProjectUnitPrice getProjectUnitPriceById( 
		java.lang.Integer project_unit_price_id
	) throws Exception
	{
		ProjectUnitPrice dao = new ProjectUnitPrice();
		dao.setProjectUnitPriceId(project_unit_price_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectUnitPriceExists( com.pomplatform.db.bean.BaseProjectUnitPrice bean, String additional ) throws Exception {

		ProjectUnitPrice dao = new ProjectUnitPrice();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectUnitPrice( com.pomplatform.db.bean.BaseProjectUnitPrice bean, String additional ) throws Exception {

		ProjectUnitPrice dao = new ProjectUnitPrice();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectUnitPrice> queryProjectUnitPrice( com.pomplatform.db.bean.BaseProjectUnitPrice bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectUnitPrice dao = new ProjectUnitPrice();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectUnitPrice> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectUnitPrice> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectUnitPrice addToProjectUnitPrice ( BaseProjectUnitPrice projectunitprice )  throws Exception {
		return addToProjectUnitPrice ( projectunitprice , false);
	}

	public static BaseProjectUnitPrice addToProjectUnitPrice ( BaseProjectUnitPrice projectunitprice, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectUnitPrice dao = new ProjectUnitPrice();
		dao.setDataFromBase(projectunitprice);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectUnitPrice addUpdateProjectUnitPrice ( BaseProjectUnitPrice projectunitprice ) throws Exception {
		return addUpdateProjectUnitPrice ( projectunitprice , false);
	}

	public static BaseProjectUnitPrice addUpdateProjectUnitPrice ( BaseProjectUnitPrice projectunitprice, boolean singleTransaction  ) throws Exception {
		if(projectunitprice.getProjectUnitPriceId() == null) return addToProjectUnitPrice(projectunitprice);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectUnitPrice dao = new ProjectUnitPrice();
		dao.setDataFromBase(projectunitprice);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectunitprice); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectUnitPrice ( BaseProjectUnitPrice bean ) throws Exception {
		ProjectUnitPrice dao = new ProjectUnitPrice();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectUnitPrice updateProjectUnitPrice ( BaseProjectUnitPrice projectunitprice ) throws Exception {
		ProjectUnitPrice dao = new ProjectUnitPrice();
		dao.setProjectUnitPriceId( projectunitprice.getProjectUnitPriceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectunitprice);
			result = dao.update();
		}
		return result == 1 ? projectunitprice : null ;
	}

	public static BaseProjectUnitPrice updateProjectUnitPriceDirect( BaseProjectUnitPrice projectunitprice ) throws Exception {
		ProjectUnitPrice dao = new ProjectUnitPrice();
		int result = 0;
		dao.setDataFromBase(projectunitprice);
		result = dao.update();
		return result == 1 ? projectunitprice : null ;
	}

	public static int setDeleteConditions(BaseProjectUnitPrice bean, ProjectUnitPrice dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectUnitPriceId() != null) {
			dao.setConditionProjectUnitPriceId("=", bean.getProjectUnitPriceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getAreaId() != null) {
				dao.setConditionAreaId("=", bean.getAreaId());
				count++;
			}
			if(bean.getGradeId() != null) {
				dao.setConditionGradeId("=", bean.getGradeId());
				count++;
			}
			if(bean.getSquareId() != null) {
				dao.setConditionSquareId("=", bean.getSquareId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectUnitPrice bean, ProjectUnitPrice dao){
		int count = 0;
		if(bean.getProjectUnitPriceId() != null) {
			dao.setConditionProjectUnitPriceId("=", bean.getProjectUnitPriceId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getAreaId() != null) {
			dao.setConditionAreaId("=", bean.getAreaId());
			count++;
		}
		if(bean.getGradeId() != null) {
			dao.setConditionGradeId("=", bean.getGradeId());
			count++;
		}
		if(bean.getSquareId() != null) {
			dao.setConditionSquareId("=", bean.getSquareId());
			count++;
		}
		if(bean.getMinSquare() != null) {
			dao.setConditionMinSquare("=", bean.getMinSquare());
			count++;
		}
		if(bean.getMaxSquare() != null) {
			dao.setConditionMaxSquare("=", bean.getMaxSquare());
			count++;
		}
		if(bean.getUnitPrice() != null) {
			dao.setConditionUnitPrice("=", bean.getUnitPrice());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectUnitPrice bean = new BaseProjectUnitPrice();
		bean.setDataFromJSON(json);
		ProjectUnitPrice dao = new ProjectUnitPrice();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectUnitPrice> rlist = new BaseCollection<>();
		BaseProjectUnitPrice bean = new BaseProjectUnitPrice();
		bean.setDataFromJSON(json);
		ProjectUnitPrice dao = new ProjectUnitPrice();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectUnitPrice> result = dao.conditionalLoad(addtion);
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
		BaseProjectUnitPrice bean = new BaseProjectUnitPrice();
		bean.setDataFromJSON(json);
		ProjectUnitPrice dao = new ProjectUnitPrice();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectUnitPrice bean = new BaseProjectUnitPrice();
		bean.setDataFromJSON(json);
		ProjectUnitPrice dao = new ProjectUnitPrice();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectUnitPrice bean = new BaseProjectUnitPrice();
		bean.setDataFromJSON(json);
		ProjectUnitPrice dao = new ProjectUnitPrice();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectUnitPrice bean = new BaseProjectUnitPrice();
		bean.setDataFromJSON(json);
		ProjectUnitPrice dao = new ProjectUnitPrice();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


