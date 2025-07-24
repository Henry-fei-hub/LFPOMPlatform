package com.pomplatform.client.employeedetail.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSManagerProjectIntegralDetail extends DBDataSource
{


	public static DSManagerProjectIntegralDetail instance = null;

	public static DSManagerProjectIntegralDetail getInstance() {
		if(instance == null) {
			instance = new DSManagerProjectIntegralDetail("DSManagerProjectIntegralDetail");
		}
		return instance;
	}

	private final DataSourceTextField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceFloatField assignedIntegralField;
	private final DataSourceTextField manageProjectIdField;

	public DSManagerProjectIntegralDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ManagerProjectIntegralDetail");


		employeeIdField = new DataSourceTextField("employeeId", "姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(11);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		assignedIntegralField = new DataSourceFloatField("assignedIntegral", "已发放积分");
		assignedIntegralField.setLength(10);
		assignedIntegralField.setDecimalPad(2);
		assignedIntegralField.setFormat("##,###,##0.00");
		assignedIntegralField.setRequired(false);
		assignedIntegralField.setHidden(false);


		manageProjectIdField = new DataSourceTextField("manageProjectId", "管理项目");
		manageProjectIdField.setLength(12);
		manageProjectIdField.setRequired(false);
		manageProjectIdField.setHidden(false);
//		manageProjectIdField.setValueMap(KeyValueManager.getValueMap("manage_projects"));
		KeyValueManager.loadValueMap("manage_projects", manageProjectIdField);

		setFields(employeeIdField, employeeNoField, assignedIntegralField, manageProjectIdField);
	}


}

