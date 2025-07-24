package com.pomplatform.client.ja.ht.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ja.ht.datasource.CDOutQuotationApplication;

public class OutQuotationApplicationSearchForm extends SearchForm
{


	private final TextItem outQuotationIdItem;

	public OutQuotationApplicationSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOutQuotationApplication.getInstance());
		outQuotationIdItem = new TextItem("outQuotationId", "报价单编码");

		setItems(outQuotationIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
