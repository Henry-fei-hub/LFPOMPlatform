package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectChange;
import com.pomplatform.db.dao.ProjectChange;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectChangeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectChangeHandler.class);

	public static BaseProjectChange getProjectChangeById( 
		java.lang.Integer project_change_id
	) throws Exception
	{
		ProjectChange dao = new ProjectChange();
		dao.setProjectChangeId(project_change_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectChangeExists( com.pomplatform.db.bean.BaseProjectChange bean, String additional ) throws Exception {

		ProjectChange dao = new ProjectChange();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectChange( com.pomplatform.db.bean.BaseProjectChange bean, String additional ) throws Exception {

		ProjectChange dao = new ProjectChange();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectChange> queryProjectChange( com.pomplatform.db.bean.BaseProjectChange bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectChange dao = new ProjectChange();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectChange> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectChange> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectChange addToProjectChange ( BaseProjectChange projectchange )  throws Exception {
		return addToProjectChange ( projectchange , false);
	}

	public static BaseProjectChange addToProjectChange ( BaseProjectChange projectchange, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectChange dao = new ProjectChange();
		dao.setDataFromBase(projectchange);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectChange addUpdateProjectChange ( BaseProjectChange projectchange ) throws Exception {
		return addUpdateProjectChange ( projectchange , false);
	}

	public static BaseProjectChange addUpdateProjectChange ( BaseProjectChange projectchange, boolean singleTransaction  ) throws Exception {
		if(projectchange.getProjectChangeId() == null) return addToProjectChange(projectchange);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectChange dao = new ProjectChange();
		dao.setDataFromBase(projectchange);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectchange); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectChange ( BaseProjectChange bean ) throws Exception {
		ProjectChange dao = new ProjectChange();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectChange updateProjectChange ( BaseProjectChange projectchange ) throws Exception {
		ProjectChange dao = new ProjectChange();
		dao.setProjectChangeId( projectchange.getProjectChangeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectchange);
			result = dao.update();
		}
		return result == 1 ? projectchange : null ;
	}

	public static BaseProjectChange updateProjectChangeDirect( BaseProjectChange projectchange ) throws Exception {
		ProjectChange dao = new ProjectChange();
		int result = 0;
		dao.setDataFromBase(projectchange);
		result = dao.update();
		return result == 1 ? projectchange : null ;
	}

	public static int setDeleteConditions(BaseProjectChange bean, ProjectChange dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectChangeId() != null) {
			dao.setConditionProjectChangeId("=", bean.getProjectChangeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractChangeId() != null) {
				dao.setConditionContractChangeId("=", bean.getContractChangeId());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getSheetChangeView() != null) {
				dao.setConditionSheetChangeView("=", bean.getSheetChangeView());
				count++;
			}
			if(bean.getTotalChangeView() != null) {
				dao.setConditionTotalChangeView("=", bean.getTotalChangeView());
				count++;
			}
			if(bean.getFlag() != null) {
				dao.setConditionFlag("=", bean.getFlag());
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
		}
		return count;
	}

	public static int setConditions(BaseProjectChange bean, ProjectChange dao){
		int count = 0;
		if(bean.getProjectChangeId() != null) {
			dao.setConditionProjectChangeId("=", bean.getProjectChangeId());
			count++;
		}
		if(bean.getContractChangeId() != null) {
			dao.setConditionContractChangeId("=", bean.getContractChangeId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getSheetAmount() != null) {
			dao.setConditionSheetAmount("=", bean.getSheetAmount());
			count++;
		}
		if(bean.getSheetChangeAmount() != null) {
			dao.setConditionSheetChangeAmount("=", bean.getSheetChangeAmount());
			count++;
		}
		if(bean.getSheetFinalAmount() != null) {
			dao.setConditionSheetFinalAmount("=", bean.getSheetFinalAmount());
			count++;
		}
		if(bean.getSheetChangeView() != null) {
			if(bean.getSheetChangeView().indexOf("%") >= 0)
				dao.setConditionSheetChangeView("like", bean.getSheetChangeView());
			else
				dao.setConditionSheetChangeView("=", bean.getSheetChangeView());
			count++;
		}
		if(bean.getTotalIntegral() != null) {
			dao.setConditionTotalIntegral("=", bean.getTotalIntegral());
			count++;
		}
		if(bean.getTotalChangeIntegral() != null) {
			dao.setConditionTotalChangeIntegral("=", bean.getTotalChangeIntegral());
			count++;
		}
		if(bean.getTotalFinalIntegral() != null) {
			dao.setConditionTotalFinalIntegral("=", bean.getTotalFinalIntegral());
			count++;
		}
		if(bean.getTotalChangeView() != null) {
			if(bean.getTotalChangeView().indexOf("%") >= 0)
				dao.setConditionTotalChangeView("like", bean.getTotalChangeView());
			else
				dao.setConditionTotalChangeView("=", bean.getTotalChangeView());
			count++;
		}
		if(bean.getCommonArea() != null) {
			dao.setConditionCommonArea("=", bean.getCommonArea());
			count++;
		}
		if(bean.getLogisticsArea() != null) {
			dao.setConditionLogisticsArea("=", bean.getLogisticsArea());
			count++;
		}
		if(bean.getDesignArea() != null) {
			dao.setConditionDesignArea("=", bean.getDesignArea());
			count++;
		}
		if(bean.getComplaintPercentage() != null) {
			dao.setConditionComplaintPercentage("=", bean.getComplaintPercentage());
			count++;
		}
		if(bean.getComplaintIntegral() != null) {
			dao.setConditionComplaintIntegral("=", bean.getComplaintIntegral());
			count++;
		}
		if(bean.getFlag() != null) {
			dao.setConditionFlag("=", bean.getFlag());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectChange bean = new BaseProjectChange();
		bean.setDataFromJSON(json);
		ProjectChange dao = new ProjectChange();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectChange> rlist = new BaseCollection<>();
		BaseProjectChange bean = new BaseProjectChange();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectChange dao = new ProjectChange();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectChange> result = dao.conditionalLoad(addtion);
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
		BaseProjectChange bean = new BaseProjectChange();
		bean.setDataFromJSON(json);
		ProjectChange dao = new ProjectChange();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectChange bean = new BaseProjectChange();
		bean.setDataFromJSON(json);
		ProjectChange dao = new ProjectChange();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectChange bean = new BaseProjectChange();
		bean.setDataFromJSON(json);
		ProjectChange dao = new ProjectChange();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectChange bean = new BaseProjectChange();
		bean.setDataFromJSON(json);
		ProjectChange dao = new ProjectChange();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


