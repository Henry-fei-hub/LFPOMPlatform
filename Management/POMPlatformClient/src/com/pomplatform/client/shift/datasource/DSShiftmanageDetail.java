package com.pomplatform.client.shift.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSShiftmanageDetail extends DBDataSource
{


	public static DSShiftmanageDetail instance = null;

	public static DSShiftmanageDetail getInstance() {
		if(instance == null) {
			instance = new DSShiftmanageDetail("DSShiftmanageDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField shiftManageIdField;
	private final DataSourceTextField shiftNameField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceBooleanField mondayField;
	private final DataSourceBooleanField tuesdayField;
	private final DataSourceBooleanField wednesdayField;
	private final DataSourceBooleanField thursdayField;
	private final DataSourceBooleanField fridayField;
	private final DataSourceBooleanField saturdayField;
	private final DataSourceBooleanField sundayField;
	private final DataSourceBooleanField isEnableField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField shiftTimeManageIdField;
	private final DataSourceTextField shiftTimeNameField;
	private final DataSourceTextField signInTimeField;
	private final DataSourceTextField signOffTimeField;

	public DSShiftmanageDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ShiftmanageDetail");


		shiftManageIdField = new DataSourceIntegerField("shiftManageId", "班次主键编码");
		shiftManageIdField.setLength(11);
		shiftManageIdField.setPrimaryKey(true);
		shiftManageIdField.setRequired(true);
		shiftManageIdField.setHidden(true);


		shiftNameField = new DataSourceTextField("shiftName", "班次名称");
		shiftNameField.setLength(64);
		shiftNameField.setRequired(false);
		shiftNameField.setHidden(true);


		startDateField = new DataSourceDateField("startDate", "起用日期");
		startDateField.setRequired(false);
		startDateField.setHidden(true);


		endDateField = new DataSourceDateField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(true);


		mondayField = new DataSourceBooleanField("monday", "星期一");
		mondayField.setRequired(false);
		mondayField.setHidden(false);
		mondayField.setCanEdit(true);


		tuesdayField = new DataSourceBooleanField("tuesday", "星期二");
		tuesdayField.setRequired(false);
		tuesdayField.setHidden(false);
		tuesdayField.setCanEdit(true);


		wednesdayField = new DataSourceBooleanField("wednesday", "星期三");
		wednesdayField.setRequired(false);
		wednesdayField.setHidden(false);
		wednesdayField.setCanEdit(true);


		thursdayField = new DataSourceBooleanField("thursday", "星期四");
		thursdayField.setRequired(false);
		thursdayField.setHidden(false);
		thursdayField.setCanEdit(true);


		fridayField = new DataSourceBooleanField("friday", "星期五");
		fridayField.setRequired(false);
		fridayField.setHidden(false);
		fridayField.setCanEdit(true);


		saturdayField = new DataSourceBooleanField("saturday", "星期六");
		saturdayField.setRequired(false);
		saturdayField.setHidden(false);
		saturdayField.setCanEdit(true);


		sundayField = new DataSourceBooleanField("sunday", "星期日");
		sundayField.setRequired(false);
		sundayField.setHidden(false);
		sundayField.setCanEdit(true);


		isEnableField = new DataSourceBooleanField("isEnable", "是否启用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		shiftTimeManageIdField = new DataSourceIntegerField("shiftTimeManageId", "时段id");
		shiftTimeManageIdField.setLength(11);
		shiftTimeManageIdField.setRequired(false);
		shiftTimeManageIdField.setHidden(true);


		shiftTimeNameField = new DataSourceTextField("shiftTimeName", "时段名称");
		shiftTimeNameField.setLength(64);
		shiftTimeNameField.setRequired(false);
		shiftTimeNameField.setHidden(false);
		shiftTimeNameField.setCanEdit(true);
		shiftTimeNameField.setValueMap();  

		signInTimeField = new DataSourceTextField("signInTime", "上班时间");
		signInTimeField.setLength(32);
		signInTimeField.setRequired(false);
		signInTimeField.setHidden(false);


		signOffTimeField = new DataSourceTextField("signOffTime", "下班时间");
		signOffTimeField.setLength(32);
		signOffTimeField.setRequired(false);
		signOffTimeField.setHidden(false);


		setFields(shiftManageIdField, shiftTimeNameField, signInTimeField, signOffTimeField, shiftNameField, startDateField, endDateField, mondayField, tuesdayField, wednesdayField, thursdayField, fridayField, saturdayField, sundayField, isEnableField, remarkField, shiftTimeManageIdField);
	}


}

