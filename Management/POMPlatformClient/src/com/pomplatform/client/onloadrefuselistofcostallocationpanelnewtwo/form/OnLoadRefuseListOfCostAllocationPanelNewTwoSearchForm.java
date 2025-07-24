package com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.datasource.CDOnLoadRefuseListOfCostAllocationPanelNewTwo;

public class OnLoadRefuseListOfCostAllocationPanelNewTwoSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final TextItem employeeIdItem;
	private final TextItem processStatusItem;

	public OnLoadRefuseListOfCostAllocationPanelNewTwoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadRefuseListOfCostAllocationPanelNewTwo.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		employeeIdItem = new TextItem("employeeId", "创建人");
		processStatusItem = new TextItem("processStatus", "流程状态");

		setItems(processTypeItem, employeeIdItem, processStatusItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
