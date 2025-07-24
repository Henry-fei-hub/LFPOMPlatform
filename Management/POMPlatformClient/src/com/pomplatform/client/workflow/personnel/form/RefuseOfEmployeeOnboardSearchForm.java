package com.pomplatform.client.workflow.personnel.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.personnel.datasource.CDRefuseOfEmployeeOnboard;

public class RefuseOfEmployeeOnboardSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final TextItem processStatusItem;
	private final SelectItem ownedCompanyItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final IPickTreeItem departmentIdItem;
	private final SelectItem statusItem;
	
	public RefuseOfEmployeeOnboardSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDRefuseOfEmployeeOnboard.getInstance());
		
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.setHidden(true);
		
		processStatusItem = new TextItem("processStatus", "流程状态");
		processStatusItem.setHidden(true);
		
		ownedCompanyItem = new SelectItem("ownedCompany", "所属公司");
		ownedCompanyItem.setWidth("*");
		ownedCompanyItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setHidden(true);
		
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		
		statusItem = new SelectItem("status", "流程状态");
		statusItem.setWidth("*");
		statusItem.setValueMap(KeyValueManager.getValueMap("process_status2"));

		setItems(statusItem,processTypeItem, processStatusItem, ownedCompanyItem, departmentIdItem, employeeNameItem, employeeNoItem);

		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
