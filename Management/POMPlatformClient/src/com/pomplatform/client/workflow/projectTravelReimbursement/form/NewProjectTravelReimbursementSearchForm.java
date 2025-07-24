package com.pomplatform.client.workflow.projectTravelReimbursement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.projectTravelReimbursement.datasource.CDNewProjectTravelReimbursement;

public class NewProjectTravelReimbursementSearchForm extends SearchForm
{


	private final TextItem travelReimbursementIdItem;

	public NewProjectTravelReimbursementSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDNewProjectTravelReimbursement.getInstance());
		travelReimbursementIdItem = new TextItem("travelReimbursementId", "差旅报销编码");

		setItems(travelReimbursementIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
