package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectContractEmployee;
import com.pomplatform.db.dao.ProjectContractEmployee;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectContractEmployeeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectContractEmployeeHandler.class);

	public static BaseProjectContractEmployee getProjectContractEmployeeById( 
		java.lang.Integer project_contract_employee_id
	) throws Exception
	{
		ProjectContractEmployee dao = new ProjectContractEmployee();
		dao.setProjectContractEmployeeId(project_contract_employee_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectContractEmployeeExists( com.pomplatform.db.bean.BaseProjectContractEmployee bean, String additional ) throws Exception {

		ProjectContractEmployee dao = new ProjectContractEmployee();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectContractEmployee( com.pomplatform.db.bean.BaseProjectContractEmployee bean, String additional ) throws Exception {

		ProjectContractEmployee dao = new ProjectContractEmployee();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectContractEmployee> queryProjectContractEmployee( com.pomplatform.db.bean.BaseProjectContractEmployee bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectContractEmployee dao = new ProjectContractEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectContractEmployee> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectContractEmployee> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectContractEmployee addToProjectContractEmployee ( BaseProjectContractEmployee projectcontractemployee )  throws Exception {
		return addToProjectContractEmployee ( projectcontractemployee , false);
	}

	public static BaseProjectContractEmployee addToProjectContractEmployee ( BaseProjectContractEmployee projectcontractemployee, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectContractEmployee dao = new ProjectContractEmployee();
		dao.setDataFromBase(projectcontractemployee);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectContractEmployee addUpdateProjectContractEmployee ( BaseProjectContractEmployee projectcontractemployee ) throws Exception {
		return addUpdateProjectContractEmployee ( projectcontractemployee , false);
	}

	public static BaseProjectContractEmployee addUpdateProjectContractEmployee ( BaseProjectContractEmployee projectcontractemployee, boolean singleTransaction  ) throws Exception {
		if(projectcontractemployee.getProjectContractEmployeeId() == null) return addToProjectContractEmployee(projectcontractemployee);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectContractEmployee dao = new ProjectContractEmployee();
		dao.setDataFromBase(projectcontractemployee);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectcontractemployee); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectContractEmployee ( BaseProjectContractEmployee bean ) throws Exception {
		ProjectContractEmployee dao = new ProjectContractEmployee();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectContractEmployee updateProjectContractEmployee ( BaseProjectContractEmployee projectcontractemployee ) throws Exception {
		ProjectContractEmployee dao = new ProjectContractEmployee();
		dao.setProjectContractEmployeeId( projectcontractemployee.getProjectContractEmployeeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectcontractemployee);
			result = dao.update();
		}
		return result == 1 ? projectcontractemployee : null ;
	}

	public static BaseProjectContractEmployee updateProjectContractEmployeeDirect( BaseProjectContractEmployee projectcontractemployee ) throws Exception {
		ProjectContractEmployee dao = new ProjectContractEmployee();
		int result = 0;
		dao.setDataFromBase(projectcontractemployee);
		result = dao.update();
		return result == 1 ? projectcontractemployee : null ;
	}

	public static int setDeleteConditions(BaseProjectContractEmployee bean, ProjectContractEmployee dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectContractEmployeeId() != null) {
			dao.setConditionProjectContractEmployeeId("=", bean.getProjectContractEmployeeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectContractChangeId() != null) {
				dao.setConditionProjectContractChangeId("=", bean.getProjectContractChangeId());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
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
		}
		return count;
	}

	public static int setConditions(BaseProjectContractEmployee bean, ProjectContractEmployee dao){
		int count = 0;
		if(bean.getProjectContractEmployeeId() != null) {
			dao.setConditionProjectContractEmployeeId("=", bean.getProjectContractEmployeeId());
			count++;
		}
		if(bean.getProjectContractChangeId() != null) {
			dao.setConditionProjectContractChangeId("=", bean.getProjectContractChangeId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
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
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectContractEmployee bean = new BaseProjectContractEmployee();
		bean.setDataFromJSON(json);
		ProjectContractEmployee dao = new ProjectContractEmployee();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectContractEmployee> rlist = new BaseCollection<>();
		BaseProjectContractEmployee bean = new BaseProjectContractEmployee();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectContractEmployee dao = new ProjectContractEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectContractEmployee> result = dao.conditionalLoad(addtion);
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
		BaseProjectContractEmployee bean = new BaseProjectContractEmployee();
		bean.setDataFromJSON(json);
		ProjectContractEmployee dao = new ProjectContractEmployee();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectContractEmployee bean = new BaseProjectContractEmployee();
		bean.setDataFromJSON(json);
		ProjectContractEmployee dao = new ProjectContractEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectContractEmployee bean = new BaseProjectContractEmployee();
		bean.setDataFromJSON(json);
		ProjectContractEmployee dao = new ProjectContractEmployee();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectContractEmployee bean = new BaseProjectContractEmployee();
		bean.setDataFromJSON(json);
		ProjectContractEmployee dao = new ProjectContractEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


