package com.pomplatform.client.sprojectemployeeadvancerecord.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSProjectEmployeeAdvanceRecord extends DataSource
{


	public static CDSProjectEmployeeAdvanceRecord instance = null;

	public static CDSProjectEmployeeAdvanceRecord getInstance() {
		if(instance == null) {
			instance = new CDSProjectEmployeeAdvanceRecord("CDSProjectEmployeeAdvanceRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;

	public CDSProjectEmployeeAdvanceRecord(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		startDateField = new DataSourceDateField("startDate", "开始时间");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "截止时间");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

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


		setFields(employeeIdField, startDateField, endDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

