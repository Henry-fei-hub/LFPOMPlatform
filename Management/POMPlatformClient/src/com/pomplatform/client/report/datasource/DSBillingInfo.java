package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSBillingInfo extends DBDataSource
{


	public static DSBillingInfo instance = null;

	public static DSBillingInfo getInstance() {
		if(instance == null) {
			instance = new DSBillingInfo("DSBillingInfo");
		}
		return instance;
	}

	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField drafterField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField subTypeField;
	private final DataSourceDateTimeField createTimeField;

	public DSBillingInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BillingInfo");


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		drafterField = new DataSourceIntegerField("drafter", "结算申请人");
		drafterField.setLength(11);
		drafterField.setRequired(false);
		drafterField.setHidden(false);
		drafterField.setValueMap(KeyValueManager.getValueMap("employees"));


		departmentIdField = new DataSourceIntegerField("departmentId", "配合部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		subTypeField = new DataSourceTextField("subType", "结算产值");
		subTypeField.setLength(255);
		subTypeField.setRequired(false);
		subTypeField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "提交时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		setFields(projectCodeField, projectNameField, drafterField, departmentIdField, subTypeField, createTimeField);
	}


}

