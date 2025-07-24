package com.pomplatform.client.projectsettlement.form;

import java.util.*;

import com.pomplatform.client.projectsettlement.datasource.CDProfessionalApprovalApplication;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;

public class ProfessionalApprovalApplicationSearchForm extends SearchForm
{


	private final TextItem professionalApproval_idItem;

	public ProfessionalApprovalApplicationSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDProfessionalApprovalApplication.getInstance());
		professionalApproval_idItem = new TextItem("professionalApproval_id", "专业负责人审批编码");

		setItems(professionalApproval_idItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
