package com.pomplatform.client.employeedetail.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProjectCostDetail extends DBDataSource
{


	public static DSProjectCostDetail instance = null;

	public static DSProjectCostDetail getInstance() {
		if(instance == null) {
			instance = new DSProjectCostDetail("DSProjectCostDetail");
		}
		return instance;
	}

	private final DataSourceTextField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceFloatField projectCostField;
	private final DataSourceTextField projectIdField;

	public DSProjectCostDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProjectCostDetail");


		employeeIdField = new DataSourceTextField("employeeId", "姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(11);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		projectCostField = new DataSourceFloatField("projectCost", "分摊费用");
		projectCostField.setLength(18);
		projectCostField.setDecimalPad(2);
		projectCostField.setFormat("#,###,###,###,###,##0.00");
		projectCostField.setRequired(false);
		projectCostField.setHidden(false);


		projectIdField = new DataSourceTextField("projectId", "项目");
		projectIdField.setLength(12);
		projectIdField.setRequired(true);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects",projectIdField);


		setFields(employeeIdField, employeeNoField, projectCostField, projectIdField);
	}


}

