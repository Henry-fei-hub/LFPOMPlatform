package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseThreadTaskManage;
import com.pomplatform.db.dao.ThreadTaskManage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ThreadTaskManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ThreadTaskManageHandler.class);

	public static BaseThreadTaskManage getThreadTaskManageById( 
		java.lang.Integer thread_task_manage_id
	) throws Exception
	{
		ThreadTaskManage dao = new ThreadTaskManage();
		dao.setThreadTaskManageId(thread_task_manage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isThreadTaskManageExists( com.pomplatform.db.bean.BaseThreadTaskManage bean, String additional ) throws Exception {

		ThreadTaskManage dao = new ThreadTaskManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countThreadTaskManage( com.pomplatform.db.bean.BaseThreadTaskManage bean, String additional ) throws Exception {

		ThreadTaskManage dao = new ThreadTaskManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseThreadTaskManage> queryThreadTaskManage( com.pomplatform.db.bean.BaseThreadTaskManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ThreadTaskManage dao = new ThreadTaskManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseThreadTaskManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseThreadTaskManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseThreadTaskManage addToThreadTaskManage ( BaseThreadTaskManage threadtaskmanage )  throws Exception {
		return addToThreadTaskManage ( threadtaskmanage , false);
	}

	public static BaseThreadTaskManage addToThreadTaskManage ( BaseThreadTaskManage threadtaskmanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ThreadTaskManage dao = new ThreadTaskManage();
		dao.setDataFromBase(threadtaskmanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseThreadTaskManage addUpdateThreadTaskManage ( BaseThreadTaskManage threadtaskmanage ) throws Exception {
		return addUpdateThreadTaskManage ( threadtaskmanage , false);
	}

	public static BaseThreadTaskManage addUpdateThreadTaskManage ( BaseThreadTaskManage threadtaskmanage, boolean singleTransaction  ) throws Exception {
		if(threadtaskmanage.getThreadTaskManageId() == null) return addToThreadTaskManage(threadtaskmanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ThreadTaskManage dao = new ThreadTaskManage();
		dao.setDataFromBase(threadtaskmanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(threadtaskmanage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteThreadTaskManage ( BaseThreadTaskManage bean ) throws Exception {
		ThreadTaskManage dao = new ThreadTaskManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseThreadTaskManage updateThreadTaskManage ( BaseThreadTaskManage threadtaskmanage ) throws Exception {
		ThreadTaskManage dao = new ThreadTaskManage();
		dao.setThreadTaskManageId( threadtaskmanage.getThreadTaskManageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(threadtaskmanage);
			result = dao.update();
		}
		return result == 1 ? threadtaskmanage : null ;
	}

	public static BaseThreadTaskManage updateThreadTaskManageDirect( BaseThreadTaskManage threadtaskmanage ) throws Exception {
		ThreadTaskManage dao = new ThreadTaskManage();
		int result = 0;
		dao.setDataFromBase(threadtaskmanage);
		result = dao.update();
		return result == 1 ? threadtaskmanage : null ;
	}

	public static int setDeleteConditions(BaseThreadTaskManage bean, ThreadTaskManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getThreadTaskManageId() != null) {
			dao.setConditionThreadTaskManageId("=", bean.getThreadTaskManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTaskType() != null) {
				dao.setConditionTaskType("=", bean.getTaskType());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getErrorMsg() != null) {
				dao.setConditionErrorMsg("=", bean.getErrorMsg());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getOperationType() != null) {
				dao.setConditionOperationType("=", bean.getOperationType());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseThreadTaskManage bean, ThreadTaskManage dao){
		int count = 0;
		if(bean.getThreadTaskManageId() != null) {
			dao.setConditionThreadTaskManageId("=", bean.getThreadTaskManageId());
			count++;
		}
		if(bean.getTaskType() != null) {
			dao.setConditionTaskType("=", bean.getTaskType());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getErrorMsg() != null) {
			if(bean.getErrorMsg().indexOf("%") >= 0)
				dao.setConditionErrorMsg("like", bean.getErrorMsg());
			else
				dao.setConditionErrorMsg("=", bean.getErrorMsg());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getOperationType() != null) {
			dao.setConditionOperationType("=", bean.getOperationType());
			count++;
		}
		if(bean.getBeginTime() != null) {
			dao.setConditionBeginTime(">=", bean.getBeginTime());
			count++;
		}
		if(bean.getEndTime() != null) {
			dao.setConditionEndTime(">=", bean.getEndTime());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
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
		BaseThreadTaskManage bean = new BaseThreadTaskManage();
		bean.setDataFromJSON(json);
		ThreadTaskManage dao = new ThreadTaskManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseThreadTaskManage> rlist = new BaseCollection<>();
		BaseThreadTaskManage bean = new BaseThreadTaskManage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ThreadTaskManage dao = new ThreadTaskManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseThreadTaskManage> result = dao.conditionalLoad(addtion);
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
		BaseThreadTaskManage bean = new BaseThreadTaskManage();
		bean.setDataFromJSON(json);
		ThreadTaskManage dao = new ThreadTaskManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseThreadTaskManage bean = new BaseThreadTaskManage();
		bean.setDataFromJSON(json);
		ThreadTaskManage dao = new ThreadTaskManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseThreadTaskManage bean = new BaseThreadTaskManage();
		bean.setDataFromJSON(json);
		ThreadTaskManage dao = new ThreadTaskManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseThreadTaskManage bean = new BaseThreadTaskManage();
		bean.setDataFromJSON(json);
		ThreadTaskManage dao = new ThreadTaskManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


