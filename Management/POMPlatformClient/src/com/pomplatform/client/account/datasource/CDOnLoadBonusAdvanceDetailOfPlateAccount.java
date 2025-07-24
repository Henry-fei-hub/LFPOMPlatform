package com.pomplatform.client.account.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadBonusAdvanceDetailOfPlateAccount extends DataSource
{


	public static CDOnLoadBonusAdvanceDetailOfPlateAccount instance = null;

	public static CDOnLoadBonusAdvanceDetailOfPlateAccount getInstance() {
		if(instance == null) {
			instance = new CDOnLoadBonusAdvanceDetailOfPlateAccount("CDOnLoadBonusAdvanceDetailOfPlateAccount");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField manageProjectNameField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;

	public CDOnLoadBonusAdvanceDetailOfPlateAccount(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "11绩效奖金)");
		businessTypeIdField.setRequired(false);
		businessTypeIdField.setLength(11);
		businessTypeIdField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		manageProjectNameField = new DataSourceTextField("manageProjectName", "项目名称");
		manageProjectNameField.setRequired(false);
		manageProjectNameField.setLength(512);
		manageProjectNameField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(true);
		monthField.setLength(11);
		monthField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(plateIdField, businessTypeIdField, employeeNoField, employeeNameField, manageProjectNameField, yearField, monthField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

