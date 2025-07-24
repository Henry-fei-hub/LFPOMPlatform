package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadInAchieveDetail extends DBDataSource
{


	public static DSOnLoadInAchieveDetail instance = null;

	public static DSOnLoadInAchieveDetail getInstance() {
		if(instance == null) {
			instance = new DSOnLoadInAchieveDetail("DSOnLoadInAchieveDetail");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceTextField financialContractCodeField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField sheetNameField;
	private final DataSourceFloatField totalRevenueField;
	private final DataSourceFloatField currentRevenueField;
	private final DataSourceFloatField lastTotalRevenueField;

	public DSOnLoadInAchieveDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadInAchieveDetail");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		financialContractCodeField = new DataSourceTextField("financialContractCode", "财务合同编号");
		financialContractCodeField.setLength(64);
		financialContractCodeField.setRequired(false);
		financialContractCodeField.setHidden(false);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setLength(64);
		sheetCodeField.setRequired(true);
		sheetCodeField.setHidden(false);


		sheetNameField = new DataSourceTextField("sheetName", "订单名称");
		sheetNameField.setLength(512);
		sheetNameField.setRequired(true);
		sheetNameField.setHidden(false);


		totalRevenueField = new DataSourceFloatField("totalRevenue", "累计营收");
		totalRevenueField.setLength(18);
		totalRevenueField.setDecimalPad(2);
		totalRevenueField.setFormat("#,###,###,###,###,##0.00");
		totalRevenueField.setRequired(false);
		totalRevenueField.setHidden(false);


		currentRevenueField = new DataSourceFloatField("currentRevenue", "本月营收");
		currentRevenueField.setLength(18);
		currentRevenueField.setDecimalPad(2);
		currentRevenueField.setFormat("#,###,###,###,###,##0.00");
		currentRevenueField.setRequired(false);
		currentRevenueField.setHidden(false);


		lastTotalRevenueField = new DataSourceFloatField("lastTotalRevenue", "上月累积营收");
		lastTotalRevenueField.setLength(18);
		lastTotalRevenueField.setDecimalPad(2);
		lastTotalRevenueField.setFormat("#,###,###,###,###,##0.00");
		lastTotalRevenueField.setRequired(true);
		lastTotalRevenueField.setHidden(false);


		setFields(plateIdField, financialContractCodeField, contractCodeField, contractNameField, sheetCodeField, sheetNameField, totalRevenueField, currentRevenueField, lastTotalRevenueField);
	}


}

