package com.pomplatform.client.settle.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.settle.datasource.CDSprojectsettlementpor;

public class SprojectsettlementporSearchForm extends SearchForm
{


	private final SelectItem projectIdItem;

	public SprojectsettlementporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSprojectsettlementpor.getInstance());
		projectIdItem = new SelectItem("projectId", "项目代码");
//		KeyValueManager.loadValueMap("projects",projectIdItem);
		KeyValueManager.loadValueMap("projects",projectIdItem);
		setItems(projectIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
