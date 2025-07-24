package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeManagerRecord;
import com.pomplatform.db.dao.EmployeeManagerRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeManagerRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeManagerRecordHandler.class);

	public static BaseEmployeeManagerRecord getEmployeeManagerRecordById( 
		java.lang.Integer employee_manager_record_id
	) throws Exception
	{
		EmployeeManagerRecord dao = new EmployeeManagerRecord();
		dao.setEmployeeManagerRecordId(employee_manager_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeManagerRecordExists( com.pomplatform.db.bean.BaseEmployeeManagerRecord bean, String additional ) throws Exception {

		EmployeeManagerRecord dao = new EmployeeManagerRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeManagerRecord( com.pomplatform.db.bean.BaseEmployeeManagerRecord bean, String additional ) throws Exception {

		EmployeeManagerRecord dao = new EmployeeManagerRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeManagerRecord> queryEmployeeManagerRecord( com.pomplatform.db.bean.BaseEmployeeManagerRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeManagerRecord dao = new EmployeeManagerRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeManagerRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeManagerRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeManagerRecord addToEmployeeManagerRecord ( BaseEmployeeManagerRecord employeemanagerrecord )  throws Exception {
		return addToEmployeeManagerRecord ( employeemanagerrecord , false);
	}

	public static BaseEmployeeManagerRecord addToEmployeeManagerRecord ( BaseEmployeeManagerRecord employeemanagerrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeManagerRecord dao = new EmployeeManagerRecord();
		dao.setDataFromBase(employeemanagerrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeManagerRecord addUpdateEmployeeManagerRecord ( BaseEmployeeManagerRecord employeemanagerrecord ) throws Exception {
		return addUpdateEmployeeManagerRecord ( employeemanagerrecord , false);
	}

	public static BaseEmployeeManagerRecord addUpdateEmployeeManagerRecord ( BaseEmployeeManagerRecord employeemanagerrecord, boolean singleTransaction  ) throws Exception {
		if(employeemanagerrecord.getEmployeeManagerRecordId() == null) return addToEmployeeManagerRecord(employeemanagerrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeManagerRecord dao = new EmployeeManagerRecord();
		dao.setDataFromBase(employeemanagerrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeemanagerrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeManagerRecord ( BaseEmployeeManagerRecord bean ) throws Exception {
		EmployeeManagerRecord dao = new EmployeeManagerRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeManagerRecord updateEmployeeManagerRecord ( BaseEmployeeManagerRecord employeemanagerrecord ) throws Exception {
		EmployeeManagerRecord dao = new EmployeeManagerRecord();
		dao.setEmployeeManagerRecordId( employeemanagerrecord.getEmployeeManagerRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeemanagerrecord);
			result = dao.update();
		}
		return result == 1 ? employeemanagerrecord : null ;
	}

	public static BaseEmployeeManagerRecord updateEmployeeManagerRecordDirect( BaseEmployeeManagerRecord employeemanagerrecord ) throws Exception {
		EmployeeManagerRecord dao = new EmployeeManagerRecord();
		int result = 0;
		dao.setDataFromBase(employeemanagerrecord);
		result = dao.update();
		return result == 1 ? employeemanagerrecord : null ;
	}

	public static int setDeleteConditions(BaseEmployeeManagerRecord bean, EmployeeManagerRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeManagerRecordId() != null) {
			dao.setConditionEmployeeManagerRecordId("=", bean.getEmployeeManagerRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
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
		}
		return count;
	}

	public static int setConditions(BaseEmployeeManagerRecord bean, EmployeeManagerRecord dao){
		int count = 0;
		if(bean.getEmployeeManagerRecordId() != null) {
			dao.setConditionEmployeeManagerRecordId("=", bean.getEmployeeManagerRecordId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeManagerRecord bean = new BaseEmployeeManagerRecord();
		bean.setDataFromJSON(json);
		EmployeeManagerRecord dao = new EmployeeManagerRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeManagerRecord> rlist = new BaseCollection<>();
		BaseEmployeeManagerRecord bean = new BaseEmployeeManagerRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeManagerRecord dao = new EmployeeManagerRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeManagerRecord> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeManagerRecord bean = new BaseEmployeeManagerRecord();
		bean.setDataFromJSON(json);
		EmployeeManagerRecord dao = new EmployeeManagerRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeManagerRecord bean = new BaseEmployeeManagerRecord();
		bean.setDataFromJSON(json);
		EmployeeManagerRecord dao = new EmployeeManagerRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeManagerRecord bean = new BaseEmployeeManagerRecord();
		bean.setDataFromJSON(json);
		EmployeeManagerRecord dao = new EmployeeManagerRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeManagerRecord bean = new BaseEmployeeManagerRecord();
		bean.setDataFromJSON(json);
		EmployeeManagerRecord dao = new EmployeeManagerRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


