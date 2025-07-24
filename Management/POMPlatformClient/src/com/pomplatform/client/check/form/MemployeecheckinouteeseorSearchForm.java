package com.pomplatform.client.check.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.check.datasource.CDMemployeecheckinouteeseor;

public class MemployeecheckinouteeseorSearchForm extends SearchForm
{


	private final ComboBoxItem employeeIdItem;
	private final DateItem startTimeItem;
	private final DateItem endTimeItem;

	public MemployeecheckinouteeseorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMemployeecheckinouteeseor.getInstance());
		employeeIdItem = new ComboBoxItem("employeeId", "员工编码");
                employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		startTimeItem = new DateItem("startTime", "开始日期");
		startTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, startTimeItem);
			}
		});
		endTimeItem = new DateItem("endTime", "结束日期");
		endTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, endTimeItem);
			}
		});

		setItems(startTimeItem, endTimeItem, employeeIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
