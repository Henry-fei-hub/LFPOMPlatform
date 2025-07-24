package com.pomplatform.client.sinvoiceitiorcount.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sinvoiceitiorcount.datasource.CDSinvoiceitiorcount;

public class SinvoiceitiorcountSearchForm extends SearchForm
{


	private final TextItem minSignItem;
	private final TextItem maxSignItem;
	private final TextItem invoiceIdItem;
	private final SelectItem ticketingCompanyItem;
	private final TextItem infoCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem contractCodeItem;
	private final SelectItem invoiceTypeItem;
	private final TextItem disableTypeItem;
	private final TextItem invoiceExpressIdItem;
	private final SelectItem signItem;
	private final ComboBoxItem customerIdItem;
	private final TextItem invoiceCodeItem;
	private final TextItem invoiceNumberItem;
	private final DateTimeItem minInStockDateItem;
	private final DateTimeItem maxInStockDateItem;
	private final DateItem minInvoiceDateItem;
	private final DateItem maxInvoiceDateItem;
	private final TextItem minInvoiceAmountItem;
	private final TextItem maxInvoiceAmountItem;
	private final TextItem contractIdItem;
	private final TextItem contractNameItem;
	private final BooleanItem haveVoucherItem;

	public SinvoiceitiorcountSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSinvoiceitiorcount.getInstance());
		minSignItem = new TextItem("minSign", "发票状态开始");
		minSignItem.hide();
		maxSignItem = new TextItem("maxSign", "发票状态结束");
		maxSignItem.hide();
		invoiceIdItem = new TextItem("invoiceId", "开发票 编码");
		invoiceIdItem.hide();
		ticketingCompanyItem = new SelectItem("ticketingCompany", "购票公司");
		ticketingCompanyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_54"));
		ticketingCompanyItem.setWidth("*");
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.hide();
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.hide();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		invoiceTypeItem = new SelectItem("invoiceType", "发票类型");
		invoiceTypeItem.setWidth("*");
		invoiceTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_52"));
		disableTypeItem = new TextItem("disableType", "可操作状态");
		disableTypeItem.hide();
		invoiceExpressIdItem = new TextItem("invoiceExpressId", "发票快递编码");
		invoiceExpressIdItem.hide();
		signItem = new SelectItem("sign", "发票状态");
		signItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_53"));
		signItem.setWidth("*");
		
		customerIdItem = new ComboBoxItem("customerId", "客户名称");
		customerIdItem.setWidth("*");
		customerIdItem.setChangeOnKeypress(false);
		customerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("customers", customerIdItem);
		
		invoiceCodeItem = new TextItem("invoiceCode", "发票代码");
		invoiceCodeItem.setWidth("*");
		invoiceNumberItem = new TextItem("invoiceNumber", "发票号码");
		invoiceNumberItem.setWidth("*");
		minInStockDateItem = new DateTimeItem("minInStockDate", "最早发票入库日期");
		minInStockDateItem.hide();
		minInStockDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minInStockDateItem);
			}
		});
		maxInStockDateItem = new DateTimeItem("maxInStockDate", "最晚发票入库日期");
		maxInStockDateItem.hide();
		maxInStockDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxInStockDateItem);
			}
		});
		minInvoiceDateItem = new DateItem("minInvoiceDate", "最早开票日期");
		minInvoiceDateItem.setWidth("*");
		maxInvoiceDateItem = new DateItem("maxInvoiceDate", "最晚开票日期");
		maxInvoiceDateItem.setWidth("*");
		minInvoiceAmountItem = new TextItem("minInvoiceAmount", "最小开票金额");
		minInvoiceAmountItem.hide();
		maxInvoiceAmountItem = new TextItem("maxInvoiceAmount", "最大开票金额");
		maxInvoiceAmountItem.hide();
		contractIdItem = new TextItem("contractId", "合同编码");
		contractIdItem.setWidth("*");
		contractIdItem.hide();
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
//		contractNameItem.hide();
		haveVoucherItem = new BooleanItem("haveVoucher", "已有凭证");
		
		setItems(contractNameItem, minSignItem, maxSignItem, invoiceIdItem, ticketingCompanyItem, infoCodeItem, projectCodeItem, contractCodeItem, invoiceTypeItem, disableTypeItem, invoiceExpressIdItem, signItem, customerIdItem, invoiceCodeItem, invoiceNumberItem, minInStockDateItem, maxInStockDateItem, minInvoiceDateItem, maxInvoiceDateItem, minInvoiceAmountItem, maxInvoiceAmountItem, contractIdItem, haveVoucherItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
