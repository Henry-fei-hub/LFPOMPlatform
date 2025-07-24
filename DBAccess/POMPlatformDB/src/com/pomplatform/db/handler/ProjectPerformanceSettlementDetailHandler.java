package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectPerformanceSettlementDetail;
import com.pomplatform.db.dao.ProjectPerformanceSettlementDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectPerformanceSettlementDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectPerformanceSettlementDetailHandler.class);

	public static BaseProjectPerformanceSettlementDetail getProjectPerformanceSettlementDetailById( 
		java.lang.Integer project_performance_settlement_detail_id
	) throws Exception
	{
		ProjectPerformanceSettlementDetail dao = new ProjectPerformanceSettlementDetail();
		dao.setProjectPerformanceSettlementDetailId(project_performance_settlement_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectPerformanceSettlementDetailExists( com.pomplatform.db.bean.BaseProjectPerformanceSettlementDetail bean, String additional ) throws Exception {

		ProjectPerformanceSettlementDetail dao = new ProjectPerformanceSettlementDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectPerformanceSettlementDetail( com.pomplatform.db.bean.BaseProjectPerformanceSettlementDetail bean, String additional ) throws Exception {

		ProjectPerformanceSettlementDetail dao = new ProjectPerformanceSettlementDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectPerformanceSettlementDetail> queryProjectPerformanceSettlementDetail( com.pomplatform.db.bean.BaseProjectPerformanceSettlementDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectPerformanceSettlementDetail dao = new ProjectPerformanceSettlementDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectPerformanceSettlementDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectPerformanceSettlementDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectPerformanceSettlementDetail addToProjectPerformanceSettlementDetail ( BaseProjectPerformanceSettlementDetail projectperformancesettlementdetail )  throws Exception {
		return addToProjectPerformanceSettlementDetail ( projectperformancesettlementdetail , false);
	}

	public static BaseProjectPerformanceSettlementDetail addToProjectPerformanceSettlementDetail ( BaseProjectPerformanceSettlementDetail projectperformancesettlementdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectPerformanceSettlementDetail dao = new ProjectPerformanceSettlementDetail();
		dao.setDataFromBase(projectperformancesettlementdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectPerformanceSettlementDetail addUpdateProjectPerformanceSettlementDetail ( BaseProjectPerformanceSettlementDetail projectperformancesettlementdetail ) throws Exception {
		return addUpdateProjectPerformanceSettlementDetail ( projectperformancesettlementdetail , false);
	}

	public static BaseProjectPerformanceSettlementDetail addUpdateProjectPerformanceSettlementDetail ( BaseProjectPerformanceSettlementDetail projectperformancesettlementdetail, boolean singleTransaction  ) throws Exception {
		if(projectperformancesettlementdetail.getProjectPerformanceSettlementDetailId() == null) return addToProjectPerformanceSettlementDetail(projectperformancesettlementdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectPerformanceSettlementDetail dao = new ProjectPerformanceSettlementDetail();
		dao.setDataFromBase(projectperformancesettlementdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectperformancesettlementdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectPerformanceSettlementDetail ( BaseProjectPerformanceSettlementDetail bean ) throws Exception {
		ProjectPerformanceSettlementDetail dao = new ProjectPerformanceSettlementDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectPerformanceSettlementDetail updateProjectPerformanceSettlementDetail ( BaseProjectPerformanceSettlementDetail projectperformancesettlementdetail ) throws Exception {
		ProjectPerformanceSettlementDetail dao = new ProjectPerformanceSettlementDetail();
		dao.setProjectPerformanceSettlementDetailId( projectperformancesettlementdetail.getProjectPerformanceSettlementDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectperformancesettlementdetail);
			result = dao.update();
		}
		return result == 1 ? projectperformancesettlementdetail : null ;
	}

	public static BaseProjectPerformanceSettlementDetail updateProjectPerformanceSettlementDetailDirect( BaseProjectPerformanceSettlementDetail projectperformancesettlementdetail ) throws Exception {
		ProjectPerformanceSettlementDetail dao = new ProjectPerformanceSettlementDetail();
		int result = 0;
		dao.setDataFromBase(projectperformancesettlementdetail);
		result = dao.update();
		return result == 1 ? projectperformancesettlementdetail : null ;
	}

	public static int setDeleteConditions(BaseProjectPerformanceSettlementDetail bean, ProjectPerformanceSettlementDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectPerformanceSettlementDetailId() != null) {
			dao.setConditionProjectPerformanceSettlementDetailId("=", bean.getProjectPerformanceSettlementDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectPerformanceSettlementId() != null) {
				dao.setConditionProjectPerformanceSettlementId("=", bean.getProjectPerformanceSettlementId());
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

	public static int setConditions(BaseProjectPerformanceSettlementDetail bean, ProjectPerformanceSettlementDetail dao){
		int count = 0;
		if(bean.getProjectPerformanceSettlementDetailId() != null) {
			dao.setConditionProjectPerformanceSettlementDetailId("=", bean.getProjectPerformanceSettlementDetailId());
			count++;
		}
		if(bean.getProjectPerformanceSettlementId() != null) {
			dao.setConditionProjectPerformanceSettlementId("=", bean.getProjectPerformanceSettlementId());
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
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getIntegral() != null) {
			dao.setConditionIntegral("=", bean.getIntegral());
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
		BaseProjectPerformanceSettlementDetail bean = new BaseProjectPerformanceSettlementDetail();
		bean.setDataFromJSON(json);
		ProjectPerformanceSettlementDetail dao = new ProjectPerformanceSettlementDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectPerformanceSettlementDetail> rlist = new BaseCollection<>();
		BaseProjectPerformanceSettlementDetail bean = new BaseProjectPerformanceSettlementDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectPerformanceSettlementDetail dao = new ProjectPerformanceSettlementDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectPerformanceSettlementDetail> result = dao.conditionalLoad(addtion);
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
		BaseProjectPerformanceSettlementDetail bean = new BaseProjectPerformanceSettlementDetail();
		bean.setDataFromJSON(json);
		ProjectPerformanceSettlementDetail dao = new ProjectPerformanceSettlementDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectPerformanceSettlementDetail bean = new BaseProjectPerformanceSettlementDetail();
		bean.setDataFromJSON(json);
		ProjectPerformanceSettlementDetail dao = new ProjectPerformanceSettlementDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectPerformanceSettlementDetail bean = new BaseProjectPerformanceSettlementDetail();
		bean.setDataFromJSON(json);
		ProjectPerformanceSettlementDetail dao = new ProjectPerformanceSettlementDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectPerformanceSettlementDetail bean = new BaseProjectPerformanceSettlementDetail();
		bean.setDataFromJSON(json);
		ProjectPerformanceSettlementDetail dao = new ProjectPerformanceSettlementDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


