package com.pomplatform.client.projectTemplate.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojecttemplateor extends DBDataSource
{


	public static DSSprojecttemplateor instance = null;

	public static DSSprojecttemplateor getInstance() {
		if(instance == null) {
			instance = new DSSprojecttemplateor("DSSprojecttemplateor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectTemplateIdField;
	private final DataSourceTextField projectTemplateNameField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField businessTypeField;

	public DSSprojecttemplateor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sprojecttemplateor");


		projectTemplateIdField = new DataSourceIntegerField("projectTemplateId", "项目阶段模板id");
		projectTemplateIdField.setLength(11);
		projectTemplateIdField.setRequired(true);
		projectTemplateIdField.setHidden(true);


		projectTemplateNameField = new DataSourceTextField("projectTemplateName", "项目阶段模板名称");
		projectTemplateNameField.setLength(56);
		projectTemplateNameField.setRequired(false);
		projectTemplateNameField.setHidden(false);


		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));


		setFields(projectTemplateIdField, projectTemplateNameField, businessTypeField, plateIdField, projectTypeField);
	}


}

