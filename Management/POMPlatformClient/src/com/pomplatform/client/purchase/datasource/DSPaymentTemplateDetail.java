package com.pomplatform.client.purchase.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPaymentTemplateDetail extends DBDataSource {

	public static DSPaymentTemplateDetail instance = null;

	public static DSPaymentTemplateDetail getInstance() {
		if (instance == null) {
			instance = new DSPaymentTemplateDetail("DSPaymentTemplateDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField paymentTemplateDetailIdField;
	private final DataSourceIntegerField paymentTemplateIdField;
	private final DataSourceTextField paymentNameField;
	private final DataSourceIntegerField delayDayField;
	private final DataSourceIntegerField orderNumField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField paymentConditionField;
	private final DataSourceTextField remarkField;
	private final DataSourceFloatField paymentRatioField;

	public DSPaymentTemplateDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("PaymentTemplateDetail");

		paymentTemplateDetailIdField = new DataSourceIntegerField("paymentTemplateDetailId", "主键");
		paymentTemplateDetailIdField.setLength(11);
		paymentTemplateDetailIdField.setPrimaryKey(true);
		paymentTemplateDetailIdField.setRequired(true);
		paymentTemplateDetailIdField.setHidden(true);

		paymentTemplateIdField = new DataSourceIntegerField("paymentTemplateId", "模板主表主键");
		paymentTemplateIdField.setLength(11);
		paymentTemplateIdField.setRequired(false);
		paymentTemplateIdField.setHidden(true);
		paymentTemplateIdField.setForeignKey("DSPaymentTemplateWithP.paymentTemplateId");

		paymentNameField = new DataSourceTextField("paymentName", "支付名称(预付款、第一次付款等等)");
		paymentNameField.setLength(255);
		paymentNameField.setRequired(true);
		paymentNameField.setHidden(false);

		delayDayField = new DataSourceIntegerField("delayDay", "延迟天数(合同开始日期多天后付款)");
		delayDayField.setLength(11);
		delayDayField.setRequired(true);
		delayDayField.setHidden(false);

		orderNumField = new DataSourceIntegerField("orderNum", "排序值  升序排列");
		orderNumField.setLength(11);
		orderNumField.setRequired(false);
		orderNumField.setHidden(true);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		paymentConditionField = new DataSourceTextField("paymentCondition", "付款条件");
		paymentConditionField.setLength(1024);
		paymentConditionField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setHidden(false);

		paymentRatioField = new DataSourceFloatField("paymentRatio", "付款比例(%)");
		paymentRatioField.setFormat("##,###,###,###,##0.00");
		paymentRatioField.setLength(16);
		paymentRatioField.setDecimalPad(2);
		paymentRatioField.setHidden(false);

		setFields(paymentTemplateDetailIdField, paymentTemplateIdField, paymentNameField, paymentRatioField,
				paymentConditionField, delayDayField, orderNumField, remarkField, createTimeField);
	}

}
