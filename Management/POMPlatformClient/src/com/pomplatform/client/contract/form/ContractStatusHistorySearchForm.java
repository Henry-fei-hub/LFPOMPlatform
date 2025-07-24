package com.pomplatform.client.contract.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contract.datasource.CDContractStatusHistory;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ContractStatusHistorySearchForm extends SearchForm
{


	private final DateItem startTimeItem;
	private final DateItem endTimeItem;
	private final SelectItem contractStatusItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;

	public ContractStatusHistorySearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractStatusHistory.getInstance());
		startTimeItem = new DateItem("startTime", "开始日期");
		startTimeItem.setWidth("*");
		
		endTimeItem = new DateItem("endTime", "截止日期");
		endTimeItem.setWidth("*");
		
		contractStatusItem = new SelectItem("contractStatus", "合同状态");
		contractStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));
		contractStatusItem.setWidth("*");

		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		setItems(startTimeItem, endTimeItem, contractStatusItem, contractCodeItem, contractNameItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
