package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord;
import com.pomplatform.db.dao.EmployeeAchieveIntegralReturnRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeAchieveIntegralReturnRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeAchieveIntegralReturnRecordHandler.class);

	public static BaseEmployeeAchieveIntegralReturnRecord getEmployeeAchieveIntegralReturnRecordById( 
		java.lang.Integer employee_achieve_integral_return_record_id
	) throws Exception
	{
		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		dao.setEmployeeAchieveIntegralReturnRecordId(employee_achieve_integral_return_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeAchieveIntegralReturnRecordExists( com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord bean, String additional ) throws Exception {

		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeAchieveIntegralReturnRecord( com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord bean, String additional ) throws Exception {

		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeAchieveIntegralReturnRecord> queryEmployeeAchieveIntegralReturnRecord( com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeAchieveIntegralReturnRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeAchieveIntegralReturnRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeAchieveIntegralReturnRecord addToEmployeeAchieveIntegralReturnRecord ( BaseEmployeeAchieveIntegralReturnRecord employeeachieveintegralreturnrecord )  throws Exception {
		return addToEmployeeAchieveIntegralReturnRecord ( employeeachieveintegralreturnrecord , false);
	}

	public static BaseEmployeeAchieveIntegralReturnRecord addToEmployeeAchieveIntegralReturnRecord ( BaseEmployeeAchieveIntegralReturnRecord employeeachieveintegralreturnrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		dao.setDataFromBase(employeeachieveintegralreturnrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeAchieveIntegralReturnRecord addUpdateEmployeeAchieveIntegralReturnRecord ( BaseEmployeeAchieveIntegralReturnRecord employeeachieveintegralreturnrecord ) throws Exception {
		return addUpdateEmployeeAchieveIntegralReturnRecord ( employeeachieveintegralreturnrecord , false);
	}

	public static BaseEmployeeAchieveIntegralReturnRecord addUpdateEmployeeAchieveIntegralReturnRecord ( BaseEmployeeAchieveIntegralReturnRecord employeeachieveintegralreturnrecord, boolean singleTransaction  ) throws Exception {
		if(employeeachieveintegralreturnrecord.getEmployeeAchieveIntegralReturnRecordId() == null) return addToEmployeeAchieveIntegralReturnRecord(employeeachieveintegralreturnrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		dao.setDataFromBase(employeeachieveintegralreturnrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeeachieveintegralreturnrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeAchieveIntegralReturnRecord ( BaseEmployeeAchieveIntegralReturnRecord bean ) throws Exception {
		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeAchieveIntegralReturnRecord updateEmployeeAchieveIntegralReturnRecord ( BaseEmployeeAchieveIntegralReturnRecord employeeachieveintegralreturnrecord ) throws Exception {
		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		dao.setEmployeeAchieveIntegralReturnRecordId( employeeachieveintegralreturnrecord.getEmployeeAchieveIntegralReturnRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeeachieveintegralreturnrecord);
			result = dao.update();
		}
		return result == 1 ? employeeachieveintegralreturnrecord : null ;
	}

	public static BaseEmployeeAchieveIntegralReturnRecord updateEmployeeAchieveIntegralReturnRecordDirect( BaseEmployeeAchieveIntegralReturnRecord employeeachieveintegralreturnrecord ) throws Exception {
		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		int result = 0;
		dao.setDataFromBase(employeeachieveintegralreturnrecord);
		result = dao.update();
		return result == 1 ? employeeachieveintegralreturnrecord : null ;
	}

	public static int setDeleteConditions(BaseEmployeeAchieveIntegralReturnRecord bean, EmployeeAchieveIntegralReturnRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeAchieveIntegralReturnRecordId() != null) {
			dao.setConditionEmployeeAchieveIntegralReturnRecordId("=", bean.getEmployeeAchieveIntegralReturnRecordId());
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
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeAchieveIntegralReturnRecord bean, EmployeeAchieveIntegralReturnRecord dao){
		int count = 0;
		if(bean.getEmployeeAchieveIntegralReturnRecordId() != null) {
			dao.setConditionEmployeeAchieveIntegralReturnRecordId("=", bean.getEmployeeAchieveIntegralReturnRecordId());
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
		if(bean.getAchieveIntegral() != null) {
			dao.setConditionAchieveIntegral("=", bean.getAchieveIntegral());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeAchieveIntegralReturnRecord bean = new BaseEmployeeAchieveIntegralReturnRecord();
		bean.setDataFromJSON(json);
		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeAchieveIntegralReturnRecord> rlist = new BaseCollection<>();
		BaseEmployeeAchieveIntegralReturnRecord bean = new BaseEmployeeAchieveIntegralReturnRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeAchieveIntegralReturnRecord> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeAchieveIntegralReturnRecord bean = new BaseEmployeeAchieveIntegralReturnRecord();
		bean.setDataFromJSON(json);
		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeAchieveIntegralReturnRecord bean = new BaseEmployeeAchieveIntegralReturnRecord();
		bean.setDataFromJSON(json);
		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeAchieveIntegralReturnRecord bean = new BaseEmployeeAchieveIntegralReturnRecord();
		bean.setDataFromJSON(json);
		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeAchieveIntegralReturnRecord bean = new BaseEmployeeAchieveIntegralReturnRecord();
		bean.setDataFromJSON(json);
		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


