package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseProjectEmployee;
import java.util.List;
import com.pomplatform.db.dao.ProjectEmployee;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ProjectEmployeeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectEmployeeHandler.class);

	public static BaseProjectEmployee getProjectEmployeeById( 
		java.lang.Integer project_employee_id
	) throws Exception
	{
		ProjectEmployee dao = new ProjectEmployee();
		dao.setProjectEmployeeId(project_employee_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectEmployeeExists( com.pomplatform.db.bean.BaseProjectEmployee bean, String additional ) throws Exception {

		ProjectEmployee dao = new ProjectEmployee();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectEmployee( com.pomplatform.db.bean.BaseProjectEmployee bean, String additional ) throws Exception {

		ProjectEmployee dao = new ProjectEmployee();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectEmployee> queryProjectEmployee( com.pomplatform.db.bean.BaseProjectEmployee bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectEmployee dao = new ProjectEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectEmployee> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectEmployee> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectEmployee addToProjectEmployee ( BaseProjectEmployee projectemployee )  throws Exception {
		return addToProjectEmployee ( projectemployee , false);
	}

	public static BaseProjectEmployee addToProjectEmployee ( BaseProjectEmployee projectemployee, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectEmployee dao = new ProjectEmployee();
		dao.setDataFromBase(projectemployee);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectEmployee addUpdateProjectEmployee ( BaseProjectEmployee projectemployee ) throws Exception {
		return addUpdateProjectEmployee ( projectemployee , false);
	}

	public static BaseProjectEmployee addUpdateProjectEmployee ( BaseProjectEmployee projectemployee, boolean singleTransaction  ) throws Exception {
		if(projectemployee.getProjectEmployeeId() == null) return addToProjectEmployee(projectemployee);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectEmployee dao = new ProjectEmployee();
		dao.setDataFromBase(projectemployee);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectemployee); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectEmployee ( BaseProjectEmployee bean ) throws Exception {
		ProjectEmployee dao = new ProjectEmployee();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectEmployee updateProjectEmployee ( BaseProjectEmployee projectemployee ) throws Exception {
		ProjectEmployee dao = new ProjectEmployee();
		dao.setProjectEmployeeId( projectemployee.getProjectEmployeeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectemployee);
			result = dao.update();
		}
		return result == 1 ? projectemployee : null ;
	}

	public static BaseProjectEmployee updateProjectEmployeeDirect( BaseProjectEmployee projectemployee ) throws Exception {
		ProjectEmployee dao = new ProjectEmployee();
		int result = 0;
		dao.setDataFromBase(projectemployee);
		result = dao.update();
		return result == 1 ? projectemployee : null ;
	}

	public static int setDeleteConditions(BaseProjectEmployee bean, ProjectEmployee dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectEmployeeId() != null) {
			dao.setConditionProjectEmployeeId("=", bean.getProjectEmployeeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getDesignPhase() != null) {
				dao.setConditionDesignPhase("=", bean.getDesignPhase());
				count++;
			}
			if(bean.getPlanWorkHours() != null) {
				dao.setConditionPlanWorkHours("=", bean.getPlanWorkHours());
				count++;
			}
			if(bean.getRealWorkHours() != null) {
				dao.setConditionRealWorkHours("=", bean.getRealWorkHours());
				count++;
			}
			if(bean.getWorkContent() != null) {
				dao.setConditionWorkContent("=", bean.getWorkContent());
				count++;
			}
			if(bean.getAlternateField1() != null) {
				dao.setConditionAlternateField1("=", bean.getAlternateField1());
				count++;
			}
			if(bean.getAlternateField2() != null) {
				dao.setConditionAlternateField2("=", bean.getAlternateField2());
				count++;
			}
			if(bean.getAlternateField3() != null) {
				dao.setConditionAlternateField3("=", bean.getAlternateField3());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getStageId() != null) {
				dao.setConditionStageId("=", bean.getStageId());
				count++;
			}
			if(bean.getFlag() != null) {
				dao.setConditionFlag("=", bean.getFlag());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectEmployee bean, ProjectEmployee dao){
		int count = 0;
		if(bean.getProjectEmployeeId() != null) {
			dao.setConditionProjectEmployeeId("=", bean.getProjectEmployeeId());
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
		if(bean.getDesignPhase() != null) {
			dao.setConditionDesignPhase("=", bean.getDesignPhase());
			count++;
		}
		if(bean.getPlanWorkHours() != null) {
			dao.setConditionPlanWorkHours("=", bean.getPlanWorkHours());
			count++;
		}
		if(bean.getRealWorkHours() != null) {
			dao.setConditionRealWorkHours("=", bean.getRealWorkHours());
			count++;
		}
		if(bean.getPlanIntegral() != null) {
			dao.setConditionPlanIntegral("=", bean.getPlanIntegral());
			count++;
		}
		if(bean.getRealIntegral() != null) {
			dao.setConditionRealIntegral("=", bean.getRealIntegral());
			count++;
		}
		if(bean.getPlanStartDate() != null) {
			dao.setConditionPlanStartDate(">=", bean.getPlanStartDate());
			count++;
		}
		if(bean.getPlanEndDate() != null) {
			dao.setConditionPlanEndDate(">=", bean.getPlanEndDate());
			count++;
		}
		if(bean.getStartDate() != null) {
			dao.setConditionStartDate(">=", bean.getStartDate());
			count++;
		}
		if(bean.getEndDate() != null) {
			dao.setConditionEndDate(">=", bean.getEndDate());
			count++;
		}
		if(bean.getWorkContent() != null) {
			if(bean.getWorkContent().indexOf("%") >= 0)
				dao.setConditionWorkContent("like", bean.getWorkContent());
			else
				dao.setConditionWorkContent("=", bean.getWorkContent());
			count++;
		}
		if(bean.getAlternateField1() != null) {
			if(bean.getAlternateField1().indexOf("%") >= 0)
				dao.setConditionAlternateField1("like", bean.getAlternateField1());
			else
				dao.setConditionAlternateField1("=", bean.getAlternateField1());
			count++;
		}
		if(bean.getAlternateField2() != null) {
			if(bean.getAlternateField2().indexOf("%") >= 0)
				dao.setConditionAlternateField2("like", bean.getAlternateField2());
			else
				dao.setConditionAlternateField2("=", bean.getAlternateField2());
			count++;
		}
		if(bean.getAlternateField3() != null) {
			if(bean.getAlternateField3().indexOf("%") >= 0)
				dao.setConditionAlternateField3("like", bean.getAlternateField3());
			else
				dao.setConditionAlternateField3("=", bean.getAlternateField3());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getCost() != null) {
			dao.setConditionCost("=", bean.getCost());
			count++;
		}
		if(bean.getSettlement() != null) {
			dao.setConditionSettlement("=", bean.getSettlement());
			count++;
		}
		if(bean.getEmployeeAchieveIntegralReturn() != null) {
			dao.setConditionEmployeeAchieveIntegralReturn("=", bean.getEmployeeAchieveIntegralReturn());
			count++;
		}
		if(bean.getStageId() != null) {
			dao.setConditionStageId("=", bean.getStageId());
			count++;
		}
		if(bean.getFlag() != null) {
			dao.setConditionFlag("=", bean.getFlag());
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
		BaseProjectEmployee bean = new BaseProjectEmployee();
		bean.setDataFromJSON(json);
		ProjectEmployee dao = new ProjectEmployee();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectEmployee> rlist = new BaseCollection<>();
		BaseProjectEmployee bean = new BaseProjectEmployee();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectEmployee dao = new ProjectEmployee();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectEmployee> result = dao.conditionalLoad(addtion);
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
		BaseProjectEmployee bean = new BaseProjectEmployee();
		bean.setDataFromJSON(json);
		ProjectEmployee dao = new ProjectEmployee();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectEmployee bean = new BaseProjectEmployee();
		bean.setDataFromJSON(json);
		ProjectEmployee dao = new ProjectEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectEmployee bean = new BaseProjectEmployee();
		bean.setDataFromJSON(json);
		ProjectEmployee dao = new ProjectEmployee();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectEmployee bean = new BaseProjectEmployee();
		bean.setDataFromJSON(json);
		ProjectEmployee dao = new ProjectEmployee();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


