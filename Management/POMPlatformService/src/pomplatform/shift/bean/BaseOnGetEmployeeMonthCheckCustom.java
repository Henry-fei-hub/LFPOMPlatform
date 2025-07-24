package pomplatform.shift.bean;

public class BaseOnGetEmployeeMonthCheckCustom extends BaseOnGetEmployeeMonthCheck 
{

	public final static java.lang.String ALL_CAPTIONS = "员工编号,员工姓名,部门,在职状态,年份,月份,迟到次数,迟到分钟,早退次数,早退分钟,迟到扣款,旷工扣款,平时加班(小时),周末加班(小时)"
			+ ",节假日加班(小时),加班餐补(本月),加班补助(本月),加班补助,调休假,年假(天),事假(天),病假(天),其它假类(天),其它假类次数,因公外出(次数),应到(天),实到(天),旷工(天),是否全勤";

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_11", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getNumberOfLate() == null ? "" : getNumberOfLate());
		sb.append(",");
		sb.append(getLateForMinutes() == null ? "" : getLateForMinutes());
		sb.append(",");
		sb.append(getNumberOfLeave() == null ? "" : getNumberOfLeave());
		sb.append(",");
		sb.append(getLeaveForMinutes() == null ? "" : getLeaveForMinutes());
		sb.append(",");
		sb.append(getLateCharge() == null ? "" : getLateCharge());
		sb.append(",");
		sb.append(getThingLeaveHours() == null ? "" : getThingLeaveHours());
		sb.append(",");
		sb.append(getNornalOvertimeHours() == null ? "" : getNornalOvertimeHours());
		sb.append(",");
		sb.append(getWeekendOvertimeHours() == null ? "" : getWeekendOvertimeHours());
		sb.append(",");
		sb.append(getHolidayOvertimeHours() == null ? "" : getHolidayOvertimeHours());
		sb.append(",");
		sb.append(getOvertimePay() == null ? "" : getOvertimePay());
		sb.append(",");
		sb.append(getOvertimePaySub() == null ? "" : getOvertimePaySub());
		sb.append(",");
		sb.append(getOvertimePaySubBefore() == null ? "" : getOvertimePaySubBefore());
		sb.append(",");
		sb.append(getAdjust() == null ? "" : getAdjust());
		sb.append(",");
		sb.append(getAnnualLeave() == null ? "" : getAnnualLeave());
		sb.append(",");
		sb.append(getThingLeaveDays() == null ? "" : getThingLeaveDays());
		sb.append(",");
		sb.append(getIllLeaveDays() == null ? "" : getIllLeaveDays());
		sb.append(",");
		sb.append(getOtherLeaveDays() == null ? "" : getOtherLeaveDays());
		sb.append(",");
		sb.append(getOtherLeaveTimes() == null ? "" : getOtherLeaveTimes());
		sb.append(",");
		sb.append(getOutForBusiness() == null ? "" : getOutForBusiness());
		sb.append(",");
		sb.append(getShouldDays() == null ? "" : getShouldDays());
		sb.append(",");
		sb.append(getFactDays() == null ? "" : getFactDays());
		sb.append(",");
		sb.append(getAbsenceDays() == null ? "" : getAbsenceDays());
		sb.append(",");
		sb.append(getIsFullTime() == null ? "" : getIsFullTime());
		return sb.toString();
	}


}
