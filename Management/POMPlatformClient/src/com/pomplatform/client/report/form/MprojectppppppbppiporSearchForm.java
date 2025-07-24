package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDMprojectppppppbppipor;

public class MprojectppppppbppiporSearchForm extends SearchForm
{


	private final TextItem projectIdItem;
	private final SelectItem projectTypeItem;
	private final TextItem businessLineItem;
	private final TextItem pricingTypeItem;
	private final ComboBoxItem plateIdItem;
	private final CheckboxItem isHasPriceItem;
	private final SelectItem projectFlagItem;
	private final TextItem contractCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;

	public MprojectppppppbppiporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMprojectppppppbppipor.getInstance());
		
		projectIdItem = new TextItem("projectId", "项目id");
		projectIdItem.hide();
		
		projectTypeItem = new SelectItem("projectType", "项目类别");
		projectTypeItem.setWidth("*");
		KeyValueManager.loadValueMap("system_dictionary_32", projectTypeItem );
		
		businessLineItem = new TextItem("businessLine", "业务条线");
		businessLineItem.hide();
		
		pricingTypeItem = new TextItem("pricingType", "定价类型");
		pricingTypeItem.hide();
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));	
		
		isHasPriceItem = new CheckboxItem("isHasPrice", "是否有定价子项");
		isHasPriceItem.hide();
		
		projectFlagItem = new SelectItem("projectFlag","项目类型标识");
		projectFlagItem.setWidth("*");
		projectFlagItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_71"));
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractCodeItem.hide();
		
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		
		setItems(plateIdItem,projectIdItem, projectTypeItem, businessLineItem, pricingTypeItem,  isHasPriceItem, projectFlagItem, contractCodeItem, projectCodeItem, projectNameItem);

		setNumCols(11);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
