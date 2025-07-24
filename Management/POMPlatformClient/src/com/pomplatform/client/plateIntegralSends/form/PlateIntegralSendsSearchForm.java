package com.pomplatform.client.plateIntegralSends.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.plateIntegralSends.datasource.CDPlateIntegralSends;

public class PlateIntegralSendsSearchForm extends SearchForm
{


	private final TextItem plateIntegralSendIdItem;
	private final ComboBoxItem plateIdItem;
	private final TextItem employeeIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public PlateIntegralSendsSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPlateIntegralSends.getInstance());
		plateIntegralSendIdItem = new TextItem("plateIntegralSendId", "主键编码");
		plateIntegralSendIdItem.hide();
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		
		employeeIdItem = new TextItem("employeeId", "操作人");
		employeeIdItem.hide();
		
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		
		endDateItem = new DateItem("endDate", "结束日期");
		endDateItem.setWidth("*");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});

		setItems(plateIntegralSendIdItem, plateIdItem, employeeIdItem, startDateItem, endDateItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
