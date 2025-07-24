package com.pomplatform.client.scontractreceivabletemplaterrcor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.scontractreceivabletemplaterrcor.datasource.CDScontractreceivabletemplaterrcor;

public class ScontractreceivabletemplaterrcorSearchForm extends SearchForm
{


	private final TextItem receivableNameItem;
	private final TextItem remarkItem;
	private final TextItem contractReceivableTemplateIdItem;
	private final SelectItem parentIdItem;
	private final TextItem operatorItem;

	public ScontractreceivabletemplaterrcorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDScontractreceivabletemplaterrcor.getInstance());
		receivableNameItem = new TextItem("receivableName", "阶段名称");
		remarkItem = new TextItem("remark", "备注");
		contractReceivableTemplateIdItem = new TextItem("contractReceivableTemplateId", "主键");
		parentIdItem = new SelectItem("parentId", "收款阶段id的父节点");
//		parentIdItem.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdItem);
		operatorItem = new TextItem("operator", "操作人");

		setItems(receivableNameItem, remarkItem, contractReceivableTemplateIdItem, parentIdItem, operatorItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
