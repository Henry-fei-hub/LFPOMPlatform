package com.pomplatform.client.calculateannualleave.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.calculateannualleave.datasource.CDTemporaryTime;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class TemporaryTimeSearchForm extends SearchForm
{


	private final TextItem employeeIdItem;

	public TemporaryTimeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDTemporaryTime.getInstance());
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setWidth("*");

		setItems(employeeIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
