package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateIntegralTransferRecord;
import com.pomplatform.db.dao.PlateIntegralTransferRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlateIntegralTransferRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateIntegralTransferRecordHandler.class);

	public static BasePlateIntegralTransferRecord getPlateIntegralTransferRecordById( 
		java.lang.Integer plate_integral_transfer_record_id
	) throws Exception
	{
		PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
		dao.setPlateIntegralTransferRecordId(plate_integral_transfer_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateIntegralTransferRecordExists( com.pomplatform.db.bean.BasePlateIntegralTransferRecord bean, String additional ) throws Exception {

		PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateIntegralTransferRecord( com.pomplatform.db.bean.BasePlateIntegralTransferRecord bean, String additional ) throws Exception {

		PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateIntegralTransferRecord> queryPlateIntegralTransferRecord( com.pomplatform.db.bean.BasePlateIntegralTransferRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateIntegralTransferRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateIntegralTransferRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateIntegralTransferRecord addToPlateIntegralTransferRecord ( BasePlateIntegralTransferRecord plateintegraltransferrecord )  throws Exception {
		return addToPlateIntegralTransferRecord ( plateintegraltransferrecord , false);
	}

	public static BasePlateIntegralTransferRecord addToPlateIntegralTransferRecord ( BasePlateIntegralTransferRecord plateintegraltransferrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
		dao.setDataFromBase(plateintegraltransferrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateIntegralTransferRecord addUpdatePlateIntegralTransferRecord ( BasePlateIntegralTransferRecord plateintegraltransferrecord ) throws Exception {
		return addUpdatePlateIntegralTransferRecord ( plateintegraltransferrecord , false);
	}

	public static BasePlateIntegralTransferRecord addUpdatePlateIntegralTransferRecord ( BasePlateIntegralTransferRecord plateintegraltransferrecord, boolean singleTransaction  ) throws Exception {
		if(plateintegraltransferrecord.getPlateIntegralTransferRecordId() == null) return addToPlateIntegralTransferRecord(plateintegraltransferrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
		dao.setDataFromBase(plateintegraltransferrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(plateintegraltransferrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateIntegralTransferRecord ( BasePlateIntegralTransferRecord bean ) throws Exception {
		PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateIntegralTransferRecord updatePlateIntegralTransferRecord ( BasePlateIntegralTransferRecord plateintegraltransferrecord ) throws Exception {
		PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
		dao.setPlateIntegralTransferRecordId( plateintegraltransferrecord.getPlateIntegralTransferRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(plateintegraltransferrecord);
			result = dao.update();
		}
		return result == 1 ? plateintegraltransferrecord : null ;
	}

	public static BasePlateIntegralTransferRecord updatePlateIntegralTransferRecordDirect( BasePlateIntegralTransferRecord plateintegraltransferrecord ) throws Exception {
		PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
		int result = 0;
		dao.setDataFromBase(plateintegraltransferrecord);
		result = dao.update();
		return result == 1 ? plateintegraltransferrecord : null ;
	}

	public static int setDeleteConditions(BasePlateIntegralTransferRecord bean, PlateIntegralTransferRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateIntegralTransferRecordId() != null) {
			dao.setConditionPlateIntegralTransferRecordId("=", bean.getPlateIntegralTransferRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFromPlateId() != null) {
				dao.setConditionFromPlateId("=", bean.getFromPlateId());
				count++;
			}
			if(bean.getToPlateId() != null) {
				dao.setConditionToPlateId("=", bean.getToPlateId());
				count++;
			}
			if(bean.getPlateEmployeeId() != null) {
				dao.setConditionPlateEmployeeId("=", bean.getPlateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePlateIntegralTransferRecord bean, PlateIntegralTransferRecord dao){
		int count = 0;
		if(bean.getPlateIntegralTransferRecordId() != null) {
			dao.setConditionPlateIntegralTransferRecordId("=", bean.getPlateIntegralTransferRecordId());
			count++;
		}
		if(bean.getFromPlateId() != null) {
			dao.setConditionFromPlateId("=", bean.getFromPlateId());
			count++;
		}
		if(bean.getToPlateId() != null) {
			dao.setConditionToPlateId("=", bean.getToPlateId());
			count++;
		}
		if(bean.getTransferIntegral() != null) {
			dao.setConditionTransferIntegral("=", bean.getTransferIntegral());
			count++;
		}
		if(bean.getTransferDate() != null) {
			dao.setConditionTransferDate(">=", bean.getTransferDate());
			count++;
		}
		if(bean.getPlateEmployeeId() != null) {
			dao.setConditionPlateEmployeeId("=", bean.getPlateEmployeeId());
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
		BasePlateIntegralTransferRecord bean = new BasePlateIntegralTransferRecord();
		bean.setDataFromJSON(json);
		PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateIntegralTransferRecord> rlist = new BaseCollection<>();
		BasePlateIntegralTransferRecord bean = new BasePlateIntegralTransferRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateIntegralTransferRecord> result = dao.conditionalLoad(addtion);
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
		BasePlateIntegralTransferRecord bean = new BasePlateIntegralTransferRecord();
		bean.setDataFromJSON(json);
		PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateIntegralTransferRecord bean = new BasePlateIntegralTransferRecord();
		bean.setDataFromJSON(json);
		PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateIntegralTransferRecord bean = new BasePlateIntegralTransferRecord();
		bean.setDataFromJSON(json);
		PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateIntegralTransferRecord bean = new BasePlateIntegralTransferRecord();
		bean.setDataFromJSON(json);
		PlateIntegralTransferRecord dao = new PlateIntegralTransferRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


