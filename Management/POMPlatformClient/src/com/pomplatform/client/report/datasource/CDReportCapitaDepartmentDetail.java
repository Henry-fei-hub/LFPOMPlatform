package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDReportCapitaDepartmentDetail extends DataSource
{


	public static CDReportCapitaDepartmentDetail instance = null;

	public static CDReportCapitaDepartmentDetail getInstance() {
		if(instance == null) {
			instance = new CDReportCapitaDepartmentDetail("CDReportCapitaDepartmentDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField departmentIdField;

	public CDReportCapitaDepartmentDetail(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(true);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "报销部门");
		departmentIdField.setRequired(true);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(new java.util.HashMap());

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


		setFields(plateIdField, yearField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

