package com.pomplatform.client.k3code.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDReceiveUnitK3Code extends DataSource
{


	public static CDReceiveUnitK3Code instance = null;

	public static CDReceiveUnitK3Code getInstance() {
		if(instance == null) {
			instance = new CDReceiveUnitK3Code("CDReceiveUnitK3Code");
		}
		return instance;
	}

	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField k3CodeField;
	private final DataSourceTextField receiveUnitField;
	private final DataSourceDateField operateStartTimeField;
	private final DataSourceDateField operateEndTimeField;
	private final DataSourceDateField updateStartTimeField;
	private final DataSourceDateField updateEndTimeField;

	public CDReceiveUnitK3Code(String dataSourceID) {

		setID(dataSourceID);
		businessIdField = new DataSourceIntegerField("businessId", "收款单位");
		businessIdField.setRequired(false);
		businessIdField.setLength(11);
		businessIdField.setHidden(false);
		businessIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setRequired(false);
		bankAccountField.setLength(64);
		bankAccountField.setHidden(false);

		k3CodeField = new DataSourceTextField("k3Code", "K3代码");
		k3CodeField.setRequired(false);
		k3CodeField.setLength(64);
		k3CodeField.setHidden(false);
		
		receiveUnitField = new DataSourceTextField("receiveUnit", "收款单位");
		receiveUnitField.setRequired(false);
		receiveUnitField.setLength(64);
		receiveUnitField.setHidden(false);

		operateStartTimeField = new DataSourceDateField("operateStartTime", "创建时间(开始)");
		operateStartTimeField.setRequired(false);
		operateStartTimeField.setHidden(false);
		
		operateEndTimeField = new DataSourceDateField("operateEndTime", "创建时间(截止)");
		operateEndTimeField.setRequired(false);
		operateEndTimeField.setHidden(false);
		
		updateStartTimeField = new DataSourceDateField("updateStartTime", "修改时间(开始)");
		updateStartTimeField.setRequired(false);
		updateStartTimeField.setHidden(false);
		
		updateEndTimeField = new DataSourceDateField("updateEndTime", "修改时间(截止)");
		updateEndTimeField.setRequired(false);
		updateEndTimeField.setHidden(false);
		
		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(businessIdField, bankAccountField, k3CodeField, receiveUnitField, operateStartTimeField, operateEndTimeField, updateStartTimeField, updateEndTimeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

