package com.pomplatform.client.sprojectemployeeadvancerecord.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sprojectemployeeadvancerecord.datasource.CDSProjectEmployeeAdvanceRecord;

public class SProjectEmployeeAdvanceRecordSearchForm extends SearchForm
{


	private final SelectItem employeeIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public SProjectEmployeeAdvanceRecordSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSProjectEmployeeAdvanceRecord.getInstance());
		employeeIdItem = new SelectItem("employeeId", "员工姓名");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		startDateItem = new DateItem("startDate", "开始时间");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateItem("endDate", "截止时间");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});

		setItems(employeeIdItem, startDateItem, endDateItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
