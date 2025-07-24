package com.pomplatform.client.receivables.form;

import java.util.LinkedHashMap;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.receivables.datasource.CDMcapitalecoosmeor;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class McapitalecoosmeorSearchForm extends SearchForm {

	private final TextItem otherNameItem;
	private final TextItem otherBankAccountItem;
	private final SelectItem selfNameItem;
	private final SelectItem moneyAttributeItem;
	private final ComboBoxItem employeeIdItem;
	private final SelectItem isHasContract;
	private final BooleanItem hasInvoices;
	private final BooleanItem hasContractReceivable;
	private final BooleanItem hasDistributionCollection;
	private final ComboBoxItem contractIdItem;
	private final SelectItem processStatusItem;
	private final DateTimeItem minHappenDateItem;
	private final DateTimeItem maxHappenDateItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final FloatItem borrowMoneyItem;
	private final BooleanItem haveVoucherItem;

	public McapitalecoosmeorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcapitalecoosmeor.getInstance());
		otherNameItem = new TextItem("otherName", "对方名称(付款方)");
		otherNameItem.setWidth("*");
		otherBankAccountItem = new TextItem("otherBankAccount", "银行账号(付款方)");
		otherBankAccountItem.setWidth("*");
		selfNameItem = new SelectItem("selfName", "内部公司(收款方)");
		selfNameItem.setWidth("*");
		selfNameItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		moneyAttributeItem = new SelectItem("moneyAttribute", "款项属性");
		moneyAttributeItem.setWidth("*");
		moneyAttributeItem.setValue(1);
		moneyAttributeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_55"));
		employeeIdItem = new ComboBoxItem("employeeId", "登记人");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.hide();

		isHasContract = new SelectItem("isHasContract", "是否绑定合同");
		isHasContract.setWidth("*");
		LinkedHashMap<String, String> valueMap = new LinkedHashMap<>();
		valueMap.put("0", "");
		valueMap.put("1", "没有绑定合同");
		valueMap.put("2", "绑定合同");
		isHasContract.setValueMap(valueMap);
		isHasContract.setValue(1);

		hasInvoices = new BooleanItem("hasInvoices", "是否绑定发票");
		hasContractReceivable = new BooleanItem("hasContractReceivable", "是否绑定合同阶段");
		hasDistributionCollection = new BooleanItem("hasDistributionCollection", "是否分配回款");

		contractIdItem = new ComboBoxItem("contractId", "选择合同");
		contractIdItem.setChangeOnKeypress(false);
		contractIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", contractIdItem);
		contractIdItem.setWidth("*");

		processStatusItem = new SelectItem("processStatus", "流程状态");
		processStatusItem.setWidth("*");
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("0", "未分配");
		map.put("1", "分配中");
		map.put("2", "分配完成");
		map.put("3", "(财务)完成分配");
		processStatusItem.setValueMap(map);

		minHappenDateItem = new DateTimeItem("minHappenDate", "最小发生时间");
		minHappenDateItem.setWidth("*");

		maxHappenDateItem = new DateTimeItem("maxHappenDate", "最大发生时间");
		maxHappenDateItem.setWidth("*");

		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");

		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");

		borrowMoneyItem = new FloatItem("borrowMoney", "借款金额");
		borrowMoneyItem.setWidth("*");

		haveVoucherItem = new BooleanItem("haveVoucher", "已有凭证");
		
		setItems(moneyAttributeItem, selfNameItem, otherNameItem, otherBankAccountItem, employeeIdItem, haveVoucherItem, 
				isHasContract, minHappenDateItem, maxHappenDateItem, processStatusItem, hasInvoices, hasContractReceivable,
				hasDistributionCollection, contractCodeItem, contractNameItem, borrowMoneyItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
