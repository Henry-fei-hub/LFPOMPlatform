package com.pomplatform.client.plateintegralsendrecord.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.plateintegralsendrecord.datasource.CDPlateIntegralSendRecord;

public class PlateIntegralSendRecordSearchForm extends SearchForm
{


	private final SelectItem plateIdItem;
	private final DateItem startdateItem;
	private final DateItem enddateItem;
	private final ComboBoxItem employeeIdItem;
	private final TextItem employeeNoItem;

	public PlateIntegralSendRecordSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPlateIntegralSendRecord.getInstance());
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.hide();
		startdateItem = new DateItem("startdate", "开始时间");
		startdateItem.hide();
		startdateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startdateItem);
			}
		});
		enddateItem = new DateItem("enddate", "截止时间");
		enddateItem.hide();
		enddateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, enddateItem);
			}
		});
		employeeIdItem = new ComboBoxItem("employeeId", "操作人姓名");
		employeeIdItem.setWidth("*");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeNoItem = new TextItem("employeeNo", "操作人工号");
		employeeNoItem.setWidth("*");

		setItems(plateIdItem, startdateItem, enddateItem, employeeIdItem, employeeNoItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
