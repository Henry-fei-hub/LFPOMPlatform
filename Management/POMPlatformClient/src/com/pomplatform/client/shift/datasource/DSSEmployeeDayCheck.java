package com.pomplatform.client.shift.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSEmployeeDayCheck extends DBDataSource {

	public static DSSEmployeeDayCheck instance = null;

	public static DSSEmployeeDayCheck getInstance() {
		if (instance == null) {
			instance = new DSSEmployeeDayCheck("DSSEmployeeMonthCheck");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateField recordDateField;
	private final DataSourceIntegerField shiftManageIdField;
	private final DataSourceDateTimeField checkinField;
	private final DataSourceDateTimeField checkoutField;
	private final DataSourceIntegerField lateLeave5mField;
	private final DataSourceIntegerField lateLeave10mField;
	private final DataSourceIntegerField lateLeave30mField;
	private final DataSourceIntegerField lateLeaveField;
	private final DataSourceIntegerField thingLeaveTimesField;
    private final DataSourceFloatField thingLeaveDayField;
	private final DataSourceFloatField thingLeavehoursField;
	private final DataSourceIntegerField illLeaveTimesField;
    private final DataSourceFloatField illLeaveDaysField;
	private final DataSourceFloatField illLeaveHoursField;
	private final DataSourceIntegerField otherLeaveTimesField;
    private final DataSourceFloatField otherLeaveDaysField;
	private final DataSourceFloatField otherLeaveHoursField;
	private final DataSourceFloatField nornalOvertimeHoursField;
	private final DataSourceIntegerField absenceDaysField;
	private final DataSourceIntegerField shouldDaysField;
	private final DataSourceIntegerField factDaysField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField remarkField;
	private final DataSourceFloatField numberOfLateField;
	private final DataSourceFloatField lateForMinutesField;
	private final DataSourceFloatField numberOfLeaveField;
	private final DataSourceFloatField LeaveForMinutesField;
	private final DataSourceFloatField lateChargeField;
	private final DataSourceFloatField adjustField;
	private final DataSourceFloatField annuaLeaveField;
	private final DataSourceFloatField weddingLeaveField;
	private final DataSourceFloatField maternityLeaveField;
	private final DataSourceFloatField prenatalCheckLeaveField;
	private final DataSourceFloatField maternityLeaveDaysField;
	private final DataSourceFloatField funeralLeaveField;
	private final DataSourceFloatField outForBusinessField;
	private final DataSourceFloatField overtimePayField;
	private final DataSourceFloatField overtimePaySubField;
	private final DataSourceFloatField weekendOvertimeHoursField;
	private final DataSourceFloatField holidayOvertimeHoursField;


	public DSSEmployeeDayCheck(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("EmployeeDayCheck");
		
		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdField.setCanEdit(false);
		
		recordDateField = new DataSourceDateField("recordDate","考勤日期");
		recordDateField.setLength(64);
		recordDateField.setHidden(false);
		recordDateField.setCanEdit(false);
		
		shiftManageIdField = new DataSourceIntegerField("shiftManageId", "班次");
		shiftManageIdField.setLength(11);
		shiftManageIdField.setRequired(false);
		shiftManageIdField.setHidden(false);
		KeyValueManager.loadValueMap("shift_manages",shiftManageIdField);
		shiftManageIdField.setCanEdit(false);
		
		checkinField = new DataSourceDateTimeField("checkin", "上班");
		checkinField.setLength(64);
		checkinField.setFormat("HH:mm:ss");
		checkinField.setRequired(false);
		checkinField.setHidden(false);
		checkinField.setCanEdit(false);
		
		checkoutField = new DataSourceDateTimeField("checkout", "下班");
		checkoutField.setLength(64);
		checkoutField.setFormat("HH:mm:ss");
		checkoutField.setRequired(false);
		checkoutField.setHidden(false);
		checkoutField.setCanEdit(false);
		
		lateLeave5mField = new DataSourceIntegerField("lateLeave5m", "迟到/早退5分钟");
		lateLeave5mField.setLength(11);
		lateLeave5mField.setEmptyDisplayValue("0");
		lateLeave5mField.setRequired(false);
		lateLeave5mField.setHidden(true);

		lateLeave10mField = new DataSourceIntegerField("lateLeave10m", "迟到/早退10分钟");
		lateLeave10mField.setLength(11);
		lateLeave10mField.setEmptyDisplayValue("0");
		lateLeave10mField.setRequired(false);
		lateLeave10mField.setHidden(true);

		lateLeave30mField = new DataSourceIntegerField("lateLeave30m", "迟到/早退30分钟");
		lateLeave30mField.setLength(11);
		lateLeave30mField.setEmptyDisplayValue("0");
		lateLeave30mField.setRequired(false);
		lateLeave30mField.setHidden(true);

		lateLeaveField = new DataSourceIntegerField("lateLeave", "扣款迟到/早退");
		lateLeaveField.setLength(11);
		lateLeaveField.setEmptyDisplayValue("0");
		lateLeaveField.setRequired(false);
		lateLeaveField.setHidden(true);

		thingLeaveTimesField = new DataSourceIntegerField("thingLeaveTimes", "事假次数");
		thingLeaveTimesField.setLength(11);
		thingLeaveTimesField.setEmptyDisplayValue("0");
		thingLeaveTimesField.setRequired(false);
		thingLeaveTimesField.setHidden(true);

		thingLeaveDayField = new DataSourceFloatField("thingLeaveDays", "事假(天)");
		thingLeaveDayField.setLength(10);
		thingLeaveDayField.setEmptyDisplayValue("0");
		thingLeaveDayField.setDecimalPad(2);
		thingLeaveDayField.setFormat("##,###,###0.00");
		thingLeaveDayField.setRequired(false);
		thingLeaveDayField.setHidden(false);
                
		thingLeavehoursField = new DataSourceFloatField("thingLeaveHours", "旷工扣款");
		thingLeavehoursField.setLength(10);
		thingLeavehoursField.setEmptyDisplayValue("0");
		thingLeavehoursField.setDecimalPad(2);
		thingLeavehoursField.setFormat("##,###,###0.00");
		thingLeavehoursField.setRequired(false);
		thingLeavehoursField.setHidden(false);
                
		illLeaveTimesField = new DataSourceIntegerField("illLeaveTimes", "病假次数");
		illLeaveTimesField.setLength(11);
		illLeaveTimesField.setEmptyDisplayValue("0");
		illLeaveTimesField.setRequired(false);
		illLeaveTimesField.setHidden(true);
                
		illLeaveDaysField = new DataSourceFloatField("illLeaveDays", "病假(天)");
		illLeaveDaysField.setLength(10);
		illLeaveDaysField.setEmptyDisplayValue("0");
		illLeaveDaysField.setDecimalPad(2);
		illLeaveDaysField.setFormat("##,###,###0.00");
		illLeaveDaysField.setRequired(false);
		illLeaveDaysField.setHidden(false);
                
		illLeaveHoursField = new DataSourceFloatField("illLeaveHours", "病假小时");
		illLeaveHoursField.setLength(10);
		illLeaveHoursField.setEmptyDisplayValue("0");
		illLeaveHoursField.setDecimalPad(2);
		illLeaveHoursField.setFormat("##,###,###0.00");
		illLeaveHoursField.setRequired(false);
		illLeaveHoursField.setHidden(true);

		otherLeaveTimesField = new DataSourceIntegerField("otherLeaveTimes", "其它假类次数");
		otherLeaveTimesField.setLength(11);
		otherLeaveTimesField.setEmptyDisplayValue("0");
		otherLeaveTimesField.setRequired(false);
		otherLeaveTimesField.setHidden(true);
                
		otherLeaveDaysField = new DataSourceFloatField("otherLeaveDays", "其它假类天数");
		otherLeaveDaysField.setLength(10);
		otherLeaveDaysField.setEmptyDisplayValue("0");
		otherLeaveDaysField.setDecimalPad(2);
		otherLeaveDaysField.setFormat("##,###,###0.00");
		otherLeaveDaysField.setRequired(false);
		otherLeaveDaysField.setHidden(false);
                
		otherLeaveHoursField = new DataSourceFloatField("otherLeaveHours", "其它假类小时");
		otherLeaveHoursField.setLength(10);
		otherLeaveHoursField.setEmptyDisplayValue("0");
		otherLeaveHoursField.setDecimalPad(2);
		otherLeaveHoursField.setFormat("##,###,###0.00");
		otherLeaveHoursField.setRequired(false);
		otherLeaveHoursField.setHidden(true);

		nornalOvertimeHoursField = new DataSourceFloatField("nornalOvertimeHours", "平时加班(小时)");
		nornalOvertimeHoursField.setLength(10);
		nornalOvertimeHoursField.setEmptyDisplayValue("0");
		nornalOvertimeHoursField.setDecimalPad(2);
		nornalOvertimeHoursField.setFormat("##,###,##0.00");
		nornalOvertimeHoursField.setRequired(false);
		nornalOvertimeHoursField.setHidden(false);

		weekendOvertimeHoursField = new DataSourceFloatField("weekendOvertimeHours", "周末加班(小时)");
		weekendOvertimeHoursField.setLength(10);
		weekendOvertimeHoursField.setEmptyDisplayValue("0");
		weekendOvertimeHoursField.setDecimalPad(2);
		weekendOvertimeHoursField.setFormat("##,###,##0.00");
		weekendOvertimeHoursField.setRequired(false);
		weekendOvertimeHoursField.setHidden(false);

		holidayOvertimeHoursField = new DataSourceFloatField("holidayOvertimeHours", "节假日加班(小时)");
		holidayOvertimeHoursField.setLength(10);
		holidayOvertimeHoursField.setEmptyDisplayValue("0");
		holidayOvertimeHoursField.setDecimalPad(2);
		holidayOvertimeHoursField.setFormat("##,###,##0.00");
		holidayOvertimeHoursField.setRequired(false);
		holidayOvertimeHoursField.setHidden(false);
		
		absenceDaysField = new DataSourceIntegerField("absenceDays", "旷工(天)");
		absenceDaysField.setLength(11);
		absenceDaysField.setEmptyDisplayValue("0");
		absenceDaysField.setRequired(false);
		absenceDaysField.setHidden(false);


		shouldDaysField = new DataSourceIntegerField("shouldDays", "应到(天)");
		shouldDaysField.setLength(11);
		shouldDaysField.setEmptyDisplayValue("0");
		shouldDaysField.setRequired(false);
		shouldDaysField.setHidden(false);

		factDaysField = new DataSourceIntegerField("factDays", "实到(天)");
		factDaysField.setLength(11);
		factDaysField.setEmptyDisplayValue("0");
		factDaysField.setRequired(false);
		factDaysField.setHidden(false);
		
		statusField = new DataSourceIntegerField("status", "考勤状态");
		statusField.setLength(11);
		statusField.setEmptyDisplayValue("0");
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_91"));



		numberOfLateField = new DataSourceFloatField("numberOfLate", "迟到次数");
		numberOfLateField.setLength(10);
		numberOfLateField.setEmptyDisplayValue("0");
		numberOfLateField.setDecimalPad(2);
		numberOfLateField.setFormat("##,###,###0.00");
		numberOfLateField.setRequired(false);
		numberOfLateField.setHidden(false);

		lateForMinutesField = new DataSourceFloatField("lateForMinutes", "迟到分数");
		lateForMinutesField.setLength(10);
		lateForMinutesField.setEmptyDisplayValue("0");
		lateForMinutesField.setDecimalPad(2);
		lateForMinutesField.setFormat("##,###,###0.00");
		lateForMinutesField.setRequired(false);
		lateForMinutesField.setHidden(false);

		numberOfLeaveField = new DataSourceFloatField("numberOfLeave", "早退次数");
		numberOfLeaveField.setLength(10);
		numberOfLeaveField.setEmptyDisplayValue("0");
		numberOfLeaveField.setDecimalPad(2);
		numberOfLeaveField.setFormat("##,###,###0.00");
		numberOfLeaveField.setRequired(false);
		numberOfLeaveField.setHidden(false);

		LeaveForMinutesField = new DataSourceFloatField("leaveForMinutes", "早退分钟");
		LeaveForMinutesField.setLength(10);
		LeaveForMinutesField.setEmptyDisplayValue("0");
		LeaveForMinutesField.setDecimalPad(2);
		LeaveForMinutesField.setFormat("##,###,###0.00");
		LeaveForMinutesField.setRequired(false);
		LeaveForMinutesField.setHidden(false);

		lateChargeField = new DataSourceFloatField("lateCharge", "迟到扣款");
		lateChargeField.setLength(10);
		lateChargeField.setEmptyDisplayValue("0");
		lateChargeField.setDecimalPad(2);
		lateChargeField.setFormat("##,###,###0.00");
		lateChargeField.setRequired(false);
		lateChargeField.setHidden(false);

		adjustField = new DataSourceFloatField("adjust", "调休假(小时)");
		adjustField.setLength(10);
		adjustField.setEmptyDisplayValue("0");
		adjustField.setDecimalPad(2);
		adjustField.setFormat("##,###,###0.00");
		adjustField.setRequired(false);
		adjustField.setHidden(false);

		annuaLeaveField = new DataSourceFloatField("annualLeave", "年假(天)");
		annuaLeaveField.setLength(10);
		annuaLeaveField.setEmptyDisplayValue("0");
		annuaLeaveField.setDecimalPad(2);
		annuaLeaveField.setFormat("##,###,###0.00");
		annuaLeaveField.setRequired(false);
		annuaLeaveField.setHidden(false);

		weddingLeaveField = new DataSourceFloatField("weddingLeave", "婚假天数");
		weddingLeaveField.setLength(10);
		weddingLeaveField.setEmptyDisplayValue("0");
		weddingLeaveField.setDecimalPad(2);
		weddingLeaveField.setFormat("##,###,###0.00");
		weddingLeaveField.setRequired(false);
		weddingLeaveField.setHidden(false);

		maternityLeaveField = new DataSourceFloatField("maternityLeave", "产假天数");
		maternityLeaveField.setLength(10);
		maternityLeaveField.setEmptyDisplayValue("0");
		maternityLeaveField.setDecimalPad(2);
		maternityLeaveField.setFormat("##,###,###0.00");
		maternityLeaveField.setRequired(false);
		maternityLeaveField.setHidden(false);

		prenatalCheckLeaveField = new DataSourceFloatField("prenatalCheckLeave", "产检假天数");
		prenatalCheckLeaveField.setLength(10);
		prenatalCheckLeaveField.setEmptyDisplayValue("0");
		prenatalCheckLeaveField.setDecimalPad(2);
		prenatalCheckLeaveField.setFormat("##,###,###0.00");
		prenatalCheckLeaveField.setRequired(false);
		prenatalCheckLeaveField.setHidden(false);

		maternityLeaveDaysField = new DataSourceFloatField("maternityLeaveDays", "陪产假天数");
		maternityLeaveDaysField.setLength(10);
		maternityLeaveDaysField.setEmptyDisplayValue("0");
		maternityLeaveDaysField.setDecimalPad(2);
		maternityLeaveDaysField.setFormat("##,###,###0.00");
		maternityLeaveDaysField.setRequired(false);
		maternityLeaveDaysField.setHidden(false);

		funeralLeaveField = new DataSourceFloatField("funeralLeave", "丧假天数");
		funeralLeaveField.setLength(10);
		funeralLeaveField.setEmptyDisplayValue("0");
		funeralLeaveField.setDecimalPad(2);
		funeralLeaveField.setFormat("##,###,###0.00");
		funeralLeaveField.setRequired(false);
		funeralLeaveField.setHidden(false);

		outForBusinessField = new DataSourceFloatField("outForBusiness", "因公外出(次数)");
		outForBusinessField.setLength(10);
		outForBusinessField.setEmptyDisplayValue("0");
		outForBusinessField.setDecimalPad(2);
		outForBusinessField.setFormat("##,###,###0.00");
		outForBusinessField.setRequired(false);
		outForBusinessField.setHidden(false);

		overtimePayField = new DataSourceFloatField("overtimePay", "加班餐补(本月)");
		overtimePayField.setLength(10);
		overtimePayField.setEmptyDisplayValue("0");
		overtimePayField.setDecimalPad(2);
		overtimePayField.setFormat("##,###,###0.00");
		overtimePayField.setRequired(false);
		overtimePayField.setHidden(false);
		
		overtimePaySubField = new DataSourceFloatField("overtimePaySub", "加班补助(本月)");
		overtimePaySubField.setLength(10);
		overtimePaySubField.setEmptyDisplayValue("0");
		overtimePaySubField.setDecimalPad(2);
		overtimePaySubField.setFormat("##,###,###0.00");
		overtimePaySubField.setRequired(false);
		overtimePaySubField.setHidden(false);

		
		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(11);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

//		setFields( employeeIdField, recordDateField,shiftManageIdField,checkinField,checkoutField,lateLeave5mField, lateLeave10mField, lateLeave30mField, lateLeaveField
//		, thingLeaveTimesField,thingLeaveDayField,thingLeavehoursField, illLeaveTimesField,illLeaveDaysField,illLeaveHoursField, otherLeaveTimesField,otherLeaveDaysField,otherLeaveHoursField
//		, nornalOvertimeHoursField, absenceDaysField, shouldDaysField, factDaysField, statusField, remarkField, numberOfLateField, lateForMinutesField, numberOfLeaveField , LeaveForMinutesField,
//				lateChargeField, adjustField,annuaLeaveField,weddingLeaveField,	maternityLeaveField,prenatalCheckLeaveField,maternityLeaveDaysField,funeralLeaveField, outForBusinessField, overtimePayField);
		/*setFields(employeeIdField, recordDateField, shiftManageIdField, checkinField, checkoutField, numberOfLateField, lateForMinutesField, numberOfLeaveField, LeaveForMinutesField
				, lateChargeField, adjustField, annuaLeaveField, nornalOvertimeHoursField, weekendOvertimeHoursField, holidayOvertimeHoursField, thingLeaveDayField, illLeaveDaysField,
				otherLeaveTimesField, outForBusinessField, overtimePayField, shouldDaysField, factDaysField, absenceDaysField, statusField, remarkField);*/

		setFields(employeeIdField,recordDateField, shiftManageIdField, checkinField,checkoutField,statusField, numberOfLateField, lateForMinutesField, numberOfLeaveField, LeaveForMinutesField
				, lateChargeField,thingLeavehoursField,  nornalOvertimeHoursField, weekendOvertimeHoursField, holidayOvertimeHoursField,overtimePayField,overtimePaySubField,adjustField, annuaLeaveField, thingLeaveDayField, illLeaveDaysField,otherLeaveDaysField,
				otherLeaveTimesField, outForBusinessField, shouldDaysField, factDaysField, absenceDaysField );
	}

}
