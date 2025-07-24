package com.pomplatform.client.contractincome.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;


import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contractincome.datasource.CDContractIncomeLedgerList;

public class ContractIncomeLedgerListSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final SelectItem companyIdItem;
	private final ComboBoxItem projectManagerItem;
	private final ComboBoxItem plateManagerItem;
	private final TextItem signingMoneySumItem;
	private final TextItem ledgerYearItem;
	private final TextItem ledgerMonthItem;
	private final ComboBoxItem clientIdItem;
	private final CheckboxItem isLockedItem;
	private final CheckboxItem isLastPaymentItem;
	private final TextItem contractYearItem;
	private final CheckboxItem invoiceAmountIsGreaterThan0Item;
	private final SelectItem unReceiveAmountTypeItem;
	private final ComboBoxItem plateIdItem;
	
	public ContractIncomeLedgerListSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractIncomeLedgerList.getInstance());
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		companyIdItem = new SelectItem("companyId", "合同签约公司");
		companyIdItem.setWidth("*");
		KeyValueManager.loadValueMap("system_dictionary_26", companyIdItem);
		
		
		projectManagerItem = new ComboBoxItem("projectManager", "项目经理");
		projectManagerItem.setWidth("*");
		KeyValueManager.loadValueMap("employee_names", projectManagerItem);
		
		
		
		plateManagerItem = new ComboBoxItem("plateManager", "项目负责人");
		plateManagerItem.setWidth("*");
		KeyValueManager.loadValueMap("employee_names", plateManagerItem);
		
		signingMoneySumItem = new TextItem("signingMoneySum", "合同签约金额");
		signingMoneySumItem.setHidden(true);
		
		Date date = new Date();
		ledgerYearItem = new TextItem("ledgerYear", "台账年份");
		ledgerYearItem.setWidth("*");
		ledgerYearItem.setDefaultValue(DateUtil.getDisplayYear(date));
		
		ledgerMonthItem = new TextItem("ledgerMonth", "台账月份");
		ledgerMonthItem.setWidth("*");
		ledgerMonthItem.setDefaultValue(DateUtil.getDisplayMonth(date) + 1);
		
		
		clientIdItem = new ComboBoxItem("clientId", "客户");
		clientIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("customers", clientIdItem);
		clientIdItem.setWidth("*");
		
		isLockedItem = new CheckboxItem("isLocked", "是否锁定");
		isLockedItem.setHidden(true);
		
		isLastPaymentItem = new CheckboxItem("isLastPayment", "合同尾款");
		
		contractYearItem = new TextItem("contractYear", "最早合同年份");
		contractYearItem.setWidth("*");
		
		invoiceAmountIsGreaterThan0Item = new CheckboxItem("invoiceAmountIsGreaterThan0", "开票金额>0");
		
		unReceiveAmountTypeItem = new SelectItem("unReceiveAmountType", "未收款选择");
		unReceiveAmountTypeItem.setWidth("*");
		LinkedHashMap<Integer, String> unReceiveAmountTypeMap = new LinkedHashMap<>();
		unReceiveAmountTypeMap.put(1, "未收款>0");
		unReceiveAmountTypeMap.put(2, "未收款=0");
		unReceiveAmountTypeMap.put(3, "未收款<0");
		unReceiveAmountTypeItem.setValueMap(unReceiveAmountTypeMap);
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setChangeOnKeypress(false);
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.hide();

		setItems(contractCodeItem, contractNameItem, companyIdItem, projectManagerItem, plateManagerItem, signingMoneySumItem, ledgerYearItem, ledgerMonthItem, clientIdItem, isLockedItem, contractYearItem, unReceiveAmountTypeItem, invoiceAmountIsGreaterThan0Item, isLastPaymentItem, plateIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
