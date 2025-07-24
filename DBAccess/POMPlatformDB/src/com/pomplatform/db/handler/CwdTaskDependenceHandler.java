package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdTaskDependence;
import com.pomplatform.db.dao.CwdTaskDependence;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdTaskDependenceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdTaskDependenceHandler.class);

	public static BaseCwdTaskDependence getCwdTaskDependenceById( 
		java.lang.Integer cwd_task_dependence_id
	) throws Exception
	{
		CwdTaskDependence dao = new CwdTaskDependence();
		dao.setCwdTaskDependenceId(cwd_task_dependence_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdTaskDependenceExists( com.pomplatform.db.bean.BaseCwdTaskDependence bean, String additional ) throws Exception {

		CwdTaskDependence dao = new CwdTaskDependence();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdTaskDependence( com.pomplatform.db.bean.BaseCwdTaskDependence bean, String additional ) throws Exception {

		CwdTaskDependence dao = new CwdTaskDependence();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdTaskDependence> queryCwdTaskDependence( com.pomplatform.db.bean.BaseCwdTaskDependence bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdTaskDependence dao = new CwdTaskDependence();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdTaskDependence> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdTaskDependence> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdTaskDependence addToCwdTaskDependence ( BaseCwdTaskDependence cwdtaskdependence )  throws Exception {
		return addToCwdTaskDependence ( cwdtaskdependence , false);
	}

	public static BaseCwdTaskDependence addToCwdTaskDependence ( BaseCwdTaskDependence cwdtaskdependence, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdTaskDependence dao = new CwdTaskDependence();
		dao.setDataFromBase(cwdtaskdependence);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdTaskDependence addUpdateCwdTaskDependence ( BaseCwdTaskDependence cwdtaskdependence ) throws Exception {
		return addUpdateCwdTaskDependence ( cwdtaskdependence , false);
	}

	public static BaseCwdTaskDependence addUpdateCwdTaskDependence ( BaseCwdTaskDependence cwdtaskdependence, boolean singleTransaction  ) throws Exception {
		if(cwdtaskdependence.getCwdTaskDependenceId() == null) return addToCwdTaskDependence(cwdtaskdependence);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdTaskDependence dao = new CwdTaskDependence();
		dao.setDataFromBase(cwdtaskdependence);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdtaskdependence); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdTaskDependence ( BaseCwdTaskDependence bean ) throws Exception {
		CwdTaskDependence dao = new CwdTaskDependence();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdTaskDependence updateCwdTaskDependence ( BaseCwdTaskDependence cwdtaskdependence ) throws Exception {
		CwdTaskDependence dao = new CwdTaskDependence();
		dao.setCwdTaskDependenceId( cwdtaskdependence.getCwdTaskDependenceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdtaskdependence);
			result = dao.update();
		}
		return result == 1 ? cwdtaskdependence : null ;
	}

	public static BaseCwdTaskDependence updateCwdTaskDependenceDirect( BaseCwdTaskDependence cwdtaskdependence ) throws Exception {
		CwdTaskDependence dao = new CwdTaskDependence();
		int result = 0;
		dao.setDataFromBase(cwdtaskdependence);
		result = dao.update();
		return result == 1 ? cwdtaskdependence : null ;
	}

	public static int setDeleteConditions(BaseCwdTaskDependence bean, CwdTaskDependence dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdTaskDependenceId() != null) {
			dao.setConditionCwdTaskDependenceId("=", bean.getCwdTaskDependenceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getPredecessorTaskManageId() != null) {
				dao.setConditionPredecessorTaskManageId("=", bean.getPredecessorTaskManageId());
				count++;
			}
			if(bean.getSuccessorTaskManageId() != null) {
				dao.setConditionSuccessorTaskManageId("=", bean.getSuccessorTaskManageId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdTaskDependence bean, CwdTaskDependence dao){
		int count = 0;
		if(bean.getCwdTaskDependenceId() != null) {
			dao.setConditionCwdTaskDependenceId("=", bean.getCwdTaskDependenceId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getPredecessorTaskManageId() != null) {
			dao.setConditionPredecessorTaskManageId("=", bean.getPredecessorTaskManageId());
			count++;
		}
		if(bean.getSuccessorTaskManageId() != null) {
			dao.setConditionSuccessorTaskManageId("=", bean.getSuccessorTaskManageId());
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
		BaseCwdTaskDependence bean = new BaseCwdTaskDependence();
		bean.setDataFromJSON(json);
		CwdTaskDependence dao = new CwdTaskDependence();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdTaskDependence> rlist = new BaseCollection<>();
		BaseCwdTaskDependence bean = new BaseCwdTaskDependence();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdTaskDependence dao = new CwdTaskDependence();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdTaskDependence> result = dao.conditionalLoad(addtion);
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
		BaseCwdTaskDependence bean = new BaseCwdTaskDependence();
		bean.setDataFromJSON(json);
		CwdTaskDependence dao = new CwdTaskDependence();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdTaskDependence bean = new BaseCwdTaskDependence();
		bean.setDataFromJSON(json);
		CwdTaskDependence dao = new CwdTaskDependence();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdTaskDependence bean = new BaseCwdTaskDependence();
		bean.setDataFromJSON(json);
		CwdTaskDependence dao = new CwdTaskDependence();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdTaskDependence bean = new BaseCwdTaskDependence();
		bean.setDataFromJSON(json);
		CwdTaskDependence dao = new CwdTaskDependence();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


