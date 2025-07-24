package com.pomplatform.client.collection.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMItemCollection extends DataSource
{


	public static CDMItemCollection instance = null;

	public static CDMItemCollection getInstance() {
		if(instance == null) {
			instance = new CDMItemCollection("CDMItemCollection");
		}
		return instance;
	}
	private final DataSourceBooleanField hasContractParagraphField;
	private final DataSourceDateTimeField minCreateTimeField;
	private final DataSourceDateTimeField maxCreateTimeField;
	private final DataSourceIntegerField moneyAttributeField;
	private final DataSourceIntegerField selfNameField;
	private final DataSourceTextField otherNameField;
	private final DataSourceTextField otherBankAccountField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;

	public CDMItemCollection(String dataSourceID) {

		setID(dataSourceID);
		hasContractParagraphField=new DataSourceBooleanField("hasContractParagraph", "有回款");
		
		minCreateTimeField = new DataSourceDateTimeField("minCreateTime", "最早创建时间");
		minCreateTimeField.setRequired(false);
		minCreateTimeField.setHidden(false);

		maxCreateTimeField = new DataSourceDateTimeField("maxCreateTime", "最晚创建时间");
		maxCreateTimeField.setRequired(false);
		maxCreateTimeField.setHidden(false);

		moneyAttributeField = new DataSourceIntegerField("moneyAttribute", "款项属性");
		moneyAttributeField.setRequired(false);
		moneyAttributeField.setLength(11);
		moneyAttributeField.setHidden(false);
		moneyAttributeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		selfNameField = new DataSourceIntegerField("selfName", "内部公司(收款方)");
		selfNameField.setRequired(false);
		selfNameField.setLength(11);
		selfNameField.setHidden(false);
		selfNameField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		otherNameField = new DataSourceTextField("otherName", "对方名称(付款方)");
		otherNameField.setRequired(false);
		otherNameField.setLength(128);
		otherNameField.setHidden(false);

		otherBankAccountField = new DataSourceTextField("otherBankAccount", "银行账号(付款方)");
		otherBankAccountField.setRequired(false);
		otherBankAccountField.setLength(128);
		otherBankAccountField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

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


		setFields(hasContractParagraphField,minCreateTimeField, maxCreateTimeField, moneyAttributeField, selfNameField, otherNameField, otherBankAccountField, contractCodeField, contractNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

