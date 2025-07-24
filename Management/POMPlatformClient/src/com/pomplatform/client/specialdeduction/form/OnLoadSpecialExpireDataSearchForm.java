package com.pomplatform.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.specialdeduction.datasource.CDOnLoadSpecialExpireData;

public class OnLoadSpecialExpireDataSearchForm extends SearchForm
{


	private final TextItem yearItem;
	private final TextItem employeIdItem;
	private final TextItem processStatusItem;
	private final TextItem monthItem;

	public OnLoadSpecialExpireDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadSpecialExpireData.getInstance());
		yearItem = new TextItem("year", "扣除年度");
		employeIdItem = new TextItem("employeId", "纳税人id");
		processStatusItem = new TextItem("processStatus", "流程状态 0 发起中  1");
		monthItem = new TextItem("month", "月份");

		setItems(yearItem, employeIdItem, processStatusItem, monthItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
