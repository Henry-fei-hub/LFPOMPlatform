package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeCostRecord;
import com.pomplatform.db.dao.EmployeeCostRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeCostRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeCostRecordHandler.class);

	public static BaseEmployeeCostRecord getEmployeeCostRecordById( 
		java.lang.Integer employee_cost_record_id
	) throws Exception
	{
		EmployeeCostRecord dao = new EmployeeCostRecord();
		dao.setEmployeeCostRecordId(employee_cost_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeCostRecordExists( com.pomplatform.db.bean.BaseEmployeeCostRecord bean, String additional ) throws Exception {

		EmployeeCostRecord dao = new EmployeeCostRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeCostRecord( com.pomplatform.db.bean.BaseEmployeeCostRecord bean, String additional ) throws Exception {

		EmployeeCostRecord dao = new EmployeeCostRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeCostRecord> queryEmployeeCostRecord( com.pomplatform.db.bean.BaseEmployeeCostRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeCostRecord dao = new EmployeeCostRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeCostRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeCostRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeCostRecord addToEmployeeCostRecord ( BaseEmployeeCostRecord employeecostrecord )  throws Exception {
		return addToEmployeeCostRecord ( employeecostrecord , false);
	}

	public static BaseEmployeeCostRecord addToEmployeeCostRecord ( BaseEmployeeCostRecord employeecostrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeCostRecord dao = new EmployeeCostRecord();
		dao.setDataFromBase(employeecostrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeCostRecord addUpdateEmployeeCostRecord ( BaseEmployeeCostRecord employeecostrecord ) throws Exception {
		return addUpdateEmployeeCostRecord ( employeecostrecord , false);
	}

	public static BaseEmployeeCostRecord addUpdateEmployeeCostRecord ( BaseEmployeeCostRecord employeecostrecord, boolean singleTransaction  ) throws Exception {
		if(employeecostrecord.getEmployeeCostRecordId() == null) return addToEmployeeCostRecord(employeecostrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeCostRecord dao = new EmployeeCostRecord();
		dao.setDataFromBase(employeecostrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeecostrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeCostRecord ( BaseEmployeeCostRecord bean ) throws Exception {
		EmployeeCostRecord dao = new EmployeeCostRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeCostRecord updateEmployeeCostRecord ( BaseEmployeeCostRecord employeecostrecord ) throws Exception {
		EmployeeCostRecord dao = new EmployeeCostRecord();
		dao.setEmployeeCostRecordId( employeecostrecord.getEmployeeCostRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeecostrecord);
			result = dao.update();
		}
		return result == 1 ? employeecostrecord : null ;
	}

	public static BaseEmployeeCostRecord updateEmployeeCostRecordDirect( BaseEmployeeCostRecord employeecostrecord ) throws Exception {
		EmployeeCostRecord dao = new EmployeeCostRecord();
		int result = 0;
		dao.setDataFromBase(employeecostrecord);
		result = dao.update();
		return result == 1 ? employeecostrecord : null ;
	}

	public static int setDeleteConditions(BaseEmployeeCostRecord bean, EmployeeCostRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeCostRecordId() != null) {
			dao.setConditionEmployeeCostRecordId("=", bean.getEmployeeCostRecordId());
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
		}
		return count;
	}

	public static int setConditions(BaseEmployeeCostRecord bean, EmployeeCostRecord dao){
		int count = 0;
		if(bean.getEmployeeCostRecordId() != null) {
			dao.setConditionEmployeeCostRecordId("=", bean.getEmployeeCostRecordId());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeCostRecord bean = new BaseEmployeeCostRecord();
		bean.setDataFromJSON(json);
		EmployeeCostRecord dao = new EmployeeCostRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeCostRecord> rlist = new BaseCollection<>();
		BaseEmployeeCostRecord bean = new BaseEmployeeCostRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeCostRecord dao = new EmployeeCostRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeCostRecord> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeCostRecord bean = new BaseEmployeeCostRecord();
		bean.setDataFromJSON(json);
		EmployeeCostRecord dao = new EmployeeCostRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeCostRecord bean = new BaseEmployeeCostRecord();
		bean.setDataFromJSON(json);
		EmployeeCostRecord dao = new EmployeeCostRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeCostRecord bean = new BaseEmployeeCostRecord();
		bean.setDataFromJSON(json);
		EmployeeCostRecord dao = new EmployeeCostRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeCostRecord bean = new BaseEmployeeCostRecord();
		bean.setDataFromJSON(json);
		EmployeeCostRecord dao = new EmployeeCostRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


