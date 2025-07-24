package com.pomplatform.client.revenuevoucher.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.revenuevoucher.datasource.CDMprojectcrymor;

public class MprojectcrymorSearchForm extends SearchForm
{


	private final TextItem yearItem;
	private final TextItem monthItem;

	public MprojectcrymorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMprojectcrymor.getInstance());
		yearItem = new TextItem("year", "年份");
		monthItem = new TextItem("month", "月份");

		setItems(yearItem, monthItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
