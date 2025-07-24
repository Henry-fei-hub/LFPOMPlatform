package com.pomplatform.client.client.workflow.specialdeduction.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSpecialDeductionRecordWithS extends DataSource
{


	public static CDSpecialDeductionRecordWithS instance = null;

	public static CDSpecialDeductionRecordWithS getInstance() {
		if(instance == null) {
			instance = new CDSpecialDeductionRecordWithS("CDSpecialDeductionRecordWithS");
		}
		return instance;
	}

	private final DataSourceIntegerField employeIdField;

	public CDSpecialDeductionRecordWithS(String dataSourceID) {

		setID(dataSourceID);
		employeIdField = new DataSourceIntegerField("employeId", "纳税人id");
		employeIdField.setRequired(true);
		employeIdField.setLength(11);
		employeIdField.setHidden(false);

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


		setFields(employeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

