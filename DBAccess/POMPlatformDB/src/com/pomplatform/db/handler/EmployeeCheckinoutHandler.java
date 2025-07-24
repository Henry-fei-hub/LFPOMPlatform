package com.pomplatform.db.handler;

import java.util.List;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeCheckinout;
import com.pomplatform.db.dao.EmployeeCheckinout;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;

public class EmployeeCheckinoutHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeCheckinoutHandler.class);

	public static BaseEmployeeCheckinout getEmployeeCheckinoutById( 
		java.lang.Integer employee_check_id
	) throws Exception
	{
		EmployeeCheckinout dao = new EmployeeCheckinout();
		dao.setEmployeeCheckId(employee_check_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeCheckinoutExists( com.pomplatform.db.bean.BaseEmployeeCheckinout bean, String additional ) throws Exception {

		EmployeeCheckinout dao = new EmployeeCheckinout();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeCheckinout( com.pomplatform.db.bean.BaseEmployeeCheckinout bean, String additional ) throws Exception {

		EmployeeCheckinout dao = new EmployeeCheckinout();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeCheckinout> queryEmployeeCheckinout( com.pomplatform.db.bean.BaseEmployeeCheckinout bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeCheckinout dao = new EmployeeCheckinout();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeCheckinout> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeCheckinout> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeCheckinout addToEmployeeCheckinout ( BaseEmployeeCheckinout employeecheckinout )  throws Exception {
		return addToEmployeeCheckinout ( employeecheckinout , false);
	}

	public static BaseEmployeeCheckinout addToEmployeeCheckinout ( BaseEmployeeCheckinout employeecheckinout, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeCheckinout dao = new EmployeeCheckinout();
		dao.setDataFromBase(employeecheckinout);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeCheckinout addUpdateEmployeeCheckinout ( BaseEmployeeCheckinout employeecheckinout ) throws Exception {
		return addUpdateEmployeeCheckinout ( employeecheckinout , false);
	}

	public static BaseEmployeeCheckinout addUpdateEmployeeCheckinout ( BaseEmployeeCheckinout employeecheckinout, boolean singleTransaction  ) throws Exception {
		if(employeecheckinout.getEmployeeCheckId() == null) return addToEmployeeCheckinout(employeecheckinout);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeCheckinout dao = new EmployeeCheckinout();
		dao.setDataFromBase(employeecheckinout);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeecheckinout); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeCheckinout ( BaseEmployeeCheckinout bean ) throws Exception {
		EmployeeCheckinout dao = new EmployeeCheckinout();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeCheckinout updateEmployeeCheckinout ( BaseEmployeeCheckinout employeecheckinout ) throws Exception {
		EmployeeCheckinout dao = new EmployeeCheckinout();
		dao.setEmployeeCheckId( employeecheckinout.getEmployeeCheckId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeecheckinout);
			result = dao.update();
		}
		return result == 1 ? employeecheckinout : null ;
	}

	public static BaseEmployeeCheckinout updateEmployeeCheckinoutDirect( BaseEmployeeCheckinout employeecheckinout ) throws Exception {
		EmployeeCheckinout dao = new EmployeeCheckinout();
		int result = 0;
		dao.setDataFromBase(employeecheckinout);
		result = dao.update();
		return result == 1 ? employeecheckinout : null ;
	}

	public static int setDeleteConditions(BaseEmployeeCheckinout bean, EmployeeCheckinout dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeCheckId() != null) {
			dao.setConditionEmployeeCheckId("=", bean.getEmployeeCheckId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getOaEmployeeId() != null) {
				dao.setConditionOaEmployeeId("=", bean.getOaEmployeeId());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getFinalStatus() != null) {
				dao.setConditionFinalStatus("=", bean.getFinalStatus());
				count++;
			}
			if(bean.getDayOfWeek() != null) {
				dao.setConditionDayOfWeek("=", bean.getDayOfWeek());
				count++;
			}
			if(bean.getWeekOfYear() != null) {
				dao.setConditionWeekOfYear("=", bean.getWeekOfYear());
				count++;
			}
			if(bean.getBigWeek() != null) {
				dao.setConditionBigWeek("=", bean.getBigWeek());
				count++;
			}
			if(bean.getComments() != null) {
				dao.setConditionComments("=", bean.getComments());
				count++;
			}
			if(bean.getLateTime() != null) {
				dao.setConditionLateTime("=", bean.getLateTime());
				count++;
			}
			if(bean.getIsWorkDay() != null) {
				dao.setConditionIsWorkDay("=", bean.getIsWorkDay());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeCheckinout bean, EmployeeCheckinout dao){
		int count = 0;
		if(bean.getEmployeeCheckId() != null) {
			dao.setConditionEmployeeCheckId("=", bean.getEmployeeCheckId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getCheckDate() != null) {
			dao.setConditionCheckDate(">=", bean.getCheckDate());
			count++;
		}
		if(bean.getCheckInTime() != null) {
			dao.setConditionCheckInTime(">=", bean.getCheckInTime());
			count++;
		}
		if(bean.getCheckOutTime() != null) {
			dao.setConditionCheckOutTime(">=", bean.getCheckOutTime());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getOaEmployeeId() != null) {
			dao.setConditionOaEmployeeId("=", bean.getOaEmployeeId());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getFinalStatus() != null) {
			dao.setConditionFinalStatus("=", bean.getFinalStatus());
			count++;
		}
		if(bean.getDayOfWeek() != null) {
			dao.setConditionDayOfWeek("=", bean.getDayOfWeek());
			count++;
		}
		if(bean.getWeekOfYear() != null) {
			dao.setConditionWeekOfYear("=", bean.getWeekOfYear());
			count++;
		}
		if(bean.getBigWeek() != null) {
			dao.setConditionBigWeek("=", bean.getBigWeek());
			count++;
		}
		if(bean.getComments() != null) {
			if(bean.getComments().indexOf("%") >= 0)
				dao.setConditionComments("like", bean.getComments());
			else
				dao.setConditionComments("=", bean.getComments());
			count++;
		}
		if(bean.getLateTime() != null) {
			dao.setConditionLateTime("=", bean.getLateTime());
			count++;
		}
		if(bean.getIsWorkDay() != null) {
			dao.setConditionIsWorkDay("=", bean.getIsWorkDay());
			count++;
		}
		if(bean.getOverTime() != null) {
			dao.setConditionOverTime("=", bean.getOverTime());
			count++;
		}
		if(bean.getLeaveDays() != null) {
			dao.setConditionLeaveDays("=", bean.getLeaveDays());
			count++;
		}
		if(bean.getLeaveHours() != null) {
			dao.setConditionLeaveHours("=", bean.getLeaveHours());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeCheckinout bean = new BaseEmployeeCheckinout();
		bean.setDataFromJSON(json);
		EmployeeCheckinout dao = new EmployeeCheckinout();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeCheckinout> rlist = new BaseCollection<>();
		BaseEmployeeCheckinout bean = new BaseEmployeeCheckinout();
		bean.setDataFromJSON(json);
		EmployeeCheckinout dao = new EmployeeCheckinout();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeCheckinout> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeCheckinout bean = new BaseEmployeeCheckinout();
		bean.setDataFromJSON(json);
		EmployeeCheckinout dao = new EmployeeCheckinout();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeCheckinout bean = new BaseEmployeeCheckinout();
		bean.setDataFromJSON(json);
		EmployeeCheckinout dao = new EmployeeCheckinout();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeCheckinout bean = new BaseEmployeeCheckinout();
		bean.setDataFromJSON(json);
		EmployeeCheckinout dao = new EmployeeCheckinout();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeCheckinout bean = new BaseEmployeeCheckinout();
		bean.setDataFromJSON(json);
		EmployeeCheckinout dao = new EmployeeCheckinout();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


