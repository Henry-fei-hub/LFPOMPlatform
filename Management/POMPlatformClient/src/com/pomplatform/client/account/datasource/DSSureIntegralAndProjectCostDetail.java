package com.pomplatform.client.account.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSureIntegralAndProjectCostDetail extends DBDataSource
{


	public static DSSureIntegralAndProjectCostDetail instance = null;

	public static DSSureIntegralAndProjectCostDetail getInstance() {
		if(instance == null) {
			instance = new DSSureIntegralAndProjectCostDetail("DSSureIntegralAndProjectCostDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField sheetNameField;
	private final DataSourceFloatField integralField;
	private final DataSourceIntegerField projectFlagField;
	private final DataSourceDateField recordDateField;

	public DSSureIntegralAndProjectCostDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SureIntegralAndProjectCostDetail");


		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setLength(64);
		sheetCodeField.setRequired(true);
		sheetCodeField.setHidden(false);
		//KeyValueManager.loadValueMap("contracts", sheetCodeField);


		sheetNameField = new DataSourceTextField("sheetName", "订单名称");
		sheetNameField.setLength(512);
		sheetNameField.setRequired(true);
		sheetNameField.setHidden(false);


		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);
		
		projectFlagField = new DataSourceIntegerField("projectFlag", "项目标示类型");
		projectFlagField.setLength(11);
		projectFlagField.setRequired(false);
		projectFlagField.setValueMap(KeyValueManager.getValueMap("system_dictionary_71"));

		recordDateField = new DataSourceDateField("recordDate" , "时间");
		recordDateField.setLength(64);

		setFields(employeeIdField, employeeNoField, employeeNameField,projectFlagField,recordDateField, sheetCodeField, sheetNameField, integralField);
	}


}

