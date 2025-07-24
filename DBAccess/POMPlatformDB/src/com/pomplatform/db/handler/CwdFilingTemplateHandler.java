package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdFilingTemplate;
import com.pomplatform.db.dao.CwdFilingTemplate;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdFilingTemplateHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdFilingTemplateHandler.class);

	public static BaseCwdFilingTemplate getCwdFilingTemplateById( 
		java.lang.Integer cwd_filing_template_id
	) throws Exception
	{
		CwdFilingTemplate dao = new CwdFilingTemplate();
		dao.setCwdFilingTemplateId(cwd_filing_template_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdFilingTemplateExists( com.pomplatform.db.bean.BaseCwdFilingTemplate bean, String additional ) throws Exception {

		CwdFilingTemplate dao = new CwdFilingTemplate();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdFilingTemplate( com.pomplatform.db.bean.BaseCwdFilingTemplate bean, String additional ) throws Exception {

		CwdFilingTemplate dao = new CwdFilingTemplate();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdFilingTemplate> queryCwdFilingTemplate( com.pomplatform.db.bean.BaseCwdFilingTemplate bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdFilingTemplate dao = new CwdFilingTemplate();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdFilingTemplate> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdFilingTemplate> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdFilingTemplate addToCwdFilingTemplate ( BaseCwdFilingTemplate cwdfilingtemplate )  throws Exception {
		return addToCwdFilingTemplate ( cwdfilingtemplate , false);
	}

	public static BaseCwdFilingTemplate addToCwdFilingTemplate ( BaseCwdFilingTemplate cwdfilingtemplate, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdFilingTemplate dao = new CwdFilingTemplate();
		dao.setDataFromBase(cwdfilingtemplate);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdFilingTemplate addUpdateCwdFilingTemplate ( BaseCwdFilingTemplate cwdfilingtemplate ) throws Exception {
		return addUpdateCwdFilingTemplate ( cwdfilingtemplate , false);
	}

	public static BaseCwdFilingTemplate addUpdateCwdFilingTemplate ( BaseCwdFilingTemplate cwdfilingtemplate, boolean singleTransaction  ) throws Exception {
		if(cwdfilingtemplate.getCwdFilingTemplateId() == null) return addToCwdFilingTemplate(cwdfilingtemplate);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdFilingTemplate dao = new CwdFilingTemplate();
		dao.setDataFromBase(cwdfilingtemplate);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdfilingtemplate); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdFilingTemplate ( BaseCwdFilingTemplate bean ) throws Exception {
		CwdFilingTemplate dao = new CwdFilingTemplate();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdFilingTemplate updateCwdFilingTemplate ( BaseCwdFilingTemplate cwdfilingtemplate ) throws Exception {
		CwdFilingTemplate dao = new CwdFilingTemplate();
		dao.setCwdFilingTemplateId( cwdfilingtemplate.getCwdFilingTemplateId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdfilingtemplate);
			result = dao.update();
		}
		return result == 1 ? cwdfilingtemplate : null ;
	}

	public static BaseCwdFilingTemplate updateCwdFilingTemplateDirect( BaseCwdFilingTemplate cwdfilingtemplate ) throws Exception {
		CwdFilingTemplate dao = new CwdFilingTemplate();
		int result = 0;
		dao.setDataFromBase(cwdfilingtemplate);
		result = dao.update();
		return result == 1 ? cwdfilingtemplate : null ;
	}

	public static int setDeleteConditions(BaseCwdFilingTemplate bean, CwdFilingTemplate dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdFilingTemplateId() != null) {
			dao.setConditionCwdFilingTemplateId("=", bean.getCwdFilingTemplateId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTemplateName() != null) {
				dao.setConditionTemplateName("=", bean.getTemplateName());
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
			if(bean.getCwdFilingMainTemplateId() != null) {
				dao.setConditionCwdFilingMainTemplateId("=", bean.getCwdFilingMainTemplateId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdFilingTemplate bean, CwdFilingTemplate dao){
		int count = 0;
		if(bean.getCwdFilingTemplateId() != null) {
			dao.setConditionCwdFilingTemplateId("=", bean.getCwdFilingTemplateId());
			count++;
		}
		if(bean.getTemplateName() != null) {
			if(bean.getTemplateName().indexOf("%") >= 0)
				dao.setConditionTemplateName("like", bean.getTemplateName());
			else
				dao.setConditionTemplateName("=", bean.getTemplateName());
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
		if(bean.getCwdFilingMainTemplateId() != null) {
			dao.setConditionCwdFilingMainTemplateId("=", bean.getCwdFilingMainTemplateId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdFilingTemplate bean = new BaseCwdFilingTemplate();
		bean.setDataFromJSON(json);
		CwdFilingTemplate dao = new CwdFilingTemplate();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdFilingTemplate> rlist = new BaseCollection<>();
		BaseCwdFilingTemplate bean = new BaseCwdFilingTemplate();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdFilingTemplate dao = new CwdFilingTemplate();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdFilingTemplate> result = dao.conditionalLoad(addtion);
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
		BaseCwdFilingTemplate bean = new BaseCwdFilingTemplate();
		bean.setDataFromJSON(json);
		CwdFilingTemplate dao = new CwdFilingTemplate();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdFilingTemplate bean = new BaseCwdFilingTemplate();
		bean.setDataFromJSON(json);
		CwdFilingTemplate dao = new CwdFilingTemplate();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdFilingTemplate bean = new BaseCwdFilingTemplate();
		bean.setDataFromJSON(json);
		CwdFilingTemplate dao = new CwdFilingTemplate();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdFilingTemplate bean = new BaseCwdFilingTemplate();
		bean.setDataFromJSON(json);
		CwdFilingTemplate dao = new CwdFilingTemplate();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


