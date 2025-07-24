package com.pomplatform.client.capitaldistribution.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProjectCapitalDistribution extends DBDataSource
{


	public static DSProjectCapitalDistribution instance = null;

	public static DSProjectCapitalDistribution getInstance() {
		if(instance == null) {
			instance = new DSProjectCapitalDistribution("DSProjectCapitalDistribution");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalDistributionIdField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField capitalIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceFloatField distributionAmountField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceFloatField sheetAmountField;
	private final DataSourceFloatField distributedAmountField;
	private final DataSourceFloatField leftAmountField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField projectIntegralField;
	private final DataSourceFloatField sureIntegralField;
	private final DataSourceDateTimeField createTimeField;
	
	
	public DSProjectCapitalDistribution(String dataSourceID) {

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
		codeField.setCanEdit(false);


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


		projectIdField = new DataSourceIntegerField("projectId", "订单名称");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
		KeyValueManager.loadValueMap("projects",projectIdField);


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
		
		sheetAmountField = new DataSourceFloatField("sheetAmount", "订单合同金额");
		sheetAmountField.setLength(18);
		sheetAmountField.setDecimalPad(2);
		sheetAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetAmountField.setRequired(false);
		sheetAmountField.setCanEdit(false);
		
		distributedAmountField = new DataSourceFloatField("distributedAmount", "已分配金额");
		distributedAmountField.setLength(18);
		distributedAmountField.setDecimalPad(2);
		distributedAmountField.setFormat("#,###,###,###,###,##0.00");
		distributedAmountField.setRequired(false);
		distributedAmountField.setCanEdit(false);
		
		leftAmountField = new DataSourceFloatField("leftAmount", "剩余的可分配金额");
		leftAmountField.setLength(18);
		leftAmountField.setDecimalPad(2);
		leftAmountField.setFormat("#,###,###,###,###,##0.00");
		leftAmountField.setRequired(false);
		leftAmountField.setHidden(true);
		
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);
		plateIdField.setCanEdit(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		projectIntegralField = new DataSourceFloatField("projectIntegral", "订单积分");
		projectIntegralField.setLength(18);
		projectIntegralField.setDecimalPad(2);
		projectIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectIntegralField.setRequired(false);
		projectIntegralField.setCanEdit(false);
		
		sureIntegralField = new DataSourceFloatField("sureIntegral", "确认积分");
		sureIntegralField.setLength(18);
		sureIntegralField.setDecimalPad(2);
		sureIntegralField.setFormat("#,###,###,###,###,##0.00");
		sureIntegralField.setRequired(false);
		sureIntegralField.setCanEdit(false);
		
		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);
		
		setFields(capitalDistributionIdField, contractIdField, typeField, capitalIdField, plateIdField, projectIdField, codeField, sheetAmountField, distributedAmountField, totalAmountField, distributionAmountField, operatorField, leftAmountField, projectIntegralField, sureIntegralField, createTimeField);
	}


}

