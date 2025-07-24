package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDEmployeeContractAttachment;

public class EmployeeContractAttachmentSearchForm extends SearchForm
{


	private final TextItem employeeIdItem;

	public EmployeeContractAttachmentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeContractAttachment.getInstance());
		employeeIdItem = new TextItem("employeeId", "员工id");

		setItems(employeeIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
