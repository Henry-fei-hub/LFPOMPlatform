package com.pomplatform.client.purchase.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.purchase.datasource.DSPaymentTemplateWithP;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class PaymentTemplateWithPNewForm extends AbstractWizadPage {

	private final TextItem templateNameItem;
	private final IntegerItem paymentCycleItem;
	private final TextAreaItem remarkItem;
	private final TextItem operatorIdItem;
	private final DateTimeItem createTimeItem;

	public PaymentTemplateWithPNewForm() {
		DSPaymentTemplateWithP ds = DSPaymentTemplateWithP.getInstance();
		__form.setWidth100();
		__form.setHeight100();
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
		operatorIdItem.setDefaultValue(ClientUtil.getEmployeeId());
		operatorIdItem.hide();
		__formItems.add(operatorIdItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.hide();
		__formItems.add(createTimeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return __form.validate();
	}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
		else
			__form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSPaymentTemplateWithP.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

}
