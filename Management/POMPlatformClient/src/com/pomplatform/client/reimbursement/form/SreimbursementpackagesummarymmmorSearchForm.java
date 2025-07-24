package com.pomplatform.client.reimbursement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.reimbursement.datasource.CDSreimbursementpackagesummarymmmor;

public class SreimbursementpackagesummarymmmorSearchForm extends SearchForm {

	private final DateTimeItem minCreateTimeItem;
	private final DateTimeItem maxCreateTimeItem;
	private final DateTimeItem minUpdateTimeItem;
	private final DateTimeItem maxUpdateTimeItem;
	private final SelectItem otherNameItem;
	private final TextItem amountItem;
	private final TextItem paymentAmountItem;
	private final TextItem strikeABalanceAmountItem;
	private final CheckboxItem isCompletedItem;
	private final TextItem payeeNameItem;
	private final TextItem selfBankNameItem;
	private final TextItem selfBankAccountItem;
	private final TextItem otherBankNameItem;
	private final TextItem otherBankAccountItem;
	private final TextItem reimbursementPackageSummaryIdItem;
	private final TextItem reimbursementPackageIdItem;
	private final TextItem moneyAttributeItem;
	private final SelectItem payForItem;
	private final TextItem employeeOrCompanyIdItem;

	public SreimbursementpackagesummarymmmorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSreimbursementpackagesummarymmmor.getInstance());
		minCreateTimeItem = new DateTimeItem("minCreateTime", "最早开始时间");
		minCreateTimeItem.hide();
		minCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCreateTimeItem);
			}
		});
		maxCreateTimeItem = new DateTimeItem("maxCreateTime", "最晚开始时间");
		maxCreateTimeItem.hide();
		maxCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCreateTimeItem);
			}
		});
		minUpdateTimeItem = new DateTimeItem("minUpdateTime", "付款开始时间");
		minUpdateTimeItem.setWidth("*");
		minUpdateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minUpdateTimeItem);
			}
		});
		maxUpdateTimeItem = new DateTimeItem("maxUpdateTime", "付款结束时间");
		maxUpdateTimeItem.setWidth("*");
		maxUpdateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxUpdateTimeItem);
			}
		});
		otherNameItem = new SelectItem("otherName", "付款方(公司)");
		otherNameItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_69"));
		otherNameItem.setWidth("*");

		amountItem = new TextItem("amount", "总金额");
		amountItem.hide();

		paymentAmountItem = new TextItem("paymentAmount", "付款金额");
		paymentAmountItem.hide();

		strikeABalanceAmountItem = new TextItem("strikeABalanceAmount", "冲账金额");
		strikeABalanceAmountItem.hide();

		isCompletedItem = new CheckboxItem("isCompleted", "是否付款");
		isCompletedItem.setWidth("*");

		payeeNameItem = new TextItem("payeeName", "收款方");
		payeeNameItem.setWidth("*");

		selfBankNameItem = new TextItem("selfBankName", "银行名称(收款方)");
		selfBankNameItem.hide();

		selfBankAccountItem = new TextItem("selfBankAccount", "银行账号(收款方)");
		selfBankAccountItem.hide();

		otherBankNameItem = new TextItem("otherBankName", "银行名称(付款方)");
		otherBankNameItem.hide();

		otherBankAccountItem = new TextItem("otherBankAccount", "银行账号(付款方)");
		otherBankAccountItem.hide();

		reimbursementPackageSummaryIdItem = new TextItem("reimbursementPackageSummaryId", "报销打包汇总表编码");
		reimbursementPackageSummaryIdItem.hide();

		reimbursementPackageIdItem = new TextItem("reimbursementPackageId", "报销打包表编码");
		reimbursementPackageIdItem.hide();

		moneyAttributeItem = new TextItem("moneyAttribute", "款项属性");
		moneyAttributeItem.hide();

		payForItem = new SelectItem("payFor", "收款方类型");
		payForItem.setWidth("*");
		payForItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_67"));

		employeeOrCompanyIdItem = new TextItem("employeeOrCompanyId", "员工或者收款单位Id");
		employeeOrCompanyIdItem.hide();

		setItems(minCreateTimeItem, maxCreateTimeItem, payForItem, payeeNameItem, otherNameItem, minUpdateTimeItem,
				maxUpdateTimeItem, amountItem, paymentAmountItem, strikeABalanceAmountItem, isCompletedItem,
				selfBankNameItem, selfBankAccountItem, otherBankNameItem, otherBankAccountItem,
				reimbursementPackageSummaryIdItem, reimbursementPackageIdItem, moneyAttributeItem,
				employeeOrCompanyIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
