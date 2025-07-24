package com.pomplatform.client.purchase.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.purchase.datasource.DSPaymentTemplateWithP;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class PaymentTemplateWithPUpdateForm extends AbstractWizadPage {

	private final TextItem paymentTemplateIdItem;
	private final TextItem templateNameItem;
	private final IntegerItem paymentCycleItem;
	private final TextAreaItem remarkItem;
	private final TextItem operatorIdItem;
	private final DateTimeItem createTimeItem;

	public PaymentTemplateWithPUpdateForm() {
		DSPaymentTemplateWithP ds = DSPaymentTemplateWithP.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		paymentTemplateIdItem = new TextItem("paymentTemplateId", "payment_template_id");
		paymentTemplateIdItem.setDisabled(true);
		paymentTemplateIdItem.setRequired(true);
		paymentTemplateIdItem.hide();
		IsIntegerValidator paymentTemplateIdValidator = new IsIntegerValidator();
		paymentTemplateIdItem.setValidators(paymentTemplateIdValidator);
		__formItems.add(paymentTemplateIdItem);
		templateNameItem = new TextItem("templateName", "模板名称");
		templateNameItem.setRequired(true);
		templateNameItem.setWidth("*");
		__formItems.add(templateNameItem);
		
		paymentCycleItem = new IntegerItem("paymentCycle", "支付周期(天)");
		paymentCycleItem.setRequired(true);
		paymentCycleItem.setWidth("*");
		__formItems.add(paymentCycleItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);
		
		operatorIdItem = new TextItem("operatorId", "操作人");
		operatorIdItem.hide();
		__formItems.add(operatorIdItem);
		
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.hide();
		__formItems.add(createTimeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSPaymentTemplateWithP.getInstance());
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
