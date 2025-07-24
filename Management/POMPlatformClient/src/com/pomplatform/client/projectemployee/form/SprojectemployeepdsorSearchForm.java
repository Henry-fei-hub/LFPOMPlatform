package com.pomplatform.client.projectemployee.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectemployee.datasource.CDSprojectemployeepdsor;

public class SprojectemployeepdsorSearchForm extends SearchForm
{


	private final TextItem projectIdItem;
	private final SelectItem designPhaseItem;
	private final SelectItem statusItem;

	public SprojectemployeepdsorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSprojectemployeepdsor.getInstance());
		projectIdItem = new TextItem("projectId", "项目编码");
		projectIdItem.setWidth("*");
		designPhaseItem = new SelectItem("designPhase", "设计阶段");
		designPhaseItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));
		statusItem = new SelectItem("status", "状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_5"));

		setItems(projectIdItem, designPhaseItem, statusItem);

		setNumCols(2);
	}

}
