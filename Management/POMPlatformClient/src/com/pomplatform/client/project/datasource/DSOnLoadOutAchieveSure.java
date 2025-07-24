package com.pomplatform.client.project.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadOutAchieveSure extends DBDataSource
{


	public static DSOnLoadOutAchieveSure instance = null;

	public static DSOnLoadOutAchieveSure getInstance() {
		if(instance == null) {
			instance = new DSOnLoadOutAchieveSure("DSOnLoadOutAchieveSure");
		}
		return instance;
	}

	private final DataSourceTextField financialContractCodeField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField totalRevenueField;
	private final DataSourceFloatField lastTotalRevenueField;
	private final DataSourceFloatField currentRevenueField;

	public DSOnLoadOutAchieveSure(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadOutAchieveSure");


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


		totalRevenueField = new DataSourceFloatField("totalRevenue", "累计营收");
		totalRevenueField.setLength(18);
		totalRevenueField.setDecimalPad(2);
		totalRevenueField.setFormat("#,###,###,###,###,##0.00");
		totalRevenueField.setRequired(false);
		totalRevenueField.setHidden(false);


		lastTotalRevenueField = new DataSourceFloatField("lastTotalRevenue", "上月累积营收");
		lastTotalRevenueField.setLength(18);
		lastTotalRevenueField.setDecimalPad(2);
		lastTotalRevenueField.setFormat("#,###,###,###,###,##0.00");
		lastTotalRevenueField.setRequired(true);
		lastTotalRevenueField.setHidden(false);


		currentRevenueField = new DataSourceFloatField("currentRevenue", "本月营收");
		currentRevenueField.setLength(18);
		currentRevenueField.setDecimalPad(2);
		currentRevenueField.setFormat("#,###,###,###,###,##0.00");
		currentRevenueField.setRequired(false);
		currentRevenueField.setHidden(false);


		setFields(financialContractCodeField, contractCodeField, contractNameField, totalRevenueField, lastTotalRevenueField, currentRevenueField);
	}


}

