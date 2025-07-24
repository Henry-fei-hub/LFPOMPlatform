package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapitalLog;
import com.pomplatform.db.dao.CapitalLog;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CapitalLogHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CapitalLogHandler.class);

	public static BaseCapitalLog getCapitalLogById( 
		java.lang.Integer capital_log_id
	) throws Exception
	{
		CapitalLog dao = new CapitalLog();
		dao.setCapitalLogId(capital_log_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCapitalLogExists( com.pomplatform.db.bean.BaseCapitalLog bean, String additional ) throws Exception {

		CapitalLog dao = new CapitalLog();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCapitalLog( com.pomplatform.db.bean.BaseCapitalLog bean, String additional ) throws Exception {

		CapitalLog dao = new CapitalLog();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCapitalLog> queryCapitalLog( com.pomplatform.db.bean.BaseCapitalLog bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CapitalLog dao = new CapitalLog();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCapitalLog> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCapitalLog> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCapitalLog addToCapitalLog ( BaseCapitalLog capitallog )  throws Exception {
		return addToCapitalLog ( capitallog , false);
	}

	public static BaseCapitalLog addToCapitalLog ( BaseCapitalLog capitallog, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CapitalLog dao = new CapitalLog();
		dao.setDataFromBase(capitallog);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCapitalLog addUpdateCapitalLog ( BaseCapitalLog capitallog ) throws Exception {
		return addUpdateCapitalLog ( capitallog , false);
	}

	public static BaseCapitalLog addUpdateCapitalLog ( BaseCapitalLog capitallog, boolean singleTransaction  ) throws Exception {
		if(capitallog.getCapitalLogId() == null) return addToCapitalLog(capitallog);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CapitalLog dao = new CapitalLog();
		dao.setDataFromBase(capitallog);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(capitallog); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCapitalLog ( BaseCapitalLog bean ) throws Exception {
		CapitalLog dao = new CapitalLog();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCapitalLog updateCapitalLog ( BaseCapitalLog capitallog ) throws Exception {
		CapitalLog dao = new CapitalLog();
		dao.setCapitalLogId( capitallog.getCapitalLogId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(capitallog);
			result = dao.update();
		}
		return result == 1 ? capitallog : null ;
	}

	public static BaseCapitalLog updateCapitalLogDirect( BaseCapitalLog capitallog ) throws Exception {
		CapitalLog dao = new CapitalLog();
		int result = 0;
		dao.setDataFromBase(capitallog);
		result = dao.update();
		return result == 1 ? capitallog : null ;
	}

	public static int setDeleteConditions(BaseCapitalLog bean, CapitalLog dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCapitalLogId() != null) {
			dao.setConditionCapitalLogId("=", bean.getCapitalLogId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getLogContent() != null) {
				dao.setConditionLogContent("=", bean.getLogContent());
				count++;
			}
			if(bean.getCapitalId() != null) {
				dao.setConditionCapitalId("=", bean.getCapitalId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCapitalLog bean, CapitalLog dao){
		int count = 0;
		if(bean.getCapitalLogId() != null) {
			dao.setConditionCapitalLogId("=", bean.getCapitalLogId());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getLogContent() != null) {
			if(bean.getLogContent().indexOf("%") >= 0)
				dao.setConditionLogContent("like", bean.getLogContent());
			else
				dao.setConditionLogContent("=", bean.getLogContent());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getCapitalId() != null) {
			dao.setConditionCapitalId("=", bean.getCapitalId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCapitalLog bean = new BaseCapitalLog();
		bean.setDataFromJSON(json);
		CapitalLog dao = new CapitalLog();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCapitalLog> rlist = new BaseCollection<>();
		BaseCapitalLog bean = new BaseCapitalLog();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CapitalLog dao = new CapitalLog();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCapitalLog> result = dao.conditionalLoad(addtion);
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
		BaseCapitalLog bean = new BaseCapitalLog();
		bean.setDataFromJSON(json);
		CapitalLog dao = new CapitalLog();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCapitalLog bean = new BaseCapitalLog();
		bean.setDataFromJSON(json);
		CapitalLog dao = new CapitalLog();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCapitalLog bean = new BaseCapitalLog();
		bean.setDataFromJSON(json);
		CapitalLog dao = new CapitalLog();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCapitalLog bean = new BaseCapitalLog();
		bean.setDataFromJSON(json);
		CapitalLog dao = new CapitalLog();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


