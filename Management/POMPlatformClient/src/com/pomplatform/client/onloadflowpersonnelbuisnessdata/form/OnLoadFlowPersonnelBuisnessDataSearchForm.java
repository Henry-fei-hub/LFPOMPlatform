package com.pomplatform.client.onloadflowpersonnelbuisnessdata.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.onloadflowpersonnelbuisnessdata.datasource.CDOnLoadFlowPersonnelBuisnessData;

public class OnLoadFlowPersonnelBuisnessDataSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final SelectItem statusItem;
	private final SelectItem companyIdItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final IPickTreeItem departmentIdItem;

	public OnLoadFlowPersonnelBuisnessDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadFlowPersonnelBuisnessData.getInstance());
		statusItem = new SelectItem("status", "状态");
		statusItem.setHidden(true);
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_61"));
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.setWidth("*");
		processTypeItem.hide();
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.hide();
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		employeeNameItem = new TextItem("employeeName", "职员姓名");
		employeeNameItem.setWidth("*");
		employeeNoItem = new TextItem("employeeNo", "职员编号");
		employeeNoItem.setWidth("*");
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.hide();

		setItems(statusItem,processTypeItem, companyIdItem, employeeNameItem, employeeNoItem, departmentIdItem);

		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
