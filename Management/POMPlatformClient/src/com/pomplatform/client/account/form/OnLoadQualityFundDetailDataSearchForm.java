package com.pomplatform.client.account.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.account.datasource.CDOnLoadQualityFundDetailData;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadQualityFundDetailDataSearchForm extends SearchForm
{


	private final TextItem businessTypeIdItem;
	private final TextItem yearItem;
	private final TextItem monthItem;

	public OnLoadQualityFundDetailDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadQualityFundDetailData.getInstance());
		businessTypeIdItem = new TextItem("businessTypeId", "业务类型");
		yearItem = new TextItem("year", "年份");
		monthItem = new TextItem("month", "月份");

		setItems(businessTypeIdItem, yearItem, monthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
