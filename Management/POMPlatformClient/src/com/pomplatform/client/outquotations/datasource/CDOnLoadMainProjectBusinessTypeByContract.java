package com.pomplatform.client.outquotations.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadMainProjectBusinessTypeByContract extends DataSource
{


	public static CDOnLoadMainProjectBusinessTypeByContract instance = null;

	public static CDOnLoadMainProjectBusinessTypeByContract getInstance() {
		if(instance == null) {
			instance = new CDOnLoadMainProjectBusinessTypeByContract("CDOnLoadMainProjectBusinessTypeByContract");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField statusField;

	public CDOnLoadMainProjectBusinessTypeByContract(String dataSourceID) {

		setID(dataSourceID);
		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setRequired(true);
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setHidden(true);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "结算状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

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


		setFields(contractIdField, projectCodeField, projectNameField, statusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

