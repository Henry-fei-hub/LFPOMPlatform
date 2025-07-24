package com.pomplatform.client.bonuspayment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMemployeeaccountrecordeeeor extends DataSource
{


	public static CDMemployeeaccountrecordeeeor instance = null;

	public static CDMemployeeaccountrecordeeeor getInstance() {
		if(instance == null) {
			instance = new CDMemployeeaccountrecordeeeor("CDMemployeeaccountrecordeeeor");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;

	public CDMemployeeaccountrecordeeeor(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

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

