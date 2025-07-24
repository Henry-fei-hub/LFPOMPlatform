package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdFilingManageDetail;
import com.pomplatform.db.dao.CwdFilingManageDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdFilingManageDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdFilingManageDetailHandler.class);

	public static BaseCwdFilingManageDetail getCwdFilingManageDetailById( 
		java.lang.Integer cwd_filing_manage_detail_id
	) throws Exception
	{
		CwdFilingManageDetail dao = new CwdFilingManageDetail();
		dao.setCwdFilingManageDetailId(cwd_filing_manage_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdFilingManageDetailExists( com.pomplatform.db.bean.BaseCwdFilingManageDetail bean, String additional ) throws Exception {

		CwdFilingManageDetail dao = new CwdFilingManageDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdFilingManageDetail( com.pomplatform.db.bean.BaseCwdFilingManageDetail bean, String additional ) throws Exception {

		CwdFilingManageDetail dao = new CwdFilingManageDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdFilingManageDetail> queryCwdFilingManageDetail( com.pomplatform.db.bean.BaseCwdFilingManageDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdFilingManageDetail dao = new CwdFilingManageDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdFilingManageDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdFilingManageDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdFilingManageDetail addToCwdFilingManageDetail ( BaseCwdFilingManageDetail cwdfilingmanagedetail )  throws Exception {
		return addToCwdFilingManageDetail ( cwdfilingmanagedetail , false);
	}

	public static BaseCwdFilingManageDetail addToCwdFilingManageDetail ( BaseCwdFilingManageDetail cwdfilingmanagedetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdFilingManageDetail dao = new CwdFilingManageDetail();
		dao.setDataFromBase(cwdfilingmanagedetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdFilingManageDetail addUpdateCwdFilingManageDetail ( BaseCwdFilingManageDetail cwdfilingmanagedetail ) throws Exception {
		return addUpdateCwdFilingManageDetail ( cwdfilingmanagedetail , false);
	}

	public static BaseCwdFilingManageDetail addUpdateCwdFilingManageDetail ( BaseCwdFilingManageDetail cwdfilingmanagedetail, boolean singleTransaction  ) throws Exception {
		if(cwdfilingmanagedetail.getCwdFilingManageDetailId() == null) return addToCwdFilingManageDetail(cwdfilingmanagedetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdFilingManageDetail dao = new CwdFilingManageDetail();
		dao.setDataFromBase(cwdfilingmanagedetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdfilingmanagedetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdFilingManageDetail ( BaseCwdFilingManageDetail bean ) throws Exception {
		CwdFilingManageDetail dao = new CwdFilingManageDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdFilingManageDetail updateCwdFilingManageDetail ( BaseCwdFilingManageDetail cwdfilingmanagedetail ) throws Exception {
		CwdFilingManageDetail dao = new CwdFilingManageDetail();
		dao.setCwdFilingManageDetailId( cwdfilingmanagedetail.getCwdFilingManageDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdfilingmanagedetail);
			result = dao.update();
		}
		return result == 1 ? cwdfilingmanagedetail : null ;
	}

	public static BaseCwdFilingManageDetail updateCwdFilingManageDetailDirect( BaseCwdFilingManageDetail cwdfilingmanagedetail ) throws Exception {
		CwdFilingManageDetail dao = new CwdFilingManageDetail();
		int result = 0;
		dao.setDataFromBase(cwdfilingmanagedetail);
		result = dao.update();
		return result == 1 ? cwdfilingmanagedetail : null ;
	}

	public static int setDeleteConditions(BaseCwdFilingManageDetail bean, CwdFilingManageDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdFilingManageDetailId() != null) {
			dao.setConditionCwdFilingManageDetailId("=", bean.getCwdFilingManageDetailId());
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
			if(bean.getCwdFilingManageId() != null) {
				dao.setConditionCwdFilingManageId("=", bean.getCwdFilingManageId());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdFilingManageDetail bean, CwdFilingManageDetail dao){
		int count = 0;
		if(bean.getCwdFilingManageDetailId() != null) {
			dao.setConditionCwdFilingManageDetailId("=", bean.getCwdFilingManageDetailId());
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
		if(bean.getCwdFilingManageId() != null) {
			dao.setConditionCwdFilingManageId("=", bean.getCwdFilingManageId());
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
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdFilingManageDetail bean = new BaseCwdFilingManageDetail();
		bean.setDataFromJSON(json);
		CwdFilingManageDetail dao = new CwdFilingManageDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdFilingManageDetail> rlist = new BaseCollection<>();
		BaseCwdFilingManageDetail bean = new BaseCwdFilingManageDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdFilingManageDetail dao = new CwdFilingManageDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdFilingManageDetail> result = dao.conditionalLoad(addtion);
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
		BaseCwdFilingManageDetail bean = new BaseCwdFilingManageDetail();
		bean.setDataFromJSON(json);
		CwdFilingManageDetail dao = new CwdFilingManageDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdFilingManageDetail bean = new BaseCwdFilingManageDetail();
		bean.setDataFromJSON(json);
		CwdFilingManageDetail dao = new CwdFilingManageDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdFilingManageDetail bean = new BaseCwdFilingManageDetail();
		bean.setDataFromJSON(json);
		CwdFilingManageDetail dao = new CwdFilingManageDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdFilingManageDetail bean = new BaseCwdFilingManageDetail();
		bean.setDataFromJSON(json);
		CwdFilingManageDetail dao = new CwdFilingManageDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


