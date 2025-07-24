package com.pomplatform.client.cardmanagecdcor.form;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.cardmanagecdcor.datasource.DSScardmanagecdcor;

public class ScardmanagecdcorNewForm extends AbstractWizadPage
{

	private final SelectItem objectIdItem;
	private final TextItem objectTypeItem;
	private final SelectItem bankIdItem;
	private final TextItem bankAccountItem;
	private final TextItem bankAddressItem;
	private final TextItem cardTypeItem;
	private final CheckboxItem defaultCardItem;
	private final CheckboxItem enabledItem;
	private final SelectItem currencyTypeItem;
	private final ComboBoxItem cmbcCodeIdItem;
	private final CheckboxItem truePaymentItem;

	public ScardmanagecdcorNewForm() {
		DSScardmanagecdcor ds = DSScardmanagecdcor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		objectIdItem = new SelectItem("objectId", "归属公司");
		objectIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		objectIdItem.setWidth("*");
		objectIdItem.setRequired(true);
		__formItems.add(objectIdItem);
		objectTypeItem = new TextItem("objectType", "2单位)");
		objectTypeItem.setDefaultValue(2);
		objectTypeItem.hide();
		__formItems.add(objectTypeItem);
		bankIdItem = new SelectItem("bankId", "开户行");
		bankIdItem.setValueMap(KeyValueManager.getValueMap("banks"));
		bankIdItem.setWidth("*");
		bankIdItem.setRequired(true);
		__formItems.add(bankIdItem);
		bankAccountItem = new TextItem("bankAccount", "银行账号");
		bankAccountItem.setWidth("*");
		bankAccountItem.setRequired(true);
		__formItems.add(bankAccountItem);
		bankAddressItem = new TextItem("bankAddress", "开户行所在地");
		bankAddressItem.setWidth("*");
		bankAddressItem.setRequired(true);
		__formItems.add(bankAddressItem);
		cardTypeItem = new TextItem("cardType", "2报销卡)");
		cardTypeItem.hide();
		__formItems.add(cardTypeItem);
		defaultCardItem = new CheckboxItem("defaultCard", "是否为默认卡");
		defaultCardItem.setDefaultValue(true);
		defaultCardItem.setWidth("*");
		__formItems.add(defaultCardItem);
		enabledItem = new CheckboxItem("enabled", "是否启用");
		enabledItem.setDefaultValue(true);
		enabledItem.setWidth("*");
		__formItems.add(enabledItem);
		currencyTypeItem = new SelectItem("currencyType", "货币类型");
		currencyTypeItem.setWidth("*");
		currencyTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));
		currencyTypeItem.setRequired(true);
		__formItems.add(currencyTypeItem);
		cmbcCodeIdItem = new ComboBoxItem("cmbcCodeId", "招商银行分行");
		cmbcCodeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		cmbcCodeIdItem.setChangeOnKeypress(false);
		cmbcCodeIdItem.setValueMap(KeyValueManager.getValueMap("cmbc_branch"));
		cmbcCodeIdItem.setWidth("*");
		__formItems.add(cmbcCodeIdItem);
		truePaymentItem = new CheckboxItem("truePayment", "真实收付款");
		truePaymentItem.setDefaultValue(true);
		__formItems.add(truePaymentItem);


		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);

	}

	public boolean checkDataNotNull(){
		if(BaseHelpUtils.isNullOrZero(objectIdItem.getValue())){
			SC.say("归属公司不能为空");
			return false;
		}
		if(BaseHelpUtils.isNullOrZero(bankIdItem.getValue())){
			SC.say("开户行不能为空");
			return false;
		}
		if(BaseHelpUtils.isNullOrZero(bankAccountItem.getValue())){
			SC.say("银行账户不能为空");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(bankAddressItem.getValue())){
			SC.say("开户行所在地不能为空");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkData() {
		return checkDataNotNull();
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSScardmanagecdcor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
