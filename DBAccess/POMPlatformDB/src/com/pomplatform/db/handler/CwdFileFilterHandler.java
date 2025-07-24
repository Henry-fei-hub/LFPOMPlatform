package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdFileFilter;
import com.pomplatform.db.dao.CwdFileFilter;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdFileFilterHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdFileFilterHandler.class);

	public static BaseCwdFileFilter getCwdFileFilterById( 
		java.lang.Integer file_filter_id
	) throws Exception
	{
		CwdFileFilter dao = new CwdFileFilter();
		dao.setFileFilterId(file_filter_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdFileFilterExists( com.pomplatform.db.bean.BaseCwdFileFilter bean, String additional ) throws Exception {

		CwdFileFilter dao = new CwdFileFilter();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdFileFilter( com.pomplatform.db.bean.BaseCwdFileFilter bean, String additional ) throws Exception {

		CwdFileFilter dao = new CwdFileFilter();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdFileFilter> queryCwdFileFilter( com.pomplatform.db.bean.BaseCwdFileFilter bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdFileFilter dao = new CwdFileFilter();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdFileFilter> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdFileFilter> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdFileFilter addToCwdFileFilter ( BaseCwdFileFilter cwdfilefilter )  throws Exception {
		return addToCwdFileFilter ( cwdfilefilter , false);
	}

	public static BaseCwdFileFilter addToCwdFileFilter ( BaseCwdFileFilter cwdfilefilter, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdFileFilter dao = new CwdFileFilter();
		dao.setDataFromBase(cwdfilefilter);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdFileFilter addUpdateCwdFileFilter ( BaseCwdFileFilter cwdfilefilter ) throws Exception {
		return addUpdateCwdFileFilter ( cwdfilefilter , false);
	}

	public static BaseCwdFileFilter addUpdateCwdFileFilter ( BaseCwdFileFilter cwdfilefilter, boolean singleTransaction  ) throws Exception {
		if(cwdfilefilter.getFileFilterId() == null) return addToCwdFileFilter(cwdfilefilter);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdFileFilter dao = new CwdFileFilter();
		dao.setDataFromBase(cwdfilefilter);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdfilefilter); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdFileFilter ( BaseCwdFileFilter bean ) throws Exception {
		CwdFileFilter dao = new CwdFileFilter();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdFileFilter updateCwdFileFilter ( BaseCwdFileFilter cwdfilefilter ) throws Exception {
		CwdFileFilter dao = new CwdFileFilter();
		dao.setFileFilterId( cwdfilefilter.getFileFilterId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdfilefilter);
			result = dao.update();
		}
		return result == 1 ? cwdfilefilter : null ;
	}

	public static BaseCwdFileFilter updateCwdFileFilterDirect( BaseCwdFileFilter cwdfilefilter ) throws Exception {
		CwdFileFilter dao = new CwdFileFilter();
		int result = 0;
		dao.setDataFromBase(cwdfilefilter);
		result = dao.update();
		return result == 1 ? cwdfilefilter : null ;
	}

	public static int setDeleteConditions(BaseCwdFileFilter bean, CwdFileFilter dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getFileFilterId() != null) {
			dao.setConditionFileFilterId("=", bean.getFileFilterId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getFilterFileExtension() != null) {
				dao.setConditionFilterFileExtension("=", bean.getFilterFileExtension());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdFileFilter bean, CwdFileFilter dao){
		int count = 0;
		if(bean.getFileFilterId() != null) {
			dao.setConditionFileFilterId("=", bean.getFileFilterId());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getFilterFileExtension() != null) {
			if(bean.getFilterFileExtension().indexOf("%") >= 0)
				dao.setConditionFilterFileExtension("like", bean.getFilterFileExtension());
			else
				dao.setConditionFilterFileExtension("=", bean.getFilterFileExtension());
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
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdFileFilter bean = new BaseCwdFileFilter();
		bean.setDataFromJSON(json);
		CwdFileFilter dao = new CwdFileFilter();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdFileFilter> rlist = new BaseCollection<>();
		BaseCwdFileFilter bean = new BaseCwdFileFilter();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdFileFilter dao = new CwdFileFilter();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdFileFilter> result = dao.conditionalLoad(addtion);
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
		BaseCwdFileFilter bean = new BaseCwdFileFilter();
		bean.setDataFromJSON(json);
		CwdFileFilter dao = new CwdFileFilter();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdFileFilter bean = new BaseCwdFileFilter();
		bean.setDataFromJSON(json);
		CwdFileFilter dao = new CwdFileFilter();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdFileFilter bean = new BaseCwdFileFilter();
		bean.setDataFromJSON(json);
		CwdFileFilter dao = new CwdFileFilter();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdFileFilter bean = new BaseCwdFileFilter();
		bean.setDataFromJSON(json);
		CwdFileFilter dao = new CwdFileFilter();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


