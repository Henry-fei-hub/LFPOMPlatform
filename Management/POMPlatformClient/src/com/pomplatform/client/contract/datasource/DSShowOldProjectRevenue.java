package com.pomplatform.client.contract.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.util.SC;

public class DSShowOldProjectRevenue extends DBDataSource
{


	public static DSShowOldProjectRevenue instance = null;

	public static DSShowOldProjectRevenue getInstance() {
		if(instance == null) {
			instance = new DSShowOldProjectRevenue("DSShowOldProjectRevenue");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceFloatField amountField;
	private final DataSourceIntegerField palteIdField;
	private final DataSourceIntegerField isFinishField;

	public DSShowOldProjectRevenue(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ShowOldProjectRevenue");


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(32);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(true);
		contractCodeField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		projectCodeField = new DataSourceTextField("projectCode", "订单编号");
		projectCodeField.setLength(32);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "订单名");
		projectNameField.setLength(32);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		amountField = new DataSourceFloatField("amount", "订单的营收");
		amountField.setLength(32);
		amountField.setDecimalPad(2);
		amountField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		palteIdField = new DataSourceIntegerField("palteId", "归属的部门");
		palteIdField.setLength(11);
		palteIdField.setRequired(false);
		palteIdField.setHidden(false);
		palteIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		isFinishField = new DataSourceIntegerField("isFinish", "是否完结");
		isFinishField.setLength(11);
		isFinishField.setRequired(false);
		isFinishField.setHidden(true);

		setFields(contractCodeField, projectCodeField, projectNameField, palteIdField, amountField, isFinishField);
	}


}

