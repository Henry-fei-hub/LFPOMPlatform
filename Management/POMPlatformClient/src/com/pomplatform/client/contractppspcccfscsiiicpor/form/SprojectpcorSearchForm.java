package com.pomplatform.client.contractppspcccfscsiiicpor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contractppspcccfscsiiicpor.datasource.CDSprojectpcor;

public class SprojectpcorSearchForm extends SearchForm
{


	private final TextItem sheetAmountItem;
	private final TextItem projectFlagItem;
	private final TextItem businessTypeItem;
	private final CheckboxItem isEcmcProjectItem;
	private final TextItem moneySumItem;
	private final TextItem contractCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem projectIdItem;
	private final TextItem contractIdItem;

	public SprojectpcorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSprojectpcor.getInstance());
		sheetAmountItem = new TextItem("sheetAmount", "订单金额");
		sheetAmountItem.setWidth("*");
		projectFlagItem = new TextItem("projectFlag", "2研发项目)");
		projectFlagItem.hide();
		businessTypeItem = new TextItem("businessType", "业务类别");
		businessTypeItem.hide();
		isEcmcProjectItem = new CheckboxItem("isEcmcProject", "true是");
		isEcmcProjectItem.hide();
		moneySumItem = new TextItem("moneySum", "合同金额");
		moneySumItem.hide();
		contractCodeItem = new TextItem("contractCode", "订单编号");
		contractCodeItem.setWidth("*");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "订单名称");
		projectNameItem.setWidth("*");
		projectIdItem = new TextItem("projectId", "项目编码");
		projectIdItem.hide();
		contractIdItem = new TextItem("contractId", "合同编码");
		contractIdItem.hide();

		setItems(sheetAmountItem, projectFlagItem, businessTypeItem, isEcmcProjectItem, moneySumItem, contractCodeItem, projectCodeItem, projectNameItem, projectIdItem, contractIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
