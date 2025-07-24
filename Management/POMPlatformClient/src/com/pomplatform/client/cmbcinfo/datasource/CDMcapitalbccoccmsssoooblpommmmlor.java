package com.pomplatform.client.cmbcinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CDMcapitalbccoccmsssoooblpommmmlor extends DataSource {

	public static CDMcapitalbccoccmsssoooblpommmmlor instance = null;

	public static CDMcapitalbccoccmsssoooblpommmmlor getInstance() {
		if (instance == null) {
			instance = new CDMcapitalbccoccmsssoooblpommmmlor("CDMcapitalbccoccmsssoooblpommmmlor");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceIntegerField capitalTypeField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField moneyAttributeField;
	private final DataSourceIntegerField selfNameField;
	private final DataSourceTextField selfBankNameField;
	private final DataSourceTextField selfBankAccountField;
	private final DataSourceTextField otherNameField;
	private final DataSourceTextField otherBankNameField;
	private final DataSourceTextField otherBankAccountField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceFloatField loanMoneyField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceFloatField originalCurrencyField;
	private final DataSourceDateTimeField minHappenDateField;
	private final DataSourceDateTimeField maxHappenDateField;
	private final DataSourceDateTimeField minCreateDateField;
	private final DataSourceDateTimeField maxCreateDateField;
	private final DataSourceIntegerField linkNumField;
	private final DataSourceBooleanField isLinkField;

	public CDMcapitalbccoccmsssoooblpommmmlor(String dataSourceID) {

		setID(dataSourceID);
		capitalIdField = new DataSourceIntegerField("capitalId", "资金表id");
		capitalIdField.setRequired(true);
		capitalIdField.setLength(11);
		capitalIdField.setPrimaryKey(true);
		capitalIdField.setHidden(true);

		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		operatorField = new DataSourceIntegerField("operator", "操作人id");
		operatorField.setRequired(false);
		operatorField.setLength(11);
		operatorField.setHidden(false);

		capitalTypeField = new DataSourceIntegerField("capitalType", "资金类型  1 流入  2 流出");
		capitalTypeField.setRequired(false);
		capitalTypeField.setLength(11);
		capitalTypeField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同主编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		moneyAttributeField = new DataSourceIntegerField("moneyAttribute", "款项属性");
		moneyAttributeField.setRequired(false);
		moneyAttributeField.setLength(11);
		moneyAttributeField.setHidden(false);

		selfNameField = new DataSourceIntegerField("selfName", "内部公司(收款方)");
		selfNameField.setRequired(false);
		selfNameField.setLength(11);
		selfNameField.setHidden(false);

		selfBankNameField = new DataSourceTextField("selfBankName", "银行名称(收款方)");
		selfBankNameField.setRequired(false);
		selfBankNameField.setLength(128);
		selfBankNameField.setHidden(false);

		selfBankAccountField = new DataSourceTextField("selfBankAccount", "银行账号(收款方)");
		selfBankAccountField.setRequired(false);
		selfBankAccountField.setLength(128);
		selfBankAccountField.setHidden(false);

		otherNameField = new DataSourceTextField("otherName", "对方名称(付款方)");
		otherNameField.setRequired(false);
		otherNameField.setLength(128);
		otherNameField.setHidden(false);

		otherBankNameField = new DataSourceTextField("otherBankName", "银行名称(付款方)");
		otherBankNameField.setRequired(false);
		otherBankNameField.setLength(128);
		otherBankNameField.setHidden(false);

		otherBankAccountField = new DataSourceTextField("otherBankAccount", "银行账号(付款方)");
		otherBankAccountField.setRequired(false);
		otherBankAccountField.setLength(128);
		otherBankAccountField.setHidden(false);

		borrowMoneyField = new DataSourceFloatField("borrowMoney", "借（增加）");
		borrowMoneyField.setRequired(true);
		borrowMoneyField.setLength(16);
		borrowMoneyField.setHidden(false);

		loanMoneyField = new DataSourceFloatField("loanMoney", "贷（减少）");
		loanMoneyField.setRequired(true);
		loanMoneyField.setLength(16);
		loanMoneyField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 未处于流程  1审批中 2审批完成");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		originalCurrencyField = new DataSourceFloatField("originalCurrency", "原币金额");
		originalCurrencyField.setRequired(true);
		originalCurrencyField.setLength(16);
		originalCurrencyField.setHidden(false);

		minHappenDateField = new DataSourceDateTimeField("minHappenDate", "最早发生日期");
		minHappenDateField.setRequired(false);
		minHappenDateField.setHidden(false);

		maxHappenDateField = new DataSourceDateTimeField("maxHappenDate", "最晚发生日期");
		maxHappenDateField.setRequired(false);
		maxHappenDateField.setHidden(false);

		minCreateDateField = new DataSourceDateTimeField("minCreateDate", "最早登记日期");
		minCreateDateField.setRequired(false);
		minCreateDateField.setHidden(false);

		maxCreateDateField = new DataSourceDateTimeField("maxCreateDate", "最晚登记日期");
		maxCreateDateField.setRequired(false);
		maxCreateDateField.setHidden(false);

		linkNumField = new DataSourceIntegerField("linkNum", "数量");
		linkNumField.setRequired(true);
		linkNumField.setLength(11);
		linkNumField.setHidden(false);

		isLinkField = new DataSourceBooleanField("isLink", "是否绑定");
		isLinkField.setRequired(false);
		isLinkField.setHidden(true);

		DataSourceIntegerField currentPageField = new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField = new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);

		setFields(capitalIdField, contractIdField, operatorField, capitalTypeField, contractCodeField,
				moneyAttributeField, selfNameField, selfBankNameField, selfBankAccountField, otherNameField,
				otherBankNameField, otherBankAccountField, borrowMoneyField, loanMoneyField, processStatusField,
				originalCurrencyField, minHappenDateField, maxHappenDateField, minCreateDateField, maxCreateDateField,
				linkNumField, isLinkField, currentPageField, pageLinesField);

		setClientOnly(true);
	}

}
