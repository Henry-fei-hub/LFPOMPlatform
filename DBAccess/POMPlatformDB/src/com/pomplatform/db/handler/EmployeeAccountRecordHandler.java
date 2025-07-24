package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeAccountRecord;
import com.pomplatform.db.dao.EmployeeAccountRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeAccountRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeAccountRecordHandler.class);

	public static BaseEmployeeAccountRecord getEmployeeAccountRecordById( 
		java.lang.Integer employee_account_record_id
	) throws Exception
	{
		EmployeeAccountRecord dao = new EmployeeAccountRecord();
		dao.setEmployeeAccountRecordId(employee_account_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeAccountRecordExists( com.pomplatform.db.bean.BaseEmployeeAccountRecord bean, String additional ) throws Exception {

		EmployeeAccountRecord dao = new EmployeeAccountRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeAccountRecord( com.pomplatform.db.bean.BaseEmployeeAccountRecord bean, String additional ) throws Exception {

		EmployeeAccountRecord dao = new EmployeeAccountRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeAccountRecord> queryEmployeeAccountRecord( com.pomplatform.db.bean.BaseEmployeeAccountRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeAccountRecord dao = new EmployeeAccountRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeAccountRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeAccountRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeAccountRecord addToEmployeeAccountRecord ( BaseEmployeeAccountRecord employeeaccountrecord )  throws Exception {
		return addToEmployeeAccountRecord ( employeeaccountrecord , false);
	}

	public static BaseEmployeeAccountRecord addToEmployeeAccountRecord ( BaseEmployeeAccountRecord employeeaccountrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeAccountRecord dao = new EmployeeAccountRecord();
		dao.setDataFromBase(employeeaccountrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeAccountRecord addUpdateEmployeeAccountRecord ( BaseEmployeeAccountRecord employeeaccountrecord ) throws Exception {
		return addUpdateEmployeeAccountRecord ( employeeaccountrecord , false);
	}

	public static BaseEmployeeAccountRecord addUpdateEmployeeAccountRecord ( BaseEmployeeAccountRecord employeeaccountrecord, boolean singleTransaction  ) throws Exception {
		if(employeeaccountrecord.getEmployeeAccountRecordId() == null) return addToEmployeeAccountRecord(employeeaccountrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeAccountRecord dao = new EmployeeAccountRecord();
		dao.setDataFromBase(employeeaccountrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeeaccountrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeAccountRecord ( BaseEmployeeAccountRecord bean ) throws Exception {
		EmployeeAccountRecord dao = new EmployeeAccountRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeAccountRecord updateEmployeeAccountRecord ( BaseEmployeeAccountRecord employeeaccountrecord ) throws Exception {
		EmployeeAccountRecord dao = new EmployeeAccountRecord();
		dao.setEmployeeAccountRecordId( employeeaccountrecord.getEmployeeAccountRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeeaccountrecord);
			result = dao.update();
		}
		return result == 1 ? employeeaccountrecord : null ;
	}

	public static BaseEmployeeAccountRecord updateEmployeeAccountRecordDirect( BaseEmployeeAccountRecord employeeaccountrecord ) throws Exception {
		EmployeeAccountRecord dao = new EmployeeAccountRecord();
		int result = 0;
		dao.setDataFromBase(employeeaccountrecord);
		result = dao.update();
		return result == 1 ? employeeaccountrecord : null ;
	}

	public static int setDeleteConditions(BaseEmployeeAccountRecord bean, EmployeeAccountRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeAccountRecordId() != null) {
			dao.setConditionEmployeeAccountRecordId("=", bean.getEmployeeAccountRecordId());
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

	public static int setConditions(BaseEmployeeAccountRecord bean, EmployeeAccountRecord dao){
		int count = 0;
		if(bean.getEmployeeAccountRecordId() != null) {
			dao.setConditionEmployeeAccountRecordId("=", bean.getEmployeeAccountRecordId());
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
		BaseEmployeeAccountRecord bean = new BaseEmployeeAccountRecord();
		bean.setDataFromJSON(json);
		EmployeeAccountRecord dao = new EmployeeAccountRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeAccountRecord> rlist = new BaseCollection<>();
		BaseEmployeeAccountRecord bean = new BaseEmployeeAccountRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeAccountRecord dao = new EmployeeAccountRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeAccountRecord> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeAccountRecord bean = new BaseEmployeeAccountRecord();
		bean.setDataFromJSON(json);
		EmployeeAccountRecord dao = new EmployeeAccountRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeAccountRecord bean = new BaseEmployeeAccountRecord();
		bean.setDataFromJSON(json);
		EmployeeAccountRecord dao = new EmployeeAccountRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeAccountRecord bean = new BaseEmployeeAccountRecord();
		bean.setDataFromJSON(json);
		EmployeeAccountRecord dao = new EmployeeAccountRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeAccountRecord bean = new BaseEmployeeAccountRecord();
		bean.setDataFromJSON(json);
		EmployeeAccountRecord dao = new EmployeeAccountRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


