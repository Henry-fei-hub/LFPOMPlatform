package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdTaskEvaluateAttachment;
import com.pomplatform.db.dao.CwdTaskEvaluateAttachment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdTaskEvaluateAttachmentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdTaskEvaluateAttachmentHandler.class);

	public static BaseCwdTaskEvaluateAttachment getCwdTaskEvaluateAttachmentById( 
		java.lang.Integer cwd_task_evaluate_attachment_id
	) throws Exception
	{
		CwdTaskEvaluateAttachment dao = new CwdTaskEvaluateAttachment();
		dao.setCwdTaskEvaluateAttachmentId(cwd_task_evaluate_attachment_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdTaskEvaluateAttachmentExists( com.pomplatform.db.bean.BaseCwdTaskEvaluateAttachment bean, String additional ) throws Exception {

		CwdTaskEvaluateAttachment dao = new CwdTaskEvaluateAttachment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdTaskEvaluateAttachment( com.pomplatform.db.bean.BaseCwdTaskEvaluateAttachment bean, String additional ) throws Exception {

		CwdTaskEvaluateAttachment dao = new CwdTaskEvaluateAttachment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdTaskEvaluateAttachment> queryCwdTaskEvaluateAttachment( com.pomplatform.db.bean.BaseCwdTaskEvaluateAttachment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdTaskEvaluateAttachment dao = new CwdTaskEvaluateAttachment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdTaskEvaluateAttachment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdTaskEvaluateAttachment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdTaskEvaluateAttachment addToCwdTaskEvaluateAttachment ( BaseCwdTaskEvaluateAttachment cwdtaskevaluateattachment )  throws Exception {
		return addToCwdTaskEvaluateAttachment ( cwdtaskevaluateattachment , false);
	}

	public static BaseCwdTaskEvaluateAttachment addToCwdTaskEvaluateAttachment ( BaseCwdTaskEvaluateAttachment cwdtaskevaluateattachment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdTaskEvaluateAttachment dao = new CwdTaskEvaluateAttachment();
		dao.setDataFromBase(cwdtaskevaluateattachment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdTaskEvaluateAttachment addUpdateCwdTaskEvaluateAttachment ( BaseCwdTaskEvaluateAttachment cwdtaskevaluateattachment ) throws Exception {
		return addUpdateCwdTaskEvaluateAttachment ( cwdtaskevaluateattachment , false);
	}

	public static BaseCwdTaskEvaluateAttachment addUpdateCwdTaskEvaluateAttachment ( BaseCwdTaskEvaluateAttachment cwdtaskevaluateattachment, boolean singleTransaction  ) throws Exception {
		if(cwdtaskevaluateattachment.getCwdTaskEvaluateAttachmentId() == null) return addToCwdTaskEvaluateAttachment(cwdtaskevaluateattachment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdTaskEvaluateAttachment dao = new CwdTaskEvaluateAttachment();
		dao.setDataFromBase(cwdtaskevaluateattachment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdtaskevaluateattachment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdTaskEvaluateAttachment ( BaseCwdTaskEvaluateAttachment bean ) throws Exception {
		CwdTaskEvaluateAttachment dao = new CwdTaskEvaluateAttachment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdTaskEvaluateAttachment updateCwdTaskEvaluateAttachment ( BaseCwdTaskEvaluateAttachment cwdtaskevaluateattachment ) throws Exception {
		CwdTaskEvaluateAttachment dao = new CwdTaskEvaluateAttachment();
		dao.setCwdTaskEvaluateAttachmentId( cwdtaskevaluateattachment.getCwdTaskEvaluateAttachmentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdtaskevaluateattachment);
			result = dao.update();
		}
		return result == 1 ? cwdtaskevaluateattachment : null ;
	}

	public static BaseCwdTaskEvaluateAttachment updateCwdTaskEvaluateAttachmentDirect( BaseCwdTaskEvaluateAttachment cwdtaskevaluateattachment ) throws Exception {
		CwdTaskEvaluateAttachment dao = new CwdTaskEvaluateAttachment();
		int result = 0;
		dao.setDataFromBase(cwdtaskevaluateattachment);
		result = dao.update();
		return result == 1 ? cwdtaskevaluateattachment : null ;
	}

	public static int setDeleteConditions(BaseCwdTaskEvaluateAttachment bean, CwdTaskEvaluateAttachment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdTaskEvaluateAttachmentId() != null) {
			dao.setConditionCwdTaskEvaluateAttachmentId("=", bean.getCwdTaskEvaluateAttachmentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCwdTaskEvaluateId() != null) {
				dao.setConditionCwdTaskEvaluateId("=", bean.getCwdTaskEvaluateId());
				count++;
			}
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdTaskEvaluateAttachment bean, CwdTaskEvaluateAttachment dao){
		int count = 0;
		if(bean.getCwdTaskEvaluateAttachmentId() != null) {
			dao.setConditionCwdTaskEvaluateAttachmentId("=", bean.getCwdTaskEvaluateAttachmentId());
			count++;
		}
		if(bean.getCwdTaskEvaluateId() != null) {
			dao.setConditionCwdTaskEvaluateId("=", bean.getCwdTaskEvaluateId());
			count++;
		}
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
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
		BaseCwdTaskEvaluateAttachment bean = new BaseCwdTaskEvaluateAttachment();
		bean.setDataFromJSON(json);
		CwdTaskEvaluateAttachment dao = new CwdTaskEvaluateAttachment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdTaskEvaluateAttachment> rlist = new BaseCollection<>();
		BaseCwdTaskEvaluateAttachment bean = new BaseCwdTaskEvaluateAttachment();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdTaskEvaluateAttachment dao = new CwdTaskEvaluateAttachment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdTaskEvaluateAttachment> result = dao.conditionalLoad(addtion);
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
		BaseCwdTaskEvaluateAttachment bean = new BaseCwdTaskEvaluateAttachment();
		bean.setDataFromJSON(json);
		CwdTaskEvaluateAttachment dao = new CwdTaskEvaluateAttachment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdTaskEvaluateAttachment bean = new BaseCwdTaskEvaluateAttachment();
		bean.setDataFromJSON(json);
		CwdTaskEvaluateAttachment dao = new CwdTaskEvaluateAttachment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdTaskEvaluateAttachment bean = new BaseCwdTaskEvaluateAttachment();
		bean.setDataFromJSON(json);
		CwdTaskEvaluateAttachment dao = new CwdTaskEvaluateAttachment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdTaskEvaluateAttachment bean = new BaseCwdTaskEvaluateAttachment();
		bean.setDataFromJSON(json);
		CwdTaskEvaluateAttachment dao = new CwdTaskEvaluateAttachment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


