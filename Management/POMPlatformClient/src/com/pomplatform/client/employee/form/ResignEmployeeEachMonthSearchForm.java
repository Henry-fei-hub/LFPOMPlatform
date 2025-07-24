package com.pomplatform.client.employee.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employee.datasource.CDResignEmployeeEachMonth;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class ResignEmployeeEachMonthSearchForm extends SearchForm
{


	private final SelectItem plateIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public ResignEmployeeEachMonthSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDResignEmployeeEachMonth.getInstance());
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.hide();
		
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		
		endDateItem = new DateItem("endDate", "截止日期");
		endDateItem.setWidth("*");

		setItems(plateIdItem, startDateItem, endDateItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
