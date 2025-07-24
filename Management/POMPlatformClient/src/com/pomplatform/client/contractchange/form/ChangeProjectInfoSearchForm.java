package com.pomplatform.client.contractchange.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contractchange.datasource.CDChangeProjectInfo;

public class ChangeProjectInfoSearchForm extends SearchForm
{


	private final SelectItem projectIdItem;
	private final TextItem flagItem;

	public ChangeProjectInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDChangeProjectInfo.getInstance());
		projectIdItem = new SelectItem("projectId", "项目编码");
//		KeyValueManager.loadValueMap("projects",projectIdItem);
		KeyValueManager.loadValueMap("projects",projectIdItem);
		flagItem = new TextItem("flag", "状态");

		setItems(projectIdItem, flagItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
