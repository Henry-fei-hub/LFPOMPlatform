package com.pomplatform.client.equipment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMequipmentrecordedeor extends DBDataSource
{


	public static DSMequipmentrecordedeor instance = null;

	public static DSMequipmentrecordedeor getInstance() {
		if(instance == null) {
			instance = new DSMequipmentrecordedeor("DSMequipmentrecordedeor");
		}
		return instance;
	}

	private final DataSourceIntegerField operationTypeField;
	private final DataSourceIntegerField countField;
	private final DataSourceIntegerField followStatusField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField departmentNameField;
	private final DataSourceDateField operationTimeField;

	public DSMequipmentrecordedeor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mequipmentrecordedeor");


		operationTypeField = new DataSourceIntegerField("operationType", "操作类型");
		operationTypeField.setLength(5);
		operationTypeField.setRequired(true);
		operationTypeField.setHidden(false);
		operationTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_255"));


		countField = new DataSourceIntegerField("count", "数量");
		countField.setLength(11);
		countField.setRequired(false);
		countField.setHidden(false);


		followStatusField = new DataSourceIntegerField("followStatus", "流程状态");
		followStatusField.setLength(5);
		followStatusField.setRequired(false);
		followStatusField.setHidden(false);
		followStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		departmentNameField = new DataSourceTextField("departmentName", "部门名称");
		departmentNameField.setLength(64);
		departmentNameField.setRequired(true);
		departmentNameField.setHidden(false);


		operationTimeField = new DataSourceDateField("operationTime", "操作时间");
		operationTimeField.setRequired(false);
		operationTimeField.setHidden(false);


		setFields(operationTypeField, countField, followStatusField, employeeNameField, departmentNameField, operationTimeField);
	}


}

