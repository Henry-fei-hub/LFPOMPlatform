package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdTaskTemplateDetail;
import com.pomplatform.db.dao.CwdTaskTemplateDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdTaskTemplateDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdTaskTemplateDetailHandler.class);

	public static BaseCwdTaskTemplateDetail getCwdTaskTemplateDetailById( 
		java.lang.Integer cwd_task_template_detail_id
	) throws Exception
	{
		CwdTaskTemplateDetail dao = new CwdTaskTemplateDetail();
		dao.setCwdTaskTemplateDetailId(cwd_task_template_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdTaskTemplateDetailExists( com.pomplatform.db.bean.BaseCwdTaskTemplateDetail bean, String additional ) throws Exception {

		CwdTaskTemplateDetail dao = new CwdTaskTemplateDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdTaskTemplateDetail( com.pomplatform.db.bean.BaseCwdTaskTemplateDetail bean, String additional ) throws Exception {

		CwdTaskTemplateDetail dao = new CwdTaskTemplateDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdTaskTemplateDetail> queryCwdTaskTemplateDetail( com.pomplatform.db.bean.BaseCwdTaskTemplateDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdTaskTemplateDetail dao = new CwdTaskTemplateDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdTaskTemplateDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdTaskTemplateDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdTaskTemplateDetail addToCwdTaskTemplateDetail ( BaseCwdTaskTemplateDetail cwdtasktemplatedetail )  throws Exception {
		return addToCwdTaskTemplateDetail ( cwdtasktemplatedetail , false);
	}

	public static BaseCwdTaskTemplateDetail addToCwdTaskTemplateDetail ( BaseCwdTaskTemplateDetail cwdtasktemplatedetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdTaskTemplateDetail dao = new CwdTaskTemplateDetail();
		dao.setDataFromBase(cwdtasktemplatedetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdTaskTemplateDetail addUpdateCwdTaskTemplateDetail ( BaseCwdTaskTemplateDetail cwdtasktemplatedetail ) throws Exception {
		return addUpdateCwdTaskTemplateDetail ( cwdtasktemplatedetail , false);
	}

	public static BaseCwdTaskTemplateDetail addUpdateCwdTaskTemplateDetail ( BaseCwdTaskTemplateDetail cwdtasktemplatedetail, boolean singleTransaction  ) throws Exception {
		if(cwdtasktemplatedetail.getCwdTaskTemplateDetailId() == null) return addToCwdTaskTemplateDetail(cwdtasktemplatedetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdTaskTemplateDetail dao = new CwdTaskTemplateDetail();
		dao.setDataFromBase(cwdtasktemplatedetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdtasktemplatedetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdTaskTemplateDetail ( BaseCwdTaskTemplateDetail bean ) throws Exception {
		CwdTaskTemplateDetail dao = new CwdTaskTemplateDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdTaskTemplateDetail updateCwdTaskTemplateDetail ( BaseCwdTaskTemplateDetail cwdtasktemplatedetail ) throws Exception {
		CwdTaskTemplateDetail dao = new CwdTaskTemplateDetail();
		dao.setCwdTaskTemplateDetailId( cwdtasktemplatedetail.getCwdTaskTemplateDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdtasktemplatedetail);
			result = dao.update();
		}
		return result == 1 ? cwdtasktemplatedetail : null ;
	}

	public static BaseCwdTaskTemplateDetail updateCwdTaskTemplateDetailDirect( BaseCwdTaskTemplateDetail cwdtasktemplatedetail ) throws Exception {
		CwdTaskTemplateDetail dao = new CwdTaskTemplateDetail();
		int result = 0;
		dao.setDataFromBase(cwdtasktemplatedetail);
		result = dao.update();
		return result == 1 ? cwdtasktemplatedetail : null ;
	}

	public static int setDeleteConditions(BaseCwdTaskTemplateDetail bean, CwdTaskTemplateDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdTaskTemplateDetailId() != null) {
			dao.setConditionCwdTaskTemplateDetailId("=", bean.getCwdTaskTemplateDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCwdTaskTemplateId() != null) {
				dao.setConditionCwdTaskTemplateId("=", bean.getCwdTaskTemplateId());
				count++;
			}
			if(bean.getTaskName() != null) {
				dao.setConditionTaskName("=", bean.getTaskName());
				count++;
			}
			if(bean.getTaskContent() != null) {
				dao.setConditionTaskContent("=", bean.getTaskContent());
				count++;
			}
			if(bean.getTaskDemand() != null) {
				dao.setConditionTaskDemand("=", bean.getTaskDemand());
				count++;
			}
			if(bean.getNumberOfDay() != null) {
				dao.setConditionNumberOfDay("=", bean.getNumberOfDay());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getOrderNum() != null) {
				dao.setConditionOrderNum("=", bean.getOrderNum());
				count++;
			}
			if(bean.getTaskType() != null) {
				dao.setConditionTaskType("=", bean.getTaskType());
				count++;
			}
			if(bean.getTaskLevel() != null) {
				dao.setConditionTaskLevel("=", bean.getTaskLevel());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdTaskTemplateDetail bean, CwdTaskTemplateDetail dao){
		int count = 0;
		if(bean.getCwdTaskTemplateDetailId() != null) {
			dao.setConditionCwdTaskTemplateDetailId("=", bean.getCwdTaskTemplateDetailId());
			count++;
		}
		if(bean.getCwdTaskTemplateId() != null) {
			dao.setConditionCwdTaskTemplateId("=", bean.getCwdTaskTemplateId());
			count++;
		}
		if(bean.getTaskName() != null) {
			if(bean.getTaskName().indexOf("%") >= 0)
				dao.setConditionTaskName("like", bean.getTaskName());
			else
				dao.setConditionTaskName("=", bean.getTaskName());
			count++;
		}
		if(bean.getTaskContent() != null) {
			if(bean.getTaskContent().indexOf("%") >= 0)
				dao.setConditionTaskContent("like", bean.getTaskContent());
			else
				dao.setConditionTaskContent("=", bean.getTaskContent());
			count++;
		}
		if(bean.getTaskDemand() != null) {
			if(bean.getTaskDemand().indexOf("%") >= 0)
				dao.setConditionTaskDemand("like", bean.getTaskDemand());
			else
				dao.setConditionTaskDemand("=", bean.getTaskDemand());
			count++;
		}
		if(bean.getNumberOfDay() != null) {
			dao.setConditionNumberOfDay("=", bean.getNumberOfDay());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getOrderNum() != null) {
			dao.setConditionOrderNum("=", bean.getOrderNum());
			count++;
		}
		if(bean.getTaskType() != null) {
			dao.setConditionTaskType("=", bean.getTaskType());
			count++;
		}
		if(bean.getTaskLevel() != null) {
			dao.setConditionTaskLevel("=", bean.getTaskLevel());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdTaskTemplateDetail bean = new BaseCwdTaskTemplateDetail();
		bean.setDataFromJSON(json);
		CwdTaskTemplateDetail dao = new CwdTaskTemplateDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdTaskTemplateDetail> rlist = new BaseCollection<>();
		BaseCwdTaskTemplateDetail bean = new BaseCwdTaskTemplateDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdTaskTemplateDetail dao = new CwdTaskTemplateDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdTaskTemplateDetail> result = dao.conditionalLoad(addtion);
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
		BaseCwdTaskTemplateDetail bean = new BaseCwdTaskTemplateDetail();
		bean.setDataFromJSON(json);
		CwdTaskTemplateDetail dao = new CwdTaskTemplateDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdTaskTemplateDetail bean = new BaseCwdTaskTemplateDetail();
		bean.setDataFromJSON(json);
		CwdTaskTemplateDetail dao = new CwdTaskTemplateDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdTaskTemplateDetail bean = new BaseCwdTaskTemplateDetail();
		bean.setDataFromJSON(json);
		CwdTaskTemplateDetail dao = new CwdTaskTemplateDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdTaskTemplateDetail bean = new BaseCwdTaskTemplateDetail();
		bean.setDataFromJSON(json);
		CwdTaskTemplateDetail dao = new CwdTaskTemplateDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


