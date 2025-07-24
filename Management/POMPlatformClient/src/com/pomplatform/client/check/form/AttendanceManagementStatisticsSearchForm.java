package com.pomplatform.client.check.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.check.datasource.CDAttendanceManagementStatistics;

public class AttendanceManagementStatisticsSearchForm extends SearchForm
{


	private final SelectItem departmentIdItem;
	private final ComboBoxItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final DateTimeItem todayItem;

	public AttendanceManagementStatisticsSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAttendanceManagementStatistics.getInstance());
		departmentIdItem = new SelectItem("departmentId", "所属部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
//		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employee_list"));
		KeyValueManager.loadValueMap("employee_list",employeeIdItem);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setWidth("*");
		
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		
		todayItem = new DateTimeItem("today", "日期");
		todayItem.setWidth("*");
		todayItem.setDefaultValue(new Date());
		todayItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, todayItem);
			}
		});

		setItems(departmentIdItem, employeeIdItem, employeeNoItem, todayItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
