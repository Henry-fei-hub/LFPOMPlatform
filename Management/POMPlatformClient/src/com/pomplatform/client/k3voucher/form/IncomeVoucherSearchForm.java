package com.pomplatform.client.k3voucher.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.k3voucher.datasource.CDIncomeVoucher;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class IncomeVoucherSearchForm extends SearchForm
{


	private final SelectItem companyIdItem;
	private final TextItem invoiceNumberItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem codeItem;
	private final TextItem nameItem;
	private final TextItem debitSideItem;
	private final TextItem creditSideItem;
	private final TextItem customerIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final BooleanItem lockedItem;

	public IncomeVoucherSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDIncomeVoucher.getInstance());
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setWidth("*");
		invoiceNumberItem = new TextItem("invoiceNumber", "发票号码");
		invoiceNumberItem.setWidth("*");
		startDateItem = new DateItem("startDate", "开始归属日期");
		startDateItem.setWidth("*");
		endDateItem = new DateItem("endDate", "结束归属日期");
		endDateItem.setWidth("*");;
		codeItem = new TextItem("code", "科目代码");
		codeItem.setWidth("*");
		nameItem = new TextItem("name", "科目名称");
		nameItem.setWidth("*");
		debitSideItem = new TextItem("debitSide", "借方");
		debitSideItem.setWidth("*");
		creditSideItem = new TextItem("creditSide", "贷方");
		creditSideItem.setWidth("*");
		customerIdItem = new TextItem("customerId", "客户名称");
		customerIdItem.setWidth("*");
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		lockedItem = new BooleanItem("locked", "是否定稿");
		lockedItem.setWidth("*");

		setItems(companyIdItem, invoiceNumberItem, startDateItem, endDateItem, codeItem, nameItem, debitSideItem, creditSideItem, customerIdItem, contractCodeItem, contractNameItem, lockedItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
