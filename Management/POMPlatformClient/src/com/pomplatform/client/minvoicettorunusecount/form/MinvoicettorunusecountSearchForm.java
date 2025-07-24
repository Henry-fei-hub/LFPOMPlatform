package com.pomplatform.client.minvoicettorunusecount.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.minvoicettorunusecount.datasource.CDMinvoicettorunusecount;

public class MinvoicettorunusecountSearchForm extends SearchForm
{


	private final SelectItem ticketingCompanyItem;

	public MinvoicettorunusecountSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMinvoicettorunusecount.getInstance());
		ticketingCompanyItem = new SelectItem("ticketingCompany", "购票公司");
		ticketingCompanyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_54"));

		setItems(ticketingCompanyItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
