package com.pomplatform.db.handler;

import java.util.List;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeMonthlyCheck;
import com.pomplatform.db.dao.EmployeeMonthlyCheck;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;

public class EmployeeMonthlyCheckHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeMonthlyCheckHandler.class);

	public static BaseEmployeeMonthlyCheck getEmployeeMonthlyCheckById( 
		java.lang.Integer month_check_id
	) throws Exception
	{
		EmployeeMonthlyCheck dao = new EmployeeMonthlyCheck();
		dao.setMonthCheckId(month_check_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeMonthlyCheckExists( com.pomplatform.db.bean.BaseEmployeeMonthlyCheck bean, String additional ) throws Exception {

		EmployeeMonthlyCheck dao = new EmployeeMonthlyCheck();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeMonthlyCheck( com.pomplatform.db.bean.BaseEmployeeMonthlyCheck bean, String additional ) throws Exception {

		EmployeeMonthlyCheck dao = new EmployeeMonthlyCheck();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeMonthlyCheck> queryEmployeeMonthlyCheck( com.pomplatform.db.bean.BaseEmployeeMonthlyCheck bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeMonthlyCheck dao = new EmployeeMonthlyCheck();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeMonthlyCheck> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeMonthlyCheck> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeMonthlyCheck addToEmployeeMonthlyCheck ( BaseEmployeeMonthlyCheck employeemonthlycheck )  throws Exception {
		return addToEmployeeMonthlyCheck ( employeemonthlycheck , false);
	}

	public static BaseEmployeeMonthlyCheck addToEmployeeMonthlyCheck ( BaseEmployeeMonthlyCheck employeemonthlycheck, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeMonthlyCheck dao = new EmployeeMonthlyCheck();
		dao.setDataFromBase(employeemonthlycheck);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeMonthlyCheck addUpdateEmployeeMonthlyCheck ( BaseEmployeeMonthlyCheck employeemonthlycheck ) throws Exception {
		return addUpdateEmployeeMonthlyCheck ( employeemonthlycheck , false);
	}

	public static BaseEmployeeMonthlyCheck addUpdateEmployeeMonthlyCheck ( BaseEmployeeMonthlyCheck employeemonthlycheck, boolean singleTransaction  ) throws Exception {
		if(employeemonthlycheck.getMonthCheckId() == null) return addToEmployeeMonthlyCheck(employeemonthlycheck);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeMonthlyCheck dao = new EmployeeMonthlyCheck();
		dao.setDataFromBase(employeemonthlycheck);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeemonthlycheck); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeMonthlyCheck ( BaseEmployeeMonthlyCheck bean ) throws Exception {
		EmployeeMonthlyCheck dao = new EmployeeMonthlyCheck();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeMonthlyCheck updateEmployeeMonthlyCheck ( BaseEmployeeMonthlyCheck employeemonthlycheck ) throws Exception {
		EmployeeMonthlyCheck dao = new EmployeeMonthlyCheck();
		dao.setMonthCheckId( employeemonthlycheck.getMonthCheckId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeemonthlycheck);
			result = dao.update();
		}
		return result == 1 ? employeemonthlycheck : null ;
	}

	public static BaseEmployeeMonthlyCheck updateEmployeeMonthlyCheckDirect( BaseEmployeeMonthlyCheck employeemonthlycheck ) throws Exception {
		EmployeeMonthlyCheck dao = new EmployeeMonthlyCheck();
		int result = 0;
		dao.setDataFromBase(employeemonthlycheck);
		result = dao.update();
		return result == 1 ? employeemonthlycheck : null ;
	}

	public static int setDeleteConditions(BaseEmployeeMonthlyCheck bean, EmployeeMonthlyCheck dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMonthCheckId() != null) {
			dao.setConditionMonthCheckId("=", bean.getMonthCheckId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getEmployeeType() != null) {
				dao.setConditionEmployeeType("=", bean.getEmployeeType());
				count++;
			}
			if(bean.getLate5m() != null) {
				dao.setConditionLate5m("=", bean.getLate5m());
				count++;
			}
			if(bean.getLate10m() != null) {
				dao.setConditionLate10m("=", bean.getLate10m());
				count++;
			}
			if(bean.getLate30m() != null) {
				dao.setConditionLate30m("=", bean.getLate30m());
				count++;
			}
			if(bean.getLate() != null) {
				dao.setConditionLate("=", bean.getLate());
				count++;
			}
			if(bean.getThingLeave() != null) {
				dao.setConditionThingLeave("=", bean.getThingLeave());
				count++;
			}
			if(bean.getIllLeave() != null) {
				dao.setConditionIllLeave("=", bean.getIllLeave());
				count++;
			}
			if(bean.getOtherLeave() != null) {
				dao.setConditionOtherLeave("=", bean.getOtherLeave());
				count++;
			}
			if(bean.getWorkDays() != null) {
				dao.setConditionWorkDays("=", bean.getWorkDays());
				count++;
			}
			if(bean.getNormalOvertime() != null) {
				dao.setConditionNormalOvertime("=", bean.getNormalOvertime());
				count++;
			}
			if(bean.getWeekendOvertime() != null) {
				dao.setConditionWeekendOvertime("=", bean.getWeekendOvertime());
				count++;
			}
			if(bean.getHolidayOvertime() != null) {
				dao.setConditionHolidayOvertime("=", bean.getHolidayOvertime());
				count++;
			}
			if(bean.getAbsenceDays() != null) {
				dao.setConditionAbsenceDays("=", bean.getAbsenceDays());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeMonthlyCheck bean, EmployeeMonthlyCheck dao){
		int count = 0;
		if(bean.getMonthCheckId() != null) {
			dao.setConditionMonthCheckId("=", bean.getMonthCheckId());
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
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getEmployeeType() != null) {
			dao.setConditionEmployeeType("=", bean.getEmployeeType());
			count++;
		}
		if(bean.getOnBoard() != null) {
			dao.setConditionOnBoard(">=", bean.getOnBoard());
			count++;
		}
		if(bean.getDutyDate() != null) {
			dao.setConditionDutyDate(">=", bean.getDutyDate());
			count++;
		}
		if(bean.getLate5m() != null) {
			dao.setConditionLate5m("=", bean.getLate5m());
			count++;
		}
		if(bean.getLate10m() != null) {
			dao.setConditionLate10m("=", bean.getLate10m());
			count++;
		}
		if(bean.getLate30m() != null) {
			dao.setConditionLate30m("=", bean.getLate30m());
			count++;
		}
		if(bean.getLate() != null) {
			dao.setConditionLate("=", bean.getLate());
			count++;
		}
		if(bean.getThingLeave() != null) {
			dao.setConditionThingLeave("=", bean.getThingLeave());
			count++;
		}
		if(bean.getThingHours() != null) {
			dao.setConditionThingHours("=", bean.getThingHours());
			count++;
		}
		if(bean.getIllLeave() != null) {
			dao.setConditionIllLeave("=", bean.getIllLeave());
			count++;
		}
		if(bean.getOtherLeave() != null) {
			dao.setConditionOtherLeave("=", bean.getOtherLeave());
			count++;
		}
		if(bean.getWorkDays() != null) {
			dao.setConditionWorkDays("=", bean.getWorkDays());
			count++;
		}
		if(bean.getNormalOvertime() != null) {
			dao.setConditionNormalOvertime("=", bean.getNormalOvertime());
			count++;
		}
		if(bean.getWeekendOvertime() != null) {
			dao.setConditionWeekendOvertime("=", bean.getWeekendOvertime());
			count++;
		}
		if(bean.getHolidayOvertime() != null) {
			dao.setConditionHolidayOvertime("=", bean.getHolidayOvertime());
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
		if(bean.getThingDays() != null) {
			dao.setConditionThingDays("=", bean.getThingDays());
			count++;
		}
		if(bean.getIllHours() != null) {
			dao.setConditionIllHours("=", bean.getIllHours());
			count++;
		}
		if(bean.getIllDays() != null) {
			dao.setConditionIllDays("=", bean.getIllDays());
			count++;
		}
		if(bean.getOtherHours() != null) {
			dao.setConditionOtherHours("=", bean.getOtherHours());
			count++;
		}
		if(bean.getOtherDays() != null) {
			dao.setConditionOtherDays("=", bean.getOtherDays());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeMonthlyCheck bean = new BaseEmployeeMonthlyCheck();
		bean.setDataFromJSON(json);
		EmployeeMonthlyCheck dao = new EmployeeMonthlyCheck();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeMonthlyCheck> rlist = new BaseCollection<>();
		BaseEmployeeMonthlyCheck bean = new BaseEmployeeMonthlyCheck();
		bean.setDataFromJSON(json);
		EmployeeMonthlyCheck dao = new EmployeeMonthlyCheck();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeMonthlyCheck> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeMonthlyCheck bean = new BaseEmployeeMonthlyCheck();
		bean.setDataFromJSON(json);
		EmployeeMonthlyCheck dao = new EmployeeMonthlyCheck();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeMonthlyCheck bean = new BaseEmployeeMonthlyCheck();
		bean.setDataFromJSON(json);
		EmployeeMonthlyCheck dao = new EmployeeMonthlyCheck();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeMonthlyCheck bean = new BaseEmployeeMonthlyCheck();
		bean.setDataFromJSON(json);
		EmployeeMonthlyCheck dao = new EmployeeMonthlyCheck();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeMonthlyCheck bean = new BaseEmployeeMonthlyCheck();
		bean.setDataFromJSON(json);
		EmployeeMonthlyCheck dao = new EmployeeMonthlyCheck();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


