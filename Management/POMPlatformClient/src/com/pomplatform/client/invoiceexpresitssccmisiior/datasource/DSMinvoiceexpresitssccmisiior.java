package com.pomplatform.client.invoiceexpresitssccmisiior.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMinvoiceexpresitssccmisiior extends DBDataSource {

	public static DSMinvoiceexpresitssccmisiior instance = null;

	public static DSMinvoiceexpresitssccmisiior getInstance() {
		if (instance == null) {
			instance = new DSMinvoiceexpresitssccmisiior("DSMinvoiceexpresitssccmisiior");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField invoiceExpressIdField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField courierTypeField;
	private final DataSourceIntegerField contactIdField;
	private final DataSourceTextField clientNameField;
	private final DataSourceTextField telField;
	private final DataSourceTextField courierNumberField;
	private final DataSourceTextField mailingAddressField;
	private final DataSourceDateTimeField courierDateField;
	private final DataSourceIntegerField signStatusField;
	private final DataSourceDateTimeField signDateField;
	private final DataSourceTextField signNameField;
	private final DataSourceTextField signReceiptField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField operatorField;

	public DSMinvoiceexpresitssccmisiior(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Minvoiceexpresitssccmisiior");

		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);

		invoiceExpressIdField = new DataSourceIntegerField("invoiceExpressId", "开发票 编码");
		invoiceExpressIdField.setLength(11);
		invoiceExpressIdField.setPrimaryKey(true);
		invoiceExpressIdField.setRequired(true);
		invoiceExpressIdField.setHidden(true);
		invoiceExpressIdField.setRootValue("root");
		invoiceExpressIdField.setForeignKey("Minvoiceexpresitssccmisiior.invoiceExpressId");

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(64);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);

		courierTypeField = new DataSourceIntegerField("courierType", "快递类型");
		courierTypeField.setLength(11);
		courierTypeField.setRequired(false);
		courierTypeField.setHidden(false);
		courierTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_56"));

		contactIdField = new DataSourceIntegerField("contactId", "联系人主键   对应  client 表 主键");
		contactIdField.setLength(11);
		contactIdField.setRequired(false);
		contactIdField.setHidden(true);

		clientNameField = new DataSourceTextField("clientName", "联系人姓名");
		clientNameField.setLength(64);
		clientNameField.setRequired(false);
		clientNameField.setHidden(false);

		telField = new DataSourceTextField("tel", "电话");
		telField.setLength(16);
		telField.setRequired(false);
		telField.setHidden(false);

		courierNumberField = new DataSourceTextField("courierNumber", "快递单号");
		courierNumberField.setLength(64);
		courierNumberField.setRequired(false);
		courierNumberField.setHidden(false);

		mailingAddressField = new DataSourceTextField("mailingAddress", "寄件地址");
		mailingAddressField.setLength(512);
		mailingAddressField.setRequired(false);
		mailingAddressField.setHidden(false);

		courierDateField = new DataSourceDateTimeField("courierDate", "快递日期");
		courierDateField.setRequired(false);
		courierDateField.setHidden(false);

		signStatusField = new DataSourceIntegerField("signStatus", "快递状态");
		signStatusField.setLength(11);
		signStatusField.setRequired(false);
		signStatusField.setHidden(false);
		signStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_57"));

		signDateField = new DataSourceDateTimeField("signDate", "签收日期");
		signDateField.setRequired(false);
		signDateField.setHidden(false);

		signNameField = new DataSourceTextField("signName", "签收人");
		signNameField.setLength(64);
		signNameField.setRequired(false);
		signNameField.setHidden(false);

		signReceiptField = new DataSourceTextField("signReceipt", "签收回执文件路劲");
		signReceiptField.setLength(512);
		signReceiptField.setRequired(false);
		signReceiptField.setHidden(true);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
		
		operatorField = new DataSourceIntegerField("operator", "登记人");
		operatorField.setLength(16);
		operatorField.setRequired(false);
		operatorField.setHidden(false);
		operatorField.setValueMap(KeyValueManager.getValueMap("employees"));

		setFields(invoiceExpressIdField, courierDateField, signStatusField, contractIdField, contractCodeField, contractNameField, infoCodeField,
				projectCodeField, courierTypeField, contactIdField, clientNameField, telField, courierNumberField,
				mailingAddressField, remarkField, signDateField, signNameField, signReceiptField, operatorField);
	}

}
