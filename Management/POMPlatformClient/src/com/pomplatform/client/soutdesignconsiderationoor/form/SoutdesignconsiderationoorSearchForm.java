package com.pomplatform.client.soutdesignconsiderationoor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.soutdesignconsiderationoor.datasource.CDSoutdesignconsiderationoor;

public class SoutdesignconsiderationoorSearchForm extends SearchForm
{


	private final TextItem outQuotationIdItem;

	public SoutdesignconsiderationoorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSoutdesignconsiderationoor.getInstance());
		outQuotationIdItem = new TextItem("outQuotationId", "报价单表编码");

		setItems(outQuotationIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
