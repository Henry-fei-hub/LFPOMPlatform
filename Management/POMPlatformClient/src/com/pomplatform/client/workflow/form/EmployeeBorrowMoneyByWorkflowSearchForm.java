package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDEmployeeBorrowMoneyByWorkflow;

public class EmployeeBorrowMoneyByWorkflowSearchForm extends SearchForm
{


	private final SelectItem employeeIdItem;

	public EmployeeBorrowMoneyByWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeBorrowMoneyByWorkflow.getInstance());
		employeeIdItem = new SelectItem("employeeId", "职员编码");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));

		setItems(employeeIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
