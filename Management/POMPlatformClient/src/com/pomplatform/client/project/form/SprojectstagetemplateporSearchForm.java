package com.pomplatform.client.project.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.project.datasource.CDSprojectstagetemplatepor;

public class SprojectstagetemplateporSearchForm extends SearchForm
{


	private final TextItem projectTemplateIdItem;

	public SprojectstagetemplateporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSprojectstagetemplatepor.getInstance());
		projectTemplateIdItem = new TextItem("projectTemplateId", "项目模板id （project_templates）");

		setItems(projectTemplateIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
