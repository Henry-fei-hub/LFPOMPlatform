package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeIntegralBusines;
import com.pomplatform.db.dao.EmployeeIntegralBusines;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeIntegralBusinesHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeIntegralBusinesHandler.class);

	public static BaseEmployeeIntegralBusines getEmployeeIntegralBusinesById( 
		java.lang.Integer employee_integral_business_id
	) throws Exception
	{
		EmployeeIntegralBusines dao = new EmployeeIntegralBusines();
		dao.setEmployeeIntegralBusinessId(employee_integral_business_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeIntegralBusinesExists( com.pomplatform.db.bean.BaseEmployeeIntegralBusines bean, String additional ) throws Exception {

		EmployeeIntegralBusines dao = new EmployeeIntegralBusines();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeIntegralBusines( com.pomplatform.db.bean.BaseEmployeeIntegralBusines bean, String additional ) throws Exception {

		EmployeeIntegralBusines dao = new EmployeeIntegralBusines();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeIntegralBusines> queryEmployeeIntegralBusines( com.pomplatform.db.bean.BaseEmployeeIntegralBusines bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeIntegralBusines dao = new EmployeeIntegralBusines();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeIntegralBusines> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeIntegralBusines> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeIntegralBusines addToEmployeeIntegralBusines ( BaseEmployeeIntegralBusines employeeintegralbusines )  throws Exception {
		return addToEmployeeIntegralBusines ( employeeintegralbusines , false);
	}

	public static BaseEmployeeIntegralBusines addToEmployeeIntegralBusines ( BaseEmployeeIntegralBusines employeeintegralbusines, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeIntegralBusines dao = new EmployeeIntegralBusines();
		dao.setDataFromBase(employeeintegralbusines);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeIntegralBusines addUpdateEmployeeIntegralBusines ( BaseEmployeeIntegralBusines employeeintegralbusines ) throws Exception {
		return addUpdateEmployeeIntegralBusines ( employeeintegralbusines , false);
	}

	public static BaseEmployeeIntegralBusines addUpdateEmployeeIntegralBusines ( BaseEmployeeIntegralBusines employeeintegralbusines, boolean singleTransaction  ) throws Exception {
		if(employeeintegralbusines.getEmployeeIntegralBusinessId() == null) return addToEmployeeIntegralBusines(employeeintegralbusines);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeIntegralBusines dao = new EmployeeIntegralBusines();
		dao.setDataFromBase(employeeintegralbusines);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeeintegralbusines); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeIntegralBusines ( BaseEmployeeIntegralBusines bean ) throws Exception {
		EmployeeIntegralBusines dao = new EmployeeIntegralBusines();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeIntegralBusines updateEmployeeIntegralBusines ( BaseEmployeeIntegralBusines employeeintegralbusines ) throws Exception {
		EmployeeIntegralBusines dao = new EmployeeIntegralBusines();
		dao.setEmployeeIntegralBusinessId( employeeintegralbusines.getEmployeeIntegralBusinessId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeeintegralbusines);
			result = dao.update();
		}
		return result == 1 ? employeeintegralbusines : null ;
	}

	public static BaseEmployeeIntegralBusines updateEmployeeIntegralBusinesDirect( BaseEmployeeIntegralBusines employeeintegralbusines ) throws Exception {
		EmployeeIntegralBusines dao = new EmployeeIntegralBusines();
		int result = 0;
		dao.setDataFromBase(employeeintegralbusines);
		result = dao.update();
		return result == 1 ? employeeintegralbusines : null ;
	}

	public static int setDeleteConditions(BaseEmployeeIntegralBusines bean, EmployeeIntegralBusines dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeIntegralBusinessId() != null) {
			dao.setConditionEmployeeIntegralBusinessId("=", bean.getEmployeeIntegralBusinessId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBusinessTypeId() != null) {
				dao.setConditionBusinessTypeId("=", bean.getBusinessTypeId());
				count++;
			}
			if(bean.getBusinessTypeName() != null) {
				dao.setConditionBusinessTypeName("=", bean.getBusinessTypeName());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeIntegralBusines bean, EmployeeIntegralBusines dao){
		int count = 0;
		if(bean.getEmployeeIntegralBusinessId() != null) {
			dao.setConditionEmployeeIntegralBusinessId("=", bean.getEmployeeIntegralBusinessId());
			count++;
		}
		if(bean.getBusinessTypeId() != null) {
			dao.setConditionBusinessTypeId("=", bean.getBusinessTypeId());
			count++;
		}
		if(bean.getBusinessTypeName() != null) {
			if(bean.getBusinessTypeName().indexOf("%") >= 0)
				dao.setConditionBusinessTypeName("like", bean.getBusinessTypeName());
			else
				dao.setConditionBusinessTypeName("=", bean.getBusinessTypeName());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getIntegral() != null) {
			dao.setConditionIntegral("=", bean.getIntegral());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeIntegralBusines bean = new BaseEmployeeIntegralBusines();
		bean.setDataFromJSON(json);
		EmployeeIntegralBusines dao = new EmployeeIntegralBusines();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeIntegralBusines> rlist = new BaseCollection<>();
		BaseEmployeeIntegralBusines bean = new BaseEmployeeIntegralBusines();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeIntegralBusines dao = new EmployeeIntegralBusines();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeIntegralBusines> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeIntegralBusines bean = new BaseEmployeeIntegralBusines();
		bean.setDataFromJSON(json);
		EmployeeIntegralBusines dao = new EmployeeIntegralBusines();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeIntegralBusines bean = new BaseEmployeeIntegralBusines();
		bean.setDataFromJSON(json);
		EmployeeIntegralBusines dao = new EmployeeIntegralBusines();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeIntegralBusines bean = new BaseEmployeeIntegralBusines();
		bean.setDataFromJSON(json);
		EmployeeIntegralBusines dao = new EmployeeIntegralBusines();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeIntegralBusines bean = new BaseEmployeeIntegralBusines();
		bean.setDataFromJSON(json);
		EmployeeIntegralBusines dao = new EmployeeIntegralBusines();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


