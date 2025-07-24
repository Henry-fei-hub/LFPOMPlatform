package com.pomplatform.client.bonuspaymentbymonth.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDBonusPaymentByMonth extends DataSource
{


	public static CDBonusPaymentByMonth instance = null;

	public static CDBonusPaymentByMonth getInstance() {
		if(instance == null) {
			instance = new CDBonusPaymentByMonth("CDBonusPaymentByMonth");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;

	public CDBonusPaymentByMonth(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

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


		setFields(employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

