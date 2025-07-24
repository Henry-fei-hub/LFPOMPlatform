package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateSalaryAdvanceRecord;
import com.pomplatform.db.dao.PlateSalaryAdvanceRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlateSalaryAdvanceRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateSalaryAdvanceRecordHandler.class);

	public static BasePlateSalaryAdvanceRecord getPlateSalaryAdvanceRecordById( 
		java.lang.Integer plate_salary_advance_record_id
	) throws Exception
	{
		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		dao.setPlateSalaryAdvanceRecordId(plate_salary_advance_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateSalaryAdvanceRecordExists( com.pomplatform.db.bean.BasePlateSalaryAdvanceRecord bean, String additional ) throws Exception {

		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateSalaryAdvanceRecord( com.pomplatform.db.bean.BasePlateSalaryAdvanceRecord bean, String additional ) throws Exception {

		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateSalaryAdvanceRecord> queryPlateSalaryAdvanceRecord( com.pomplatform.db.bean.BasePlateSalaryAdvanceRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateSalaryAdvanceRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateSalaryAdvanceRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateSalaryAdvanceRecord addToPlateSalaryAdvanceRecord ( BasePlateSalaryAdvanceRecord platesalaryadvancerecord )  throws Exception {
		return addToPlateSalaryAdvanceRecord ( platesalaryadvancerecord , false);
	}

	public static BasePlateSalaryAdvanceRecord addToPlateSalaryAdvanceRecord ( BasePlateSalaryAdvanceRecord platesalaryadvancerecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		dao.setDataFromBase(platesalaryadvancerecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateSalaryAdvanceRecord addUpdatePlateSalaryAdvanceRecord ( BasePlateSalaryAdvanceRecord platesalaryadvancerecord ) throws Exception {
		return addUpdatePlateSalaryAdvanceRecord ( platesalaryadvancerecord , false);
	}

	public static BasePlateSalaryAdvanceRecord addUpdatePlateSalaryAdvanceRecord ( BasePlateSalaryAdvanceRecord platesalaryadvancerecord, boolean singleTransaction  ) throws Exception {
		if(platesalaryadvancerecord.getPlateSalaryAdvanceRecordId() == null) return addToPlateSalaryAdvanceRecord(platesalaryadvancerecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		dao.setDataFromBase(platesalaryadvancerecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(platesalaryadvancerecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateSalaryAdvanceRecord ( BasePlateSalaryAdvanceRecord bean ) throws Exception {
		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateSalaryAdvanceRecord updatePlateSalaryAdvanceRecord ( BasePlateSalaryAdvanceRecord platesalaryadvancerecord ) throws Exception {
		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		dao.setPlateSalaryAdvanceRecordId( platesalaryadvancerecord.getPlateSalaryAdvanceRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(platesalaryadvancerecord);
			result = dao.update();
		}
		return result == 1 ? platesalaryadvancerecord : null ;
	}

	public static BasePlateSalaryAdvanceRecord updatePlateSalaryAdvanceRecordDirect( BasePlateSalaryAdvanceRecord platesalaryadvancerecord ) throws Exception {
		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		int result = 0;
		dao.setDataFromBase(platesalaryadvancerecord);
		result = dao.update();
		return result == 1 ? platesalaryadvancerecord : null ;
	}

	public static int setDeleteConditions(BasePlateSalaryAdvanceRecord bean, PlateSalaryAdvanceRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateSalaryAdvanceRecordId() != null) {
			dao.setConditionPlateSalaryAdvanceRecordId("=", bean.getPlateSalaryAdvanceRecordId());
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
			if(bean.getEmployeeName() != null) {
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getIsReturn() != null) {
				dao.setConditionIsReturn("=", bean.getIsReturn());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePlateSalaryAdvanceRecord bean, PlateSalaryAdvanceRecord dao){
		int count = 0;
		if(bean.getPlateSalaryAdvanceRecordId() != null) {
			dao.setConditionPlateSalaryAdvanceRecordId("=", bean.getPlateSalaryAdvanceRecordId());
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
		if(bean.getEmployeeName() != null) {
			if(bean.getEmployeeName().indexOf("%") >= 0)
				dao.setConditionEmployeeName("like", bean.getEmployeeName());
			else
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getSalaryReturn() != null) {
			dao.setConditionSalaryReturn("=", bean.getSalaryReturn());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getIsReturn() != null) {
			dao.setConditionIsReturn("=", bean.getIsReturn());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePlateSalaryAdvanceRecord bean = new BasePlateSalaryAdvanceRecord();
		bean.setDataFromJSON(json);
		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateSalaryAdvanceRecord> rlist = new BaseCollection<>();
		BasePlateSalaryAdvanceRecord bean = new BasePlateSalaryAdvanceRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateSalaryAdvanceRecord> result = dao.conditionalLoad(addtion);
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
		BasePlateSalaryAdvanceRecord bean = new BasePlateSalaryAdvanceRecord();
		bean.setDataFromJSON(json);
		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateSalaryAdvanceRecord bean = new BasePlateSalaryAdvanceRecord();
		bean.setDataFromJSON(json);
		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateSalaryAdvanceRecord bean = new BasePlateSalaryAdvanceRecord();
		bean.setDataFromJSON(json);
		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateSalaryAdvanceRecord bean = new BasePlateSalaryAdvanceRecord();
		bean.setDataFromJSON(json);
		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


