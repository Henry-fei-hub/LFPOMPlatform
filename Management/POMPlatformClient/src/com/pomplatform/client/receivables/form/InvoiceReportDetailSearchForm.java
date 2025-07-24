package com.pomplatform.client.receivables.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.receivables.datasource.CDInvoiceReportDetail;

public class InvoiceReportDetailSearchForm extends SearchForm
{


	private final TextItem projectManagerIdItem;

	public InvoiceReportDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDInvoiceReportDetail.getInstance());
		projectManagerIdItem = new TextItem("projectManagerId", "项目经理编码");

		setItems(projectManagerIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
