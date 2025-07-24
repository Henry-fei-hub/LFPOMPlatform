package com.pomplatform.client.contract.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;

import javax.swing.plaf.ComboBoxUI;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contract.datasource.CDContractManage;

public class ContractManageSearchForm extends SearchForm
{


	private final SelectItem signingCompanyNameItem;
	private final TextItem contractNameItem;
	private final TextItem contractCodeItem;
	private final ComboBoxItem customerIdItem;

	public ContractManageSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractManage.getInstance());
		signingCompanyNameItem = new SelectItem("signingCompanyName", "签约公司");
		signingCompanyNameItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		signingCompanyNameItem.setWidth("*");
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		customerIdItem = new ComboBoxItem("customerId", "客户");
		customerIdItem.setWidth("*");
		customerIdItem.setChangeOnKeypress(false);
		customerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		customerIdItem.setValueMap(KeyValueManager.getValueMap("customers"));
		KeyValueManager.loadValueMap("customers",customerIdItem);
		setItems(contractCodeItem, contractNameItem, signingCompanyNameItem, customerIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
