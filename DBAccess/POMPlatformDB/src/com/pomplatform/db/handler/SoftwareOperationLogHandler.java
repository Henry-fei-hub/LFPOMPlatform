package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSoftwareOperationLog;
import com.pomplatform.db.dao.SoftwareOperationLog;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SoftwareOperationLogHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SoftwareOperationLogHandler.class);

	public static BaseSoftwareOperationLog getSoftwareOperationLogById( 
		java.lang.Integer software_operation_log_id
	) throws Exception
	{
		SoftwareOperationLog dao = new SoftwareOperationLog();
		dao.setSoftwareOperationLogId(software_operation_log_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSoftwareOperationLogExists( com.pomplatform.db.bean.BaseSoftwareOperationLog bean, String additional ) throws Exception {

		SoftwareOperationLog dao = new SoftwareOperationLog();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSoftwareOperationLog( com.pomplatform.db.bean.BaseSoftwareOperationLog bean, String additional ) throws Exception {

		SoftwareOperationLog dao = new SoftwareOperationLog();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSoftwareOperationLog> querySoftwareOperationLog( com.pomplatform.db.bean.BaseSoftwareOperationLog bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SoftwareOperationLog dao = new SoftwareOperationLog();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSoftwareOperationLog> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSoftwareOperationLog> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSoftwareOperationLog addToSoftwareOperationLog ( BaseSoftwareOperationLog softwareoperationlog )  throws Exception {
		return addToSoftwareOperationLog ( softwareoperationlog , false);
	}

	public static BaseSoftwareOperationLog addToSoftwareOperationLog ( BaseSoftwareOperationLog softwareoperationlog, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SoftwareOperationLog dao = new SoftwareOperationLog();
		dao.setDataFromBase(softwareoperationlog);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSoftwareOperationLog addUpdateSoftwareOperationLog ( BaseSoftwareOperationLog softwareoperationlog ) throws Exception {
		return addUpdateSoftwareOperationLog ( softwareoperationlog , false);
	}

	public static BaseSoftwareOperationLog addUpdateSoftwareOperationLog ( BaseSoftwareOperationLog softwareoperationlog, boolean singleTransaction  ) throws Exception {
		if(softwareoperationlog.getSoftwareOperationLogId() == null) return addToSoftwareOperationLog(softwareoperationlog);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SoftwareOperationLog dao = new SoftwareOperationLog();
		dao.setDataFromBase(softwareoperationlog);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(softwareoperationlog); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSoftwareOperationLog ( BaseSoftwareOperationLog bean ) throws Exception {
		SoftwareOperationLog dao = new SoftwareOperationLog();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSoftwareOperationLog updateSoftwareOperationLog ( BaseSoftwareOperationLog softwareoperationlog ) throws Exception {
		SoftwareOperationLog dao = new SoftwareOperationLog();
		dao.setSoftwareOperationLogId( softwareoperationlog.getSoftwareOperationLogId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(softwareoperationlog);
			result = dao.update();
		}
		return result == 1 ? softwareoperationlog : null ;
	}

	public static BaseSoftwareOperationLog updateSoftwareOperationLogDirect( BaseSoftwareOperationLog softwareoperationlog ) throws Exception {
		SoftwareOperationLog dao = new SoftwareOperationLog();
		int result = 0;
		dao.setDataFromBase(softwareoperationlog);
		result = dao.update();
		return result == 1 ? softwareoperationlog : null ;
	}

	public static int setDeleteConditions(BaseSoftwareOperationLog bean, SoftwareOperationLog dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSoftwareOperationLogId() != null) {
			dao.setConditionSoftwareOperationLogId("=", bean.getSoftwareOperationLogId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getOperationType() != null) {
				dao.setConditionOperationType("=", bean.getOperationType());
				count++;
			}
			if(bean.getMacAddress() != null) {
				dao.setConditionMacAddress("=", bean.getMacAddress());
				count++;
			}
			if(bean.getIpAddress() != null) {
				dao.setConditionIpAddress("=", bean.getIpAddress());
				count++;
			}
			if(bean.getMachineName() != null) {
				dao.setConditionMachineName("=", bean.getMachineName());
				count++;
			}
			if(bean.getSoftwareType() != null) {
				dao.setConditionSoftwareType("=", bean.getSoftwareType());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSoftwareOperationLog bean, SoftwareOperationLog dao){
		int count = 0;
		if(bean.getSoftwareOperationLogId() != null) {
			dao.setConditionSoftwareOperationLogId("=", bean.getSoftwareOperationLogId());
			count++;
		}
		if(bean.getOperationType() != null) {
			dao.setConditionOperationType("=", bean.getOperationType());
			count++;
		}
		if(bean.getMacAddress() != null) {
			if(bean.getMacAddress().indexOf("%") >= 0)
				dao.setConditionMacAddress("like", bean.getMacAddress());
			else
				dao.setConditionMacAddress("=", bean.getMacAddress());
			count++;
		}
		if(bean.getIpAddress() != null) {
			if(bean.getIpAddress().indexOf("%") >= 0)
				dao.setConditionIpAddress("like", bean.getIpAddress());
			else
				dao.setConditionIpAddress("=", bean.getIpAddress());
			count++;
		}
		if(bean.getMachineName() != null) {
			if(bean.getMachineName().indexOf("%") >= 0)
				dao.setConditionMachineName("like", bean.getMachineName());
			else
				dao.setConditionMachineName("=", bean.getMachineName());
			count++;
		}
		if(bean.getSoftwareType() != null) {
			dao.setConditionSoftwareType("=", bean.getSoftwareType());
			count++;
		}
		if(bean.getLocalOperationTime() != null) {
			dao.setConditionLocalOperationTime(">=", bean.getLocalOperationTime());
			count++;
		}
		if(bean.getLocalRequestTime() != null) {
			dao.setConditionLocalRequestTime(">=", bean.getLocalRequestTime());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getCurrentVersionNo() != null) {
			dao.setConditionCurrentVersionNo("=", bean.getCurrentVersionNo());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getOriVersionNo() != null) {
			dao.setConditionOriVersionNo("=", bean.getOriVersionNo());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSoftwareOperationLog bean = new BaseSoftwareOperationLog();
		bean.setDataFromJSON(json);
		SoftwareOperationLog dao = new SoftwareOperationLog();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSoftwareOperationLog> rlist = new BaseCollection<>();
		BaseSoftwareOperationLog bean = new BaseSoftwareOperationLog();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SoftwareOperationLog dao = new SoftwareOperationLog();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSoftwareOperationLog> result = dao.conditionalLoad(addtion);
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
		BaseSoftwareOperationLog bean = new BaseSoftwareOperationLog();
		bean.setDataFromJSON(json);
		SoftwareOperationLog dao = new SoftwareOperationLog();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSoftwareOperationLog bean = new BaseSoftwareOperationLog();
		bean.setDataFromJSON(json);
		SoftwareOperationLog dao = new SoftwareOperationLog();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSoftwareOperationLog bean = new BaseSoftwareOperationLog();
		bean.setDataFromJSON(json);
		SoftwareOperationLog dao = new SoftwareOperationLog();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSoftwareOperationLog bean = new BaseSoftwareOperationLog();
		bean.setDataFromJSON(json);
		SoftwareOperationLog dao = new SoftwareOperationLog();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


