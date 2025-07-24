package com.pomplatform.client.mcontracticcacccor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.mcontracticcacccor.datasource.CDMcontracticcacccor;

public class McontracticcacccorSearchForm extends SearchForm
{


	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem customerNameItem;
	private final TextItem contractNameItem;

	public McontracticcacccorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcontracticcacccor.getInstance());
		contractIdItem = new TextItem("contractId", "合同编码");
		contractIdItem.hide();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		setItems(contractIdItem, contractCodeItem, customerNameItem, contractNameItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
