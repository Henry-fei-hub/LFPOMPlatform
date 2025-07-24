package com.pomplatform.db.handler;

import java.util.List;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectAppendIntegralRecord;
import com.pomplatform.db.dao.ProjectAppendIntegralRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;

public class ProjectAppendIntegralRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectAppendIntegralRecordHandler.class);

	public static BaseProjectAppendIntegralRecord getProjectAppendIntegralRecordById( 
		java.lang.Integer project_append_integral_record_id
	) throws Exception
	{
		ProjectAppendIntegralRecord dao = new ProjectAppendIntegralRecord();
		dao.setProjectAppendIntegralRecordId(project_append_integral_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectAppendIntegralRecordExists( com.pomplatform.db.bean.BaseProjectAppendIntegralRecord bean, String additional ) throws Exception {

		ProjectAppendIntegralRecord dao = new ProjectAppendIntegralRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectAppendIntegralRecord( com.pomplatform.db.bean.BaseProjectAppendIntegralRecord bean, String additional ) throws Exception {

		ProjectAppendIntegralRecord dao = new ProjectAppendIntegralRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectAppendIntegralRecord> queryProjectAppendIntegralRecord( com.pomplatform.db.bean.BaseProjectAppendIntegralRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectAppendIntegralRecord dao = new ProjectAppendIntegralRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectAppendIntegralRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectAppendIntegralRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectAppendIntegralRecord addToProjectAppendIntegralRecord ( BaseProjectAppendIntegralRecord projectappendintegralrecord )  throws Exception {
		return addToProjectAppendIntegralRecord ( projectappendintegralrecord , false);
	}

	public static BaseProjectAppendIntegralRecord addToProjectAppendIntegralRecord ( BaseProjectAppendIntegralRecord projectappendintegralrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectAppendIntegralRecord dao = new ProjectAppendIntegralRecord();
		dao.setDataFromBase(projectappendintegralrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectAppendIntegralRecord addUpdateProjectAppendIntegralRecord ( BaseProjectAppendIntegralRecord projectappendintegralrecord ) throws Exception {
		return addUpdateProjectAppendIntegralRecord ( projectappendintegralrecord , false);
	}

	public static BaseProjectAppendIntegralRecord addUpdateProjectAppendIntegralRecord ( BaseProjectAppendIntegralRecord projectappendintegralrecord, boolean singleTransaction  ) throws Exception {
		if(projectappendintegralrecord.getProjectAppendIntegralRecordId() == null) return addToProjectAppendIntegralRecord(projectappendintegralrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectAppendIntegralRecord dao = new ProjectAppendIntegralRecord();
		dao.setDataFromBase(projectappendintegralrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectappendintegralrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectAppendIntegralRecord ( BaseProjectAppendIntegralRecord bean ) throws Exception {
		ProjectAppendIntegralRecord dao = new ProjectAppendIntegralRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectAppendIntegralRecord updateProjectAppendIntegralRecord ( BaseProjectAppendIntegralRecord projectappendintegralrecord ) throws Exception {
		ProjectAppendIntegralRecord dao = new ProjectAppendIntegralRecord();
		dao.setProjectAppendIntegralRecordId( projectappendintegralrecord.getProjectAppendIntegralRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectappendintegralrecord);
			result = dao.update();
		}
		return result == 1 ? projectappendintegralrecord : null ;
	}

	public static BaseProjectAppendIntegralRecord updateProjectAppendIntegralRecordDirect( BaseProjectAppendIntegralRecord projectappendintegralrecord ) throws Exception {
		ProjectAppendIntegralRecord dao = new ProjectAppendIntegralRecord();
		int result = 0;
		dao.setDataFromBase(projectappendintegralrecord);
		result = dao.update();
		return result == 1 ? projectappendintegralrecord : null ;
	}

	public static int setDeleteConditions(BaseProjectAppendIntegralRecord bean, ProjectAppendIntegralRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectAppendIntegralRecordId() != null) {
			dao.setConditionProjectAppendIntegralRecordId("=", bean.getProjectAppendIntegralRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getAppendIntegral() != null) {
				dao.setConditionAppendIntegral("=", bean.getAppendIntegral());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectAppendIntegralRecord bean, ProjectAppendIntegralRecord dao){
		int count = 0;
		if(bean.getProjectAppendIntegralRecordId() != null) {
			dao.setConditionProjectAppendIntegralRecordId("=", bean.getProjectAppendIntegralRecordId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getAppendIntegral() != null) {
			dao.setConditionAppendIntegral("=", bean.getAppendIntegral());
			count++;
		}
		if(bean.getPercentage() != null) {
			dao.setConditionPercentage("=", bean.getPercentage());
			count++;
		}
		if(bean.getAppendTime() != null) {
			dao.setConditionAppendTime(">=", bean.getAppendTime());
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
		BaseProjectAppendIntegralRecord bean = new BaseProjectAppendIntegralRecord();
		bean.setDataFromJSON(json);
		ProjectAppendIntegralRecord dao = new ProjectAppendIntegralRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectAppendIntegralRecord> rlist = new BaseCollection<>();
		BaseProjectAppendIntegralRecord bean = new BaseProjectAppendIntegralRecord();
		bean.setDataFromJSON(json);
		ProjectAppendIntegralRecord dao = new ProjectAppendIntegralRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectAppendIntegralRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectAppendIntegralRecord bean = new BaseProjectAppendIntegralRecord();
		bean.setDataFromJSON(json);
		ProjectAppendIntegralRecord dao = new ProjectAppendIntegralRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectAppendIntegralRecord bean = new BaseProjectAppendIntegralRecord();
		bean.setDataFromJSON(json);
		ProjectAppendIntegralRecord dao = new ProjectAppendIntegralRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectAppendIntegralRecord bean = new BaseProjectAppendIntegralRecord();
		bean.setDataFromJSON(json);
		ProjectAppendIntegralRecord dao = new ProjectAppendIntegralRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectAppendIntegralRecord bean = new BaseProjectAppendIntegralRecord();
		bean.setDataFromJSON(json);
		ProjectAppendIntegralRecord dao = new ProjectAppendIntegralRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


