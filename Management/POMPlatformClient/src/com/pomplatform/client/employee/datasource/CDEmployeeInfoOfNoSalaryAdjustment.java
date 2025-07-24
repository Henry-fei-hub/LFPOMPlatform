package com.pomplatform.client.employee.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDEmployeeInfoOfNoSalaryAdjustment extends DataSource
{


	public static CDEmployeeInfoOfNoSalaryAdjustment instance = null;

	public static CDEmployeeInfoOfNoSalaryAdjustment getInstance() {
		if(instance == null) {
			instance = new CDEmployeeInfoOfNoSalaryAdjustment("CDEmployeeInfoOfNoSalaryAdjustment");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceDateTimeField startTimeField;
	private final DataSourceDateTimeField endTimeField;

	public CDEmployeeInfoOfNoSalaryAdjustment(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		startTimeField = new DataSourceDateTimeField("startTime", "开始日期");
		startTimeField.setRequired(false);
		startTimeField.setHidden(false);

		endTimeField = new DataSourceDateTimeField("endTime", "截止日期");
		endTimeField.setRequired(false);
		endTimeField.setHidden(false);

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


		setFields(plateIdField, employeeNameField, startTimeField, endTimeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

