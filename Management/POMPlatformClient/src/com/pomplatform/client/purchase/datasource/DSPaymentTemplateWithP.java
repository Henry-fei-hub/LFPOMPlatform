package com.pomplatform.client.purchase.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.FieldType;

public class DSPaymentTemplateWithP extends DBDataSource {

	public static DSPaymentTemplateWithP instance = null;

	public static DSPaymentTemplateWithP getInstance() {
		if (instance == null) {
			instance = new DSPaymentTemplateWithP("DSPaymentTemplateWithP");
		}
		return instance;
	}

	private final DataSourceIntegerField paymentTemplateIdField;
	private final DataSourceTextField templateNameField;
	private final DataSourceIntegerField paymentCycleField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceField detailPaymentTemplateDetail;

	public DSPaymentTemplateWithP(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("PaymentTemplateWithP");

		paymentTemplateIdField = new DataSourceIntegerField("paymentTemplateId", "payment_template_id");
		paymentTemplateIdField.setLength(11);
		paymentTemplateIdField.setPrimaryKey(true);
		paymentTemplateIdField.setRequired(true);
		paymentTemplateIdField.setHidden(true);
		paymentTemplateIdField.setRootValue("root");
		paymentTemplateIdField.setForeignKey("DSPaymentTemplateWithP.paymentTemplateId");

		templateNameField = new DataSourceTextField("templateName", "模板名称");
		templateNameField.setLength(255);
		templateNameField.setRequired(false);
		templateNameField.setHidden(false);

		paymentCycleField = new DataSourceIntegerField("paymentCycle", "支付周期(天)");
		paymentCycleField.setLength(11);
		paymentCycleField.setRequired(false);
		paymentCycleField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setLength(11);
		operatorIdField.setRequired(false);
		operatorIdField.setHidden(false);
		operatorIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		detailPaymentTemplateDetail = new DataSourceField("detailPaymentTemplateDetail", FieldType.ANY);
		detailPaymentTemplateDetail.setChildrenProperty(true);
		detailPaymentTemplateDetail.setChildTagName("PaymentTemplateDetail");
		detailPaymentTemplateDetail.setRequired(false);
		detailPaymentTemplateDetail.setHidden(true);

		setFields(paymentTemplateIdField, templateNameField, paymentCycleField, remarkField, operatorIdField,
				createTimeField, detailPaymentTemplateDetail);
	}

}
