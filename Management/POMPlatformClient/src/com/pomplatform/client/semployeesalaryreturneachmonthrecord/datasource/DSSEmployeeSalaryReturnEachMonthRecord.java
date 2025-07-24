package com.pomplatform.client.semployeesalaryreturneachmonthrecord.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSEmployeeSalaryReturnEachMonthRecord extends DBDataSource
{


	public static DSSEmployeeSalaryReturnEachMonthRecord instance = null;

	public static DSSEmployeeSalaryReturnEachMonthRecord getInstance() {
		if(instance == null) {
			instance = new DSSEmployeeSalaryReturnEachMonthRecord("DSSEmployeeSalaryReturnEachMonthRecord");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField recordYearField;
	private final DataSourceIntegerField recordMonthField;
	private final DataSourceFloatField salaryReturnField;

	public DSSEmployeeSalaryReturnEachMonthRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SEmployeeSalaryReturnEachMonthRecord");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		recordYearField = new DataSourceIntegerField("recordYear", "年份");
		recordYearField.setLength(11);
		recordYearField.setRequired(true);
		recordYearField.setHidden(false);


		recordMonthField = new DataSourceIntegerField("recordMonth", "月份");
		recordMonthField.setLength(11);
		recordMonthField.setRequired(true);
		recordMonthField.setHidden(false);


		salaryReturnField = new DataSourceFloatField("salaryReturn", "积分回流");
		salaryReturnField.setLength(18);
		salaryReturnField.setDecimalPad(2);
		salaryReturnField.setFormat("#,###,###,###,###,##0.00");
		salaryReturnField.setRequired(false);
		salaryReturnField.setHidden(false);


		setFields(plateIdField, recordYearField, recordMonthField, salaryReturnField);
	}


}

