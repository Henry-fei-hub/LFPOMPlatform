package com.pomplatform.client.employeedetail.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeedetail.datasource.CDSureIntegralDetail;

public class SureIntegralDetailSearchForm extends SearchForm
{


	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final SelectItem employeeIdItem;

	public SureIntegralDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSureIntegralDetail.getInstance());
		startDateItem = new DateItem("startDate", "结算日期");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateItem("endDate", "结算日期");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});
		employeeIdItem = new SelectItem("employeeId", "人员");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));

		setItems(startDateItem, endDateItem, employeeIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
