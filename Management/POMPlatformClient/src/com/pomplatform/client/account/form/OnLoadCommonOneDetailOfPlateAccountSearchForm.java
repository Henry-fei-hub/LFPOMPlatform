package com.pomplatform.client.account.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.account.datasource.CDOnLoadCommonOneDetailOfPlateAccount;

public class OnLoadCommonOneDetailOfPlateAccountSearchForm extends SearchForm
{


	private final SelectItem plateIdItem;
	private final TextItem businessTypeIdItem;
	private final TextItem yearItem;
	private final TextItem monthItem;

	public OnLoadCommonOneDetailOfPlateAccountSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadCommonOneDetailOfPlateAccount.getInstance());
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.hide();
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		businessTypeIdItem = new TextItem("businessTypeId", "11绩效奖金)");
		yearItem = new TextItem("year", "年份");
		monthItem = new TextItem("month", "月份");

		setItems(plateIdItem, businessTypeIdItem, yearItem, monthItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
