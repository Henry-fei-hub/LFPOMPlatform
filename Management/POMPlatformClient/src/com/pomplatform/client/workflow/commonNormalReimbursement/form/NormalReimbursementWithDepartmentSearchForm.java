package com.pomplatform.client.workflow.commonNormalReimbursement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.commonNormalReimbursement.datasource.CDNormalReimbursementWithDepartment;

public class NormalReimbursementWithDepartmentSearchForm extends SearchForm
{


	private final TextItem projectNormalReimbursementIdItem;

	public NormalReimbursementWithDepartmentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDNormalReimbursementWithDepartment.getInstance());
		projectNormalReimbursementIdItem = new TextItem("projectNormalReimbursementId", "主键编码");

		setItems(projectNormalReimbursementIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
