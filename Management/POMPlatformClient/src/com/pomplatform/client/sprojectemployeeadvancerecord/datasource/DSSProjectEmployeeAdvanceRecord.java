package com.pomplatform.client.sprojectemployeeadvancerecord.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSProjectEmployeeAdvanceRecord extends DBDataSource {

	public static DSSProjectEmployeeAdvanceRecord instance = null;

	public static DSSProjectEmployeeAdvanceRecord getInstance() {
		if (instance == null) {
			instance = new DSSProjectEmployeeAdvanceRecord("DSSProjectEmployeeAdvanceRecord");
		}
		return instance;
	}

	private final DataSourceTextField employeeIdField;
	private final DataSourceIntegerField advanceYearField;
	private final DataSourceIntegerField advanceMonthField;
	private final DataSourceFloatField advanceIntegralField;

	public DSSProjectEmployeeAdvanceRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SProjectEmployeeAdvanceRecord");

		employeeIdField = new DataSourceTextField("employeeId", "员工姓名");
		employeeIdField.setLength(32);
		employeeIdField.setDecimalPad(0);
		employeeIdField.setFormat("##,###,###,###,###,###,###,###,###,###,##0");
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		advanceYearField = new DataSourceIntegerField("advanceYear", "年份");
		advanceYearField.setLength(11);
		advanceYearField.setRequired(true);
		advanceYearField.setHidden(false);

		advanceMonthField = new DataSourceIntegerField("advanceMonth", "月份");
		advanceMonthField.setLength(11);
		advanceMonthField.setRequired(true);
		advanceMonthField.setHidden(false);

		advanceIntegralField = new DataSourceFloatField("advanceIntegral", "补贴积分");
		advanceIntegralField.setLength(10);
		advanceIntegralField.setDecimalPad(2);
		advanceIntegralField.setFormat("##,###,##0.00");
		advanceIntegralField.setRequired(false);
		advanceIntegralField.setHidden(false);

		setFields(employeeIdField, advanceYearField, advanceMonthField, advanceIntegralField);
	}

}
