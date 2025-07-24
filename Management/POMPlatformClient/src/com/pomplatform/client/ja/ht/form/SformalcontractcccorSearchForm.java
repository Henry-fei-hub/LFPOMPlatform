package com.pomplatform.client.ja.ht.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ja.ht.datasource.CDSformalcontractcccor;

public class SformalcontractcccorSearchForm extends SearchForm
{


	private final TextItem contractNameItem;
	private final TextItem clientContractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem projectCodeItem;
	private final SelectItem projectLevelItem;
	private final DateTimeItem createTimeItem;
	private final SelectItem businessTypeItem;
	private final SelectItem projectTypeItem;

	public SformalcontractcccorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSformalcontractcccor.getInstance());
		contractNameItem = new TextItem("contractName", "正式合同名称");
		contractNameItem.setWidth("*");
		clientContractIdItem = new TextItem("clientContractId", "客户合同编号");
		clientContractIdItem.setWidth("*");
		contractCodeItem = new TextItem("contractCode", "正式合同编号");
		contractCodeItem.setWidth("*");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectCodeItem.setHidden(true);
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.setHidden(true);
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setWidth("*");
		createTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, createTimeItem);
			}
		});
		businessTypeItem = new SelectItem("businessType", "业务类别");
		businessTypeItem.setWidth("*");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		projectTypeItem = new SelectItem("projectType", "项目类别");
		projectTypeItem.setWidth("*");
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));

		setItems(businessTypeItem, projectTypeItem,contractNameItem, clientContractIdItem, contractCodeItem, projectCodeItem, projectLevelItem, createTimeItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
