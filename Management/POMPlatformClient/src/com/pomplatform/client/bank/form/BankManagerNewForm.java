package com.pomplatform.client.bank.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.bank.datasource.DSBankManager;

public class BankManagerNewForm extends AbstractWizadPage
{


	private final TextItem bankNameItem;
	private final TextItem orderNumItem;
	private final DateTimeItem createTimeItem;

	public BankManagerNewForm() {
		DSBankManager ds = DSBankManager.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		bankNameItem = new TextItem("bankName", "银行名称");
		bankNameItem.setWidth("*");
		__formItems.add(bankNameItem);
		orderNumItem = new TextItem("orderNum", "排序 越小排越前");
		__formItems.add(orderNumItem);
		orderNumItem.setHidden(true);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setHidden(true);
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
		manager.setDataSource(DSBankManager.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
