package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseProjectStageProcessDetail;
import java.util.List;
import com.pomplatform.db.dao.ProjectStageProcessDetail;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ProjectStageProcessDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectStageProcessDetailHandler.class);

	public static BaseProjectStageProcessDetail getProjectStageProcessDetailById( 
		java.lang.Integer project_stage_process_detail_id
	) throws Exception
	{
		ProjectStageProcessDetail dao = new ProjectStageProcessDetail();
		dao.setProjectStageProcessDetailId(project_stage_process_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectStageProcessDetailExists( com.pomplatform.db.bean.BaseProjectStageProcessDetail bean, String additional ) throws Exception {

		ProjectStageProcessDetail dao = new ProjectStageProcessDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectStageProcessDetail( com.pomplatform.db.bean.BaseProjectStageProcessDetail bean, String additional ) throws Exception {

		ProjectStageProcessDetail dao = new ProjectStageProcessDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectStageProcessDetail> queryProjectStageProcessDetail( com.pomplatform.db.bean.BaseProjectStageProcessDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectStageProcessDetail dao = new ProjectStageProcessDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectStageProcessDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectStageProcessDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectStageProcessDetail addToProjectStageProcessDetail ( BaseProjectStageProcessDetail projectstageprocessdetail )  throws Exception {
		return addToProjectStageProcessDetail ( projectstageprocessdetail , false);
	}

	public static BaseProjectStageProcessDetail addToProjectStageProcessDetail ( BaseProjectStageProcessDetail projectstageprocessdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectStageProcessDetail dao = new ProjectStageProcessDetail();
		dao.setDataFromBase(projectstageprocessdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectStageProcessDetail addUpdateProjectStageProcessDetail ( BaseProjectStageProcessDetail projectstageprocessdetail ) throws Exception {
		return addUpdateProjectStageProcessDetail ( projectstageprocessdetail , false);
	}

	public static BaseProjectStageProcessDetail addUpdateProjectStageProcessDetail ( BaseProjectStageProcessDetail projectstageprocessdetail, boolean singleTransaction  ) throws Exception {
		if(projectstageprocessdetail.getProjectStageProcessDetailId() == null) return addToProjectStageProcessDetail(projectstageprocessdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectStageProcessDetail dao = new ProjectStageProcessDetail();
		dao.setDataFromBase(projectstageprocessdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectstageprocessdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectStageProcessDetail ( BaseProjectStageProcessDetail bean ) throws Exception {
		ProjectStageProcessDetail dao = new ProjectStageProcessDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectStageProcessDetail updateProjectStageProcessDetail ( BaseProjectStageProcessDetail projectstageprocessdetail ) throws Exception {
		ProjectStageProcessDetail dao = new ProjectStageProcessDetail();
		dao.setProjectStageProcessDetailId( projectstageprocessdetail.getProjectStageProcessDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectstageprocessdetail);
			result = dao.update();
		}
		return result == 1 ? projectstageprocessdetail : null ;
	}

	public static BaseProjectStageProcessDetail updateProjectStageProcessDetailDirect( BaseProjectStageProcessDetail projectstageprocessdetail ) throws Exception {
		ProjectStageProcessDetail dao = new ProjectStageProcessDetail();
		int result = 0;
		dao.setDataFromBase(projectstageprocessdetail);
		result = dao.update();
		return result == 1 ? projectstageprocessdetail : null ;
	}

	public static int setDeleteConditions(BaseProjectStageProcessDetail bean, ProjectStageProcessDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectStageProcessDetailId() != null) {
			dao.setConditionProjectStageProcessDetailId("=", bean.getProjectStageProcessDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectStageProcessRecordId() != null) {
				dao.setConditionProjectStageProcessRecordId("=", bean.getProjectStageProcessRecordId());
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
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectStageProcessDetail bean, ProjectStageProcessDetail dao){
		int count = 0;
		if(bean.getProjectStageProcessDetailId() != null) {
			dao.setConditionProjectStageProcessDetailId("=", bean.getProjectStageProcessDetailId());
			count++;
		}
		if(bean.getProjectStageProcessRecordId() != null) {
			dao.setConditionProjectStageProcessRecordId("=", bean.getProjectStageProcessRecordId());
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
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectStageProcessDetail bean = new BaseProjectStageProcessDetail();
		bean.setDataFromJSON(json);
		ProjectStageProcessDetail dao = new ProjectStageProcessDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectStageProcessDetail> rlist = new BaseCollection<>();
		BaseProjectStageProcessDetail bean = new BaseProjectStageProcessDetail();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectStageProcessDetail dao = new ProjectStageProcessDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectStageProcessDetail> result = dao.conditionalLoad(addtion);
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
		BaseProjectStageProcessDetail bean = new BaseProjectStageProcessDetail();
		bean.setDataFromJSON(json);
		ProjectStageProcessDetail dao = new ProjectStageProcessDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectStageProcessDetail bean = new BaseProjectStageProcessDetail();
		bean.setDataFromJSON(json);
		ProjectStageProcessDetail dao = new ProjectStageProcessDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectStageProcessDetail bean = new BaseProjectStageProcessDetail();
		bean.setDataFromJSON(json);
		ProjectStageProcessDetail dao = new ProjectStageProcessDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectStageProcessDetail bean = new BaseProjectStageProcessDetail();
		bean.setDataFromJSON(json);
		ProjectStageProcessDetail dao = new ProjectStageProcessDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


