package com.pomplatform.client.purchase.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMpurchaseplanmsommpmosror extends DBDataSource {

	public static DSMpurchaseplanmsommpmosror instance = null;

	public static DSMpurchaseplanmsommpmosror getInstance() {
		if (instance == null) {
			instance = new DSMpurchaseplanmsommpmosror("DSMpurchaseplanmsommpmosror");
		}
		return instance;
	}

	private final DataSourceIntegerField purchasePlanIdField;
	private final DataSourceIntegerField personInChargeField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField oriPersonnelBusinessIdField;
	private final DataSourceDateField purchaseDateField;
	private final DataSourceFloatField purchaseAmountField;
	private final DataSourceIntegerField supplierIdField;
	private final DataSourceTextField supplierNameField;
	private final DataSourceTextField supplierCodeField;
	private final DataSourceTextField abbreviatedNameField;
	private final DataSourceTextField majorContactPersonField;
	private final DataSourceTextField contactPhoneField;
	private final DataSourceFloatField taxAmountField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceIntegerField dealStatusField;
	private final DataSourceIntegerField purchaseContractIdField;
	private final DataSourceIntegerField toPersonnelBusinessIdField;

	public DSMpurchaseplanmsommpmosror(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mpurchaseplanmsommpmosror");

		purchasePlanIdField = new DataSourceIntegerField("purchasePlanId", "主键");
		purchasePlanIdField.setLength(11);
		purchasePlanIdField.setPrimaryKey(true);
		purchasePlanIdField.setRequired(true);
		purchasePlanIdField.setHidden(true);

		personInChargeField = new DataSourceIntegerField("personInCharge", "负责人");
		personInChargeField.setLength(11);
		personInChargeField.setRequired(false);
		personInChargeField.setHidden(false);
		personInChargeField.setValueMap(KeyValueManager.getValueMap("employees"));

		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "大项目主键");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(true);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);

		oriPersonnelBusinessIdField = new DataSourceIntegerField("oriPersonnelBusinessId", "源流程业务主键");
		oriPersonnelBusinessIdField.setLength(11);
		oriPersonnelBusinessIdField.setRequired(false);
		oriPersonnelBusinessIdField.setHidden(true);

		purchaseDateField = new DataSourceDateField("purchaseDate", "采购日期");
		purchaseDateField.setRequired(false);
		purchaseDateField.setHidden(false);

		purchaseAmountField = new DataSourceFloatField("purchaseAmount", "采购金额");
		purchaseAmountField.setLength(16);
		purchaseAmountField.setDecimalPad(2);
		purchaseAmountField.setFormat("##,###,###,###,##0.00");
		purchaseAmountField.setRequired(false);
		purchaseAmountField.setHidden(false);

		supplierIdField = new DataSourceIntegerField("supplierId", "供应商主键");
		supplierIdField.setLength(11);
		supplierIdField.setRequired(false);
		supplierIdField.setHidden(true);

		supplierNameField = new DataSourceTextField("supplierName", "供应商名称");
		supplierNameField.setLength(128);
		supplierNameField.setRequired(false);
		supplierNameField.setHidden(false);

		supplierCodeField = new DataSourceTextField("supplierCode", "供应商编号");
		supplierCodeField.setLength(64);
		supplierCodeField.setRequired(false);
		supplierCodeField.setHidden(true);

		abbreviatedNameField = new DataSourceTextField("abbreviatedName", "供应商简称");
		abbreviatedNameField.setLength(128);
		abbreviatedNameField.setRequired(false);
		abbreviatedNameField.setHidden(false);

		majorContactPersonField = new DataSourceTextField("majorContactPerson", "主要联系人");
		majorContactPersonField.setLength(128);
		majorContactPersonField.setRequired(false);
		majorContactPersonField.setHidden(false);

		contactPhoneField = new DataSourceTextField("contactPhone", "客户联系人电话");
		contactPhoneField.setLength(64);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(false);

		taxAmountField = new DataSourceFloatField("taxAmount", "含税金额");
		taxAmountField.setLength(16);
		taxAmountField.setDecimalPad(2);
		taxAmountField.setFormat("##,###,###,###,##0.00");
		taxAmountField.setRequired(false);
		taxAmountField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		operatorIdField = new DataSourceIntegerField("operatorId", "操作人(指派人)");
		operatorIdField.setLength(11);
		operatorIdField.setRequired(false);
		operatorIdField.setHidden(false);
		operatorIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		dealStatusField = new DataSourceIntegerField("dealStatus", "处理状态");
		dealStatusField.setLength(11);
		dealStatusField.setRequired(false);
		dealStatusField.setHidden(false);
		dealStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_207"));

		purchaseContractIdField = new DataSourceIntegerField("purchaseContractId", "采购合同主键");
		purchaseContractIdField.setLength(11);
		purchaseContractIdField.setRequired(false);
		purchaseContractIdField.setHidden(true);

		toPersonnelBusinessIdField = new DataSourceIntegerField("toPersonnelBusinessId", "采购实施业务主键");
		toPersonnelBusinessIdField.setLength(11);
		toPersonnelBusinessIdField.setRequired(false);
		toPersonnelBusinessIdField.setHidden(true);

		setFields(purchasePlanIdField, mainProjectIdField, projectCodeField, projectNameField,
				oriPersonnelBusinessIdField, purchaseDateField, purchaseAmountField, taxAmountField, supplierIdField,
				supplierNameField, supplierCodeField, abbreviatedNameField, majorContactPersonField, contactPhoneField,
				personInChargeField, operatorIdField, remarkField, dealStatusField, createTimeField, purchaseContractIdField,
				toPersonnelBusinessIdField);
	}

}
