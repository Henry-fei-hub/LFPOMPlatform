package com.pomplatform.client.shift.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSAttendanceRecord extends DBDataSource
{


	public static DSAttendanceRecord instance = null;

	public static DSAttendanceRecord getInstance() {
		if(instance == null) {
			instance = new DSAttendanceRecord("DSAttendanceRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeDayCheckIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceDateField recordDateField;
	private final DataSourceIntegerField shiftManageIdField;
	private final DataSourceDateTimeField checkinField;
	private final DataSourceDateTimeField checkoutField;
	private final DataSourceIntegerField lateLeave5mField;
	private final DataSourceIntegerField lateLeave10mField;
	private final DataSourceIntegerField lateLeave30mField;
	private final DataSourceIntegerField lateLeaveField;
	private final DataSourceIntegerField thingLeaveTimesField;
	private final DataSourceFloatField thingLeaveHoursField;
	private final DataSourceFloatField thingLeaveDaysField;
	private final DataSourceIntegerField illLeaveTimesField;
	private final DataSourceFloatField illLeaveHoursField;
	private final DataSourceFloatField illLeaveDaysField;
	private final DataSourceIntegerField otherLeaveTimesField;
	private final DataSourceFloatField otherLeaveHoursField;
	private final DataSourceFloatField otherLeaveDaysField;
	private final DataSourceFloatField nornalOvertimeHoursField;
	private final DataSourceFloatField weekendOvertimeHoursField;
	private final DataSourceFloatField holidayOvertimeHoursField;
	private final DataSourceFloatField absenceDaysField;
	private final DataSourceFloatField shouldDaysField;
	private final DataSourceFloatField factDaysField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSAttendanceRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AttendanceRecord");


		employeeDayCheckIdField = new DataSourceIntegerField("employeeDayCheckId", "主键编码");
		employeeDayCheckIdField.setLength(11);
		employeeDayCheckIdField.setPrimaryKey(true);
		employeeDayCheckIdField.setRequired(true);
		employeeDayCheckIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(true);
		yearField.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(true);
		monthField.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));


		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		shiftManageIdField = new DataSourceIntegerField("shiftManageId", "班次");
		shiftManageIdField.setLength(11);
		shiftManageIdField.setRequired(false);
		shiftManageIdField.setHidden(false);
//		shiftManageIdField.setValueMap(KeyValueManager.getValueMap("shift_manages"));
		KeyValueManager.loadValueMap("shift_manages",shiftManageIdField);

		checkinField = new DataSourceDateTimeField("checkin", "上班时间");
		checkinField.setRequired(false);
		checkinField.setHidden(false);


		checkoutField = new DataSourceDateTimeField("checkout", "下班时间");
		checkoutField.setRequired(false);
		checkoutField.setHidden(false);


		lateLeave5mField = new DataSourceIntegerField("lateLeave5m", "迟到/早退5分钟");
		lateLeave5mField.setLength(11);
		lateLeave5mField.setRequired(false);
		lateLeave5mField.setHidden(false);


		lateLeave10mField = new DataSourceIntegerField("lateLeave10m", "迟到/早退10分钟");
		lateLeave10mField.setLength(11);
		lateLeave10mField.setRequired(false);
		lateLeave10mField.setHidden(false);


		lateLeave30mField = new DataSourceIntegerField("lateLeave30m", "迟到/早退30分钟");
		lateLeave30mField.setLength(11);
		lateLeave30mField.setRequired(false);
		lateLeave30mField.setHidden(false);


		lateLeaveField = new DataSourceIntegerField("lateLeave", "扣款迟到/早退");
		lateLeaveField.setLength(11);
		lateLeaveField.setRequired(false);
		lateLeaveField.setHidden(false);


		thingLeaveTimesField = new DataSourceIntegerField("thingLeaveTimes", "事假次数");
		thingLeaveTimesField.setLength(11);
		thingLeaveTimesField.setRequired(false);
		thingLeaveTimesField.setHidden(false);


		thingLeaveHoursField = new DataSourceFloatField("thingLeaveHours", "事假小时数");
		thingLeaveHoursField.setLength(18);
		thingLeaveHoursField.setDecimalPad(2);
		thingLeaveHoursField.setFormat("#,###,###,###,###,##0.00");
		thingLeaveHoursField.setRequired(false);
		thingLeaveHoursField.setHidden(false);


		thingLeaveDaysField = new DataSourceFloatField("thingLeaveDays", "事假天数");
		thingLeaveDaysField.setLength(18);
		thingLeaveDaysField.setDecimalPad(2);
		thingLeaveDaysField.setFormat("#,###,###,###,###,##0.00");
		thingLeaveDaysField.setRequired(false);
		thingLeaveDaysField.setHidden(false);


		illLeaveTimesField = new DataSourceIntegerField("illLeaveTimes", "病假次数");
		illLeaveTimesField.setLength(11);
		illLeaveTimesField.setRequired(false);
		illLeaveTimesField.setHidden(false);


		illLeaveHoursField = new DataSourceFloatField("illLeaveHours", "病假小时数");
		illLeaveHoursField.setLength(18);
		illLeaveHoursField.setDecimalPad(2);
		illLeaveHoursField.setFormat("#,###,###,###,###,##0.00");
		illLeaveHoursField.setRequired(false);
		illLeaveHoursField.setHidden(false);


		illLeaveDaysField = new DataSourceFloatField("illLeaveDays", "病假天数");
		illLeaveDaysField.setLength(18);
		illLeaveDaysField.setDecimalPad(2);
		illLeaveDaysField.setFormat("#,###,###,###,###,##0.00");
		illLeaveDaysField.setRequired(false);
		illLeaveDaysField.setHidden(false);


		otherLeaveTimesField = new DataSourceIntegerField("otherLeaveTimes", "其它假类次数");
		otherLeaveTimesField.setLength(11);
		otherLeaveTimesField.setRequired(false);
		otherLeaveTimesField.setHidden(false);


		otherLeaveHoursField = new DataSourceFloatField("otherLeaveHours", "其它假类小时数");
		otherLeaveHoursField.setLength(18);
		otherLeaveHoursField.setDecimalPad(2);
		otherLeaveHoursField.setFormat("#,###,###,###,###,##0.00");
		otherLeaveHoursField.setRequired(false);
		otherLeaveHoursField.setHidden(false);


		otherLeaveDaysField = new DataSourceFloatField("otherLeaveDays", "其它假类天数");
		otherLeaveDaysField.setLength(18);
		otherLeaveDaysField.setDecimalPad(2);
		otherLeaveDaysField.setFormat("#,###,###,###,###,##0.00");
		otherLeaveDaysField.setRequired(false);
		otherLeaveDaysField.setHidden(false);


		nornalOvertimeHoursField = new DataSourceFloatField("nornalOvertimeHours", "平时加班小时数");
		nornalOvertimeHoursField.setLength(18);
		nornalOvertimeHoursField.setDecimalPad(2);
		nornalOvertimeHoursField.setFormat("#,###,###,###,###,##0.00");
		nornalOvertimeHoursField.setRequired(false);
		nornalOvertimeHoursField.setHidden(true);


		weekendOvertimeHoursField = new DataSourceFloatField("weekendOvertimeHours", "周末加班小时数");
		weekendOvertimeHoursField.setLength(18);
		weekendOvertimeHoursField.setDecimalPad(2);
		weekendOvertimeHoursField.setFormat("#,###,###,###,###,##0.00");
		weekendOvertimeHoursField.setRequired(false);
		weekendOvertimeHoursField.setHidden(true);


		holidayOvertimeHoursField = new DataSourceFloatField("holidayOvertimeHours", "节假日加班小时数");
		holidayOvertimeHoursField.setLength(18);
		holidayOvertimeHoursField.setDecimalPad(2);
		holidayOvertimeHoursField.setFormat("#,###,###,###,###,##0.00");
		holidayOvertimeHoursField.setRequired(false);
		holidayOvertimeHoursField.setHidden(true);


		absenceDaysField = new DataSourceFloatField("absenceDays", "旷工天数");
		absenceDaysField.setLength(18);
		absenceDaysField.setDecimalPad(2);
		absenceDaysField.setFormat("#,###,###,###,###,##0.00");
		absenceDaysField.setRequired(false);
		absenceDaysField.setHidden(true);


		shouldDaysField = new DataSourceFloatField("shouldDays", "应到天数");
		shouldDaysField.setLength(18);
		shouldDaysField.setDecimalPad(2);
		shouldDaysField.setFormat("#,###,###,###,###,##0.00");
		shouldDaysField.setRequired(false);
		shouldDaysField.setHidden(true);


		factDaysField = new DataSourceFloatField("factDays", "实到天数");
		factDaysField.setLength(18);
		factDaysField.setDecimalPad(2);
		factDaysField.setFormat("#,###,###,###,###,##0.00");
		factDaysField.setRequired(false);
		factDaysField.setHidden(true);


		statusField = new DataSourceIntegerField("status", "考勤状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setEmptyDisplayValue("0");
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_91"));


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(employeeDayCheckIdField, employeeIdField, yearField, monthField, recordDateField, shiftManageIdField, checkinField, checkoutField, lateLeave5mField, lateLeave10mField, lateLeave30mField, lateLeaveField, thingLeaveTimesField, thingLeaveHoursField, thingLeaveDaysField, illLeaveTimesField, illLeaveHoursField, illLeaveDaysField, otherLeaveTimesField, otherLeaveHoursField, otherLeaveDaysField, nornalOvertimeHoursField, weekendOvertimeHoursField, holidayOvertimeHoursField, absenceDaysField, shouldDaysField, factDaysField, statusField, operateEmployeeIdField, operateTimeField, remarkField);
	}


}

