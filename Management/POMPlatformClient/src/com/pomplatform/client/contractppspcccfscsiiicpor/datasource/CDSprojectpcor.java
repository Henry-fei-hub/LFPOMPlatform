package com.pomplatform.client.contractppspcccfscsiiicpor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectpcor extends DataSource
{


	public static CDSprojectpcor instance = null;

	public static CDSprojectpcor getInstance() {
		if(instance == null) {
			instance = new CDSprojectpcor("CDSprojectpcor");
		}
		return instance;
	}

	private final DataSourceFloatField sheetAmountField;
	private final DataSourceIntegerField projectFlagField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceBooleanField isEcmcProjectField;
	private final DataSourceFloatField moneySumField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField contractIdField;

	public CDSprojectpcor(String dataSourceID) {

		setID(dataSourceID);
		sheetAmountField = new DataSourceFloatField("sheetAmount", "订单金额");
		sheetAmountField.setRequired(true);
		sheetAmountField.setLength(18);
		sheetAmountField.setHidden(false);

		projectFlagField = new DataSourceIntegerField("projectFlag", "2研发项目)");
		projectFlagField.setRequired(false);
		projectFlagField.setLength(11);
		projectFlagField.setHidden(false);

		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(11);
		businessTypeField.setHidden(false);

		isEcmcProjectField = new DataSourceBooleanField("isEcmcProject", "true是");
		isEcmcProjectField.setRequired(false);
		isEcmcProjectField.setHidden(false);

		moneySumField = new DataSourceFloatField("moneySum", "合同金额");
		moneySumField.setRequired(true);
		moneySumField.setLength(18);
		moneySumField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(true);
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setHidden(true);

		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

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


		setFields(sheetAmountField, projectFlagField, businessTypeField, isEcmcProjectField, moneySumField, contractCodeField, projectCodeField, projectNameField, projectIdField, contractIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

