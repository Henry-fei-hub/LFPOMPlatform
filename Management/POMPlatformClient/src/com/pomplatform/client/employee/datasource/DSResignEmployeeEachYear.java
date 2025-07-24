package com.pomplatform.client.employee.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class DSResignEmployeeEachYear extends DBDataSource
{


	public static DSResignEmployeeEachYear instance = null;

	public static DSResignEmployeeEachYear getInstance() {
		if(instance == null) {
			instance = new DSResignEmployeeEachYear("DSResignEmployeeEachYear");
		}
		return instance;
	}

	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField amountField;

	public DSResignEmployeeEachYear(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ResignEmployeeEachYear");


		parentIdField = new DataSourceIntegerField("parentId", "业务部门");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(false);
		parentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(true);
		yearField.setHidden(false);


		amountField = new DataSourceIntegerField("amount", "离职人数");
		amountField.setLength(8);
		amountField.setRequired(true);
		amountField.setHidden(false);


		setFields(parentIdField, yearField, amountField);
	}


}

