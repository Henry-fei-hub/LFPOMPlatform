package com.pomplatform.client.costallocation.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.costallocation.datasource.CDCarCostAllocationEachMonthDetail;

public class CarCostAllocationEachMonthDetailSearchForm extends SearchForm
{


	private final SelectItem costTypeItem;
	private final DateTimeItem startTimeItem;
	private final DateTimeItem endTimeItem;

	public CarCostAllocationEachMonthDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCarCostAllocationEachMonthDetail.getInstance());
		costTypeItem = new SelectItem("costType", "用车类型");
		costTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_119"));
		startTimeItem = new DateTimeItem("startTime", "开始时间");
		startTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startTimeItem);
			}
		});
		endTimeItem = new DateTimeItem("endTime", "截止时间");
		endTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endTimeItem);
			}
		});

		setItems(costTypeItem, startTimeItem, endTimeItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
