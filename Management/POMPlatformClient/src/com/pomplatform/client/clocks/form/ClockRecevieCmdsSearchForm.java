package com.pomplatform.client.clocks.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.clocks.datasource.CDClockRecevieCmds;

public class ClockRecevieCmdsSearchForm extends SearchForm
{


	private final SelectItem statusItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;
	private final TextItem deviceNameItem;

	public ClockRecevieCmdsSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDClockRecevieCmds.getInstance());
		statusItem = new SelectItem("status", "执行状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_88"));
		statusItem.setWidth("*");
		
		startDateItem = new DateTimeItem("startDate", "开始日期");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		startDateItem.setWidth("*");
		
		endDateItem = new DateTimeItem("endDate", "结束日期");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, endDateItem);
			}
		});
		endDateItem.setWidth("*");
		
		deviceNameItem = new TextItem("deviceName", "设备名称");
		deviceNameItem.setWidth("*");

		setItems(statusItem, startDateItem, endDateItem, deviceNameItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
