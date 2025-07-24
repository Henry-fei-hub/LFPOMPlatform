package com.pomplatform.client.capitaldistribution.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSimpleCapitalList extends DBDataSource
{


	public static DSSimpleCapitalList instance = null;

	public static DSSimpleCapitalList getInstance() {
		if(instance == null) {
			instance = new DSSimpleCapitalList("DSSimpleCapitalList");
		}
		return instance;
	}

	private final DataSourceBooleanField lockedField;
	private final DataSourceIntegerField capitalIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceDateTimeField happenDateField;

	public DSSimpleCapitalList(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SimpleCapitalList");


		lockedField = new DataSourceBooleanField("locked", "是否锁定");
		lockedField.setRequired(false);
		lockedField.setHidden(false);


		capitalIdField = new DataSourceIntegerField("capitalId", "资金表id");
		capitalIdField.setLength(11);
		capitalIdField.setPrimaryKey(true);
		capitalIdField.setRequired(true);
		capitalIdField.setHidden(false);


		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(false);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);


		borrowMoneyField = new DataSourceFloatField("borrowMoney", "借（增加）");
		borrowMoneyField.setLength(16);
		borrowMoneyField.setDecimalPad(2);
		borrowMoneyField.setFormat("##,###,###,###,##0.00");
		borrowMoneyField.setRequired(false);
		borrowMoneyField.setHidden(false);


		happenDateField = new DataSourceDateTimeField("happenDate", "发生日期");
		happenDateField.setRequired(false);
		happenDateField.setHidden(false);


		setFields(capitalIdField, lockedField, contractIdField, borrowMoneyField, happenDateField);
	}


}

