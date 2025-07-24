package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateIntegralAssignRecord;
import com.pomplatform.db.dao.PlateIntegralAssignRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlateIntegralAssignRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateIntegralAssignRecordHandler.class);

	public static BasePlateIntegralAssignRecord getPlateIntegralAssignRecordById( 
		java.lang.Integer plate_integral_assign_record_id
	) throws Exception
	{
		PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
		dao.setPlateIntegralAssignRecordId(plate_integral_assign_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateIntegralAssignRecordExists( com.pomplatform.db.bean.BasePlateIntegralAssignRecord bean, String additional ) throws Exception {

		PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateIntegralAssignRecord( com.pomplatform.db.bean.BasePlateIntegralAssignRecord bean, String additional ) throws Exception {

		PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateIntegralAssignRecord> queryPlateIntegralAssignRecord( com.pomplatform.db.bean.BasePlateIntegralAssignRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateIntegralAssignRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateIntegralAssignRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateIntegralAssignRecord addToPlateIntegralAssignRecord ( BasePlateIntegralAssignRecord plateintegralassignrecord )  throws Exception {
		return addToPlateIntegralAssignRecord ( plateintegralassignrecord , false);
	}

	public static BasePlateIntegralAssignRecord addToPlateIntegralAssignRecord ( BasePlateIntegralAssignRecord plateintegralassignrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
		dao.setDataFromBase(plateintegralassignrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateIntegralAssignRecord addUpdatePlateIntegralAssignRecord ( BasePlateIntegralAssignRecord plateintegralassignrecord ) throws Exception {
		return addUpdatePlateIntegralAssignRecord ( plateintegralassignrecord , false);
	}

	public static BasePlateIntegralAssignRecord addUpdatePlateIntegralAssignRecord ( BasePlateIntegralAssignRecord plateintegralassignrecord, boolean singleTransaction  ) throws Exception {
		if(plateintegralassignrecord.getPlateIntegralAssignRecordId() == null) return addToPlateIntegralAssignRecord(plateintegralassignrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
		dao.setDataFromBase(plateintegralassignrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(plateintegralassignrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateIntegralAssignRecord ( BasePlateIntegralAssignRecord bean ) throws Exception {
		PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateIntegralAssignRecord updatePlateIntegralAssignRecord ( BasePlateIntegralAssignRecord plateintegralassignrecord ) throws Exception {
		PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
		dao.setPlateIntegralAssignRecordId( plateintegralassignrecord.getPlateIntegralAssignRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(plateintegralassignrecord);
			result = dao.update();
		}
		return result == 1 ? plateintegralassignrecord : null ;
	}

	public static BasePlateIntegralAssignRecord updatePlateIntegralAssignRecordDirect( BasePlateIntegralAssignRecord plateintegralassignrecord ) throws Exception {
		PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
		int result = 0;
		dao.setDataFromBase(plateintegralassignrecord);
		result = dao.update();
		return result == 1 ? plateintegralassignrecord : null ;
	}

	public static int setDeleteConditions(BasePlateIntegralAssignRecord bean, PlateIntegralAssignRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateIntegralAssignRecordId() != null) {
			dao.setConditionPlateIntegralAssignRecordId("=", bean.getPlateIntegralAssignRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
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

	public static int setConditions(BasePlateIntegralAssignRecord bean, PlateIntegralAssignRecord dao){
		int count = 0;
		if(bean.getPlateIntegralAssignRecordId() != null) {
			dao.setConditionPlateIntegralAssignRecordId("=", bean.getPlateIntegralAssignRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getAssignIntegral() != null) {
			dao.setConditionAssignIntegral("=", bean.getAssignIntegral());
			count++;
		}
		if(bean.getAssignDate() != null) {
			dao.setConditionAssignDate(">=", bean.getAssignDate());
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
		BasePlateIntegralAssignRecord bean = new BasePlateIntegralAssignRecord();
		bean.setDataFromJSON(json);
		PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateIntegralAssignRecord> rlist = new BaseCollection<>();
		BasePlateIntegralAssignRecord bean = new BasePlateIntegralAssignRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateIntegralAssignRecord> result = dao.conditionalLoad(addtion);
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
		BasePlateIntegralAssignRecord bean = new BasePlateIntegralAssignRecord();
		bean.setDataFromJSON(json);
		PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateIntegralAssignRecord bean = new BasePlateIntegralAssignRecord();
		bean.setDataFromJSON(json);
		PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateIntegralAssignRecord bean = new BasePlateIntegralAssignRecord();
		bean.setDataFromJSON(json);
		PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateIntegralAssignRecord bean = new BasePlateIntegralAssignRecord();
		bean.setDataFromJSON(json);
		PlateIntegralAssignRecord dao = new PlateIntegralAssignRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


