package com.pomplatform.client.shift.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.shift.datasource.CDSshiftmanagesor;

public class SshiftmanagesorSearchForm extends SearchForm
{


	private final TextItem shiftNameItem;

	public SshiftmanagesorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSshiftmanagesor.getInstance());
		shiftNameItem = new TextItem("shiftName", "班次名称");
		shiftNameItem.setWidth(500);
		setItems(shiftNameItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
