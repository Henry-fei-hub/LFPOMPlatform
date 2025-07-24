package com.pomplatform.client.ssubcontractsspor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSsubcontractsspor extends DataSource
{


	public static CDSsubcontractsspor instance = null;

	public static CDSsubcontractsspor getInstance() {
		if(instance == null) {
			instance = new CDSsubcontractsspor("CDSsubcontractsspor");
		}
		return instance;
	}

	private final DataSourceIntegerField subContractIdField;
	private final DataSourceTextField subContractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField subContractNameField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField departmentIdField;

	public CDSsubcontractsspor(String dataSourceID) {

		setID(dataSourceID);
		subContractIdField = new DataSourceIntegerField("subContractId", "子合同编码");
		subContractIdField.setRequired(true);
		subContractIdField.setLength(11);
		subContractIdField.setPrimaryKey(true);
		subContractIdField.setHidden(true);

		subContractCodeField = new DataSourceTextField("subContractCode", "子合同编号");
		subContractCodeField.setRequired(false);
		subContractCodeField.setLength(64);
		subContractCodeField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		subContractNameField = new DataSourceTextField("subContractName", "子合同名称  充当了区域");
		subContractNameField.setRequired(false);
		subContractNameField.setLength(64);
		subContractNameField.setHidden(false);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setRequired(false);
		infoCodeField.setLength(32);
		infoCodeField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(512);
		remarkField.setHidden(false);

		parentIdField = new DataSourceIntegerField("parentId", "主合同编码");
		parentIdField.setRequired(false);
		parentIdField.setLength(11);
		parentIdField.setHidden(false);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdField);

		businessTypeField = new DataSourceIntegerField("businessType", "业务类型");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(11);
		businessTypeField.setHidden(false);

		projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
		projectTypeField.setRequired(false);
		projectTypeField.setLength(11);
		projectTypeField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "承接部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

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


		setFields(subContractIdField, subContractCodeField, projectCodeField, subContractNameField, infoCodeField, remarkField, parentIdField, businessTypeField, projectTypeField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

