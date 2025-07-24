package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.personnelbusiness.datasource.CDCheckWorkHandover;

public class CheckWorkHandoverSearchForm extends SearchForm
{


	private final TextItem typeItem;
	private final TextItem linkIdItem;
	private final TextItem fromEmployeeIdItem;
	private final TextItem toEmployeeIdItem;

	public CheckWorkHandoverSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCheckWorkHandover.getInstance());
		typeItem = new TextItem("type", "工作交接类型  1离职   2转岗");
		linkIdItem = new TextItem("linkId", "关联编码");
		fromEmployeeIdItem = new TextItem("fromEmployeeId", "交接者");
		toEmployeeIdItem = new TextItem("toEmployeeId", "被交接者");

		setItems(typeItem, linkIdItem, fromEmployeeIdItem, toEmployeeIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
