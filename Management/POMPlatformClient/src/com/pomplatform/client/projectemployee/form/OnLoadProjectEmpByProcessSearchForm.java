package com.pomplatform.client.projectemployee.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectemployee.datasource.CDOnLoadProjectEmpByProcess;

public class OnLoadProjectEmpByProcessSearchForm extends SearchForm
{


	private final TextItem businessIdItem;
	private final TextItem processStatusItem;

	public OnLoadProjectEmpByProcessSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadProjectEmpByProcess.getInstance());
		businessIdItem = new TextItem("businessId", "业务编码");
		processStatusItem = new TextItem("processStatus", "流程状态 0 发起中  1");

		setItems(businessIdItem, processStatusItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
