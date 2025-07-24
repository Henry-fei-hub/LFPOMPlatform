package com.pomplatform.client.reimbursementpackage.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.reimbursementpackage.datasource.CDNewReimbursementPackage;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class NewReimbursementPackageSearchForm extends SearchForm
{


	private final SelectItem processTypeItem;
	private final SelectItem employeeIdItem;
	private final SelectItem companyIdItem;
	private final IPickTreeItem departmentIdItem;
	private final TextItem codeItem;

	public NewReimbursementPackageSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDNewReimbursementPackage.getInstance());
		
		processTypeItem = new SelectItem("processType", "流程类型");
		processTypeItem.setWidth("*");
		processTypeItem.setValueMap(KeyValueManager.getValueMap("system_process_types"));
		
		employeeIdItem = new SelectItem("employeeId", "处理人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.hide();
		
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setWidth("*");
		
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setWidth("*");
		
		codeItem = new TextItem("code", "编号");
		codeItem.setWidth("*");

		setItems(processTypeItem, employeeIdItem, companyIdItem, departmentIdItem, codeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
