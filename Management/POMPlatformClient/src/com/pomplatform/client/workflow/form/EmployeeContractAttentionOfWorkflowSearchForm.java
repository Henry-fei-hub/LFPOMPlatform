package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDEmployeeContractAttentionOfWorkflow;

public class EmployeeContractAttentionOfWorkflowSearchForm extends SearchForm
{


	private final TextItem statusItem;
	private final ComboBoxItem employeeIdItem;

	public EmployeeContractAttentionOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeContractAttentionOfWorkflow.getInstance());
		statusItem = new TextItem("status", "状态");
		statusItem.setHidden(true);
		statusItem.setWidth("*");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_61"));
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		setItems(statusItem, employeeIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
