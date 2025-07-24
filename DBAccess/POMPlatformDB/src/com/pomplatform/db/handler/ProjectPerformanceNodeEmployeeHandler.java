package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectPerformanceNodeEmployee;
import com.pomplatform.db.dao.ProjectPerformanceNodeEmployee;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectPerformanceNodeEmployeeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectPerformanceNodeEmployeeHandler.class);

	public static BaseProjectPerformanceNodeEmployee getProjectPerformanceNodeEmployeeById( 
		java.lang.Integer project_performance_node_employee_id
	) throws Exception
	{
		ProjectPerformanceNodeEmployee dao = new ProjectPerformanceNodeEmployee();
		dao.setProjectPerformanceNodeEmployeeId(project_performance_node_employee_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectPerformanceNodeEmployeeExists( com.pomplatform.db.bean.BaseProjectPerformanceNodeEmployee bean, String additional ) throws Exception {

		ProjectPerformanceNodeEmployee dao = new ProjectPerformanceNodeEmployee();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectPerformanceNodeEmployee( com.pomplatform.db.bean.BaseProjectPerformanceNodeEmployee bean, String additional ) throws Exception {

		ProjectPerformanceNodeEmployee dao = new ProjectPerformanceNodeEmployee();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectPerformanceNodeEmployee> queryProjectPerformanceNodeEmployee( com.pomplatform.db.bean.BaseProjectPerformanceNodeEmployee bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectPerformanceNodeEmployee dao = new ProjectPerformanceNodeEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectPerformanceNodeEmployee> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectPerformanceNodeEmployee> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectPerformanceNodeEmployee addToProjectPerformanceNodeEmployee ( BaseProjectPerformanceNodeEmployee projectperformancenodeemployee )  throws Exception {
		return addToProjectPerformanceNodeEmployee ( projectperformancenodeemployee , false);
	}

	public static BaseProjectPerformanceNodeEmployee addToProjectPerformanceNodeEmployee ( BaseProjectPerformanceNodeEmployee projectperformancenodeemployee, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectPerformanceNodeEmployee dao = new ProjectPerformanceNodeEmployee();
		dao.setDataFromBase(projectperformancenodeemployee);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectPerformanceNodeEmployee addUpdateProjectPerformanceNodeEmployee ( BaseProjectPerformanceNodeEmployee projectperformancenodeemployee ) throws Exception {
		return addUpdateProjectPerformanceNodeEmployee ( projectperformancenodeemployee , false);
	}

	public static BaseProjectPerformanceNodeEmployee addUpdateProjectPerformanceNodeEmployee ( BaseProjectPerformanceNodeEmployee projectperformancenodeemployee, boolean singleTransaction  ) throws Exception {
		if(projectperformancenodeemployee.getProjectPerformanceNodeEmployeeId() == null) return addToProjectPerformanceNodeEmployee(projectperformancenodeemployee);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectPerformanceNodeEmployee dao = new ProjectPerformanceNodeEmployee();
		dao.setDataFromBase(projectperformancenodeemployee);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectperformancenodeemployee); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectPerformanceNodeEmployee ( BaseProjectPerformanceNodeEmployee bean ) throws Exception {
		ProjectPerformanceNodeEmployee dao = new ProjectPerformanceNodeEmployee();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectPerformanceNodeEmployee updateProjectPerformanceNodeEmployee ( BaseProjectPerformanceNodeEmployee projectperformancenodeemployee ) throws Exception {
		ProjectPerformanceNodeEmployee dao = new ProjectPerformanceNodeEmployee();
		dao.setProjectPerformanceNodeEmployeeId( projectperformancenodeemployee.getProjectPerformanceNodeEmployeeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectperformancenodeemployee);
			result = dao.update();
		}
		return result == 1 ? projectperformancenodeemployee : null ;
	}

	public static BaseProjectPerformanceNodeEmployee updateProjectPerformanceNodeEmployeeDirect( BaseProjectPerformanceNodeEmployee projectperformancenodeemployee ) throws Exception {
		ProjectPerformanceNodeEmployee dao = new ProjectPerformanceNodeEmployee();
		int result = 0;
		dao.setDataFromBase(projectperformancenodeemployee);
		result = dao.update();
		return result == 1 ? projectperformancenodeemployee : null ;
	}

	public static int setDeleteConditions(BaseProjectPerformanceNodeEmployee bean, ProjectPerformanceNodeEmployee dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectPerformanceNodeEmployeeId() != null) {
			dao.setConditionProjectPerformanceNodeEmployeeId("=", bean.getProjectPerformanceNodeEmployeeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getEmployeeName() != null) {
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectPerformanceNodeEmployee bean, ProjectPerformanceNodeEmployee dao){
		int count = 0;
		if(bean.getProjectPerformanceNodeEmployeeId() != null) {
			dao.setConditionProjectPerformanceNodeEmployeeId("=", bean.getProjectPerformanceNodeEmployeeId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getEmployeeName() != null) {
			if(bean.getEmployeeName().indexOf("%") >= 0)
				dao.setConditionEmployeeName("like", bean.getEmployeeName());
			else
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
			count++;
		}
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getRecordTime() != null) {
			dao.setConditionRecordTime(">=", bean.getRecordTime());
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
		BaseProjectPerformanceNodeEmployee bean = new BaseProjectPerformanceNodeEmployee();
		bean.setDataFromJSON(json);
		ProjectPerformanceNodeEmployee dao = new ProjectPerformanceNodeEmployee();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectPerformanceNodeEmployee> rlist = new BaseCollection<>();
		BaseProjectPerformanceNodeEmployee bean = new BaseProjectPerformanceNodeEmployee();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectPerformanceNodeEmployee dao = new ProjectPerformanceNodeEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectPerformanceNodeEmployee> result = dao.conditionalLoad(addtion);
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
		BaseProjectPerformanceNodeEmployee bean = new BaseProjectPerformanceNodeEmployee();
		bean.setDataFromJSON(json);
		ProjectPerformanceNodeEmployee dao = new ProjectPerformanceNodeEmployee();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectPerformanceNodeEmployee bean = new BaseProjectPerformanceNodeEmployee();
		bean.setDataFromJSON(json);
		ProjectPerformanceNodeEmployee dao = new ProjectPerformanceNodeEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectPerformanceNodeEmployee bean = new BaseProjectPerformanceNodeEmployee();
		bean.setDataFromJSON(json);
		ProjectPerformanceNodeEmployee dao = new ProjectPerformanceNodeEmployee();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectPerformanceNodeEmployee bean = new BaseProjectPerformanceNodeEmployee();
		bean.setDataFromJSON(json);
		ProjectPerformanceNodeEmployee dao = new ProjectPerformanceNodeEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


