package com.pomplatform.client.designer.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.designer.datasource.CDMprojectemployeepor;

public class MprojectemployeeporSearchForm extends SearchForm
{


	private final TextItem employeeIdItem;

	public MprojectemployeeporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMprojectemployeepor.getInstance());
		employeeIdItem = new TextItem("employeeId", "员工编码");
		employeeIdItem.setWidth("*");

		setItems(employeeIdItem);

		setNumCols(4);
	}

}
