package com.pomplatform.client.projectattachment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectattachment.datasource.CDSprojectattachmentpor;

public class SprojectattachmentporSearchForm extends SearchForm
{


	private final TextItem projectIdItem;

	public SprojectattachmentporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSprojectattachmentpor.getInstance());
		projectIdItem = new TextItem("projectId", "项目编码");
		projectIdItem.setWidth("*");

		setItems(projectIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
