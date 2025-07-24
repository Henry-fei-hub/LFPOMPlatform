package com.pomplatform.client.mcontractreceivableiicor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMcontractreceivableiicor extends DBDataSource
{


	public static DSMcontractreceivableiicor instance = null;

	public static DSMcontractreceivableiicor getInstance() {
		if(instance == null) {
			instance = new DSMcontractreceivableiicor("DSMcontractreceivableiicor");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField contractReceivableIdField;
	private final DataSourceTextField receivableNameField;
	private final DataSourceFloatField receivablePercentageField;
	private final DataSourceFloatField receivableSumMoneyField;
	private final DataSourceBooleanField isConfirmationLetterField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceFloatField receivableApplyMoneyField;
	private final DataSourceDateTimeField createTimeField;

	public DSMcontractreceivableiicor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mcontractreceivableiicor");


		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		contractReceivableIdField = new DataSourceIntegerField("contractReceivableId", "合同阶段id");
		contractReceivableIdField.setLength(11);
		contractReceivableIdField.setPrimaryKey(true);
		contractReceivableIdField.setRequired(true);
		contractReceivableIdField.setHidden(true);


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


		receivableSumMoneyField = new DataSourceFloatField("receivableSumMoney", "收款金额");
		receivableSumMoneyField.setLength(16);
		receivableSumMoneyField.setDecimalPad(2);
		receivableSumMoneyField.setFormat("##,###,###,###,##0.00");
		receivableSumMoneyField.setRequired(false);
		receivableSumMoneyField.setHidden(false);


		isConfirmationLetterField = new DataSourceBooleanField("isConfirmationLetter", "是否已经被用做过确认函");
		isConfirmationLetterField.setRequired(false);
		isConfirmationLetterField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "收款阶段备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "收款阶段id的父节点");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);


		receivableApplyMoneyField = new DataSourceFloatField("receivableApplyMoney", "阶段申请的金额");
		receivableApplyMoneyField.setLength(16);
		receivableApplyMoneyField.setDecimalPad(2);
		receivableApplyMoneyField.setFormat("##,###,###,###,##0.00");
		receivableApplyMoneyField.setRequired(false);
		receivableApplyMoneyField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		setFields(contractReceivableIdField, contractIdField, receivableNameField, receivablePercentageField, receivableSumMoneyField, isConfirmationLetterField, remarkField, parentIdField, receivableApplyMoneyField, createTimeField);
	}


}

