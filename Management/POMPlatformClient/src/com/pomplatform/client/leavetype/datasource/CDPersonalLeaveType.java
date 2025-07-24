package com.pomplatform.client.leavetype.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPersonalLeaveType extends DataSource
{


	public static CDPersonalLeaveType instance = null;

	public static CDPersonalLeaveType getInstance() {
		if(instance == null) {
			instance = new CDPersonalLeaveType("CDPersonalLeaveType");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField provinceIdField;

	public CDPersonalLeaveType(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setRequired(true);
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setHidden(true);
//		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdField);

		provinceIdField = new DataSourceIntegerField("provinceId", "适用省份");
		provinceIdField.setRequired(false);
		provinceIdField.setLength(11);
		provinceIdField.setHidden(false);
		provinceIdField.setValueMap(KeyValueManager.getValueMap("provinces"));

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


		setFields(employeeIdField, provinceIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

