package com.pomplatform.client.projectcostlist.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectcostlist.datasource.CDProjectCostList;

public class ProjectCostListSearchForm extends SearchForm
{


	private final SelectItem statusItem;
	private final SelectItem costTypeItem;

	public ProjectCostListSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDProjectCostList.getInstance());
		statusItem = new SelectItem("status", "结算状态");
                statusItem.setWidth("*");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));
		costTypeItem = new SelectItem("costType", "费用类型");
                costTypeItem.setWidth("*");
		costTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_9"));

		setItems(statusItem, costTypeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
