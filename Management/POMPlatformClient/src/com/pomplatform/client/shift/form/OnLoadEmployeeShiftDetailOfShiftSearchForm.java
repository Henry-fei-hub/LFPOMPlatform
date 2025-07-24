package com.pomplatform.client.shift.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class OnLoadEmployeeShiftDetailOfShiftSearchForm extends SearchForm
{


	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final IPickTreeItem departmentIdItem;
	private final SelectItem genderItem;

	public OnLoadEmployeeShiftDetailOfShiftSearchForm() {
		setWidth100();
		setHeight100();
		startDateItem = new DateItem("startDate", "记录日期");
		startDateItem.hide();
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateItem("endDate", "记录日期");
		endDateItem.hide();
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		genderItem = new SelectItem("gender", "性别");
		genderItem.setWidth("*");
		genderItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));

		setItems(startDateItem, endDateItem, employeeNoItem, employeeNameItem, departmentIdItem, genderItem);

		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
