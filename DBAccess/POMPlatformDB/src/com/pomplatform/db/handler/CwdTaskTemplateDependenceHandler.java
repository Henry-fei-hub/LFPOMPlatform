package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdTaskTemplateDependence;
import com.pomplatform.db.dao.CwdTaskTemplateDependence;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdTaskTemplateDependenceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdTaskTemplateDependenceHandler.class);

	public static BaseCwdTaskTemplateDependence getCwdTaskTemplateDependenceById( 
		java.lang.Integer cwd_task_template_dependence_id
	) throws Exception
	{
		CwdTaskTemplateDependence dao = new CwdTaskTemplateDependence();
		dao.setCwdTaskTemplateDependenceId(cwd_task_template_dependence_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdTaskTemplateDependenceExists( com.pomplatform.db.bean.BaseCwdTaskTemplateDependence bean, String additional ) throws Exception {

		CwdTaskTemplateDependence dao = new CwdTaskTemplateDependence();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdTaskTemplateDependence( com.pomplatform.db.bean.BaseCwdTaskTemplateDependence bean, String additional ) throws Exception {

		CwdTaskTemplateDependence dao = new CwdTaskTemplateDependence();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdTaskTemplateDependence> queryCwdTaskTemplateDependence( com.pomplatform.db.bean.BaseCwdTaskTemplateDependence bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdTaskTemplateDependence dao = new CwdTaskTemplateDependence();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdTaskTemplateDependence> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdTaskTemplateDependence> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdTaskTemplateDependence addToCwdTaskTemplateDependence ( BaseCwdTaskTemplateDependence cwdtasktemplatedependence )  throws Exception {
		return addToCwdTaskTemplateDependence ( cwdtasktemplatedependence , false);
	}

	public static BaseCwdTaskTemplateDependence addToCwdTaskTemplateDependence ( BaseCwdTaskTemplateDependence cwdtasktemplatedependence, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdTaskTemplateDependence dao = new CwdTaskTemplateDependence();
		dao.setDataFromBase(cwdtasktemplatedependence);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdTaskTemplateDependence addUpdateCwdTaskTemplateDependence ( BaseCwdTaskTemplateDependence cwdtasktemplatedependence ) throws Exception {
		return addUpdateCwdTaskTemplateDependence ( cwdtasktemplatedependence , false);
	}

	public static BaseCwdTaskTemplateDependence addUpdateCwdTaskTemplateDependence ( BaseCwdTaskTemplateDependence cwdtasktemplatedependence, boolean singleTransaction  ) throws Exception {
		if(cwdtasktemplatedependence.getCwdTaskTemplateDependenceId() == null) return addToCwdTaskTemplateDependence(cwdtasktemplatedependence);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdTaskTemplateDependence dao = new CwdTaskTemplateDependence();
		dao.setDataFromBase(cwdtasktemplatedependence);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdtasktemplatedependence); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdTaskTemplateDependence ( BaseCwdTaskTemplateDependence bean ) throws Exception {
		CwdTaskTemplateDependence dao = new CwdTaskTemplateDependence();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdTaskTemplateDependence updateCwdTaskTemplateDependence ( BaseCwdTaskTemplateDependence cwdtasktemplatedependence ) throws Exception {
		CwdTaskTemplateDependence dao = new CwdTaskTemplateDependence();
		dao.setCwdTaskTemplateDependenceId( cwdtasktemplatedependence.getCwdTaskTemplateDependenceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdtasktemplatedependence);
			result = dao.update();
		}
		return result == 1 ? cwdtasktemplatedependence : null ;
	}

	public static BaseCwdTaskTemplateDependence updateCwdTaskTemplateDependenceDirect( BaseCwdTaskTemplateDependence cwdtasktemplatedependence ) throws Exception {
		CwdTaskTemplateDependence dao = new CwdTaskTemplateDependence();
		int result = 0;
		dao.setDataFromBase(cwdtasktemplatedependence);
		result = dao.update();
		return result == 1 ? cwdtasktemplatedependence : null ;
	}

	public static int setDeleteConditions(BaseCwdTaskTemplateDependence bean, CwdTaskTemplateDependence dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdTaskTemplateDependenceId() != null) {
			dao.setConditionCwdTaskTemplateDependenceId("=", bean.getCwdTaskTemplateDependenceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCwdTaskTemplateId() != null) {
				dao.setConditionCwdTaskTemplateId("=", bean.getCwdTaskTemplateId());
				count++;
			}
			if(bean.getPredecessorTaskId() != null) {
				dao.setConditionPredecessorTaskId("=", bean.getPredecessorTaskId());
				count++;
			}
			if(bean.getSuccessorTaskId() != null) {
				dao.setConditionSuccessorTaskId("=", bean.getSuccessorTaskId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdTaskTemplateDependence bean, CwdTaskTemplateDependence dao){
		int count = 0;
		if(bean.getCwdTaskTemplateDependenceId() != null) {
			dao.setConditionCwdTaskTemplateDependenceId("=", bean.getCwdTaskTemplateDependenceId());
			count++;
		}
		if(bean.getCwdTaskTemplateId() != null) {
			dao.setConditionCwdTaskTemplateId("=", bean.getCwdTaskTemplateId());
			count++;
		}
		if(bean.getPredecessorTaskId() != null) {
			dao.setConditionPredecessorTaskId("=", bean.getPredecessorTaskId());
			count++;
		}
		if(bean.getSuccessorTaskId() != null) {
			dao.setConditionSuccessorTaskId("=", bean.getSuccessorTaskId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdTaskTemplateDependence bean = new BaseCwdTaskTemplateDependence();
		bean.setDataFromJSON(json);
		CwdTaskTemplateDependence dao = new CwdTaskTemplateDependence();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdTaskTemplateDependence> rlist = new BaseCollection<>();
		BaseCwdTaskTemplateDependence bean = new BaseCwdTaskTemplateDependence();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdTaskTemplateDependence dao = new CwdTaskTemplateDependence();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdTaskTemplateDependence> result = dao.conditionalLoad(addtion);
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
		BaseCwdTaskTemplateDependence bean = new BaseCwdTaskTemplateDependence();
		bean.setDataFromJSON(json);
		CwdTaskTemplateDependence dao = new CwdTaskTemplateDependence();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdTaskTemplateDependence bean = new BaseCwdTaskTemplateDependence();
		bean.setDataFromJSON(json);
		CwdTaskTemplateDependence dao = new CwdTaskTemplateDependence();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdTaskTemplateDependence bean = new BaseCwdTaskTemplateDependence();
		bean.setDataFromJSON(json);
		CwdTaskTemplateDependence dao = new CwdTaskTemplateDependence();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdTaskTemplateDependence bean = new BaseCwdTaskTemplateDependence();
		bean.setDataFromJSON(json);
		CwdTaskTemplateDependence dao = new CwdTaskTemplateDependence();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


