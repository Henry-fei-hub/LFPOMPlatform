package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeInitialBalance;
import com.pomplatform.db.dao.EmployeeInitialBalance;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeInitialBalanceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeInitialBalanceHandler.class);

	public static BaseEmployeeInitialBalance getEmployeeInitialBalanceById( 
		java.lang.Integer employee_initial_balance_id
	) throws Exception
	{
		EmployeeInitialBalance dao = new EmployeeInitialBalance();
		dao.setEmployeeInitialBalanceId(employee_initial_balance_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeInitialBalanceExists( com.pomplatform.db.bean.BaseEmployeeInitialBalance bean, String additional ) throws Exception {

		EmployeeInitialBalance dao = new EmployeeInitialBalance();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeInitialBalance( com.pomplatform.db.bean.BaseEmployeeInitialBalance bean, String additional ) throws Exception {

		EmployeeInitialBalance dao = new EmployeeInitialBalance();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeInitialBalance> queryEmployeeInitialBalance( com.pomplatform.db.bean.BaseEmployeeInitialBalance bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeInitialBalance dao = new EmployeeInitialBalance();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeInitialBalance> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeInitialBalance> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeInitialBalance addToEmployeeInitialBalance ( BaseEmployeeInitialBalance employeeinitialbalance )  throws Exception {
		return addToEmployeeInitialBalance ( employeeinitialbalance , false);
	}

	public static BaseEmployeeInitialBalance addToEmployeeInitialBalance ( BaseEmployeeInitialBalance employeeinitialbalance, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeInitialBalance dao = new EmployeeInitialBalance();
		dao.setDataFromBase(employeeinitialbalance);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeInitialBalance addUpdateEmployeeInitialBalance ( BaseEmployeeInitialBalance employeeinitialbalance ) throws Exception {
		return addUpdateEmployeeInitialBalance ( employeeinitialbalance , false);
	}

	public static BaseEmployeeInitialBalance addUpdateEmployeeInitialBalance ( BaseEmployeeInitialBalance employeeinitialbalance, boolean singleTransaction  ) throws Exception {
		if(employeeinitialbalance.getEmployeeInitialBalanceId() == null) return addToEmployeeInitialBalance(employeeinitialbalance);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeInitialBalance dao = new EmployeeInitialBalance();
		dao.setDataFromBase(employeeinitialbalance);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeeinitialbalance); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeInitialBalance ( BaseEmployeeInitialBalance bean ) throws Exception {
		EmployeeInitialBalance dao = new EmployeeInitialBalance();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeInitialBalance updateEmployeeInitialBalance ( BaseEmployeeInitialBalance employeeinitialbalance ) throws Exception {
		EmployeeInitialBalance dao = new EmployeeInitialBalance();
		dao.setEmployeeInitialBalanceId( employeeinitialbalance.getEmployeeInitialBalanceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeeinitialbalance);
			result = dao.update();
		}
		return result == 1 ? employeeinitialbalance : null ;
	}

	public static BaseEmployeeInitialBalance updateEmployeeInitialBalanceDirect( BaseEmployeeInitialBalance employeeinitialbalance ) throws Exception {
		EmployeeInitialBalance dao = new EmployeeInitialBalance();
		int result = 0;
		dao.setDataFromBase(employeeinitialbalance);
		result = dao.update();
		return result == 1 ? employeeinitialbalance : null ;
	}

	public static int setDeleteConditions(BaseEmployeeInitialBalance bean, EmployeeInitialBalance dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeInitialBalanceId() != null) {
			dao.setConditionEmployeeInitialBalanceId("=", bean.getEmployeeInitialBalanceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeInitialBalance bean, EmployeeInitialBalance dao){
		int count = 0;
		if(bean.getEmployeeInitialBalanceId() != null) {
			dao.setConditionEmployeeInitialBalanceId("=", bean.getEmployeeInitialBalanceId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getInitialBalance() != null) {
			dao.setConditionInitialBalance("=", bean.getInitialBalance());
			count++;
		}
		if(bean.getHappenDate() != null) {
			dao.setConditionHappenDate(">=", bean.getHappenDate());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeInitialBalance bean = new BaseEmployeeInitialBalance();
		bean.setDataFromJSON(json);
		EmployeeInitialBalance dao = new EmployeeInitialBalance();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeInitialBalance> rlist = new BaseCollection<>();
		BaseEmployeeInitialBalance bean = new BaseEmployeeInitialBalance();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeInitialBalance dao = new EmployeeInitialBalance();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeInitialBalance> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeInitialBalance bean = new BaseEmployeeInitialBalance();
		bean.setDataFromJSON(json);
		EmployeeInitialBalance dao = new EmployeeInitialBalance();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeInitialBalance bean = new BaseEmployeeInitialBalance();
		bean.setDataFromJSON(json);
		EmployeeInitialBalance dao = new EmployeeInitialBalance();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeInitialBalance bean = new BaseEmployeeInitialBalance();
		bean.setDataFromJSON(json);
		EmployeeInitialBalance dao = new EmployeeInitialBalance();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeInitialBalance bean = new BaseEmployeeInitialBalance();
		bean.setDataFromJSON(json);
		EmployeeInitialBalance dao = new EmployeeInitialBalance();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


