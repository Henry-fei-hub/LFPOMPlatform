package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectQuoteTemplate;
import com.pomplatform.db.dao.ProjectQuoteTemplate;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectQuoteTemplateHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectQuoteTemplateHandler.class);

	public static BaseProjectQuoteTemplate getProjectQuoteTemplateById( 
		java.lang.Integer project_quote_template_id
	) throws Exception
	{
		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		dao.setProjectQuoteTemplateId(project_quote_template_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectQuoteTemplateExists( com.pomplatform.db.bean.BaseProjectQuoteTemplate bean, String additional ) throws Exception {

		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectQuoteTemplate( com.pomplatform.db.bean.BaseProjectQuoteTemplate bean, String additional ) throws Exception {

		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectQuoteTemplate> queryProjectQuoteTemplate( com.pomplatform.db.bean.BaseProjectQuoteTemplate bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectQuoteTemplate> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectQuoteTemplate> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectQuoteTemplate addToProjectQuoteTemplate ( BaseProjectQuoteTemplate projectquotetemplate )  throws Exception {
		return addToProjectQuoteTemplate ( projectquotetemplate , false);
	}

	public static BaseProjectQuoteTemplate addToProjectQuoteTemplate ( BaseProjectQuoteTemplate projectquotetemplate, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		dao.setDataFromBase(projectquotetemplate);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectQuoteTemplate addUpdateProjectQuoteTemplate ( BaseProjectQuoteTemplate projectquotetemplate ) throws Exception {
		return addUpdateProjectQuoteTemplate ( projectquotetemplate , false);
	}

	public static BaseProjectQuoteTemplate addUpdateProjectQuoteTemplate ( BaseProjectQuoteTemplate projectquotetemplate, boolean singleTransaction  ) throws Exception {
		if(projectquotetemplate.getProjectQuoteTemplateId() == null) return addToProjectQuoteTemplate(projectquotetemplate);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		dao.setDataFromBase(projectquotetemplate);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectquotetemplate); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectQuoteTemplate ( BaseProjectQuoteTemplate bean ) throws Exception {
		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectQuoteTemplate updateProjectQuoteTemplate ( BaseProjectQuoteTemplate projectquotetemplate ) throws Exception {
		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		dao.setProjectQuoteTemplateId( projectquotetemplate.getProjectQuoteTemplateId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectquotetemplate);
			result = dao.update();
		}
		return result == 1 ? projectquotetemplate : null ;
	}

	public static BaseProjectQuoteTemplate updateProjectQuoteTemplateDirect( BaseProjectQuoteTemplate projectquotetemplate ) throws Exception {
		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		int result = 0;
		dao.setDataFromBase(projectquotetemplate);
		result = dao.update();
		return result == 1 ? projectquotetemplate : null ;
	}

	public static int setDeleteConditions(BaseProjectQuoteTemplate bean, ProjectQuoteTemplate dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectQuoteTemplateId() != null) {
			dao.setConditionProjectQuoteTemplateId("=", bean.getProjectQuoteTemplateId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getDesignTypeName() != null) {
				dao.setConditionDesignTypeName("=", bean.getDesignTypeName());
				count++;
			}
			if(bean.getDesignContent() != null) {
				dao.setConditionDesignContent("=", bean.getDesignContent());
				count++;
			}
			if(bean.getDesignStage() != null) {
				dao.setConditionDesignStage("=", bean.getDesignStage());
				count++;
			}
			if(bean.getAreaType() != null) {
				dao.setConditionAreaType("=", bean.getAreaType());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getProjectQuoteTemplatesParentId() != null) {
				dao.setConditionProjectQuoteTemplatesParentId("=", bean.getProjectQuoteTemplatesParentId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectQuoteTemplate bean, ProjectQuoteTemplate dao){
		int count = 0;
		if(bean.getProjectQuoteTemplateId() != null) {
			dao.setConditionProjectQuoteTemplateId("=", bean.getProjectQuoteTemplateId());
			count++;
		}
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getDesignTypeName() != null) {
			if(bean.getDesignTypeName().indexOf("%") >= 0)
				dao.setConditionDesignTypeName("like", bean.getDesignTypeName());
			else
				dao.setConditionDesignTypeName("=", bean.getDesignTypeName());
			count++;
		}
		if(bean.getDesignContent() != null) {
			if(bean.getDesignContent().indexOf("%") >= 0)
				dao.setConditionDesignContent("like", bean.getDesignContent());
			else
				dao.setConditionDesignContent("=", bean.getDesignContent());
			count++;
		}
		if(bean.getDesignStage() != null) {
			dao.setConditionDesignStage("=", bean.getDesignStage());
			count++;
		}
		if(bean.getAreaType() != null) {
			dao.setConditionAreaType("=", bean.getAreaType());
			count++;
		}
		if(bean.getTax() != null) {
			dao.setConditionTax("=", bean.getTax());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getProjectQuoteTemplatesParentId() != null) {
			dao.setConditionProjectQuoteTemplatesParentId("=", bean.getProjectQuoteTemplatesParentId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectQuoteTemplate bean = new BaseProjectQuoteTemplate();
		bean.setDataFromJSON(json);
		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectQuoteTemplate> rlist = new BaseCollection<>();
		BaseProjectQuoteTemplate bean = new BaseProjectQuoteTemplate();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectQuoteTemplate> result = dao.conditionalLoad(addtion);
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
		BaseProjectQuoteTemplate bean = new BaseProjectQuoteTemplate();
		bean.setDataFromJSON(json);
		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectQuoteTemplate bean = new BaseProjectQuoteTemplate();
		bean.setDataFromJSON(json);
		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectQuoteTemplate bean = new BaseProjectQuoteTemplate();
		bean.setDataFromJSON(json);
		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectQuoteTemplate bean = new BaseProjectQuoteTemplate();
		bean.setDataFromJSON(json);
		ProjectQuoteTemplate dao = new ProjectQuoteTemplate();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


