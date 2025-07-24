package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadAttentionListOfSalaryAdjustment extends DataSource
{


	public static CDOnLoadAttentionListOfSalaryAdjustment instance = null;

	public static CDOnLoadAttentionListOfSalaryAdjustment getInstance() {
		if(instance == null) {
			instance = new CDOnLoadAttentionListOfSalaryAdjustment("CDOnLoadAttentionListOfSalaryAdjustment");
		}
		return instance;
	}

	private final DataSourceIntegerField statusField;
	private final DataSourceDateTimeField yearField;
	private final DataSourceDateTimeField monthField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField auditorField;

	public CDOnLoadAttentionListOfSalaryAdjustment(String dataSourceID) {

		setID(dataSourceID);
		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		yearField = new DataSourceDateTimeField("year", "年份");
		yearField.setRequired(false);
		yearField.setHidden(false);

		monthField = new DataSourceDateTimeField("month", "月份");
		monthField.setRequired(false);
		monthField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		employeeIdField = new DataSourceIntegerField("employeeId", "姓名");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		auditorField = new DataSourceIntegerField("auditor", "处理人");
		auditorField.setRequired(false);
		auditorField.setLength(11);
		auditorField.setHidden(false);
		auditorField.setValueMap(KeyValueManager.getValueMap("employees"));

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


		setFields(statusField, yearField, monthField, plateIdField, employeeIdField, auditorField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

