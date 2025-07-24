package com.pomplatform.client.projectteambuild.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectteambuild.datasource.CDProjectEmployeePlanIntegralProgress;

public class ProjectEmployeePlanIntegralProgressSearchForm extends SearchForm
{


	private final SelectItem projectIdItem;

	public ProjectEmployeePlanIntegralProgressSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDProjectEmployeePlanIntegralProgress.getInstance());
		projectIdItem = new SelectItem("projectId", "项目");
		projectIdItem.setWidth("*");
		projectIdItem.setValueMap(KeyValueManager.getValueMap("projects"));
		projectIdItem.hide();
		setItems(projectIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
