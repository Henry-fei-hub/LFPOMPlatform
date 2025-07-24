package com.pomplatform.client.bonuspayment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSBonusPaymentDetailAudit extends DBDataSource {

	public static DSBonusPaymentDetailAudit instance = null;

	public static DSBonusPaymentDetailAudit getInstance() {
		if (instance == null) {
			instance = new DSBonusPaymentDetailAudit("DSBonusPaymentDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField bonusPaymentDetailIdField;
	private final DataSourceIntegerField bonusPaymentRecordIdField;
	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceFloatField achieveIntegralField;
	private final DataSourceFloatField payPercentField;
	private final DataSourceFloatField payIntegralField;
	private final DataSourceFloatField leftIntegralField;
	private final DataSourceDateField payDateField;
	private final DataSourceIntegerField stateField;
	private final DataSourceIntegerField sendNumberField;
	private final DataSourceFloatField firstIntegralField;
	private final DataSourceFloatField secondIntegralField;
	private final DataSourceFloatField thirdIntegralField;

	public DSBonusPaymentDetailAudit(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BonusPaymentDetail");

		bonusPaymentDetailIdField = new DataSourceIntegerField("bonusPaymentDetailId", "主键编码");
		bonusPaymentDetailIdField.setLength(11);
		bonusPaymentDetailIdField.setPrimaryKey(true);
		bonusPaymentDetailIdField.setRequired(true);
		bonusPaymentDetailIdField.setHidden(true);

		bonusPaymentRecordIdField = new DataSourceIntegerField("bonusPaymentRecordId", "奖金发放记录编码");
		bonusPaymentRecordIdField.setLength(11);
		bonusPaymentRecordIdField.setRequired(false);
		bonusPaymentRecordIdField.setHidden(true);

		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(65);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);

		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);

		achieveIntegralField = new DataSourceFloatField("achieveIntegral", "价值积分");
		achieveIntegralField.setLength(18);
		achieveIntegralField.setDecimalPad(2);
		achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(true);

		payPercentField = new DataSourceFloatField("payPercent", "发放比率(%)");
		payPercentField.setLength(5);
		payPercentField.setDecimalPad(2);
		payPercentField.setFormat("##0.00");
		payPercentField.setRequired(false);
		payPercentField.setHidden(true);

		payIntegralField = new DataSourceFloatField("payIntegral", "发放积分");
		payIntegralField.setLength(12);
		payIntegralField.setDecimalPad(2);
		payIntegralField.setFormat("#,###,###,##0.00");
		payIntegralField.setRequired(false);
		payIntegralField.setHidden(false);

		leftIntegralField = new DataSourceFloatField("leftIntegral", "剩余积分");
		leftIntegralField.setLength(12);
		leftIntegralField.setDecimalPad(2);
		leftIntegralField.setFormat("#,###,###,##0.00");
		leftIntegralField.setRequired(false);
		leftIntegralField.setHidden(true);

		payDateField = new DataSourceDateField("payDate", "发放年月");
		payDateField.setRequired(false);
		payDateField.setHidden(true);

		stateField = new DataSourceIntegerField("state", "审核状态");
		stateField.setLength(11);
		stateField.setRequired(false);
		stateField.setHidden(true);
		stateField.setValueMap(KeyValueManager.getValueMap("system_dictionary_36"));
		
		
		sendNumberField = new DataSourceIntegerField("sendNumber", "发放次数");
		sendNumberField.setLength(11);
		sendNumberField.setRequired(false);
		sendNumberField.setHidden(false);


		firstIntegralField = new DataSourceFloatField("firstIntegral", "第一次发放积分");
		firstIntegralField.setLength(18);
		firstIntegralField.setDecimalPad(2);
		firstIntegralField.setFormat("#,###,###,###,###,##0.00");
		firstIntegralField.setRequired(false);
		firstIntegralField.setHidden(false);


		secondIntegralField = new DataSourceFloatField("secondIntegral", "第二次发放积分");
		secondIntegralField.setLength(18);
		secondIntegralField.setDecimalPad(2);
		secondIntegralField.setFormat("#,###,###,###,###,##0.00");
		secondIntegralField.setRequired(false);
		secondIntegralField.setHidden(false);


		thirdIntegralField = new DataSourceFloatField("thirdIntegral", "第三次发放积分");
		thirdIntegralField.setLength(18);
		thirdIntegralField.setDecimalPad(2);
		thirdIntegralField.setFormat("#,###,###,###,###,##0.00");
		thirdIntegralField.setRequired(false);
		thirdIntegralField.setHidden(false);

		setFields(bonusPaymentDetailIdField, bonusPaymentRecordIdField, employeeIdField, employeeNoField,
				employeeNameField, achieveIntegralField, payPercentField, payIntegralField, sendNumberField,firstIntegralField,secondIntegralField,thirdIntegralField,
				leftIntegralField,payDateField, stateField, plateIdField);
	}

}
