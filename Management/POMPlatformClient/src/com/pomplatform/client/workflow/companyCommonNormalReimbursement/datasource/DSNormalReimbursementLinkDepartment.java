package com.pomplatform.client.workflow.companyCommonNormalReimbursement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSNormalReimbursementLinkDepartment extends DBDataSource
{


	public static DSNormalReimbursementLinkDepartment instance = null;

	public static DSNormalReimbursementLinkDepartment getInstance() {
		if(instance == null) {
			instance = new DSNormalReimbursementLinkDepartment("DSNormalReimbursementLinkDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField normalReimbursementLinkDepartmentIdField;
	private final DataSourceIntegerField projectNormalReimbursementIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceFloatField amountField;

	public DSNormalReimbursementLinkDepartment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("NormalReimbursementLinkDepartment");


		normalReimbursementLinkDepartmentIdField = new DataSourceIntegerField("normalReimbursementLinkDepartmentId", "主键编码");
		normalReimbursementLinkDepartmentIdField.setLength(11);
		normalReimbursementLinkDepartmentIdField.setPrimaryKey(true);
		normalReimbursementLinkDepartmentIdField.setRequired(true);
		normalReimbursementLinkDepartmentIdField.setHidden(true);


		projectNormalReimbursementIdField = new DataSourceIntegerField("projectNormalReimbursementId", "日常报销编码");
		projectNormalReimbursementIdField.setLength(11);
		projectNormalReimbursementIdField.setRequired(false);
		projectNormalReimbursementIdField.setHidden(true);


		departmentIdField = new DataSourceTextField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		amountField = new DataSourceFloatField("amount", "费用");
		amountField.setLength(18);
		amountField.setDecimalPad(5);
		amountField.setFormat("#,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		setFields(normalReimbursementLinkDepartmentIdField, projectNormalReimbursementIdField, departmentIdField, amountField);
	}


}

