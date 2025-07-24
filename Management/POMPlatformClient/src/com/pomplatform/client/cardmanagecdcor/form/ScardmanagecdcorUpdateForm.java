package com.pomplatform.client.cardmanagecdcor.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.cardmanagecdcor.datasource.DSScardmanagecdcor;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class ScardmanagecdcorUpdateForm extends AbstractWizadPage {

	private final TextItem cardManageIdItem;
	private final SelectItem objectIdItem;
	private final TextItem objectTypeItem;
	private final ComboBoxItem bankIdItem;
	private final TextItem bankAccountItem;
	private final TextItem bankAddressItem;
	private final TextItem cardTypeItem;
	private final CheckboxItem defaultCardItem;
	private final CheckboxItem enabledItem;
	private final SelectItem currencyTypeItem;
	private final ComboBoxItem cmbcCodeIdItem;
	private final CheckboxItem truePaymentItem;

	public ScardmanagecdcorUpdateForm() {
		DSScardmanagecdcor ds = DSScardmanagecdcor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		cardManageIdItem = new TextItem("cardManageId", "主键编码");
		cardManageIdItem.setDisabled(true);
		cardManageIdItem.setRequired(true);
		cardManageIdItem.setHidden(true);
		IsIntegerValidator cardManageIdValidator = new IsIntegerValidator();
		cardManageIdItem.setValidators(cardManageIdValidator);
		__formItems.add(cardManageIdItem);
		objectIdItem = new SelectItem("objectId", "归属公司");
		objectIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		objectIdItem.setWidth("*");
		__formItems.add(objectIdItem);
		objectTypeItem = new TextItem("objectType", "2单位)");
		objectTypeItem.hide();
		__formItems.add(objectTypeItem);
		bankIdItem = new ComboBoxItem("bankId", "开户行");
		bankIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		bankIdItem.setDisabled(true);
		bankIdItem.setValueMap(KeyValueManager.getValueMap("banks"));
		bankIdItem.setWidth("*");
		__formItems.add(bankIdItem);
		bankAccountItem = new TextItem("bankAccount", "银行账号");
//		bankAccountItem.setDisabled(true);
		bankAccountItem.setWidth("*");
		__formItems.add(bankAccountItem);
		bankAddressItem = new TextItem("bankAddress", "开户行所在地");
//		bankAddressItem.setDisabled(true);
		bankAddressItem.setWidth("*");
		__formItems.add(bankAddressItem);
		cardTypeItem = new TextItem("cardType", "2报销卡)");
		cardTypeItem.hide();
		__formItems.add(cardTypeItem);
		defaultCardItem = new CheckboxItem("defaultCard", "是否为默认卡");
		defaultCardItem.setWidth("*");
		__formItems.add(defaultCardItem);
		enabledItem = new CheckboxItem("enabled", "是否启用");
		enabledItem.setWidth("*");
		__formItems.add(enabledItem);
		currencyTypeItem = new SelectItem("currencyType", "货币类型");
		currencyTypeItem.setWidth("*");
		currencyTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));
		__formItems.add(currencyTypeItem);
		cmbcCodeIdItem = new ComboBoxItem("cmbcCodeId", "招商银行分行");
		cmbcCodeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		cmbcCodeIdItem.setChangeOnKeypress(false);
		cmbcCodeIdItem.setValueMap(KeyValueManager.getValueMap("cmbc_branch"));
		cmbcCodeIdItem.setWidth("*");
		__formItems.add(cmbcCodeIdItem);
		truePaymentItem = new CheckboxItem("truePayment", "真实收付款");
		__formItems.add(truePaymentItem);

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
		manager.setDataSource(DSScardmanagecdcor.getInstance());
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
