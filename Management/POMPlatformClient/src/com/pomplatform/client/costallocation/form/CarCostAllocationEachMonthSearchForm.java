package com.pomplatform.client.costallocation.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.costallocation.datasource.CDCarCostAllocationEachMonth;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class CarCostAllocationEachMonthSearchForm extends SearchForm
{


	private final SelectItem costTypeItem;
	private final DateItem startTimeItem;
	private final DateItem endTimeItem;

	public CarCostAllocationEachMonthSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCarCostAllocationEachMonth.getInstance());
		
		costTypeItem = new SelectItem("costType", "用车类型");
		costTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_119"));
		costTypeItem.setWidth("*");
		
		startTimeItem = new DateItem("startTime", "开始日期");
		startTimeItem.setWidth("*");
		
		endTimeItem = new DateItem("endTime", "截止日期");
		endTimeItem.setWidth("*");

		setItems(costTypeItem, startTimeItem, endTimeItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
