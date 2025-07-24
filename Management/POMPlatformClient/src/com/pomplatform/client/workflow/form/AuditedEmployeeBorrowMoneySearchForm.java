package com.pomplatform.client.workflow.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDAuditedEmployeeBorrowMoney;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class AuditedEmployeeBorrowMoneySearchForm extends SearchForm
{


	private final SelectItem statusItem;
	private final ComboBoxItem drafterItem;
	private final ComboBoxItem companyIdItem;
	private final IPickTreeItem departmentIdItem;
	private final TextItem codeItem;

	public AuditedEmployeeBorrowMoneySearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAuditedEmployeeBorrowMoney.getInstance());
		statusItem = new SelectItem("status", "状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_38"));
		statusItem.setWidth("*");
		
		drafterItem = new ComboBoxItem("drafter", "发起人");
		drafterItem.setChangeOnKeypress(false);
		drafterItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		drafterItem.setValueMap(KeyValueManager.getValueMap("employees"));
		drafterItem.setWidth("*");
		
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

		setItems(drafterItem, companyIdItem, departmentIdItem, codeItem, statusItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
