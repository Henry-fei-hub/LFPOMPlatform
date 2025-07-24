package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.personnelbusiness.datasource.CDPlateSalaryAdjustment;

public class PlateSalaryAdjustmentSearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final ComboBoxItem plateIdItem;

	public PlateSalaryAdjustmentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPlateSalaryAdjustment.getInstance());
		yearItem = new SelectItem("year", "年份");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		monthItem = new SelectItem("month", "月份");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		setItems(yearItem, monthItem, plateIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
