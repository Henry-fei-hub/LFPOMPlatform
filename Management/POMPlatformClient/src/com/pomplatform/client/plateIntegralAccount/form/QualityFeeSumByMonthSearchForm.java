package com.pomplatform.client.plateIntegralAccount.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.plateIntegralAccount.datasource.CDQualityFeeSumByMonth;

public class QualityFeeSumByMonthSearchForm extends SearchForm
{


	private final SelectItem plateIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public QualityFeeSumByMonthSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDQualityFeeSumByMonth.getInstance());
		plateIdItem = new SelectItem("plateId", "积分提取部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		startDateItem = new DateItem("startDate", "发放日期");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateItem("endDate", "发放日期");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});

		setItems(plateIdItem, startDateItem, endDateItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
