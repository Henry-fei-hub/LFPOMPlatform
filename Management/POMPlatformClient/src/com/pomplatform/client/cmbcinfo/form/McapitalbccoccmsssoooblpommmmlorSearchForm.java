package com.pomplatform.client.cmbcinfo.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.cmbcinfo.datasource.CDMcapitalbccoccmsssoooblpommmmlor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class McapitalbccoccmsssoooblpommmmlorSearchForm extends SearchForm {

	private final TextItem capitalIdItem;
	private final TextItem contractIdItem;
	private final TextItem operatorItem;
	private final TextItem capitalTypeItem;
	private final TextItem contractCodeItem;
	private final TextItem moneyAttributeItem;
	private final SelectItem selfNameItem;
	private final TextItem selfBankNameItem;
	private final TextItem selfBankAccountItem;
	private final TextItem otherNameItem;
	private final TextItem otherBankNameItem;
	private final TextItem otherBankAccountItem;
	private final TextItem borrowMoneyItem;
	private final TextItem loanMoneyItem;
	private final TextItem processStatusItem;
	private final TextItem originalCurrencyItem;
	private final DateTimeItem minHappenDateItem;
	private final DateTimeItem maxHappenDateItem;
	private final DateTimeItem minCreateDateItem;
	private final DateTimeItem maxCreateDateItem;
	private final TextItem linkNumItem;
	private final BooleanItem isLinkItem;

	public McapitalbccoccmsssoooblpommmmlorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcapitalbccoccmsssoooblpommmmlor.getInstance());
		capitalIdItem = new TextItem("capitalId", "资金表id");
		capitalIdItem.hide();
		contractIdItem = new TextItem("contractId", "合同id");
		contractIdItem.hide();
		operatorItem = new TextItem("operator", "操作人id");
		operatorItem.hide();
		capitalTypeItem = new TextItem("capitalType", "资金类型  1 流入  2 流出");
		capitalTypeItem.hide();
		contractCodeItem = new TextItem("contractCode", "合同主编号");
		contractCodeItem.hide();
		moneyAttributeItem = new TextItem("moneyAttribute", "款项属性");
		moneyAttributeItem.hide();
		selfNameItem = new SelectItem("selfName", "归属公司");
		selfNameItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		selfNameItem.setWidth("*");
		selfBankNameItem = new TextItem("selfBankName", "银行名称(收款方)");
		selfBankNameItem.hide();
		selfBankNameItem.setWidth("*");
		selfBankAccountItem = new TextItem("selfBankAccount", "银行账号(收款方)");
		selfBankAccountItem.setWidth("*");
		otherNameItem = new TextItem("otherName", "对方名称(付款方)");
		otherNameItem.setWidth("*");
		otherBankNameItem = new TextItem("otherBankName", "银行名称(付款方)");
		otherBankNameItem.setWidth("*");
		otherBankAccountItem = new TextItem("otherBankAccount", "银行账号(付款方)");
		otherBankAccountItem.setWidth("*");
		borrowMoneyItem = new TextItem("borrowMoney", "借（增加）");
		borrowMoneyItem.hide();
		loanMoneyItem = new TextItem("loanMoney", "贷（减少）");
		loanMoneyItem.hide();
		processStatusItem = new TextItem("processStatus", "流程状态 0 未处于流程  1审批中 2审批完成");
		processStatusItem.hide();
		originalCurrencyItem = new TextItem("originalCurrency", "原币金额");
		originalCurrencyItem.hide();
		minHappenDateItem = new DateTimeItem("minHappenDate", "最早发生日期");
		minHappenDateItem.setWidth("*");
		minHappenDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minHappenDateItem);
			}
		});
		maxHappenDateItem = new DateTimeItem("maxHappenDate", "最晚发生日期");
		maxHappenDateItem.setWidth("*");
		maxHappenDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxHappenDateItem);
			}
		});
		minCreateDateItem = new DateTimeItem("minCreateDate", "最早登记日期");
		minCreateDateItem.hide();
		minCreateDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCreateDateItem);
			}
		});
		maxCreateDateItem = new DateTimeItem("maxCreateDate", "最晚登记日期");
		maxCreateDateItem.hide();
		maxCreateDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCreateDateItem);
			}
		});
		linkNumItem = new TextItem("linkNum", "数量");
		linkNumItem.hide();
		
		isLinkItem = new BooleanItem("isLink", "是否绑定");
		isLinkItem.setWidth("*");

		setItems(capitalIdItem, contractIdItem, operatorItem, capitalTypeItem, contractCodeItem, moneyAttributeItem,
				selfNameItem, selfBankNameItem, selfBankAccountItem, otherNameItem, otherBankNameItem,
				otherBankAccountItem, borrowMoneyItem, loanMoneyItem, processStatusItem, originalCurrencyItem,
				minHappenDateItem, maxHappenDateItem, minCreateDateItem, maxCreateDateItem, linkNumItem, isLinkItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
