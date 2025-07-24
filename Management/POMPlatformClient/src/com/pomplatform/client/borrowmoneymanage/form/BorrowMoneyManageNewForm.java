package com.pomplatform.client.borrowmoneymanage.form;

import java.util.Date;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.borrowmoneymanage.datasource.DSBorrowMoneyManage;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class BorrowMoneyManageNewForm extends AbstractWizadPage
{


	private final ComboBoxItem employeeIdItem;
	private final TextItem borrowLimitMoneyItem;

	public BorrowMoneyManageNewForm() {
		DSBorrowMoneyManage ds = DSBorrowMoneyManage.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		__form.setPadding(5);
		__form.setMargin(5);
		employeeIdItem = new ComboBoxItem("employeeId", "职员");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(employeeIdItem);
		borrowLimitMoneyItem = new TextItem("borrowLimitMoney", "借款额度");
		borrowLimitMoneyItem.setWidth("*");
		__formItems.add(borrowLimitMoneyItem);

		__form.setItems(getFormItemArray());
		__form.setBackgroundColor("#e2e2e2");
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
		manager.setDataSource(DSBorrowMoneyManage.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		//设置创建人和时间
		int createEmployeeId = ClientUtil.getEmployeeId();
		Map param = __form.getValues();
		param.put("createEmployeeId", createEmployeeId);
		param.put("createDate", new Date());
		return param;
	}


}
