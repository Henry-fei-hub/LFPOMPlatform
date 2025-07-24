package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDSealApplication;

public class SealApplicationSearchForm extends SearchForm
{


	private final TextItem personnelBusinessIdItem;
	private final TextItem departmentIdItem;
	private final TextItem employeeIdItem;

	public SealApplicationSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSealApplication.getInstance());
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "人事业务编码");
		departmentIdItem = new TextItem("departmentId", "部门");
		employeeIdItem = new TextItem("employeeId", "申请人");

		setItems(personnelBusinessIdItem, departmentIdItem, employeeIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
