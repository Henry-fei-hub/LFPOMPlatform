package com.pomplatform.db.handler;

import java.util.List;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectLog;
import com.pomplatform.db.dao.ProjectLog;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;

public class ProjectLogHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectLogHandler.class);

	public static BaseProjectLog getProjectLogById( 
		java.lang.Integer project_log_id
	) throws Exception
	{
		ProjectLog dao = new ProjectLog();
		dao.setProjectLogId(project_log_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectLogExists( com.pomplatform.db.bean.BaseProjectLog bean, String additional ) throws Exception {

		ProjectLog dao = new ProjectLog();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectLog( com.pomplatform.db.bean.BaseProjectLog bean, String additional ) throws Exception {

		ProjectLog dao = new ProjectLog();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectLog> queryProjectLog( com.pomplatform.db.bean.BaseProjectLog bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectLog dao = new ProjectLog();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectLog> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectLog> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectLog addToProjectLog ( BaseProjectLog projectlog )  throws Exception {
		return addToProjectLog ( projectlog , false);
	}

	public static BaseProjectLog addToProjectLog ( BaseProjectLog projectlog, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectLog dao = new ProjectLog();
		dao.setDataFromBase(projectlog);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectLog addUpdateProjectLog ( BaseProjectLog projectlog ) throws Exception {
		return addUpdateProjectLog ( projectlog , false);
	}

	public static BaseProjectLog addUpdateProjectLog ( BaseProjectLog projectlog, boolean singleTransaction  ) throws Exception {
		if(projectlog.getProjectLogId() == null) return addToProjectLog(projectlog);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectLog dao = new ProjectLog();
		dao.setDataFromBase(projectlog);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectlog); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectLog ( BaseProjectLog bean ) throws Exception {
		ProjectLog dao = new ProjectLog();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectLog updateProjectLog ( BaseProjectLog projectlog ) throws Exception {
		ProjectLog dao = new ProjectLog();
		dao.setProjectLogId( projectlog.getProjectLogId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectlog);
			result = dao.update();
		}
		return result == 1 ? projectlog : null ;
	}

	public static BaseProjectLog updateProjectLogDirect( BaseProjectLog projectlog ) throws Exception {
		ProjectLog dao = new ProjectLog();
		int result = 0;
		dao.setDataFromBase(projectlog);
		result = dao.update();
		return result == 1 ? projectlog : null ;
	}

	public static int setDeleteConditions(BaseProjectLog bean, ProjectLog dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectLogId() != null) {
			dao.setConditionProjectLogId("=", bean.getProjectLogId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getOperateId() != null) {
				dao.setConditionOperateId("=", bean.getOperateId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getManagerId() != null) {
				dao.setConditionManagerId("=", bean.getManagerId());
				count++;
			}
			if(bean.getDesignPhase() != null) {
				dao.setConditionDesignPhase("=", bean.getDesignPhase());
				count++;
			}
			if(bean.getLogType() != null) {
				dao.setConditionLogType("=", bean.getLogType());
				count++;
			}
			if(bean.getLogContent() != null) {
				dao.setConditionLogContent("=", bean.getLogContent());
				count++;
			}
			if(bean.getAlternateField1() != null) {
				dao.setConditionAlternateField1("=", bean.getAlternateField1());
				count++;
			}
			if(bean.getAlternateField2() != null) {
				dao.setConditionAlternateField2("=", bean.getAlternateField2());
				count++;
			}
			if(bean.getAlternateField3() != null) {
				dao.setConditionAlternateField3("=", bean.getAlternateField3());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectLog bean, ProjectLog dao){
		int count = 0;
		if(bean.getProjectLogId() != null) {
			dao.setConditionProjectLogId("=", bean.getProjectLogId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getOperateId() != null) {
			dao.setConditionOperateId("=", bean.getOperateId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getManagerId() != null) {
			dao.setConditionManagerId("=", bean.getManagerId());
			count++;
		}
		if(bean.getDesignPhase() != null) {
			dao.setConditionDesignPhase("=", bean.getDesignPhase());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getLogType() != null) {
			dao.setConditionLogType("=", bean.getLogType());
			count++;
		}
		if(bean.getLogContent() != null) {
			if(bean.getLogContent().indexOf("%") >= 0)
				dao.setConditionLogContent("like", bean.getLogContent());
			else
				dao.setConditionLogContent("=", bean.getLogContent());
			count++;
		}
		if(bean.getAlternateField1() != null) {
			if(bean.getAlternateField1().indexOf("%") >= 0)
				dao.setConditionAlternateField1("like", bean.getAlternateField1());
			else
				dao.setConditionAlternateField1("=", bean.getAlternateField1());
			count++;
		}
		if(bean.getAlternateField2() != null) {
			if(bean.getAlternateField2().indexOf("%") >= 0)
				dao.setConditionAlternateField2("like", bean.getAlternateField2());
			else
				dao.setConditionAlternateField2("=", bean.getAlternateField2());
			count++;
		}
		if(bean.getAlternateField3() != null) {
			if(bean.getAlternateField3().indexOf("%") >= 0)
				dao.setConditionAlternateField3("like", bean.getAlternateField3());
			else
				dao.setConditionAlternateField3("=", bean.getAlternateField3());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectLog bean = new BaseProjectLog();
		bean.setDataFromJSON(json);
		ProjectLog dao = new ProjectLog();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectLog> rlist = new BaseCollection<>();
		BaseProjectLog bean = new BaseProjectLog();
		bean.setDataFromJSON(json);
		ProjectLog dao = new ProjectLog();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectLog> result = dao.conditionalLoad(addtion);
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
		BaseProjectLog bean = new BaseProjectLog();
		bean.setDataFromJSON(json);
		ProjectLog dao = new ProjectLog();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectLog bean = new BaseProjectLog();
		bean.setDataFromJSON(json);
		ProjectLog dao = new ProjectLog();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectLog bean = new BaseProjectLog();
		bean.setDataFromJSON(json);
		ProjectLog dao = new ProjectLog();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectLog bean = new BaseProjectLog();
		bean.setDataFromJSON(json);
		ProjectLog dao = new ProjectLog();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


