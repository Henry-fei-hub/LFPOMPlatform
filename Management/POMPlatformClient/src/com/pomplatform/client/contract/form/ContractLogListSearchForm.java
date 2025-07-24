package com.pomplatform.client.contract.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contract.datasource.CDContractLogList;

public class ContractLogListSearchForm extends SearchForm
{


	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final SelectItem originalStatusItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final SelectItem newStatusItem;

	public ContractLogListSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractLogList.getInstance());
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateItem("endDate", "截止日期");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		endDateItem.setUseMask(true);
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});
		originalStatusItem = new SelectItem("originalStatus", "原始合同状态");
		originalStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));
		originalStatusItem.setWidth("*");
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		newStatusItem = new SelectItem("newStatus", "新合同状态");
		newStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));
		newStatusItem.setWidth("*");

		setItems(startDateItem, endDateItem, originalStatusItem, contractCodeItem, contractNameItem, newStatusItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
