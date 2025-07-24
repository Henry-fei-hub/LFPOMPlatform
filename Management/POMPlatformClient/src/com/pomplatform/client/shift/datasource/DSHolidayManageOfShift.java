package com.pomplatform.client.shift.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSHolidayManageOfShift extends DBDataSource
{


	public static DSHolidayManageOfShift instance = null;

	public static DSHolidayManageOfShift getInstance() {
		if(instance == null) {
			instance = new DSHolidayManageOfShift("DSHolidayManageOfShift");
		}
		return instance;
	}

	private final DataSourceIntegerField holidayManageIdField;
	private final DataSourceTextField nameField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceDateTimeField startTimeField;
	private final DataSourceDateTimeField endTimeField;
	private final DataSourceDateField recordDateField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceBooleanField isWorkDayField;
	private final DataSourceTextField descriptionField;
	private final DataSourceBooleanField isCountOvertimeField;

	public DSHolidayManageOfShift(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("HolidayManage");


		holidayManageIdField = new DataSourceIntegerField("holidayManageId", "主键编码");
		holidayManageIdField.setLength(11);
		holidayManageIdField.setPrimaryKey(true);
		holidayManageIdField.setRequired(true);
		holidayManageIdField.setHidden(true);


		nameField = new DataSourceTextField("name", "节日名称");
		nameField.setLength(64);
		nameField.setRequired(false);
		nameField.setHidden(false);


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);


		startTimeField = new DataSourceDateTimeField("startTime", "开始时间");
		startTimeField.setRequired(false);
		startTimeField.setHidden(false);


		endTimeField = new DataSourceDateTimeField("endTime", "结束时间");
		endTimeField.setRequired(false);
		endTimeField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "记录日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);

		isWorkDayField = new DataSourceBooleanField("isWorkDay", "是否计工作日");
		isWorkDayField.setLength(32);
		isWorkDayField.setRequired(false);
		isWorkDayField.setHidden(false);

		isCountOvertimeField = new DataSourceBooleanField("isCountOvertime", "是否算加班");
		isCountOvertimeField.setLength(32);
		isCountOvertimeField.setRequired(false);
		isCountOvertimeField.setHidden(false);

		descriptionField = new DataSourceTextField("description", "说明");
		descriptionField.setLength(1024);
		descriptionField.setRequired(false);
		descriptionField.setHidden(false);


		setFields(holidayManageIdField, nameField, yearField, monthField, startTimeField, endTimeField, recordDateField, operateEmployeeIdField, operateTimeField,isWorkDayField,isCountOvertimeField, descriptionField);
	}


}

