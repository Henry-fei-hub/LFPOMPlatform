package com.pomplatform.client.employeeaccountrecordeeppccmmpebor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMemployeeaccountrecordeeppccmmpebor extends DBDataSource
{


	public static DSMemployeeaccountrecordeeppccmmpebor instance = null;

	public static DSMemployeeaccountrecordeeppccmmpebor getInstance() {
		if(instance == null) {
			instance = new DSMemployeeaccountrecordeeppccmmpebor("DSMemployeeaccountrecordeeppccmmpebor");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField sheetNameField;
	private final DataSourceFloatField integralField;
	private final DataSourceIntegerField projectFlagField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceFloatField sheetAmountField;
	private final DataSourceIntegerField employeeAccountRecordIdField;
	private final DataSourceFloatField moneyField;
	private final DataSourceFloatField percenteField;
	private final DataSourceFloatField confirmIntegralField;

	public DSMemployeeaccountrecordeeppccmmpebor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Memployeeaccountrecordeeppccmmpebor");


		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(true);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		sheetCodeField = new DataSourceTextField("sheetCode", "项目编号");
		sheetCodeField.setLength(64);
		sheetCodeField.setRequired(true);
		sheetCodeField.setHidden(false);


		sheetNameField = new DataSourceTextField("sheetName", "项目名称");
		sheetNameField.setLength(512);
		sheetNameField.setRequired(true);
		sheetNameField.setHidden(false);


		integralField = new DataSourceFloatField("integral", "确认积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);


		projectFlagField = new DataSourceIntegerField("projectFlag", "2研发项目)");
		projectFlagField.setLength(11);
		projectFlagField.setRequired(false);
		projectFlagField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目代码");
		projectIdField.setLength(11);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);


		sheetAmountField = new DataSourceFloatField("sheetAmount", "订单金额");
		sheetAmountField.setLength(18);
		sheetAmountField.setDecimalPad(2);
		sheetAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetAmountField.setRequired(false);
		sheetAmountField.setHidden(false);


		employeeAccountRecordIdField = new DataSourceIntegerField("employeeAccountRecordId", "主键编码");
		employeeAccountRecordIdField.setLength(11);
		employeeAccountRecordIdField.setPrimaryKey(true);
		employeeAccountRecordIdField.setRequired(true);
		employeeAccountRecordIdField.setHidden(true);


		moneyField = new DataSourceFloatField("money", "回款总金额");
		moneyField.setLength(16);
		moneyField.setDecimalPad(2);
		moneyField.setFormat("##,###,###,###,##0.00");
		moneyField.setRequired(false);
		moneyField.setHidden(false);


		percenteField = new DataSourceFloatField("percente", "回款百分比");
		percenteField.setLength(18);
		percenteField.setDecimalPad(2);
		percenteField.setFormat("#,###,###,###,###,##0.00");
		percenteField.setRequired(true);
		percenteField.setHidden(false);


		confirmIntegralField = new DataSourceFloatField("confirmIntegral", "真实积分");
		confirmIntegralField.setLength(18);
		confirmIntegralField.setDecimalPad(2);
		confirmIntegralField.setFormat("#,###,###,###,###,##0.00");
		confirmIntegralField.setRequired(true);
		confirmIntegralField.setHidden(false);


		setFields(employeeAccountRecordIdField, employeeIdField, employeeNoField, employeeNameField, sheetCodeField, sheetNameField, integralField, projectFlagField, projectIdField, sheetAmountField, moneyField, percenteField, confirmIntegralField);
	}


}

