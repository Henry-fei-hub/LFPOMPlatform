package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadSalaryPaymentByCompany extends DataSource
{


	public static CDOnLoadSalaryPaymentByCompany instance = null;

	public static CDOnLoadSalaryPaymentByCompany getInstance() {
		if(instance == null) {
			instance = new CDOnLoadSalaryPaymentByCompany("CDOnLoadSalaryPaymentByCompany");
		}
		return instance;
	}

	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField typeField;

	public CDOnLoadSalaryPaymentByCompany(String dataSourceID) {

		setID(dataSourceID);
		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(false);
		monthField.setLength(11);
		monthField.setHidden(false);

		typeField = new DataSourceIntegerField("type", "类型");
		typeField.setRequired(false);
		typeField.setLength(11);
		typeField.setHidden(false);
		typeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(companyIdField, yearField, monthField, typeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

