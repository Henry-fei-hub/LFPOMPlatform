package com.pomplatform.client.platesalaryadvancerecord.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.platesalaryadvancerecord.datasource.CDPlateSalaryAdvanceRecord;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class PlateSalaryAdvanceRecordSearchForm extends SearchForm {

	private final SelectItem plateIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem employeeNoItem;
	private final ComboBoxItem employeeIdItem;

	public PlateSalaryAdvanceRecordSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPlateSalaryAdvanceRecord.getInstance());
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.hide();
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		startDateItem = new DateItem("startDate", "开始时间");
		startDateItem.hide();
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateItem("endDate", "截止时间");
		endDateItem.hide();
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		employeeIdItem = new ComboBoxItem("employeeId", "姓名");
		employeeIdItem.setWidth("*");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));

		setItems(plateIdItem, startDateItem, endDateItem, employeeNoItem, employeeIdItem);

		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
