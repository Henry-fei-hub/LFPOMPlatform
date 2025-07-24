package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSBonusPaymentDetail extends DBDataSource
{


	public static DSBonusPaymentDetail instance = null;

	public static DSBonusPaymentDetail getInstance() {
		if(instance == null) {
			instance = new DSBonusPaymentDetail("DSBonusPaymentDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField bonusPaymentDetailIdField;
	private final DataSourceIntegerField bonusPaymentRecordIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceFloatField achieveIntegralField;
	private final DataSourceFloatField payPercentField;
	private final DataSourceFloatField payIntegralField;
	private final DataSourceFloatField leftIntegralField;
	private final DataSourceDateField payDateField;
	private final DataSourceIntegerField stateField;
	private final DataSourceBooleanField isReturnField;
	private final DataSourceBooleanField isLevelTwoField;
	private final DataSourceFloatField firstIntegralField;
	private final DataSourceFloatField secondIntegralField;
	private final DataSourceFloatField thirdIntegralField;
	private final DataSourceIntegerField sendNumberField;
	private final DataSourceIntegerField departmentIdField;

	public DSBonusPaymentDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
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


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

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
		achieveIntegralField.setLength(15);
		achieveIntegralField.setDecimalPad(5);
		achieveIntegralField.setFormat("#,###,###,##0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(false);


		payPercentField = new DataSourceFloatField("payPercent", "发放比率");
		payPercentField.setLength(5);
		payPercentField.setDecimalPad(2);
		payPercentField.setFormat("##0.00");
		payPercentField.setRequired(false);
		payPercentField.setHidden(false);


		payIntegralField = new DataSourceFloatField("payIntegral", "发放积分");
		payIntegralField.setLength(15);
		payIntegralField.setDecimalPad(5);
		payIntegralField.setFormat("#,###,###,##0.00");
		payIntegralField.setRequired(false);
		payIntegralField.setHidden(false);


		leftIntegralField = new DataSourceFloatField("leftIntegral", "剩余积分");
		leftIntegralField.setLength(15);
		leftIntegralField.setDecimalPad(5);
		leftIntegralField.setFormat("#,###,###,##0.00");
		leftIntegralField.setRequired(false);
		leftIntegralField.setHidden(false);


		payDateField = new DataSourceDateField("payDate", "发放年月");
		payDateField.setRequired(false);
		payDateField.setHidden(false);


		stateField = new DataSourceIntegerField("state", "审核状态");
		stateField.setLength(11);
		stateField.setRequired(false);
		stateField.setHidden(true);


		isReturnField = new DataSourceBooleanField("isReturn", "积分是否回收的标识，true回收； false不回收");
		isReturnField.setRequired(false);
		isReturnField.setHidden(true);


		isLevelTwoField = new DataSourceBooleanField("isLevelTwo", "是否二级部门提交的");
		isLevelTwoField.setRequired(false);
		isLevelTwoField.setHidden(true);


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


		sendNumberField = new DataSourceIntegerField("sendNumber", "发放次数");
		sendNumberField.setLength(11);
		sendNumberField.setRequired(false);
		sendNumberField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门id");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);


		setFields(bonusPaymentDetailIdField, bonusPaymentRecordIdField, plateIdField, employeeIdField, employeeNoField, employeeNameField, achieveIntegralField, payPercentField, payIntegralField, leftIntegralField, payDateField, stateField, isReturnField, isLevelTwoField,sendNumberField, firstIntegralField, secondIntegralField, thirdIntegralField, departmentIdField);
	}


}

