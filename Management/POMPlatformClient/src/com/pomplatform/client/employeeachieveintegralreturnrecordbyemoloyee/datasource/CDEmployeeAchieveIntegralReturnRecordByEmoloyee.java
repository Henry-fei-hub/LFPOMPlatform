package com.pomplatform.client.employeeachieveintegralreturnrecordbyemoloyee.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDEmployeeAchieveIntegralReturnRecordByEmoloyee extends DataSource
{


	public static CDEmployeeAchieveIntegralReturnRecordByEmoloyee instance = null;

	public static CDEmployeeAchieveIntegralReturnRecordByEmoloyee getInstance() {
		if(instance == null) {
			instance = new CDEmployeeAchieveIntegralReturnRecordByEmoloyee("CDEmployeeAchieveIntegralReturnRecordByEmoloyee");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField recordYearField;
	private final DataSourceIntegerField recordMonthField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;

	public CDEmployeeAchieveIntegralReturnRecordByEmoloyee(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		recordYearField = new DataSourceIntegerField("recordYear", "年份");
		recordYearField.setRequired(true);
		recordYearField.setLength(11);
		recordYearField.setHidden(false);

		recordMonthField = new DataSourceIntegerField("recordMonth", "月份");
		recordMonthField.setRequired(true);
		recordMonthField.setLength(11);
		recordMonthField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "姓名");
		employeeNameField.setRequired(false);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

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


		setFields(plateIdField, recordYearField, recordMonthField, employeeNoField, employeeNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

