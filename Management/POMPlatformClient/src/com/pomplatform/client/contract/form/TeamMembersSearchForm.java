package com.pomplatform.client.contract.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contract.datasource.CDTeamMembers;

public class TeamMembersSearchForm extends SearchForm
{


	private final PickTreeItem departmentIdItem;
	private final TextItem employeeNameItem;

	public TeamMembersSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDTeamMembers.getInstance());
		departmentIdItem = new PickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments", ""));
		employeeNameItem = new TextItem("employeeName", "员工姓名");

		setItems(departmentIdItem, employeeNameItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
