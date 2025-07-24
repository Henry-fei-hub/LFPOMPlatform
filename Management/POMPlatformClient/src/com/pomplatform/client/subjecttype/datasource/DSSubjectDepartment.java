package com.pomplatform.client.subjecttype.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSubjectDepartment extends DBDataSource
{


	public static DSSubjectDepartment instance = null;

	public static DSSubjectDepartment getInstance() {
		if(instance == null) {
			instance = new DSSubjectDepartment("DSSubjectDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField subjectDepartmentIdField;
	private final DataSourceIntegerField subjectTypeIdField;
	private final DataSourceIntegerField departmentIdField;

	public DSSubjectDepartment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("SubjectDepartment");


		subjectDepartmentIdField = new DataSourceIntegerField("subjectDepartmentId", "主键编码");
		subjectDepartmentIdField.setLength(11);
		subjectDepartmentIdField.setPrimaryKey(true);
		subjectDepartmentIdField.setRequired(true);
		subjectDepartmentIdField.setHidden(false);


		subjectTypeIdField = new DataSourceIntegerField("subjectTypeId", "科目编码");
		subjectTypeIdField.setLength(11);
		subjectTypeIdField.setRequired(false);
		subjectTypeIdField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		setFields(subjectDepartmentIdField, subjectTypeIdField, departmentIdField);
	}


}

