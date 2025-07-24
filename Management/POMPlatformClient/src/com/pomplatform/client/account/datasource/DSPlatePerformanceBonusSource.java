package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPlatePerformanceBonusSource extends DBDataSource {

	public static DSPlatePerformanceBonusSource instance = null;

	public static DSPlatePerformanceBonusSource getInstance() {
		if (instance == null) {
			instance = new DSPlatePerformanceBonusSource("DSPlatePerformanceBonusSource");
		}
		return instance;
	}

	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceFloatField sendIntegralField;
	private final DataSourceFloatField sendedIntegralField;

	public DSPlatePerformanceBonusSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("AccountManageProcess");
		
		remarkField = new DataSourceTextField("remark", "职员编号");
		remarkField.setLength(18);
		remarkField.setCanEdit(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "职员名称");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setCanEdit(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		sendIntegralField = new DataSourceFloatField("sendIntegral", "绩效奖金");
		sendIntegralField.setLength(18);
		sendIntegralField.setDecimalPad(2);
		sendIntegralField.setFormat("#,###,###,###,###,##0.00");
		sendIntegralField.setRequired(false);
		sendIntegralField.setCanEdit(true);
		sendIntegralField.setHidden(false);
		
		sendedIntegralField = new DataSourceFloatField("sendedIntegral", "累计绩效奖金");
		sendedIntegralField.setLength(18);
		sendedIntegralField.setDecimalPad(2);
		sendedIntegralField.setFormat("#,###,###,###,###,##0.00");
		sendedIntegralField.setCanEdit(false);
		sendedIntegralField.setHidden(false);


		setFields(remarkField,employeeIdField, sendIntegralField, sendedIntegralField);
	}

}
