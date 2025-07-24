package com.pomplatform.client.plateIntegralAccount.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.plateIntegralAccount.datasource.CDQualityFeeDetail;

public class QualityFeeDetailSearchForm extends SearchForm
{


	private final SelectItem fromPlateIdItem;
	private final SelectItem toPlateIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public QualityFeeDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDQualityFeeDetail.getInstance());
		fromPlateIdItem = new SelectItem("fromPlateId", "积分提取部门");
		fromPlateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		toPlateIdItem = new SelectItem("toPlateId", "积分发放部门");
		toPlateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateItem("endDate", "截止日期");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});

		setItems(fromPlateIdItem, toPlateIdItem, startDateItem, endDateItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
