package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSspecialdeductionmonthdetailedpor extends DataSource
{


	public static CDSspecialdeductionmonthdetailedpor instance = null;

	public static CDSspecialdeductionmonthdetailedpor getInstance() {
		if(instance == null) {
			instance = new CDSspecialdeductionmonthdetailedpor("CDSspecialdeductionmonthdetailedpor");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField yearField;
	private final DataSourceTextField monthField;
	private final DataSourceTextField employeeNoField;

	public CDSspecialdeductionmonthdetailedpor(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "职员");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		yearField = new DataSourceTextField("year", "年度");
		yearField.setRequired(false);
		yearField.setLength(64);
		yearField.setHidden(false);

		monthField = new DataSourceTextField("month", "月份");
		monthField.setRequired(false);
		monthField.setLength(64);
		monthField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "职员编号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

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


		setFields(employeeIdField, departmentIdField, plateIdField, yearField, monthField, employeeNoField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

