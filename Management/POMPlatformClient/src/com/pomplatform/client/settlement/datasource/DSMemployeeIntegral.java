package com.pomplatform.client.settlement.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMemployeeIntegral extends DBDataSource {

	public static DSMemployeeIntegral instance = null;

	public static DSMemployeeIntegral getInstance() {
		if (instance == null) {
			instance = new DSMemployeeIntegral("DSMprojectemployeeppor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectEmployeeIdField;
	private final DataSourceTextField employeeIdField;
	private final DataSourceFloatField assignIntegralField;

	public DSMemployeeIntegral(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mprojectemployeeppor");

		projectEmployeeIdField = new DataSourceIntegerField("projectEmployeeId", "项目组建编码");
		projectEmployeeIdField.setLength(11);
		projectEmployeeIdField.setPrimaryKey(true);
		projectEmployeeIdField.setRequired(true);
		projectEmployeeIdField.setHidden(true);

		employeeIdField = new DataSourceTextField("employeeId", "职员名称");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setCanEdit(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		assignIntegralField = new DataSourceFloatField("realIntegral", "发放积分");
		assignIntegralField.setLength(10);
		assignIntegralField.setDecimalPad(2);
		assignIntegralField.setFormat("##,###,##0.00");
		assignIntegralField.setRequired(true);
		assignIntegralField.setHidden(false);
		assignIntegralField.setCanEdit(true);
                
		setFields(projectEmployeeIdField, employeeIdField, assignIntegralField);
	}

}
