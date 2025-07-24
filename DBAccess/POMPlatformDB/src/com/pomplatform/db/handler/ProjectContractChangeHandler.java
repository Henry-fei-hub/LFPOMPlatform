package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectContractChange;
import com.pomplatform.db.dao.ProjectContractChange;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectContractChangeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectContractChangeHandler.class);

	public static BaseProjectContractChange getProjectContractChangeById( 
		java.lang.Integer project_contract_change_id
	) throws Exception
	{
		ProjectContractChange dao = new ProjectContractChange();
		dao.setProjectContractChangeId(project_contract_change_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectContractChangeExists( com.pomplatform.db.bean.BaseProjectContractChange bean, String additional ) throws Exception {

		ProjectContractChange dao = new ProjectContractChange();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectContractChange( com.pomplatform.db.bean.BaseProjectContractChange bean, String additional ) throws Exception {

		ProjectContractChange dao = new ProjectContractChange();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectContractChange> queryProjectContractChange( com.pomplatform.db.bean.BaseProjectContractChange bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectContractChange dao = new ProjectContractChange();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectContractChange> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectContractChange> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectContractChange addToProjectContractChange ( BaseProjectContractChange projectcontractchange )  throws Exception {
		return addToProjectContractChange ( projectcontractchange , false);
	}

	public static BaseProjectContractChange addToProjectContractChange ( BaseProjectContractChange projectcontractchange, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectContractChange dao = new ProjectContractChange();
		dao.setDataFromBase(projectcontractchange);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectContractChange addUpdateProjectContractChange ( BaseProjectContractChange projectcontractchange ) throws Exception {
		return addUpdateProjectContractChange ( projectcontractchange , false);
	}

	public static BaseProjectContractChange addUpdateProjectContractChange ( BaseProjectContractChange projectcontractchange, boolean singleTransaction  ) throws Exception {
		if(projectcontractchange.getProjectContractChangeId() == null) return addToProjectContractChange(projectcontractchange);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectContractChange dao = new ProjectContractChange();
		dao.setDataFromBase(projectcontractchange);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectcontractchange); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectContractChange ( BaseProjectContractChange bean ) throws Exception {
		ProjectContractChange dao = new ProjectContractChange();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectContractChange updateProjectContractChange ( BaseProjectContractChange projectcontractchange ) throws Exception {
		ProjectContractChange dao = new ProjectContractChange();
		dao.setProjectContractChangeId( projectcontractchange.getProjectContractChangeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectcontractchange);
			result = dao.update();
		}
		return result == 1 ? projectcontractchange : null ;
	}

	public static BaseProjectContractChange updateProjectContractChangeDirect( BaseProjectContractChange projectcontractchange ) throws Exception {
		ProjectContractChange dao = new ProjectContractChange();
		int result = 0;
		dao.setDataFromBase(projectcontractchange);
		result = dao.update();
		return result == 1 ? projectcontractchange : null ;
	}

	public static int setDeleteConditions(BaseProjectContractChange bean, ProjectContractChange dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectContractChangeId() != null) {
			dao.setConditionProjectContractChangeId("=", bean.getProjectContractChangeId());
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
			if(bean.getIsCompleted() != null) {
				dao.setConditionIsCompleted("=", bean.getIsCompleted());
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

	public static int setConditions(BaseProjectContractChange bean, ProjectContractChange dao){
		int count = 0;
		if(bean.getProjectContractChangeId() != null) {
			dao.setConditionProjectContractChangeId("=", bean.getProjectContractChangeId());
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
		if(bean.getIntegral() != null) {
			dao.setConditionIntegral("=", bean.getIntegral());
			count++;
		}
		if(bean.getPlateIntegral() != null) {
			dao.setConditionPlateIntegral("=", bean.getPlateIntegral());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getIsCompleted() != null) {
			dao.setConditionIsCompleted("=", bean.getIsCompleted());
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
		BaseProjectContractChange bean = new BaseProjectContractChange();
		bean.setDataFromJSON(json);
		ProjectContractChange dao = new ProjectContractChange();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectContractChange> rlist = new BaseCollection<>();
		BaseProjectContractChange bean = new BaseProjectContractChange();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectContractChange dao = new ProjectContractChange();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectContractChange> result = dao.conditionalLoad(addtion);
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
		BaseProjectContractChange bean = new BaseProjectContractChange();
		bean.setDataFromJSON(json);
		ProjectContractChange dao = new ProjectContractChange();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectContractChange bean = new BaseProjectContractChange();
		bean.setDataFromJSON(json);
		ProjectContractChange dao = new ProjectContractChange();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectContractChange bean = new BaseProjectContractChange();
		bean.setDataFromJSON(json);
		ProjectContractChange dao = new ProjectContractChange();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectContractChange bean = new BaseProjectContractChange();
		bean.setDataFromJSON(json);
		ProjectContractChange dao = new ProjectContractChange();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


