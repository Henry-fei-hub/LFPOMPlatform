package com.pomplatform.client.workflow.operation.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.operation.datasource.CDOnLoadApplyListOfCostAllocation;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadApplyListOfCostAllocationSearchForm extends SearchForm
{


	private final SelectItem processTypeItem;
	private final SelectItem drafterItem;
	private final TextItem codeItem;
	private final TextItem nameItem;
	private final TextItem costItem;
	private final SelectItem costTypeItem;

	public OnLoadApplyListOfCostAllocationSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadApplyListOfCostAllocation.getInstance());
		processTypeItem = new SelectItem("processType", "流程类型");
		processTypeItem.hide();
		processTypeItem.setValueMap(KeyValueManager.getValueMap("system_process_types"));
		drafterItem = new SelectItem("drafter", "起草人");
		drafterItem.setValueMap(KeyValueManager.getValueMap("employees"));
		drafterItem.hide();
		codeItem = new TextItem("code", "编号");
		codeItem.setWidth("*");
		nameItem = new TextItem("name", "费用承担主体");
		nameItem.setWidth("*");
		costItem = new TextItem("cost", "成本");
		costItem.setWidth("*");
		costTypeItem = new SelectItem("costType", "原成本类型");
		costTypeItem.setWidth("*");
		costTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_121"));

		setItems(processTypeItem, drafterItem, costTypeItem, costItem, codeItem, nameItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
