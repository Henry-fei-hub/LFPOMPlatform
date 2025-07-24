package com.pomplatform.client.employeereportrecorddetail.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSEmployeeViolationChargesMonthly extends DBDataSource
{


	public static DSEmployeeViolationChargesMonthly instance = null;

	public static DSEmployeeViolationChargesMonthly getInstance() {
		if(instance == null) {
			instance = new DSEmployeeViolationChargesMonthly("DSEmployeeViolationChargesMonthly");
		}
		return instance;
	}

	private final DataSourceTextField violationYearField;
	private final DataSourceIntegerField violationMonthField;
	private final DataSourceFloatField violationChargesField;

	public DSEmployeeViolationChargesMonthly(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeViolationChargesMonthly");


		violationYearField = new DataSourceTextField("violationYear", "年份");
		violationYearField.setLength(11);
		violationYearField.setRequired(true);
		violationYearField.setHidden(false);


		violationMonthField = new DataSourceIntegerField("violationMonth", "月份");
		violationMonthField.setLength(11);
		violationMonthField.setRequired(true);
		violationMonthField.setHidden(false);


		violationChargesField = new DataSourceFloatField("violationCharges", "项目违规金");
		violationChargesField.setLength(18);
		violationChargesField.setDecimalPad(5);
		violationChargesField.setFormat("#,###,###,###,##0.00");
		violationChargesField.setRequired(false);
		violationChargesField.setHidden(false);


		setFields(violationYearField, violationMonthField, violationChargesField);
	}


}

