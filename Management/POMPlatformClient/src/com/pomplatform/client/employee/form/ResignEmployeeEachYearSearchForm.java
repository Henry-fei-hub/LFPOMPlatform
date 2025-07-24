package com.pomplatform.client.employee.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employee.datasource.CDResignEmployeeEachYear;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class ResignEmployeeEachYearSearchForm extends SearchForm
{


	private final ComboBoxItem parentIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public ResignEmployeeEachYearSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDResignEmployeeEachYear.getInstance());
		parentIdItem = new ComboBoxItem("parentId", "业务部门");
		parentIdItem.setWidth("*");
//		parentIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		parentIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		parentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		
		endDateItem = new DateItem("endDate", "截止日期");
		endDateItem.setWidth("*");
		
		setItems(parentIdItem, startDateItem, endDateItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
