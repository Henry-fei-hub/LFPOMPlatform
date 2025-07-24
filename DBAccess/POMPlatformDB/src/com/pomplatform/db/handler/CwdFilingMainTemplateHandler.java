package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdFilingMainTemplate;
import com.pomplatform.db.dao.CwdFilingMainTemplate;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdFilingMainTemplateHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdFilingMainTemplateHandler.class);

	public static BaseCwdFilingMainTemplate getCwdFilingMainTemplateById( 
		java.lang.Integer cwd_filing_main_template_id
	) throws Exception
	{
		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		dao.setCwdFilingMainTemplateId(cwd_filing_main_template_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdFilingMainTemplateExists( com.pomplatform.db.bean.BaseCwdFilingMainTemplate bean, String additional ) throws Exception {

		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdFilingMainTemplate( com.pomplatform.db.bean.BaseCwdFilingMainTemplate bean, String additional ) throws Exception {

		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdFilingMainTemplate> queryCwdFilingMainTemplate( com.pomplatform.db.bean.BaseCwdFilingMainTemplate bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdFilingMainTemplate> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdFilingMainTemplate> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdFilingMainTemplate addToCwdFilingMainTemplate ( BaseCwdFilingMainTemplate cwdfilingmaintemplate )  throws Exception {
		return addToCwdFilingMainTemplate ( cwdfilingmaintemplate , false);
	}

	public static BaseCwdFilingMainTemplate addToCwdFilingMainTemplate ( BaseCwdFilingMainTemplate cwdfilingmaintemplate, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		dao.setDataFromBase(cwdfilingmaintemplate);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdFilingMainTemplate addUpdateCwdFilingMainTemplate ( BaseCwdFilingMainTemplate cwdfilingmaintemplate ) throws Exception {
		return addUpdateCwdFilingMainTemplate ( cwdfilingmaintemplate , false);
	}

	public static BaseCwdFilingMainTemplate addUpdateCwdFilingMainTemplate ( BaseCwdFilingMainTemplate cwdfilingmaintemplate, boolean singleTransaction  ) throws Exception {
		if(cwdfilingmaintemplate.getCwdFilingMainTemplateId() == null) return addToCwdFilingMainTemplate(cwdfilingmaintemplate);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		dao.setDataFromBase(cwdfilingmaintemplate);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdfilingmaintemplate); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdFilingMainTemplate ( BaseCwdFilingMainTemplate bean ) throws Exception {
		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdFilingMainTemplate updateCwdFilingMainTemplate ( BaseCwdFilingMainTemplate cwdfilingmaintemplate ) throws Exception {
		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		dao.setCwdFilingMainTemplateId( cwdfilingmaintemplate.getCwdFilingMainTemplateId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdfilingmaintemplate);
			result = dao.update();
		}
		return result == 1 ? cwdfilingmaintemplate : null ;
	}

	public static BaseCwdFilingMainTemplate updateCwdFilingMainTemplateDirect( BaseCwdFilingMainTemplate cwdfilingmaintemplate ) throws Exception {
		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		int result = 0;
		dao.setDataFromBase(cwdfilingmaintemplate);
		result = dao.update();
		return result == 1 ? cwdfilingmaintemplate : null ;
	}

	public static int setDeleteConditions(BaseCwdFilingMainTemplate bean, CwdFilingMainTemplate dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdFilingMainTemplateId() != null) {
			dao.setConditionCwdFilingMainTemplateId("=", bean.getCwdFilingMainTemplateId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTemplateName() != null) {
				dao.setConditionTemplateName("=", bean.getTemplateName());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdFilingMainTemplate bean, CwdFilingMainTemplate dao){
		int count = 0;
		if(bean.getCwdFilingMainTemplateId() != null) {
			dao.setConditionCwdFilingMainTemplateId("=", bean.getCwdFilingMainTemplateId());
			count++;
		}
		if(bean.getTemplateName() != null) {
			if(bean.getTemplateName().indexOf("%") >= 0)
				dao.setConditionTemplateName("like", bean.getTemplateName());
			else
				dao.setConditionTemplateName("=", bean.getTemplateName());
			count++;
		}
		if(bean.getProjectType() != null) {
			dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
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
		BaseCwdFilingMainTemplate bean = new BaseCwdFilingMainTemplate();
		bean.setDataFromJSON(json);
		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdFilingMainTemplate> rlist = new BaseCollection<>();
		BaseCwdFilingMainTemplate bean = new BaseCwdFilingMainTemplate();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdFilingMainTemplate> result = dao.conditionalLoad(addtion);
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
		BaseCwdFilingMainTemplate bean = new BaseCwdFilingMainTemplate();
		bean.setDataFromJSON(json);
		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdFilingMainTemplate bean = new BaseCwdFilingMainTemplate();
		bean.setDataFromJSON(json);
		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdFilingMainTemplate bean = new BaseCwdFilingMainTemplate();
		bean.setDataFromJSON(json);
		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdFilingMainTemplate bean = new BaseCwdFilingMainTemplate();
		bean.setDataFromJSON(json);
		CwdFilingMainTemplate dao = new CwdFilingMainTemplate();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


