package com.pomplatform.client.newcontract.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.newcontract.datasource.CDNewContract;

public class NewContractSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem projectCodeItem;

	public NewContractSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDNewContract.getInstance());
		contractCodeItem = new TextItem("contractCode", "主合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "主合同名称");
		contractNameItem.setWidth("*");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");

		setItems(contractCodeItem, contractNameItem, projectCodeItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
