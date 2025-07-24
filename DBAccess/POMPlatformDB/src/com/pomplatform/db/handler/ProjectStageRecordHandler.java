package com.pomplatform.db.handler;

import java.util.List;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectStageRecord;
import com.pomplatform.db.dao.ProjectStageRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;

public class ProjectStageRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectStageRecordHandler.class);

	public static BaseProjectStageRecord getProjectStageRecordById( 
		java.lang.Integer project_stage_record_id
	) throws Exception
	{
		ProjectStageRecord dao = new ProjectStageRecord();
		dao.setProjectStageRecordId(project_stage_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectStageRecordExists( com.pomplatform.db.bean.BaseProjectStageRecord bean, String additional ) throws Exception {

		ProjectStageRecord dao = new ProjectStageRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectStageRecord( com.pomplatform.db.bean.BaseProjectStageRecord bean, String additional ) throws Exception {

		ProjectStageRecord dao = new ProjectStageRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectStageRecord> queryProjectStageRecord( com.pomplatform.db.bean.BaseProjectStageRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectStageRecord dao = new ProjectStageRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectStageRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectStageRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectStageRecord addToProjectStageRecord ( BaseProjectStageRecord projectstagerecord )  throws Exception {
		return addToProjectStageRecord ( projectstagerecord , false);
	}

	public static BaseProjectStageRecord addToProjectStageRecord ( BaseProjectStageRecord projectstagerecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectStageRecord dao = new ProjectStageRecord();
		dao.setDataFromBase(projectstagerecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectStageRecord addUpdateProjectStageRecord ( BaseProjectStageRecord projectstagerecord ) throws Exception {
		return addUpdateProjectStageRecord ( projectstagerecord , false);
	}

	public static BaseProjectStageRecord addUpdateProjectStageRecord ( BaseProjectStageRecord projectstagerecord, boolean singleTransaction  ) throws Exception {
		if(projectstagerecord.getProjectStageRecordId() == null) return addToProjectStageRecord(projectstagerecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectStageRecord dao = new ProjectStageRecord();
		dao.setDataFromBase(projectstagerecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectstagerecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectStageRecord ( BaseProjectStageRecord bean ) throws Exception {
		ProjectStageRecord dao = new ProjectStageRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectStageRecord updateProjectStageRecord ( BaseProjectStageRecord projectstagerecord ) throws Exception {
		ProjectStageRecord dao = new ProjectStageRecord();
		dao.setProjectStageRecordId( projectstagerecord.getProjectStageRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectstagerecord);
			result = dao.update();
		}
		return result == 1 ? projectstagerecord : null ;
	}

	public static BaseProjectStageRecord updateProjectStageRecordDirect( BaseProjectStageRecord projectstagerecord ) throws Exception {
		ProjectStageRecord dao = new ProjectStageRecord();
		int result = 0;
		dao.setDataFromBase(projectstagerecord);
		result = dao.update();
		return result == 1 ? projectstagerecord : null ;
	}

	public static int setDeleteConditions(BaseProjectStageRecord bean, ProjectStageRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectStageRecordId() != null) {
			dao.setConditionProjectStageRecordId("=", bean.getProjectStageRecordId());
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
		}
		return count;
	}

	public static int setConditions(BaseProjectStageRecord bean, ProjectStageRecord dao){
		int count = 0;
		if(bean.getProjectStageRecordId() != null) {
			dao.setConditionProjectStageRecordId("=", bean.getProjectStageRecordId());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectStageRecord bean = new BaseProjectStageRecord();
		bean.setDataFromJSON(json);
		ProjectStageRecord dao = new ProjectStageRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectStageRecord> rlist = new BaseCollection<>();
		BaseProjectStageRecord bean = new BaseProjectStageRecord();
		bean.setDataFromJSON(json);
		ProjectStageRecord dao = new ProjectStageRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectStageRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectStageRecord bean = new BaseProjectStageRecord();
		bean.setDataFromJSON(json);
		ProjectStageRecord dao = new ProjectStageRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectStageRecord bean = new BaseProjectStageRecord();
		bean.setDataFromJSON(json);
		ProjectStageRecord dao = new ProjectStageRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectStageRecord bean = new BaseProjectStageRecord();
		bean.setDataFromJSON(json);
		ProjectStageRecord dao = new ProjectStageRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectStageRecord bean = new BaseProjectStageRecord();
		bean.setDataFromJSON(json);
		ProjectStageRecord dao = new ProjectStageRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


