package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdFileUpdateLog;
import com.pomplatform.db.dao.CwdFileUpdateLog;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdFileUpdateLogHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdFileUpdateLogHandler.class);

	public static BaseCwdFileUpdateLog getCwdFileUpdateLogById( 
		java.lang.Integer file_update_log_id
	) throws Exception
	{
		CwdFileUpdateLog dao = new CwdFileUpdateLog();
		dao.setFileUpdateLogId(file_update_log_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdFileUpdateLogExists( com.pomplatform.db.bean.BaseCwdFileUpdateLog bean, String additional ) throws Exception {

		CwdFileUpdateLog dao = new CwdFileUpdateLog();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdFileUpdateLog( com.pomplatform.db.bean.BaseCwdFileUpdateLog bean, String additional ) throws Exception {

		CwdFileUpdateLog dao = new CwdFileUpdateLog();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdFileUpdateLog> queryCwdFileUpdateLog( com.pomplatform.db.bean.BaseCwdFileUpdateLog bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdFileUpdateLog dao = new CwdFileUpdateLog();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdFileUpdateLog> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdFileUpdateLog> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdFileUpdateLog addToCwdFileUpdateLog ( BaseCwdFileUpdateLog cwdfileupdatelog )  throws Exception {
		return addToCwdFileUpdateLog ( cwdfileupdatelog , false);
	}

	public static BaseCwdFileUpdateLog addToCwdFileUpdateLog ( BaseCwdFileUpdateLog cwdfileupdatelog, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdFileUpdateLog dao = new CwdFileUpdateLog();
		dao.setDataFromBase(cwdfileupdatelog);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdFileUpdateLog addUpdateCwdFileUpdateLog ( BaseCwdFileUpdateLog cwdfileupdatelog ) throws Exception {
		return addUpdateCwdFileUpdateLog ( cwdfileupdatelog , false);
	}

	public static BaseCwdFileUpdateLog addUpdateCwdFileUpdateLog ( BaseCwdFileUpdateLog cwdfileupdatelog, boolean singleTransaction  ) throws Exception {
		if(cwdfileupdatelog.getFileUpdateLogId() == null) return addToCwdFileUpdateLog(cwdfileupdatelog);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdFileUpdateLog dao = new CwdFileUpdateLog();
		dao.setDataFromBase(cwdfileupdatelog);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdfileupdatelog); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdFileUpdateLog ( BaseCwdFileUpdateLog bean ) throws Exception {
		CwdFileUpdateLog dao = new CwdFileUpdateLog();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdFileUpdateLog updateCwdFileUpdateLog ( BaseCwdFileUpdateLog cwdfileupdatelog ) throws Exception {
		CwdFileUpdateLog dao = new CwdFileUpdateLog();
		dao.setFileUpdateLogId( cwdfileupdatelog.getFileUpdateLogId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdfileupdatelog);
			result = dao.update();
		}
		return result == 1 ? cwdfileupdatelog : null ;
	}

	public static BaseCwdFileUpdateLog updateCwdFileUpdateLogDirect( BaseCwdFileUpdateLog cwdfileupdatelog ) throws Exception {
		CwdFileUpdateLog dao = new CwdFileUpdateLog();
		int result = 0;
		dao.setDataFromBase(cwdfileupdatelog);
		result = dao.update();
		return result == 1 ? cwdfileupdatelog : null ;
	}

	public static int setDeleteConditions(BaseCwdFileUpdateLog bean, CwdFileUpdateLog dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getFileUpdateLogId() != null) {
			dao.setConditionFileUpdateLogId("=", bean.getFileUpdateLogId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCwdFileId() != null) {
				dao.setConditionCwdFileId("=", bean.getCwdFileId());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdFileUpdateLog bean, CwdFileUpdateLog dao){
		int count = 0;
		if(bean.getFileUpdateLogId() != null) {
			dao.setConditionFileUpdateLogId("=", bean.getFileUpdateLogId());
			count++;
		}
		if(bean.getCwdFileId() != null) {
			dao.setConditionCwdFileId("=", bean.getCwdFileId());
			count++;
		}
		if(bean.getBeginTime() != null) {
			dao.setConditionBeginTime(">=", bean.getBeginTime());
			count++;
		}
		if(bean.getEndTime() != null) {
			dao.setConditionEndTime(">=", bean.getEndTime());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdFileUpdateLog bean = new BaseCwdFileUpdateLog();
		bean.setDataFromJSON(json);
		CwdFileUpdateLog dao = new CwdFileUpdateLog();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdFileUpdateLog> rlist = new BaseCollection<>();
		BaseCwdFileUpdateLog bean = new BaseCwdFileUpdateLog();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdFileUpdateLog dao = new CwdFileUpdateLog();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdFileUpdateLog> result = dao.conditionalLoad(addtion);
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
		BaseCwdFileUpdateLog bean = new BaseCwdFileUpdateLog();
		bean.setDataFromJSON(json);
		CwdFileUpdateLog dao = new CwdFileUpdateLog();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdFileUpdateLog bean = new BaseCwdFileUpdateLog();
		bean.setDataFromJSON(json);
		CwdFileUpdateLog dao = new CwdFileUpdateLog();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdFileUpdateLog bean = new BaseCwdFileUpdateLog();
		bean.setDataFromJSON(json);
		CwdFileUpdateLog dao = new CwdFileUpdateLog();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdFileUpdateLog bean = new BaseCwdFileUpdateLog();
		bean.setDataFromJSON(json);
		CwdFileUpdateLog dao = new CwdFileUpdateLog();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


