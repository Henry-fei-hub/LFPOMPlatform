package com.pomplatform.client.attachment.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadAttachmentDataOfAttachmentSearchForm extends SearchForm
{
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final ComboBoxItem employeeIdItem;
	private final SelectItem contractStatusItem;
	private final CheckboxItem checkAmountItem;
	public OnLoadAttachmentDataOfAttachmentSearchForm() {
		setWidth100();
		setHeight100();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		employeeIdItem = new ComboBoxItem("aliEmployeeId", "项目经理");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setWidth("*");
		
		contractStatusItem=new SelectItem("contractStatusM","合同状态");
		contractStatusItem.setMultiple(true);
		contractStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));
		contractStatusItem.setWidth("*");
		
		checkAmountItem = new CheckboxItem("checkAmount", "回款是否相等");
		checkAmountItem.setWidth("*");
		setItems(contractCodeItem, contractNameItem, employeeIdItem,contractStatusItem,checkAmountItem);
		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
