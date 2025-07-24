package com.pomplatform.client.projectprogress.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectprogrespppor extends DBDataSource
{


	public static DSSprojectprogrespppor instance = null;

	public static DSSprojectprogrespppor getInstance() {
		if(instance == null) {
			instance = new DSSprojectprogrespppor("DSSprojectprogrespppor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectProgressIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceIntegerField designPhaseField;
	private final DataSourceDateField finishDateField;
	private final DataSourceTextField alternateField1Field;
	private final DataSourceTextField alternateField2Field;
	private final DataSourceTextField alternateField3Field;
	private final DataSourceIntegerField statusField;

	public DSSprojectprogrespppor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sprojectprogrespppor");


		projectProgressIdField = new DataSourceIntegerField("projectProgressId", "项目进度编码");
		projectProgressIdField.setLength(11);
		projectProgressIdField.setPrimaryKey(true);
		projectProgressIdField.setRequired(true);
		projectProgressIdField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);


		projectManageIdField = new DataSourceIntegerField("projectManageId", "项目负责人编码");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);


		designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
		designPhaseField.setLength(11);
		designPhaseField.setRequired(false);
		designPhaseField.setHidden(false);


		finishDateField = new DataSourceDateField("finishDate", "完成日期");
		finishDateField.setRequired(false);
		finishDateField.setHidden(false);


		alternateField1Field = new DataSourceTextField("alternateField1", "备用字段1");
		alternateField1Field.setLength(512);
		alternateField1Field.setRequired(false);
		alternateField1Field.setHidden(false);


		alternateField2Field = new DataSourceTextField("alternateField2", "备用字段2");
		alternateField2Field.setLength(512);
		alternateField2Field.setRequired(false);
		alternateField2Field.setHidden(false);


		alternateField3Field = new DataSourceTextField("alternateField3", "备用字段3");
		alternateField3Field.setLength(512);
		alternateField3Field.setRequired(false);
		alternateField3Field.setHidden(false);


		statusField = new DataSourceIntegerField("status", "status");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);


		setFields(projectProgressIdField, projectIdField, projectManageIdField, designPhaseField, finishDateField, alternateField1Field, alternateField2Field, alternateField3Field, statusField);
	}


}

