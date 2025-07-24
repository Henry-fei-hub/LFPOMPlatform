package com.pomplatform.client.capitaldistribution.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPlateCapitalDistribution extends DBDataSource
{


	public static DSPlateCapitalDistribution instance = null;

	public static DSPlateCapitalDistribution getInstance() {
		if(instance == null) {
			instance = new DSPlateCapitalDistribution("DSPlateCapitalDistribution");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalDistributionIdField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField capitalIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceFloatField distributionAmountField;
	private final DataSourceIntegerField operatorField;

	public DSPlateCapitalDistribution(String dataSourceID) {

		super();
		setID(dataSourceID);


		capitalDistributionIdField = new DataSourceIntegerField("capitalDistributionId", "回款分配表编码");
		capitalDistributionIdField.setLength(11);
		capitalDistributionIdField.setPrimaryKey(true);
		capitalDistributionIdField.setRequired(true);
		capitalDistributionIdField.setHidden(true);


		codeField = new DataSourceTextField("code", "订单编号");
		codeField.setLength(64);
		codeField.setRequired(false);
		codeField.setHidden(false);


		contractIdField = new DataSourceIntegerField("contractId", "合同名称");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);

		typeField = new DataSourceIntegerField("type", " 2订单回款分配");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(true);


		capitalIdField = new DataSourceIntegerField("capitalId", "回款编码");
		capitalIdField.setLength(11);
		capitalIdField.setRequired(false);
		capitalIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		totalAmountField = new DataSourceFloatField("totalAmount", "回款金额");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(false);
		totalAmountField.setCanEdit(false);


		distributionAmountField = new DataSourceFloatField("distributionAmount", "回款分配金额");
		distributionAmountField.setLength(18);
		distributionAmountField.setDecimalPad(2);
		distributionAmountField.setFormat("#,###,###,###,###,##0.00");
		distributionAmountField.setRequired(false);
		distributionAmountField.setHidden(false);


		operatorField = new DataSourceIntegerField("operator", "操作者");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(true);
		operatorField.setValueMap(KeyValueManager.getValueMap("employees"));
		
		setFields(capitalDistributionIdField, contractIdField, typeField, capitalIdField, plateIdField, codeField, totalAmountField, distributionAmountField, operatorField);
	}


}

