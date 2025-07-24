package com.pomplatform.client.check.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMemployeecheckinouteeseor extends DataSource
{


	public static CDMemployeecheckinouteeseor instance = null;

	public static CDMemployeecheckinouteeseor getInstance() {
		if(instance == null) {
			instance = new CDMemployeecheckinouteeseor("CDMemployeecheckinouteeseor");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateField startTimeField;
	private final DataSourceDateField endTimeField;

	public CDMemployeecheckinouteeseor(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setRequired(true);
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		startTimeField = new DataSourceDateField("startTime", "开始日期");
		startTimeField.setRequired(false);
		startTimeField.setHidden(false);

		endTimeField = new DataSourceDateField("endTime", "结束日期");
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


		setFields(employeeIdField, startTimeField, endTimeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

