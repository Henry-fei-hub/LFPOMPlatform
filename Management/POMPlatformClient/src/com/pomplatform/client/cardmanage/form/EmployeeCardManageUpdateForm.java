package com.pomplatform.client.cardmanage.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.cardmanage.datasource.DSEmployeeCardManage;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class EmployeeCardManageUpdateForm extends AbstractWizadPage
{


	private final TextItem cardManageIdItem;
	private final ComboBoxItem objectIdItem;
	private final ComboBoxItem bankIdItem;
	private final TextItem bankAccountItem;
	private final TextItem bankAddressItem;
	private final TextItem cardTypeItem;
	private final CheckboxItem defaultCardItem;
	private final CheckboxItem enabledItem;
	private final TextItem bankNameItem;

	public EmployeeCardManageUpdateForm() {
		DSEmployeeCardManage ds = DSEmployeeCardManage.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		__form.setPadding(5);
		__form.setMargin(5);
		cardManageIdItem = new TextItem("cardManageId", "主键编码");
		cardManageIdItem.setDisabled(true);
		cardManageIdItem.setRequired(true);
		cardManageIdItem.hide();
		IsIntegerValidator cardManageIdValidator = new IsIntegerValidator();
		cardManageIdItem.setValidators(cardManageIdValidator);
		__formItems.add(cardManageIdItem);
		objectIdItem = new ComboBoxItem("objectId", "职员");
		objectIdItem.setWidth("*");
		objectIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		objectIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(objectIdItem);
		bankIdItem = new ComboBoxItem("bankId", "开户行");
		bankIdItem.setWidth("*");
		bankIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		bankIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_68"));
		KeyValueManager.loadValueMap("banks", bankIdItem);
		bankIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				bankNameItem.setValue(event.getItem().getDisplayValue());
				
			}
		});
		__formItems.add(bankIdItem);
		bankNameItem = new TextItem("bankName", "开户行(支行)<font color='red'>填写内容例子:XX银行XX支行</font>");
		bankNameItem.setWidth("*");
		__formItems.add(bankNameItem);
		bankAccountItem = new TextItem("bankAccount", "银行账号");
		bankAccountItem.setWidth("*");
		__formItems.add(bankAccountItem);
		bankAddressItem = new TextItem("bankAddress", "开户行所在地");
		bankAddressItem.setWidth("*");
		__formItems.add(bankAddressItem);
		cardTypeItem = new TextItem("cardType", "卡类型");
		cardTypeItem.setWidth("*");
		cardTypeItem.hide();
		__formItems.add(cardTypeItem);
		defaultCardItem = new CheckboxItem("defaultCard", "是否为默认卡");
		__formItems.add(defaultCardItem);
		enabledItem = new CheckboxItem("enabled", "是否启用");
		__formItems.add(enabledItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setBackgroundColor("#e2e2e2");
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		bankNameItem.setColSpan(4);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSEmployeeCardManage.getInstance());
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
