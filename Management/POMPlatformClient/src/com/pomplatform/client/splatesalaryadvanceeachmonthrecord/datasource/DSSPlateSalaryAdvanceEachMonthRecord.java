package com.pomplatform.client.splatesalaryadvanceeachmonthrecord.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSPlateSalaryAdvanceEachMonthRecord extends DBDataSource
{


	public static DSSPlateSalaryAdvanceEachMonthRecord instance = null;

	public static DSSPlateSalaryAdvanceEachMonthRecord getInstance() {
		if(instance == null) {
			instance = new DSSPlateSalaryAdvanceEachMonthRecord("DSSPlateSalaryAdvanceEachMonthRecord");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField recordYearField;
	private final DataSourceIntegerField recordMonthField;
	private final DataSourceFloatField salaryReturnField;

	public DSSPlateSalaryAdvanceEachMonthRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SPlateSalaryAdvanceEachMonthRecord");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(32);
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


		salaryReturnField = new DataSourceFloatField("salaryReturn", "积分补贴");
		salaryReturnField.setLength(18);
		salaryReturnField.setDecimalPad(2);
		salaryReturnField.setFormat("#,###,###,###,###,##0.00");
		salaryReturnField.setRequired(false);
		salaryReturnField.setHidden(false);


		setFields(plateIdField, recordYearField, recordMonthField, salaryReturnField);
	}


}

