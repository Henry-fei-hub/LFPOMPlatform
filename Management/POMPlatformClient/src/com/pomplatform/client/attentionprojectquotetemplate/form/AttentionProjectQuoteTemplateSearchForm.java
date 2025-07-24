package com.pomplatform.client.attentionprojectquotetemplate.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.attentionprojectquotetemplate.datasource.CDAttentionProjectQuoteTemplate;

public class AttentionProjectQuoteTemplateSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final TextItem projectNameItem;
	private final ComboBoxItem employeeIdItem;
	private final TextItem operateEmployeeIdItem;
	private final SelectItem businessTypeItem;

	public AttentionProjectQuoteTemplateSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAttentionProjectQuoteTemplate.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.setHidden(true);
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		
		
		
		employeeIdItem = new ComboBoxItem("employeeId", "创建人");
		employeeIdItem.setWidth("*");
		KeyValueManager.loadValueMap("employees", employeeIdItem);
		
		
		
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		operateEmployeeIdItem.setHidden(true);
		
		
		businessTypeItem = new SelectItem("businessType", "业务类别");
		businessTypeItem.setWidth("*");
		KeyValueManager.loadValueMap("pre_business_type", businessTypeItem);

		setItems(processTypeItem, projectNameItem, employeeIdItem, operateEmployeeIdItem, businessTypeItem);


		setNumCols(16);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
