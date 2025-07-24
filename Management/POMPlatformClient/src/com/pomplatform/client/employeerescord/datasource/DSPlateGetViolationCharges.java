package com.pomplatform.client.employeerescord.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPlateGetViolationCharges extends DBDataSource {

	public static DSPlateGetViolationCharges instance = null;

	public static DSPlateGetViolationCharges getInstance() {
		if (instance == null) {
			instance = new DSPlateGetViolationCharges("DSPlateGetViolationCharges");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField employeeIdField;
	private final DataSourceFloatField violationChargesField;

	public DSPlateGetViolationCharges(String dataSourceID) {

		super();
		setID(dataSourceID);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		employeeIdField = new DataSourceTextField("employeeId", "职员");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setCanEdit(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		violationChargesField = new DataSourceFloatField("violationCharges", "资源绩效");
		violationChargesField.setLength(18);
		violationChargesField.setDecimalPad(2);
		violationChargesField.setFormat("##,###,###,##0.00");
		violationChargesField.setRequired(false);
		violationChargesField.setHidden(false);

		setFields(plateIdField, employeeIdField, violationChargesField);
	}

}
