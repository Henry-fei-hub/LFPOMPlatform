package com.pomplatform.client.cwd.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSScwdfilingmaintemplatetrcor extends DBDataSource {

	public static DSScwdfilingmaintemplatetrcor instance = null;

	public static DSScwdfilingmaintemplatetrcor getInstance() {
		if (instance == null) {
			instance = new DSScwdfilingmaintemplatetrcor("DSScwdfilingmaintemplatetrcor");
		}
		return instance;
	}

	private final DataSourceIntegerField cwdFilingMainTemplateIdField;
	private final DataSourceTextField templateNameField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateTimeField createTimeField;

	public DSScwdfilingmaintemplatetrcor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Scwdfilingmaintemplatetrcor");

		cwdFilingMainTemplateIdField = new DataSourceIntegerField("cwdFilingMainTemplateId", "主键");
		cwdFilingMainTemplateIdField.setLength(11);
		cwdFilingMainTemplateIdField.setPrimaryKey(true);
		cwdFilingMainTemplateIdField.setRequired(true);
		cwdFilingMainTemplateIdField.setHidden(true);

		templateNameField = new DataSourceTextField("templateName", "模板名称");
		templateNameField.setLength(255);
		templateNameField.setRequired(false);
		templateNameField.setHidden(false);

		projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));

		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setLength(11);
		operatorIdField.setRequired(false);
		operatorIdField.setHidden(false);
		operatorIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		setFields(cwdFilingMainTemplateIdField, templateNameField, projectTypeField, operatorIdField, departmentIdField,
				remarkField, createTimeField);
	}

}
