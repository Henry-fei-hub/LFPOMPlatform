package com.pomplatform.client.totaltrainingmanagement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.totaltrainingmanagement.datasource.CDTotalTrainingManagement;

public class TotalTrainingManagementSearchForm extends SearchForm
{


	private final IPickTreeItem departmentIdItem;
	private final SelectItem yearItem;

	public TotalTrainingManagementSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDTotalTrainingManagement.getInstance());
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setValueField("treeId");
		
		
		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		
		setItems(departmentIdItem, yearItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
