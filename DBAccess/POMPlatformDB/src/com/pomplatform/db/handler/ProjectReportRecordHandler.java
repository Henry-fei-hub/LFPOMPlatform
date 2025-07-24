package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectReportRecord;
import com.pomplatform.db.dao.ProjectReportRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectReportRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectReportRecordHandler.class);

	public static BaseProjectReportRecord getProjectReportRecordById( 
		java.lang.Integer project_report_record_id
	) throws Exception
	{
		ProjectReportRecord dao = new ProjectReportRecord();
		dao.setProjectReportRecordId(project_report_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectReportRecordExists( com.pomplatform.db.bean.BaseProjectReportRecord bean, String additional ) throws Exception {

		ProjectReportRecord dao = new ProjectReportRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectReportRecord( com.pomplatform.db.bean.BaseProjectReportRecord bean, String additional ) throws Exception {

		ProjectReportRecord dao = new ProjectReportRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectReportRecord> queryProjectReportRecord( com.pomplatform.db.bean.BaseProjectReportRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectReportRecord dao = new ProjectReportRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectReportRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectReportRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectReportRecord addToProjectReportRecord ( BaseProjectReportRecord projectreportrecord )  throws Exception {
		return addToProjectReportRecord ( projectreportrecord , false);
	}

	public static BaseProjectReportRecord addToProjectReportRecord ( BaseProjectReportRecord projectreportrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectReportRecord dao = new ProjectReportRecord();
		dao.setDataFromBase(projectreportrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectReportRecord addUpdateProjectReportRecord ( BaseProjectReportRecord projectreportrecord ) throws Exception {
		return addUpdateProjectReportRecord ( projectreportrecord , false);
	}

	public static BaseProjectReportRecord addUpdateProjectReportRecord ( BaseProjectReportRecord projectreportrecord, boolean singleTransaction  ) throws Exception {
		if(projectreportrecord.getProjectReportRecordId() == null) return addToProjectReportRecord(projectreportrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectReportRecord dao = new ProjectReportRecord();
		dao.setDataFromBase(projectreportrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectreportrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectReportRecord ( BaseProjectReportRecord bean ) throws Exception {
		ProjectReportRecord dao = new ProjectReportRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectReportRecord updateProjectReportRecord ( BaseProjectReportRecord projectreportrecord ) throws Exception {
		ProjectReportRecord dao = new ProjectReportRecord();
		dao.setProjectReportRecordId( projectreportrecord.getProjectReportRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectreportrecord);
			result = dao.update();
		}
		return result == 1 ? projectreportrecord : null ;
	}

	public static BaseProjectReportRecord updateProjectReportRecordDirect( BaseProjectReportRecord projectreportrecord ) throws Exception {
		ProjectReportRecord dao = new ProjectReportRecord();
		int result = 0;
		dao.setDataFromBase(projectreportrecord);
		result = dao.update();
		return result == 1 ? projectreportrecord : null ;
	}

	public static int setDeleteConditions(BaseProjectReportRecord bean, ProjectReportRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectReportRecordId() != null) {
			dao.setConditionProjectReportRecordId("=", bean.getProjectReportRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getIsLock() != null) {
				dao.setConditionIsLock("=", bean.getIsLock());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectReportRecord bean, ProjectReportRecord dao){
		int count = 0;
		if(bean.getProjectReportRecordId() != null) {
			dao.setConditionProjectReportRecordId("=", bean.getProjectReportRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getSubtractComplaintIntegral() != null) {
			dao.setConditionSubtractComplaintIntegral("=", bean.getSubtractComplaintIntegral());
			count++;
		}
		if(bean.getSureIntegral() != null) {
			dao.setConditionSureIntegral("=", bean.getSureIntegral());
			count++;
		}
		if(bean.getProjectCost() != null) {
			dao.setConditionProjectCost("=", bean.getProjectCost());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getIsLock() != null) {
			dao.setConditionIsLock("=", bean.getIsLock());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectReportRecord bean = new BaseProjectReportRecord();
		bean.setDataFromJSON(json);
		ProjectReportRecord dao = new ProjectReportRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectReportRecord> rlist = new BaseCollection<>();
		BaseProjectReportRecord bean = new BaseProjectReportRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectReportRecord dao = new ProjectReportRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectReportRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectReportRecord bean = new BaseProjectReportRecord();
		bean.setDataFromJSON(json);
		ProjectReportRecord dao = new ProjectReportRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectReportRecord bean = new BaseProjectReportRecord();
		bean.setDataFromJSON(json);
		ProjectReportRecord dao = new ProjectReportRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectReportRecord bean = new BaseProjectReportRecord();
		bean.setDataFromJSON(json);
		ProjectReportRecord dao = new ProjectReportRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectReportRecord bean = new BaseProjectReportRecord();
		bean.setDataFromJSON(json);
		ProjectReportRecord dao = new ProjectReportRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


