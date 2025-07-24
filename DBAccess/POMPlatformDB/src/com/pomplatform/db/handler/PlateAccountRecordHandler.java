package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateAccountRecord;
import com.pomplatform.db.dao.PlateAccountRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlateAccountRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateAccountRecordHandler.class);

	public static BasePlateAccountRecord getPlateAccountRecordById( 
		java.lang.Integer plate_account_record_id
	) throws Exception
	{
		PlateAccountRecord dao = new PlateAccountRecord();
		dao.setPlateAccountRecordId(plate_account_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateAccountRecordExists( com.pomplatform.db.bean.BasePlateAccountRecord bean, String additional ) throws Exception {

		PlateAccountRecord dao = new PlateAccountRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateAccountRecord( com.pomplatform.db.bean.BasePlateAccountRecord bean, String additional ) throws Exception {

		PlateAccountRecord dao = new PlateAccountRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateAccountRecord> queryPlateAccountRecord( com.pomplatform.db.bean.BasePlateAccountRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateAccountRecord dao = new PlateAccountRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateAccountRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateAccountRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateAccountRecord addToPlateAccountRecord ( BasePlateAccountRecord plateaccountrecord )  throws Exception {
		return addToPlateAccountRecord ( plateaccountrecord , false);
	}

	public static BasePlateAccountRecord addToPlateAccountRecord ( BasePlateAccountRecord plateaccountrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateAccountRecord dao = new PlateAccountRecord();
		dao.setDataFromBase(plateaccountrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateAccountRecord addUpdatePlateAccountRecord ( BasePlateAccountRecord plateaccountrecord ) throws Exception {
		return addUpdatePlateAccountRecord ( plateaccountrecord , false);
	}

	public static BasePlateAccountRecord addUpdatePlateAccountRecord ( BasePlateAccountRecord plateaccountrecord, boolean singleTransaction  ) throws Exception {
		if(plateaccountrecord.getPlateAccountRecordId() == null) return addToPlateAccountRecord(plateaccountrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateAccountRecord dao = new PlateAccountRecord();
		dao.setDataFromBase(plateaccountrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(plateaccountrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateAccountRecord ( BasePlateAccountRecord bean ) throws Exception {
		PlateAccountRecord dao = new PlateAccountRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateAccountRecord updatePlateAccountRecord ( BasePlateAccountRecord plateaccountrecord ) throws Exception {
		PlateAccountRecord dao = new PlateAccountRecord();
		dao.setPlateAccountRecordId( plateaccountrecord.getPlateAccountRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(plateaccountrecord);
			result = dao.update();
		}
		return result == 1 ? plateaccountrecord : null ;
	}

	public static BasePlateAccountRecord updatePlateAccountRecordDirect( BasePlateAccountRecord plateaccountrecord ) throws Exception {
		PlateAccountRecord dao = new PlateAccountRecord();
		int result = 0;
		dao.setDataFromBase(plateaccountrecord);
		result = dao.update();
		return result == 1 ? plateaccountrecord : null ;
	}

	public static int setDeleteConditions(BasePlateAccountRecord bean, PlateAccountRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateAccountRecordId() != null) {
			dao.setConditionPlateAccountRecordId("=", bean.getPlateAccountRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
			if(bean.getBusinessTypeId() != null) {
				dao.setConditionBusinessTypeId("=", bean.getBusinessTypeId());
				count++;
			}
			if(bean.getIsLock() != null) {
				dao.setConditionIsLock("=", bean.getIsLock());
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
		}
		return count;
	}

	public static int setConditions(BasePlateAccountRecord bean, PlateAccountRecord dao){
		int count = 0;
		if(bean.getPlateAccountRecordId() != null) {
			dao.setConditionPlateAccountRecordId("=", bean.getPlateAccountRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		if(bean.getBusinessTypeId() != null) {
			dao.setConditionBusinessTypeId("=", bean.getBusinessTypeId());
			count++;
		}
		if(bean.getIntegral() != null) {
			dao.setConditionIntegral("=", bean.getIntegral());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getIsLock() != null) {
			dao.setConditionIsLock("=", bean.getIsLock());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePlateAccountRecord bean = new BasePlateAccountRecord();
		bean.setDataFromJSON(json);
		PlateAccountRecord dao = new PlateAccountRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateAccountRecord> rlist = new BaseCollection<>();
		BasePlateAccountRecord bean = new BasePlateAccountRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateAccountRecord dao = new PlateAccountRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateAccountRecord> result = dao.conditionalLoad(addtion);
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
		BasePlateAccountRecord bean = new BasePlateAccountRecord();
		bean.setDataFromJSON(json);
		PlateAccountRecord dao = new PlateAccountRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateAccountRecord bean = new BasePlateAccountRecord();
		bean.setDataFromJSON(json);
		PlateAccountRecord dao = new PlateAccountRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateAccountRecord bean = new BasePlateAccountRecord();
		bean.setDataFromJSON(json);
		PlateAccountRecord dao = new PlateAccountRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateAccountRecord bean = new BasePlateAccountRecord();
		bean.setDataFromJSON(json);
		PlateAccountRecord dao = new PlateAccountRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


