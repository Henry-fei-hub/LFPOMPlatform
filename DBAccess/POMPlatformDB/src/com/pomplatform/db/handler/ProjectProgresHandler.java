package com.pomplatform.db.handler;

import java.util.List;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectProgres;
import com.pomplatform.db.dao.ProjectProgres;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;

public class ProjectProgresHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectProgresHandler.class);

	public static BaseProjectProgres getProjectProgresById( 
		java.lang.Integer project_progress_id
	) throws Exception
	{
		ProjectProgres dao = new ProjectProgres();
		dao.setProjectProgressId(project_progress_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectProgresExists( com.pomplatform.db.bean.BaseProjectProgres bean, String additional ) throws Exception {

		ProjectProgres dao = new ProjectProgres();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectProgres( com.pomplatform.db.bean.BaseProjectProgres bean, String additional ) throws Exception {

		ProjectProgres dao = new ProjectProgres();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectProgres> queryProjectProgres( com.pomplatform.db.bean.BaseProjectProgres bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectProgres dao = new ProjectProgres();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectProgres> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectProgres> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectProgres addToProjectProgres ( BaseProjectProgres projectprogres )  throws Exception {
		return addToProjectProgres ( projectprogres , false);
	}

	public static BaseProjectProgres addToProjectProgres ( BaseProjectProgres projectprogres, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectProgres dao = new ProjectProgres();
		dao.setDataFromBase(projectprogres);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectProgres addUpdateProjectProgres ( BaseProjectProgres projectprogres ) throws Exception {
		return addUpdateProjectProgres ( projectprogres , false);
	}

	public static BaseProjectProgres addUpdateProjectProgres ( BaseProjectProgres projectprogres, boolean singleTransaction  ) throws Exception {
		if(projectprogres.getProjectProgressId() == null) return addToProjectProgres(projectprogres);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectProgres dao = new ProjectProgres();
		dao.setDataFromBase(projectprogres);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectprogres); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectProgres ( BaseProjectProgres bean ) throws Exception {
		ProjectProgres dao = new ProjectProgres();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectProgres updateProjectProgres ( BaseProjectProgres projectprogres ) throws Exception {
		ProjectProgres dao = new ProjectProgres();
		dao.setProjectProgressId( projectprogres.getProjectProgressId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectprogres);
			result = dao.update();
		}
		return result == 1 ? projectprogres : null ;
	}

	public static BaseProjectProgres updateProjectProgresDirect( BaseProjectProgres projectprogres ) throws Exception {
		ProjectProgres dao = new ProjectProgres();
		int result = 0;
		dao.setDataFromBase(projectprogres);
		result = dao.update();
		return result == 1 ? projectprogres : null ;
	}

	public static int setDeleteConditions(BaseProjectProgres bean, ProjectProgres dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectProgressId() != null) {
			dao.setConditionProjectProgressId("=", bean.getProjectProgressId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getProjectManageId() != null) {
				dao.setConditionProjectManageId("=", bean.getProjectManageId());
				count++;
			}
			if(bean.getDesignPhase() != null) {
				dao.setConditionDesignPhase("=", bean.getDesignPhase());
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

	public static int setConditions(BaseProjectProgres bean, ProjectProgres dao){
		int count = 0;
		if(bean.getProjectProgressId() != null) {
			dao.setConditionProjectProgressId("=", bean.getProjectProgressId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getProjectManageId() != null) {
			dao.setConditionProjectManageId("=", bean.getProjectManageId());
			count++;
		}
		if(bean.getDesignPhase() != null) {
			dao.setConditionDesignPhase("=", bean.getDesignPhase());
			count++;
		}
		if(bean.getFinishDate() != null) {
			dao.setConditionFinishDate(">=", bean.getFinishDate());
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
		BaseProjectProgres bean = new BaseProjectProgres();
		bean.setDataFromJSON(json);
		ProjectProgres dao = new ProjectProgres();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectProgres> rlist = new BaseCollection<>();
		BaseProjectProgres bean = new BaseProjectProgres();
		bean.setDataFromJSON(json);
		ProjectProgres dao = new ProjectProgres();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectProgres> result = dao.conditionalLoad(addtion);
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
		BaseProjectProgres bean = new BaseProjectProgres();
		bean.setDataFromJSON(json);
		ProjectProgres dao = new ProjectProgres();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectProgres bean = new BaseProjectProgres();
		bean.setDataFromJSON(json);
		ProjectProgres dao = new ProjectProgres();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectProgres bean = new BaseProjectProgres();
		bean.setDataFromJSON(json);
		ProjectProgres dao = new ProjectProgres();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectProgres bean = new BaseProjectProgres();
		bean.setDataFromJSON(json);
		ProjectProgres dao = new ProjectProgres();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


