package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapitalEmployee;
import com.pomplatform.db.dao.CapitalEmployee;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CapitalEmployeeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CapitalEmployeeHandler.class);

	public static BaseCapitalEmployee getCapitalEmployeeById( 
		java.lang.Integer capital_employee_id
	) throws Exception
	{
		CapitalEmployee dao = new CapitalEmployee();
		dao.setCapitalEmployeeId(capital_employee_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCapitalEmployeeExists( com.pomplatform.db.bean.BaseCapitalEmployee bean, String additional ) throws Exception {

		CapitalEmployee dao = new CapitalEmployee();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCapitalEmployee( com.pomplatform.db.bean.BaseCapitalEmployee bean, String additional ) throws Exception {

		CapitalEmployee dao = new CapitalEmployee();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCapitalEmployee> queryCapitalEmployee( com.pomplatform.db.bean.BaseCapitalEmployee bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CapitalEmployee dao = new CapitalEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCapitalEmployee> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCapitalEmployee> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCapitalEmployee addToCapitalEmployee ( BaseCapitalEmployee capitalemployee )  throws Exception {
		return addToCapitalEmployee ( capitalemployee , false);
	}

	public static BaseCapitalEmployee addToCapitalEmployee ( BaseCapitalEmployee capitalemployee, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CapitalEmployee dao = new CapitalEmployee();
		dao.setDataFromBase(capitalemployee);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCapitalEmployee addUpdateCapitalEmployee ( BaseCapitalEmployee capitalemployee ) throws Exception {
		return addUpdateCapitalEmployee ( capitalemployee , false);
	}

	public static BaseCapitalEmployee addUpdateCapitalEmployee ( BaseCapitalEmployee capitalemployee, boolean singleTransaction  ) throws Exception {
		if(capitalemployee.getCapitalEmployeeId() == null) return addToCapitalEmployee(capitalemployee);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CapitalEmployee dao = new CapitalEmployee();
		dao.setDataFromBase(capitalemployee);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(capitalemployee); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCapitalEmployee ( BaseCapitalEmployee bean ) throws Exception {
		CapitalEmployee dao = new CapitalEmployee();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCapitalEmployee updateCapitalEmployee ( BaseCapitalEmployee capitalemployee ) throws Exception {
		CapitalEmployee dao = new CapitalEmployee();
		dao.setCapitalEmployeeId( capitalemployee.getCapitalEmployeeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(capitalemployee);
			result = dao.update();
		}
		return result == 1 ? capitalemployee : null ;
	}

	public static BaseCapitalEmployee updateCapitalEmployeeDirect( BaseCapitalEmployee capitalemployee ) throws Exception {
		CapitalEmployee dao = new CapitalEmployee();
		int result = 0;
		dao.setDataFromBase(capitalemployee);
		result = dao.update();
		return result == 1 ? capitalemployee : null ;
	}

	public static int setDeleteConditions(BaseCapitalEmployee bean, CapitalEmployee dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCapitalEmployeeId() != null) {
			dao.setConditionCapitalEmployeeId("=", bean.getCapitalEmployeeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCapitalId() != null) {
				dao.setConditionCapitalId("=", bean.getCapitalId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCapitalEmployee bean, CapitalEmployee dao){
		int count = 0;
		if(bean.getCapitalEmployeeId() != null) {
			dao.setConditionCapitalEmployeeId("=", bean.getCapitalEmployeeId());
			count++;
		}
		if(bean.getCapitalId() != null) {
			dao.setConditionCapitalId("=", bean.getCapitalId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
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
		BaseCapitalEmployee bean = new BaseCapitalEmployee();
		bean.setDataFromJSON(json);
		CapitalEmployee dao = new CapitalEmployee();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCapitalEmployee> rlist = new BaseCollection<>();
		BaseCapitalEmployee bean = new BaseCapitalEmployee();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CapitalEmployee dao = new CapitalEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCapitalEmployee> result = dao.conditionalLoad(addtion);
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
		BaseCapitalEmployee bean = new BaseCapitalEmployee();
		bean.setDataFromJSON(json);
		CapitalEmployee dao = new CapitalEmployee();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCapitalEmployee bean = new BaseCapitalEmployee();
		bean.setDataFromJSON(json);
		CapitalEmployee dao = new CapitalEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCapitalEmployee bean = new BaseCapitalEmployee();
		bean.setDataFromJSON(json);
		CapitalEmployee dao = new CapitalEmployee();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCapitalEmployee bean = new BaseCapitalEmployee();
		bean.setDataFromJSON(json);
		CapitalEmployee dao = new CapitalEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


