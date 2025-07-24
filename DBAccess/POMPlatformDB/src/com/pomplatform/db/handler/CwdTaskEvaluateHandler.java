package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdTaskEvaluate;
import com.pomplatform.db.dao.CwdTaskEvaluate;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdTaskEvaluateHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdTaskEvaluateHandler.class);

	public static BaseCwdTaskEvaluate getCwdTaskEvaluateById( 
		java.lang.Integer cwd_task_evaluate_id
	) throws Exception
	{
		CwdTaskEvaluate dao = new CwdTaskEvaluate();
		dao.setCwdTaskEvaluateId(cwd_task_evaluate_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdTaskEvaluateExists( com.pomplatform.db.bean.BaseCwdTaskEvaluate bean, String additional ) throws Exception {

		CwdTaskEvaluate dao = new CwdTaskEvaluate();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdTaskEvaluate( com.pomplatform.db.bean.BaseCwdTaskEvaluate bean, String additional ) throws Exception {

		CwdTaskEvaluate dao = new CwdTaskEvaluate();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdTaskEvaluate> queryCwdTaskEvaluate( com.pomplatform.db.bean.BaseCwdTaskEvaluate bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdTaskEvaluate dao = new CwdTaskEvaluate();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdTaskEvaluate> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdTaskEvaluate> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdTaskEvaluate addToCwdTaskEvaluate ( BaseCwdTaskEvaluate cwdtaskevaluate )  throws Exception {
		return addToCwdTaskEvaluate ( cwdtaskevaluate , false);
	}

	public static BaseCwdTaskEvaluate addToCwdTaskEvaluate ( BaseCwdTaskEvaluate cwdtaskevaluate, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdTaskEvaluate dao = new CwdTaskEvaluate();
		dao.setDataFromBase(cwdtaskevaluate);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdTaskEvaluate addUpdateCwdTaskEvaluate ( BaseCwdTaskEvaluate cwdtaskevaluate ) throws Exception {
		return addUpdateCwdTaskEvaluate ( cwdtaskevaluate , false);
	}

	public static BaseCwdTaskEvaluate addUpdateCwdTaskEvaluate ( BaseCwdTaskEvaluate cwdtaskevaluate, boolean singleTransaction  ) throws Exception {
		if(cwdtaskevaluate.getCwdTaskEvaluateId() == null) return addToCwdTaskEvaluate(cwdtaskevaluate);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdTaskEvaluate dao = new CwdTaskEvaluate();
		dao.setDataFromBase(cwdtaskevaluate);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdtaskevaluate); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdTaskEvaluate ( BaseCwdTaskEvaluate bean ) throws Exception {
		CwdTaskEvaluate dao = new CwdTaskEvaluate();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdTaskEvaluate updateCwdTaskEvaluate ( BaseCwdTaskEvaluate cwdtaskevaluate ) throws Exception {
		CwdTaskEvaluate dao = new CwdTaskEvaluate();
		dao.setCwdTaskEvaluateId( cwdtaskevaluate.getCwdTaskEvaluateId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdtaskevaluate);
			result = dao.update();
		}
		return result == 1 ? cwdtaskevaluate : null ;
	}

	public static BaseCwdTaskEvaluate updateCwdTaskEvaluateDirect( BaseCwdTaskEvaluate cwdtaskevaluate ) throws Exception {
		CwdTaskEvaluate dao = new CwdTaskEvaluate();
		int result = 0;
		dao.setDataFromBase(cwdtaskevaluate);
		result = dao.update();
		return result == 1 ? cwdtaskevaluate : null ;
	}

	public static int setDeleteConditions(BaseCwdTaskEvaluate bean, CwdTaskEvaluate dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdTaskEvaluateId() != null) {
			dao.setConditionCwdTaskEvaluateId("=", bean.getCwdTaskEvaluateId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCwdTaskProcessId() != null) {
				dao.setConditionCwdTaskProcessId("=", bean.getCwdTaskProcessId());
				count++;
			}
			if(bean.getCwdTaskManageId() != null) {
				dao.setConditionCwdTaskManageId("=", bean.getCwdTaskManageId());
				count++;
			}
			if(bean.getEvaluateContent() != null) {
				dao.setConditionEvaluateContent("=", bean.getEvaluateContent());
				count++;
			}
			if(bean.getTaskGrade() != null) {
				dao.setConditionTaskGrade("=", bean.getTaskGrade());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdTaskEvaluate bean, CwdTaskEvaluate dao){
		int count = 0;
		if(bean.getCwdTaskEvaluateId() != null) {
			dao.setConditionCwdTaskEvaluateId("=", bean.getCwdTaskEvaluateId());
			count++;
		}
		if(bean.getCwdTaskProcessId() != null) {
			dao.setConditionCwdTaskProcessId("=", bean.getCwdTaskProcessId());
			count++;
		}
		if(bean.getCwdTaskManageId() != null) {
			dao.setConditionCwdTaskManageId("=", bean.getCwdTaskManageId());
			count++;
		}
		if(bean.getEvaluateContent() != null) {
			if(bean.getEvaluateContent().indexOf("%") >= 0)
				dao.setConditionEvaluateContent("like", bean.getEvaluateContent());
			else
				dao.setConditionEvaluateContent("=", bean.getEvaluateContent());
			count++;
		}
		if(bean.getTaskGrade() != null) {
			dao.setConditionTaskGrade("=", bean.getTaskGrade());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
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
		BaseCwdTaskEvaluate bean = new BaseCwdTaskEvaluate();
		bean.setDataFromJSON(json);
		CwdTaskEvaluate dao = new CwdTaskEvaluate();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdTaskEvaluate> rlist = new BaseCollection<>();
		BaseCwdTaskEvaluate bean = new BaseCwdTaskEvaluate();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdTaskEvaluate dao = new CwdTaskEvaluate();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdTaskEvaluate> result = dao.conditionalLoad(addtion);
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
		BaseCwdTaskEvaluate bean = new BaseCwdTaskEvaluate();
		bean.setDataFromJSON(json);
		CwdTaskEvaluate dao = new CwdTaskEvaluate();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdTaskEvaluate bean = new BaseCwdTaskEvaluate();
		bean.setDataFromJSON(json);
		CwdTaskEvaluate dao = new CwdTaskEvaluate();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdTaskEvaluate bean = new BaseCwdTaskEvaluate();
		bean.setDataFromJSON(json);
		CwdTaskEvaluate dao = new CwdTaskEvaluate();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdTaskEvaluate bean = new BaseCwdTaskEvaluate();
		bean.setDataFromJSON(json);
		CwdTaskEvaluate dao = new CwdTaskEvaluate();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


