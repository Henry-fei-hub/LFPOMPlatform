package com.pomplatform.client.receivables.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcapitalecoosmeor extends DataSource
{


	public static CDMcapitalecoosmeor instance = null;

	public static CDMcapitalecoosmeor getInstance() {
		if(instance == null) {
			instance = new CDMcapitalecoosmeor("CDMcapitalecoosmeor");
		}
		return instance;
	}

	private final DataSourceTextField otherNameField;
	private final DataSourceTextField otherBankAccountField;
	private final DataSourceIntegerField selfNameField;
	private final DataSourceIntegerField moneyAttributeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField selfBankNameField;
	private final DataSourceTextField selfBankAccountField;

	public CDMcapitalecoosmeor(String dataSourceID) {

		setID(dataSourceID);
		otherNameField = new DataSourceTextField("otherName", "对方名称(付款方)");
		otherNameField.setRequired(false);
		otherNameField.setLength(128);
		otherNameField.setHidden(false);

		otherBankAccountField = new DataSourceTextField("otherBankAccount", "银行账号(付款方)");
		otherBankAccountField.setRequired(false);
		otherBankAccountField.setLength(128);
		otherBankAccountField.setHidden(false);

		selfNameField = new DataSourceIntegerField("selfName", "内部公司(收款方)");
		selfNameField.setRequired(false);
		selfNameField.setLength(11);
		selfNameField.setHidden(false);
		selfNameField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));
		
		selfBankAccountField = new DataSourceTextField("selfBankAccount", "银行账号(收款方)");
		selfBankAccountField.setLength(128);
		selfBankAccountField.setRequired(false);
		selfBankAccountField.setHidden(false);

		selfBankNameField = new DataSourceTextField("selfBankName", "银行名称(收款方)");
		selfBankNameField.setLength(128);
		selfBankNameField.setRequired(false);
		selfBankNameField.setHidden(false);

		moneyAttributeField = new DataSourceIntegerField("moneyAttribute", "款项属性");
		moneyAttributeField.setRequired(false);
		moneyAttributeField.setLength(11);
		moneyAttributeField.setHidden(false);
		moneyAttributeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setRequired(true);
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

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


		setFields(otherNameField, otherBankAccountField, selfNameField, selfBankNameField, selfBankAccountField, moneyAttributeField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

