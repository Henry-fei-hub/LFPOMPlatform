package com.pomplatform.client.receivables.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.receivables.datasource.CDIncomeMoneyForWeek;

public class IncomeMoneyForWeekSearchForm extends SearchForm
{


	private final TextItem contractNameItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;

	public IncomeMoneyForWeekSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDIncomeMoneyForWeek.getInstance());
		contractNameItem = new TextItem("contractName", "收款项目");
		startDateItem = new DateTimeItem("startDate", "开始日期");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateTimeItem("endDate", "截止日期");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});

		setItems(contractNameItem, startDateItem, endDateItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
