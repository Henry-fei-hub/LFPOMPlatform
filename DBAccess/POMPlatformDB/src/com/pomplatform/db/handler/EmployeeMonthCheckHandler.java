package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseEmployeeMonthCheck;
import java.util.List;
import com.pomplatform.db.dao.EmployeeMonthCheck;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class EmployeeMonthCheckHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeMonthCheckHandler.class);

	public static BaseEmployeeMonthCheck getEmployeeMonthCheckById( 
		java.lang.Integer employee_month_check_id
	) throws Exception
	{
		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		dao.setEmployeeMonthCheckId(employee_month_check_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeMonthCheckExists( com.pomplatform.db.bean.BaseEmployeeMonthCheck bean, String additional ) throws Exception {

		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeMonthCheck( com.pomplatform.db.bean.BaseEmployeeMonthCheck bean, String additional ) throws Exception {

		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeMonthCheck> queryEmployeeMonthCheck( com.pomplatform.db.bean.BaseEmployeeMonthCheck bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeMonthCheck> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeMonthCheck> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeMonthCheck addToEmployeeMonthCheck ( BaseEmployeeMonthCheck employeemonthcheck )  throws Exception {
		return addToEmployeeMonthCheck ( employeemonthcheck , false);
	}

	public static BaseEmployeeMonthCheck addToEmployeeMonthCheck ( BaseEmployeeMonthCheck employeemonthcheck, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		dao.setDataFromBase(employeemonthcheck);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeMonthCheck addUpdateEmployeeMonthCheck ( BaseEmployeeMonthCheck employeemonthcheck ) throws Exception {
		return addUpdateEmployeeMonthCheck ( employeemonthcheck , false);
	}

	public static BaseEmployeeMonthCheck addUpdateEmployeeMonthCheck ( BaseEmployeeMonthCheck employeemonthcheck, boolean singleTransaction  ) throws Exception {
		if(employeemonthcheck.getEmployeeMonthCheckId() == null) return addToEmployeeMonthCheck(employeemonthcheck);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		dao.setDataFromBase(employeemonthcheck);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeemonthcheck); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeMonthCheck ( BaseEmployeeMonthCheck bean ) throws Exception {
		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeMonthCheck updateEmployeeMonthCheck ( BaseEmployeeMonthCheck employeemonthcheck ) throws Exception {
		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		dao.setEmployeeMonthCheckId( employeemonthcheck.getEmployeeMonthCheckId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeemonthcheck);
			result = dao.update();
		}
		return result == 1 ? employeemonthcheck : null ;
	}

	public static BaseEmployeeMonthCheck updateEmployeeMonthCheckDirect( BaseEmployeeMonthCheck employeemonthcheck ) throws Exception {
		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		int result = 0;
		dao.setDataFromBase(employeemonthcheck);
		result = dao.update();
		return result == 1 ? employeemonthcheck : null ;
	}

	public static int setDeleteConditions(BaseEmployeeMonthCheck bean, EmployeeMonthCheck dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeMonthCheckId() != null) {
			dao.setConditionEmployeeMonthCheckId("=", bean.getEmployeeMonthCheckId());
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
			if(bean.getIsFullTime() != null) {
				dao.setConditionIsFullTime("=", bean.getIsFullTime());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeMonthCheck bean, EmployeeMonthCheck dao){
		int count = 0;
		if(bean.getEmployeeMonthCheckId() != null) {
			dao.setConditionEmployeeMonthCheckId("=", bean.getEmployeeMonthCheckId());
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
		if(bean.getIsFullTime() != null) {
			dao.setConditionIsFullTime("=", bean.getIsFullTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeMonthCheck bean = new BaseEmployeeMonthCheck();
		bean.setDataFromJSON(json);
		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeMonthCheck> rlist = new BaseCollection<>();
		BaseEmployeeMonthCheck bean = new BaseEmployeeMonthCheck();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeMonthCheck> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeMonthCheck bean = new BaseEmployeeMonthCheck();
		bean.setDataFromJSON(json);
		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeMonthCheck bean = new BaseEmployeeMonthCheck();
		bean.setDataFromJSON(json);
		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeMonthCheck bean = new BaseEmployeeMonthCheck();
		bean.setDataFromJSON(json);
		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeMonthCheck bean = new BaseEmployeeMonthCheck();
		bean.setDataFromJSON(json);
		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


