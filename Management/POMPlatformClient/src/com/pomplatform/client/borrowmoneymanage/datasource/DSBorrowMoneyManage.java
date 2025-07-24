package com.pomplatform.client.borrowmoneymanage.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSBorrowMoneyManage extends DBDataSource
{


	public static DSBorrowMoneyManage instance = null;

	public static DSBorrowMoneyManage getInstance() {
		if(instance == null) {
			instance = new DSBorrowMoneyManage("DSBorrowMoneyManage");
		}
		return instance;
	}

	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField borrowLimitManageIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceFloatField borrowLimitMoneyField;
	private final DataSourceIntegerField createEmployeeIdField;
	private final DataSourceDateField createDateField;
	private final DataSourceIntegerField updateEmployeeIdField;
	private final DataSourceDateField updateDateField;

	public DSBorrowMoneyManage(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BorrowMoneyManage");


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		statusField = new DataSourceIntegerField("status", "在职状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));


		borrowLimitManageIdField = new DataSourceIntegerField("borrowLimitManageId", "主键编码");
		borrowLimitManageIdField.setLength(11);
		borrowLimitManageIdField.setPrimaryKey(true);
		borrowLimitManageIdField.setRequired(true);
		borrowLimitManageIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		borrowLimitMoneyField = new DataSourceFloatField("borrowLimitMoney", "借款额度");
		borrowLimitMoneyField.setLength(18);
		borrowLimitMoneyField.setDecimalPad(5);
		borrowLimitMoneyField.setFormat("#,###,###,###,##0.00");
		borrowLimitMoneyField.setRequired(false);
		borrowLimitMoneyField.setHidden(false);


		createEmployeeIdField = new DataSourceIntegerField("createEmployeeId", "创建人");
		createEmployeeIdField.setLength(11);
		createEmployeeIdField.setRequired(false);
		createEmployeeIdField.setHidden(false);
		createEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		createDateField = new DataSourceDateField("createDate", "创建日期");
		createDateField.setRequired(false);
		createDateField.setHidden(false);


		updateEmployeeIdField = new DataSourceIntegerField("updateEmployeeId", "更新人");
		updateEmployeeIdField.setLength(11);
		updateEmployeeIdField.setRequired(false);
		updateEmployeeIdField.setHidden(false);
		updateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		updateDateField = new DataSourceDateField("updateDate", "更新日期");
		updateDateField.setRequired(false);
		updateDateField.setHidden(false);


		setFields(borrowLimitManageIdField, employeeNoField, employeeNameField, departmentIdField, statusField, employeeIdField, borrowLimitMoneyField, createEmployeeIdField, createDateField, updateEmployeeIdField, updateDateField);
	}


}

