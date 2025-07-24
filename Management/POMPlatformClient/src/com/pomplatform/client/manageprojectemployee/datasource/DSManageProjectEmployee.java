package com.pomplatform.client.manageprojectemployee.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSManageProjectEmployee extends DBDataSource {

	public static DSManageProjectEmployee instance = null;

	public static DSManageProjectEmployee getInstance() {
		if (instance == null) {
			instance = new DSManageProjectEmployee("DSManageProjectEmployee");
		}
		return instance;
	}

	private final DataSourceIntegerField manageProjectIdField;
	private final DataSourceTextField employeeIdField;
	private final DataSourceFloatField assignIntegralField;
	private final DataSourceTextField assignedIntegralField;

	public DSManageProjectEmployee(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ManageProjectEmployee");

		manageProjectIdField = new DataSourceIntegerField("manageProjectId", "管理项目");
		manageProjectIdField.setLength(11);
		manageProjectIdField.setRequired(false);
		manageProjectIdField.setHidden(true);
//		manageProjectIdField.setValueMap(KeyValueManager.getValueMap("manage_projects"));
		KeyValueManager.loadValueMap("manage_projects", manageProjectIdField);

		employeeIdField = new DataSourceTextField("employeeId", "发放成员");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setCanEdit(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		assignIntegralField = new DataSourceFloatField("assignIntegral", "发放积分");
		assignIntegralField.setLength(10);
		assignIntegralField.setDecimalPad(2);
		assignIntegralField.setFormat("##,###,##0.00");
		assignIntegralField.setRequired(false);
		assignIntegralField.setHidden(false);

		assignedIntegralField = new DataSourceTextField("assignedIntegral", "已发放积分");
		assignedIntegralField.setCanEdit(false);
		assignedIntegralField.setLength(10);
		assignedIntegralField.setDecimalPad(2);
		assignedIntegralField.setFormat("##,###,##0.00");
		assignedIntegralField.setRequired(false);
		assignedIntegralField.setHidden(false);

		setFields(manageProjectIdField, employeeIdField, assignIntegralField, assignedIntegralField);
	}

}
