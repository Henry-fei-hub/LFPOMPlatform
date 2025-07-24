package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadProjectSettlementDetailOfPlateAccount extends DBDataSource
{


	public static DSOnLoadProjectSettlementDetailOfPlateAccount instance = null;

	public static DSOnLoadProjectSettlementDetailOfPlateAccount getInstance() {
		if(instance == null) {
			instance = new DSOnLoadProjectSettlementDetailOfPlateAccount("DSOnLoadProjectSettlementDetailOfPlateAccount");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField sheetNameField;
	private final DataSourceFloatField integralField;
	private final DataSourceDateField recordDateField;
	private final DataSourceTextField remarkField;

	public DSOnLoadProjectSettlementDetailOfPlateAccount(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadProjectSettlementDetailOfPlateAccount");


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setLength(64);
		sheetCodeField.setRequired(true);
		sheetCodeField.setHidden(false);
//		sheetCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts", sheetCodeField);


		sheetNameField = new DataSourceTextField("sheetName", "订单名称");
		sheetNameField.setLength(512);
		sheetNameField.setRequired(true);
		sheetNameField.setHidden(false);


		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(plateIdField, sheetCodeField, sheetNameField, integralField, recordDateField, remarkField);
	}


}

