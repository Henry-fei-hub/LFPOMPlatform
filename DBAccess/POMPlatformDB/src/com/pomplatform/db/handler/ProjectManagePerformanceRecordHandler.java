package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectManagePerformanceRecord;
import com.pomplatform.db.dao.ProjectManagePerformanceRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectManagePerformanceRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectManagePerformanceRecordHandler.class);

	public static BaseProjectManagePerformanceRecord getProjectManagePerformanceRecordById( 
		java.lang.Integer project_manage_performance_record_id
	) throws Exception
	{
		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
		dao.setProjectManagePerformanceRecordId(project_manage_performance_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectManagePerformanceRecordExists( com.pomplatform.db.bean.BaseProjectManagePerformanceRecord bean, String additional ) throws Exception {

		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectManagePerformanceRecord( com.pomplatform.db.bean.BaseProjectManagePerformanceRecord bean, String additional ) throws Exception {

		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectManagePerformanceRecord> queryProjectManagePerformanceRecord( com.pomplatform.db.bean.BaseProjectManagePerformanceRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectManagePerformanceRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectManagePerformanceRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectManagePerformanceRecord addToProjectManagePerformanceRecord ( BaseProjectManagePerformanceRecord projectmanageperformancerecord )  throws Exception {
		return addToProjectManagePerformanceRecord ( projectmanageperformancerecord , false);
	}

	public static BaseProjectManagePerformanceRecord addToProjectManagePerformanceRecord ( BaseProjectManagePerformanceRecord projectmanageperformancerecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
		dao.setDataFromBase(projectmanageperformancerecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectManagePerformanceRecord addUpdateProjectManagePerformanceRecord ( BaseProjectManagePerformanceRecord projectmanageperformancerecord ) throws Exception {
		return addUpdateProjectManagePerformanceRecord ( projectmanageperformancerecord , false);
	}

	public static BaseProjectManagePerformanceRecord addUpdateProjectManagePerformanceRecord ( BaseProjectManagePerformanceRecord projectmanageperformancerecord, boolean singleTransaction  ) throws Exception {
		if(projectmanageperformancerecord.getProjectManagePerformanceRecordId() == null) return addToProjectManagePerformanceRecord(projectmanageperformancerecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
		dao.setDataFromBase(projectmanageperformancerecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectmanageperformancerecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectManagePerformanceRecord ( BaseProjectManagePerformanceRecord bean ) throws Exception {
		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectManagePerformanceRecord updateProjectManagePerformanceRecord ( BaseProjectManagePerformanceRecord projectmanageperformancerecord ) throws Exception {
		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
		dao.setProjectManagePerformanceRecordId( projectmanageperformancerecord.getProjectManagePerformanceRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectmanageperformancerecord);
			result = dao.update();
		}
		return result == 1 ? projectmanageperformancerecord : null ;
	}

	public static BaseProjectManagePerformanceRecord updateProjectManagePerformanceRecordDirect( BaseProjectManagePerformanceRecord projectmanageperformancerecord ) throws Exception {
		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
		int result = 0;
		dao.setDataFromBase(projectmanageperformancerecord);
		result = dao.update();
		return result == 1 ? projectmanageperformancerecord : null ;
	}

	public static int setDeleteConditions(BaseProjectManagePerformanceRecord bean, ProjectManagePerformanceRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectManagePerformanceRecordId() != null) {
			dao.setConditionProjectManagePerformanceRecordId("=", bean.getProjectManagePerformanceRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectManagePerformanceTotalId() != null) {
				dao.setConditionProjectManagePerformanceTotalId("=", bean.getProjectManagePerformanceTotalId());
				count++;
			}
			if(bean.getObjectId() != null) {
				dao.setConditionObjectId("=", bean.getObjectId());
				count++;
			}
			if(bean.getObjectNo() != null) {
				dao.setConditionObjectNo("=", bean.getObjectNo());
				count++;
			}
			if(bean.getObjectName() != null) {
				dao.setConditionObjectName("=", bean.getObjectName());
				count++;
			}
			if(bean.getObjectType() != null) {
				dao.setConditionObjectType("=", bean.getObjectType());
				count++;
			}
			if(bean.getPerformanceStatus() != null) {
				dao.setConditionPerformanceStatus("=", bean.getPerformanceStatus());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getBusinessName() != null) {
				dao.setConditionBusinessName("=", bean.getBusinessName());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectManagePerformanceRecord bean, ProjectManagePerformanceRecord dao){
		int count = 0;
		if(bean.getProjectManagePerformanceRecordId() != null) {
			dao.setConditionProjectManagePerformanceRecordId("=", bean.getProjectManagePerformanceRecordId());
			count++;
		}
		if(bean.getProjectManagePerformanceTotalId() != null) {
			dao.setConditionProjectManagePerformanceTotalId("=", bean.getProjectManagePerformanceTotalId());
			count++;
		}
		if(bean.getObjectId() != null) {
			dao.setConditionObjectId("=", bean.getObjectId());
			count++;
		}
		if(bean.getObjectNo() != null) {
			if(bean.getObjectNo().indexOf("%") >= 0)
				dao.setConditionObjectNo("like", bean.getObjectNo());
			else
				dao.setConditionObjectNo("=", bean.getObjectNo());
			count++;
		}
		if(bean.getObjectName() != null) {
			if(bean.getObjectName().indexOf("%") >= 0)
				dao.setConditionObjectName("like", bean.getObjectName());
			else
				dao.setConditionObjectName("=", bean.getObjectName());
			count++;
		}
		if(bean.getObjectType() != null) {
			dao.setConditionObjectType("=", bean.getObjectType());
			count++;
		}
		if(bean.getPerformanceMoney() != null) {
			dao.setConditionPerformanceMoney("=", bean.getPerformanceMoney());
			count++;
		}
		if(bean.getPerformanceStatus() != null) {
			dao.setConditionPerformanceStatus("=", bean.getPerformanceStatus());
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
		BaseProjectManagePerformanceRecord bean = new BaseProjectManagePerformanceRecord();
		bean.setDataFromJSON(json);
		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectManagePerformanceRecord> rlist = new BaseCollection<>();
		BaseProjectManagePerformanceRecord bean = new BaseProjectManagePerformanceRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectManagePerformanceRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectManagePerformanceRecord bean = new BaseProjectManagePerformanceRecord();
		bean.setDataFromJSON(json);
		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectManagePerformanceRecord bean = new BaseProjectManagePerformanceRecord();
		bean.setDataFromJSON(json);
		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectManagePerformanceRecord bean = new BaseProjectManagePerformanceRecord();
		bean.setDataFromJSON(json);
		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectManagePerformanceRecord bean = new BaseProjectManagePerformanceRecord();
		bean.setDataFromJSON(json);
		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


