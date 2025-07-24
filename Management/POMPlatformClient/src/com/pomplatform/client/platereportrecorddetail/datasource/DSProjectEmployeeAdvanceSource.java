package com.pomplatform.client.platereportrecorddetail.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProjectEmployeeAdvanceSource extends DBDataSource {

	public static DSProjectEmployeeAdvanceSource instance = null;

	public static DSProjectEmployeeAdvanceSource getInstance() {
		if (instance == null) {
			instance = new DSProjectEmployeeAdvanceSource("DSAchieveIntegralSource");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceFloatField advanceIntegralField;
	private final DataSourceTextField advancedIntegralField;

	public DSProjectEmployeeAdvanceSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("OnGetProjectEmployeeAdvanceRecord");

		employeeIdField = new DataSourceIntegerField("employeeId", "补贴人员");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setCanEdit(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		advanceIntegralField = new DataSourceFloatField("advanceIntegral", "补贴积分");
		advanceIntegralField.setLength(18);
		advanceIntegralField.setDecimalPad(2);
		advanceIntegralField.setFormat("#,###,###,###,###,##0.00");
		advanceIntegralField.setRequired(false);
		advanceIntegralField.setCanEdit(true);
		advanceIntegralField.setHidden(false);

		advancedIntegralField = new DataSourceTextField("advancedIntegral", "已补贴积分");
		advancedIntegralField.setLength(18);
		advancedIntegralField.setCanEdit(false);

		setFields(employeeIdField, advanceIntegralField, advancedIntegralField);
	}

}
