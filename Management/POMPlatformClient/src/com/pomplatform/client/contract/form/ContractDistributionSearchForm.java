package com.pomplatform.client.contract.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contract.datasource.CDContractDistribution;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ContractDistributionSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final SelectItem businessTypeItem;

	public ContractDistributionSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractDistribution.getInstance());
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		
		monthItem = new SelectItem("month", "月份");
		monthItem.setWidth("*");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		
		businessTypeItem = new SelectItem("businessType", "业务类别");
		businessTypeItem.setWidth("*");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));

		setItems(contractCodeItem, contractNameItem, businessTypeItem, yearItem, monthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
