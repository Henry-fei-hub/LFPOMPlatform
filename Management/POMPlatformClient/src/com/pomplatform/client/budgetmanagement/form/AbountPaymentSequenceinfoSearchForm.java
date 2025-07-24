package com.pomplatform.client.budgetmanagement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.budgetmanagement.datasource.CDAbountPaymentSequenceinfo;

public class AbountPaymentSequenceinfoSearchForm extends SearchForm
{


	private final TextItem budgetManagementIdItem;

	public AbountPaymentSequenceinfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAbountPaymentSequenceinfo.getInstance());
		budgetManagementIdItem = new TextItem("budgetManagementId", "预算管理id");

		setItems(budgetManagementIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
