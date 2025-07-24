package com.pomplatform.client.payment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.payment.datasource.CDOnloadEmployeePaymentMonthDetail;

public class OnloadEmployeePaymentMonthDetailSearchForm extends SearchForm
{


	private final ComboBoxItem employeeIdItem;
	private final TextItem yearItem;
	private final TextItem monthItem;
	private final TextItem employeeNoItem;
	private final IPickTreeItem departmentIdItem;
	private final ComboBoxItem plateIdItem;

	public OnloadEmployeePaymentMonthDetailSearchForm() {
		setWidth100();
		setHeight100();
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		yearItem = new TextItem("year", "年份");
		yearItem.setHidden(false);
		yearItem.setWidth("*");
		monthItem = new TextItem("month", "月份");
		monthItem.setHidden(false);
		monthItem.setWidth("*");
		
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		
		departmentIdItem = new IPickTreeItem("departmentId", "所属部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setValueField("treeId");
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	

		setItems(employeeIdItem, employeeNoItem, departmentIdItem, plateIdItem, yearItem, monthItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
