package com.pomplatform.client.mainprojectinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.mainprojectinfo.datasource.CDOnLoadBidPaySheetProjectSummary;

public class OnLoadBidPaySheetProjectSummarySearchForm extends SearchForm
{


	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final ComboBoxItem employeeIdItem;

	public OnLoadBidPaySheetProjectSummarySearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadBidPaySheetProjectSummary.getInstance());
		employeeIdItem = new ComboBoxItem("employeeId", "申请人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		contractIdItem = new TextItem("contractId", "合同id");
		contractIdItem.hide();
		contractCodeItem = new TextItem("contractCode", "订单编号");
		contractCodeItem.hide();
		contractNameItem = new TextItem("contractName", "订单名称");
		contractNameItem.hide();


		setItems(employeeIdItem,projectCodeItem, projectNameItem, contractIdItem, contractCodeItem, contractNameItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
