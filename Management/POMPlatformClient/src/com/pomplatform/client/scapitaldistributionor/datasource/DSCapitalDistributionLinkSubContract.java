package com.pomplatform.client.scapitaldistributionor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class DSCapitalDistributionLinkSubContract extends DBDataSource {

	public static DSCapitalDistributionLinkSubContract instance = null;

	public static DSCapitalDistributionLinkSubContract getInstance() {
		if (instance == null) {
			instance = new DSCapitalDistributionLinkSubContract("DSCapitalDistributionLinkSubContract");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalDistributionLinkSubContractIdField;
	private final DataSourceIntegerField capitalDistributionIdField;
	private final DataSourceIntegerField subContractIdField;
	private final DataSourceFloatField moneyField;

	public DSCapitalDistributionLinkSubContract(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("CapitalDistributionLinkSubContract");

		capitalDistributionLinkSubContractIdField = new DataSourceIntegerField("capitalDistributionLinkSubContractId",
				"主键");
		capitalDistributionLinkSubContractIdField.setLength(11);
		capitalDistributionLinkSubContractIdField.setPrimaryKey(true);
		capitalDistributionLinkSubContractIdField.setRequired(true);
		capitalDistributionLinkSubContractIdField.setHidden(true);

		capitalDistributionIdField = new DataSourceIntegerField("capitalDistributionId", "回款分配编码");
		capitalDistributionIdField.setLength(11);
		capitalDistributionIdField.setRequired(false);
		capitalDistributionIdField.setHidden(true);

		subContractIdField = new DataSourceIntegerField("subContractId", "子订单");
		subContractIdField.setLength(11);
		subContractIdField.setRequired(false);
		subContractIdField.setHidden(false);
//		subContractIdField.setValueMap(KeyValueManager.getValueMap("projects"));
        KeyValueManager.loadValueMap("projects",subContractIdField);

		moneyField = new DataSourceFloatField("money", "金额");
		moneyField.setLength(16);
		moneyField.setDecimalPad(2);
		moneyField.setFormat("##,###,###,###,##0.00");
		moneyField.setRequired(false);
		moneyField.setHidden(false);

		setFields(capitalDistributionLinkSubContractIdField, capitalDistributionIdField, subContractIdField,
				moneyField);
	}

}
