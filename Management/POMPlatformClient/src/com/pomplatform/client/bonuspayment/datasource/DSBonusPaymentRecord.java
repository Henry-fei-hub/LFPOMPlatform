package com.pomplatform.client.bonuspayment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSBonusPaymentRecord extends DBDataSource
{


	public static DSBonusPaymentRecord instance = null;

	public static DSBonusPaymentRecord getInstance() {
		if(instance == null) {
			instance = new DSBonusPaymentRecord("DSBonusPaymentRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField bonusPaymentRecordIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField payIntegralField;
	private final DataSourceDateField payDateField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField applicantField;
	private final DataSourceDateTimeField applyTimeField;
	private final DataSourceIntegerField stateField;
	private final DataSourceTextField opinionField;
	private final DataSourceIntegerField auditorField;
	private final DataSourceDateTimeField auditingTimeField;

	public DSBonusPaymentRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BonusPaymentRecord");


		bonusPaymentRecordIdField = new DataSourceIntegerField("bonusPaymentRecordId", "主键编码");
		bonusPaymentRecordIdField.setLength(11);
		bonusPaymentRecordIdField.setPrimaryKey(true);
		bonusPaymentRecordIdField.setRequired(true);
		bonusPaymentRecordIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		payIntegralField = new DataSourceFloatField("payIntegral", "发放积分");
		payIntegralField.setLength(12);
		payIntegralField.setDecimalPad(2);
		payIntegralField.setFormat("#,###,###,##0.00");
		payIntegralField.setRequired(false);
		payIntegralField.setHidden(false);


		payDateField = new DataSourceDateField("payDate", "申请日期");
		payDateField.setRequired(false);
		payDateField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "申请缘由");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		applicantField = new DataSourceIntegerField("applicant", "申请人");
		applicantField.setLength(11);
		applicantField.setRequired(false);
		applicantField.setHidden(false);
//		applicantField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",applicantField);

		applyTimeField = new DataSourceDateTimeField("applyTime", "申请时间");
		applyTimeField.setRequired(false);
		applyTimeField.setHidden(true);


		stateField = new DataSourceIntegerField("state", "审核状态");
		stateField.setLength(11);
		stateField.setRequired(false);
		stateField.setHidden(false);
		stateField.setValueMap(KeyValueManager.getValueMap("system_dictionary_36"));


		opinionField = new DataSourceTextField("opinion", "审核意见");
		opinionField.setLength(512);
		opinionField.setRequired(false);
		opinionField.setHidden(false);


		auditorField = new DataSourceIntegerField("auditor", "审核人");
		auditorField.setLength(11);
		auditorField.setRequired(false);
		auditorField.setHidden(true);
//		auditorField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",auditorField);

		auditingTimeField = new DataSourceDateTimeField("auditingTime", "发放时间");
		auditingTimeField.setRequired(false);
		auditingTimeField.setHidden(false);


		setFields(bonusPaymentRecordIdField, plateIdField, payIntegralField, payDateField, auditingTimeField, remarkField, applicantField, applyTimeField, stateField, opinionField, auditorField);
	}


}

