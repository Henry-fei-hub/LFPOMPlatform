package com.pomplatform.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.specialdeduction.datasource.CDSspecialdeductionmonthdetailedpor;

public class SspecialdeductionmonthdetailedporSearchForm extends SearchForm
{


	private final ComboBoxItem employeeIdItem;
	private final PickTreeItem departmentIdItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final TextItem employeeNoItem;

	public SspecialdeductionmonthdetailedporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSspecialdeductionmonthdetailedpor.getInstance());
		employeeIdItem = new ComboBoxItem("employeeId", "职员");
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));	
		
		employeeNoItem = new TextItem("employeeNo", "职员编号");
		employeeNoItem.setWidth("*");
		
		departmentIdItem = new PickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments", "0"));	
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setChangeOnKeypress(false);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		
		Date d = new Date();
		yearItem = new SelectItem("year", "年份");
		yearItem.setValue(d.getYear()+1900);
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		monthItem = new SelectItem("month", "月份");
		monthItem.setWidth("*");
		monthItem.setValue(d.getMonth() + 1);
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));


		setItems(employeeIdItem, employeeNoItem, departmentIdItem, plateIdItem, yearItem, monthItem);

		setNumCols(13);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
