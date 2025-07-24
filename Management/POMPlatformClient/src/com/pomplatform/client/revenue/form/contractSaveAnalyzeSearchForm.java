package com.pomplatform.client.revenue.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.revenue.datasource.CDcontractSaveAnalyze;

public class contractSaveAnalyzeSearchForm extends SearchForm
{


	private final ComboBoxItem projectIdItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem yearItem;

	public contractSaveAnalyzeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDcontractSaveAnalyze.getInstance());
		projectIdItem = new ComboBoxItem("projectId", "项目编码");
		projectIdItem.setWidth("*");
		projectIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectIdItem.setValueMap(KeyValueManager.getValueMap("projects"));
		projectIdItem.hide();
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		yearItem = new SelectItem("year", "年份");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.setWidth("*");
		Date currentDate = new Date();
		yearItem.setDefaultValue(currentDate.getYear()+1900);
		
		setItems(projectIdItem, plateIdItem, yearItem);
		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
