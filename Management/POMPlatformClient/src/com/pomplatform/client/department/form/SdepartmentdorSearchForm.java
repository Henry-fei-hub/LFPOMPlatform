package com.pomplatform.client.department.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.department.datasource.CDSdepartmentdor;

public class SdepartmentdorSearchForm extends SearchForm
{


	private final TextItem departmentNameItem;

	public SdepartmentdorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSdepartmentdor.getInstance());
		departmentNameItem = new TextItem("departmentName", "部门名称");
		departmentNameItem.setWidth("*");

		setItems(departmentNameItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
