package com.pomplatform.client.trainingmanagement.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.trainingmanagement.datasource.CDEmployeeItegral;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class EmployeeItegralSearchForm extends SearchForm
{


	private final TextItem selectYearItem;
	private final ComboBoxItem employeeIdItem;
	private final PickTreeItem departmentIdItem;

	public EmployeeItegralSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeItegral.getInstance());
		selectYearItem = new TextItem("selectYear", "年份");
		selectYearItem.setWidth("*");
		employeeIdItem = new ComboBoxItem("employeeId", "签到人编码");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		departmentIdItem = new PickTreeItem("departmentId", "部门编码");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments", "0"));

		setItems(selectYearItem, employeeIdItem, departmentIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
