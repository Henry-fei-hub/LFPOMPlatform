package com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMcapitaldistributionlinksubcontractpcor extends DBDataSource
{


	public static DSMcapitaldistributionlinksubcontractpcor instance = null;

	public static DSMcapitaldistributionlinksubcontractpcor getInstance() {
		if(instance == null) {
			instance = new DSMcapitaldistributionlinksubcontractpcor("DSMcapitaldistributionlinksubcontractpcor");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalDistributionLinkSubContractIdField;
	private final DataSourceIntegerField capitalDistributionIdField;
	private final DataSourceIntegerField subContractIdField;
	private final DataSourceFloatField moneyField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField capitalIdField;
	private final DataSourceDateTimeField createTimeField;

	public DSMcapitaldistributionlinksubcontractpcor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mcapitaldistributionlinksubcontractpcor");


		capitalDistributionLinkSubContractIdField = new DataSourceIntegerField("capitalDistributionLinkSubContractId", "主键");
		capitalDistributionLinkSubContractIdField.setLength(11);
		capitalDistributionLinkSubContractIdField.setPrimaryKey(true);
		capitalDistributionLinkSubContractIdField.setRequired(true);
		capitalDistributionLinkSubContractIdField.setHidden(false);


		capitalDistributionIdField = new DataSourceIntegerField("capitalDistributionId", "回款分配编码");
		capitalDistributionIdField.setLength(11);
		capitalDistributionIdField.setRequired(false);
		capitalDistributionIdField.setHidden(false);


		subContractIdField = new DataSourceIntegerField("subContractId", "订单编码");
		subContractIdField.setLength(11);
		subContractIdField.setRequired(false);
		subContractIdField.setHidden(false);


		moneyField = new DataSourceFloatField("money", "金额");
		moneyField.setLength(16);
		moneyField.setDecimalPad(2);
		moneyField.setFormat("##,###,###,###,##0.00");
		moneyField.setRequired(false);
		moneyField.setHidden(false);


		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		capitalIdField = new DataSourceIntegerField("capitalId", "收款主键(手动分配回款使用)");
		capitalIdField.setLength(11);
		capitalIdField.setRequired(false);
		capitalIdField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		setFields(capitalDistributionLinkSubContractIdField, capitalDistributionIdField, subContractIdField, moneyField, contractCodeField, projectNameField, capitalIdField, createTimeField);
	}


}

