package com.pomplatform.client.project.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.project.datasource.CDOnLoadProjectStageSettlement2;

public class OnLoadProjectStageSettlement2SearchForm extends SearchForm
{


	private final TextItem projectIdItem;
	private final TextItem stageIdItem;
	private final TextItem checkEmployeeIdItem;

	public OnLoadProjectStageSettlement2SearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadProjectStageSettlement2.getInstance());
		projectIdItem = new TextItem("projectId", "项目id");
		stageIdItem = new TextItem("stageId", "阶段代码");
		checkEmployeeIdItem = new TextItem("checkEmployeeId", "审核人id");

		setItems(projectIdItem, stageIdItem, checkEmployeeIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
