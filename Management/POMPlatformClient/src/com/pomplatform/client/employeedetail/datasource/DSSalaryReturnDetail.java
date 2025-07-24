package com.pomplatform.client.employeedetail.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSalaryReturnDetail extends DBDataSource
{


	public static DSSalaryReturnDetail instance = null;

	public static DSSalaryReturnDetail getInstance() {
		if(instance == null) {
			instance = new DSSalaryReturnDetail("DSSalaryReturnDetail");
		}
		return instance;
	}

	private final DataSourceTextField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceFloatField salaryReturnField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateField recordDateField;

	public DSSalaryReturnDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SalaryReturnDetail");


		employeeIdField = new DataSourceTextField("employeeId", "员工");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(11);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		salaryReturnField = new DataSourceFloatField("salaryReturn", "积分回流");
		salaryReturnField.setLength(18);
		salaryReturnField.setDecimalPad(2);
		salaryReturnField.setFormat("#,###,###,###,###,##0.00");
		salaryReturnField.setRequired(false);
		salaryReturnField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		
		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		setFields(employeeIdField, employeeNoField, salaryReturnField, plateIdField, recordDateField);
	}


}

