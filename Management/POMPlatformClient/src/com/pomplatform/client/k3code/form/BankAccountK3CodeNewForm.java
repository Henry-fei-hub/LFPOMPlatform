package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.k3code.datasource.DSAllCardManage;
import com.pomplatform.client.k3code.datasource.DSBankAccountK3Code;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;

public class BankAccountK3CodeNewForm extends AbstractWizadPage
{


	private final TextItem typeItem;
	private final ComboBoxItem businessIdItem;
	private final TextItem k3CodeItem;
	private final TextItem k3NameItem;

	public BankAccountK3CodeNewForm() {
		DSBankAccountK3Code ds = DSBankAccountK3Code.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		typeItem = new TextItem("type", " 7收款方类型");
		typeItem.setDefaultValue(5);
		typeItem.hide();
		__formItems.add(typeItem);
		
		//银行卡信息字段
		ListGridField cardManageIdField = new ListGridField("cardManageId");
		ListGridField bankAccountField = new ListGridField("bankAccount");
		ListGridField bankAddressField = new ListGridField("bankAddress");
		
		businessIdItem = new ComboBoxItem("businessId", "银行账号");
		businessIdItem.setWidth("*");
		businessIdItem.setChangeOnKeypress(false);
		businessIdItem.setOptionDataSource(DSAllCardManage.getInstance());
		Criteria condition = new Criteria();
		condition.addCriteria("objectType", 2);
		condition.addCriteria("enabled", true);
		businessIdItem.setPickListCriteria(condition);
		businessIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		businessIdItem.setValueField(cardManageIdField.getName());
		businessIdItem.setDisplayField(bankAddressField.getName());
		businessIdItem.setPickListFields(bankAddressField, bankAccountField);
		__formItems.add(businessIdItem);
		
		k3CodeItem = new TextItem("k3Code", "K3代码");
		k3CodeItem.setWidth("*");
		__formItems.add(k3CodeItem);
		
		k3NameItem = new TextItem("k3Name", "K3名称");
		k3NameItem.setWidth("*");
		__formItems.add(k3NameItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
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
		manager.setDataSource(DSBankAccountK3Code.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
