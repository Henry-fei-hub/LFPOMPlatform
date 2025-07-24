package com.pomplatform.client.selectgrid.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.selectgrid.datasource.CDSelectGridPreProjectValue;

public class SelectGridPreProjectValueSearchForm extends SearchForm
{


	private final TextItem projectNameItem;
	private final TextItem customNumberItem;
	private final TextItem remarkItem;
	private final TextItem plateIdItem;
	private final TextItem preProjectReimbursementNumberIdItem;

	public SelectGridPreProjectValueSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSelectGridPreProjectValue.getInstance());
		projectNameItem = new TextItem("projectName", "项目名称");
		customNumberItem = new TextItem("customNumber", "前期项目信息编号");
		remarkItem = new TextItem("remark", "备注");
		plateIdItem = new TextItem("plateId", "板块");
		preProjectReimbursementNumberIdItem = new TextItem("preProjectReimbursementNumberId", "主键编码");

		setItems(projectNameItem, customNumberItem, remarkItem, plateIdItem, preProjectReimbursementNumberIdItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
