package com.pomplatform.client.account.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.account.datasource.CDBonusSubsidyDetail;

public class BonusSubsidyDetailSearchForm extends SearchForm
{


	private final TextItem yearItem;
	private final TextItem monthItem;
	private final SelectItem plateIdItem;
	private final SelectItem employeeIdItem;

	public BonusSubsidyDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDBonusSubsidyDetail.getInstance());
		yearItem = new TextItem("year", "年份");
		monthItem = new TextItem("month", "月份");
		plateIdItem = new SelectItem("plateId", "所在业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		employeeIdItem = new SelectItem("employeeId", "职员编码");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));

		setItems(yearItem, monthItem, plateIdItem, employeeIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
