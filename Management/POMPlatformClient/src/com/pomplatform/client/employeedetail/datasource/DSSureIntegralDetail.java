package com.pomplatform.client.employeedetail.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSureIntegralDetail extends DBDataSource
{


	public static DSSureIntegralDetail instance = null;

	public static DSSureIntegralDetail getInstance() {
		if(instance == null) {
			instance = new DSSureIntegralDetail("DSSureIntegralDetail");
		}
		return instance;
	}

	private final DataSourceTextField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceFloatField realAmountField;
	private final DataSourceTextField projectIdField;

	public DSSureIntegralDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SureIntegralDetail");


		employeeIdField = new DataSourceTextField("employeeId", "人员");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		realAmountField = new DataSourceFloatField("realAmount", "确认积分");
		realAmountField.setLength(18);
		realAmountField.setDecimalPad(2);
		realAmountField.setFormat("#,###,###,###,###,##0.00");
		realAmountField.setRequired(false);
		realAmountField.setHidden(false);


		projectIdField = new DataSourceTextField("projectId", "项目");
		projectIdField.setLength(65);
		projectIdField.setRequired(true);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects",projectIdField);

		setFields(employeeIdField, employeeNoField, projectIdField, realAmountField);
	}


}

