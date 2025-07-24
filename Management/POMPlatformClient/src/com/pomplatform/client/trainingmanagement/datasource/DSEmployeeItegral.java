package com.pomplatform.client.trainingmanagement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class DSEmployeeItegral extends DBDataSource
{


	public static DSEmployeeItegral instance = null;

	public static DSEmployeeItegral getInstance() {
		if(instance == null) {
			instance = new DSEmployeeItegral("DSEmployeeItegral");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField oneField;
	private final DataSourceIntegerField twoField;
	private final DataSourceIntegerField threeField;
	private final DataSourceIntegerField fourField;
	private final DataSourceIntegerField fiveField;
	private final DataSourceIntegerField sixField;
	private final DataSourceIntegerField sevenField;
	private final DataSourceIntegerField eightField;
	private final DataSourceIntegerField nineField;
	private final DataSourceIntegerField tenField;
	private final DataSourceIntegerField elevenField;
	private final DataSourceIntegerField twelveField;
	private final DataSourceIntegerField totalField;

	public DSEmployeeItegral(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeItegral");


		employeeIdField = new DataSourceIntegerField("employeeId", "签到人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		oneField = new DataSourceIntegerField("one", "一月");
		oneField.setLength(8);
		oneField.setRequired(true);
		oneField.setHidden(false);


		twoField = new DataSourceIntegerField("two", "二月");
		twoField.setLength(8);
		twoField.setRequired(true);
		twoField.setHidden(false);


		threeField = new DataSourceIntegerField("three", "三月");
		threeField.setLength(8);
		threeField.setRequired(true);
		threeField.setHidden(false);


		fourField = new DataSourceIntegerField("four", "四月");
		fourField.setLength(8);
		fourField.setRequired(true);
		fourField.setHidden(false);


		fiveField = new DataSourceIntegerField("five", "五月");
		fiveField.setLength(8);
		fiveField.setRequired(true);
		fiveField.setHidden(false);


		sixField = new DataSourceIntegerField("six", "六月");
		sixField.setLength(8);
		sixField.setRequired(true);
		sixField.setHidden(false);


		sevenField = new DataSourceIntegerField("seven", "七月");
		sevenField.setLength(8);
		sevenField.setRequired(true);
		sevenField.setHidden(false);


		eightField = new DataSourceIntegerField("eight", "八月");
		eightField.setLength(8);
		eightField.setRequired(true);
		eightField.setHidden(false);


		nineField = new DataSourceIntegerField("nine", "九月");
		nineField.setLength(8);
		nineField.setRequired(true);
		nineField.setHidden(false);


		tenField = new DataSourceIntegerField("ten", "十月");
		tenField.setLength(8);
		tenField.setRequired(true);
		tenField.setHidden(false);


		elevenField = new DataSourceIntegerField("eleven", "十一月");
		elevenField.setLength(8);
		elevenField.setRequired(true);
		elevenField.setHidden(false);


		twelveField = new DataSourceIntegerField("twelve", "十二月");
		twelveField.setLength(8);
		twelveField.setRequired(true);
		twelveField.setHidden(false);


		totalField = new DataSourceIntegerField("total", "总分");
		totalField.setLength(8);
		totalField.setRequired(true);
		totalField.setHidden(false);


		setFields(employeeIdField, departmentIdField, oneField, twoField, threeField, fourField, fiveField, sixField, sevenField, eightField, nineField, tenField, elevenField, twelveField, totalField);
	}


}

