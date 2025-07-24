package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSystemInitLog;
import com.pomplatform.db.dao.SystemInitLog;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SystemInitLogHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SystemInitLogHandler.class);

	public static BaseSystemInitLog getSystemInitLogById( 
		java.lang.Integer system_init_log_id
	) throws Exception
	{
		SystemInitLog dao = new SystemInitLog();
		dao.setSystemInitLogId(system_init_log_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSystemInitLogExists( com.pomplatform.db.bean.BaseSystemInitLog bean, String additional ) throws Exception {

		SystemInitLog dao = new SystemInitLog();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSystemInitLog( com.pomplatform.db.bean.BaseSystemInitLog bean, String additional ) throws Exception {

		SystemInitLog dao = new SystemInitLog();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSystemInitLog> querySystemInitLog( com.pomplatform.db.bean.BaseSystemInitLog bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SystemInitLog dao = new SystemInitLog();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSystemInitLog> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSystemInitLog> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSystemInitLog addToSystemInitLog ( BaseSystemInitLog systeminitlog )  throws Exception {
		return addToSystemInitLog ( systeminitlog , false);
	}

	public static BaseSystemInitLog addToSystemInitLog ( BaseSystemInitLog systeminitlog, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SystemInitLog dao = new SystemInitLog();
		dao.setDataFromBase(systeminitlog);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSystemInitLog addUpdateSystemInitLog ( BaseSystemInitLog systeminitlog ) throws Exception {
		return addUpdateSystemInitLog ( systeminitlog , false);
	}

	public static BaseSystemInitLog addUpdateSystemInitLog ( BaseSystemInitLog systeminitlog, boolean singleTransaction  ) throws Exception {
		if(systeminitlog.getSystemInitLogId() == null) return addToSystemInitLog(systeminitlog);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SystemInitLog dao = new SystemInitLog();
		dao.setDataFromBase(systeminitlog);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(systeminitlog); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSystemInitLog ( BaseSystemInitLog bean ) throws Exception {
		SystemInitLog dao = new SystemInitLog();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSystemInitLog updateSystemInitLog ( BaseSystemInitLog systeminitlog ) throws Exception {
		SystemInitLog dao = new SystemInitLog();
		dao.setSystemInitLogId( systeminitlog.getSystemInitLogId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(systeminitlog);
			result = dao.update();
		}
		return result == 1 ? systeminitlog : null ;
	}

	public static BaseSystemInitLog updateSystemInitLogDirect( BaseSystemInitLog systeminitlog ) throws Exception {
		SystemInitLog dao = new SystemInitLog();
		int result = 0;
		dao.setDataFromBase(systeminitlog);
		result = dao.update();
		return result == 1 ? systeminitlog : null ;
	}

	public static int setDeleteConditions(BaseSystemInitLog bean, SystemInitLog dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSystemInitLogId() != null) {
			dao.setConditionSystemInitLogId("=", bean.getSystemInitLogId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getLogMsg() != null) {
				dao.setConditionLogMsg("=", bean.getLogMsg());
				count++;
			}
			if(bean.getFlag() != null) {
				dao.setConditionFlag("=", bean.getFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSystemInitLog bean, SystemInitLog dao){
		int count = 0;
		if(bean.getSystemInitLogId() != null) {
			dao.setConditionSystemInitLogId("=", bean.getSystemInitLogId());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getLogMsg() != null) {
			if(bean.getLogMsg().indexOf("%") >= 0)
				dao.setConditionLogMsg("like", bean.getLogMsg());
			else
				dao.setConditionLogMsg("=", bean.getLogMsg());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getFlag() != null) {
			dao.setConditionFlag("=", bean.getFlag());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSystemInitLog bean = new BaseSystemInitLog();
		bean.setDataFromJSON(json);
		SystemInitLog dao = new SystemInitLog();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSystemInitLog> rlist = new BaseCollection<>();
		BaseSystemInitLog bean = new BaseSystemInitLog();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SystemInitLog dao = new SystemInitLog();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSystemInitLog> result = dao.conditionalLoad(addtion);
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
		BaseSystemInitLog bean = new BaseSystemInitLog();
		bean.setDataFromJSON(json);
		SystemInitLog dao = new SystemInitLog();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSystemInitLog bean = new BaseSystemInitLog();
		bean.setDataFromJSON(json);
		SystemInitLog dao = new SystemInitLog();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSystemInitLog bean = new BaseSystemInitLog();
		bean.setDataFromJSON(json);
		SystemInitLog dao = new SystemInitLog();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSystemInitLog bean = new BaseSystemInitLog();
		bean.setDataFromJSON(json);
		SystemInitLog dao = new SystemInitLog();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


