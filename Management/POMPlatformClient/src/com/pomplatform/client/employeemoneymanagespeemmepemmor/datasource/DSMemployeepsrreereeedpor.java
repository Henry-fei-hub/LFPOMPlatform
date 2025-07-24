package com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMemployeepsrreereeedpor extends DBDataSource {

	public static DSMemployeepsrreereeedpor instance = null;

	public static DSMemployeepsrreereeedpor getInstance() {
		if (instance == null) {
			instance = new DSMemployeepsrreereeedpor("DSMemployeepsrreereeedpor");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField initialBalanceField;
	private final DataSourceFloatField payMoneyField;
	private final DataSourceFloatField balanceAmountField;
	private final DataSourceFloatField balanceField;

	public DSMemployeepsrreereeedpor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Memployeepsrreereeedpor");

		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);

		statusField = new DataSourceIntegerField("status", "在职状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));

		initialBalanceField = new DataSourceFloatField("initialBalance", "期初余额");
		initialBalanceField.setLength(16);
		initialBalanceField.setDecimalPad(2);
		initialBalanceField.setFormat("##,###,###,###,##0.00");
		initialBalanceField.setRequired(false);
		initialBalanceField.setHidden(false);

		payMoneyField = new DataSourceFloatField("payMoney", "付款金额");
		payMoneyField.setLength(16);
		payMoneyField.setDecimalPad(2);
		payMoneyField.setFormat("##,###,###,###,##0.00");
		payMoneyField.setRequired(false);
		payMoneyField.setHidden(false);

		balanceAmountField = new DataSourceFloatField("balanceAmount", "冲账金额");
		balanceAmountField.setLength(16);
		balanceAmountField.setDecimalPad(2);
		balanceAmountField.setFormat("##,###,###,###,##0.00");
		balanceAmountField.setRequired(false);
		balanceAmountField.setHidden(false);

		balanceField = new DataSourceFloatField("balance", "余额");
		balanceField.setLength(18);
		balanceField.setDecimalPad(2);
		balanceField.setFormat("#,###,###,###,###,##0.00");
		balanceField.setRequired(true);
		balanceField.setHidden(false);

		setFields(employeeIdField, employeeNameField, departmentIdField, employeeNoField, plateIdField, statusField,
				initialBalanceField, payMoneyField, balanceAmountField, balanceField);
	}

}
