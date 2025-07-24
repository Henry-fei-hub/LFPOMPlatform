package com.pomplatform.client.workflow.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDTravelReimbursementsAuditOfWorkflow;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class TravelReimbursementsAuditOfWorkflowSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final SelectItem statusItem;
	private final ComboBoxItem drafterItem;
	private final ComboBoxItem companyIdItem;
	private final IPickTreeItem departmentIdItem;
	private final TextItem codeItem;

	public TravelReimbursementsAuditOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDTravelReimbursementsAuditOfWorkflow.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		statusItem = new SelectItem("status", "状态");
		statusItem.hide();
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));

		drafterItem = new ComboBoxItem("drafter", "发起人");
		drafterItem.setWidth("*");
		drafterItem.setChangeOnKeypress(false);
		drafterItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		drafterItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
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

		setItems(processTypeItem, statusItem, drafterItem, companyIdItem, departmentIdItem, codeItem);

		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
