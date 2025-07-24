package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectEmployeeAuditRecord;
import com.pomplatform.db.dao.ProjectEmployeeAuditRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectEmployeeAuditRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectEmployeeAuditRecordHandler.class);

	public static BaseProjectEmployeeAuditRecord getProjectEmployeeAuditRecordById( 
		java.lang.Integer project_employee_audit_records_id
	) throws Exception
	{
		ProjectEmployeeAuditRecord dao = new ProjectEmployeeAuditRecord();
		dao.setProjectEmployeeAuditRecordsId(project_employee_audit_records_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectEmployeeAuditRecordExists( com.pomplatform.db.bean.BaseProjectEmployeeAuditRecord bean, String additional ) throws Exception {

		ProjectEmployeeAuditRecord dao = new ProjectEmployeeAuditRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectEmployeeAuditRecord( com.pomplatform.db.bean.BaseProjectEmployeeAuditRecord bean, String additional ) throws Exception {

		ProjectEmployeeAuditRecord dao = new ProjectEmployeeAuditRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectEmployeeAuditRecord> queryProjectEmployeeAuditRecord( com.pomplatform.db.bean.BaseProjectEmployeeAuditRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectEmployeeAuditRecord dao = new ProjectEmployeeAuditRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectEmployeeAuditRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectEmployeeAuditRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectEmployeeAuditRecord addToProjectEmployeeAuditRecord ( BaseProjectEmployeeAuditRecord projectemployeeauditrecord )  throws Exception {
		return addToProjectEmployeeAuditRecord ( projectemployeeauditrecord , false);
	}

	public static BaseProjectEmployeeAuditRecord addToProjectEmployeeAuditRecord ( BaseProjectEmployeeAuditRecord projectemployeeauditrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectEmployeeAuditRecord dao = new ProjectEmployeeAuditRecord();
		dao.setDataFromBase(projectemployeeauditrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectEmployeeAuditRecord addUpdateProjectEmployeeAuditRecord ( BaseProjectEmployeeAuditRecord projectemployeeauditrecord ) throws Exception {
		return addUpdateProjectEmployeeAuditRecord ( projectemployeeauditrecord , false);
	}

	public static BaseProjectEmployeeAuditRecord addUpdateProjectEmployeeAuditRecord ( BaseProjectEmployeeAuditRecord projectemployeeauditrecord, boolean singleTransaction  ) throws Exception {
		if(projectemployeeauditrecord.getProjectEmployeeAuditRecordsId() == null) return addToProjectEmployeeAuditRecord(projectemployeeauditrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectEmployeeAuditRecord dao = new ProjectEmployeeAuditRecord();
		dao.setDataFromBase(projectemployeeauditrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectemployeeauditrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectEmployeeAuditRecord ( BaseProjectEmployeeAuditRecord bean ) throws Exception {
		ProjectEmployeeAuditRecord dao = new ProjectEmployeeAuditRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectEmployeeAuditRecord updateProjectEmployeeAuditRecord ( BaseProjectEmployeeAuditRecord projectemployeeauditrecord ) throws Exception {
		ProjectEmployeeAuditRecord dao = new ProjectEmployeeAuditRecord();
		dao.setProjectEmployeeAuditRecordsId( projectemployeeauditrecord.getProjectEmployeeAuditRecordsId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectemployeeauditrecord);
			result = dao.update();
		}
		return result == 1 ? projectemployeeauditrecord : null ;
	}

	public static BaseProjectEmployeeAuditRecord updateProjectEmployeeAuditRecordDirect( BaseProjectEmployeeAuditRecord projectemployeeauditrecord ) throws Exception {
		ProjectEmployeeAuditRecord dao = new ProjectEmployeeAuditRecord();
		int result = 0;
		dao.setDataFromBase(projectemployeeauditrecord);
		result = dao.update();
		return result == 1 ? projectemployeeauditrecord : null ;
	}

	public static int setDeleteConditions(BaseProjectEmployeeAuditRecord bean, ProjectEmployeeAuditRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectEmployeeAuditRecordsId() != null) {
			dao.setConditionProjectEmployeeAuditRecordsId("=", bean.getProjectEmployeeAuditRecordsId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getStageId() != null) {
				dao.setConditionStageId("=", bean.getStageId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getCheckEmployeeId() != null) {
				dao.setConditionCheckEmployeeId("=", bean.getCheckEmployeeId());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
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
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectEmployeeAuditRecord bean, ProjectEmployeeAuditRecord dao){
		int count = 0;
		if(bean.getProjectEmployeeAuditRecordsId() != null) {
			dao.setConditionProjectEmployeeAuditRecordsId("=", bean.getProjectEmployeeAuditRecordsId());
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
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getCheckEmployeeId() != null) {
			dao.setConditionCheckEmployeeId("=", bean.getCheckEmployeeId());
			count++;
		}
		if(bean.getPlanIntegral() != null) {
			dao.setConditionPlanIntegral("=", bean.getPlanIntegral());
			count++;
		}
		if(bean.getOldPlanIntegral() != null) {
			dao.setConditionOldPlanIntegral("=", bean.getOldPlanIntegral());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
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
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectEmployeeAuditRecord bean = new BaseProjectEmployeeAuditRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeAuditRecord dao = new ProjectEmployeeAuditRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectEmployeeAuditRecord> rlist = new BaseCollection<>();
		BaseProjectEmployeeAuditRecord bean = new BaseProjectEmployeeAuditRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectEmployeeAuditRecord dao = new ProjectEmployeeAuditRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectEmployeeAuditRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectEmployeeAuditRecord bean = new BaseProjectEmployeeAuditRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeAuditRecord dao = new ProjectEmployeeAuditRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectEmployeeAuditRecord bean = new BaseProjectEmployeeAuditRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeAuditRecord dao = new ProjectEmployeeAuditRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectEmployeeAuditRecord bean = new BaseProjectEmployeeAuditRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeAuditRecord dao = new ProjectEmployeeAuditRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectEmployeeAuditRecord bean = new BaseProjectEmployeeAuditRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeAuditRecord dao = new ProjectEmployeeAuditRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


