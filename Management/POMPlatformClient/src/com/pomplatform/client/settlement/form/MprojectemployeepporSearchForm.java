package com.pomplatform.client.settlement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.settlement.datasource.CDMprojectemployeeppor;

public class MprojectemployeepporSearchForm extends SearchForm
{


	private final SelectItem projectIdItem;

	public MprojectemployeepporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMprojectemployeeppor.getInstance());
		projectIdItem = new SelectItem("projectId", "项目编码");
//		KeyValueManager.loadValueMap("projects",projectIdItem);
		KeyValueManager.loadValueMap("projects",projectIdItem);

		setItems(projectIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
