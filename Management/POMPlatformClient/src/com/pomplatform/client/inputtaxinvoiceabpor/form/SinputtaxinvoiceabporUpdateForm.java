package com.pomplatform.client.inputtaxinvoiceabpor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.inputtaxinvoiceabpor.datasource.DSSinputtaxinvoiceabpor;

public class SinputtaxinvoiceabporUpdateForm extends AbstractWizadPage
{


	private final TextItem inputTaxInvoiceIdItem;
	private final TextItem addTypeItem;
	private final TextItem invoiceTypeItem;
	private final TextItem invoiceCodeItem;
	private final TextItem invoiceNumberItem;
	private final DateTimeItem invoiceDateItem;
	private final TextItem invoiceAmountItem;
	private final TextItem taxRateItem;
	private final TextItem businessIdItem;
	private final TextItem processTypeItem;
	private final TextItem processInstanceIdItem;
	private final TextItem operatorItem;
	private final DateTimeItem createTimeItem;
	private final TextItem deleteFlagItem;
	private final TextItem remarkItem;
	private final TextItem otherRemarkItem;
	private final TextItem randomCodeItem;
	private final TextItem taxAmountItem;

	public SinputtaxinvoiceabporUpdateForm() {
		DSSinputtaxinvoiceabpor ds = DSSinputtaxinvoiceabpor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		inputTaxInvoiceIdItem = new TextItem("inputTaxInvoiceId", "input_tax_invoice_id");
		inputTaxInvoiceIdItem.setDisabled(true);
		inputTaxInvoiceIdItem.setRequired(true);
		IsIntegerValidator inputTaxInvoiceIdValidator = new IsIntegerValidator();
		inputTaxInvoiceIdItem.setValidators(inputTaxInvoiceIdValidator);
		__formItems.add(inputTaxInvoiceIdItem);
		addTypeItem = new TextItem("addType", "添加类型 1手动添加  2二维码添加");
		__formItems.add(addTypeItem);
		invoiceTypeItem = new TextItem("invoiceType", "发票类型 1专票，2普票 ，3代开");
		__formItems.add(invoiceTypeItem);
		invoiceCodeItem = new TextItem("invoiceCode", "发票代码(10位 每次批量录入是一样)");
		__formItems.add(invoiceCodeItem);
		invoiceNumberItem = new TextItem("invoiceNumber", "发票号码(8位)");
		__formItems.add(invoiceNumberItem);
		invoiceDateItem = new DateTimeItem("invoiceDate", "开票日期");
		__formItems.add(invoiceDateItem);
		invoiceAmountItem = new TextItem("invoiceAmount", "开票金额(如 100)");
		__formItems.add(invoiceAmountItem);
		taxRateItem = new TextItem("taxRate", "税率(如 6%)");
		__formItems.add(taxRateItem);
		businessIdItem = new TextItem("businessId", "流程业务主键");
		__formItems.add(businessIdItem);
		processTypeItem = new TextItem("processType", "流程类型");
		__formItems.add(processTypeItem);
		processInstanceIdItem = new TextItem("processInstanceId", "流程实例主键");
		__formItems.add(processInstanceIdItem);
		operatorItem = new TextItem("operator", "operator");
		__formItems.add(operatorItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		__formItems.add(createTimeItem);
		deleteFlagItem = new TextItem("deleteFlag", "删除状态  0未删除  1被删除");
		__formItems.add(deleteFlagItem);
		remarkItem = new TextItem("remark", "备注");
		__formItems.add(remarkItem);
		otherRemarkItem = new TextItem("otherRemark", "其他备注");
		__formItems.add(otherRemarkItem);
		randomCodeItem = new TextItem("randomCode", "发票二维码随机字符串");
		__formItems.add(randomCodeItem);
		taxAmountItem = new TextItem("taxAmount", "税额");
		__formItems.add(taxAmountItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSinputtaxinvoiceabpor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
