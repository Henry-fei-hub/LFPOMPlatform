package com.pomplatform.client.project.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.project.datasource.CDSprojectpbpor;

public class SprojectpbporSearchForm extends SearchForm
{


	private final SelectItem projectTypeItem;
	private final TextItem businessLineItem;
	private final SelectItem pricingTypeItem;
	private final TextItem contractCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final ComboBoxItem plateIdItem;
	private final BooleanItem isHasPriceItem;
	private final SelectItem projectFlagItem;

	public SprojectpbporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSprojectpbpor.getInstance());
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		contractCodeItem = new TextItem("contractCode", "订单编号");
		contractCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		
		projectTypeItem = new SelectItem("projectType", "项目类别");
		projectTypeItem.setWidth("*");
		KeyValueManager.loadValueMap("system_dictionary_32", projectTypeItem );
		
		pricingTypeItem = new SelectItem("pricingType", "定价类型");
		pricingTypeItem.setWidth("*");
		KeyValueManager.loadValueMap("system_dictionary_207", pricingTypeItem);
		businessLineItem = new TextItem("businessLine", "业务条线");
		businessLineItem.hide();
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.hide();
		
		projectFlagItem = new SelectItem("projectFlag","项目类型标识");
		projectFlagItem.setWidth("*");
		projectFlagItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_71"));
		
		isHasPriceItem =new BooleanItem("isHasPrice","是否有补贴");
		isHasPriceItem.setWidth("*");

		setItems(projectTypeItem, businessLineItem, pricingTypeItem, contractCodeItem, projectCodeItem, projectNameItem, plateIdItem,projectFlagItem,isHasPriceItem);

		setNumCols(14);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
