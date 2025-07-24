package com.pomplatform.client.selectgridemployeevalue.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.selectgridemployeevalue.datasource.CDSelectGridEmployeeValue;

public class SelectGridEmployeeValueSearchForm extends SearchForm
{


	private final TextItem statusItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem roleIdItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNameEnItem;

	public SelectGridEmployeeValueSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSelectGridEmployeeValue.getInstance());
		statusItem = new TextItem("status", "员工状态");
		employeeIdItem = new TextItem("employeeId", "员工编码");
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		roleIdItem = new TextItem("roleId", "角色");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameEnItem = new TextItem("employeeNameEn", "英文名");

		setItems(statusItem, employeeIdItem, employeeNoItem, roleIdItem, employeeNameItem, employeeNameEnItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
