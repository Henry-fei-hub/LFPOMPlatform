package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseManageProject;
import com.pomplatform.db.dao.ManageProject;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ManageProjectHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ManageProjectHandler.class);

	public static BaseManageProject getManageProjectById( 
		java.lang.Integer manage_project_id
	) throws Exception
	{
		ManageProject dao = new ManageProject();
		dao.setManageProjectId(manage_project_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isManageProjectExists( com.pomplatform.db.bean.BaseManageProject bean, String additional ) throws Exception {

		ManageProject dao = new ManageProject();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countManageProject( com.pomplatform.db.bean.BaseManageProject bean, String additional ) throws Exception {

		ManageProject dao = new ManageProject();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseManageProject> queryManageProject( com.pomplatform.db.bean.BaseManageProject bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ManageProject dao = new ManageProject();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseManageProject> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseManageProject> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseManageProject addToManageProject ( BaseManageProject manageproject )  throws Exception {
		return addToManageProject ( manageproject , false);
	}

	public static BaseManageProject addToManageProject ( BaseManageProject manageproject, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ManageProject dao = new ManageProject();
		dao.setDataFromBase(manageproject);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseManageProject addUpdateManageProject ( BaseManageProject manageproject ) throws Exception {
		return addUpdateManageProject ( manageproject , false);
	}

	public static BaseManageProject addUpdateManageProject ( BaseManageProject manageproject, boolean singleTransaction  ) throws Exception {
		if(manageproject.getManageProjectId() == null) return addToManageProject(manageproject);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ManageProject dao = new ManageProject();
		dao.setDataFromBase(manageproject);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(manageproject); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteManageProject ( BaseManageProject bean ) throws Exception {
		ManageProject dao = new ManageProject();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseManageProject updateManageProject ( BaseManageProject manageproject ) throws Exception {
		ManageProject dao = new ManageProject();
		dao.setManageProjectId( manageproject.getManageProjectId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(manageproject);
			result = dao.update();
		}
		return result == 1 ? manageproject : null ;
	}

	public static BaseManageProject updateManageProjectDirect( BaseManageProject manageproject ) throws Exception {
		ManageProject dao = new ManageProject();
		int result = 0;
		dao.setDataFromBase(manageproject);
		result = dao.update();
		return result == 1 ? manageproject : null ;
	}

	public static int setDeleteConditions(BaseManageProject bean, ManageProject dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getManageProjectId() != null) {
			dao.setConditionManageProjectId("=", bean.getManageProjectId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getManageProjectName() != null) {
				dao.setConditionManageProjectName("=", bean.getManageProjectName());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseManageProject bean, ManageProject dao){
		int count = 0;
		if(bean.getManageProjectId() != null) {
			dao.setConditionManageProjectId("=", bean.getManageProjectId());
			count++;
		}
		if(bean.getManageProjectName() != null) {
			dao.setConditionManageProjectName("like", "%"+bean.getManageProjectName()+"%");
			count++;
		}
		if(bean.getTotalIntegral() != null) {
			dao.setConditionTotalIntegral("=", bean.getTotalIntegral());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getProjectDate() != null) {
			dao.setConditionProjectDate(">=", bean.getProjectDate());
			count++;
		}
		if(bean.getRemark() != null) {
			dao.setConditionRemark("like", "%"+bean.getRemark()+"%");
			count++;
		}
		if(bean.getLeftIntegral() != null) {
			dao.setConditionLeftIntegral("=", bean.getLeftIntegral());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseManageProject bean = new BaseManageProject();
		bean.setDataFromJSON(json);
		ManageProject dao = new ManageProject();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseManageProject> rlist = new BaseCollection<>();
		BaseManageProject bean = new BaseManageProject();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ManageProject dao = new ManageProject();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseManageProject> result = dao.conditionalLoad(addtion);
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
		BaseManageProject bean = new BaseManageProject();
		bean.setDataFromJSON(json);
		ManageProject dao = new ManageProject();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseManageProject bean = new BaseManageProject();
		bean.setDataFromJSON(json);
		ManageProject dao = new ManageProject();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseManageProject bean = new BaseManageProject();
		bean.setDataFromJSON(json);
		ManageProject dao = new ManageProject();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseManageProject bean = new BaseManageProject();
		bean.setDataFromJSON(json);
		ManageProject dao = new ManageProject();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


