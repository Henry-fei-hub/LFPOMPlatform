package com.pomplatform.client.role.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.role.datasource.CDSfunctionffor;

public class SfunctionfforSearchForm extends SearchForm
{


	private final TextItem functionNameItem;
	private final TextItem functionCodeItem;

	public SfunctionfforSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSfunctionffor.getInstance());
		functionNameItem = new TextItem("functionName", "功能名称");
		functionNameItem.setWidth("*");
		functionCodeItem = new TextItem("functionCode", "功能编号");
		functionCodeItem.setWidth("*");

		setItems(functionNameItem, functionCodeItem);

		setNumCols(2);
	}

}
