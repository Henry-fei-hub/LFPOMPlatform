package com.pomplatform.client.ja.ht.form;

import java.util.*;

import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ja.ht.datasource.CDContractPrice;

public class ContractPriceSearchForm extends SearchForm
{


	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
//	private final TextItem customerNameItem;
	private final SelectItem mainProjectStageIdItem;
	private final ComboBoxItem clientIdItem;
	private final ComboBoxItem customerIdItem;

	public ContractPriceSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractPrice.getInstance());
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		mainProjectStageIdItem = new SelectItem("mainProjectStageId", "立项类型");
		mainProjectStageIdItem.setWidth("*");
		mainProjectStageIdItem.setValueMap(KeyValueManager.getValueMap("main_project_stages"));
//		customerNameItem = new TextItem("customerName", "客户名称");
//		customerNameItem.setWidth("*");
		customerIdItem = new ComboBoxItem("customerId", "集团名称");
		customerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("customers", customerIdItem);
		customerIdItem.setWidth("*");

		clientIdItem = new ComboBoxItem("clientId", "客户名称");
		clientIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("customers", clientIdItem);
		clientIdItem.setWidth("*");

		setItems(projectCodeItem, projectNameItem, mainProjectStageIdItem,customerIdItem,clientIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
