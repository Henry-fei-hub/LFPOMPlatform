package com.pomplatform.client.shift.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAttendanceRecord extends DataSource
{


	public static CDAttendanceRecord instance = null;

	public static CDAttendanceRecord getInstance() {
		if(instance == null) {
			instance = new CDAttendanceRecord("CDAttendanceRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateField endDateField;
	private final DataSourceDateField startDateField;

	public CDAttendanceRecord(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		endDateField = new DataSourceDateField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

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


		setFields(employeeIdField, endDateField, startDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

