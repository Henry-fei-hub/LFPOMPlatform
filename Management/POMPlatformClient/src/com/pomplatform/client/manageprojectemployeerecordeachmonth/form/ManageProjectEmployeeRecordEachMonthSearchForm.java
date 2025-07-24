package com.pomplatform.client.manageprojectemployeerecordeachmonth.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.manageprojectemployeerecordeachmonth.datasource.CDManageProjectEmployeeRecordEachMonth;

public class ManageProjectEmployeeRecordEachMonthSearchForm extends SearchForm
{


	private final DateItem startdateItem;
	private final DateItem enddateItem;
	private final SelectItem employeeIdItem;

	public ManageProjectEmployeeRecordEachMonthSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDManageProjectEmployeeRecordEachMonth.getInstance());
		startdateItem = new DateItem("startdate", "开始日期");
		startdateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startdateItem);
			}
		});
		enddateItem = new DateItem("enddate", "截止日期");
		enddateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, enddateItem);
			}
		});
		employeeIdItem = new SelectItem("employeeId", "员工姓名");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));

		setItems(startdateItem, enddateItem, employeeIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
