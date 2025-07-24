package com.pomplatform.client.attachment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnAttachmentLinkContractReceivables extends DBDataSource
{


	public static DSOnAttachmentLinkContractReceivables instance = null;

	public static DSOnAttachmentLinkContractReceivables getInstance() {
		if(instance == null) {
			instance = new DSOnAttachmentLinkContractReceivables("DSOnAttachmentLinkContractReceivables");
		}
		return instance;
	}

	private final DataSourceIntegerField contractReceivableIdField;
	private final DataSourceTextField receivableNameField;
	private final DataSourceFloatField receivablePercentageField;
	private final DataSourceFloatField receivableSumMoneyField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField flagTypeField;
	private final DataSourceIntegerField bindAmountField;

	public DSOnAttachmentLinkContractReceivables(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnAttachmentLinkContractReceivables");


		contractReceivableIdField = new DataSourceIntegerField("contractReceivableId", "收款阶段编码");
		contractReceivableIdField.setLength(11);
		contractReceivableIdField.setRequired(false);
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


		parentIdField = new DataSourceIntegerField("parentId", "收款阶段id的父节点");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdField);


		flagTypeField = new DataSourceIntegerField("flagType", "绑定状态");
		flagTypeField.setLength(11);
		flagTypeField.setRequired(true);
		flagTypeField.setHidden(false);

		java.util.Map<String,String> flagTypeValues = new java.util.HashMap<String,String>();
		flagTypeValues.put("1", "未绑定");
		flagTypeValues.put("2", "已绑定");
		flagTypeField.setValueMap(flagTypeValues);
		
		bindAmountField = new DataSourceIntegerField("bindAmount", "绑定确认函");
		bindAmountField.setLength(11);
		bindAmountField.setRequired(true);
		bindAmountField.setHidden(false);


		setFields(contractReceivableIdField, receivableNameField, receivablePercentageField, receivableSumMoneyField, parentIdField, flagTypeField, bindAmountField);
	}


}

