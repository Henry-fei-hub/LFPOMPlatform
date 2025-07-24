package com.pomplatform.client.contract.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contract.datasource.CDNewContractDistribution;

public class NewContractDistributionSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
//	private final SelectItem selectYearItem;
//	private final SelectItem selectMonthItem;
	private final SelectItem businessTypeItem;
	private final TextItem contractSigningStatusItem;

	public NewContractDistributionSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDNewContractDistribution.getInstance());
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
//		selectYearItem = new SelectItem("selectYear", "年份");
//		selectYearItem.setWidth("*");
//		selectYearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
//		selectMonthItem = new SelectItem("selectMonth", "月份");
//		selectMonthItem.setWidth("*");
//		selectMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		businessTypeItem = new SelectItem("businessType", "业务类别");
		businessTypeItem.setWidth("*");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		contractSigningStatusItem = new TextItem("contractSigningStatus", "合同签订状态  1已寄出  2已签订");
		contractSigningStatusItem.setHidden(true);

		setItems(contractCodeItem, contractNameItem,businessTypeItem, contractSigningStatusItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
