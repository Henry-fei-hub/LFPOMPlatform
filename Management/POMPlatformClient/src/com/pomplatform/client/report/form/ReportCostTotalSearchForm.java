package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDReportCostTotal;

public class ReportCostTotalSearchForm extends SearchForm
{


	private final IntegerItem yearItem;
	private final SelectItem feeTypeItem;
	private final ComboBoxItem plateIdItem;

	public ReportCostTotalSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportCostTotal.getInstance());
		yearItem = new IntegerItem("year", "年份");
		yearItem.setDefaultValue(new Date().getYear() + 1900);
		yearItem.setWidth("*");
		
		feeTypeItem = new SelectItem("feeType", "费用类型");
		feeTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_121"));
		feeTypeItem.setWidth("*");
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));	

		setItems(yearItem, feeTypeItem, plateIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
