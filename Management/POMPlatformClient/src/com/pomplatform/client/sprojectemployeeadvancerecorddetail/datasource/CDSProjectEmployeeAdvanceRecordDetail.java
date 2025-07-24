package com.pomplatform.client.sprojectemployeeadvancerecorddetail.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSProjectEmployeeAdvanceRecordDetail extends DataSource
{


	public static CDSProjectEmployeeAdvanceRecordDetail instance = null;

	public static CDSProjectEmployeeAdvanceRecordDetail getInstance() {
		if(instance == null) {
			instance = new CDSProjectEmployeeAdvanceRecordDetail("CDSProjectEmployeeAdvanceRecordDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField advanceYearField;
	private final DataSourceIntegerField advanceMonthField;

	public CDSProjectEmployeeAdvanceRecordDetail(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "补贴成员");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		advanceYearField = new DataSourceIntegerField("advanceYear", "年份");
		advanceYearField.setRequired(false);
		advanceYearField.setLength(11);
		advanceYearField.setHidden(false);
		advanceYearField.setValueMap(KeyValueManager.getValueMap("employees"));

		advanceMonthField = new DataSourceIntegerField("advanceMonth", "月份");
		advanceMonthField.setRequired(false);
		advanceMonthField.setLength(11);
		advanceMonthField.setHidden(false);
		advanceMonthField.setValueMap(KeyValueManager.getValueMap("employees"));

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


		setFields(employeeIdField, advanceYearField, advanceMonthField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

