package com.pomplatform.client.equipment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

import java.util.HashMap;
import java.util.Map;

public class DSMequipmenttypeedeeeor extends DBDataSource
{


	public static DSMequipmenttypeedeeeor instance = null;

	public static DSMequipmenttypeedeeeor getInstance() {
		if(instance == null) {
			instance = new DSMequipmenttypeedeeeor("DSMequipmenttypeedeeeor");
		}
		return instance;
	}

	private final DataSourceIntegerField equipmentTypeIdField;
	private final DataSourceTextField nameField;
//	private final DataSourceBooleanField enabledField;
	private final DataSourceTextField enabledField;
	private final DataSourceFloatField priceField;
	private final DataSourceIntegerField typeField;
	private final DataSourceDateField updateTimeField;
	private final DataSourceIntegerField updatePersonField;
	private final DataSourceIntegerField countField;
	private final DataSourceBooleanField isDeleteField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField departmentNameField;

	public DSMequipmenttypeedeeeor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mequipmenttypeedeeeor");


		equipmentTypeIdField = new DataSourceIntegerField("equipmentTypeId", "设备类型");
		equipmentTypeIdField.setLength(11);
		equipmentTypeIdField.setPrimaryKey(true);
		equipmentTypeIdField.setRequired(true);
		equipmentTypeIdField.setHidden(true);


		nameField = new DataSourceTextField("name", "物品名称");
		nameField.setLength(32);
		nameField.setRequired(false);
		nameField.setHidden(false);

		typeField = new DataSourceIntegerField("type", "物品类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(false);
		typeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_254"));

		priceField = new DataSourceFloatField("price", "单价");
		priceField.setLength(10);
		priceField.setDecimalPad(2);
		priceField.setFormat("##,###,##0.00");
		priceField.setRequired(false);
		priceField.setHidden(false);


		countField = new DataSourceIntegerField("count", "数量");
		countField.setLength(11);
		countField.setRequired(false);
		countField.setHidden(false);

		enabledField = new DataSourceTextField("flag", "物品状态");
		enabledField.setRequired(false);
		enabledField.setHidden(false);
		Map map = new HashMap();
		map.put("true","启用");
		map.put("false","禁用");
		enabledField.setValueMap(map);

		updatePersonField = new DataSourceIntegerField("updatePerson", "最近操作人");
		updatePersonField.setLength(11);
		updatePersonField.setRequired(false);
		updatePersonField.setHidden(true);

		isDeleteField = new DataSourceBooleanField("isDelete", "是否删除");
		isDeleteField.setRequired(false);
		isDeleteField.setHidden(true);


		employeeNameField = new DataSourceTextField("employeeName", "操作人");
		employeeNameField.setLength(32);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		departmentNameField = new DataSourceTextField("departmentName", "所属部门");
		departmentNameField.setLength(32);
		departmentNameField.setRequired(true);
		departmentNameField.setHidden(false);

		updateTimeField = new DataSourceDateField("updateTime", "操作时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(false);


		setFields(equipmentTypeIdField, nameField, typeField , priceField , countField , enabledField , updatePersonField, isDeleteField, employeeNameField, departmentNameField, updateTimeField);
	}


}

