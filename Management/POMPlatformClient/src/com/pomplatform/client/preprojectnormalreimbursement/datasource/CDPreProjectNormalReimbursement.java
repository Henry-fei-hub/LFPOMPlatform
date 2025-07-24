package com.pomplatform.client.preprojectnormalreimbursement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPreProjectNormalReimbursement extends DataSource
{


	public static CDPreProjectNormalReimbursement instance = null;

	public static CDPreProjectNormalReimbursement getInstance() {
		if(instance == null) {
			instance = new CDPreProjectNormalReimbursement("CDPreProjectNormalReimbursement");
		}
		return instance;
	}

	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField reimbursementNameField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField amountField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField codeField;

	public CDPreProjectNormalReimbursement(String dataSourceID) {

		setID(dataSourceID);
		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程编码");
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setLength(11);
		processInstanceIdField.setHidden(false);
		processInstanceIdField.setValueMap(new java.util.HashMap());

		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "起草人");
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "报销人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		departmentIdField = new DataSourceIntegerField("departmentId", "报销部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(new java.util.HashMap());

		reimbursementNameField = new DataSourceTextField("reimbursementName", "主题");
		reimbursementNameField.setRequired(false);
		reimbursementNameField.setLength(256);
		reimbursementNameField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		amountField = new DataSourceFloatField("amount", "报销总金额");
		amountField.setRequired(true);
		amountField.setLength(18);
		amountField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(512);
		remarkField.setHidden(false);

		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

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


		setFields(processInstanceIdField, applyEmployeeIdField, employeeIdField, departmentIdField, reimbursementNameField, statusField, amountField, remarkField, codeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

