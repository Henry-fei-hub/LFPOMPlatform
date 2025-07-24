package com.pomplatform.client.scontract.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.scontract.datasource.CDScontract;

public class ScontractSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem infoCodeItem;
	private final SelectItem contractStatusItem;
	private final TextItem clientContractIdItem;

	public ScontractSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDScontract.getInstance());
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setWidth("*");
		contractStatusItem = new SelectItem("contractStatus", "合同状态");
		contractStatusItem.setWidth("*");
		contractStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));
		clientContractIdItem = new TextItem("clientContractId", "客户合同编号");
		clientContractIdItem.setWidth("*");
		clientContractIdItem.setHidden(true);
		setItems(contractCodeItem, contractNameItem, infoCodeItem, contractStatusItem, clientContractIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
