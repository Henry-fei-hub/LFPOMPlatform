package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectSettlementPerformance;
import com.pomplatform.db.dao.ProjectSettlementPerformance;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectSettlementPerformanceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectSettlementPerformanceHandler.class);

	public static BaseProjectSettlementPerformance getProjectSettlementPerformanceById( 
		java.lang.Integer project_settlement_performance_id
	) throws Exception
	{
		ProjectSettlementPerformance dao = new ProjectSettlementPerformance();
		dao.setProjectSettlementPerformanceId(project_settlement_performance_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectSettlementPerformanceExists( com.pomplatform.db.bean.BaseProjectSettlementPerformance bean, String additional ) throws Exception {

		ProjectSettlementPerformance dao = new ProjectSettlementPerformance();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectSettlementPerformance( com.pomplatform.db.bean.BaseProjectSettlementPerformance bean, String additional ) throws Exception {

		ProjectSettlementPerformance dao = new ProjectSettlementPerformance();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectSettlementPerformance> queryProjectSettlementPerformance( com.pomplatform.db.bean.BaseProjectSettlementPerformance bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectSettlementPerformance dao = new ProjectSettlementPerformance();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectSettlementPerformance> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectSettlementPerformance> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectSettlementPerformance addToProjectSettlementPerformance ( BaseProjectSettlementPerformance projectsettlementperformance )  throws Exception {
		return addToProjectSettlementPerformance ( projectsettlementperformance , false);
	}

	public static BaseProjectSettlementPerformance addToProjectSettlementPerformance ( BaseProjectSettlementPerformance projectsettlementperformance, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectSettlementPerformance dao = new ProjectSettlementPerformance();
		dao.setDataFromBase(projectsettlementperformance);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectSettlementPerformance addUpdateProjectSettlementPerformance ( BaseProjectSettlementPerformance projectsettlementperformance ) throws Exception {
		return addUpdateProjectSettlementPerformance ( projectsettlementperformance , false);
	}

	public static BaseProjectSettlementPerformance addUpdateProjectSettlementPerformance ( BaseProjectSettlementPerformance projectsettlementperformance, boolean singleTransaction  ) throws Exception {
		if(projectsettlementperformance.getProjectSettlementPerformanceId() == null) return addToProjectSettlementPerformance(projectsettlementperformance);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectSettlementPerformance dao = new ProjectSettlementPerformance();
		dao.setDataFromBase(projectsettlementperformance);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectsettlementperformance); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectSettlementPerformance ( BaseProjectSettlementPerformance bean ) throws Exception {
		ProjectSettlementPerformance dao = new ProjectSettlementPerformance();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectSettlementPerformance updateProjectSettlementPerformance ( BaseProjectSettlementPerformance projectsettlementperformance ) throws Exception {
		ProjectSettlementPerformance dao = new ProjectSettlementPerformance();
		dao.setProjectSettlementPerformanceId( projectsettlementperformance.getProjectSettlementPerformanceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectsettlementperformance);
			result = dao.update();
		}
		return result == 1 ? projectsettlementperformance : null ;
	}

	public static BaseProjectSettlementPerformance updateProjectSettlementPerformanceDirect( BaseProjectSettlementPerformance projectsettlementperformance ) throws Exception {
		ProjectSettlementPerformance dao = new ProjectSettlementPerformance();
		int result = 0;
		dao.setDataFromBase(projectsettlementperformance);
		result = dao.update();
		return result == 1 ? projectsettlementperformance : null ;
	}

	public static int setDeleteConditions(BaseProjectSettlementPerformance bean, ProjectSettlementPerformance dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectSettlementPerformanceId() != null) {
			dao.setConditionProjectSettlementPerformanceId("=", bean.getProjectSettlementPerformanceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSettlementId() != null) {
				dao.setConditionSettlementId("=", bean.getSettlementId());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getStageId() != null) {
				dao.setConditionStageId("=", bean.getStageId());
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

	public static int setConditions(BaseProjectSettlementPerformance bean, ProjectSettlementPerformance dao){
		int count = 0;
		if(bean.getProjectSettlementPerformanceId() != null) {
			dao.setConditionProjectSettlementPerformanceId("=", bean.getProjectSettlementPerformanceId());
			count++;
		}
		if(bean.getSettlementId() != null) {
			dao.setConditionSettlementId("=", bean.getSettlementId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getStageId() != null) {
			dao.setConditionStageId("=", bean.getStageId());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getIntegral() != null) {
			dao.setConditionIntegral("=", bean.getIntegral());
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
		BaseProjectSettlementPerformance bean = new BaseProjectSettlementPerformance();
		bean.setDataFromJSON(json);
		ProjectSettlementPerformance dao = new ProjectSettlementPerformance();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectSettlementPerformance> rlist = new BaseCollection<>();
		BaseProjectSettlementPerformance bean = new BaseProjectSettlementPerformance();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectSettlementPerformance dao = new ProjectSettlementPerformance();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectSettlementPerformance> result = dao.conditionalLoad(addtion);
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
		BaseProjectSettlementPerformance bean = new BaseProjectSettlementPerformance();
		bean.setDataFromJSON(json);
		ProjectSettlementPerformance dao = new ProjectSettlementPerformance();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectSettlementPerformance bean = new BaseProjectSettlementPerformance();
		bean.setDataFromJSON(json);
		ProjectSettlementPerformance dao = new ProjectSettlementPerformance();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectSettlementPerformance bean = new BaseProjectSettlementPerformance();
		bean.setDataFromJSON(json);
		ProjectSettlementPerformance dao = new ProjectSettlementPerformance();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectSettlementPerformance bean = new BaseProjectSettlementPerformance();
		bean.setDataFromJSON(json);
		ProjectSettlementPerformance dao = new ProjectSettlementPerformance();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


