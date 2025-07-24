package com.pomplatform.client.employeeInformationDetails.form;

import java.util.*;

import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeeInformationDetails.datasource.CDMemployeeeeedor;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;


public class MemployeeeeedorSearchForm extends SearchForm
{


	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final IPickTreeItem departmentIdItem;

	public MemployeeeeedorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMemployeeeeedor.getInstance());
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");

		employeeNoItem = new TextItem("employeeNo", "员工工号");
		employeeNoItem.setWidth("*");

		departmentIdItem = new IPickTreeItem("departmentId", "部门");
//		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setValueField("treeId");

		setItems(employeeNameItem, employeeNoItem, departmentIdItem);

		setNumCols(6);
		setAutoHeight();
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
