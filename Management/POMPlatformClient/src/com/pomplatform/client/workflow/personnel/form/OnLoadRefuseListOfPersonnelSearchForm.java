package com.pomplatform.client.workflow.personnel.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.personnel.datasource.CDOnLoadRefuseListOfPersonnel;

public class OnLoadRefuseListOfPersonnelSearchForm extends SearchForm
{


	private final SelectItem processTypeItem;
	private final SelectItem statusItem;
	private final SelectItem employeeIdItem;
	private final SelectItem companyIdItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final IPickTreeItem departmentIdItem;

	public OnLoadRefuseListOfPersonnelSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadRefuseListOfPersonnel.getInstance());
		processTypeItem = new SelectItem("processType", "流程类型");
		processTypeItem.hide();;
		statusItem = new SelectItem("status", "流程状态");
		statusItem.setWidth("*");
		statusItem.setValueMap(KeyValueManager.getValueMap("process_status2"));
		employeeIdItem = new SelectItem("employeeId", "申请人");
		employeeIdItem.hide();;
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.hide();;
		employeeNameItem = new TextItem("employeeNameItem", "职员名字");
		employeeNameItem.setWidth("*");
		employeeNoItem = new TextItem("employeeNo", "职员编号");
		employeeNoItem.setWidth("*");
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		

		setItems(processTypeItem, statusItem, employeeIdItem, companyIdItem, employeeNameItem, employeeNoItem, departmentIdItem);

		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
