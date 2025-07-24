package com.pomplatform.client.projectStageTemplate.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectstagetemplateor extends DBDataSource
{


	public static DSSprojectstagetemplateor instance = null;

	public static DSSprojectstagetemplateor getInstance() {
		if(instance == null) {
			instance = new DSSprojectstagetemplateor("DSSprojectstagetemplateor");
		}
		return instance;
	}
	

	private final DataSourceIntegerField projectStageTemplateIdField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceIntegerField percentField;
	private final DataSourceTextField stageNameField;
	private final DataSourceTextField projectTemplateNameField;
	private final DataSourceIntegerField projectTemplateIdField;
	private final DataSourceFloatField projectAmountField;

	public DSSprojectstagetemplateor(String dataSourceID) {
		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sprojectstagetemplateor");

			projectStageTemplateIdField = new DataSourceIntegerField("projectStageTemplateId", "项目阶段代码");
			projectStageTemplateIdField.setLength(11);
			projectStageTemplateIdField.setPrimaryKey(true);
			projectStageTemplateIdField.setRequired(true);
			projectStageTemplateIdField.setHidden(true);


			stageIdField = new DataSourceIntegerField("stageId", "阶段代码");
			stageIdField.setLength(11);
			stageIdField.setRequired(false);
			stageIdField.setHidden(false);


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
			projectTemplateIdField.setRequired(false);
			projectTemplateIdField.setHidden(true);


			projectAmountField = new DataSourceFloatField("projectAmount", "项目积分");
			projectAmountField.setLength(18);
			projectAmountField.setDecimalPad(2);
			projectAmountField.setFormat("#,###,###,###,##0.00");
			projectAmountField.setRequired(false);
			projectAmountField.setHidden(true);
			
			setFields(projectStageTemplateIdField, stageIdField,stageNameField, percentField,  projectTemplateNameField, projectTemplateIdField, projectAmountField);

		}
		
		



}

