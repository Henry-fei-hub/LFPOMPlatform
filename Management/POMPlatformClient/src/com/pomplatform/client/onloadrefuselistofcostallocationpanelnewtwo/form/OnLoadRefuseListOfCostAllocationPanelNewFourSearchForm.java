package com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.datasource.CDOnLoadRefuseListOfCostAllocationPanelNewFour;

public class OnLoadRefuseListOfCostAllocationPanelNewFourSearchForm extends SearchForm
{


	private final TextItem statusItem;
	private final TextItem processTypeItem;
	private final TextItem employeeIdItem;

	public OnLoadRefuseListOfCostAllocationPanelNewFourSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadRefuseListOfCostAllocationPanelNewFour.getInstance());
		statusItem = new TextItem("status", "状态");
		processTypeItem = new TextItem("processType", "流程类型");
		employeeIdItem = new TextItem("employeeId", "创建人");

		setItems(statusItem, processTypeItem, employeeIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
