package com.pomplatform.client.aboutprojectquotetemplatesparent.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.aboutprojectquotetemplatesparent.datasource.CDAboutProjectQuoteTemplatesParent;

public class AboutProjectQuoteTemplatesParentSearchForm extends SearchForm
{


	private final TextItem parentNameItem;
	private final SelectItem businessTypeItem;
	private final SelectItem companyIdItem;
	private final ComboBoxItem createEmployeeIdItem;
	private final DateItem createDateStartItem;
	private final DateItem createDateEndItem;
	private final TextItem remarkItem;

	public AboutProjectQuoteTemplatesParentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAboutProjectQuoteTemplatesParent.getInstance());
		parentNameItem = new TextItem("parentName", "模板名称");
		parentNameItem.setWidth("*");
		
		businessTypeItem = new SelectItem("businessType", "业务类别");
		KeyValueManager.loadValueMap("pre_business_type",businessTypeItem);
		businessTypeItem.setWidth("*");
		
		companyIdItem = new SelectItem("companyId", "归属公司");
		KeyValueManager.loadValueMap("company_records",companyIdItem);
		companyIdItem.setWidth("*");
		
		
		createEmployeeIdItem = new ComboBoxItem("createEmployeeId", "创建人");
		KeyValueManager.loadValueMap("employees", createEmployeeIdItem);
		createEmployeeIdItem.setWidth("*");
		
		createDateStartItem = new DateItem("createDateStart", "创建开始日期");
		createDateStartItem.setWidth("*");
		createDateStartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, createDateStartItem);
			}
		});
		createDateEndItem = new DateItem("createDateEnd", "创建结束日期");
		createDateEndItem.setWidth("*");
		createDateEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, createDateEndItem);
			}
		});
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setHidden(true);

		setItems(parentNameItem, businessTypeItem, companyIdItem, createEmployeeIdItem, createDateStartItem, createDateEndItem, remarkItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
