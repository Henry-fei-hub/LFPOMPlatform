package com.pomplatform.client.contractreceivablecipor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contractreceivablecipor.datasource.CDScontractreceivablecipor;

public class ScontractreceivableciporSearchForm extends SearchForm
{


	private final TextItem contractReceivableIdItem;
	private final TextItem infoCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem receivableNameItem;
	private final CheckboxItem isConfirmationLetterItem;
	private final TextItem remarkItem;
	private final SelectItem parentIdItem;

	public ScontractreceivableciporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDScontractreceivablecipor.getInstance());
		contractReceivableIdItem = new TextItem("contractReceivableId", "合同阶段id");
		infoCodeItem = new TextItem("infoCode", "信息编号");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		contractIdItem = new TextItem("contractId", "合同主键");
		contractCodeItem = new TextItem("contractCode", "合同主编号");
		receivableNameItem = new TextItem("receivableName", "阶段名称");
		isConfirmationLetterItem = new CheckboxItem("isConfirmationLetter", "是否已经被用做过确认函");
		remarkItem = new TextItem("remark", "收款阶段备注");
		parentIdItem = new SelectItem("parentId", "收款阶段id的父节点");
//		parentIdItem.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdItem);

		setItems(contractReceivableIdItem, infoCodeItem, projectCodeItem, contractIdItem, contractCodeItem, receivableNameItem, isConfirmationLetterItem, remarkItem, parentIdItem);

		setNumCols(18);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
