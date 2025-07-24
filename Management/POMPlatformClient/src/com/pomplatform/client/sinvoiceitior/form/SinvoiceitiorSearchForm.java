package com.pomplatform.client.sinvoiceitior.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sinvoiceitior.datasource.CDSinvoiceitior;

public class SinvoiceitiorSearchForm extends SearchForm
{


	private final TextItem invoiceIdItem;
	private final SelectItem ticketingCompanyItem;
	private final TextItem infoCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem contractCodeItem;
	private final SelectItem invoiceTypeItem;
	private final TextItem disableTypeItem;
	private final TextItem invoiceExpressIdItem;
	private final SelectItem signItem;
	private final TextItem clientNameItem;
	private final TextItem invoiceCodeItem;
	private final TextItem invoiceNumberItem;
	private final DateTimeItem minInStockDateItem;
	private final DateTimeItem maxInStockDateItem;
	private final DateTimeItem minInvoiceDateItem;
	private final DateTimeItem maxInvoiceDateItem;
	private final TextItem minInvoiceAmountItem;
	private final TextItem maxInvoiceAmountItem;

	public SinvoiceitiorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSinvoiceitior.getInstance());
		invoiceIdItem = new TextItem("invoiceId", "开发票 编码");
		invoiceIdItem.hide();
		ticketingCompanyItem = new SelectItem("ticketingCompany", "购票公司");
		ticketingCompanyItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		ticketingCompanyItem.setWidth("*");
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.hide();
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.hide();
		contractCodeItem = new TextItem("contractCode", "合同主编号");
		contractCodeItem.hide();
		invoiceTypeItem = new SelectItem("invoiceType", "发票类型");
		invoiceTypeItem.setWidth("*");
		invoiceTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_52"));
		disableTypeItem = new TextItem("disableType", "可操作状态");
		disableTypeItem.hide();
		invoiceExpressIdItem = new TextItem("invoiceExpressId", "发票快递编码");
		invoiceExpressIdItem.hide();
		signItem = new SelectItem("sign", "发票状态");
		signItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_53"));
		signItem.hide();
		clientNameItem = new TextItem("clientName", "客户名称");
		clientNameItem.hide();
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
		minInvoiceDateItem = new DateTimeItem("minInvoiceDate", "最早开票日期");
		minInvoiceDateItem.hide();
		minInvoiceDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minInvoiceDateItem);
			}
		});
		maxInvoiceDateItem = new DateTimeItem("maxInvoiceDate", "最晚开票日期");
		maxInvoiceDateItem.hide();
		maxInvoiceDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxInvoiceDateItem);
			}
		});
		minInvoiceAmountItem = new TextItem("minInvoiceAmount", "最小开票金额");
		minInvoiceAmountItem.hide();
		maxInvoiceAmountItem = new TextItem("maxInvoiceAmount", "最大开票金额");
		maxInvoiceAmountItem.hide();
		
		setItems(invoiceIdItem, ticketingCompanyItem, infoCodeItem, projectCodeItem, contractCodeItem, invoiceTypeItem, disableTypeItem, invoiceExpressIdItem, signItem, clientNameItem, invoiceCodeItem, invoiceNumberItem, minInStockDateItem, maxInStockDateItem, minInvoiceDateItem, maxInvoiceDateItem, minInvoiceAmountItem, maxInvoiceAmountItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
