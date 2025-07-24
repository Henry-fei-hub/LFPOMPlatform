package com.pomplatform.client.projectstages.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.projectstages.datasource.CDConfirmablePhasesList;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ConfirmablePhasesListSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem infoCodeItem;
	private final TextItem statusItem;

	public ConfirmablePhasesListSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDConfirmablePhasesList.getInstance());
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setWidth("*");
		statusItem = new TextItem("status", "结算状态");
		statusItem.hide();
		setItems(contractCodeItem, contractNameItem, infoCodeItem, statusItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
