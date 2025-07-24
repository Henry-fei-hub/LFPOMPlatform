package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSContractAmountAnalyzeDetail extends DBDataSource
{


	public static DSContractAmountAnalyzeDetail instance = null;

	public static DSContractAmountAnalyzeDetail getInstance() {
		if(instance == null) {
			instance = new DSContractAmountAnalyzeDetail("DSContractAmountAnalyzeDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceDateField contractDateField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField plateNameField;
	private final DataSourceFloatField sheetAmountField;

	public DSContractAmountAnalyzeDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractAmountAnalyzeDetail");


		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setRequired(true);
		contractIdField.setHidden(true);
		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractDateField = new DataSourceDateField("contractDate", "签约日期");
		contractDateField.setRequired(false);
		contractDateField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "订单编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		plateNameField = new DataSourceTextField("plateName", "业务部门");
		plateNameField.setLength(64);
		plateNameField.setRequired(false);
		plateNameField.setHidden(false);


		sheetAmountField = new DataSourceFloatField("sheetAmount", "订单合同金额");
		sheetAmountField.setLength(18);
		sheetAmountField.setDecimalPad(2);
		sheetAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetAmountField.setRequired(false);
		sheetAmountField.setHidden(false);


		setFields(contractIdField, contractCodeField, projectCodeField, projectNameField, plateNameField, contractDateField, sheetAmountField);
	}


}

