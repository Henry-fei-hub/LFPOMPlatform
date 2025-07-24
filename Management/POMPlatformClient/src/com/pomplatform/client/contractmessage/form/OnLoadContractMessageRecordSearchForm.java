package com.pomplatform.client.contractmessage.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contractmessage.datasource.CDOnLoadContractMessageRecord;

public class OnLoadContractMessageRecordSearchForm extends SearchForm
{
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final SelectItem msgStatusItem;

	public OnLoadContractMessageRecordSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadContractMessageRecord.getInstance());
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		msgStatusItem = new SelectItem("msgStatus", "消息状态");
//		msgStatusItem.setDefaultValue(1);
		msgStatusItem.setWidth("*");
		msgStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_243"));
		setItems(contractCodeItem, contractNameItem,msgStatusItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
