package com.pomplatform.client.projectteambuild.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;

public class DSProjectEmployeePlanIntegralProgress extends DBDataSource
{


	public static DSProjectEmployeePlanIntegralProgress instance = null;

	public static DSProjectEmployeePlanIntegralProgress getInstance() {
		if(instance == null) {
			instance = new DSProjectEmployeePlanIntegralProgress("DSProjectEmployeePlanIntegralProgress");
		}
		return instance;
	}

	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceFloatField planIntegralField;
	private final DataSourceFloatField realIntegralField;
	private final DataSourceTextField alternateField1Field;
	private final DataSourceTextField alternateField2Field;

	public DSProjectEmployeePlanIntegralProgress(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProjectEmployeePlanIntegralProgress");


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(true);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "职员名称");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		stageIdField = new DataSourceIntegerField("stageId", "阶段");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(false);
		stageIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

		planIntegralField = new DataSourceFloatField("planIntegral", "预分配积分");
		planIntegralField.setLength(0);
		planIntegralField.setDecimalPad(0);
		planIntegralField.setFormat("");
		planIntegralField.setRequired(false);
		planIntegralField.setHidden(false);

		realIntegralField = new DataSourceFloatField("realIntegral", "实际获得积分");
		realIntegralField.setLength(0);
		realIntegralField.setDecimalPad(0);
		realIntegralField.setFormat("");
		realIntegralField.setRequired(false);
		realIntegralField.setHidden(true);

		alternateField1Field = new DataSourceTextField("alternateField1", "上一次预分配积分");
		alternateField1Field.setLength(512);
		alternateField1Field.setRequired(false);
		alternateField1Field.setHidden(false);


		alternateField2Field = new DataSourceTextField("alternateField2", "状态");
		alternateField2Field.setLength(512);
		alternateField2Field.setRequired(false);
		alternateField2Field.setHidden(false);
		Map<String, String> map =new HashMap<>();
		map.put("1", "待审批");
		map.put("2", "同意");
		map.put("3", "不同意");
		alternateField2Field.setValueMap(map);

		setFields(projectCodeField, contractCodeField, projectNameField, employeeIdField, stageIdField, planIntegralField, alternateField1Field, realIntegralField, alternateField2Field);
	}


}

