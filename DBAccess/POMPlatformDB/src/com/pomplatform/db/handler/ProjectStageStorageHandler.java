package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectStageStorage;
import com.pomplatform.db.dao.ProjectStageStorage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectStageStorageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectStageStorageHandler.class);

	public static BaseProjectStageStorage getProjectStageStorageById( 
		java.lang.Integer project_stage_storage_id
	) throws Exception
	{
		ProjectStageStorage dao = new ProjectStageStorage();
		dao.setProjectStageStorageId(project_stage_storage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectStageStorageExists( com.pomplatform.db.bean.BaseProjectStageStorage bean, String additional ) throws Exception {

		ProjectStageStorage dao = new ProjectStageStorage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectStageStorage( com.pomplatform.db.bean.BaseProjectStageStorage bean, String additional ) throws Exception {

		ProjectStageStorage dao = new ProjectStageStorage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectStageStorage> queryProjectStageStorage( com.pomplatform.db.bean.BaseProjectStageStorage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectStageStorage dao = new ProjectStageStorage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectStageStorage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectStageStorage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectStageStorage addToProjectStageStorage ( BaseProjectStageStorage projectstagestorage )  throws Exception {
		return addToProjectStageStorage ( projectstagestorage , false);
	}

	public static BaseProjectStageStorage addToProjectStageStorage ( BaseProjectStageStorage projectstagestorage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectStageStorage dao = new ProjectStageStorage();
		dao.setDataFromBase(projectstagestorage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectStageStorage addUpdateProjectStageStorage ( BaseProjectStageStorage projectstagestorage ) throws Exception {
		return addUpdateProjectStageStorage ( projectstagestorage , false);
	}

	public static BaseProjectStageStorage addUpdateProjectStageStorage ( BaseProjectStageStorage projectstagestorage, boolean singleTransaction  ) throws Exception {
		if(projectstagestorage.getProjectStageStorageId() == null) return addToProjectStageStorage(projectstagestorage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectStageStorage dao = new ProjectStageStorage();
		dao.setDataFromBase(projectstagestorage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectstagestorage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectStageStorage ( BaseProjectStageStorage bean ) throws Exception {
		ProjectStageStorage dao = new ProjectStageStorage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectStageStorage updateProjectStageStorage ( BaseProjectStageStorage projectstagestorage ) throws Exception {
		ProjectStageStorage dao = new ProjectStageStorage();
		dao.setProjectStageStorageId( projectstagestorage.getProjectStageStorageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectstagestorage);
			result = dao.update();
		}
		return result == 1 ? projectstagestorage : null ;
	}

	public static BaseProjectStageStorage updateProjectStageStorageDirect( BaseProjectStageStorage projectstagestorage ) throws Exception {
		ProjectStageStorage dao = new ProjectStageStorage();
		int result = 0;
		dao.setDataFromBase(projectstagestorage);
		result = dao.update();
		return result == 1 ? projectstagestorage : null ;
	}

	public static int setDeleteConditions(BaseProjectStageStorage bean, ProjectStageStorage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectStageStorageId() != null) {
			dao.setConditionProjectStageStorageId("=", bean.getProjectStageStorageId());
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
			if(bean.getPercent() != null) {
				dao.setConditionPercent("=", bean.getPercent());
				count++;
			}
			if(bean.getStageName() != null) {
				dao.setConditionStageName("=", bean.getStageName());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getRiginalPlan() != null) {
				dao.setConditionRiginalPlan("=", bean.getRiginalPlan());
				count++;
			}
			if(bean.getTabAmount() != null) {
				dao.setConditionTabAmount("=", bean.getTabAmount());
				count++;
			}
			if(bean.getProjectTemplateId() != null) {
				dao.setConditionProjectTemplateId("=", bean.getProjectTemplateId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectStageStorage bean, ProjectStageStorage dao){
		int count = 0;
		if(bean.getProjectStageStorageId() != null) {
			dao.setConditionProjectStageStorageId("=", bean.getProjectStageStorageId());
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
		if(bean.getPercent() != null) {
			dao.setConditionPercent("=", bean.getPercent());
			count++;
		}
		if(bean.getProjectAmount() != null) {
			dao.setConditionProjectAmount("=", bean.getProjectAmount());
			count++;
		}
		if(bean.getStageName() != null) {
			if(bean.getStageName().indexOf("%") >= 0)
				dao.setConditionStageName("like", bean.getStageName());
			else
				dao.setConditionStageName("=", bean.getStageName());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getRiginalPlan() != null) {
			dao.setConditionRiginalPlan("=", bean.getRiginalPlan());
			count++;
		}
		if(bean.getProjectConfirmAmount() != null) {
			dao.setConditionProjectConfirmAmount("=", bean.getProjectConfirmAmount());
			count++;
		}
		if(bean.getTabAmount() != null) {
			dao.setConditionTabAmount("=", bean.getTabAmount());
			count++;
		}
		if(bean.getProjectTemplateId() != null) {
			dao.setConditionProjectTemplateId("=", bean.getProjectTemplateId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectStageStorage bean = new BaseProjectStageStorage();
		bean.setDataFromJSON(json);
		ProjectStageStorage dao = new ProjectStageStorage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectStageStorage> rlist = new BaseCollection<>();
		BaseProjectStageStorage bean = new BaseProjectStageStorage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectStageStorage dao = new ProjectStageStorage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectStageStorage> result = dao.conditionalLoad(addtion);
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
		BaseProjectStageStorage bean = new BaseProjectStageStorage();
		bean.setDataFromJSON(json);
		ProjectStageStorage dao = new ProjectStageStorage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectStageStorage bean = new BaseProjectStageStorage();
		bean.setDataFromJSON(json);
		ProjectStageStorage dao = new ProjectStageStorage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectStageStorage bean = new BaseProjectStageStorage();
		bean.setDataFromJSON(json);
		ProjectStageStorage dao = new ProjectStageStorage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectStageStorage bean = new BaseProjectStageStorage();
		bean.setDataFromJSON(json);
		ProjectStageStorage dao = new ProjectStageStorage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


