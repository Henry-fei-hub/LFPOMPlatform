package com.pomplatform.client.signatory.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class DSMainProjectMajorEmployee extends DBDataSource {

	public static DSMainProjectMajorEmployee instance = null;

	public static DSMainProjectMajorEmployee getInstance() {
		if (instance == null) {
			instance = new DSMainProjectMajorEmployee("DSMainProjectMajorEmployee");
		}
		return instance;
	}

	private final DataSourceIntegerField mainProjectMajorEmployeeIdField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField specialtyIdField;
	private final DataSourceIntegerField relationField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField stampHolderField;

	public DSMainProjectMajorEmployee(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("MainProjectMajorEmployee");

		mainProjectMajorEmployeeIdField = new DataSourceIntegerField("mainProjectMajorEmployeeId", "主键");
		mainProjectMajorEmployeeIdField.setLength(11);
		mainProjectMajorEmployeeIdField.setPrimaryKey(true);
		mainProjectMajorEmployeeIdField.setRequired(true);
		mainProjectMajorEmployeeIdField.setHidden(true);

		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "大项目主键");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(true);

		employeeIdField = new DataSourceIntegerField("employeeId", "人员");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		specialtyIdField = new DataSourceIntegerField("specialtyId", "专业");
		specialtyIdField.setLength(11);
		specialtyIdField.setRequired(false);
		specialtyIdField.setHidden(false);
		specialtyIdField.setValueMap(KeyValueManager.getValueMap("pm_specials"));

		relationField = new DataSourceIntegerField("relation", "角色");
		relationField.setLength(11);
		relationField.setRequired(false);
		relationField.setHidden(false);
		relationField.setValueMap(KeyValueManager.getValueMap("system_dictionary_212"));

		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setLength(11);
		operatorIdField.setRequired(false);
		operatorIdField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		stampHolderField = new DataSourceIntegerField("stampHolder", "印章持有人(盖章人)");
		stampHolderField.setLength(11);
		stampHolderField.setRequired(false);
		stampHolderField.setHidden(false);
		stampHolderField.setValueMap(KeyValueManager.getValueMap("employees"));

		setFields(mainProjectMajorEmployeeIdField, mainProjectIdField, employeeIdField, specialtyIdField, relationField,
				operatorIdField, createTimeField, stampHolderField);
	}

}
