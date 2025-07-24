package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectQuoteDetail;
import com.pomplatform.db.dao.ProjectQuoteDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectQuoteDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectQuoteDetailHandler.class);

	public static BaseProjectQuoteDetail getProjectQuoteDetailById( 
		java.lang.Integer project_quote_detail_id
	) throws Exception
	{
		ProjectQuoteDetail dao = new ProjectQuoteDetail();
		dao.setProjectQuoteDetailId(project_quote_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectQuoteDetailExists( com.pomplatform.db.bean.BaseProjectQuoteDetail bean, String additional ) throws Exception {

		ProjectQuoteDetail dao = new ProjectQuoteDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectQuoteDetail( com.pomplatform.db.bean.BaseProjectQuoteDetail bean, String additional ) throws Exception {

		ProjectQuoteDetail dao = new ProjectQuoteDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectQuoteDetail> queryProjectQuoteDetail( com.pomplatform.db.bean.BaseProjectQuoteDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectQuoteDetail dao = new ProjectQuoteDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectQuoteDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectQuoteDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectQuoteDetail addToProjectQuoteDetail ( BaseProjectQuoteDetail projectquotedetail )  throws Exception {
		return addToProjectQuoteDetail ( projectquotedetail , false);
	}

	public static BaseProjectQuoteDetail addToProjectQuoteDetail ( BaseProjectQuoteDetail projectquotedetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectQuoteDetail dao = new ProjectQuoteDetail();
		dao.setDataFromBase(projectquotedetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectQuoteDetail addUpdateProjectQuoteDetail ( BaseProjectQuoteDetail projectquotedetail ) throws Exception {
		return addUpdateProjectQuoteDetail ( projectquotedetail , false);
	}

	public static BaseProjectQuoteDetail addUpdateProjectQuoteDetail ( BaseProjectQuoteDetail projectquotedetail, boolean singleTransaction  ) throws Exception {
		if(projectquotedetail.getProjectQuoteDetailId() == null) return addToProjectQuoteDetail(projectquotedetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectQuoteDetail dao = new ProjectQuoteDetail();
		dao.setDataFromBase(projectquotedetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectquotedetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectQuoteDetail ( BaseProjectQuoteDetail bean ) throws Exception {
		ProjectQuoteDetail dao = new ProjectQuoteDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectQuoteDetail updateProjectQuoteDetail ( BaseProjectQuoteDetail projectquotedetail ) throws Exception {
		ProjectQuoteDetail dao = new ProjectQuoteDetail();
		dao.setProjectQuoteDetailId( projectquotedetail.getProjectQuoteDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectquotedetail);
			result = dao.update();
		}
		return result == 1 ? projectquotedetail : null ;
	}

	public static BaseProjectQuoteDetail updateProjectQuoteDetailDirect( BaseProjectQuoteDetail projectquotedetail ) throws Exception {
		ProjectQuoteDetail dao = new ProjectQuoteDetail();
		int result = 0;
		dao.setDataFromBase(projectquotedetail);
		result = dao.update();
		return result == 1 ? projectquotedetail : null ;
	}

	public static int setDeleteConditions(BaseProjectQuoteDetail bean, ProjectQuoteDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectQuoteDetailId() != null) {
			dao.setConditionProjectQuoteDetailId("=", bean.getProjectQuoteDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectQuoteId() != null) {
				dao.setConditionProjectQuoteId("=", bean.getProjectQuoteId());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
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
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectQuoteDetail bean, ProjectQuoteDetail dao){
		int count = 0;
		if(bean.getProjectQuoteDetailId() != null) {
			dao.setConditionProjectQuoteDetailId("=", bean.getProjectQuoteDetailId());
			count++;
		}
		if(bean.getProjectQuoteId() != null) {
			dao.setConditionProjectQuoteId("=", bean.getProjectQuoteId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
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
		if(bean.getArea() != null) {
			dao.setConditionArea("=", bean.getArea());
			count++;
		}
		if(bean.getAreaPrice() != null) {
			dao.setConditionAreaPrice("=", bean.getAreaPrice());
			count++;
		}
		if(bean.getTotalPrice() != null) {
			dao.setConditionTotalPrice("=", bean.getTotalPrice());
			count++;
		}
		if(bean.getTax() != null) {
			dao.setConditionTax("=", bean.getTax());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectQuoteDetail bean = new BaseProjectQuoteDetail();
		bean.setDataFromJSON(json);
		ProjectQuoteDetail dao = new ProjectQuoteDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectQuoteDetail> rlist = new BaseCollection<>();
		BaseProjectQuoteDetail bean = new BaseProjectQuoteDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectQuoteDetail dao = new ProjectQuoteDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectQuoteDetail> result = dao.conditionalLoad(addtion);
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
		BaseProjectQuoteDetail bean = new BaseProjectQuoteDetail();
		bean.setDataFromJSON(json);
		ProjectQuoteDetail dao = new ProjectQuoteDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectQuoteDetail bean = new BaseProjectQuoteDetail();
		bean.setDataFromJSON(json);
		ProjectQuoteDetail dao = new ProjectQuoteDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectQuoteDetail bean = new BaseProjectQuoteDetail();
		bean.setDataFromJSON(json);
		ProjectQuoteDetail dao = new ProjectQuoteDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectQuoteDetail bean = new BaseProjectQuoteDetail();
		bean.setDataFromJSON(json);
		ProjectQuoteDetail dao = new ProjectQuoteDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


