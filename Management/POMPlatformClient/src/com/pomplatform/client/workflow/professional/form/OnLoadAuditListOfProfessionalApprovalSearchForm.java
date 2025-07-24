package com.pomplatform.client.workflow.professional.form;

import java.util.*;

import com.pomplatform.client.workflow.professional.datasource.CDOnLoadAuditListOfProfessionalApproval;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;

public class OnLoadAuditListOfProfessionalApprovalSearchForm extends SearchForm
{


	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final IPickTreeItem departmentIdItem;

	public OnLoadAuditListOfProfessionalApprovalSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadAuditListOfProfessionalApproval.getInstance());
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		//employeeNoItem.setValueMap(KeyValueManager.getValueMap("employees"));
		departmentIdItem = new IPickTreeItem("departmentId", "专业负责人部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setValueField("treeId");

		setItems(employeeNameItem, employeeNoItem, departmentIdItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
