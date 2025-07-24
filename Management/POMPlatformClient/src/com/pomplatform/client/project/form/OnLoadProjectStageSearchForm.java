package com.pomplatform.client.project.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.project.datasource.CDOnLoadProjectStage;

public class OnLoadProjectStageSearchForm extends SearchForm
{


	private final TextItem projectIdItem;
	private final TextItem checkEmployeeIdItem;

	public OnLoadProjectStageSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadProjectStage.getInstance());
		projectIdItem = new TextItem("projectId", "项目id");
		checkEmployeeIdItem = new TextItem("checkEmployeeId", "审核人id");

		setItems(projectIdItem, checkEmployeeIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
