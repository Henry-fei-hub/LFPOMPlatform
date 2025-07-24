package com.pomplatform.client.workflow.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDNormalReimbursementsApplyOfWorkflow;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class NormalReimbursementsApplyOfWorkflowSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final SelectItem employeeIdItem;
	private final ComboBoxItem companyIdItem;
	private final CheckboxItem isProjectItem;
	private final IPickTreeItem departmentIdItem;
	private final TextItem codeItem;
	private final TextItem reimbursementNameItem;

	public NormalReimbursementsApplyOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDNormalReimbursementsApplyOfWorkflow.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		employeeIdItem = new SelectItem("employeeId", "报销人");
		employeeIdItem.hide();
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		isProjectItem = new CheckboxItem("isProject", "是否是项目上的报销，默认false");
		isProjectItem.hide();
		departmentIdItem = new IPickTreeItem("departmentId", "归属部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		codeItem = new TextItem("code", "编号");
		codeItem.setWidth("*");
		reimbursementNameItem = new TextItem("reimbursementName" , "报销主题");
		reimbursementNameItem.setWidth("*");

		setItems(processTypeItem, employeeIdItem, companyIdItem, isProjectItem, departmentIdItem, codeItem , reimbursementNameItem);

		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
