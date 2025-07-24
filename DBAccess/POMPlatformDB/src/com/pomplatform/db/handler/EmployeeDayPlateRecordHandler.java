package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeDayPlateRecord;
import com.pomplatform.db.dao.EmployeeDayPlateRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeDayPlateRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeDayPlateRecordHandler.class);

	public static BaseEmployeeDayPlateRecord getEmployeeDayPlateRecordById( 
		java.lang.Integer employee_day_plate_record_id
	) throws Exception
	{
		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
		dao.setEmployeeDayPlateRecordId(employee_day_plate_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeDayPlateRecordExists( com.pomplatform.db.bean.BaseEmployeeDayPlateRecord bean, String additional ) throws Exception {

		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeDayPlateRecord( com.pomplatform.db.bean.BaseEmployeeDayPlateRecord bean, String additional ) throws Exception {

		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeDayPlateRecord> queryEmployeeDayPlateRecord( com.pomplatform.db.bean.BaseEmployeeDayPlateRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeDayPlateRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeDayPlateRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeDayPlateRecord addToEmployeeDayPlateRecord ( BaseEmployeeDayPlateRecord employeedayplaterecord )  throws Exception {
		return addToEmployeeDayPlateRecord ( employeedayplaterecord , false);
	}

	public static BaseEmployeeDayPlateRecord addToEmployeeDayPlateRecord ( BaseEmployeeDayPlateRecord employeedayplaterecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
		dao.setDataFromBase(employeedayplaterecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeDayPlateRecord addUpdateEmployeeDayPlateRecord ( BaseEmployeeDayPlateRecord employeedayplaterecord ) throws Exception {
		return addUpdateEmployeeDayPlateRecord ( employeedayplaterecord , false);
	}

	public static BaseEmployeeDayPlateRecord addUpdateEmployeeDayPlateRecord ( BaseEmployeeDayPlateRecord employeedayplaterecord, boolean singleTransaction  ) throws Exception {
		if(employeedayplaterecord.getEmployeeDayPlateRecordId() == null) return addToEmployeeDayPlateRecord(employeedayplaterecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
		dao.setDataFromBase(employeedayplaterecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeedayplaterecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeDayPlateRecord ( BaseEmployeeDayPlateRecord bean ) throws Exception {
		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeDayPlateRecord updateEmployeeDayPlateRecord ( BaseEmployeeDayPlateRecord employeedayplaterecord ) throws Exception {
		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
		dao.setEmployeeDayPlateRecordId( employeedayplaterecord.getEmployeeDayPlateRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeedayplaterecord);
			result = dao.update();
		}
		return result == 1 ? employeedayplaterecord : null ;
	}

	public static BaseEmployeeDayPlateRecord updateEmployeeDayPlateRecordDirect( BaseEmployeeDayPlateRecord employeedayplaterecord ) throws Exception {
		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
		int result = 0;
		dao.setDataFromBase(employeedayplaterecord);
		result = dao.update();
		return result == 1 ? employeedayplaterecord : null ;
	}

	public static int setDeleteConditions(BaseEmployeeDayPlateRecord bean, EmployeeDayPlateRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeDayPlateRecordId() != null) {
			dao.setConditionEmployeeDayPlateRecordId("=", bean.getEmployeeDayPlateRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getEmployeeName() != null) {
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getOnboardStatus() != null) {
				dao.setConditionOnboardStatus("=", bean.getOnboardStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeDayPlateRecord bean, EmployeeDayPlateRecord dao){
		int count = 0;
		if(bean.getEmployeeDayPlateRecordId() != null) {
			dao.setConditionEmployeeDayPlateRecordId("=", bean.getEmployeeDayPlateRecordId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getEmployeeName() != null) {
			if(bean.getEmployeeName().indexOf("%") >= 0)
				dao.setConditionEmployeeName("like", bean.getEmployeeName());
			else
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getOnboardStatus() != null) {
			dao.setConditionOnboardStatus("=", bean.getOnboardStatus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeDayPlateRecord bean = new BaseEmployeeDayPlateRecord();
		bean.setDataFromJSON(json);
		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeDayPlateRecord> rlist = new BaseCollection<>();
		BaseEmployeeDayPlateRecord bean = new BaseEmployeeDayPlateRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeDayPlateRecord> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeDayPlateRecord bean = new BaseEmployeeDayPlateRecord();
		bean.setDataFromJSON(json);
		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeDayPlateRecord bean = new BaseEmployeeDayPlateRecord();
		bean.setDataFromJSON(json);
		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeDayPlateRecord bean = new BaseEmployeeDayPlateRecord();
		bean.setDataFromJSON(json);
		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeDayPlateRecord bean = new BaseEmployeeDayPlateRecord();
		bean.setDataFromJSON(json);
		EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


