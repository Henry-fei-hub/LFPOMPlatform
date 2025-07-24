package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePreProjectTransferRecord;
import com.pomplatform.db.dao.PreProjectTransferRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PreProjectTransferRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PreProjectTransferRecordHandler.class);

	public static BasePreProjectTransferRecord getPreProjectTransferRecordById( 
		java.lang.Integer pre_project_transfer_record_id
	) throws Exception
	{
		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		dao.setPreProjectTransferRecordId(pre_project_transfer_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPreProjectTransferRecordExists( com.pomplatform.db.bean.BasePreProjectTransferRecord bean, String additional ) throws Exception {

		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPreProjectTransferRecord( com.pomplatform.db.bean.BasePreProjectTransferRecord bean, String additional ) throws Exception {

		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePreProjectTransferRecord> queryPreProjectTransferRecord( com.pomplatform.db.bean.BasePreProjectTransferRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePreProjectTransferRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePreProjectTransferRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePreProjectTransferRecord addToPreProjectTransferRecord ( BasePreProjectTransferRecord preprojecttransferrecord )  throws Exception {
		return addToPreProjectTransferRecord ( preprojecttransferrecord , false);
	}

	public static BasePreProjectTransferRecord addToPreProjectTransferRecord ( BasePreProjectTransferRecord preprojecttransferrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		dao.setDataFromBase(preprojecttransferrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePreProjectTransferRecord addUpdatePreProjectTransferRecord ( BasePreProjectTransferRecord preprojecttransferrecord ) throws Exception {
		return addUpdatePreProjectTransferRecord ( preprojecttransferrecord , false);
	}

	public static BasePreProjectTransferRecord addUpdatePreProjectTransferRecord ( BasePreProjectTransferRecord preprojecttransferrecord, boolean singleTransaction  ) throws Exception {
		if(preprojecttransferrecord.getPreProjectTransferRecordId() == null) return addToPreProjectTransferRecord(preprojecttransferrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		dao.setDataFromBase(preprojecttransferrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(preprojecttransferrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePreProjectTransferRecord ( BasePreProjectTransferRecord bean ) throws Exception {
		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePreProjectTransferRecord updatePreProjectTransferRecord ( BasePreProjectTransferRecord preprojecttransferrecord ) throws Exception {
		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		dao.setPreProjectTransferRecordId( preprojecttransferrecord.getPreProjectTransferRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(preprojecttransferrecord);
			result = dao.update();
		}
		return result == 1 ? preprojecttransferrecord : null ;
	}

	public static BasePreProjectTransferRecord updatePreProjectTransferRecordDirect( BasePreProjectTransferRecord preprojecttransferrecord ) throws Exception {
		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		int result = 0;
		dao.setDataFromBase(preprojecttransferrecord);
		result = dao.update();
		return result == 1 ? preprojecttransferrecord : null ;
	}

	public static int setDeleteConditions(BasePreProjectTransferRecord bean, PreProjectTransferRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPreProjectTransferRecordId() != null) {
			dao.setConditionPreProjectTransferRecordId("=", bean.getPreProjectTransferRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPreProjectId() != null) {
				dao.setConditionPreProjectId("=", bean.getPreProjectId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getTransferEmployeeId() != null) {
				dao.setConditionTransferEmployeeId("=", bean.getTransferEmployeeId());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePreProjectTransferRecord bean, PreProjectTransferRecord dao){
		int count = 0;
		if(bean.getPreProjectTransferRecordId() != null) {
			dao.setConditionPreProjectTransferRecordId("=", bean.getPreProjectTransferRecordId());
			count++;
		}
		if(bean.getPreProjectId() != null) {
			dao.setConditionPreProjectId("=", bean.getPreProjectId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getTransferEmployeeId() != null) {
			dao.setConditionTransferEmployeeId("=", bean.getTransferEmployeeId());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePreProjectTransferRecord bean = new BasePreProjectTransferRecord();
		bean.setDataFromJSON(json);
		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePreProjectTransferRecord> rlist = new BaseCollection<>();
		BasePreProjectTransferRecord bean = new BasePreProjectTransferRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePreProjectTransferRecord> result = dao.conditionalLoad(addtion);
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
		BasePreProjectTransferRecord bean = new BasePreProjectTransferRecord();
		bean.setDataFromJSON(json);
		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePreProjectTransferRecord bean = new BasePreProjectTransferRecord();
		bean.setDataFromJSON(json);
		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePreProjectTransferRecord bean = new BasePreProjectTransferRecord();
		bean.setDataFromJSON(json);
		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePreProjectTransferRecord bean = new BasePreProjectTransferRecord();
		bean.setDataFromJSON(json);
		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


