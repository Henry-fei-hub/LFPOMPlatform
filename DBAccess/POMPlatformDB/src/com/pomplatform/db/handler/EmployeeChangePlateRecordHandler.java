package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeChangePlateRecord;
import com.pomplatform.db.dao.EmployeeChangePlateRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeChangePlateRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeChangePlateRecordHandler.class);

	public static BaseEmployeeChangePlateRecord getEmployeeChangePlateRecordById( 
		java.lang.Integer employee_change_plate_record_id
	) throws Exception
	{
		EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
		dao.setEmployeeChangePlateRecordId(employee_change_plate_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeChangePlateRecordExists( com.pomplatform.db.bean.BaseEmployeeChangePlateRecord bean, String additional ) throws Exception {

		EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeChangePlateRecord( com.pomplatform.db.bean.BaseEmployeeChangePlateRecord bean, String additional ) throws Exception {

		EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeChangePlateRecord> queryEmployeeChangePlateRecord( com.pomplatform.db.bean.BaseEmployeeChangePlateRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeChangePlateRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeChangePlateRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeChangePlateRecord addToEmployeeChangePlateRecord ( BaseEmployeeChangePlateRecord employeechangeplaterecord )  throws Exception {
		return addToEmployeeChangePlateRecord ( employeechangeplaterecord , false);
	}

	public static BaseEmployeeChangePlateRecord addToEmployeeChangePlateRecord ( BaseEmployeeChangePlateRecord employeechangeplaterecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
		dao.setDataFromBase(employeechangeplaterecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeChangePlateRecord addUpdateEmployeeChangePlateRecord ( BaseEmployeeChangePlateRecord employeechangeplaterecord ) throws Exception {
		return addUpdateEmployeeChangePlateRecord ( employeechangeplaterecord , false);
	}

	public static BaseEmployeeChangePlateRecord addUpdateEmployeeChangePlateRecord ( BaseEmployeeChangePlateRecord employeechangeplaterecord, boolean singleTransaction  ) throws Exception {
		if(employeechangeplaterecord.getEmployeeChangePlateRecordId() == null) return addToEmployeeChangePlateRecord(employeechangeplaterecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
		dao.setDataFromBase(employeechangeplaterecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeechangeplaterecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeChangePlateRecord ( BaseEmployeeChangePlateRecord bean ) throws Exception {
		EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeChangePlateRecord updateEmployeeChangePlateRecord ( BaseEmployeeChangePlateRecord employeechangeplaterecord ) throws Exception {
		EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
		dao.setEmployeeChangePlateRecordId( employeechangeplaterecord.getEmployeeChangePlateRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeechangeplaterecord);
			result = dao.update();
		}
		return result == 1 ? employeechangeplaterecord : null ;
	}

	public static BaseEmployeeChangePlateRecord updateEmployeeChangePlateRecordDirect( BaseEmployeeChangePlateRecord employeechangeplaterecord ) throws Exception {
		EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
		int result = 0;
		dao.setDataFromBase(employeechangeplaterecord);
		result = dao.update();
		return result == 1 ? employeechangeplaterecord : null ;
	}

	public static int setDeleteConditions(BaseEmployeeChangePlateRecord bean, EmployeeChangePlateRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeChangePlateRecordId() != null) {
			dao.setConditionEmployeeChangePlateRecordId("=", bean.getEmployeeChangePlateRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
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
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeChangePlateRecord bean, EmployeeChangePlateRecord dao){
		int count = 0;
		if(bean.getEmployeeChangePlateRecordId() != null) {
			dao.setConditionEmployeeChangePlateRecordId("=", bean.getEmployeeChangePlateRecordId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
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
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		if(bean.getChangePlateDate() != null) {
			dao.setConditionChangePlateDate(">=", bean.getChangePlateDate());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeChangePlateRecord bean = new BaseEmployeeChangePlateRecord();
		bean.setDataFromJSON(json);
		EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeChangePlateRecord> rlist = new BaseCollection<>();
		BaseEmployeeChangePlateRecord bean = new BaseEmployeeChangePlateRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeChangePlateRecord> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeChangePlateRecord bean = new BaseEmployeeChangePlateRecord();
		bean.setDataFromJSON(json);
		EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeChangePlateRecord bean = new BaseEmployeeChangePlateRecord();
		bean.setDataFromJSON(json);
		EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeChangePlateRecord bean = new BaseEmployeeChangePlateRecord();
		bean.setDataFromJSON(json);
		EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeChangePlateRecord bean = new BaseEmployeeChangePlateRecord();
		bean.setDataFromJSON(json);
		EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


