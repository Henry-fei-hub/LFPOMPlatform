package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDReportOnEmployeeEducationTotalByDepartment extends DataSource
{


	public static CDReportOnEmployeeEducationTotalByDepartment instance = null;

	public static CDReportOnEmployeeEducationTotalByDepartment getInstance() {
		if(instance == null) {
			instance = new CDReportOnEmployeeEducationTotalByDepartment("CDReportOnEmployeeEducationTotalByDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField plateIdField;

	public CDReportOnEmployeeEducationTotalByDepartment(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(true);
		statusField.setLength(11);
		statusField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

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


		setFields(yearField, statusField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

