package com.pomplatform.client.sprojectemployeeadvancerecordpor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sprojectemployeeadvancerecordpor.datasource.CDSProjectEmployeeAdvanceRecordpor;

public class SProjectEmployeeAdvanceRecordporSearchForm extends SearchForm
{


	private final SelectItem projectIdItem;

	public SProjectEmployeeAdvanceRecordporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSProjectEmployeeAdvanceRecordpor.getInstance());
		projectIdItem = new SelectItem("projectId", "补贴项目");
		KeyValueManager.loadValueMap("projects",projectIdItem);

		setItems(projectIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
