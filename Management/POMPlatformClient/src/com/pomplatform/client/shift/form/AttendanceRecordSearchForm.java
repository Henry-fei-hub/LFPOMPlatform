package com.pomplatform.client.shift.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.shift.datasource.CDAttendanceRecord;

public class AttendanceRecordSearchForm extends SearchForm
{


	private final SelectItem employeeIdItem;
	private final DateItem endDateItem;
	private final DateItem startDateItem;

	public AttendanceRecordSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAttendanceRecord.getInstance());
		employeeIdItem = new SelectItem("employeeId", "职员编码");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		endDateItem = new DateItem("endDate", "结束日期");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});

		setItems(employeeIdItem, endDateItem, startDateItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
