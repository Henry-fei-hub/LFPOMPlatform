package com.pomplatform.client.financialstatements.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.financialstatements.datasource.CDScapitalipcor;

public class ScapitalipcorSearchForm extends SearchForm
{


	private final TextItem infoCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem contractCodeItem;
	private final TextItem capitalIdItem;
	private final TextItem contractIdItem;
	private final TextItem moneyAttributeItem;
	private final TextItem selfNameItem;
	private final TextItem capitalTypeItem;
	private final TextItem processStatusItem;

	public ScapitalipcorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDScapitalipcor.getInstance());
		infoCodeItem = new TextItem("infoCode", "信息编号");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		contractCodeItem = new TextItem("contractCode", "合同主编号");
		capitalIdItem = new TextItem("capitalId", "资金表id");
		contractIdItem = new TextItem("contractId", "合同id");
		moneyAttributeItem = new TextItem("moneyAttribute", "款项属性");
		selfNameItem = new TextItem("selfName", "内部公司(收款方)");
		capitalTypeItem = new TextItem("capitalType", "资金类型  1 流入  2 流出");
		processStatusItem = new TextItem("processStatus", "流程状态 0 未处于流程  1审批中 2审批完成");

		setItems(infoCodeItem, projectCodeItem, contractCodeItem, capitalIdItem, contractIdItem, moneyAttributeItem, selfNameItem, capitalTypeItem, processStatusItem);

		setNumCols(18);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
