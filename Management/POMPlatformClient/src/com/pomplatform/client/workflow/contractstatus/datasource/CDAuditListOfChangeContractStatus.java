package com.pomplatform.client.workflow.contractstatus.datasource;

import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CDAuditListOfChangeContractStatus extends DataSource
{


	public static CDAuditListOfChangeContractStatus instance = null;

	public static CDAuditListOfChangeContractStatus getInstance() {
		if(instance == null) {
			instance = new CDAuditListOfChangeContractStatus("CDAuditListOfChangeContractStatus");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceTextField contentField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;

	public CDAuditListOfChangeContractStatus(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		operatorField = new DataSourceIntegerField("operator", "发起者");
		operatorField.setRequired(false);
		operatorField.setLength(11);
		operatorField.setHidden(false);
		operatorField.setValueMap(KeyValueManager.getValueMap("employees"));

		contentField = new DataSourceTextField("content", "原因");
		contentField.setRequired(false);
		contentField.setLength(1024);
		contentField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

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


		setFields(employeeIdField, statusField, processTypeField, operatorField, contentField, contractCodeField, contractNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

