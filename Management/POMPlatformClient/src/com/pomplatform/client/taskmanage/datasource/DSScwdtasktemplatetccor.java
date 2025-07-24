package com.pomplatform.client.taskmanage.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSScwdtasktemplatetccor extends DBDataSource {

	public static DSScwdtasktemplatetccor instance = null;

	public static DSScwdtasktemplatetccor getInstance() {
		if (instance == null) {
			instance = new DSScwdtasktemplatetccor("DSScwdtasktemplatetccor");
		}
		return instance;
	}

	private final DataSourceIntegerField cwdTaskTemplateIdField;
	private final DataSourceTextField templateNameField;
	private final DataSourceIntegerField projectAreaField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField companyNoField;
	private final DataSourceIntegerField numberOfDayField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceIntegerField numberOfParticipantField;

	public DSScwdtasktemplatetccor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Scwdtasktemplatetccor");

		cwdTaskTemplateIdField = new DataSourceIntegerField("cwdTaskTemplateId", "主键");
		cwdTaskTemplateIdField.setLength(11);
		cwdTaskTemplateIdField.setPrimaryKey(true);
		cwdTaskTemplateIdField.setRequired(true);
		cwdTaskTemplateIdField.setHidden(true);

		templateNameField = new DataSourceTextField("templateName", "模板名称");
		templateNameField.setLength(255);
		templateNameField.setRequired(false);
		templateNameField.setHidden(false);

		projectAreaField = new DataSourceIntegerField("projectArea", "项目面积");
		projectAreaField.setLength(11);
		projectAreaField.setRequired(false);
		projectAreaField.setHidden(false);

		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		companyIdField = new DataSourceIntegerField("companyId", "归属公司编码");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(true);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

		companyNoField = new DataSourceTextField("companyNo", "公司编号");
		companyNoField.setLength(64);
		companyNoField.setRequired(false);
		companyNoField.setHidden(true);

		numberOfDayField = new DataSourceIntegerField("numberOfDay", "天数(周期)");
		numberOfDayField.setLength(11);
		numberOfDayField.setRequired(false);
		numberOfDayField.setHidden(false);

		projectLevelField = new DataSourceIntegerField("projectLevel", "项目类型");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(false);

		numberOfParticipantField = new DataSourceIntegerField("numberOfParticipant", "参与人数");
		numberOfParticipantField.setLength(11);
		numberOfParticipantField.setRequired(false);
		numberOfParticipantField.setHidden(false);

		setFields(cwdTaskTemplateIdField, templateNameField, projectAreaField, companyIdField, companyNoField,
				numberOfDayField, projectLevelField, numberOfParticipantField, departmentIdField, operatorField,
				createTimeField);
	}

}
