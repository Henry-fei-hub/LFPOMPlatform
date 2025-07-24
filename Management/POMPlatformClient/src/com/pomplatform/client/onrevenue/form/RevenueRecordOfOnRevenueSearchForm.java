package com.pomplatform.client.onrevenue.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.onrevenue.datasource.CDRevenueRecordOfOnRevenue;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class RevenueRecordOfOnRevenueSearchForm extends SearchForm
{


	private final SelectItem signingCompanyItem;
	private final TextItem nameItem;

	public RevenueRecordOfOnRevenueSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDRevenueRecordOfOnRevenue.getInstance());
		signingCompanyItem = new SelectItem("signingCompany", "签约公司");
		signingCompanyItem.setWidth("*");
		signingCompanyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		nameItem = new TextItem("name", "名称");
		nameItem.setWidth("*");

		setItems(signingCompanyItem, nameItem);

		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
