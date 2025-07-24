package com.pomplatform.client.contractreceivablecipor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSScontractreceivablecipor extends DBDataSource
{


	public static DSScontractreceivablecipor instance = null;

	public static DSScontractreceivablecipor getInstance() {
		if(instance == null) {
			instance = new DSScontractreceivablecipor("DSScontractreceivablecipor");
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

	public DSScontractreceivablecipor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Scontractreceivablecipor");


		contractReceivableIdField = new DataSourceIntegerField("contractReceivableId", "合同阶段id");
		contractReceivableIdField.setLength(11);
		contractReceivableIdField.setPrimaryKey(true);
		contractReceivableIdField.setRequired(true);
		contractReceivableIdField.setHidden(true);


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


		contractCodeField = new DataSourceTextField("contractCode", "合同主编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(true);


		receivableNameField = new DataSourceTextField("receivableName", "阶段名称");
		receivableNameField.setLength(128);
		receivableNameField.setRequired(false);
		receivableNameField.setHidden(false);


		receivablePercentageField = new DataSourceFloatField("receivablePercentage", "阶段收款率(%)");
		receivablePercentageField.setLength(16);
		receivablePercentageField.setDecimalPad(2);
		receivablePercentageField.setFormat("##,###,###,###,##0.00");
		receivablePercentageField.setRequired(false);
		receivablePercentageField.setHidden(false);


		receivableSumMoneyField = new DataSourceFloatField("receivableSumMoney", "收款金额");
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
		remarkField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "收款阶段id的父节点");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);


		setFields(contractReceivableIdField, infoCodeField, projectCodeField, contractIdField, contractCodeField, receivableNameField, receivablePercentageField, receivableSumMoneyField, isConfirmationLetterField, remarkField, parentIdField);
	}


}

