package com.pomplatform.client.manageprojectemployeerecordeachmonth.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDManageProjectEmployeeRecordEachMonth extends DataSource
{


	public static CDManageProjectEmployeeRecordEachMonth instance = null;

	public static CDManageProjectEmployeeRecordEachMonth getInstance() {
		if(instance == null) {
			instance = new CDManageProjectEmployeeRecordEachMonth("CDManageProjectEmployeeRecordEachMonth");
		}
		return instance;
	}

	private final DataSourceDateField startdateField;
	private final DataSourceDateField enddateField;
	private final DataSourceIntegerField employeeIdField;

	public CDManageProjectEmployeeRecordEachMonth(String dataSourceID) {

		setID(dataSourceID);
		startdateField = new DataSourceDateField("startdate", "开始日期");
		startdateField.setRequired(false);
		startdateField.setHidden(false);

		enddateField = new DataSourceDateField("enddate", "截止日期");
		enddateField.setRequired(false);
		enddateField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

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


		setFields(startdateField, enddateField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

