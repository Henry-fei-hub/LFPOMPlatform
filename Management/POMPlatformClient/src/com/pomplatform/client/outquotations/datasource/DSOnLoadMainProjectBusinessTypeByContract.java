package com.pomplatform.client.outquotations.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadMainProjectBusinessTypeByContract extends DBDataSource
{


	public static DSOnLoadMainProjectBusinessTypeByContract instance = null;

	public static DSOnLoadMainProjectBusinessTypeByContract getInstance() {
		if(instance == null) {
			instance = new DSOnLoadMainProjectBusinessTypeByContract("DSOnLoadMainProjectBusinessTypeByContract");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceIntegerField outQuotationIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceFloatField outputValueSumField;

	public DSOnLoadMainProjectBusinessTypeByContract(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadMainProjectBusinessTypeByContract");


		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setRequired(true);
		contractIdField.setHidden(false);


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "主键编码");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setPrimaryKey(true);
		mainProjectIdField.setRequired(true);
		mainProjectIdField.setHidden(false);


		outQuotationIdField = new DataSourceIntegerField("outQuotationId", "报价单编码");
		outQuotationIdField.setLength(11);
		outQuotationIdField.setPrimaryKey(true);
		outQuotationIdField.setRequired(true);
		outQuotationIdField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "合同金额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);


		outputValueSumField = new DataSourceFloatField("outputValueSum", "总产值");
		outputValueSumField.setLength(18);
		outputValueSumField.setDecimalPad(2);
		outputValueSumField.setFormat("#,###,###,###,###,##0.00");
		outputValueSumField.setRequired(true);
		outputValueSumField.setHidden(false);


		setFields(contractIdField, mainProjectIdField, outQuotationIdField, projectCodeField, projectNameField, signingMoneySumField, outputValueSumField);
	}


}

