package com.pomplatform.client.capitaldsitributionemployee.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMemployeeaccountrecordespemmor extends DBDataSource
{


	public static DSMemployeeaccountrecordespemmor instance = null;

	public static DSMemployeeaccountrecordespemmor getInstance() {
		if(instance == null) {
			instance = new DSMemployeeaccountrecordespemmor("DSMemployeeaccountrecordespemmor");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceTextField dicTypeValueField;
	private final DataSourceIntegerField typeField;
	private final DataSourceFloatField integralField;
	private final DataSourceFloatField confirmIntegralField;

	public DSMemployeeaccountrecordespemmor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Memployeeaccountrecordespemmor");


		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "10绩效奖金)");
		businessTypeIdField.setLength(11);
		businessTypeIdField.setRequired(false);
		businessTypeIdField.setHidden(true);


		dicTypeValueField = new DataSourceTextField("dicTypeValue", "类型");
		dicTypeValueField.setLength(64);
		dicTypeValueField.setRequired(false);
		dicTypeValueField.setHidden(false);


		typeField = new DataSourceIntegerField("type", "类型");
		typeField.setLength(11);
		typeField.setRequired(true);
		typeField.setHidden(true);


		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);
		
		confirmIntegralField = new DataSourceFloatField("confirmIntegral", "校正后积分");
		confirmIntegralField.setLength(18);
		confirmIntegralField.setDecimalPad(2);
		confirmIntegralField.setFormat("#,###,###,###,###,##0.00");
		confirmIntegralField.setRequired(false);
		confirmIntegralField.setHidden(false);


		setFields(employeeIdField, businessTypeIdField, dicTypeValueField, typeField, integralField, confirmIntegralField);
	}


}

