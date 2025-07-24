package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadSpecialDeductionYear extends DataSource
{


	public static CDOnLoadSpecialDeductionYear instance = null;

	public static CDOnLoadSpecialDeductionYear getInstance() {
		if(instance == null) {
			instance = new CDOnLoadSpecialDeductionYear("CDOnLoadSpecialDeductionYear");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField yearField;

	public CDOnLoadSpecialDeductionYear(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setRequired(false);
		businessIdField.setLength(11);
		businessIdField.setHidden(false);

		yearField = new DataSourceTextField("year", "扣除年度");
		yearField.setRequired(false);
		yearField.setLength(64);
		yearField.setHidden(false);

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


		setFields(employeeIdField, businessIdField, yearField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

