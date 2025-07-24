package com.pomplatform.client.abouttrainingmanagement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.abouttrainingmanagement.datasource.CDAboutTrainingManagement;

public class AboutTrainingManagementSearchForm extends SearchForm
{


	private final IPickTreeItem departmentIdItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;

	public AboutTrainingManagementSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAboutTrainingManagement.getInstance());
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setValueField("treeId");
		
		
		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		
		monthItem = new SelectItem("month", "月份");
		monthItem.setWidth("*");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		

		setItems(departmentIdItem, yearItem, monthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
