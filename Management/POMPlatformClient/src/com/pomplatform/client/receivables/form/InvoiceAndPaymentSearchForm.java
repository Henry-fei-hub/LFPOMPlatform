package com.pomplatform.client.receivables.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.receivables.datasource.CDInvoiceAndPayment;

public class InvoiceAndPaymentSearchForm extends SearchForm
{


	private final TextItem contractIdItem;
	private final TextItem otherNameItem;
	private final TextItem otherBankAccountItem;
	private final TextItem selfNameItem;
	private final SelectItem moneyAttributeItem;
	private final CheckboxItem hasInvoicesItem;
	private final CheckboxItem hasContractReceivableItem;
	private final CheckboxItem hasDistributionCollectionItem;
	private final TextItem processStatusItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem borrowMoneyItem;
	private final CheckboxItem haveVoucherItem;
	private final SelectItem happenYearItem;
	private final SelectItem happenMonthItem;
	private final SelectItem isHasContract;

	public InvoiceAndPaymentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDInvoiceAndPayment.getInstance());
		contractIdItem = new TextItem("contractId", "合同id");
		contractIdItem.setHidden(true);
		otherNameItem = new TextItem("otherName", "对方名称(付款方)");
		otherNameItem.setHidden(true);
		otherBankAccountItem = new TextItem("otherBankAccount", "银行账号(付款方)");
		otherBankAccountItem.setHidden(true);
		selfNameItem = new TextItem("selfName", "内部公司(收款方)");
		selfNameItem.setHidden(true);
		moneyAttributeItem = new SelectItem("moneyAttribute", "款项属性");
		moneyAttributeItem.setHidden(true);
//		moneyAttributeItem.setWidth("*");
//		moneyAttributeItem.setValue(1);
//		moneyAttributeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_55"));
		hasInvoicesItem = new CheckboxItem("hasInvoices", "是否绑定了发票");
		hasInvoicesItem.setHidden(true);
		hasContractReceivableItem = new CheckboxItem("hasContractReceivable", "是否绑定了合同阶段付款");
		hasContractReceivableItem.setHidden(true);
		hasDistributionCollectionItem = new CheckboxItem("hasDistributionCollection", "有分配回款");
		hasDistributionCollectionItem.setHidden(true);
		processStatusItem = new TextItem("processStatus", "流程状态 0 未处于流程  1审批中 2审批完成");
		processStatusItem.setHidden(true);
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		borrowMoneyItem = new TextItem("borrowMoney", "收款金额");
		borrowMoneyItem.setHidden(true);
		haveVoucherItem = new CheckboxItem("haveVoucher", "是否有凭证");
		haveVoucherItem.setHidden(true);
		happenYearItem = new SelectItem("happenYear","年份");
		happenYearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		happenYearItem.setWidth("*");
		happenMonthItem = new SelectItem("happenMonth","月份");
		happenMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		happenMonthItem.setWidth("*");
		isHasContract = new SelectItem("isHasContract", "是否绑定合同");
		isHasContract.setWidth("*");
		LinkedHashMap<String, String> valueMap = new LinkedHashMap<>();
		valueMap.put("0", "");
		valueMap.put("1", "没有绑定合同");
		valueMap.put("2", "绑定合同");
		isHasContract.setValueMap(valueMap);
		isHasContract.setValue(2);

		setItems(happenYearItem,happenMonthItem,contractCodeItem,  contractNameItem, isHasContract, contractIdItem, otherNameItem, otherBankAccountItem, selfNameItem, moneyAttributeItem, hasInvoicesItem, hasContractReceivableItem, hasDistributionCollectionItem, processStatusItem, borrowMoneyItem, haveVoucherItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
