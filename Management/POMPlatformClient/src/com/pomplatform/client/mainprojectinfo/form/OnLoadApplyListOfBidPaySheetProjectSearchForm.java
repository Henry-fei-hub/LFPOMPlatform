package com.pomplatform.client.mainprojectinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.mainprojectinfo.datasource.CDOnLoadApplyListOfBidPaySheetProject;

public class OnLoadApplyListOfBidPaySheetProjectSearchForm extends SearchForm
{


	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem employeeIdItem;

	public OnLoadApplyListOfBidPaySheetProjectSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadApplyListOfBidPaySheetProject.getInstance());
		projectCodeItem = new TextItem("projectCode", "订单编号");
		projectCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "订单名称");
		projectNameItem.setWidth("*");
		contractCodeItem = new TextItem("contractCode", "工号");
		contractCodeItem.hide();
		contractNameItem = new TextItem("contractName", "计划安排");
		contractNameItem.hide();
		employeeIdItem = new ComboBoxItem("employeeId", "申请人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.hide();
		
		setItems(employeeIdItem, projectCodeItem, projectNameItem, contractCodeItem, contractNameItem);
		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
