package com.pomplatform.client.projectappendintegralrecordpor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectappendintegralrecordpor.datasource.CDSprojectappendintegralrecordpor;

public class SprojectappendintegralrecordporSearchForm extends SearchForm
{


	private final SelectItem projectIdItem;

	public SprojectappendintegralrecordporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSprojectappendintegralrecordpor.getInstance());
		projectIdItem = new SelectItem("projectId", "项目编码");
		KeyValueManager.loadValueMap("projects",projectIdItem);

		setItems(projectIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
