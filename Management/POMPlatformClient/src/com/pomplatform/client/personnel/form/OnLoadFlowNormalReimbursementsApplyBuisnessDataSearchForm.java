package com.pomplatform.client.personnel.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.personnel.datasource.CDOnLoadFlowNormalReimbursementsApplyBuisnessData;
import com.pomplatform.client.workflow.datasource.CDNormalReimbursementsAuditOfWorkflow;

public class OnLoadFlowNormalReimbursementsApplyBuisnessDataSearchForm extends SearchForm
{


	private final TextItem employeeIdItem;
	private final TextItem processTypeItem;
	private final SelectItem statusItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final ComboBoxItem companyIdItem;
	private final IPickTreeItem departmentIdItem;
	private final TextItem codeItem;
	private final ComboBoxItem applyEmployeeIdItem;

	public OnLoadFlowNormalReimbursementsApplyBuisnessDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDNormalReimbursementsAuditOfWorkflow.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		statusItem = new SelectItem("status", "状态");
		statusItem.setWidth("*");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_38"));
		
		applyEmployeeIdItem = new ComboBoxItem("applyEmployeeId", "发起人");
		applyEmployeeIdItem.setWidth("*");
		applyEmployeeIdItem.setChangeOnKeypress(false);
		applyEmployeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		applyEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		
		departmentIdItem = new IPickTreeItem("departmentId", "归属部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		
		codeItem = new TextItem("code", "编号");
		codeItem.setWidth("*");
		
		employeeIdItem = new ComboBoxItem("employeeId", "员工id");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.hide();
		employeeNameItem = new TextItem("employeeName", "职员名字");
		employeeNameItem.setWidth("*");
		employeeNameItem.hide();
		
		employeeNoItem = new TextItem("employeeNo", "职员编号");
		employeeNoItem.setWidth("*");
		employeeNoItem.hide();

		setItems(processTypeItem, statusItem, applyEmployeeIdItem, companyIdItem, departmentIdItem,employeeIdItem, codeItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
