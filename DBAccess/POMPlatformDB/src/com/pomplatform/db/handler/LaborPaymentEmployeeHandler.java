package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseLaborPaymentEmployee;
import com.pomplatform.db.dao.LaborPaymentEmployee;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class LaborPaymentEmployeeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(LaborPaymentEmployeeHandler.class);

	public static BaseLaborPaymentEmployee getLaborPaymentEmployeeById( 
		java.lang.Integer labor_payment_employee_id
	) throws Exception
	{
		LaborPaymentEmployee dao = new LaborPaymentEmployee();
		dao.setLaborPaymentEmployeeId(labor_payment_employee_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isLaborPaymentEmployeeExists( com.pomplatform.db.bean.BaseLaborPaymentEmployee bean, String additional ) throws Exception {

		LaborPaymentEmployee dao = new LaborPaymentEmployee();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countLaborPaymentEmployee( com.pomplatform.db.bean.BaseLaborPaymentEmployee bean, String additional ) throws Exception {

		LaborPaymentEmployee dao = new LaborPaymentEmployee();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseLaborPaymentEmployee> queryLaborPaymentEmployee( com.pomplatform.db.bean.BaseLaborPaymentEmployee bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		LaborPaymentEmployee dao = new LaborPaymentEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseLaborPaymentEmployee> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseLaborPaymentEmployee> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseLaborPaymentEmployee addToLaborPaymentEmployee ( BaseLaborPaymentEmployee laborpaymentemployee )  throws Exception {
		return addToLaborPaymentEmployee ( laborpaymentemployee , false);
	}

	public static BaseLaborPaymentEmployee addToLaborPaymentEmployee ( BaseLaborPaymentEmployee laborpaymentemployee, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		LaborPaymentEmployee dao = new LaborPaymentEmployee();
		dao.setDataFromBase(laborpaymentemployee);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseLaborPaymentEmployee addUpdateLaborPaymentEmployee ( BaseLaborPaymentEmployee laborpaymentemployee ) throws Exception {
		return addUpdateLaborPaymentEmployee ( laborpaymentemployee , false);
	}

	public static BaseLaborPaymentEmployee addUpdateLaborPaymentEmployee ( BaseLaborPaymentEmployee laborpaymentemployee, boolean singleTransaction  ) throws Exception {
		if(laborpaymentemployee.getLaborPaymentEmployeeId() == null) return addToLaborPaymentEmployee(laborpaymentemployee);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		LaborPaymentEmployee dao = new LaborPaymentEmployee();
		dao.setDataFromBase(laborpaymentemployee);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(laborpaymentemployee); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteLaborPaymentEmployee ( BaseLaborPaymentEmployee bean ) throws Exception {
		LaborPaymentEmployee dao = new LaborPaymentEmployee();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseLaborPaymentEmployee updateLaborPaymentEmployee ( BaseLaborPaymentEmployee laborpaymentemployee ) throws Exception {
		LaborPaymentEmployee dao = new LaborPaymentEmployee();
		dao.setLaborPaymentEmployeeId( laborpaymentemployee.getLaborPaymentEmployeeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(laborpaymentemployee);
			result = dao.update();
		}
		return result == 1 ? laborpaymentemployee : null ;
	}

	public static BaseLaborPaymentEmployee updateLaborPaymentEmployeeDirect( BaseLaborPaymentEmployee laborpaymentemployee ) throws Exception {
		LaborPaymentEmployee dao = new LaborPaymentEmployee();
		int result = 0;
		dao.setDataFromBase(laborpaymentemployee);
		result = dao.update();
		return result == 1 ? laborpaymentemployee : null ;
	}

	public static int setDeleteConditions(BaseLaborPaymentEmployee bean, LaborPaymentEmployee dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getLaborPaymentEmployeeId() != null) {
			dao.setConditionLaborPaymentEmployeeId("=", bean.getLaborPaymentEmployeeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseLaborPaymentEmployee bean, LaborPaymentEmployee dao){
		int count = 0;
		if(bean.getLaborPaymentEmployeeId() != null) {
			dao.setConditionLaborPaymentEmployeeId("=", bean.getLaborPaymentEmployeeId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseLaborPaymentEmployee bean = new BaseLaborPaymentEmployee();
		bean.setDataFromJSON(json);
		LaborPaymentEmployee dao = new LaborPaymentEmployee();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseLaborPaymentEmployee> rlist = new BaseCollection<>();
		BaseLaborPaymentEmployee bean = new BaseLaborPaymentEmployee();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		LaborPaymentEmployee dao = new LaborPaymentEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseLaborPaymentEmployee> result = dao.conditionalLoad(addtion);
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
		BaseLaborPaymentEmployee bean = new BaseLaborPaymentEmployee();
		bean.setDataFromJSON(json);
		LaborPaymentEmployee dao = new LaborPaymentEmployee();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseLaborPaymentEmployee bean = new BaseLaborPaymentEmployee();
		bean.setDataFromJSON(json);
		LaborPaymentEmployee dao = new LaborPaymentEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseLaborPaymentEmployee bean = new BaseLaborPaymentEmployee();
		bean.setDataFromJSON(json);
		LaborPaymentEmployee dao = new LaborPaymentEmployee();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseLaborPaymentEmployee bean = new BaseLaborPaymentEmployee();
		bean.setDataFromJSON(json);
		LaborPaymentEmployee dao = new LaborPaymentEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


