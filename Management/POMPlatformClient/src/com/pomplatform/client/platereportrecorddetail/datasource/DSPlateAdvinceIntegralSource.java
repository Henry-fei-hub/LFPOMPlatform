package com.pomplatform.client.platereportrecorddetail.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPlateAdvinceIntegralSource extends DBDataSource {

	public static DSPlateAdvinceIntegralSource instance = null;

	public static DSPlateAdvinceIntegralSource getInstance() {
		if (instance == null) {
			instance = new DSPlateAdvinceIntegralSource("DSPlateAdvinceIntegralSource");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceFloatField achieveIntegralField;
	private final DataSourceTextField employeeNoField;

	public DSPlateAdvinceIntegralSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("PlateAdvinceIntegral");
		
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setHidden(true);
		
		employeeIdField = new DataSourceIntegerField("employeeId", "人员姓名");
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeNoField = new DataSourceTextField("employeeNo", "人员编号");
		employeeNoField.setLength(32);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);
		
		achieveIntegralField = new DataSourceFloatField("integral", "价值积分");
		achieveIntegralField.setLength(18);
		achieveIntegralField.setDecimalPad(2);
		achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(false);
		

		setFields(plateIdField,employeeIdField, employeeNoField,achieveIntegralField);
	}

}
