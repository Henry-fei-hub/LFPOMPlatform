package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSAllOtherDetail extends DBDataSource
{


	public static DSAllOtherDetail instance = null;

	public static DSAllOtherDetail getInstance() {
		if(instance == null) {
			instance = new DSAllOtherDetail("DSAllOtherDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceFloatField integralField;
	private final DataSourceTextField operateEmployeeIdField;
	private final DataSourceDateField recordDateField;
	private final DataSourceTextField remarkField;

	public DSAllOtherDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AllOtherDetail");


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


		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);
		
		operateEmployeeIdField = new DataSourceTextField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(64);
		operateEmployeeIdField.setRequired(true);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		
		recordDateField = new DataSourceDateField("recordDate", "操作日期");
		recordDateField.setLength(64);
		recordDateField.setRequired(true);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(employeeIdField, employeeNoField, employeeNameField, integralField,operateEmployeeIdField,recordDateField, remarkField);
	}


}

