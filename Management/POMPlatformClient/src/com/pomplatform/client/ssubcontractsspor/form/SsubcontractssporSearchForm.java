package com.pomplatform.client.ssubcontractsspor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ssubcontractsspor.datasource.CDSsubcontractsspor;

public class SsubcontractssporSearchForm extends SearchForm
{


	private final TextItem subContractIdItem;
	private final TextItem subContractCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem subContractNameItem;
	private final TextItem infoCodeItem;
	private final TextItem remarkItem;
	private final SelectItem parentIdItem;
	private final TextItem businessTypeItem;
	private final TextItem projectTypeItem;
	private final TextItem departmentIdItem;

	public SsubcontractssporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSsubcontractsspor.getInstance());
		subContractIdItem = new TextItem("subContractId", "子合同编码");
		subContractIdItem.hide();
		subContractCodeItem = new TextItem("subContractCode", "子合同编号");
		subContractCodeItem.setWidth("*");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		subContractNameItem = new TextItem("subContractName", "子合同名称");
		subContractNameItem.setWidth("*");
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setWidth("*");
		infoCodeItem.hide();
		remarkItem = new TextItem("remark", "备注");
		remarkItem.hide();
		parentIdItem = new SelectItem("parentId", "主合同编码");
		parentIdItem.hide();
//		parentIdItem.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdItem);
		businessTypeItem = new TextItem("businessType", "业务类型");
		businessTypeItem.hide();
		projectTypeItem = new TextItem("projectType", "项目类型");
		projectTypeItem.hide();
		departmentIdItem = new TextItem("departmentId", "承接部门");
		departmentIdItem.hide();

		setItems(subContractIdItem, subContractCodeItem, projectCodeItem, subContractNameItem, infoCodeItem, remarkItem, parentIdItem, businessTypeItem, projectTypeItem, departmentIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
