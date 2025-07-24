package com.pomplatform.client.preprojectnormalreimbursement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.preprojectnormalreimbursement.datasource.CDPreProjectNormalReimbursement;

public class PreProjectNormalReimbursementSearchForm extends SearchForm
{


	private final SelectItem processInstanceIdItem;
	private final TextItem applyEmployeeIdItem;
	private final SelectItem employeeIdItem;
	private final SelectItem departmentIdItem;
	private final TextItem reimbursementNameItem;
	private final SelectItem statusItem;
	private final TextItem amountItem;
	private final TextItem remarkItem;
	private final TextItem codeItem;

	public PreProjectNormalReimbursementSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPreProjectNormalReimbursement.getInstance());
		processInstanceIdItem = new SelectItem("processInstanceId", "流程编码");
		processInstanceIdItem.setValueMap((LinkedHashMap)getDataSource().getField("processInstanceId").getValueMap());
		applyEmployeeIdItem = new TextItem("applyEmployeeId", "起草人");
		employeeIdItem = new SelectItem("employeeId", "报销人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		departmentIdItem = new SelectItem("departmentId", "报销部门");
		departmentIdItem.setValueMap((LinkedHashMap)getDataSource().getField("departmentId").getValueMap());
		reimbursementNameItem = new TextItem("reimbursementName", "主题");
		statusItem = new SelectItem("status", "状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_61"));
		amountItem = new TextItem("amount", "报销总金额");
		remarkItem = new TextItem("remark", "备注");
		codeItem = new TextItem("code", "报销编号");

		setItems(processInstanceIdItem, applyEmployeeIdItem, employeeIdItem, departmentIdItem, reimbursementNameItem, statusItem, amountItem, remarkItem, codeItem);

		setNumCols(18);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
