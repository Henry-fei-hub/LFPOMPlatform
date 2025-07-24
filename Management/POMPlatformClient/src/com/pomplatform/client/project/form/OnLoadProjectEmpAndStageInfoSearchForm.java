package com.pomplatform.client.project.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.project.datasource.CDOnLoadProjectEmpAndStageInfo;

public class OnLoadProjectEmpAndStageInfoSearchForm extends SearchForm
{


	private final TextItem projectIdItem;

	public OnLoadProjectEmpAndStageInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadProjectEmpAndStageInfo.getInstance());
		projectIdItem = new TextItem("projectId", "项目编码");

		setItems(projectIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
