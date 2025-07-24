package com.pomplatform.client.cwd.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCwdFilingTemplate extends DBDataSource {

	public static DSCwdFilingTemplate instance = null;

	public static DSCwdFilingTemplate getInstance() {
		if (instance == null) {
			instance = new DSCwdFilingTemplate("DSCwdFilingTemplate");
		}
		return instance;
	}

	private final DataSourceIntegerField cwdFilingTemplateIdField;
	private final DataSourceTextField templateNameField;
	private final DataSourceIntegerField filingTypeField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateTimeField createTimeField;

	public DSCwdFilingTemplate(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("CwdFilingTemplate");

		cwdFilingTemplateIdField = new DataSourceIntegerField("cwdFilingTemplateId", "");
		cwdFilingTemplateIdField.setLength(11);
		cwdFilingTemplateIdField.setPrimaryKey(true);
		cwdFilingTemplateIdField.setRequired(true);
		cwdFilingTemplateIdField.setHidden(true);

		templateNameField = new DataSourceTextField("templateName", "模板名称");
		templateNameField.setLength(255);
		templateNameField.setRequired(false);
		templateNameField.setHidden(false);

		filingTypeField = new DataSourceIntegerField("filingType", "归档类型");
		filingTypeField.setLength(11);
		filingTypeField.setRequired(false);
		filingTypeField.setHidden(false);
		filingTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_199"));

		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setLength(11);
		operatorIdField.setRequired(false);
		operatorIdField.setHidden(false);
		operatorIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		setFields(cwdFilingTemplateIdField, templateNameField, filingTypeField, operatorIdField, remarkField,
				createTimeField);
	}

}
