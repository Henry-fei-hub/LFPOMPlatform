package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.personnelbusiness.datasource.CDReturnOfItems;

public class ReturnOfItemsSearchForm extends SearchForm
{


	private final TextItem personnelBusinessIdItem;

	public ReturnOfItemsSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReturnOfItems.getInstance());
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "人事业务编码");

		setItems(personnelBusinessIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
