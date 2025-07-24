package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectQuoteTemplatesParent;
import com.pomplatform.db.dao.ProjectQuoteTemplatesParent;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectQuoteTemplatesParentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectQuoteTemplatesParentHandler.class);

	public static BaseProjectQuoteTemplatesParent getProjectQuoteTemplatesParentById( 
		java.lang.Integer project_quote_templates_parent_id
	) throws Exception
	{
		ProjectQuoteTemplatesParent dao = new ProjectQuoteTemplatesParent();
		dao.setProjectQuoteTemplatesParentId(project_quote_templates_parent_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectQuoteTemplatesParentExists( com.pomplatform.db.bean.BaseProjectQuoteTemplatesParent bean, String additional ) throws Exception {

		ProjectQuoteTemplatesParent dao = new ProjectQuoteTemplatesParent();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectQuoteTemplatesParent( com.pomplatform.db.bean.BaseProjectQuoteTemplatesParent bean, String additional ) throws Exception {

		ProjectQuoteTemplatesParent dao = new ProjectQuoteTemplatesParent();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectQuoteTemplatesParent> queryProjectQuoteTemplatesParent( com.pomplatform.db.bean.BaseProjectQuoteTemplatesParent bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectQuoteTemplatesParent dao = new ProjectQuoteTemplatesParent();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectQuoteTemplatesParent> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectQuoteTemplatesParent> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectQuoteTemplatesParent addToProjectQuoteTemplatesParent ( BaseProjectQuoteTemplatesParent projectquotetemplatesparent )  throws Exception {
		return addToProjectQuoteTemplatesParent ( projectquotetemplatesparent , false);
	}

	public static BaseProjectQuoteTemplatesParent addToProjectQuoteTemplatesParent ( BaseProjectQuoteTemplatesParent projectquotetemplatesparent, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectQuoteTemplatesParent dao = new ProjectQuoteTemplatesParent();
		dao.setDataFromBase(projectquotetemplatesparent);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectQuoteTemplatesParent addUpdateProjectQuoteTemplatesParent ( BaseProjectQuoteTemplatesParent projectquotetemplatesparent ) throws Exception {
		return addUpdateProjectQuoteTemplatesParent ( projectquotetemplatesparent , false);
	}

	public static BaseProjectQuoteTemplatesParent addUpdateProjectQuoteTemplatesParent ( BaseProjectQuoteTemplatesParent projectquotetemplatesparent, boolean singleTransaction  ) throws Exception {
		if(projectquotetemplatesparent.getProjectQuoteTemplatesParentId() == null) return addToProjectQuoteTemplatesParent(projectquotetemplatesparent);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectQuoteTemplatesParent dao = new ProjectQuoteTemplatesParent();
		dao.setDataFromBase(projectquotetemplatesparent);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectquotetemplatesparent); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectQuoteTemplatesParent ( BaseProjectQuoteTemplatesParent bean ) throws Exception {
		ProjectQuoteTemplatesParent dao = new ProjectQuoteTemplatesParent();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectQuoteTemplatesParent updateProjectQuoteTemplatesParent ( BaseProjectQuoteTemplatesParent projectquotetemplatesparent ) throws Exception {
		ProjectQuoteTemplatesParent dao = new ProjectQuoteTemplatesParent();
		dao.setProjectQuoteTemplatesParentId( projectquotetemplatesparent.getProjectQuoteTemplatesParentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectquotetemplatesparent);
			result = dao.update();
		}
		return result == 1 ? projectquotetemplatesparent : null ;
	}

	public static BaseProjectQuoteTemplatesParent updateProjectQuoteTemplatesParentDirect( BaseProjectQuoteTemplatesParent projectquotetemplatesparent ) throws Exception {
		ProjectQuoteTemplatesParent dao = new ProjectQuoteTemplatesParent();
		int result = 0;
		dao.setDataFromBase(projectquotetemplatesparent);
		result = dao.update();
		return result == 1 ? projectquotetemplatesparent : null ;
	}

	public static int setDeleteConditions(BaseProjectQuoteTemplatesParent bean, ProjectQuoteTemplatesParent dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectQuoteTemplatesParentId() != null) {
			dao.setConditionProjectQuoteTemplatesParentId("=", bean.getProjectQuoteTemplatesParentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getParentName() != null) {
				dao.setConditionParentName("=", bean.getParentName());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getCreateEmployeeId() != null) {
				dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectQuoteTemplatesParent bean, ProjectQuoteTemplatesParent dao){
		int count = 0;
		if(bean.getProjectQuoteTemplatesParentId() != null) {
			dao.setConditionProjectQuoteTemplatesParentId("=", bean.getProjectQuoteTemplatesParentId());
			count++;
		}
		if(bean.getParentName() != null) {
			if(bean.getParentName().indexOf("%") >= 0)
				dao.setConditionParentName("like", bean.getParentName());
			else
				dao.setConditionParentName("=", bean.getParentName());
			count++;
		}
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getCreateEmployeeId() != null) {
			dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
			count++;
		}
		if(bean.getCreateDate() != null) {
			dao.setConditionCreateDate(">=", bean.getCreateDate());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectQuoteTemplatesParent bean = new BaseProjectQuoteTemplatesParent();
		bean.setDataFromJSON(json);
		ProjectQuoteTemplatesParent dao = new ProjectQuoteTemplatesParent();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectQuoteTemplatesParent> rlist = new BaseCollection<>();
		BaseProjectQuoteTemplatesParent bean = new BaseProjectQuoteTemplatesParent();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectQuoteTemplatesParent dao = new ProjectQuoteTemplatesParent();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectQuoteTemplatesParent> result = dao.conditionalLoad(addtion);
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
		BaseProjectQuoteTemplatesParent bean = new BaseProjectQuoteTemplatesParent();
		bean.setDataFromJSON(json);
		ProjectQuoteTemplatesParent dao = new ProjectQuoteTemplatesParent();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectQuoteTemplatesParent bean = new BaseProjectQuoteTemplatesParent();
		bean.setDataFromJSON(json);
		ProjectQuoteTemplatesParent dao = new ProjectQuoteTemplatesParent();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectQuoteTemplatesParent bean = new BaseProjectQuoteTemplatesParent();
		bean.setDataFromJSON(json);
		ProjectQuoteTemplatesParent dao = new ProjectQuoteTemplatesParent();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectQuoteTemplatesParent bean = new BaseProjectQuoteTemplatesParent();
		bean.setDataFromJSON(json);
		ProjectQuoteTemplatesParent dao = new ProjectQuoteTemplatesParent();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


