package com.pomplatform.client.purchase.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.purchase.datasource.CDPaymentTemplateWithP;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class PaymentTemplateWithPSearchForm extends SearchForm {

	private final TextItem operatorIdItem;
	private final IntegerItem minPaymentCycleItem;
	private final IntegerItem maxPaymentCycleItem;
	private final TextItem templateNameItem;
	private final TextItem remarkItem;

	public PaymentTemplateWithPSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPaymentTemplateWithP.getInstance());
		operatorIdItem = new TextItem("operatorId", "操作人");
		operatorIdItem.hide();
		minPaymentCycleItem = new IntegerItem("minPaymentCycle", "最小支付周期(天)");
		minPaymentCycleItem.setWidth("*");
		maxPaymentCycleItem = new IntegerItem("maxPaymentCycle", "最大支付周期(天)");
		maxPaymentCycleItem.setWidth("*");
		templateNameItem = new TextItem("templateName", "模板名称");
		templateNameItem.setWidth("*");
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");

		setItems(operatorIdItem, minPaymentCycleItem, maxPaymentCycleItem, templateNameItem, remarkItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
