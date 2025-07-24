package com.pomplatform.client.inputtaxinvoiceabpor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.inputtaxinvoiceabpor.datasource.CDMinputtaxinvoicelinkfinancesippciiymssor;

public class MinputtaxinvoicelinkfinancesippciiymssorSearchForm extends SearchForm
{


	private final SelectItem processStatusItem;
	private final SelectItem companyIdItem;
	private final TextItem invoiceCodeItem;
	private final TextItem invoiceNumberItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final TextItem salesCodeItem;
	private final TextItem salesNameItem;
	private final TextItem codeItem;

	public MinputtaxinvoicelinkfinancesippciiymssorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMinputtaxinvoicelinkfinancesippciiymssor.getInstance());
		processStatusItem = new SelectItem("processStatus", "流程状态");
		processStatusItem.hide();
		
		companyIdItem = new SelectItem("companyId", "公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		
		invoiceCodeItem = new TextItem("invoiceCode", "发票代码");
		invoiceCodeItem.setWidth("*");
		
		invoiceNumberItem = new TextItem("invoiceNumber", "发票号码");
		invoiceNumberItem.setWidth("*");
		
		yearItem = new SelectItem("year", "年");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.setWidth("*");
		
		monthItem = new SelectItem("month", "月");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		monthItem.setWidth("*");
		
		salesCodeItem = new TextItem("salesCode", "销方税号");
		salesCodeItem.setWidth("*");
		
		salesNameItem = new TextItem("salesName", "销方名称");
		salesNameItem.setWidth("*");
		
		codeItem = new TextItem("code", "报销编号");
		codeItem.setWidth("*");

		setItems(processStatusItem, companyIdItem, invoiceCodeItem, invoiceNumberItem, yearItem, monthItem, salesCodeItem, salesNameItem, codeItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
