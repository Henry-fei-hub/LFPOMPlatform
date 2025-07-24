package com.pomplatform.client.trainingmanagement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDTrainingManagement extends DataSource
{


	public static CDTrainingManagement instance = null;

	public static CDTrainingManagement getInstance() {
		if(instance == null) {
			instance = new CDTrainingManagement("CDTrainingManagement");
		}
		return instance;
	}

	private final DataSourceIntegerField trainingManagementIdField;
	private final DataSourceTextField subjectField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField createPersonIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField courseScoreField;
	private final DataSourceTextField compereField;

	public CDTrainingManagement(String dataSourceID) {

		setID(dataSourceID);
		trainingManagementIdField = new DataSourceIntegerField("trainingManagementId", "主键编码");
		trainingManagementIdField.setRequired(true);
		trainingManagementIdField.setLength(11);
		trainingManagementIdField.setHidden(true);

		subjectField = new DataSourceTextField("subject", "主题");
		subjectField.setRequired(false);
		subjectField.setLength(255);
		subjectField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		createPersonIdField = new DataSourceIntegerField("createPersonId", "创建人编码");
		createPersonIdField.setRequired(false);
		createPersonIdField.setLength(11);
		createPersonIdField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		courseScoreField = new DataSourceIntegerField("courseScore", "课程分数");
		courseScoreField.setRequired(false);
		courseScoreField.setLength(11);
		courseScoreField.setHidden(false);

		compereField = new DataSourceTextField("compere", "主持人");
		compereField.setRequired(false);
		compereField.setLength(32);
		compereField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(trainingManagementIdField, subjectField, createTimeField, departmentIdField, createPersonIdField, employeeIdField, courseScoreField, compereField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

