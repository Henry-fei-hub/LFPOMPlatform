package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseEmployeeDayCheck;
import java.util.List;
import com.pomplatform.db.dao.EmployeeDayCheck;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class EmployeeDayCheckHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeDayCheckHandler.class);

	public static BaseEmployeeDayCheck getEmployeeDayCheckById( 
		java.lang.Integer employee_day_check_id
	) throws Exception
	{
		EmployeeDayCheck dao = new EmployeeDayCheck();
		dao.setEmployeeDayCheckId(employee_day_check_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeDayCheckExists( com.pomplatform.db.bean.BaseEmployeeDayCheck bean, String additional ) throws Exception {

		EmployeeDayCheck dao = new EmployeeDayCheck();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeDayCheck( com.pomplatform.db.bean.BaseEmployeeDayCheck bean, String additional ) throws Exception {

		EmployeeDayCheck dao = new EmployeeDayCheck();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeDayCheck> queryEmployeeDayCheck( com.pomplatform.db.bean.BaseEmployeeDayCheck bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeDayCheck dao = new EmployeeDayCheck();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeDayCheck> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeDayCheck> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeDayCheck addToEmployeeDayCheck ( BaseEmployeeDayCheck employeedaycheck )  throws Exception {
		return addToEmployeeDayCheck ( employeedaycheck , false);
	}

	public static BaseEmployeeDayCheck addToEmployeeDayCheck ( BaseEmployeeDayCheck employeedaycheck, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeDayCheck dao = new EmployeeDayCheck();
		dao.setDataFromBase(employeedaycheck);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeDayCheck addUpdateEmployeeDayCheck ( BaseEmployeeDayCheck employeedaycheck ) throws Exception {
		return addUpdateEmployeeDayCheck ( employeedaycheck , false);
	}

	public static BaseEmployeeDayCheck addUpdateEmployeeDayCheck ( BaseEmployeeDayCheck employeedaycheck, boolean singleTransaction  ) throws Exception {
		if(employeedaycheck.getEmployeeDayCheckId() == null) return addToEmployeeDayCheck(employeedaycheck);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeDayCheck dao = new EmployeeDayCheck();
		dao.setDataFromBase(employeedaycheck);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeedaycheck); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeDayCheck ( BaseEmployeeDayCheck bean ) throws Exception {
		EmployeeDayCheck dao = new EmployeeDayCheck();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeDayCheck updateEmployeeDayCheck ( BaseEmployeeDayCheck employeedaycheck ) throws Exception {
		EmployeeDayCheck dao = new EmployeeDayCheck();
		dao.setEmployeeDayCheckId( employeedaycheck.getEmployeeDayCheckId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeedaycheck);
			result = dao.update();
		}
		return result == 1 ? employeedaycheck : null ;
	}

	public static BaseEmployeeDayCheck updateEmployeeDayCheckDirect( BaseEmployeeDayCheck employeedaycheck ) throws Exception {
		EmployeeDayCheck dao = new EmployeeDayCheck();
		int result = 0;
		dao.setDataFromBase(employeedaycheck);
		result = dao.update();
		return result == 1 ? employeedaycheck : null ;
	}

	public static int setDeleteConditions(BaseEmployeeDayCheck bean, EmployeeDayCheck dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeDayCheckId() != null) {
			dao.setConditionEmployeeDayCheckId("=", bean.getEmployeeDayCheckId());
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
			if(bean.getShiftManageId() != null) {
				dao.setConditionShiftManageId("=", bean.getShiftManageId());
				count++;
			}
			if(bean.getLateLeave5m() != null) {
				dao.setConditionLateLeave5m("=", bean.getLateLeave5m());
				count++;
			}
			if(bean.getLateLeave10m() != null) {
				dao.setConditionLateLeave10m("=", bean.getLateLeave10m());
				count++;
			}
			if(bean.getLateLeave30m() != null) {
				dao.setConditionLateLeave30m("=", bean.getLateLeave30m());
				count++;
			}
			if(bean.getLateLeave() != null) {
				dao.setConditionLateLeave("=", bean.getLateLeave());
				count++;
			}
			if(bean.getThingLeaveTimes() != null) {
				dao.setConditionThingLeaveTimes("=", bean.getThingLeaveTimes());
				count++;
			}
			if(bean.getIllLeaveTimes() != null) {
				dao.setConditionIllLeaveTimes("=", bean.getIllLeaveTimes());
				count++;
			}
			if(bean.getOtherLeaveTimes() != null) {
				dao.setConditionOtherLeaveTimes("=", bean.getOtherLeaveTimes());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
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
			if(bean.getIsLocked() != null) {
				dao.setConditionIsLocked("=", bean.getIsLocked());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeDayCheck bean, EmployeeDayCheck dao){
		int count = 0;
		if(bean.getEmployeeDayCheckId() != null) {
			dao.setConditionEmployeeDayCheckId("=", bean.getEmployeeDayCheckId());
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
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getShiftManageId() != null) {
			dao.setConditionShiftManageId("=", bean.getShiftManageId());
			count++;
		}
		if(bean.getCheckin() != null) {
			dao.setConditionCheckin(">=", bean.getCheckin());
			count++;
		}
		if(bean.getCheckout() != null) {
			dao.setConditionCheckout(">=", bean.getCheckout());
			count++;
		}
		if(bean.getLateLeave5m() != null) {
			dao.setConditionLateLeave5m("=", bean.getLateLeave5m());
			count++;
		}
		if(bean.getLateLeave10m() != null) {
			dao.setConditionLateLeave10m("=", bean.getLateLeave10m());
			count++;
		}
		if(bean.getLateLeave30m() != null) {
			dao.setConditionLateLeave30m("=", bean.getLateLeave30m());
			count++;
		}
		if(bean.getLateLeave() != null) {
			dao.setConditionLateLeave("=", bean.getLateLeave());
			count++;
		}
		if(bean.getThingLeaveTimes() != null) {
			dao.setConditionThingLeaveTimes("=", bean.getThingLeaveTimes());
			count++;
		}
		if(bean.getThingLeaveHours() != null) {
			dao.setConditionThingLeaveHours("=", bean.getThingLeaveHours());
			count++;
		}
		if(bean.getThingLeaveDays() != null) {
			dao.setConditionThingLeaveDays("=", bean.getThingLeaveDays());
			count++;
		}
		if(bean.getIllLeaveTimes() != null) {
			dao.setConditionIllLeaveTimes("=", bean.getIllLeaveTimes());
			count++;
		}
		if(bean.getIllLeaveHours() != null) {
			dao.setConditionIllLeaveHours("=", bean.getIllLeaveHours());
			count++;
		}
		if(bean.getIllLeaveDays() != null) {
			dao.setConditionIllLeaveDays("=", bean.getIllLeaveDays());
			count++;
		}
		if(bean.getOtherLeaveTimes() != null) {
			dao.setConditionOtherLeaveTimes("=", bean.getOtherLeaveTimes());
			count++;
		}
		if(bean.getOtherLeaveHours() != null) {
			dao.setConditionOtherLeaveHours("=", bean.getOtherLeaveHours());
			count++;
		}
		if(bean.getOtherLeaveDays() != null) {
			dao.setConditionOtherLeaveDays("=", bean.getOtherLeaveDays());
			count++;
		}
		if(bean.getNornalOvertimeHours() != null) {
			dao.setConditionNornalOvertimeHours("=", bean.getNornalOvertimeHours());
			count++;
		}
		if(bean.getWeekendOvertimeHours() != null) {
			dao.setConditionWeekendOvertimeHours("=", bean.getWeekendOvertimeHours());
			count++;
		}
		if(bean.getHolidayOvertimeHours() != null) {
			dao.setConditionHolidayOvertimeHours("=", bean.getHolidayOvertimeHours());
			count++;
		}
		if(bean.getAbsenceDays() != null) {
			dao.setConditionAbsenceDays("=", bean.getAbsenceDays());
			count++;
		}
		if(bean.getShouldDays() != null) {
			dao.setConditionShouldDays("=", bean.getShouldDays());
			count++;
		}
		if(bean.getFactDays() != null) {
			dao.setConditionFactDays("=", bean.getFactDays());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
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
		if(bean.getIsLocked() != null) {
			dao.setConditionIsLocked("=", bean.getIsLocked());
			count++;
		}
		if(bean.getNumberOfLate() != null) {
			dao.setConditionNumberOfLate("=", bean.getNumberOfLate());
			count++;
		}
		if(bean.getLateForMinutes() != null) {
			dao.setConditionLateForMinutes("=", bean.getLateForMinutes());
			count++;
		}
		if(bean.getNumberOfLeave() != null) {
			dao.setConditionNumberOfLeave("=", bean.getNumberOfLeave());
			count++;
		}
		if(bean.getLeaveForMinutes() != null) {
			dao.setConditionLeaveForMinutes("=", bean.getLeaveForMinutes());
			count++;
		}
		if(bean.getLateCharge() != null) {
			dao.setConditionLateCharge("=", bean.getLateCharge());
			count++;
		}
		if(bean.getAdjust() != null) {
			dao.setConditionAdjust("=", bean.getAdjust());
			count++;
		}
		if(bean.getAnnualLeave() != null) {
			dao.setConditionAnnualLeave("=", bean.getAnnualLeave());
			count++;
		}
		if(bean.getWeddingLeave() != null) {
			dao.setConditionWeddingLeave("=", bean.getWeddingLeave());
			count++;
		}
		if(bean.getMaternityLeave() != null) {
			dao.setConditionMaternityLeave("=", bean.getMaternityLeave());
			count++;
		}
		if(bean.getPrenatalCheckLeave() != null) {
			dao.setConditionPrenatalCheckLeave("=", bean.getPrenatalCheckLeave());
			count++;
		}
		if(bean.getMaternityLeaveDays() != null) {
			dao.setConditionMaternityLeaveDays("=", bean.getMaternityLeaveDays());
			count++;
		}
		if(bean.getFuneralLeave() != null) {
			dao.setConditionFuneralLeave("=", bean.getFuneralLeave());
			count++;
		}
		if(bean.getOutForBusiness() != null) {
			dao.setConditionOutForBusiness("=", bean.getOutForBusiness());
			count++;
		}
		if(bean.getOvertimePay() != null) {
			dao.setConditionOvertimePay("=", bean.getOvertimePay());
			count++;
		}
		if(bean.getOvertimePaySub() != null) {
			dao.setConditionOvertimePaySub("=", bean.getOvertimePaySub());
			count++;
		}
		if(bean.getOvertimePaySubBefore() != null) {
			dao.setConditionOvertimePaySubBefore("=", bean.getOvertimePaySubBefore());
			count++;
		}
		if(bean.getOvertimePayBefore() != null) {
			dao.setConditionOvertimePayBefore("=", bean.getOvertimePayBefore());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeDayCheck bean = new BaseEmployeeDayCheck();
		bean.setDataFromJSON(json);
		EmployeeDayCheck dao = new EmployeeDayCheck();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeDayCheck> rlist = new BaseCollection<>();
		BaseEmployeeDayCheck bean = new BaseEmployeeDayCheck();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeDayCheck dao = new EmployeeDayCheck();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeDayCheck> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeDayCheck bean = new BaseEmployeeDayCheck();
		bean.setDataFromJSON(json);
		EmployeeDayCheck dao = new EmployeeDayCheck();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeDayCheck bean = new BaseEmployeeDayCheck();
		bean.setDataFromJSON(json);
		EmployeeDayCheck dao = new EmployeeDayCheck();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeDayCheck bean = new BaseEmployeeDayCheck();
		bean.setDataFromJSON(json);
		EmployeeDayCheck dao = new EmployeeDayCheck();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeDayCheck bean = new BaseEmployeeDayCheck();
		bean.setDataFromJSON(json);
		EmployeeDayCheck dao = new EmployeeDayCheck();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


