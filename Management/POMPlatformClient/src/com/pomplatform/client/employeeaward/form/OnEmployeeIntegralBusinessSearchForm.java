package com.pomplatform.client.employeeaward.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.data.TextImportSettings;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeeaward.datasource.CDOnEmployeeIntegralBusiness;

public class OnEmployeeIntegralBusinessSearchForm extends SearchForm
{


	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final SelectItem statusItem;
	private final TextItem businessTypeNameItem;

	public OnEmployeeIntegralBusinessSearchForm() {
		setWidth100();
		setHeight100();
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		
		endDateItem = new DateItem("endDate", "截止日期");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		endDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		
		statusItem = new SelectItem("status", "状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_118"));
		statusItem.setWidth("*");
		
		businessTypeNameItem = new TextItem("businessTypeName", "业务功能名称");
		businessTypeNameItem.setWidth("*");
		
		setItems(businessTypeNameItem, statusItem,startDateItem, endDateItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
