package com.pomplatform.client.workflow.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDEmployeeContractAuditOfWorkflow;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class EmployeeContractAuditOfWorkflowSearchForm extends SearchForm
{


	private final ComboBoxItem employeeIdItem;
	private final SelectItem statusItem;
	private final ComboBoxItem employeeNameItem;

	public EmployeeContractAuditOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeContractAuditOfWorkflow.getInstance());
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
		employeeIdItem.setWidth("*");
		KeyValueManager.loadValueMap("employees",employeeIdItem);
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setHidden(false);

		statusItem = new SelectItem("employee_status", "状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));
		statusItem.setHidden(true);
		statusItem.setWidth("*");
		statusItem.setHidden(true);

		employeeNameItem = new ComboBoxItem("employee_name", "员工姓名");
		employeeNameItem.setWidth("*");
		KeyValueManager.loadValueMap("employees",employeeNameItem);
		employeeNameItem.setChangeOnKeypress(false);
		employeeNameItem.setHidden(true);
		setItems(employeeIdItem, statusItem ,employeeNameItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
