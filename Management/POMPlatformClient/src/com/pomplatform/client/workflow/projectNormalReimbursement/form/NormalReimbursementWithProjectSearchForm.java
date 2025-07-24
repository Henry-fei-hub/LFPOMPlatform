package com.pomplatform.client.workflow.projectNormalReimbursement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.projectNormalReimbursement.datasource.CDNormalReimbursementWithProject;

public class NormalReimbursementWithProjectSearchForm extends SearchForm
{


	private final TextItem projectNormalReimbursementIdItem;

	public NormalReimbursementWithProjectSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDNormalReimbursementWithProject.getInstance());
		projectNormalReimbursementIdItem = new TextItem("projectNormalReimbursementId", "主键编码");

		setItems(projectNormalReimbursementIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
