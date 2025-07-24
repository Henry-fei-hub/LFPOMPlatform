package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadEmployeeAccountByBusinessTypeData extends DBDataSource
{


	public static DSOnLoadEmployeeAccountByBusinessTypeData instance = null;

	public static DSOnLoadEmployeeAccountByBusinessTypeData getInstance() {
		if(instance == null) {
			instance = new DSOnLoadEmployeeAccountByBusinessTypeData("DSOnLoadEmployeeAccountByBusinessTypeData");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField dutyIdField;
	private final DataSourceIntegerField genderField;
	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceFloatField accountIntegralField;

	public DSOnLoadEmployeeAccountByBusinessTypeData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadEmployeeAccountByBusinessTypeData");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(true);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);
		employeeNameField.setValueMap(new java.util.HashMap());


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		dutyIdField = new DataSourceIntegerField("dutyId", "职位名称");
		dutyIdField.setLength(11);
		dutyIdField.setRequired(false);
		dutyIdField.setHidden(false);
		dutyIdField.setValueMap(KeyValueManager.getValueMap("duties"));


		genderField = new DataSourceIntegerField("gender", "性别");
		genderField.setLength(11);
		genderField.setRequired(false);
		genderField.setHidden(false);
		genderField.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));


		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "10绩效奖金)");
		businessTypeIdField.setLength(11);
		businessTypeIdField.setRequired(false);
		businessTypeIdField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "父代码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);


		accountIntegralField = new DataSourceFloatField("accountIntegral", "产值结算金额");
		accountIntegralField.setLength(18);
		accountIntegralField.setDecimalPad(2);
		accountIntegralField.setFormat("#,###,###,###,###,##0.00");
		accountIntegralField.setRequired(true);
		accountIntegralField.setHidden(false);


		setFields(employeeIdField, employeeNoField, employeeNameField, plateIdField, dutyIdField, genderField, businessTypeIdField, parentIdField, accountIntegralField);
	}


}

