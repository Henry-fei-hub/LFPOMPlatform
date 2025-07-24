package com.pomplatform.client.employeemoneymanagespeemmepemmor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource.CDMemployeepsrreereeedpor;

public class MemployeepsrreereeedporSearchForm extends SearchForm {

	private final TextItem receiveUnitNameItem;
	private final ComboBoxItem employeeIdItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final PickTreeItem departmentIdItem;
	private final TextItem plateIdItem;

	public MemployeepsrreereeedporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMemployeepsrreereeedpor.getInstance());
		receiveUnitNameItem = new TextItem("receiveUnitName", "收款方");
		receiveUnitNameItem.hide();
		employeeIdItem = new ComboBoxItem("employeeId", "员工");
		employeeIdItem.setWidth("*");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.hide();
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setValueField("treeId");
		// departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		plateIdItem = new TextItem("plateId", "板块");
		plateIdItem.hide();

		setItems(receiveUnitNameItem, employeeIdItem, employeeNameItem, employeeNoItem, departmentIdItem, plateIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
