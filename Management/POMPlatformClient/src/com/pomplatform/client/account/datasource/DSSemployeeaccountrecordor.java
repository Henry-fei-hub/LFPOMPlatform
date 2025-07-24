package com.pomplatform.client.account.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSemployeeaccountrecordor extends DBDataSource
{


	public static DSSemployeeaccountrecordor instance = null;

	public static DSSemployeeaccountrecordor getInstance() {
		if(instance == null) {
			instance = new DSSemployeeaccountrecordor("DSSemployeeaccountrecordor");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateField recordDateField;
	private final DataSourceIntegerField businessTypeIdField;

	public DSSemployeeaccountrecordor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Semployeeaccountrecordor");


		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "10绩效奖金)");
		businessTypeIdField.setLength(11);
		businessTypeIdField.setRequired(false);
		businessTypeIdField.setHidden(false);


		setFields(employeeIdField, plateIdField, recordDateField, businessTypeIdField);
	}


}

