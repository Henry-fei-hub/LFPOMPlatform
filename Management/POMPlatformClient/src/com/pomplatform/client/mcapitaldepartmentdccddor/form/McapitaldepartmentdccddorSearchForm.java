package com.pomplatform.client.mcapitaldepartmentdccddor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.mcapitaldepartmentdccddor.datasource.CDMcapitaldepartmentdccddor;

public class McapitaldepartmentdccddorSearchForm extends SearchForm
{


	private final TextItem capitalDepartmentIdItem;
	private final TextItem capitalIdItem;
	private final TextItem departmentIdItem;
	private final TextItem departmentNameItem;

	public McapitaldepartmentdccddorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcapitaldepartmentdccddor.getInstance());
		capitalDepartmentIdItem = new TextItem("capitalDepartmentId", "主键");
		capitalIdItem = new TextItem("capitalId", "回款编码");
		departmentIdItem = new TextItem("departmentId", "部门编码");
		departmentNameItem = new TextItem("departmentName", "部门名称");

		setItems(capitalDepartmentIdItem, capitalIdItem, departmentIdItem, departmentNameItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
