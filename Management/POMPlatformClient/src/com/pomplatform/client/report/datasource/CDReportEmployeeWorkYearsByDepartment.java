package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDReportEmployeeWorkYearsByDepartment extends DataSource
{


	public static CDReportEmployeeWorkYearsByDepartment instance = null;

	public static CDReportEmployeeWorkYearsByDepartment getInstance() {
		if(instance == null) {
			instance = new CDReportEmployeeWorkYearsByDepartment("CDReportEmployeeWorkYearsByDepartment");
		}
		return instance;
	}

	private final DataSourceDateField endDateField;
	private final DataSourceDateField startDateField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField plateTypeField;
	private final DataSourceIntegerField departmentIdField;

	public CDReportEmployeeWorkYearsByDepartment(String dataSourceID) {

		setID(dataSourceID);
		endDateField = new DataSourceDateField("endDate", "入职日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		startDateField = new DataSourceDateField("startDate", "离职日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(true);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		plateTypeField = new DataSourceIntegerField("plateType", "3营销部)");
		plateTypeField.setRequired(false);
		plateTypeField.setLength(11);
		plateTypeField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setRequired(true);
		departmentIdField.setLength(11);
		departmentIdField.setPrimaryKey(true);
		departmentIdField.setHidden(true);

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


		setFields(endDateField, startDateField, plateIdField, plateTypeField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

