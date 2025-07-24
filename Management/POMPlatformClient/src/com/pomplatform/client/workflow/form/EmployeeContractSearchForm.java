package com.pomplatform.client.workflow.form;

import java.util.*;

import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDEmployeeContract;

public class EmployeeContractSearchForm extends SearchForm
{


	private final ComboBoxItem employeeIdItem;
	private final DateItem startDateItem;

	public EmployeeContractSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeContract.getInstance());
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
		employeeIdItem.setWidth("*");
		KeyValueManager.loadValueMap("employees",employeeIdItem);
		employeeIdItem.setChangeOnKeypress(false);

		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		startDateItem.setHidden(true);

		setItems(employeeIdItem, startDateItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
