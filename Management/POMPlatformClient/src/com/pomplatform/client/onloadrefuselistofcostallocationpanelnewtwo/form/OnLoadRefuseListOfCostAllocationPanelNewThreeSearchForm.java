package com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.datasource.CDOnLoadRefuseListOfCostAllocationPanelNewThree;

public class OnLoadRefuseListOfCostAllocationPanelNewThreeSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final TextItem statusItem;
	private final TextItem employeeIdItem;

	public OnLoadRefuseListOfCostAllocationPanelNewThreeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadRefuseListOfCostAllocationPanelNewThree.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		statusItem = new TextItem("status", "状态");
		employeeIdItem = new TextItem("employeeId", "创建人");

		setItems(processTypeItem, statusItem, employeeIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
