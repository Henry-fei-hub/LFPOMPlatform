package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnSalaryAnnualBonusByCompany extends DataSource
{


	public static CDOnSalaryAnnualBonusByCompany instance = null;

	public static CDOnSalaryAnnualBonusByCompany getInstance() {
		if(instance == null) {
			instance = new CDOnSalaryAnnualBonusByCompany("CDOnSalaryAnnualBonusByCompany");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField companyIdField;

	public CDOnSalaryAnnualBonusByCompany(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "所属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

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


		setFields(yearField, companyIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

