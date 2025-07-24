package com.pomplatform.client.project.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.project.datasource.CDOnLoadProjectOverview;

public class OnLoadProjectOverviewSearchForm extends SearchForm
{


	private final TextItem contractIdItem;
	private final TextItem projectIdItem;

	public OnLoadProjectOverviewSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadProjectOverview.getInstance());
		contractIdItem = new TextItem("contractId", "合同id");
		projectIdItem = new TextItem("projectId", "项目编码");

		setItems(contractIdItem, projectIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
