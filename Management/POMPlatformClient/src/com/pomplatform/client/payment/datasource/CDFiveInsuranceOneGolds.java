package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDFiveInsuranceOneGolds extends DataSource
{


	public static CDFiveInsuranceOneGolds instance = null;

	public static CDFiveInsuranceOneGolds getInstance() {
		if(instance == null) {
			instance = new CDFiveInsuranceOneGolds("CDFiveInsuranceOneGolds");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField ownedCompanyField;

	public CDFiveInsuranceOneGolds(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "职员姓名");
		employeeIdField.setRequired(true);
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeNoField = new DataSourceTextField("employeeNo", "职员编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		ownedCompanyField = new DataSourceTextField("ownedCompany", "所属公司");
		ownedCompanyField.setRequired(false);
		ownedCompanyField.setLength(64);
		ownedCompanyField.setHidden(false);

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


		setFields(employeeIdField, employeeNoField, ownedCompanyField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

