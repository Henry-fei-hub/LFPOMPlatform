package com.pomplatform.client.tablemaintain.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.tablemaintain.datasource.CDTableMaintain;

public class TableMaintainSearchForm extends SearchForm
{


	private final TextItem tableNameItem;
	private final TextItem remarkItem;

	public TableMaintainSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDTableMaintain.getInstance());

		tableNameItem = new TextItem("tableName", "表名称");
		tableNameItem.setWidth("*");

		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");

		setItems(tableNameItem, remarkItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
