package com.pomplatform.client.leavetype.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.leavetype.datasource.CDPersonalLeaveType;

public class PersonalLeaveTypeSearchForm extends SearchForm
{


	private final SelectItem employeeIdItem;
	private final SelectItem provinceIdItem;

	public PersonalLeaveTypeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPersonalLeaveType.getInstance());
		employeeIdItem = new SelectItem("employeeId", "员工编码");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		provinceIdItem = new SelectItem("provinceId", "适用省份");
		provinceIdItem.setValueMap(KeyValueManager.getValueMap("provinces"));

		setItems(employeeIdItem, provinceIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
