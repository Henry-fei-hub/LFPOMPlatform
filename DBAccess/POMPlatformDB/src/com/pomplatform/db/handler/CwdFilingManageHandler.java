package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdFilingManage;
import com.pomplatform.db.dao.CwdFilingManage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdFilingManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdFilingManageHandler.class);

	public static BaseCwdFilingManage getCwdFilingManageById( 
		java.lang.Integer cwd_filing_manage_id
	) throws Exception
	{
		CwdFilingManage dao = new CwdFilingManage();
		dao.setCwdFilingManageId(cwd_filing_manage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdFilingManageExists( com.pomplatform.db.bean.BaseCwdFilingManage bean, String additional ) throws Exception {

		CwdFilingManage dao = new CwdFilingManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdFilingManage( com.pomplatform.db.bean.BaseCwdFilingManage bean, String additional ) throws Exception {

		CwdFilingManage dao = new CwdFilingManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdFilingManage> queryCwdFilingManage( com.pomplatform.db.bean.BaseCwdFilingManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdFilingManage dao = new CwdFilingManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdFilingManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdFilingManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdFilingManage addToCwdFilingManage ( BaseCwdFilingManage cwdfilingmanage )  throws Exception {
		return addToCwdFilingManage ( cwdfilingmanage , false);
	}

	public static BaseCwdFilingManage addToCwdFilingManage ( BaseCwdFilingManage cwdfilingmanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdFilingManage dao = new CwdFilingManage();
		dao.setDataFromBase(cwdfilingmanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdFilingManage addUpdateCwdFilingManage ( BaseCwdFilingManage cwdfilingmanage ) throws Exception {
		return addUpdateCwdFilingManage ( cwdfilingmanage , false);
	}

	public static BaseCwdFilingManage addUpdateCwdFilingManage ( BaseCwdFilingManage cwdfilingmanage, boolean singleTransaction  ) throws Exception {
		if(cwdfilingmanage.getCwdFilingManageId() == null) return addToCwdFilingManage(cwdfilingmanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdFilingManage dao = new CwdFilingManage();
		dao.setDataFromBase(cwdfilingmanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdfilingmanage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdFilingManage ( BaseCwdFilingManage bean ) throws Exception {
		CwdFilingManage dao = new CwdFilingManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdFilingManage updateCwdFilingManage ( BaseCwdFilingManage cwdfilingmanage ) throws Exception {
		CwdFilingManage dao = new CwdFilingManage();
		dao.setCwdFilingManageId( cwdfilingmanage.getCwdFilingManageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdfilingmanage);
			result = dao.update();
		}
		return result == 1 ? cwdfilingmanage : null ;
	}

	public static BaseCwdFilingManage updateCwdFilingManageDirect( BaseCwdFilingManage cwdfilingmanage ) throws Exception {
		CwdFilingManage dao = new CwdFilingManage();
		int result = 0;
		dao.setDataFromBase(cwdfilingmanage);
		result = dao.update();
		return result == 1 ? cwdfilingmanage : null ;
	}

	public static int setDeleteConditions(BaseCwdFilingManage bean, CwdFilingManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdFilingManageId() != null) {
			dao.setConditionCwdFilingManageId("=", bean.getCwdFilingManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getTemplateName() != null) {
				dao.setConditionTemplateName("=", bean.getTemplateName());
				count++;
			}
			if(bean.getCwdFilingTemplateId() != null) {
				dao.setConditionCwdFilingTemplateId("=", bean.getCwdFilingTemplateId());
				count++;
			}
			if(bean.getFilingType() != null) {
				dao.setConditionFilingType("=", bean.getFilingType());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdFilingManage bean, CwdFilingManage dao){
		int count = 0;
		if(bean.getCwdFilingManageId() != null) {
			dao.setConditionCwdFilingManageId("=", bean.getCwdFilingManageId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getTemplateName() != null) {
			if(bean.getTemplateName().indexOf("%") >= 0)
				dao.setConditionTemplateName("like", bean.getTemplateName());
			else
				dao.setConditionTemplateName("=", bean.getTemplateName());
			count++;
		}
		if(bean.getCwdFilingTemplateId() != null) {
			dao.setConditionCwdFilingTemplateId("=", bean.getCwdFilingTemplateId());
			count++;
		}
		if(bean.getFilingType() != null) {
			dao.setConditionFilingType("=", bean.getFilingType());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
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
		BaseCwdFilingManage bean = new BaseCwdFilingManage();
		bean.setDataFromJSON(json);
		CwdFilingManage dao = new CwdFilingManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdFilingManage> rlist = new BaseCollection<>();
		BaseCwdFilingManage bean = new BaseCwdFilingManage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdFilingManage dao = new CwdFilingManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdFilingManage> result = dao.conditionalLoad(addtion);
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
		BaseCwdFilingManage bean = new BaseCwdFilingManage();
		bean.setDataFromJSON(json);
		CwdFilingManage dao = new CwdFilingManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdFilingManage bean = new BaseCwdFilingManage();
		bean.setDataFromJSON(json);
		CwdFilingManage dao = new CwdFilingManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdFilingManage bean = new BaseCwdFilingManage();
		bean.setDataFromJSON(json);
		CwdFilingManage dao = new CwdFilingManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdFilingManage bean = new BaseCwdFilingManage();
		bean.setDataFromJSON(json);
		CwdFilingManage dao = new CwdFilingManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


