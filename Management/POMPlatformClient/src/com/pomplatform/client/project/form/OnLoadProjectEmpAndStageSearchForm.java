package com.pomplatform.client.project.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.project.datasource.CDOnLoadProjectEmpAndStage;

public class OnLoadProjectEmpAndStageSearchForm extends SearchForm
{


	private final TextItem projectIdItem;
	private final TextItem employeeIdItem;

	public OnLoadProjectEmpAndStageSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadProjectEmpAndStage.getInstance());
		projectIdItem = new TextItem("projectId", "项目编码");
		employeeIdItem = new TextItem("employeeId", "被审核人id");

		setItems(projectIdItem, employeeIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
