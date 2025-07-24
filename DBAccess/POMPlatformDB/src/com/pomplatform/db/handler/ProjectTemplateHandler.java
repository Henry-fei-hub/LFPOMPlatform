package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectTemplate;
import com.pomplatform.db.dao.ProjectTemplate;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectTemplateHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectTemplateHandler.class);

	public static BaseProjectTemplate getProjectTemplateById( 
		java.lang.Integer project_template_id
	) throws Exception
	{
		ProjectTemplate dao = new ProjectTemplate();
		dao.setProjectTemplateId(project_template_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectTemplateExists( com.pomplatform.db.bean.BaseProjectTemplate bean, String additional ) throws Exception {

		ProjectTemplate dao = new ProjectTemplate();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectTemplate( com.pomplatform.db.bean.BaseProjectTemplate bean, String additional ) throws Exception {

		ProjectTemplate dao = new ProjectTemplate();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectTemplate> queryProjectTemplate( com.pomplatform.db.bean.BaseProjectTemplate bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectTemplate dao = new ProjectTemplate();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectTemplate> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectTemplate> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectTemplate addToProjectTemplate ( BaseProjectTemplate projecttemplate )  throws Exception {
		return addToProjectTemplate ( projecttemplate , false);
	}

	public static BaseProjectTemplate addToProjectTemplate ( BaseProjectTemplate projecttemplate, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectTemplate dao = new ProjectTemplate();
		dao.setDataFromBase(projecttemplate);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectTemplate addUpdateProjectTemplate ( BaseProjectTemplate projecttemplate ) throws Exception {
		return addUpdateProjectTemplate ( projecttemplate , false);
	}

	public static BaseProjectTemplate addUpdateProjectTemplate ( BaseProjectTemplate projecttemplate, boolean singleTransaction  ) throws Exception {
		if(projecttemplate.getProjectTemplateId() == null) return addToProjectTemplate(projecttemplate);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectTemplate dao = new ProjectTemplate();
		dao.setDataFromBase(projecttemplate);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projecttemplate); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectTemplate ( BaseProjectTemplate bean ) throws Exception {
		ProjectTemplate dao = new ProjectTemplate();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectTemplate updateProjectTemplate ( BaseProjectTemplate projecttemplate ) throws Exception {
		ProjectTemplate dao = new ProjectTemplate();
		dao.setProjectTemplateId( projecttemplate.getProjectTemplateId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projecttemplate);
			result = dao.update();
		}
		return result == 1 ? projecttemplate : null ;
	}

	public static BaseProjectTemplate updateProjectTemplateDirect( BaseProjectTemplate projecttemplate ) throws Exception {
		ProjectTemplate dao = new ProjectTemplate();
		int result = 0;
		dao.setDataFromBase(projecttemplate);
		result = dao.update();
		return result == 1 ? projecttemplate : null ;
	}

	public static int setDeleteConditions(BaseProjectTemplate bean, ProjectTemplate dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectTemplateId() != null) {
			dao.setConditionProjectTemplateId("=", bean.getProjectTemplateId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectTemplateName() != null) {
				dao.setConditionProjectTemplateName("=", bean.getProjectTemplateName());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectTemplate bean, ProjectTemplate dao){
		int count = 0;
		if(bean.getProjectTemplateId() != null) {
			dao.setConditionProjectTemplateId("=", bean.getProjectTemplateId());
			count++;
		}
		if(bean.getProjectTemplateName() != null) {
			if(bean.getProjectTemplateName().indexOf("%") >= 0)
				dao.setConditionProjectTemplateName("like", bean.getProjectTemplateName());
			else
				dao.setConditionProjectTemplateName("=", bean.getProjectTemplateName());
			count++;
		}
		if(bean.getProjectType() != null) {
			dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectTemplate bean = new BaseProjectTemplate();
		bean.setDataFromJSON(json);
		ProjectTemplate dao = new ProjectTemplate();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectTemplate> rlist = new BaseCollection<>();
		BaseProjectTemplate bean = new BaseProjectTemplate();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectTemplate dao = new ProjectTemplate();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectTemplate> result = dao.conditionalLoad(addtion);
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
		BaseProjectTemplate bean = new BaseProjectTemplate();
		bean.setDataFromJSON(json);
		ProjectTemplate dao = new ProjectTemplate();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectTemplate bean = new BaseProjectTemplate();
		bean.setDataFromJSON(json);
		ProjectTemplate dao = new ProjectTemplate();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectTemplate bean = new BaseProjectTemplate();
		bean.setDataFromJSON(json);
		ProjectTemplate dao = new ProjectTemplate();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectTemplate bean = new BaseProjectTemplate();
		bean.setDataFromJSON(json);
		ProjectTemplate dao = new ProjectTemplate();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


