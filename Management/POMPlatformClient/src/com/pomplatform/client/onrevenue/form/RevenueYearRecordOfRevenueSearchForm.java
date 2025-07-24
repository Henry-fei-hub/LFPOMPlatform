package com.pomplatform.client.onrevenue.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.onrevenue.datasource.CDRevenueYearRecordOfRevenue;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class RevenueYearRecordOfRevenueSearchForm extends SearchForm
{
	private final SelectItem signingCompanyItem;
	private final CheckboxItem isFinishItem;
	private final TextItem yearRevenueItem;
	private final TextItem parentIdItem;

	public RevenueYearRecordOfRevenueSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDRevenueYearRecordOfRevenue.getInstance());
		signingCompanyItem = new SelectItem("signingCompany", "签约公司");
		signingCompanyItem.setWidth("*");
		signingCompanyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		isFinishItem = new CheckboxItem("isFinish", "合同是否完成");
		yearRevenueItem = new TextItem("yearRevenue", "年度");
		yearRevenueItem.setWidth("*");
		parentIdItem = new TextItem("parentId", "父级编码");
		parentIdItem.hide();

		setItems(signingCompanyItem, yearRevenueItem, isFinishItem, parentIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
