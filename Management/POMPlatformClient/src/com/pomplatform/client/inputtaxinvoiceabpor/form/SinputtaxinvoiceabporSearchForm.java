package com.pomplatform.client.inputtaxinvoiceabpor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.inputtaxinvoiceabpor.datasource.CDSinputtaxinvoiceabpor;

public class SinputtaxinvoiceabporSearchForm extends SearchForm {

	private final TextItem remarkItem;
	private final TextItem salesCodeItem;
	private final TextItem salesNameItem;
	private final TextItem inputTaxInvoiceIdItem;
	private final SelectItem invoiceTypeItem;
	private final TextItem invoiceCodeItem;
	private final TextItem invoiceNumberItem;
	private final TextItem invoiceAmountItem;
	private final TextItem taxRateItem;
	private final TextItem operatorItem;
	private final TextItem yearItem;
	private final TextItem monthItem;
	private final CheckboxItem haveCheckItem;

	public SinputtaxinvoiceabporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSinputtaxinvoiceabpor.getInstance());
		remarkItem = new TextItem("remark", "备注");
		remarkItem.hide();
		remarkItem.setWidth("*");
		salesCodeItem = new TextItem("salesCode", "销方税号");
		salesCodeItem.setWidth("*");
		salesNameItem = new TextItem("salesName", "销方名称");
		salesNameItem.setWidth("*");
		inputTaxInvoiceIdItem = new TextItem("inputTaxInvoiceId", "主键");
		inputTaxInvoiceIdItem.hide();
		invoiceTypeItem = new SelectItem("invoiceType", "发票类型 ");
		invoiceTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_52"));
		invoiceTypeItem.setWidth("*");
		
		invoiceCodeItem = new TextItem("invoiceCode", "发票代码");
		invoiceCodeItem.setWidth("*");
		
		invoiceNumberItem = new TextItem("invoiceNumber", "发票号码");
		invoiceNumberItem.setWidth("*");
		
		invoiceAmountItem = new TextItem("invoiceAmount", "开票金额");
		invoiceAmountItem.setWidth("*");
		
		taxRateItem = new TextItem("taxRate", "税率");
		taxRateItem.hide();
		operatorItem = new TextItem("operator", "操作人");
		operatorItem.hide();
		yearItem = new TextItem("year", "年");
		yearItem.hide();
		monthItem = new TextItem("month", "月");
		monthItem.hide();
		haveCheckItem = new CheckboxItem("haveCheck", "是否勾选");
		haveCheckItem.hide();

		setItems(remarkItem, salesCodeItem, salesNameItem, inputTaxInvoiceIdItem, invoiceTypeItem, invoiceCodeItem,
				invoiceNumberItem, invoiceAmountItem, taxRateItem, operatorItem, yearItem, monthItem, haveCheckItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
