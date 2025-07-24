package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseProjectStage;
import java.util.List;
import com.pomplatform.db.dao.ProjectStage;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ProjectStageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectStageHandler.class);

	public static BaseProjectStage getProjectStageById( 
		java.lang.Integer project_stage_id
	) throws Exception
	{
		ProjectStage dao = new ProjectStage();
		dao.setProjectStageId(project_stage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectStageExists( com.pomplatform.db.bean.BaseProjectStage bean, String additional ) throws Exception {

		ProjectStage dao = new ProjectStage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectStage( com.pomplatform.db.bean.BaseProjectStage bean, String additional ) throws Exception {

		ProjectStage dao = new ProjectStage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectStage> queryProjectStage( com.pomplatform.db.bean.BaseProjectStage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectStage dao = new ProjectStage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectStage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectStage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectStage addToProjectStage ( BaseProjectStage projectstage )  throws Exception {
		return addToProjectStage ( projectstage , false);
	}

	public static BaseProjectStage addToProjectStage ( BaseProjectStage projectstage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectStage dao = new ProjectStage();
		dao.setDataFromBase(projectstage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectStage addUpdateProjectStage ( BaseProjectStage projectstage ) throws Exception {
		return addUpdateProjectStage ( projectstage , false);
	}

	public static BaseProjectStage addUpdateProjectStage ( BaseProjectStage projectstage, boolean singleTransaction  ) throws Exception {
		if(projectstage.getProjectStageId() == null) return addToProjectStage(projectstage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectStage dao = new ProjectStage();
		dao.setDataFromBase(projectstage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectstage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectStage ( BaseProjectStage bean ) throws Exception {
		ProjectStage dao = new ProjectStage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectStage updateProjectStage ( BaseProjectStage projectstage ) throws Exception {
		ProjectStage dao = new ProjectStage();
		dao.setProjectStageId( projectstage.getProjectStageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectstage);
			result = dao.update();
		}
		return result == 1 ? projectstage : null ;
	}

	public static BaseProjectStage updateProjectStageDirect( BaseProjectStage projectstage ) throws Exception {
		ProjectStage dao = new ProjectStage();
		int result = 0;
		dao.setDataFromBase(projectstage);
		result = dao.update();
		return result == 1 ? projectstage : null ;
	}

	public static int setDeleteConditions(BaseProjectStage bean, ProjectStage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectStageId() != null) {
			dao.setConditionProjectStageId("=", bean.getProjectStageId());
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
			if(bean.getStageName() != null) {
				dao.setConditionStageName("=", bean.getStageName());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getProjectTemplateId() != null) {
				dao.setConditionProjectTemplateId("=", bean.getProjectTemplateId());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectStage bean, ProjectStage dao){
		int count = 0;
		if(bean.getProjectStageId() != null) {
			dao.setConditionProjectStageId("=", bean.getProjectStageId());
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
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getProjectTemplateId() != null) {
			dao.setConditionProjectTemplateId("=", bean.getProjectTemplateId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
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
		BaseProjectStage bean = new BaseProjectStage();
		bean.setDataFromJSON(json);
		ProjectStage dao = new ProjectStage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectStage> rlist = new BaseCollection<>();
		BaseProjectStage bean = new BaseProjectStage();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectStage dao = new ProjectStage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectStage> result = dao.conditionalLoad(addtion);
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
		BaseProjectStage bean = new BaseProjectStage();
		bean.setDataFromJSON(json);
		ProjectStage dao = new ProjectStage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectStage bean = new BaseProjectStage();
		bean.setDataFromJSON(json);
		ProjectStage dao = new ProjectStage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectStage bean = new BaseProjectStage();
		bean.setDataFromJSON(json);
		ProjectStage dao = new ProjectStage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectStage bean = new BaseProjectStage();
		bean.setDataFromJSON(json);
		ProjectStage dao = new ProjectStage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


