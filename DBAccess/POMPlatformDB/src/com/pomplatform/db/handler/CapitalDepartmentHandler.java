package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapitalDepartment;
import com.pomplatform.db.dao.CapitalDepartment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CapitalDepartmentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CapitalDepartmentHandler.class);

	public static BaseCapitalDepartment getCapitalDepartmentById( 
		java.lang.Integer capital_department_id
	) throws Exception
	{
		CapitalDepartment dao = new CapitalDepartment();
		dao.setCapitalDepartmentId(capital_department_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCapitalDepartmentExists( com.pomplatform.db.bean.BaseCapitalDepartment bean, String additional ) throws Exception {

		CapitalDepartment dao = new CapitalDepartment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCapitalDepartment( com.pomplatform.db.bean.BaseCapitalDepartment bean, String additional ) throws Exception {

		CapitalDepartment dao = new CapitalDepartment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCapitalDepartment> queryCapitalDepartment( com.pomplatform.db.bean.BaseCapitalDepartment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CapitalDepartment dao = new CapitalDepartment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCapitalDepartment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCapitalDepartment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCapitalDepartment addToCapitalDepartment ( BaseCapitalDepartment capitaldepartment )  throws Exception {
		return addToCapitalDepartment ( capitaldepartment , false);
	}

	public static BaseCapitalDepartment addToCapitalDepartment ( BaseCapitalDepartment capitaldepartment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CapitalDepartment dao = new CapitalDepartment();
		dao.setDataFromBase(capitaldepartment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCapitalDepartment addUpdateCapitalDepartment ( BaseCapitalDepartment capitaldepartment ) throws Exception {
		return addUpdateCapitalDepartment ( capitaldepartment , false);
	}

	public static BaseCapitalDepartment addUpdateCapitalDepartment ( BaseCapitalDepartment capitaldepartment, boolean singleTransaction  ) throws Exception {
		if(capitaldepartment.getCapitalDepartmentId() == null) return addToCapitalDepartment(capitaldepartment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CapitalDepartment dao = new CapitalDepartment();
		dao.setDataFromBase(capitaldepartment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(capitaldepartment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCapitalDepartment ( BaseCapitalDepartment bean ) throws Exception {
		CapitalDepartment dao = new CapitalDepartment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCapitalDepartment updateCapitalDepartment ( BaseCapitalDepartment capitaldepartment ) throws Exception {
		CapitalDepartment dao = new CapitalDepartment();
		dao.setCapitalDepartmentId( capitaldepartment.getCapitalDepartmentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(capitaldepartment);
			result = dao.update();
		}
		return result == 1 ? capitaldepartment : null ;
	}

	public static BaseCapitalDepartment updateCapitalDepartmentDirect( BaseCapitalDepartment capitaldepartment ) throws Exception {
		CapitalDepartment dao = new CapitalDepartment();
		int result = 0;
		dao.setDataFromBase(capitaldepartment);
		result = dao.update();
		return result == 1 ? capitaldepartment : null ;
	}

	public static int setDeleteConditions(BaseCapitalDepartment bean, CapitalDepartment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCapitalDepartmentId() != null) {
			dao.setConditionCapitalDepartmentId("=", bean.getCapitalDepartmentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCapitalId() != null) {
				dao.setConditionCapitalId("=", bean.getCapitalId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCapitalDepartment bean, CapitalDepartment dao){
		int count = 0;
		if(bean.getCapitalDepartmentId() != null) {
			dao.setConditionCapitalDepartmentId("=", bean.getCapitalDepartmentId());
			count++;
		}
		if(bean.getCapitalId() != null) {
			dao.setConditionCapitalId("=", bean.getCapitalId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getMoney() != null) {
			dao.setConditionMoney("=", bean.getMoney());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getCreatTime() != null) {
			dao.setConditionCreatTime(">=", bean.getCreatTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCapitalDepartment bean = new BaseCapitalDepartment();
		bean.setDataFromJSON(json);
		CapitalDepartment dao = new CapitalDepartment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCapitalDepartment> rlist = new BaseCollection<>();
		BaseCapitalDepartment bean = new BaseCapitalDepartment();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CapitalDepartment dao = new CapitalDepartment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCapitalDepartment> result = dao.conditionalLoad(addtion);
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
		BaseCapitalDepartment bean = new BaseCapitalDepartment();
		bean.setDataFromJSON(json);
		CapitalDepartment dao = new CapitalDepartment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCapitalDepartment bean = new BaseCapitalDepartment();
		bean.setDataFromJSON(json);
		CapitalDepartment dao = new CapitalDepartment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCapitalDepartment bean = new BaseCapitalDepartment();
		bean.setDataFromJSON(json);
		CapitalDepartment dao = new CapitalDepartment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCapitalDepartment bean = new BaseCapitalDepartment();
		bean.setDataFromJSON(json);
		CapitalDepartment dao = new CapitalDepartment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


