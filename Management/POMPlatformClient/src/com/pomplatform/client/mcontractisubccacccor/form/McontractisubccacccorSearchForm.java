package com.pomplatform.client.mcontractisubccacccor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.mcontractisubccacccor.datasource.CDMcontractisubccacccor;

public class McontractisubccacccorSearchForm extends SearchForm
{


	private final TextItem departmentIdItem;
	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem customerNameItem;
	private final TextItem contractNameItem;

	public McontractisubccacccorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcontractisubccacccor.getInstance());
		departmentIdItem = new TextItem("departmentId", "归属部门");
		departmentIdItem.hide();
		contractIdItem = new TextItem("contractId", "合同编码");
		contractIdItem.hide();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		setItems(departmentIdItem, contractIdItem, contractCodeItem, customerNameItem, contractNameItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
