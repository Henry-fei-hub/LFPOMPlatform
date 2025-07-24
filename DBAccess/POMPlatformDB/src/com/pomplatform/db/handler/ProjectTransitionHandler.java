package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseProjectTransition;
import java.util.List;
import com.pomplatform.db.dao.ProjectTransition;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ProjectTransitionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectTransitionHandler.class);

	public static BaseProjectTransition getProjectTransitionById( 
		java.lang.Integer project_transition_id
	) throws Exception
	{
		ProjectTransition dao = new ProjectTransition();
		dao.setProjectTransitionId(project_transition_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectTransitionExists( com.pomplatform.db.bean.BaseProjectTransition bean, String additional ) throws Exception {

		ProjectTransition dao = new ProjectTransition();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectTransition( com.pomplatform.db.bean.BaseProjectTransition bean, String additional ) throws Exception {

		ProjectTransition dao = new ProjectTransition();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectTransition> queryProjectTransition( com.pomplatform.db.bean.BaseProjectTransition bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectTransition dao = new ProjectTransition();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectTransition> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectTransition> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectTransition addToProjectTransition ( BaseProjectTransition projecttransition )  throws Exception {
		return addToProjectTransition ( projecttransition , false);
	}

	public static BaseProjectTransition addToProjectTransition ( BaseProjectTransition projecttransition, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectTransition dao = new ProjectTransition();
		dao.setDataFromBase(projecttransition);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectTransition addUpdateProjectTransition ( BaseProjectTransition projecttransition ) throws Exception {
		return addUpdateProjectTransition ( projecttransition , false);
	}

	public static BaseProjectTransition addUpdateProjectTransition ( BaseProjectTransition projecttransition, boolean singleTransaction  ) throws Exception {
		if(projecttransition.getProjectTransitionId() == null) return addToProjectTransition(projecttransition);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectTransition dao = new ProjectTransition();
		dao.setDataFromBase(projecttransition);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projecttransition); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectTransition ( BaseProjectTransition bean ) throws Exception {
		ProjectTransition dao = new ProjectTransition();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectTransition updateProjectTransition ( BaseProjectTransition projecttransition ) throws Exception {
		ProjectTransition dao = new ProjectTransition();
		dao.setProjectTransitionId( projecttransition.getProjectTransitionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projecttransition);
			result = dao.update();
		}
		return result == 1 ? projecttransition : null ;
	}

	public static BaseProjectTransition updateProjectTransitionDirect( BaseProjectTransition projecttransition ) throws Exception {
		ProjectTransition dao = new ProjectTransition();
		int result = 0;
		dao.setDataFromBase(projecttransition);
		result = dao.update();
		return result == 1 ? projecttransition : null ;
	}

	public static int setDeleteConditions(BaseProjectTransition bean, ProjectTransition dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectTransitionId() != null) {
			dao.setConditionProjectTransitionId("=", bean.getProjectTransitionId());
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
			if(bean.getIsOrNot() != null) {
				dao.setConditionIsOrNot("=", bean.getIsOrNot());
				count++;
			}
			if(bean.getInitiateDesign() != null) {
				dao.setConditionInitiateDesign("=", bean.getInitiateDesign());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectTransition bean, ProjectTransition dao){
		int count = 0;
		if(bean.getProjectTransitionId() != null) {
			dao.setConditionProjectTransitionId("=", bean.getProjectTransitionId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getPercent() != null) {
			dao.setConditionPercent("=", bean.getPercent());
			count++;
		}
		if(bean.getProjectManageId() != null) {
			dao.setConditionProjectManageId("=", bean.getProjectManageId());
			count++;
		}
		if(bean.getIsOrNot() != null) {
			dao.setConditionIsOrNot("=", bean.getIsOrNot());
			count++;
		}
		if(bean.getInitiateDesign() != null) {
			dao.setConditionInitiateDesign("=", bean.getInitiateDesign());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectTransition bean = new BaseProjectTransition();
		bean.setDataFromJSON(json);
		ProjectTransition dao = new ProjectTransition();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectTransition> rlist = new BaseCollection<>();
		BaseProjectTransition bean = new BaseProjectTransition();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectTransition dao = new ProjectTransition();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectTransition> result = dao.conditionalLoad(addtion);
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
		BaseProjectTransition bean = new BaseProjectTransition();
		bean.setDataFromJSON(json);
		ProjectTransition dao = new ProjectTransition();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectTransition bean = new BaseProjectTransition();
		bean.setDataFromJSON(json);
		ProjectTransition dao = new ProjectTransition();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectTransition bean = new BaseProjectTransition();
		bean.setDataFromJSON(json);
		ProjectTransition dao = new ProjectTransition();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectTransition bean = new BaseProjectTransition();
		bean.setDataFromJSON(json);
		ProjectTransition dao = new ProjectTransition();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


