package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectPerformance;
import com.pomplatform.db.dao.ProjectPerformance;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectPerformanceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectPerformanceHandler.class);

	public static BaseProjectPerformance getProjectPerformanceById( 
		java.lang.Integer project_performance_id
	) throws Exception
	{
		ProjectPerformance dao = new ProjectPerformance();
		dao.setProjectPerformanceId(project_performance_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectPerformanceExists( com.pomplatform.db.bean.BaseProjectPerformance bean, String additional ) throws Exception {

		ProjectPerformance dao = new ProjectPerformance();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectPerformance( com.pomplatform.db.bean.BaseProjectPerformance bean, String additional ) throws Exception {

		ProjectPerformance dao = new ProjectPerformance();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectPerformance> queryProjectPerformance( com.pomplatform.db.bean.BaseProjectPerformance bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectPerformance dao = new ProjectPerformance();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectPerformance> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectPerformance> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectPerformance addToProjectPerformance ( BaseProjectPerformance projectperformance )  throws Exception {
		return addToProjectPerformance ( projectperformance , false);
	}

	public static BaseProjectPerformance addToProjectPerformance ( BaseProjectPerformance projectperformance, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectPerformance dao = new ProjectPerformance();
		dao.setDataFromBase(projectperformance);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectPerformance addUpdateProjectPerformance ( BaseProjectPerformance projectperformance ) throws Exception {
		return addUpdateProjectPerformance ( projectperformance , false);
	}

	public static BaseProjectPerformance addUpdateProjectPerformance ( BaseProjectPerformance projectperformance, boolean singleTransaction  ) throws Exception {
		if(projectperformance.getProjectPerformanceId() == null) return addToProjectPerformance(projectperformance);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectPerformance dao = new ProjectPerformance();
		dao.setDataFromBase(projectperformance);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectperformance); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectPerformance ( BaseProjectPerformance bean ) throws Exception {
		ProjectPerformance dao = new ProjectPerformance();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectPerformance updateProjectPerformance ( BaseProjectPerformance projectperformance ) throws Exception {
		ProjectPerformance dao = new ProjectPerformance();
		dao.setProjectPerformanceId( projectperformance.getProjectPerformanceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectperformance);
			result = dao.update();
		}
		return result == 1 ? projectperformance : null ;
	}

	public static BaseProjectPerformance updateProjectPerformanceDirect( BaseProjectPerformance projectperformance ) throws Exception {
		ProjectPerformance dao = new ProjectPerformance();
		int result = 0;
		dao.setDataFromBase(projectperformance);
		result = dao.update();
		return result == 1 ? projectperformance : null ;
	}

	public static int setDeleteConditions(BaseProjectPerformance bean, ProjectPerformance dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectPerformanceId() != null) {
			dao.setConditionProjectPerformanceId("=", bean.getProjectPerformanceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
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
			if(bean.getClientComplaint() != null) {
				dao.setConditionClientComplaint("=", bean.getClientComplaint());
				count++;
			}
			if(bean.getReason() != null) {
				dao.setConditionReason("=", bean.getReason());
				count++;
			}
			if(bean.getIsSubmit() != null) {
				dao.setConditionIsSubmit("=", bean.getIsSubmit());
				count++;
			}
			if(bean.getPerformanceFlag() != null) {
				dao.setConditionPerformanceFlag("=", bean.getPerformanceFlag());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
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
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getIsSettlement() != null) {
				dao.setConditionIsSettlement("=", bean.getIsSettlement());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectPerformance bean, ProjectPerformance dao){
		int count = 0;
		if(bean.getProjectPerformanceId() != null) {
			dao.setConditionProjectPerformanceId("=", bean.getProjectPerformanceId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getIntegral() != null) {
			dao.setConditionIntegral("=", bean.getIntegral());
			count++;
		}
		if(bean.getPercent() != null) {
			dao.setConditionPercent("=", bean.getPercent());
			count++;
		}
		if(bean.getPerformanceIntegral() != null) {
			dao.setConditionPerformanceIntegral("=", bean.getPerformanceIntegral());
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
		if(bean.getClientComplaint() != null) {
			if(bean.getClientComplaint().indexOf("%") >= 0)
				dao.setConditionClientComplaint("like", bean.getClientComplaint());
			else
				dao.setConditionClientComplaint("=", bean.getClientComplaint());
			count++;
		}
		if(bean.getReason() != null) {
			if(bean.getReason().indexOf("%") >= 0)
				dao.setConditionReason("like", bean.getReason());
			else
				dao.setConditionReason("=", bean.getReason());
			count++;
		}
		if(bean.getIsSubmit() != null) {
			dao.setConditionIsSubmit("=", bean.getIsSubmit());
			count++;
		}
		if(bean.getPerformanceFlag() != null) {
			dao.setConditionPerformanceFlag("=", bean.getPerformanceFlag());
			count++;
		}
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
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
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getIsSettlement() != null) {
			dao.setConditionIsSettlement("=", bean.getIsSettlement());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectPerformance bean = new BaseProjectPerformance();
		bean.setDataFromJSON(json);
		ProjectPerformance dao = new ProjectPerformance();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectPerformance> rlist = new BaseCollection<>();
		BaseProjectPerformance bean = new BaseProjectPerformance();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectPerformance dao = new ProjectPerformance();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectPerformance> result = dao.conditionalLoad(addtion);
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
		BaseProjectPerformance bean = new BaseProjectPerformance();
		bean.setDataFromJSON(json);
		ProjectPerformance dao = new ProjectPerformance();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectPerformance bean = new BaseProjectPerformance();
		bean.setDataFromJSON(json);
		ProjectPerformance dao = new ProjectPerformance();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectPerformance bean = new BaseProjectPerformance();
		bean.setDataFromJSON(json);
		ProjectPerformance dao = new ProjectPerformance();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectPerformance bean = new BaseProjectPerformance();
		bean.setDataFromJSON(json);
		ProjectPerformance dao = new ProjectPerformance();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


