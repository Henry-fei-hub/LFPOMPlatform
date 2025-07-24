package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectPerformanceSettlement;
import com.pomplatform.db.dao.ProjectPerformanceSettlement;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectPerformanceSettlementHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectPerformanceSettlementHandler.class);

	public static BaseProjectPerformanceSettlement getProjectPerformanceSettlementById( 
		java.lang.Integer project_performance_settlement_id
	) throws Exception
	{
		ProjectPerformanceSettlement dao = new ProjectPerformanceSettlement();
		dao.setProjectPerformanceSettlementId(project_performance_settlement_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectPerformanceSettlementExists( com.pomplatform.db.bean.BaseProjectPerformanceSettlement bean, String additional ) throws Exception {

		ProjectPerformanceSettlement dao = new ProjectPerformanceSettlement();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectPerformanceSettlement( com.pomplatform.db.bean.BaseProjectPerformanceSettlement bean, String additional ) throws Exception {

		ProjectPerformanceSettlement dao = new ProjectPerformanceSettlement();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectPerformanceSettlement> queryProjectPerformanceSettlement( com.pomplatform.db.bean.BaseProjectPerformanceSettlement bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectPerformanceSettlement dao = new ProjectPerformanceSettlement();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectPerformanceSettlement> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectPerformanceSettlement> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectPerformanceSettlement addToProjectPerformanceSettlement ( BaseProjectPerformanceSettlement projectperformancesettlement )  throws Exception {
		return addToProjectPerformanceSettlement ( projectperformancesettlement , false);
	}

	public static BaseProjectPerformanceSettlement addToProjectPerformanceSettlement ( BaseProjectPerformanceSettlement projectperformancesettlement, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectPerformanceSettlement dao = new ProjectPerformanceSettlement();
		dao.setDataFromBase(projectperformancesettlement);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectPerformanceSettlement addUpdateProjectPerformanceSettlement ( BaseProjectPerformanceSettlement projectperformancesettlement ) throws Exception {
		return addUpdateProjectPerformanceSettlement ( projectperformancesettlement , false);
	}

	public static BaseProjectPerformanceSettlement addUpdateProjectPerformanceSettlement ( BaseProjectPerformanceSettlement projectperformancesettlement, boolean singleTransaction  ) throws Exception {
		if(projectperformancesettlement.getProjectPerformanceSettlementId() == null) return addToProjectPerformanceSettlement(projectperformancesettlement);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectPerformanceSettlement dao = new ProjectPerformanceSettlement();
		dao.setDataFromBase(projectperformancesettlement);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectperformancesettlement); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectPerformanceSettlement ( BaseProjectPerformanceSettlement bean ) throws Exception {
		ProjectPerformanceSettlement dao = new ProjectPerformanceSettlement();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectPerformanceSettlement updateProjectPerformanceSettlement ( BaseProjectPerformanceSettlement projectperformancesettlement ) throws Exception {
		ProjectPerformanceSettlement dao = new ProjectPerformanceSettlement();
		dao.setProjectPerformanceSettlementId( projectperformancesettlement.getProjectPerformanceSettlementId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectperformancesettlement);
			result = dao.update();
		}
		return result == 1 ? projectperformancesettlement : null ;
	}

	public static BaseProjectPerformanceSettlement updateProjectPerformanceSettlementDirect( BaseProjectPerformanceSettlement projectperformancesettlement ) throws Exception {
		ProjectPerformanceSettlement dao = new ProjectPerformanceSettlement();
		int result = 0;
		dao.setDataFromBase(projectperformancesettlement);
		result = dao.update();
		return result == 1 ? projectperformancesettlement : null ;
	}

	public static int setDeleteConditions(BaseProjectPerformanceSettlement bean, ProjectPerformanceSettlement dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectPerformanceSettlementId() != null) {
			dao.setConditionProjectPerformanceSettlementId("=", bean.getProjectPerformanceSettlementId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getPerformanceFlag() != null) {
				dao.setConditionPerformanceFlag("=", bean.getPerformanceFlag());
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

	public static int setConditions(BaseProjectPerformanceSettlement bean, ProjectPerformanceSettlement dao){
		int count = 0;
		if(bean.getProjectPerformanceSettlementId() != null) {
			dao.setConditionProjectPerformanceSettlementId("=", bean.getProjectPerformanceSettlementId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getPerformanceFlag() != null) {
			dao.setConditionPerformanceFlag("=", bean.getPerformanceFlag());
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
		BaseProjectPerformanceSettlement bean = new BaseProjectPerformanceSettlement();
		bean.setDataFromJSON(json);
		ProjectPerformanceSettlement dao = new ProjectPerformanceSettlement();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectPerformanceSettlement> rlist = new BaseCollection<>();
		BaseProjectPerformanceSettlement bean = new BaseProjectPerformanceSettlement();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectPerformanceSettlement dao = new ProjectPerformanceSettlement();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectPerformanceSettlement> result = dao.conditionalLoad(addtion);
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
		BaseProjectPerformanceSettlement bean = new BaseProjectPerformanceSettlement();
		bean.setDataFromJSON(json);
		ProjectPerformanceSettlement dao = new ProjectPerformanceSettlement();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectPerformanceSettlement bean = new BaseProjectPerformanceSettlement();
		bean.setDataFromJSON(json);
		ProjectPerformanceSettlement dao = new ProjectPerformanceSettlement();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectPerformanceSettlement bean = new BaseProjectPerformanceSettlement();
		bean.setDataFromJSON(json);
		ProjectPerformanceSettlement dao = new ProjectPerformanceSettlement();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectPerformanceSettlement bean = new BaseProjectPerformanceSettlement();
		bean.setDataFromJSON(json);
		ProjectPerformanceSettlement dao = new ProjectPerformanceSettlement();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


