package com.pomplatform.client.check.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSemployeemonthlycheckymor extends DBDataSource {

	public static DSSemployeemonthlycheckymor instance = null;

	public static DSSemployeemonthlycheckymor getInstance() {
		if (instance == null) {
			instance = new DSSemployeemonthlycheckymor("DSSemployeemonthlycheckymor");
		}
		return instance;
	}

	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField employeeTypeField;
	private final DataSourceDateField onBoardField;
	private final DataSourceDateField dutyDateField;
	private final DataSourceIntegerField late5mField;
	private final DataSourceIntegerField late10mField;
	private final DataSourceIntegerField late30mField;
	private final DataSourceIntegerField lateField;
	private final DataSourceIntegerField thingLeaveField;
        private final DataSourceFloatField thingDaysField;
	private final DataSourceFloatField thingHoursField;
	private final DataSourceIntegerField illLeaveField;
        private final DataSourceFloatField illDaysField;
	private final DataSourceFloatField illHoursField;
	private final DataSourceIntegerField otherLeaveField;
        private final DataSourceFloatField otherDaysField;
	private final DataSourceFloatField otherHoursField;
	private final DataSourceIntegerField workDaysField;
	private final DataSourceIntegerField normalOvertimeField;
	private final DataSourceIntegerField weekendOvertimeField;
	private final DataSourceIntegerField holidayOvertimeField;
	private final DataSourceFloatField nornalOvertimeHoursField;
	private final DataSourceFloatField weekendOvertimeHoursField;
	private final DataSourceFloatField holidayOvertimeHoursField;
	private final DataSourceIntegerField absenceDaysField;

	public DSSemployeemonthlycheckymor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Semployeemonthlycheckymor");

		employeeNoField = new DataSourceTextField("employeeNo", "员工号");
		employeeNoField.setLength(20);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		employeeTypeField = new DataSourceIntegerField("employeeType", "员工类型");
		employeeTypeField.setLength(11);
		employeeTypeField.setRequired(false);
		employeeTypeField.setHidden(false);
		employeeTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_24"));

		onBoardField = new DataSourceDateField("onBoard", "入职日期");
		onBoardField.setRequired(false);
		onBoardField.setHidden(false);

		dutyDateField = new DataSourceDateField("dutyDate", "转正日期");
		dutyDateField.setRequired(false);
		dutyDateField.setHidden(false);

		late5mField = new DataSourceIntegerField("late5m", "迟到5分钟");
		late5mField.setLength(11);
		late5mField.setRequired(false);
		late5mField.setHidden(false);

		late10mField = new DataSourceIntegerField("late10m", "迟到10分钟");
		late10mField.setLength(11);
		late10mField.setRequired(false);
		late10mField.setHidden(false);

		late30mField = new DataSourceIntegerField("late30m", "迟到30分钟");
		late30mField.setLength(11);
		late30mField.setRequired(false);
		late30mField.setHidden(false);

		lateField = new DataSourceIntegerField("late", "扣款迟到");
		lateField.setLength(11);
		lateField.setRequired(false);
		lateField.setHidden(false);

		thingLeaveField = new DataSourceIntegerField("thingLeave", "事假次数");
		thingLeaveField.setLength(11);
		thingLeaveField.setRequired(false);
		thingLeaveField.setHidden(false);

		thingDaysField = new DataSourceFloatField("thingDays", "事假天数");
		thingDaysField.setLength(10);
		thingDaysField.setDecimalPad(2);
		thingDaysField.setFormat("##,###,###.##");
		thingDaysField.setRequired(false);
		thingDaysField.setHidden(false);
                
		thingHoursField = new DataSourceFloatField("thingHours", "事假小时");
		thingHoursField.setLength(10);
		thingHoursField.setDecimalPad(2);
		thingHoursField.setFormat("##,###,###.##");
		thingHoursField.setRequired(false);
		thingHoursField.setHidden(false);
                
		illLeaveField = new DataSourceIntegerField("illLeave", "病假次数");
		illLeaveField.setLength(11);
		illLeaveField.setRequired(false);
		illLeaveField.setHidden(false);
                
                illDaysField = new DataSourceFloatField("illDays", "病假天数");
		illDaysField.setLength(10);
		illDaysField.setDecimalPad(2);
		illDaysField.setFormat("##,###,###.##");
		illDaysField.setRequired(false);
		illDaysField.setHidden(false);
                
                illHoursField = new DataSourceFloatField("illHours", "病假小时");
		illHoursField.setLength(10);
		illHoursField.setDecimalPad(2);
		illHoursField.setFormat("##,###,###.##");
		illHoursField.setRequired(false);
		illHoursField.setHidden(false);

		otherLeaveField = new DataSourceIntegerField("otherLeave", "其它假类次数");
		otherLeaveField.setLength(11);
		otherLeaveField.setRequired(false);
		otherLeaveField.setHidden(false);
                
                otherDaysField = new DataSourceFloatField("otherDays", "其它假类天数");
		otherDaysField.setLength(10);
		otherDaysField.setDecimalPad(2);
		otherDaysField.setFormat("##,###,###.##");
		otherDaysField.setRequired(false);
		otherDaysField.setHidden(false);
                
                otherHoursField = new DataSourceFloatField("otherHours", "其它假类小时");
		otherHoursField.setLength(10);
		otherHoursField.setDecimalPad(2);
		otherHoursField.setFormat("##,###,###.##");
		otherHoursField.setRequired(false);
		otherHoursField.setHidden(false);

		workDaysField = new DataSourceIntegerField("workDays", "应到天数");
		workDaysField.setLength(11);
		workDaysField.setRequired(false);
		workDaysField.setHidden(false);

		normalOvertimeField = new DataSourceIntegerField("normalOvertime", "平时加班天数");
		normalOvertimeField.setLength(11);
		normalOvertimeField.setRequired(false);
		normalOvertimeField.setHidden(false);

		weekendOvertimeField = new DataSourceIntegerField("weekendOvertime", "周末加班天数");
		weekendOvertimeField.setLength(11);
		weekendOvertimeField.setRequired(false);
		weekendOvertimeField.setHidden(false);

		holidayOvertimeField = new DataSourceIntegerField("holidayOvertime", "放假加班天数");
		holidayOvertimeField.setLength(11);
		holidayOvertimeField.setRequired(false);
		holidayOvertimeField.setHidden(false);

		nornalOvertimeHoursField = new DataSourceFloatField("nornalOvertimeHours", "平时加班小时");
		nornalOvertimeHoursField.setLength(10);
		nornalOvertimeHoursField.setDecimalPad(2);
		nornalOvertimeHoursField.setFormat("##,###,##0.00");
		nornalOvertimeHoursField.setRequired(false);
		nornalOvertimeHoursField.setHidden(false);

		weekendOvertimeHoursField = new DataSourceFloatField("weekendOvertimeHours", "周末加班小时");
		weekendOvertimeHoursField.setLength(10);
		weekendOvertimeHoursField.setDecimalPad(2);
		weekendOvertimeHoursField.setFormat("##,###,##0.00");
		weekendOvertimeHoursField.setRequired(false);
		weekendOvertimeHoursField.setHidden(false);

		holidayOvertimeHoursField = new DataSourceFloatField("holidayOvertimeHours", "节假日加班小时");
		holidayOvertimeHoursField.setLength(10);
		holidayOvertimeHoursField.setDecimalPad(2);
		holidayOvertimeHoursField.setFormat("##,###,##0.00");
		holidayOvertimeHoursField.setRequired(false);
		holidayOvertimeHoursField.setHidden(false);

		absenceDaysField = new DataSourceIntegerField("absenceDays", "旷工天数");
		absenceDaysField.setLength(11);
		absenceDaysField.setRequired(false);
		absenceDaysField.setHidden(false);

		setFields(employeeNoField, employeeIdField, departmentIdField, employeeTypeField, onBoardField, dutyDateField, late5mField, late10mField, late30mField, lateField, thingLeaveField,thingDaysField,thingHoursField, illLeaveField,illDaysField,illHoursField, otherLeaveField,otherDaysField,otherHoursField, workDaysField, normalOvertimeField, weekendOvertimeField, holidayOvertimeField, nornalOvertimeHoursField, weekendOvertimeHoursField, holidayOvertimeHoursField, absenceDaysField);
	}

}
