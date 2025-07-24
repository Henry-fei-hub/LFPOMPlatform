package com.pomplatform.client.aboutrevenueamount.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.aboutrevenueamount.datasource.CDAboutRevenueAmount;

public class AboutRevenueAmountSearchForm extends SearchForm
{


	private final TextItem contractIdItem;
	private final TextItem yearItem;
	private final TextItem monthItem;

	public AboutRevenueAmountSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAboutRevenueAmount.getInstance());
		contractIdItem = new TextItem("contractId", "contract_id");
		contractIdItem.setHidden(true);
		yearItem = new TextItem("year", "年");
		yearItem.setWidth("*");
		monthItem = new TextItem("month", "月");
		monthItem.setWidth("*");

		setItems(contractIdItem, yearItem, monthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
