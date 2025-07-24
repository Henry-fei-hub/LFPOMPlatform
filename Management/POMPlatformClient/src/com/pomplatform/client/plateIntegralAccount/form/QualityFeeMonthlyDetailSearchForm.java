package com.pomplatform.client.plateIntegralAccount.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.plateIntegralAccount.datasource.CDQualityFeeMonthlyDetail;

public class QualityFeeMonthlyDetailSearchForm extends SearchForm
{


	private final SelectItem fromPlateIdItem;
	private final DateItem yearItem;
	private final DateItem monthItem;

	public QualityFeeMonthlyDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDQualityFeeMonthlyDetail.getInstance());
		fromPlateIdItem = new SelectItem("fromPlateId", "积分提取部门");
		fromPlateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		yearItem = new DateItem("year", "发放日期");
		yearItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, yearItem);
			}
		});
		monthItem = new DateItem("month", "发放日期");
		monthItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, monthItem);
			}
		});

		setItems(fromPlateIdItem, yearItem, monthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
