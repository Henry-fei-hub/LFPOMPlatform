package com.pomplatform.client.attentionsupplierinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.attentionsupplierinfo.datasource.CDAttentionSupplierInfo;

public class AttentionSupplierInfoSearchForm extends SearchForm
{


	private final SelectItem statusItem;
	private final TextItem supplierNameItem;
	private final DateTimeItem operateTimeStartItem;
	private final DateTimeItem operateTimeEndItem;
	private final SelectItem areasExpertiseItem;

	public AttentionSupplierInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAttentionSupplierInfo.getInstance());
		statusItem = new SelectItem("status", "状态");
		statusItem.setWidth("*");
		KeyValueManager.loadValueMap("system_dictionary_38",statusItem);
		
		
		
		supplierNameItem = new TextItem("supplierName", "供应商名称");
		supplierNameItem.setWidth("*");
		
		
		operateTimeStartItem = new DateTimeItem("operateTimeStart", "创建开始时间");
		operateTimeStartItem.setWidth("*");
		operateTimeStartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, operateTimeStartItem);
			}
		});
		
		operateTimeEndItem = new DateTimeItem("operateTimeEnd", "创建结束时间");
		operateTimeEndItem.setWidth("*");
		operateTimeEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, operateTimeEndItem);
			}
		});
		
		areasExpertiseItem = new SelectItem("areasExpertise", "擅长领域");
		KeyValueManager.loadValueMap("system_dictionary_213", areasExpertiseItem);
		areasExpertiseItem.setWidth("*");

		setItems(supplierNameItem,areasExpertiseItem,statusItem,operateTimeStartItem,operateTimeEndItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
