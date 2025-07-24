package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDProjectEmployeeProcessApplication;

public class ProjectEmployeeProcessApplicationSearchForm extends SearchForm
{


	private final TextItem personnelBusinessIdItem;
	private final TextItem processTypeItem;

	public ProjectEmployeeProcessApplicationSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDProjectEmployeeProcessApplication.getInstance());
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "人事业务编码");
		processTypeItem = new TextItem("processType", "类型 13请假  14出差  15打卡  16外出  17加班");

		setItems(personnelBusinessIdItem, processTypeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
