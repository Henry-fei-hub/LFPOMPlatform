package com.pomplatform.client.refuseprojectquotetemplate.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.refuseprojectquotetemplate.datasource.CDRefuseProjectQuoteTemplate;

public class RefuseProjectQuoteTemplateSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final TextItem projectNameItem;
	private final DateTimeItem createTimeStartItem;
	private final DateTimeItem createTimeEndItem;
	private final ComboBoxItem employeeIdItem;
	private final TextItem operateEmployeeIdItem;
	private final SelectItem businessTypeItem;

	public RefuseProjectQuoteTemplateSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDRefuseProjectQuoteTemplate.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.setHidden(true);
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		
		createTimeStartItem = new DateTimeItem("createTimeStart", "创建开始时间");
		createTimeStartItem.setWidth("*");
		createTimeStartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, createTimeStartItem);
			}
		});
		createTimeEndItem = new DateTimeItem("createTimeEnd", "创建结束时间");
		createTimeEndItem.setWidth("*");
		createTimeEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, createTimeEndItem);
			}
		});
		
		employeeIdItem = new ComboBoxItem("employeeId", "创建人");
		employeeIdItem.setWidth("*");
		KeyValueManager.loadValueMap("employees", employeeIdItem);
		
		
		
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		operateEmployeeIdItem.setHidden(true);
		
		
		businessTypeItem = new SelectItem("businessType", "业务类别");
		businessTypeItem.setWidth("*");
		KeyValueManager.loadValueMap("pre_business_type", businessTypeItem);

		setItems(processTypeItem, projectNameItem, createTimeStartItem, createTimeEndItem, employeeIdItem, operateEmployeeIdItem,  businessTypeItem);

		setNumCols(16);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
