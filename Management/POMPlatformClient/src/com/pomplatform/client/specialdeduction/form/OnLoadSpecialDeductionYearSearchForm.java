package com.pomplatform.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.specialdeduction.datasource.CDOnLoadSpecialDeductionYear;

public class OnLoadSpecialDeductionYearSearchForm extends SearchForm
{


	private final TextItem employeeIdItem;
	private final TextItem businessIdItem;
	private final TextItem yearItem;

	public OnLoadSpecialDeductionYearSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadSpecialDeductionYear.getInstance());
		employeeIdItem = new TextItem("employeeId", "创建人");
		businessIdItem = new TextItem("businessId", "业务编码");
		yearItem = new TextItem("year", "扣除年度");

		setItems(employeeIdItem, businessIdItem, yearItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
