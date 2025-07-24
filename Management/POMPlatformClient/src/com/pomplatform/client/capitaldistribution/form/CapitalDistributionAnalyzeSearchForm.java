package com.pomplatform.client.capitaldistribution.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.capitaldistribution.datasource.CDCapitalDistributionAnalyze;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;

public class CapitalDistributionAnalyzeSearchForm extends SearchForm
{


	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public CapitalDistributionAnalyzeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCapitalDistributionAnalyze.getInstance());
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		
		endDateItem = new DateItem("endDate", "结束日期");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		endDateItem.setUseMask(true);

		setItems(startDateItem, endDateItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
