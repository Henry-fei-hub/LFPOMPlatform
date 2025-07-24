package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectstagetemplatepor extends DBDataSource
{


	public static DSSprojectstagetemplatepor instance = null;

	public static DSSprojectstagetemplatepor getInstance() {
		if(instance == null) {
			instance = new DSSprojectstagetemplatepor("DSSprojectstagetemplatepor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectStageTemplateIdField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceIntegerField percentField;
	private final DataSourceTextField stageNameField;
	private final DataSourceTextField projectTemplateNameField;
	private final DataSourceIntegerField projectTemplateIdField;
	private final DataSourceIntegerField projectAmountField;

	public DSSprojectstagetemplatepor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sprojectstagetemplatepor");


		projectStageTemplateIdField = new DataSourceIntegerField("projectStageTemplateId", "项目阶段代码");
		projectStageTemplateIdField.setLength(11);
		projectStageTemplateIdField.setPrimaryKey(true);
		projectStageTemplateIdField.setRequired(true);
		projectStageTemplateIdField.setHidden(true);


		stageIdField = new DataSourceIntegerField("stageId", "阶段代码");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(false);
//		stageIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

		percentField = new DataSourceIntegerField("percent", "占比(%)");
		percentField.setLength(11);
		percentField.setRequired(false);
		percentField.setHidden(false);


		stageNameField = new DataSourceTextField("stageName", "阶段名称");
		stageNameField.setLength(56);
		stageNameField.setRequired(false);
		stageNameField.setHidden(false);
		


		projectTemplateNameField = new DataSourceTextField("projectTemplateName", "项目阶段模板名称");
		projectTemplateNameField.setLength(56);
		projectTemplateNameField.setRequired(false);
		projectTemplateNameField.setHidden(true);


		projectTemplateIdField = new DataSourceIntegerField("projectTemplateId", "项目模板id （project_templates）");
		projectTemplateIdField.setLength(11);
		projectTemplateIdField.setFormat("#,###,###,###,##0.00");
		projectTemplateIdField.setRequired(false);
		projectTemplateIdField.setHidden(true);
		
		
		projectAmountField = new DataSourceIntegerField("projectAmount", "阶段积分");
		projectAmountField.setLength(11);
		projectAmountField.setRequired(false);
		projectAmountField.setHidden(false);


		setFields(projectStageTemplateIdField, stageIdField, stageNameField,percentField  , projectTemplateNameField, projectTemplateIdField,projectAmountField);
	}


}

