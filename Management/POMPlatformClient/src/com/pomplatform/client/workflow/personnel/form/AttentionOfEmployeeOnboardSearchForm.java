package com.pomplatform.client.workflow.personnel.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.personnel.datasource.CDAttentionOfEmployeeOnboard;

public class AttentionOfEmployeeOnboardSearchForm extends SearchForm
{


	private final SelectItem statusItem;
	private final TextItem processTypeItem;
	private final SelectItem employeeIdItem;
	private final SelectItem ownedCompanyItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final IPickTreeItem departmentIdItem;

	public AttentionOfEmployeeOnboardSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAttentionOfEmployeeOnboard.getInstance());
		statusItem = new SelectItem("status", "状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_61"));
		statusItem.setHidden(true);
		
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.setHidden(true);
		
		employeeIdItem = new SelectItem("employeeId", "处理人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setHidden(true);
		
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
		
		
		setItems(statusItem, processTypeItem, employeeIdItem, ownedCompanyItem, departmentIdItem, employeeNameItem, employeeNoItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
