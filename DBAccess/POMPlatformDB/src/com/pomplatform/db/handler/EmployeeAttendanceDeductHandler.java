package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeAttendanceDeduct;
import com.pomplatform.db.dao.EmployeeAttendanceDeduct;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeAttendanceDeductHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeAttendanceDeductHandler.class);

	public static BaseEmployeeAttendanceDeduct getEmployeeAttendanceDeductById( 
		java.lang.Integer employee_attendance_deduct_id
	) throws Exception
	{
		EmployeeAttendanceDeduct dao = new EmployeeAttendanceDeduct();
		dao.setEmployeeAttendanceDeductId(employee_attendance_deduct_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeAttendanceDeductExists( com.pomplatform.db.bean.BaseEmployeeAttendanceDeduct bean, String additional ) throws Exception {

		EmployeeAttendanceDeduct dao = new EmployeeAttendanceDeduct();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeAttendanceDeduct( com.pomplatform.db.bean.BaseEmployeeAttendanceDeduct bean, String additional ) throws Exception {

		EmployeeAttendanceDeduct dao = new EmployeeAttendanceDeduct();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeAttendanceDeduct> queryEmployeeAttendanceDeduct( com.pomplatform.db.bean.BaseEmployeeAttendanceDeduct bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeAttendanceDeduct dao = new EmployeeAttendanceDeduct();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeAttendanceDeduct> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeAttendanceDeduct> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeAttendanceDeduct addToEmployeeAttendanceDeduct ( BaseEmployeeAttendanceDeduct employeeattendancededuct )  throws Exception {
		return addToEmployeeAttendanceDeduct ( employeeattendancededuct , false);
	}

	public static BaseEmployeeAttendanceDeduct addToEmployeeAttendanceDeduct ( BaseEmployeeAttendanceDeduct employeeattendancededuct, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeAttendanceDeduct dao = new EmployeeAttendanceDeduct();
		dao.setDataFromBase(employeeattendancededuct);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeAttendanceDeduct addUpdateEmployeeAttendanceDeduct ( BaseEmployeeAttendanceDeduct employeeattendancededuct ) throws Exception {
		return addUpdateEmployeeAttendanceDeduct ( employeeattendancededuct , false);
	}

	public static BaseEmployeeAttendanceDeduct addUpdateEmployeeAttendanceDeduct ( BaseEmployeeAttendanceDeduct employeeattendancededuct, boolean singleTransaction  ) throws Exception {
		if(employeeattendancededuct.getEmployeeAttendanceDeductId() == null) return addToEmployeeAttendanceDeduct(employeeattendancededuct);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeAttendanceDeduct dao = new EmployeeAttendanceDeduct();
		dao.setDataFromBase(employeeattendancededuct);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeeattendancededuct); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeAttendanceDeduct ( BaseEmployeeAttendanceDeduct bean ) throws Exception {
		EmployeeAttendanceDeduct dao = new EmployeeAttendanceDeduct();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeAttendanceDeduct updateEmployeeAttendanceDeduct ( BaseEmployeeAttendanceDeduct employeeattendancededuct ) throws Exception {
		EmployeeAttendanceDeduct dao = new EmployeeAttendanceDeduct();
		dao.setEmployeeAttendanceDeductId( employeeattendancededuct.getEmployeeAttendanceDeductId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeeattendancededuct);
			result = dao.update();
		}
		return result == 1 ? employeeattendancededuct : null ;
	}

	public static BaseEmployeeAttendanceDeduct updateEmployeeAttendanceDeductDirect( BaseEmployeeAttendanceDeduct employeeattendancededuct ) throws Exception {
		EmployeeAttendanceDeduct dao = new EmployeeAttendanceDeduct();
		int result = 0;
		dao.setDataFromBase(employeeattendancededuct);
		result = dao.update();
		return result == 1 ? employeeattendancededuct : null ;
	}

	public static int setDeleteConditions(BaseEmployeeAttendanceDeduct bean, EmployeeAttendanceDeduct dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeAttendanceDeductId() != null) {
			dao.setConditionEmployeeAttendanceDeductId("=", bean.getEmployeeAttendanceDeductId());
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

	public static int setConditions(BaseEmployeeAttendanceDeduct bean, EmployeeAttendanceDeduct dao){
		int count = 0;
		if(bean.getEmployeeAttendanceDeductId() != null) {
			dao.setConditionEmployeeAttendanceDeductId("=", bean.getEmployeeAttendanceDeductId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
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
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
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
		BaseEmployeeAttendanceDeduct bean = new BaseEmployeeAttendanceDeduct();
		bean.setDataFromJSON(json);
		EmployeeAttendanceDeduct dao = new EmployeeAttendanceDeduct();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeAttendanceDeduct> rlist = new BaseCollection<>();
		BaseEmployeeAttendanceDeduct bean = new BaseEmployeeAttendanceDeduct();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeAttendanceDeduct dao = new EmployeeAttendanceDeduct();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeAttendanceDeduct> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeAttendanceDeduct bean = new BaseEmployeeAttendanceDeduct();
		bean.setDataFromJSON(json);
		EmployeeAttendanceDeduct dao = new EmployeeAttendanceDeduct();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeAttendanceDeduct bean = new BaseEmployeeAttendanceDeduct();
		bean.setDataFromJSON(json);
		EmployeeAttendanceDeduct dao = new EmployeeAttendanceDeduct();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeAttendanceDeduct bean = new BaseEmployeeAttendanceDeduct();
		bean.setDataFromJSON(json);
		EmployeeAttendanceDeduct dao = new EmployeeAttendanceDeduct();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeAttendanceDeduct bean = new BaseEmployeeAttendanceDeduct();
		bean.setDataFromJSON(json);
		EmployeeAttendanceDeduct dao = new EmployeeAttendanceDeduct();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


