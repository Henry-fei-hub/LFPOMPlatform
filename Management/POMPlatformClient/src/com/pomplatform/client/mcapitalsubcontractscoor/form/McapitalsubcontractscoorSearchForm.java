package com.pomplatform.client.mcapitalsubcontractscoor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.mcapitalsubcontractscoor.datasource.CDMcapitalsubcontractscoor;

public class McapitalsubcontractscoorSearchForm extends SearchForm
{


	private final TextItem capitalIdItem;
	private final TextItem operatorIdItem;

	public McapitalsubcontractscoorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcapitalsubcontractscoor.getInstance());
		capitalIdItem = new TextItem("capitalId", "回款编码");
		operatorIdItem = new TextItem("operatorId", "操作人");

		setItems(capitalIdItem, operatorIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
