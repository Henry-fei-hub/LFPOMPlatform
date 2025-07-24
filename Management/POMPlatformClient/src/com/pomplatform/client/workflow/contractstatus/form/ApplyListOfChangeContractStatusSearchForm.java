package com.pomplatform.client.workflow.contractstatus.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.workflow.contractstatus.datasource.CDApplyListOfChangeContractStatus;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ApplyListOfChangeContractStatusSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final TextItem processStatusItem;
	private final TextItem deleteFlagItem;
	private final TextItem operatorItem;
	private final TextItem contentItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;

	public ApplyListOfChangeContractStatusSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDApplyListOfChangeContractStatus.getInstance());
		
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		
		processStatusItem = new TextItem("processStatus", "流程状态");
		processStatusItem.hide();
		
		deleteFlagItem = new TextItem("deleteFlag", "删除状态");
		deleteFlagItem.hide();
		
		operatorItem = new TextItem("operator", "操作人");
		operatorItem.hide();
		
		contentItem = new TextItem("content", "日志");
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		
		contractNameItem = new TextItem("contractName", "合同名称");

		setItems(processTypeItem, processStatusItem, deleteFlagItem, operatorItem, contractCodeItem, contractNameItem, contentItem);

		setNumCols(6);
		
		FormItem[] items = getFields();
		for(FormItem item : items) {
			item.setWidth("*");
		}
		
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
