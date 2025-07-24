package com.pomplatform.client.capitaldistribution.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.capitaldistribution.datasource.CDCapitalDifference;

public class CapitalDifferenceSearchForm extends SearchForm
{


	private final TextItem moneyAttributeItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;

	public CapitalDifferenceSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCapitalDifference.getInstance());
		moneyAttributeItem = new TextItem("moneyAttribute", "款项属性");
		startDateItem = new DateTimeItem("startDate", "开始日期");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateTimeItem("endDate", "结束日期");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, endDateItem);
			}
		});

		setItems(moneyAttributeItem, startDateItem, endDateItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
