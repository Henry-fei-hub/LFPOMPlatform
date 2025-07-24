package com.pomplatform.client.outquotations.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.outquotations.datasource.CDOnLoadMainProjectBusinessTypeByContract;

public class OnLoadMainProjectBusinessTypeByContractSearchForm extends SearchForm
{


	private final TextItem contractIdItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem statusItem;

	public OnLoadMainProjectBusinessTypeByContractSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadMainProjectBusinessTypeByContract.getInstance());
		contractIdItem = new TextItem("contractId", "主订单编码");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectNameItem = new TextItem("projectName", "项目名称");
		statusItem = new TextItem("status", "结算状态");

		setItems(contractIdItem, projectCodeItem, projectNameItem, statusItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
