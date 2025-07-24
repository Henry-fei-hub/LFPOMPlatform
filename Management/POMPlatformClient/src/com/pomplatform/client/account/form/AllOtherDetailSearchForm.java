package com.pomplatform.client.account.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.account.datasource.CDAllOtherDetail;

public class AllOtherDetailSearchForm extends SearchForm
{


	private final TextItem yearItem;
	private final TextItem monthItem;
	private final SelectItem plateIdItem;
	private final SelectItem employeeIdItem;
	private final TextItem businessTypeIdItem;

	public AllOtherDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAllOtherDetail.getInstance());
		yearItem = new TextItem("year", "年份");
		monthItem = new TextItem("month", "月份");
		plateIdItem = new SelectItem("plateId", "所在业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		employeeIdItem = new SelectItem("employeeId", "职员编码");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		businessTypeIdItem = new TextItem("businessTypeId", "10绩效奖金)");

		setItems(yearItem, monthItem, plateIdItem, employeeIdItem, businessTypeIdItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
