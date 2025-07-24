package com.pomplatform.client.contractincome.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDContractIncomeLedgerList extends DataSource
{


	public static CDContractIncomeLedgerList instance = null;

	public static CDContractIncomeLedgerList getInstance() {
		if(instance == null) {
			instance = new CDContractIncomeLedgerList("CDContractIncomeLedgerList");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField projectManagerField;
	private final DataSourceTextField plateManagerField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceIntegerField ledgerYearField;
	private final DataSourceIntegerField ledgerMonthField;
	private final DataSourceIntegerField clientIdField;
	private final DataSourceBooleanField isLockedField;
	private final DataSourceIntegerField contractYearField;
	private final DataSourceIntegerField unReceiveAmountTypeField;
	private final DataSourceIntegerField plateIdField;

	public CDContractIncomeLedgerList(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "合同签约公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		projectManagerField = new DataSourceTextField("projectManager", "项目经理");
		projectManagerField.setRequired(false);
		projectManagerField.setLength(128);
		projectManagerField.setHidden(false);

		plateManagerField = new DataSourceTextField("plateManager", "项目负责人");
		plateManagerField.setRequired(false);
		plateManagerField.setLength(128);
		plateManagerField.setHidden(false);

		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "合同签约金额");
		signingMoneySumField.setRequired(true);
		signingMoneySumField.setLength(18);
		signingMoneySumField.setHidden(false);

		ledgerYearField = new DataSourceIntegerField("ledgerYear", "台账年份");
		ledgerYearField.setRequired(false);
		ledgerYearField.setLength(11);
		ledgerYearField.setHidden(false);

		ledgerMonthField = new DataSourceIntegerField("ledgerMonth", "台账月份");
		ledgerMonthField.setRequired(false);
		ledgerMonthField.setLength(11);
		ledgerMonthField.setHidden(false);

		clientIdField = new DataSourceIntegerField("clientId", "客户");
		clientIdField.setRequired(false);
		clientIdField.setLength(11);
		clientIdField.setHidden(false);
		clientIdField.setValueMap(KeyValueManager.getValueMap("customers"));

		isLockedField = new DataSourceBooleanField("isLocked", "是否锁定");
		isLockedField.setRequired(false);
		isLockedField.setHidden(false);
		
		contractYearField = new DataSourceIntegerField("contractYear", "最早合同年份");
		contractYearField.setRequired(false);
		contractYearField.setLength(11);
		contractYearField.setHidden(false);
		
		unReceiveAmountTypeField = new DataSourceIntegerField("unReceiveAmountType", "未收款选择");
		unReceiveAmountTypeField.setRequired(false);
		unReceiveAmountTypeField.setLength(11);
		unReceiveAmountTypeField.setHidden(false);
		
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

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


		setFields(contractCodeField, contractNameField, companyIdField, projectManagerField, plateManagerField, signingMoneySumField, ledgerYearField, ledgerMonthField, clientIdField, isLockedField, contractYearField, unReceiveAmountTypeField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

