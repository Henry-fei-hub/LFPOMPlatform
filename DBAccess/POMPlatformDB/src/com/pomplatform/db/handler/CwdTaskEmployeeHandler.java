package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdTaskEmployee;
import com.pomplatform.db.dao.CwdTaskEmployee;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdTaskEmployeeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdTaskEmployeeHandler.class);

	public static BaseCwdTaskEmployee getCwdTaskEmployeeById( 
		java.lang.Integer cwd_task_employee_id
	) throws Exception
	{
		CwdTaskEmployee dao = new CwdTaskEmployee();
		dao.setCwdTaskEmployeeId(cwd_task_employee_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdTaskEmployeeExists( com.pomplatform.db.bean.BaseCwdTaskEmployee bean, String additional ) throws Exception {

		CwdTaskEmployee dao = new CwdTaskEmployee();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdTaskEmployee( com.pomplatform.db.bean.BaseCwdTaskEmployee bean, String additional ) throws Exception {

		CwdTaskEmployee dao = new CwdTaskEmployee();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdTaskEmployee> queryCwdTaskEmployee( com.pomplatform.db.bean.BaseCwdTaskEmployee bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdTaskEmployee dao = new CwdTaskEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdTaskEmployee> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdTaskEmployee> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdTaskEmployee addToCwdTaskEmployee ( BaseCwdTaskEmployee cwdtaskemployee )  throws Exception {
		return addToCwdTaskEmployee ( cwdtaskemployee , false);
	}

	public static BaseCwdTaskEmployee addToCwdTaskEmployee ( BaseCwdTaskEmployee cwdtaskemployee, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdTaskEmployee dao = new CwdTaskEmployee();
		dao.setDataFromBase(cwdtaskemployee);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdTaskEmployee addUpdateCwdTaskEmployee ( BaseCwdTaskEmployee cwdtaskemployee ) throws Exception {
		return addUpdateCwdTaskEmployee ( cwdtaskemployee , false);
	}

	public static BaseCwdTaskEmployee addUpdateCwdTaskEmployee ( BaseCwdTaskEmployee cwdtaskemployee, boolean singleTransaction  ) throws Exception {
		if(cwdtaskemployee.getCwdTaskEmployeeId() == null) return addToCwdTaskEmployee(cwdtaskemployee);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdTaskEmployee dao = new CwdTaskEmployee();
		dao.setDataFromBase(cwdtaskemployee);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdtaskemployee); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdTaskEmployee ( BaseCwdTaskEmployee bean ) throws Exception {
		CwdTaskEmployee dao = new CwdTaskEmployee();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdTaskEmployee updateCwdTaskEmployee ( BaseCwdTaskEmployee cwdtaskemployee ) throws Exception {
		CwdTaskEmployee dao = new CwdTaskEmployee();
		dao.setCwdTaskEmployeeId( cwdtaskemployee.getCwdTaskEmployeeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdtaskemployee);
			result = dao.update();
		}
		return result == 1 ? cwdtaskemployee : null ;
	}

	public static BaseCwdTaskEmployee updateCwdTaskEmployeeDirect( BaseCwdTaskEmployee cwdtaskemployee ) throws Exception {
		CwdTaskEmployee dao = new CwdTaskEmployee();
		int result = 0;
		dao.setDataFromBase(cwdtaskemployee);
		result = dao.update();
		return result == 1 ? cwdtaskemployee : null ;
	}

	public static int setDeleteConditions(BaseCwdTaskEmployee bean, CwdTaskEmployee dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdTaskEmployeeId() != null) {
			dao.setConditionCwdTaskEmployeeId("=", bean.getCwdTaskEmployeeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCwdTaskManageId() != null) {
				dao.setConditionCwdTaskManageId("=", bean.getCwdTaskManageId());
				count++;
			}
			if(bean.getTaskRole() != null) {
				dao.setConditionTaskRole("=", bean.getTaskRole());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdTaskEmployee bean, CwdTaskEmployee dao){
		int count = 0;
		if(bean.getCwdTaskEmployeeId() != null) {
			dao.setConditionCwdTaskEmployeeId("=", bean.getCwdTaskEmployeeId());
			count++;
		}
		if(bean.getCwdTaskManageId() != null) {
			dao.setConditionCwdTaskManageId("=", bean.getCwdTaskManageId());
			count++;
		}
		if(bean.getTaskRole() != null) {
			dao.setConditionTaskRole("=", bean.getTaskRole());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
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
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdTaskEmployee bean = new BaseCwdTaskEmployee();
		bean.setDataFromJSON(json);
		CwdTaskEmployee dao = new CwdTaskEmployee();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdTaskEmployee> rlist = new BaseCollection<>();
		BaseCwdTaskEmployee bean = new BaseCwdTaskEmployee();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdTaskEmployee dao = new CwdTaskEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdTaskEmployee> result = dao.conditionalLoad(addtion);
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
		BaseCwdTaskEmployee bean = new BaseCwdTaskEmployee();
		bean.setDataFromJSON(json);
		CwdTaskEmployee dao = new CwdTaskEmployee();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdTaskEmployee bean = new BaseCwdTaskEmployee();
		bean.setDataFromJSON(json);
		CwdTaskEmployee dao = new CwdTaskEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdTaskEmployee bean = new BaseCwdTaskEmployee();
		bean.setDataFromJSON(json);
		CwdTaskEmployee dao = new CwdTaskEmployee();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdTaskEmployee bean = new BaseCwdTaskEmployee();
		bean.setDataFromJSON(json);
		CwdTaskEmployee dao = new CwdTaskEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


