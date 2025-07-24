package com.pomplatform.client.equipment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSEquipmentDetail extends DBDataSource
{


	public static DSEquipmentDetail instance = null;

	public static DSEquipmentDetail getInstance() {
		if(instance == null) {
			instance = new DSEquipmentDetail("DSEquipmentDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField operationTypeField;
	private final DataSourceTextField nameField;
	private final DataSourceIntegerField countField;
	private final DataSourceIntegerField followStatusField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField departmentNameField;
	private final DataSourceIntegerField nextAuditorField;
	private final DataSourceDateTimeField operationTimeField;

	public DSEquipmentDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EquipmentDetail");


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);

		departmentNameField = new DataSourceTextField("departmentName", "部门名称");
		departmentNameField.setLength(64);
		departmentNameField.setRequired(true);
		departmentNameField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);

		nameField = new DataSourceTextField("name", "物品名称");
		nameField.setLength(128);
		nameField.setRequired(false);
		nameField.setHidden(false);

		nextAuditorField = new DataSourceIntegerField("nextAuditor", "物品类型");
		nextAuditorField.setLength(11);
		nextAuditorField.setRequired(false);
		nextAuditorField.setHidden(false);
		nextAuditorField.setValueMap(KeyValueManager.getValueMap("system_dictionary_252"));


		countField = new DataSourceIntegerField("count", "数量");
		countField.setLength(11);
		countField.setRequired(false);
		countField.setHidden(false);


		followStatusField = new DataSourceIntegerField("followStatus", "流程状态");
		followStatusField.setLength(5);
		followStatusField.setRequired(false);
		followStatusField.setHidden(true);


		operationTypeField = new DataSourceIntegerField("operationType", "操作类型");
		operationTypeField.setLength(5);
		operationTypeField.setRequired(false);
		operationTypeField.setHidden(false);
		operationTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_255"));


		operationTimeField = new DataSourceDateTimeField("operationTime", "操作时间");
		operationTimeField.setRequired(false);
		operationTimeField.setHidden(false);


		setFields(departmentNameField, employeeNameField, employeeNoField, nameField, nextAuditorField, countField, followStatusField, operationTypeField, operationTimeField);
	}


}

