package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectQuote;
import com.pomplatform.db.dao.ProjectQuote;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectQuoteHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectQuoteHandler.class);

	public static BaseProjectQuote getProjectQuoteById( 
		java.lang.Integer project_quote_id
	) throws Exception
	{
		ProjectQuote dao = new ProjectQuote();
		dao.setProjectQuoteId(project_quote_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectQuoteExists( com.pomplatform.db.bean.BaseProjectQuote bean, String additional ) throws Exception {

		ProjectQuote dao = new ProjectQuote();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectQuote( com.pomplatform.db.bean.BaseProjectQuote bean, String additional ) throws Exception {

		ProjectQuote dao = new ProjectQuote();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectQuote> queryProjectQuote( com.pomplatform.db.bean.BaseProjectQuote bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectQuote dao = new ProjectQuote();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectQuote> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectQuote> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectQuote addToProjectQuote ( BaseProjectQuote projectquote )  throws Exception {
		return addToProjectQuote ( projectquote , false);
	}

	public static BaseProjectQuote addToProjectQuote ( BaseProjectQuote projectquote, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectQuote dao = new ProjectQuote();
		dao.setDataFromBase(projectquote);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectQuote addUpdateProjectQuote ( BaseProjectQuote projectquote ) throws Exception {
		return addUpdateProjectQuote ( projectquote , false);
	}

	public static BaseProjectQuote addUpdateProjectQuote ( BaseProjectQuote projectquote, boolean singleTransaction  ) throws Exception {
		if(projectquote.getProjectQuoteId() == null) return addToProjectQuote(projectquote);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectQuote dao = new ProjectQuote();
		dao.setDataFromBase(projectquote);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectquote); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectQuote ( BaseProjectQuote bean ) throws Exception {
		ProjectQuote dao = new ProjectQuote();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectQuote updateProjectQuote ( BaseProjectQuote projectquote ) throws Exception {
		ProjectQuote dao = new ProjectQuote();
		dao.setProjectQuoteId( projectquote.getProjectQuoteId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectquote);
			result = dao.update();
		}
		return result == 1 ? projectquote : null ;
	}

	public static BaseProjectQuote updateProjectQuoteDirect( BaseProjectQuote projectquote ) throws Exception {
		ProjectQuote dao = new ProjectQuote();
		int result = 0;
		dao.setDataFromBase(projectquote);
		result = dao.update();
		return result == 1 ? projectquote : null ;
	}

	public static int setDeleteConditions(BaseProjectQuote bean, ProjectQuote dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectQuoteId() != null) {
			dao.setConditionProjectQuoteId("=", bean.getProjectQuoteId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getTitleName() != null) {
				dao.setConditionTitleName("=", bean.getTitleName());
				count++;
			}
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
				count++;
			}
			if(bean.getVersionNumber() != null) {
				dao.setConditionVersionNumber("=", bean.getVersionNumber());
				count++;
			}
			if(bean.getQuoteStatus() != null) {
				dao.setConditionQuoteStatus("=", bean.getQuoteStatus());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
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
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectQuote bean, ProjectQuote dao){
		int count = 0;
		if(bean.getProjectQuoteId() != null) {
			dao.setConditionProjectQuoteId("=", bean.getProjectQuoteId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getTitleName() != null) {
			if(bean.getTitleName().indexOf("%") >= 0)
				dao.setConditionTitleName("like", bean.getTitleName());
			else
				dao.setConditionTitleName("=", bean.getTitleName());
			count++;
		}
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
			count++;
		}
		if(bean.getVersionNumber() != null) {
			dao.setConditionVersionNumber("=", bean.getVersionNumber());
			count++;
		}
		if(bean.getQuoteStatus() != null) {
			dao.setConditionQuoteStatus("=", bean.getQuoteStatus());
			count++;
		}
		if(bean.getBasicAmount() != null) {
			dao.setConditionBasicAmount("=", bean.getBasicAmount());
			count++;
		}
		if(bean.getTotalAmount() != null) {
			dao.setConditionTotalAmount("=", bean.getTotalAmount());
			count++;
		}
		if(bean.getUpAmount() != null) {
			dao.setConditionUpAmount("=", bean.getUpAmount());
			count++;
		}
		if(bean.getUpPercent() != null) {
			dao.setConditionUpPercent("=", bean.getUpPercent());
			count++;
		}
		if(bean.getPreferentialAmount() != null) {
			dao.setConditionPreferentialAmount("=", bean.getPreferentialAmount());
			count++;
		}
		if(bean.getPerferentialPercent() != null) {
			dao.setConditionPerferentialPercent("=", bean.getPerferentialPercent());
			count++;
		}
		if(bean.getSpecialDiscountAmount() != null) {
			dao.setConditionSpecialDiscountAmount("=", bean.getSpecialDiscountAmount());
			count++;
		}
		if(bean.getSpecialDiscountPercent() != null) {
			dao.setConditionSpecialDiscountPercent("=", bean.getSpecialDiscountPercent());
			count++;
		}
		if(bean.getTaxAmount() != null) {
			dao.setConditionTaxAmount("=", bean.getTaxAmount());
			count++;
		}
		if(bean.getOtherTaxAmount() != null) {
			dao.setConditionOtherTaxAmount("=", bean.getOtherTaxAmount());
			count++;
		}
		if(bean.getFinalPercent() != null) {
			dao.setConditionFinalPercent("=", bean.getFinalPercent());
			count++;
		}
		if(bean.getFinalAmount() != null) {
			dao.setConditionFinalAmount("=", bean.getFinalAmount());
			count++;
		}
		if(bean.getTaxFinalAmount() != null) {
			dao.setConditionTaxFinalAmount("=", bean.getTaxFinalAmount());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
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
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectQuote bean = new BaseProjectQuote();
		bean.setDataFromJSON(json);
		ProjectQuote dao = new ProjectQuote();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectQuote> rlist = new BaseCollection<>();
		BaseProjectQuote bean = new BaseProjectQuote();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectQuote dao = new ProjectQuote();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectQuote> result = dao.conditionalLoad(addtion);
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
		BaseProjectQuote bean = new BaseProjectQuote();
		bean.setDataFromJSON(json);
		ProjectQuote dao = new ProjectQuote();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectQuote bean = new BaseProjectQuote();
		bean.setDataFromJSON(json);
		ProjectQuote dao = new ProjectQuote();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectQuote bean = new BaseProjectQuote();
		bean.setDataFromJSON(json);
		ProjectQuote dao = new ProjectQuote();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectQuote bean = new BaseProjectQuote();
		bean.setDataFromJSON(json);
		ProjectQuote dao = new ProjectQuote();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


