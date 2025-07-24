package com.pomplatform.client.bonuspayment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.bonuspayment.datasource.CDMemployeeaccountrecordeeeor;

public class MemployeeaccountrecordeeeorSearchForm extends SearchForm
{


	private final TextItem employeeIdItem;

	public MemployeeaccountrecordeeeorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMemployeeaccountrecordeeeor.getInstance());
		employeeIdItem = new TextItem("employeeId", "职员编码");

		setItems(employeeIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
