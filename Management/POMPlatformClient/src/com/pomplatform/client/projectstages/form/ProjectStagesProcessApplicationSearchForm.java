package com.pomplatform.client.projectstages.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectstages.datasource.CDProjectStagesProcessApplication;

public class ProjectStagesProcessApplicationSearchForm extends SearchForm
{


	private final TextItem projectStageProcessRecordIdItem;
	private final TextItem contractIdItem;

	public ProjectStagesProcessApplicationSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDProjectStagesProcessApplication.getInstance());
		projectStageProcessRecordIdItem = new TextItem("projectStageProcessRecordId", "id");
		contractIdItem = new TextItem("contractId", "contract_id");

		setItems(projectStageProcessRecordIdItem, contractIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
