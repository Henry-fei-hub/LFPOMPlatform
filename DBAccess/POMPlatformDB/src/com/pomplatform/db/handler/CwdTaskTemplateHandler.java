package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdTaskTemplate;
import com.pomplatform.db.dao.CwdTaskTemplate;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdTaskTemplateHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdTaskTemplateHandler.class);

	public static BaseCwdTaskTemplate getCwdTaskTemplateById( 
		java.lang.Integer cwd_task_template_id
	) throws Exception
	{
		CwdTaskTemplate dao = new CwdTaskTemplate();
		dao.setCwdTaskTemplateId(cwd_task_template_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdTaskTemplateExists( com.pomplatform.db.bean.BaseCwdTaskTemplate bean, String additional ) throws Exception {

		CwdTaskTemplate dao = new CwdTaskTemplate();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdTaskTemplate( com.pomplatform.db.bean.BaseCwdTaskTemplate bean, String additional ) throws Exception {

		CwdTaskTemplate dao = new CwdTaskTemplate();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdTaskTemplate> queryCwdTaskTemplate( com.pomplatform.db.bean.BaseCwdTaskTemplate bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdTaskTemplate dao = new CwdTaskTemplate();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdTaskTemplate> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdTaskTemplate> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdTaskTemplate addToCwdTaskTemplate ( BaseCwdTaskTemplate cwdtasktemplate )  throws Exception {
		return addToCwdTaskTemplate ( cwdtasktemplate , false);
	}

	public static BaseCwdTaskTemplate addToCwdTaskTemplate ( BaseCwdTaskTemplate cwdtasktemplate, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdTaskTemplate dao = new CwdTaskTemplate();
		dao.setDataFromBase(cwdtasktemplate);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdTaskTemplate addUpdateCwdTaskTemplate ( BaseCwdTaskTemplate cwdtasktemplate ) throws Exception {
		return addUpdateCwdTaskTemplate ( cwdtasktemplate , false);
	}

	public static BaseCwdTaskTemplate addUpdateCwdTaskTemplate ( BaseCwdTaskTemplate cwdtasktemplate, boolean singleTransaction  ) throws Exception {
		if(cwdtasktemplate.getCwdTaskTemplateId() == null) return addToCwdTaskTemplate(cwdtasktemplate);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdTaskTemplate dao = new CwdTaskTemplate();
		dao.setDataFromBase(cwdtasktemplate);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdtasktemplate); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdTaskTemplate ( BaseCwdTaskTemplate bean ) throws Exception {
		CwdTaskTemplate dao = new CwdTaskTemplate();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdTaskTemplate updateCwdTaskTemplate ( BaseCwdTaskTemplate cwdtasktemplate ) throws Exception {
		CwdTaskTemplate dao = new CwdTaskTemplate();
		dao.setCwdTaskTemplateId( cwdtasktemplate.getCwdTaskTemplateId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdtasktemplate);
			result = dao.update();
		}
		return result == 1 ? cwdtasktemplate : null ;
	}

	public static BaseCwdTaskTemplate updateCwdTaskTemplateDirect( BaseCwdTaskTemplate cwdtasktemplate ) throws Exception {
		CwdTaskTemplate dao = new CwdTaskTemplate();
		int result = 0;
		dao.setDataFromBase(cwdtasktemplate);
		result = dao.update();
		return result == 1 ? cwdtasktemplate : null ;
	}

	public static int setDeleteConditions(BaseCwdTaskTemplate bean, CwdTaskTemplate dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdTaskTemplateId() != null) {
			dao.setConditionCwdTaskTemplateId("=", bean.getCwdTaskTemplateId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTemplateName() != null) {
				dao.setConditionTemplateName("=", bean.getTemplateName());
				count++;
			}
			if(bean.getProjectArea() != null) {
				dao.setConditionProjectArea("=", bean.getProjectArea());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getCompanyNo() != null) {
				dao.setConditionCompanyNo("=", bean.getCompanyNo());
				count++;
			}
			if(bean.getNumberOfDay() != null) {
				dao.setConditionNumberOfDay("=", bean.getNumberOfDay());
				count++;
			}
			if(bean.getProjectLevel() != null) {
				dao.setConditionProjectLevel("=", bean.getProjectLevel());
				count++;
			}
			if(bean.getNumberOfParticipant() != null) {
				dao.setConditionNumberOfParticipant("=", bean.getNumberOfParticipant());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdTaskTemplate bean, CwdTaskTemplate dao){
		int count = 0;
		if(bean.getCwdTaskTemplateId() != null) {
			dao.setConditionCwdTaskTemplateId("=", bean.getCwdTaskTemplateId());
			count++;
		}
		if(bean.getTemplateName() != null) {
			if(bean.getTemplateName().indexOf("%") >= 0)
				dao.setConditionTemplateName("like", bean.getTemplateName());
			else
				dao.setConditionTemplateName("=", bean.getTemplateName());
			count++;
		}
		if(bean.getProjectArea() != null) {
			dao.setConditionProjectArea("=", bean.getProjectArea());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getCompanyNo() != null) {
			if(bean.getCompanyNo().indexOf("%") >= 0)
				dao.setConditionCompanyNo("like", bean.getCompanyNo());
			else
				dao.setConditionCompanyNo("=", bean.getCompanyNo());
			count++;
		}
		if(bean.getNumberOfDay() != null) {
			dao.setConditionNumberOfDay("=", bean.getNumberOfDay());
			count++;
		}
		if(bean.getProjectLevel() != null) {
			dao.setConditionProjectLevel("=", bean.getProjectLevel());
			count++;
		}
		if(bean.getNumberOfParticipant() != null) {
			dao.setConditionNumberOfParticipant("=", bean.getNumberOfParticipant());
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
		BaseCwdTaskTemplate bean = new BaseCwdTaskTemplate();
		bean.setDataFromJSON(json);
		CwdTaskTemplate dao = new CwdTaskTemplate();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdTaskTemplate> rlist = new BaseCollection<>();
		BaseCwdTaskTemplate bean = new BaseCwdTaskTemplate();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdTaskTemplate dao = new CwdTaskTemplate();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdTaskTemplate> result = dao.conditionalLoad(addtion);
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
		BaseCwdTaskTemplate bean = new BaseCwdTaskTemplate();
		bean.setDataFromJSON(json);
		CwdTaskTemplate dao = new CwdTaskTemplate();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdTaskTemplate bean = new BaseCwdTaskTemplate();
		bean.setDataFromJSON(json);
		CwdTaskTemplate dao = new CwdTaskTemplate();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdTaskTemplate bean = new BaseCwdTaskTemplate();
		bean.setDataFromJSON(json);
		CwdTaskTemplate dao = new CwdTaskTemplate();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdTaskTemplate bean = new BaseCwdTaskTemplate();
		bean.setDataFromJSON(json);
		CwdTaskTemplate dao = new CwdTaskTemplate();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


