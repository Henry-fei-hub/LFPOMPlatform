package com.pomplatform.client.receiveunit.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.receiveunit.datasource.CDMprocessbilllistsmmeor;

public class MprocessbilllistsmmeorSearchForm extends SearchForm {

	private final ComboBoxItem payeeNameItem;
	private final DateTimeItem minCompleteTimeItem;
	private final DateTimeItem maxCompleteTimeItem;
	private final ComboBoxItem employeeIdItem;

	public MprocessbilllistsmmeorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMprocessbilllistsmmeor.getInstance());
		payeeNameItem = new ComboBoxItem("payeeName", "收款方");
		payeeNameItem.setChangeOnKeypress(false);
		payeeNameItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		payeeNameItem.setValueMap(KeyValueManager.getValueMap("receive_unit_manages"));
		KeyValueManager.loadValueMap("receive_unit_manages",payeeNameItem);
		payeeNameItem.setWidth("*");
		minCompleteTimeItem = new DateTimeItem("minCompleteTime", "最早完成时间");
		minCompleteTimeItem.hide();
		minCompleteTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCompleteTimeItem);
			}
		});
		maxCompleteTimeItem = new DateTimeItem("maxCompleteTime", "最晚完成时间");
		maxCompleteTimeItem.hide();
		maxCompleteTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCompleteTimeItem);
			}
		});
		employeeIdItem = new ComboBoxItem("employeeId", "申请人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setChangeOnKeypress(true);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDisabled(true);

		setItems(payeeNameItem, minCompleteTimeItem, maxCompleteTimeItem, employeeIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
