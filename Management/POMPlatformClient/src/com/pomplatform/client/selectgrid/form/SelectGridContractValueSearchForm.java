package com.pomplatform.client.selectgrid.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.selectgrid.datasource.CDSelectGridContractValue;

public class SelectGridContractValueSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem customerNameItem;
	private final TextItem projectTypeItem;
	private final TextItem contractIdItem;
	private final SelectItem statusItem;
	private final TextItem businessTypeItem;
	private final TextItem flowStatusItem;
	private final SelectItem parentIdItem;
	private final CheckboxItem isFinishItem;

	public SelectGridContractValueSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSelectGridContractValue.getInstance());
		contractCodeItem = new TextItem("contractCode", "主订单编号");
		contractNameItem = new TextItem("contractName", "主订单名称");
		customerNameItem = new TextItem("customerName", "客户名称");
		projectTypeItem = new TextItem("projectType", "项目类别");
		contractIdItem = new TextItem("contractId", "主订单编码");
		statusItem = new SelectItem("status", "结算状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));
		businessTypeItem = new TextItem("businessType", "业务类别");
		flowStatusItem = new TextItem("flowStatus", "流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成");
		parentIdItem = new SelectItem("parentId", "tree结构表示");
//		parentIdItem.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdItem);
		isFinishItem = new CheckboxItem("isFinish", "合同是否完成");

		setItems(contractCodeItem, contractNameItem, customerNameItem, projectTypeItem, contractIdItem, statusItem, businessTypeItem, flowStatusItem, parentIdItem, isFinishItem);

		setNumCols(20);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
