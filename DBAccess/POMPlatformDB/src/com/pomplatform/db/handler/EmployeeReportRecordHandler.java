package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeReportRecord;
import com.pomplatform.db.dao.EmployeeReportRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeReportRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeReportRecordHandler.class);

	public static BaseEmployeeReportRecord getEmployeeReportRecordById( 
		java.lang.Integer employee_report_record_id
	) throws Exception
	{
		EmployeeReportRecord dao = new EmployeeReportRecord();
		dao.setEmployeeReportRecordId(employee_report_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeReportRecordExists( com.pomplatform.db.bean.BaseEmployeeReportRecord bean, String additional ) throws Exception {

		EmployeeReportRecord dao = new EmployeeReportRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeReportRecord( com.pomplatform.db.bean.BaseEmployeeReportRecord bean, String additional ) throws Exception {

		EmployeeReportRecord dao = new EmployeeReportRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeReportRecord> queryEmployeeReportRecord( com.pomplatform.db.bean.BaseEmployeeReportRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeReportRecord dao = new EmployeeReportRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeReportRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeReportRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeReportRecord addToEmployeeReportRecord ( BaseEmployeeReportRecord employeereportrecord )  throws Exception {
		return addToEmployeeReportRecord ( employeereportrecord , false);
	}

	public static BaseEmployeeReportRecord addToEmployeeReportRecord ( BaseEmployeeReportRecord employeereportrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeReportRecord dao = new EmployeeReportRecord();
		dao.setDataFromBase(employeereportrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeReportRecord addUpdateEmployeeReportRecord ( BaseEmployeeReportRecord employeereportrecord ) throws Exception {
		return addUpdateEmployeeReportRecord ( employeereportrecord , false);
	}

	public static BaseEmployeeReportRecord addUpdateEmployeeReportRecord ( BaseEmployeeReportRecord employeereportrecord, boolean singleTransaction  ) throws Exception {
		if(employeereportrecord.getEmployeeReportRecordId() == null) return addToEmployeeReportRecord(employeereportrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeReportRecord dao = new EmployeeReportRecord();
		dao.setDataFromBase(employeereportrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeereportrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeReportRecord ( BaseEmployeeReportRecord bean ) throws Exception {
		EmployeeReportRecord dao = new EmployeeReportRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeReportRecord updateEmployeeReportRecord ( BaseEmployeeReportRecord employeereportrecord ) throws Exception {
		EmployeeReportRecord dao = new EmployeeReportRecord();
		dao.setEmployeeReportRecordId( employeereportrecord.getEmployeeReportRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeereportrecord);
			result = dao.update();
		}
		return result == 1 ? employeereportrecord : null ;
	}

	public static BaseEmployeeReportRecord updateEmployeeReportRecordDirect( BaseEmployeeReportRecord employeereportrecord ) throws Exception {
		EmployeeReportRecord dao = new EmployeeReportRecord();
		int result = 0;
		dao.setDataFromBase(employeereportrecord);
		result = dao.update();
		return result == 1 ? employeereportrecord : null ;
	}

	public static int setDeleteConditions(BaseEmployeeReportRecord bean, EmployeeReportRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeReportRecordId() != null) {
			dao.setConditionEmployeeReportRecordId("=", bean.getEmployeeReportRecordId());
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
			if(bean.getIsLock() != null) {
				dao.setConditionIsLock("=", bean.getIsLock());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeReportRecord bean, EmployeeReportRecord dao){
		int count = 0;
		if(bean.getEmployeeReportRecordId() != null) {
			dao.setConditionEmployeeReportRecordId("=", bean.getEmployeeReportRecordId());
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
		if(bean.getSureIntegral() != null) {
			dao.setConditionSureIntegral("=", bean.getSureIntegral());
			count++;
		}
		if(bean.getManagerProjectIntegral() != null) {
			dao.setConditionManagerProjectIntegral("=", bean.getManagerProjectIntegral());
			count++;
		}
		if(bean.getSalaryAdvance() != null) {
			dao.setConditionSalaryAdvance("=", bean.getSalaryAdvance());
			count++;
		}
		if(bean.getSalaryReturn() != null) {
			dao.setConditionSalaryReturn("=", bean.getSalaryReturn());
			count++;
		}
		if(bean.getSalary() != null) {
			dao.setConditionSalary("=", bean.getSalary());
			count++;
		}
		if(bean.getProjectCost() != null) {
			dao.setConditionProjectCost("=", bean.getProjectCost());
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
		if(bean.getProjectAdvance() != null) {
			dao.setConditionProjectAdvance("=", bean.getProjectAdvance());
			count++;
		}
		if(bean.getBonusPayment() != null) {
			dao.setConditionBonusPayment("=", bean.getBonusPayment());
			count++;
		}
		if(bean.getIntegralReturn() != null) {
			dao.setConditionIntegralReturn("=", bean.getIntegralReturn());
			count++;
		}
		if(bean.getViolationCharges() != null) {
			dao.setConditionViolationCharges("=", bean.getViolationCharges());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeReportRecord bean = new BaseEmployeeReportRecord();
		bean.setDataFromJSON(json);
		EmployeeReportRecord dao = new EmployeeReportRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeReportRecord> rlist = new BaseCollection<>();
		BaseEmployeeReportRecord bean = new BaseEmployeeReportRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeReportRecord dao = new EmployeeReportRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeReportRecord> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeReportRecord bean = new BaseEmployeeReportRecord();
		bean.setDataFromJSON(json);
		EmployeeReportRecord dao = new EmployeeReportRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeReportRecord bean = new BaseEmployeeReportRecord();
		bean.setDataFromJSON(json);
		EmployeeReportRecord dao = new EmployeeReportRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeReportRecord bean = new BaseEmployeeReportRecord();
		bean.setDataFromJSON(json);
		EmployeeReportRecord dao = new EmployeeReportRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeReportRecord bean = new BaseEmployeeReportRecord();
		bean.setDataFromJSON(json);
		EmployeeReportRecord dao = new EmployeeReportRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


