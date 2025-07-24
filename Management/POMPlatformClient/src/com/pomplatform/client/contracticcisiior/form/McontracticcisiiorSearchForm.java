package com.pomplatform.client.contracticcisiior.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contracticcisiior.datasource.CDMcontracticcisiior;

public class McontracticcisiiorSearchForm extends SearchForm
{


	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final SelectItem invoiceTypeItem;
	private final SelectItem signItem;
	private final TextItem invoiceCodeItem;
	private final TextItem invoiceNumberItem;

	public McontracticcisiiorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcontracticcisiior.getInstance());
		contractIdItem = new TextItem("contractId", "主订单编码");
		contractIdItem.hide();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		invoiceTypeItem = new SelectItem("invoiceType", "发票类型");
		invoiceTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_52"));
		invoiceTypeItem.setWidth("*");
		signItem = new SelectItem("sign", "发票状态");
		signItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_53"));
		signItem.setWidth("*");
		invoiceCodeItem = new TextItem("invoiceCode", "发票代码");
		invoiceCodeItem.setWidth("*");
		invoiceNumberItem = new TextItem("invoiceNumber", "发票号码");
		invoiceNumberItem.setWidth("*");
		setItems(contractIdItem, contractCodeItem, contractNameItem, invoiceTypeItem, signItem, invoiceCodeItem, invoiceNumberItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
