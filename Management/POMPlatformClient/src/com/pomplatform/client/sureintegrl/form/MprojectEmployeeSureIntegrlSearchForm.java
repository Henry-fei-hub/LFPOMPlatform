package com.pomplatform.client.sureintegrl.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sureintegrl.datasource.CDMprojectEmployeeSureIntegrl;

public class MprojectEmployeeSureIntegrlSearchForm extends SearchForm
{


	private final TextItem stageIdItem;
	private final SelectItem projectIdItem;

	public MprojectEmployeeSureIntegrlSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMprojectEmployeeSureIntegrl.getInstance());
		stageIdItem = new TextItem("stageId", "项目阶段");
		stageIdItem.setWidth("*");
		projectIdItem = new SelectItem("projectId", "项目编码");
//		KeyValueManager.loadValueMap("projects",projectIdItem);
		KeyValueManager.loadValueMap("projects",projectIdItem);
		setItems(stageIdItem, projectIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
