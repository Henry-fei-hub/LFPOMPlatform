package com.pomplatform.client.cardmanage.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSEmployeeCardManage extends DBDataSource
{


	public static DSEmployeeCardManage instance = null;

	public static DSEmployeeCardManage getInstance() {
		if(instance == null) {
			instance = new DSEmployeeCardManage("DSEmployeeCardManage");
		}
		return instance;
	}

	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField cardManageIdField;
	private final DataSourceTextField objectIdField;
	private final DataSourceIntegerField objectTypeField;
	private final DataSourceTextField bankIdField;
	private final DataSourceTextField bankNameField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField bankAddressField;
	private final DataSourceIntegerField cardTypeField;
	private final DataSourceBooleanField defaultCardField;
	private final DataSourceBooleanField enabledField;

	public DSEmployeeCardManage(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeCardManage");


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


		cardManageIdField = new DataSourceIntegerField("cardManageId", "主键编码");
		cardManageIdField.setLength(11);
		cardManageIdField.setPrimaryKey(true);
		cardManageIdField.setRequired(true);
		cardManageIdField.setHidden(true);


		objectIdField = new DataSourceTextField("objectId", "对象ID");
		objectIdField.setLength(64);
		objectIdField.setRequired(false);
		objectIdField.setHidden(true);


		objectTypeField = new DataSourceIntegerField("objectType", "对象类型");
		objectTypeField.setLength(11);
		objectTypeField.setRequired(false);
		objectTypeField.setHidden(true);


		bankIdField = new DataSourceTextField("bankId", "开户行");
		bankIdField.setLength(64);
		bankIdField.setRequired(false);
		bankIdField.setHidden(false);
//		bankIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_68"));
		KeyValueManager.loadValueMap("banks", bankIdField);
		
		bankNameField = new DataSourceTextField("bankName","开户行（支行）");
		bankNameField.setRequired(false);
		bankNameField.setHidden(false);
		
		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setLength(64);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(false);


		bankAddressField = new DataSourceTextField("bankAddress", "开户行所在地");
		bankAddressField.setLength(128);
		bankAddressField.setRequired(false);
		bankAddressField.setHidden(false);


		cardTypeField = new DataSourceIntegerField("cardType", "卡类型");
		cardTypeField.setLength(11);
		cardTypeField.setRequired(false);
		cardTypeField.setHidden(true);


		defaultCardField = new DataSourceBooleanField("defaultCard", "是否为默认卡");
		defaultCardField.setRequired(false);
		defaultCardField.setHidden(false);


		enabledField = new DataSourceBooleanField("enabled", "是否启用");
		enabledField.setRequired(false);
		enabledField.setHidden(false);
		
		setFields(cardManageIdField, employeeNoField, employeeNameField, departmentIdField,statusField, objectIdField, objectTypeField, bankIdField,bankNameField, bankAccountField, bankAddressField, cardTypeField, defaultCardField, enabledField);
	}


}

