package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectManagePerformanceTotal;
import com.pomplatform.db.dao.ProjectManagePerformanceTotal;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectManagePerformanceTotalHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectManagePerformanceTotalHandler.class);

	public static BaseProjectManagePerformanceTotal getProjectManagePerformanceTotalById( 
		java.lang.Integer project_manage_performance_total_id
	) throws Exception
	{
		ProjectManagePerformanceTotal dao = new ProjectManagePerformanceTotal();
		dao.setProjectManagePerformanceTotalId(project_manage_performance_total_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectManagePerformanceTotalExists( com.pomplatform.db.bean.BaseProjectManagePerformanceTotal bean, String additional ) throws Exception {

		ProjectManagePerformanceTotal dao = new ProjectManagePerformanceTotal();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectManagePerformanceTotal( com.pomplatform.db.bean.BaseProjectManagePerformanceTotal bean, String additional ) throws Exception {

		ProjectManagePerformanceTotal dao = new ProjectManagePerformanceTotal();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectManagePerformanceTotal> queryProjectManagePerformanceTotal( com.pomplatform.db.bean.BaseProjectManagePerformanceTotal bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectManagePerformanceTotal dao = new ProjectManagePerformanceTotal();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectManagePerformanceTotal> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectManagePerformanceTotal> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectManagePerformanceTotal addToProjectManagePerformanceTotal ( BaseProjectManagePerformanceTotal projectmanageperformancetotal )  throws Exception {
		return addToProjectManagePerformanceTotal ( projectmanageperformancetotal , false);
	}

	public static BaseProjectManagePerformanceTotal addToProjectManagePerformanceTotal ( BaseProjectManagePerformanceTotal projectmanageperformancetotal, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectManagePerformanceTotal dao = new ProjectManagePerformanceTotal();
		dao.setDataFromBase(projectmanageperformancetotal);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectManagePerformanceTotal addUpdateProjectManagePerformanceTotal ( BaseProjectManagePerformanceTotal projectmanageperformancetotal ) throws Exception {
		return addUpdateProjectManagePerformanceTotal ( projectmanageperformancetotal , false);
	}

	public static BaseProjectManagePerformanceTotal addUpdateProjectManagePerformanceTotal ( BaseProjectManagePerformanceTotal projectmanageperformancetotal, boolean singleTransaction  ) throws Exception {
		if(projectmanageperformancetotal.getProjectManagePerformanceTotalId() == null) return addToProjectManagePerformanceTotal(projectmanageperformancetotal);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectManagePerformanceTotal dao = new ProjectManagePerformanceTotal();
		dao.setDataFromBase(projectmanageperformancetotal);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectmanageperformancetotal); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectManagePerformanceTotal ( BaseProjectManagePerformanceTotal bean ) throws Exception {
		ProjectManagePerformanceTotal dao = new ProjectManagePerformanceTotal();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectManagePerformanceTotal updateProjectManagePerformanceTotal ( BaseProjectManagePerformanceTotal projectmanageperformancetotal ) throws Exception {
		ProjectManagePerformanceTotal dao = new ProjectManagePerformanceTotal();
		dao.setProjectManagePerformanceTotalId( projectmanageperformancetotal.getProjectManagePerformanceTotalId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectmanageperformancetotal);
			result = dao.update();
		}
		return result == 1 ? projectmanageperformancetotal : null ;
	}

	public static BaseProjectManagePerformanceTotal updateProjectManagePerformanceTotalDirect( BaseProjectManagePerformanceTotal projectmanageperformancetotal ) throws Exception {
		ProjectManagePerformanceTotal dao = new ProjectManagePerformanceTotal();
		int result = 0;
		dao.setDataFromBase(projectmanageperformancetotal);
		result = dao.update();
		return result == 1 ? projectmanageperformancetotal : null ;
	}

	public static int setDeleteConditions(BaseProjectManagePerformanceTotal bean, ProjectManagePerformanceTotal dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectManagePerformanceTotalId() != null) {
			dao.setConditionProjectManagePerformanceTotalId("=", bean.getProjectManagePerformanceTotalId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getBusinessName() != null) {
				dao.setConditionBusinessName("=", bean.getBusinessName());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
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
		}
		return count;
	}

	public static int setConditions(BaseProjectManagePerformanceTotal bean, ProjectManagePerformanceTotal dao){
		int count = 0;
		if(bean.getProjectManagePerformanceTotalId() != null) {
			dao.setConditionProjectManagePerformanceTotalId("=", bean.getProjectManagePerformanceTotalId());
			count++;
		}
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getBusinessName() != null) {
			if(bean.getBusinessName().indexOf("%") >= 0)
				dao.setConditionBusinessName("like", bean.getBusinessName());
			else
				dao.setConditionBusinessName("=", bean.getBusinessName());
			count++;
		}
		if(bean.getPerformanceMoney() != null) {
			dao.setConditionPerformanceMoney("=", bean.getPerformanceMoney());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
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
		BaseProjectManagePerformanceTotal bean = new BaseProjectManagePerformanceTotal();
		bean.setDataFromJSON(json);
		ProjectManagePerformanceTotal dao = new ProjectManagePerformanceTotal();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectManagePerformanceTotal> rlist = new BaseCollection<>();
		BaseProjectManagePerformanceTotal bean = new BaseProjectManagePerformanceTotal();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectManagePerformanceTotal dao = new ProjectManagePerformanceTotal();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectManagePerformanceTotal> result = dao.conditionalLoad(addtion);
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
		BaseProjectManagePerformanceTotal bean = new BaseProjectManagePerformanceTotal();
		bean.setDataFromJSON(json);
		ProjectManagePerformanceTotal dao = new ProjectManagePerformanceTotal();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectManagePerformanceTotal bean = new BaseProjectManagePerformanceTotal();
		bean.setDataFromJSON(json);
		ProjectManagePerformanceTotal dao = new ProjectManagePerformanceTotal();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectManagePerformanceTotal bean = new BaseProjectManagePerformanceTotal();
		bean.setDataFromJSON(json);
		ProjectManagePerformanceTotal dao = new ProjectManagePerformanceTotal();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectManagePerformanceTotal bean = new BaseProjectManagePerformanceTotal();
		bean.setDataFromJSON(json);
		ProjectManagePerformanceTotal dao = new ProjectManagePerformanceTotal();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


