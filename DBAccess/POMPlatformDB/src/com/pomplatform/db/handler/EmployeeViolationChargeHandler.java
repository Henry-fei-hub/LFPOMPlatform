package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeViolationCharge;
import com.pomplatform.db.dao.EmployeeViolationCharge;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeViolationChargeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeViolationChargeHandler.class);

	public static BaseEmployeeViolationCharge getEmployeeViolationChargeById( 
		java.lang.Integer employee_violation_charges_id
	) throws Exception
	{
		EmployeeViolationCharge dao = new EmployeeViolationCharge();
		dao.setEmployeeViolationChargesId(employee_violation_charges_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeViolationChargeExists( com.pomplatform.db.bean.BaseEmployeeViolationCharge bean, String additional ) throws Exception {

		EmployeeViolationCharge dao = new EmployeeViolationCharge();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeViolationCharge( com.pomplatform.db.bean.BaseEmployeeViolationCharge bean, String additional ) throws Exception {

		EmployeeViolationCharge dao = new EmployeeViolationCharge();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeViolationCharge> queryEmployeeViolationCharge( com.pomplatform.db.bean.BaseEmployeeViolationCharge bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeViolationCharge dao = new EmployeeViolationCharge();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeViolationCharge> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeViolationCharge> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeViolationCharge addToEmployeeViolationCharge ( BaseEmployeeViolationCharge employeeviolationcharge )  throws Exception {
		return addToEmployeeViolationCharge ( employeeviolationcharge , false);
	}

	public static BaseEmployeeViolationCharge addToEmployeeViolationCharge ( BaseEmployeeViolationCharge employeeviolationcharge, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeViolationCharge dao = new EmployeeViolationCharge();
		dao.setDataFromBase(employeeviolationcharge);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeViolationCharge addUpdateEmployeeViolationCharge ( BaseEmployeeViolationCharge employeeviolationcharge ) throws Exception {
		return addUpdateEmployeeViolationCharge ( employeeviolationcharge , false);
	}

	public static BaseEmployeeViolationCharge addUpdateEmployeeViolationCharge ( BaseEmployeeViolationCharge employeeviolationcharge, boolean singleTransaction  ) throws Exception {
		if(employeeviolationcharge.getEmployeeViolationChargesId() == null) return addToEmployeeViolationCharge(employeeviolationcharge);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeViolationCharge dao = new EmployeeViolationCharge();
		dao.setDataFromBase(employeeviolationcharge);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeeviolationcharge); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeViolationCharge ( BaseEmployeeViolationCharge bean ) throws Exception {
		EmployeeViolationCharge dao = new EmployeeViolationCharge();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeViolationCharge updateEmployeeViolationCharge ( BaseEmployeeViolationCharge employeeviolationcharge ) throws Exception {
		EmployeeViolationCharge dao = new EmployeeViolationCharge();
		dao.setEmployeeViolationChargesId( employeeviolationcharge.getEmployeeViolationChargesId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeeviolationcharge);
			result = dao.update();
		}
		return result == 1 ? employeeviolationcharge : null ;
	}

	public static BaseEmployeeViolationCharge updateEmployeeViolationChargeDirect( BaseEmployeeViolationCharge employeeviolationcharge ) throws Exception {
		EmployeeViolationCharge dao = new EmployeeViolationCharge();
		int result = 0;
		dao.setDataFromBase(employeeviolationcharge);
		result = dao.update();
		return result == 1 ? employeeviolationcharge : null ;
	}

	public static int setDeleteConditions(BaseEmployeeViolationCharge bean, EmployeeViolationCharge dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeViolationChargesId() != null) {
			dao.setConditionEmployeeViolationChargesId("=", bean.getEmployeeViolationChargesId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeViolationCharge bean, EmployeeViolationCharge dao){
		int count = 0;
		if(bean.getEmployeeViolationChargesId() != null) {
			dao.setConditionEmployeeViolationChargesId("=", bean.getEmployeeViolationChargesId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getViolationCharges() != null) {
			dao.setConditionViolationCharges("=", bean.getViolationCharges());
			count++;
		}
		if(bean.getViolationDate() != null) {
			dao.setConditionViolationDate(">=", bean.getViolationDate());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeViolationCharge bean = new BaseEmployeeViolationCharge();
		bean.setDataFromJSON(json);
		EmployeeViolationCharge dao = new EmployeeViolationCharge();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeViolationCharge> rlist = new BaseCollection<>();
		BaseEmployeeViolationCharge bean = new BaseEmployeeViolationCharge();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeViolationCharge dao = new EmployeeViolationCharge();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeViolationCharge> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeViolationCharge bean = new BaseEmployeeViolationCharge();
		bean.setDataFromJSON(json);
		EmployeeViolationCharge dao = new EmployeeViolationCharge();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeViolationCharge bean = new BaseEmployeeViolationCharge();
		bean.setDataFromJSON(json);
		EmployeeViolationCharge dao = new EmployeeViolationCharge();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeViolationCharge bean = new BaseEmployeeViolationCharge();
		bean.setDataFromJSON(json);
		EmployeeViolationCharge dao = new EmployeeViolationCharge();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeViolationCharge bean = new BaseEmployeeViolationCharge();
		bean.setDataFromJSON(json);
		EmployeeViolationCharge dao = new EmployeeViolationCharge();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


