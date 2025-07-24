package com.pomplatform.client.capitaldistribution.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCapitalDistributionOfProject extends DBDataSource
{


	public static DSCapitalDistributionOfProject instance = null;

	public static DSCapitalDistributionOfProject getInstance() {
		if(instance == null) {
			instance = new DSCapitalDistributionOfProject("DSCapitalDistributionOfProject");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalDistributionIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField capitalIdField;
	private final DataSourceIntegerField idField;
	private final DataSourceTextField projectContractCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceFloatField distributionAmountField;
	private final DataSourceDateField happenDateField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField plateIdField;

	public DSCapitalDistributionOfProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CapitalDistributionOfProject");


		capitalDistributionIdField = new DataSourceIntegerField("capitalDistributionId", "回款分配表编码");
		capitalDistributionIdField.setLength(11);
		capitalDistributionIdField.setPrimaryKey(true);
		capitalDistributionIdField.setRequired(true);
		capitalDistributionIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractIdField = new DataSourceIntegerField("contractId", "合同名称");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(false);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", contractIdField);

		typeField = new DataSourceIntegerField("type", " 2订单回款分配");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(true);


		capitalIdField = new DataSourceIntegerField("capitalId", "回款编码");
		capitalIdField.setLength(11);
		capitalIdField.setRequired(false);
		capitalIdField.setHidden(true);


		idField = new DataSourceIntegerField("id", "部门或者订单编码");
		idField.setLength(11);
		idField.setRequired(false);
		idField.setHidden(true);
		idField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		projectContractCodeField = new DataSourceTextField("projectContractCode", "订单编号");
		projectContractCodeField.setLength(64);
		projectContractCodeField.setRequired(true);
		projectContractCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		totalAmountField = new DataSourceFloatField("totalAmount", "回款金额");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(false);


		distributionAmountField = new DataSourceFloatField("distributionAmount", "回款分配金额");
		distributionAmountField.setLength(18);
		distributionAmountField.setDecimalPad(2);
		distributionAmountField.setFormat("#,###,###,###,###,##0.00");
		distributionAmountField.setRequired(false);
		distributionAmountField.setHidden(false);


		happenDateField = new DataSourceDateField("happenDate", "回款日期");
		happenDateField.setRequired(false);
		happenDateField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
		

		setFields(capitalDistributionIdField, contractCodeField, contractIdField, typeField, capitalIdField, plateIdField, idField, projectContractCodeField, projectNameField, totalAmountField, distributionAmountField, happenDateField, createTimeField, remarkField);
	}


}

