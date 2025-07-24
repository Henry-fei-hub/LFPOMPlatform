package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSContractDistributionNew extends DBDataSource
{


	public static DSContractDistributionNew instance = null;

	public static DSContractDistributionNew getInstance() {
		if(instance == null) {
			instance = new DSContractDistributionNew("DSContractDistributionNew");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceDateField contractDateField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceTextField plateNameField;
	private final DataSourceFloatField realRelativelyField;
	private final DataSourceFloatField relativelyProgressField;
	private final DataSourceFloatField sumField;

	public DSContractDistributionNew(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractDistributionNew");


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
		contractIdField.setForeignKey("DSContractDistributionNew.contractId");


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractDateField = new DataSourceDateField("contractDate", "签订日期");
		contractDateField.setRequired(false);
		contractDateField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "签约金额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);


		businessTypeField = new DataSourceTextField("businessType", "业态");
		businessTypeField.setLength(32);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);
		businessTypeField.setHidden(true);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));


		plateNameField = new DataSourceTextField("plateName", "部门名称");
		plateNameField.setLength(64);
		plateNameField.setRequired(false);
		plateNameField.setHidden(false);


		realRelativelyField = new DataSourceFloatField("realRelatively", "项目总进度(%)");
		realRelativelyField.setLength(18);
		realRelativelyField.setDecimalPad(2);
		realRelativelyField.setFormat("#,###,###,###,###,##0.00");
		realRelativelyField.setRequired(true);
		realRelativelyField.setHidden(false);


		relativelyProgressField = new DataSourceFloatField("relativelyProgress", "提成进度(%)");
		relativelyProgressField.setLength(32);
		relativelyProgressField.setDecimalPad(2);
		relativelyProgressField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
		relativelyProgressField.setRequired(false);
		relativelyProgressField.setHidden(false);


		sumField = new DataSourceFloatField("sum", "提成金额");
		sumField.setLength(18);
		sumField.setDecimalPad(2);
		sumField.setFormat("#,###,###,###,###,##0.00");
		sumField.setRequired(true);
		sumField.setHidden(false);


		setFields(contractIdField, contractCodeField, contractDateField, contractNameField, signingMoneySumField, businessTypeField, plateNameField, realRelativelyField, relativelyProgressField, sumField);
	}


}

