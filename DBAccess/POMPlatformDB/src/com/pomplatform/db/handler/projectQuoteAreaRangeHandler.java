package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseprojectQuoteAreaRange;
import com.pomplatform.db.dao.projectQuoteAreaRange;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class projectQuoteAreaRangeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(projectQuoteAreaRangeHandler.class);

	public static BaseprojectQuoteAreaRange getprojectQuoteAreaRangeById( 
		java.lang.Integer project_quote_area_range_id
	) throws Exception
	{
		projectQuoteAreaRange dao = new projectQuoteAreaRange();
		dao.setProjectQuoteAreaRangeId(project_quote_area_range_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isprojectQuoteAreaRangeExists( com.pomplatform.db.bean.BaseprojectQuoteAreaRange bean, String additional ) throws Exception {

		projectQuoteAreaRange dao = new projectQuoteAreaRange();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countprojectQuoteAreaRange( com.pomplatform.db.bean.BaseprojectQuoteAreaRange bean, String additional ) throws Exception {

		projectQuoteAreaRange dao = new projectQuoteAreaRange();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseprojectQuoteAreaRange> queryprojectQuoteAreaRange( com.pomplatform.db.bean.BaseprojectQuoteAreaRange bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		projectQuoteAreaRange dao = new projectQuoteAreaRange();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseprojectQuoteAreaRange> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseprojectQuoteAreaRange> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseprojectQuoteAreaRange addToprojectQuoteAreaRange ( BaseprojectQuoteAreaRange projectquotearearange )  throws Exception {
		return addToprojectQuoteAreaRange ( projectquotearearange , false);
	}

	public static BaseprojectQuoteAreaRange addToprojectQuoteAreaRange ( BaseprojectQuoteAreaRange projectquotearearange, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		projectQuoteAreaRange dao = new projectQuoteAreaRange();
		dao.setDataFromBase(projectquotearearange);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseprojectQuoteAreaRange addUpdateprojectQuoteAreaRange ( BaseprojectQuoteAreaRange projectquotearearange ) throws Exception {
		return addUpdateprojectQuoteAreaRange ( projectquotearearange , false);
	}

	public static BaseprojectQuoteAreaRange addUpdateprojectQuoteAreaRange ( BaseprojectQuoteAreaRange projectquotearearange, boolean singleTransaction  ) throws Exception {
		if(projectquotearearange.getProjectQuoteAreaRangeId() == null) return addToprojectQuoteAreaRange(projectquotearearange);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		projectQuoteAreaRange dao = new projectQuoteAreaRange();
		dao.setDataFromBase(projectquotearearange);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectquotearearange); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteprojectQuoteAreaRange ( BaseprojectQuoteAreaRange bean ) throws Exception {
		projectQuoteAreaRange dao = new projectQuoteAreaRange();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseprojectQuoteAreaRange updateprojectQuoteAreaRange ( BaseprojectQuoteAreaRange projectquotearearange ) throws Exception {
		projectQuoteAreaRange dao = new projectQuoteAreaRange();
		dao.setProjectQuoteAreaRangeId( projectquotearearange.getProjectQuoteAreaRangeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectquotearearange);
			result = dao.update();
		}
		return result == 1 ? projectquotearearange : null ;
	}

	public static BaseprojectQuoteAreaRange updateprojectQuoteAreaRangeDirect( BaseprojectQuoteAreaRange projectquotearearange ) throws Exception {
		projectQuoteAreaRange dao = new projectQuoteAreaRange();
		int result = 0;
		dao.setDataFromBase(projectquotearearange);
		result = dao.update();
		return result == 1 ? projectquotearearange : null ;
	}

	public static int setDeleteConditions(BaseprojectQuoteAreaRange bean, projectQuoteAreaRange dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectQuoteAreaRangeId() != null) {
			dao.setConditionProjectQuoteAreaRangeId("=", bean.getProjectQuoteAreaRangeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectQuoteTemplatesParentId() != null) {
				dao.setConditionProjectQuoteTemplatesParentId("=", bean.getProjectQuoteTemplatesParentId());
				count++;
			}
			if(bean.getProjectQuoteTemplateId() != null) {
				dao.setConditionProjectQuoteTemplateId("=", bean.getProjectQuoteTemplateId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseprojectQuoteAreaRange bean, projectQuoteAreaRange dao){
		int count = 0;
		if(bean.getProjectQuoteAreaRangeId() != null) {
			dao.setConditionProjectQuoteAreaRangeId("=", bean.getProjectQuoteAreaRangeId());
			count++;
		}
		if(bean.getProjectQuoteTemplatesParentId() != null) {
			dao.setConditionProjectQuoteTemplatesParentId("=", bean.getProjectQuoteTemplatesParentId());
			count++;
		}
		if(bean.getProjectQuoteTemplateId() != null) {
			dao.setConditionProjectQuoteTemplateId("=", bean.getProjectQuoteTemplateId());
			count++;
		}
		if(bean.getAreaRangeStart() != null) {
			dao.setConditionAreaRangeStart("=", bean.getAreaRangeStart());
			count++;
		}
		if(bean.getAreaRangeEnd() != null) {
			dao.setConditionAreaRangeEnd("=", bean.getAreaRangeEnd());
			count++;
		}
		if(bean.getAreaPrice() != null) {
			dao.setConditionAreaPrice("=", bean.getAreaPrice());
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
		BaseprojectQuoteAreaRange bean = new BaseprojectQuoteAreaRange();
		bean.setDataFromJSON(json);
		projectQuoteAreaRange dao = new projectQuoteAreaRange();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseprojectQuoteAreaRange> rlist = new BaseCollection<>();
		BaseprojectQuoteAreaRange bean = new BaseprojectQuoteAreaRange();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		projectQuoteAreaRange dao = new projectQuoteAreaRange();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseprojectQuoteAreaRange> result = dao.conditionalLoad(addtion);
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
		BaseprojectQuoteAreaRange bean = new BaseprojectQuoteAreaRange();
		bean.setDataFromJSON(json);
		projectQuoteAreaRange dao = new projectQuoteAreaRange();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseprojectQuoteAreaRange bean = new BaseprojectQuoteAreaRange();
		bean.setDataFromJSON(json);
		projectQuoteAreaRange dao = new projectQuoteAreaRange();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseprojectQuoteAreaRange bean = new BaseprojectQuoteAreaRange();
		bean.setDataFromJSON(json);
		projectQuoteAreaRange dao = new projectQuoteAreaRange();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseprojectQuoteAreaRange bean = new BaseprojectQuoteAreaRange();
		bean.setDataFromJSON(json);
		projectQuoteAreaRange dao = new projectQuoteAreaRange();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


