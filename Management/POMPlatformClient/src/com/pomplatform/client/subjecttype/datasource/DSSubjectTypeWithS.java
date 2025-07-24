package com.pomplatform.client.subjecttype.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSubjectTypeWithS extends DBDataSource
{


	public static DSSubjectTypeWithS instance = null;

	public static DSSubjectTypeWithS getInstance() {
		if(instance == null) {
			instance = new DSSubjectTypeWithS("DSSubjectTypeWithS");
		}
		return instance;
	}

	private final DataSourceIntegerField subjectTypeIdField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceTextField subjectNameField;
	private final DataSourceBooleanField isEnabledField;
	private final DataSourceField detailSubjectDepartment;

	public DSSubjectTypeWithS(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("SubjectTypeWithS");


		subjectTypeIdField = new DataSourceIntegerField("subjectTypeId", "主键编码");
		subjectTypeIdField.setLength(11);
		subjectTypeIdField.setPrimaryKey(true);
		subjectTypeIdField.setRequired(true);
		subjectTypeIdField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setForeignKey(dataSourceID+".subjectTypeId");
		parentIdField.setRootValue("0");
		parentIdField.setHidden(false);


		subjectNameField = new DataSourceTextField("subjectName", "科目名称");
		subjectNameField.setLength(64);
		subjectNameField.setRequired(false);
		subjectNameField.setHidden(false);


		isEnabledField = new DataSourceBooleanField("isEnabled", "是否启用");
		isEnabledField.setRequired(false);
		isEnabledField.setHidden(false);

		detailSubjectDepartment = new DataSourceField("detailSubjectDepartment", FieldType.ANY);
		detailSubjectDepartment.setChildrenProperty(true);
		detailSubjectDepartment.setChildTagName("SubjectDepartment");
		detailSubjectDepartment.setRequired(false);
		detailSubjectDepartment.setHidden(true);

		setFields(subjectTypeIdField, parentIdField, subjectNameField, isEnabledField, detailSubjectDepartment);
	}


}

