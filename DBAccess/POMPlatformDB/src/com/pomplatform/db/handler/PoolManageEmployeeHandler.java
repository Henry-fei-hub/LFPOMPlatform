package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePoolManageEmployee;
import com.pomplatform.db.dao.PoolManageEmployee;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PoolManageEmployeeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PoolManageEmployeeHandler.class);

	public static BasePoolManageEmployee getPoolManageEmployeeById( 
		java.lang.Integer pool_manage_employee_id
	) throws Exception
	{
		PoolManageEmployee dao = new PoolManageEmployee();
		dao.setPoolManageEmployeeId(pool_manage_employee_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPoolManageEmployeeExists( com.pomplatform.db.bean.BasePoolManageEmployee bean, String additional ) throws Exception {

		PoolManageEmployee dao = new PoolManageEmployee();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPoolManageEmployee( com.pomplatform.db.bean.BasePoolManageEmployee bean, String additional ) throws Exception {

		PoolManageEmployee dao = new PoolManageEmployee();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePoolManageEmployee> queryPoolManageEmployee( com.pomplatform.db.bean.BasePoolManageEmployee bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PoolManageEmployee dao = new PoolManageEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePoolManageEmployee> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePoolManageEmployee> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePoolManageEmployee addToPoolManageEmployee ( BasePoolManageEmployee poolmanageemployee )  throws Exception {
		return addToPoolManageEmployee ( poolmanageemployee , false);
	}

	public static BasePoolManageEmployee addToPoolManageEmployee ( BasePoolManageEmployee poolmanageemployee, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PoolManageEmployee dao = new PoolManageEmployee();
		dao.setDataFromBase(poolmanageemployee);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePoolManageEmployee addUpdatePoolManageEmployee ( BasePoolManageEmployee poolmanageemployee ) throws Exception {
		return addUpdatePoolManageEmployee ( poolmanageemployee , false);
	}

	public static BasePoolManageEmployee addUpdatePoolManageEmployee ( BasePoolManageEmployee poolmanageemployee, boolean singleTransaction  ) throws Exception {
		if(poolmanageemployee.getPoolManageEmployeeId() == null) return addToPoolManageEmployee(poolmanageemployee);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PoolManageEmployee dao = new PoolManageEmployee();
		dao.setDataFromBase(poolmanageemployee);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(poolmanageemployee); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePoolManageEmployee ( BasePoolManageEmployee bean ) throws Exception {
		PoolManageEmployee dao = new PoolManageEmployee();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePoolManageEmployee updatePoolManageEmployee ( BasePoolManageEmployee poolmanageemployee ) throws Exception {
		PoolManageEmployee dao = new PoolManageEmployee();
		dao.setPoolManageEmployeeId( poolmanageemployee.getPoolManageEmployeeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(poolmanageemployee);
			result = dao.update();
		}
		return result == 1 ? poolmanageemployee : null ;
	}

	public static BasePoolManageEmployee updatePoolManageEmployeeDirect( BasePoolManageEmployee poolmanageemployee ) throws Exception {
		PoolManageEmployee dao = new PoolManageEmployee();
		int result = 0;
		dao.setDataFromBase(poolmanageemployee);
		result = dao.update();
		return result == 1 ? poolmanageemployee : null ;
	}

	public static int setDeleteConditions(BasePoolManageEmployee bean, PoolManageEmployee dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPoolManageEmployeeId() != null) {
			dao.setConditionPoolManageEmployeeId("=", bean.getPoolManageEmployeeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPoolManageId() != null) {
				dao.setConditionPoolManageId("=", bean.getPoolManageId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getBusinessIds() != null) {
				dao.setConditionBusinessIds("=", bean.getBusinessIds());
				count++;
			}
			if(bean.getBusinessNames() != null) {
				dao.setConditionBusinessNames("=", bean.getBusinessNames());
				count++;
			}
			if(bean.getProfessionalIds() != null) {
				dao.setConditionProfessionalIds("=", bean.getProfessionalIds());
				count++;
			}
			if(bean.getProfessionalNames() != null) {
				dao.setConditionProfessionalNames("=", bean.getProfessionalNames());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePoolManageEmployee bean, PoolManageEmployee dao){
		int count = 0;
		if(bean.getPoolManageEmployeeId() != null) {
			dao.setConditionPoolManageEmployeeId("=", bean.getPoolManageEmployeeId());
			count++;
		}
		if(bean.getPoolManageId() != null) {
			dao.setConditionPoolManageId("=", bean.getPoolManageId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getBusinessIds() != null) {
			if(bean.getBusinessIds().indexOf("%") >= 0)
				dao.setConditionBusinessIds("like", bean.getBusinessIds());
			else
				dao.setConditionBusinessIds("=", bean.getBusinessIds());
			count++;
		}
		if(bean.getBusinessNames() != null) {
			if(bean.getBusinessNames().indexOf("%") >= 0)
				dao.setConditionBusinessNames("like", bean.getBusinessNames());
			else
				dao.setConditionBusinessNames("=", bean.getBusinessNames());
			count++;
		}
		if(bean.getProfessionalIds() != null) {
			if(bean.getProfessionalIds().indexOf("%") >= 0)
				dao.setConditionProfessionalIds("like", bean.getProfessionalIds());
			else
				dao.setConditionProfessionalIds("=", bean.getProfessionalIds());
			count++;
		}
		if(bean.getProfessionalNames() != null) {
			if(bean.getProfessionalNames().indexOf("%") >= 0)
				dao.setConditionProfessionalNames("like", bean.getProfessionalNames());
			else
				dao.setConditionProfessionalNames("=", bean.getProfessionalNames());
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
		BasePoolManageEmployee bean = new BasePoolManageEmployee();
		bean.setDataFromJSON(json);
		PoolManageEmployee dao = new PoolManageEmployee();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePoolManageEmployee> rlist = new BaseCollection<>();
		BasePoolManageEmployee bean = new BasePoolManageEmployee();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PoolManageEmployee dao = new PoolManageEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePoolManageEmployee> result = dao.conditionalLoad(addtion);
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
		BasePoolManageEmployee bean = new BasePoolManageEmployee();
		bean.setDataFromJSON(json);
		PoolManageEmployee dao = new PoolManageEmployee();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePoolManageEmployee bean = new BasePoolManageEmployee();
		bean.setDataFromJSON(json);
		PoolManageEmployee dao = new PoolManageEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePoolManageEmployee bean = new BasePoolManageEmployee();
		bean.setDataFromJSON(json);
		PoolManageEmployee dao = new PoolManageEmployee();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePoolManageEmployee bean = new BasePoolManageEmployee();
		bean.setDataFromJSON(json);
		PoolManageEmployee dao = new PoolManageEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


