package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeSalaryReturnRecord;
import com.pomplatform.db.dao.EmployeeSalaryReturnRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeSalaryReturnRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeSalaryReturnRecordHandler.class);

	public static BaseEmployeeSalaryReturnRecord getEmployeeSalaryReturnRecordById( 
		java.lang.Integer employee_salary_return_record_id
	) throws Exception
	{
		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		dao.setEmployeeSalaryReturnRecordId(employee_salary_return_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeSalaryReturnRecordExists( com.pomplatform.db.bean.BaseEmployeeSalaryReturnRecord bean, String additional ) throws Exception {

		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeSalaryReturnRecord( com.pomplatform.db.bean.BaseEmployeeSalaryReturnRecord bean, String additional ) throws Exception {

		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeSalaryReturnRecord> queryEmployeeSalaryReturnRecord( com.pomplatform.db.bean.BaseEmployeeSalaryReturnRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeSalaryReturnRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeSalaryReturnRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeSalaryReturnRecord addToEmployeeSalaryReturnRecord ( BaseEmployeeSalaryReturnRecord employeesalaryreturnrecord )  throws Exception {
		return addToEmployeeSalaryReturnRecord ( employeesalaryreturnrecord , false);
	}

	public static BaseEmployeeSalaryReturnRecord addToEmployeeSalaryReturnRecord ( BaseEmployeeSalaryReturnRecord employeesalaryreturnrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		dao.setDataFromBase(employeesalaryreturnrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeSalaryReturnRecord addUpdateEmployeeSalaryReturnRecord ( BaseEmployeeSalaryReturnRecord employeesalaryreturnrecord ) throws Exception {
		return addUpdateEmployeeSalaryReturnRecord ( employeesalaryreturnrecord , false);
	}

	public static BaseEmployeeSalaryReturnRecord addUpdateEmployeeSalaryReturnRecord ( BaseEmployeeSalaryReturnRecord employeesalaryreturnrecord, boolean singleTransaction  ) throws Exception {
		if(employeesalaryreturnrecord.getEmployeeSalaryReturnRecordId() == null) return addToEmployeeSalaryReturnRecord(employeesalaryreturnrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		dao.setDataFromBase(employeesalaryreturnrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeesalaryreturnrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeSalaryReturnRecord ( BaseEmployeeSalaryReturnRecord bean ) throws Exception {
		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeSalaryReturnRecord updateEmployeeSalaryReturnRecord ( BaseEmployeeSalaryReturnRecord employeesalaryreturnrecord ) throws Exception {
		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		dao.setEmployeeSalaryReturnRecordId( employeesalaryreturnrecord.getEmployeeSalaryReturnRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeesalaryreturnrecord);
			result = dao.update();
		}
		return result == 1 ? employeesalaryreturnrecord : null ;
	}

	public static BaseEmployeeSalaryReturnRecord updateEmployeeSalaryReturnRecordDirect( BaseEmployeeSalaryReturnRecord employeesalaryreturnrecord ) throws Exception {
		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		int result = 0;
		dao.setDataFromBase(employeesalaryreturnrecord);
		result = dao.update();
		return result == 1 ? employeesalaryreturnrecord : null ;
	}

	public static int setDeleteConditions(BaseEmployeeSalaryReturnRecord bean, EmployeeSalaryReturnRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeSalaryReturnRecordId() != null) {
			dao.setConditionEmployeeSalaryReturnRecordId("=", bean.getEmployeeSalaryReturnRecordId());
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

	public static int setConditions(BaseEmployeeSalaryReturnRecord bean, EmployeeSalaryReturnRecord dao){
		int count = 0;
		if(bean.getEmployeeSalaryReturnRecordId() != null) {
			dao.setConditionEmployeeSalaryReturnRecordId("=", bean.getEmployeeSalaryReturnRecordId());
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
		BaseEmployeeSalaryReturnRecord bean = new BaseEmployeeSalaryReturnRecord();
		bean.setDataFromJSON(json);
		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeSalaryReturnRecord> rlist = new BaseCollection<>();
		BaseEmployeeSalaryReturnRecord bean = new BaseEmployeeSalaryReturnRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeSalaryReturnRecord> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeSalaryReturnRecord bean = new BaseEmployeeSalaryReturnRecord();
		bean.setDataFromJSON(json);
		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeSalaryReturnRecord bean = new BaseEmployeeSalaryReturnRecord();
		bean.setDataFromJSON(json);
		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeSalaryReturnRecord bean = new BaseEmployeeSalaryReturnRecord();
		bean.setDataFromJSON(json);
		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeSalaryReturnRecord bean = new BaseEmployeeSalaryReturnRecord();
		bean.setDataFromJSON(json);
		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


