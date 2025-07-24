package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.datasource.DSReimbursementInvoiceInformation;

public class ReimbursementInvoiceInformationNewForm extends AbstractWizadPage
{


	private final TextItem processTypeItem;
	private final TextItem businessIdItem;
	private final TextItem detailIdItem;
	private final TextItem invoiceTypeItem;
	private final TextItem invoiceCodeItem;
	private final TextItem invoiceNumberItem;
	private final TextItem totalAmountItem;
	private final TextItem taxRateItem;
	private final TextItem taxAmountItem;
	private final TextItem subtractAmountItem;
	private final TextItem creatorItem;
	private final DateTimeItem createTimeItem;

	public ReimbursementInvoiceInformationNewForm() {
		DSReimbursementInvoiceInformation ds = DSReimbursementInvoiceInformation.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		processTypeItem = new TextItem("processType", "流程类型");
		__formItems.add(processTypeItem);
		businessIdItem = new TextItem("businessId", "流程业务主键");
		__formItems.add(businessIdItem);
		detailIdItem = new TextItem("detailId", "父表主键(实际主表)");
		__formItems.add(detailIdItem);
		invoiceTypeItem = new TextItem("invoiceType", "票类");
		__formItems.add(invoiceTypeItem);
		invoiceCodeItem = new TextItem("invoiceCode", "发票代码");
		__formItems.add(invoiceCodeItem);
		invoiceNumberItem = new TextItem("invoiceNumber", "发票号码");
		__formItems.add(invoiceNumberItem);
		totalAmountItem = new TextItem("totalAmount", "票面金额(价税合计)");
		__formItems.add(totalAmountItem);
		taxRateItem = new TextItem("taxRate", "税率");
		__formItems.add(taxRateItem);
		taxAmountItem = new TextItem("taxAmount", "税额");
		__formItems.add(taxAmountItem);
		subtractAmountItem = new TextItem("subtractAmount", "扣除金额");
		__formItems.add(subtractAmountItem);
		creatorItem = new TextItem("creator", "创建人");
		__formItems.add(creatorItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		__formItems.add(createTimeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSReimbursementInvoiceInformation.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
