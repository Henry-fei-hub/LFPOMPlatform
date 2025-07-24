package com.pomplatform.client.workflow.personnel.form;

import java.util.*;

import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.personnel.datasource.CDApplicationInForFiling;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;


public class ApplicationInForFilingSearchForm extends SearchForm
{


	private final TextItem drafterItem;
	private final TextItem companyIdItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final PickTreeItem departmentIdItem;

	public ApplicationInForFilingSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDApplicationInForFiling.getInstance());
		drafterItem = new TextItem("drafter", "申请人");
		drafterItem.hide();
		drafterItem.setWidth("*");
		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.hide();
		companyIdItem.setWidth("*");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		departmentIdItem = new PickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments", "0"));

		setItems(drafterItem, companyIdItem, employeeNameItem, employeeNoItem, departmentIdItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
