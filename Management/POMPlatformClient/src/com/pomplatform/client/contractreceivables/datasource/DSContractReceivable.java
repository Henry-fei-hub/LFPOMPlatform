package com.pomplatform.client.contractreceivables.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSContractReceivable extends DBDataSource
{


	public static DSContractReceivable instance = null;

	public static DSContractReceivable getInstance() {
		if(instance == null) {
			instance = new DSContractReceivable("DSContractReceivable");
		}
		return instance;
	}

	private final DataSourceIntegerField contractReceivableIdField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField receivableNameField;
	private final DataSourceFloatField receivablePercentageField;
	private final DataSourceFloatField receivableSumMoneyField;
	private final DataSourceBooleanField isConfirmationLetterField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField parentIdField;
	
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceIntegerField operatorField;
	
	
	private final DataSourceFloatField stagePercentageField;//回款阶段百分比
	private final DataSourceFloatField stageSumMoneyField;//回款阶段金额
	
	

	public DSContractReceivable(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ContractReceivable");


		contractReceivableIdField = new DataSourceIntegerField("contractReceivableId", "合同阶段id");
		contractReceivableIdField.setLength(11);
		contractReceivableIdField.setPrimaryKey(true);
		contractReceivableIdField.setRequired(true);
		contractReceivableIdField.setHidden(true);
		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);

		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(64);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);


		contractCodeField = new DataSourceTextField("contractCode", "合同主编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(true);


		receivableNameField = new DataSourceTextField("receivableName", "阶段名称");
		receivableNameField.setLength(128);
		receivableNameField.setRequired(false);
		receivableNameField.setHidden(false);


		receivablePercentageField = new DataSourceFloatField("receivablePercentage", "收款百分比");
		receivablePercentageField.setLength(16);
		receivablePercentageField.setDecimalPad(2);
		receivablePercentageField.setFormat("##,###,###,###,##0.00");
		receivablePercentageField.setRequired(false);
		receivablePercentageField.setHidden(false);


		receivableSumMoneyField = new DataSourceFloatField("receivableSumMoney", "收款金额(单位:元)");
		receivableSumMoneyField.setLength(16);
		receivableSumMoneyField.setDecimalPad(2);
		receivableSumMoneyField.setFormat("##,###,###,###,##0.00");
		receivableSumMoneyField.setRequired(false);
		receivableSumMoneyField.setHidden(false);


		isConfirmationLetterField = new DataSourceBooleanField("isConfirmationLetter", "是否已经被用做过确认函");
		isConfirmationLetterField.setRequired(false);
		isConfirmationLetterField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "收款阶段备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "收款阶段id的父节点");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setForeignKey(dataSourceID+".contractReceivableId");
		parentIdField.setRootValue("");
		parentIdField.setHidden(true);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("project_types"));
		
		KeyValueManager.loadValueMap("project_types", parentIdField);

		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		
		
		stagePercentageField = new DataSourceFloatField("stagePercentage", "回款阶段百分比");
		stagePercentageField.setLength(16);
		stagePercentageField.setDecimalPad(2);
		stagePercentageField.setFormat("##,###,###,###,##0.00");
		stagePercentageField.setRequired(false);
		stagePercentageField.setHidden(false);
		
		stageSumMoneyField = new DataSourceFloatField("stageSumMoney", "回款阶段金额");
		stageSumMoneyField.setLength(16);
		stageSumMoneyField.setDecimalPad(2);
		stageSumMoneyField.setFormat("##,###,###,###,##0.00");
		stageSumMoneyField.setRequired(false);
		stageSumMoneyField.setHidden(false);
		setFields(contractReceivableIdField, infoCodeField, projectCodeField, contractIdField, contractCodeField, receivableNameField, receivablePercentageField, receivableSumMoneyField, isConfirmationLetterField, remarkField, parentIdField, operatorField,stagePercentageField,stageSumMoneyField,createTimeField,updateTimeField,operatorField);
	}


}

