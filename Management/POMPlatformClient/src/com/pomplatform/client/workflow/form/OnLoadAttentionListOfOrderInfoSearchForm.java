package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDOnLoadAttentionListOfOrderInfo;

public class OnLoadAttentionListOfOrderInfoSearchForm extends SearchForm
{


//	private final TextItem statusItem;
//	private final TextItem processTypeItem;
//	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem infoCodeItem;
	private final TextItem contractNameItem;

	public OnLoadAttentionListOfOrderInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadAttentionListOfOrderInfo.getInstance());
//		statusItem = new TextItem("status", "状态");
//		processTypeItem = new TextItem("processType", "流程类型");
		contractCodeItem = new TextItem("contractCode", "主订单编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "主订单名称");
		contractNameItem.setWidth("*");
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setWidth("*");
		setItems(contractCodeItem,contractNameItem, infoCodeItem);
		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
