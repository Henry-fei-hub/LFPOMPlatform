package com.pomplatform.client.stagemodel.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.stagemodel.datasource.CDStageContractInfoList;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class StageContractInfoListSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final SelectItem contractStatusItem;

	public StageContractInfoListSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDStageContractInfoList.getInstance());
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		contractStatusItem = new SelectItem("contractStatus", "合同状态");
		contractStatusItem.setWidth("*");
		contractStatusItem.setMultiple(true);
		contractStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));

		setItems(contractCodeItem, contractNameItem, contractStatusItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
