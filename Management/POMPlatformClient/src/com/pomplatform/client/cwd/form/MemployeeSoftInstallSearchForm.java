package com.pomplatform.client.cwd.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.cwd.datasource.CDMemployeeSoftInstall;

public class MemployeeSoftInstallSearchForm extends SearchForm
{


	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final PickTreeItem departmentIdItem;
	private final SelectItem statusItem;

	public MemployeeSoftInstallSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMemployeeSoftInstall.getInstance());
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		departmentIdItem = new PickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		statusItem = new SelectItem("status", "安装状态");
		statusItem.setValueMap((LinkedHashMap)getDataSource().getField("status").getValueMap());
		statusItem.setWidth("*");

		setItems(employeeNoItem, employeeNameItem, departmentIdItem, statusItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
