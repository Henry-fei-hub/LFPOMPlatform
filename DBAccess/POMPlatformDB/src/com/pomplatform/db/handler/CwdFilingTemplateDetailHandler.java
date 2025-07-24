package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdFilingTemplateDetail;
import com.pomplatform.db.dao.CwdFilingTemplateDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdFilingTemplateDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdFilingTemplateDetailHandler.class);

	public static BaseCwdFilingTemplateDetail getCwdFilingTemplateDetailById( 
		java.lang.Integer cwd_filing_template_detail_id
	) throws Exception
	{
		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		dao.setCwdFilingTemplateDetailId(cwd_filing_template_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdFilingTemplateDetailExists( com.pomplatform.db.bean.BaseCwdFilingTemplateDetail bean, String additional ) throws Exception {

		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdFilingTemplateDetail( com.pomplatform.db.bean.BaseCwdFilingTemplateDetail bean, String additional ) throws Exception {

		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdFilingTemplateDetail> queryCwdFilingTemplateDetail( com.pomplatform.db.bean.BaseCwdFilingTemplateDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdFilingTemplateDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdFilingTemplateDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdFilingTemplateDetail addToCwdFilingTemplateDetail ( BaseCwdFilingTemplateDetail cwdfilingtemplatedetail )  throws Exception {
		return addToCwdFilingTemplateDetail ( cwdfilingtemplatedetail , false);
	}

	public static BaseCwdFilingTemplateDetail addToCwdFilingTemplateDetail ( BaseCwdFilingTemplateDetail cwdfilingtemplatedetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		dao.setDataFromBase(cwdfilingtemplatedetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdFilingTemplateDetail addUpdateCwdFilingTemplateDetail ( BaseCwdFilingTemplateDetail cwdfilingtemplatedetail ) throws Exception {
		return addUpdateCwdFilingTemplateDetail ( cwdfilingtemplatedetail , false);
	}

	public static BaseCwdFilingTemplateDetail addUpdateCwdFilingTemplateDetail ( BaseCwdFilingTemplateDetail cwdfilingtemplatedetail, boolean singleTransaction  ) throws Exception {
		if(cwdfilingtemplatedetail.getCwdFilingTemplateDetailId() == null) return addToCwdFilingTemplateDetail(cwdfilingtemplatedetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		dao.setDataFromBase(cwdfilingtemplatedetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdfilingtemplatedetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdFilingTemplateDetail ( BaseCwdFilingTemplateDetail bean ) throws Exception {
		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdFilingTemplateDetail updateCwdFilingTemplateDetail ( BaseCwdFilingTemplateDetail cwdfilingtemplatedetail ) throws Exception {
		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		dao.setCwdFilingTemplateDetailId( cwdfilingtemplatedetail.getCwdFilingTemplateDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdfilingtemplatedetail);
			result = dao.update();
		}
		return result == 1 ? cwdfilingtemplatedetail : null ;
	}

	public static BaseCwdFilingTemplateDetail updateCwdFilingTemplateDetailDirect( BaseCwdFilingTemplateDetail cwdfilingtemplatedetail ) throws Exception {
		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		int result = 0;
		dao.setDataFromBase(cwdfilingtemplatedetail);
		result = dao.update();
		return result == 1 ? cwdfilingtemplatedetail : null ;
	}

	public static int setDeleteConditions(BaseCwdFilingTemplateDetail bean, CwdFilingTemplateDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdFilingTemplateDetailId() != null) {
			dao.setConditionCwdFilingTemplateDetailId("=", bean.getCwdFilingTemplateDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFileName() != null) {
				dao.setConditionFileName("=", bean.getFileName());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getCwdFilingTemplateId() != null) {
				dao.setConditionCwdFilingTemplateId("=", bean.getCwdFilingTemplateId());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdFilingTemplateDetail bean, CwdFilingTemplateDetail dao){
		int count = 0;
		if(bean.getCwdFilingTemplateDetailId() != null) {
			dao.setConditionCwdFilingTemplateDetailId("=", bean.getCwdFilingTemplateDetailId());
			count++;
		}
		if(bean.getFileName() != null) {
			if(bean.getFileName().indexOf("%") >= 0)
				dao.setConditionFileName("like", bean.getFileName());
			else
				dao.setConditionFileName("=", bean.getFileName());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getCwdFilingTemplateId() != null) {
			dao.setConditionCwdFilingTemplateId("=", bean.getCwdFilingTemplateId());
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
		BaseCwdFilingTemplateDetail bean = new BaseCwdFilingTemplateDetail();
		bean.setDataFromJSON(json);
		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdFilingTemplateDetail> rlist = new BaseCollection<>();
		BaseCwdFilingTemplateDetail bean = new BaseCwdFilingTemplateDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdFilingTemplateDetail> result = dao.conditionalLoad(addtion);
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
		BaseCwdFilingTemplateDetail bean = new BaseCwdFilingTemplateDetail();
		bean.setDataFromJSON(json);
		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdFilingTemplateDetail bean = new BaseCwdFilingTemplateDetail();
		bean.setDataFromJSON(json);
		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdFilingTemplateDetail bean = new BaseCwdFilingTemplateDetail();
		bean.setDataFromJSON(json);
		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdFilingTemplateDetail bean = new BaseCwdFilingTemplateDetail();
		bean.setDataFromJSON(json);
		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


