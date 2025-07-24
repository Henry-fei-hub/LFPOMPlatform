package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadProjectEmpAndStage extends DBDataSource
{


	public static DSOnLoadProjectEmpAndStage instance = null;

	public static DSOnLoadProjectEmpAndStage getInstance() {
		if(instance == null) {
			instance = new DSOnLoadProjectEmpAndStage("DSOnLoadProjectEmpAndStage");
		}
		return instance;
	}

	private final DataSourceIntegerField projectEmployeeIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceFloatField sureIntegralField;
	private final DataSourceIntegerField gradeIdField;
	private final DataSourceFloatField planIntegralField;
	private final DataSourceTextField alternateField1Field;
	private final DataSourceTextField alternateField2Field;
	private final DataSourceIntegerField statusField;

	public DSOnLoadProjectEmpAndStage(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadProjectEmpAndStage");


		projectEmployeeIdField = new DataSourceIntegerField("projectEmployeeId", "项目组建编码");
		projectEmployeeIdField.setLength(11);
		projectEmployeeIdField.setPrimaryKey(true);
		projectEmployeeIdField.setRequired(true);
		projectEmployeeIdField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目代码");
		projectIdField.setLength(11);
		projectIdField.setRequired(true);
		projectIdField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "结算操作人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		stageIdField = new DataSourceIntegerField("stageId", "项目阶段");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(false);


		sureIntegralField = new DataSourceFloatField("sureIntegral", "");
		sureIntegralField.setLength(18);
		sureIntegralField.setDecimalPad(2);
		sureIntegralField.setFormat("#,###,###,###,###,##0.00");
		sureIntegralField.setRequired(true);
		sureIntegralField.setHidden(false);


		gradeIdField = new DataSourceIntegerField("gradeId", "等级");
		gradeIdField.setLength(11);
		gradeIdField.setRequired(false);
		gradeIdField.setHidden(false);


		planIntegralField = new DataSourceFloatField("planIntegral", "预分配积分");
		planIntegralField.setLength(0);
		planIntegralField.setDecimalPad(0);
		planIntegralField.setFormat("");
		planIntegralField.setRequired(false);
		planIntegralField.setHidden(false);


		alternateField1Field = new DataSourceTextField("alternateField1", "上一次预分配积分");
		alternateField1Field.setLength(512);
		alternateField1Field.setRequired(false);
		alternateField1Field.setHidden(false);


		alternateField2Field = new DataSourceTextField("alternateField2", "//状态值  1待审批    2同意  3不同意");
		alternateField2Field.setLength(512);
		alternateField2Field.setRequired(false);
		alternateField2Field.setHidden(false);


		statusField = new DataSourceIntegerField("status", "结算状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);


		setFields(projectEmployeeIdField, projectIdField, employeeIdField, employeeNoField, employeeNameField, stageIdField, sureIntegralField, gradeIdField, planIntegralField, alternateField1Field, alternateField2Field, statusField);
	}


}

