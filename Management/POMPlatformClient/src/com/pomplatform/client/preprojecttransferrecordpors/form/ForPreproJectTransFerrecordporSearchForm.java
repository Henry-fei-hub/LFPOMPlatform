package com.pomplatform.client.preprojecttransferrecordpors.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.preprojecttransferrecordpors.datasource.CDForPreproJectTransFerrecordpor;

public class ForPreproJectTransFerrecordporSearchForm extends SearchForm
{


	private final TextItem preProjectIdItem;
	private final TextItem employeeIdItem;

	public ForPreproJectTransFerrecordporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDForPreproJectTransFerrecordpor.getInstance());
		preProjectIdItem = new TextItem("preProjectId", "项目id");
		employeeIdItem = new TextItem("employeeId", "原报备人");

		setItems(preProjectIdItem, employeeIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
