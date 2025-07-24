package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDReportEmployeeDailyHoursTotal extends DataSource
{


	public static CDReportEmployeeDailyHoursTotal instance = null;

	public static CDReportEmployeeDailyHoursTotal getInstance() {
		if(instance == null) {
			instance = new CDReportEmployeeDailyHoursTotal("CDReportEmployeeDailyHoursTotal");
		}
		return instance;
	}

	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceDateField startWorkDateField;
	private final DataSourceDateField endWorkDateField;

	public CDReportEmployeeDailyHoursTotal(String dataSourceID) {

		setID(dataSourceID);
		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);
		employeeNoField.setValueMap(KeyValueManager.getValueMap(""));

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		startWorkDateField = new DataSourceDateField("startWorkDate", "日期");
		startWorkDateField.setRequired(false);
		startWorkDateField.setHidden(false);

		endWorkDateField = new DataSourceDateField("endWorkDate", "日期");
		endWorkDateField.setRequired(false);
		endWorkDateField.setHidden(false);

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


		setFields(employeeNoField, employeeNameField, startWorkDateField, endWorkDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

