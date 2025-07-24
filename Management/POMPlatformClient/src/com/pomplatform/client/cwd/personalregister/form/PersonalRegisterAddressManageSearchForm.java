package com.pomplatform.client.cwd.personalregister.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.cwd.personalregister.datasource.CDPersonalRegisterAddressManage;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class PersonalRegisterAddressManageSearchForm extends SearchForm
{


	private final ComboBoxItem employeeIdItem;
	private final TextItem ipAddressItem;
	private final TextItem macAddressItem;
	private final TextItem workplaceNameItem;

	public PersonalRegisterAddressManageSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPersonalRegisterAddressManage.getInstance());
		
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		
		ipAddressItem = new TextItem("ipAddress", "公网IP地址");
		ipAddressItem.setWidth("*");
		
		macAddressItem = new TextItem("macAddress", "机器MAC地址");
		macAddressItem.setWidth("*");
		
		workplaceNameItem = new TextItem("workplaceName", "工作场所名称");
		workplaceNameItem.setWidth("*");

		setItems(employeeIdItem, workplaceNameItem, ipAddressItem, macAddressItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
