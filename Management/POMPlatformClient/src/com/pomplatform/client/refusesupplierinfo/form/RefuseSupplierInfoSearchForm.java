package com.pomplatform.client.refusesupplierinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.refusesupplierinfo.datasource.CDRefuseSupplierInfo;

public class RefuseSupplierInfoSearchForm extends SearchForm
{


	private final TextItem supplierNameItem;
	private final DateTimeItem createTimeStartItem;
	private final DateTimeItem createTimeEndItem;
	private final ComboBoxItem employeeIdItem;
	private final SelectItem areasExpertiseItem;

	public RefuseSupplierInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDRefuseSupplierInfo.getInstance());
		supplierNameItem = new TextItem("supplierName", "供应商名称");
		supplierNameItem.setWidth("*");
		
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
		KeyValueManager.loadValueMap("employees", employeeIdItem);
		employeeIdItem.setWidth("*");
		
		areasExpertiseItem = new SelectItem("areasExpertise", "擅长领域");
		KeyValueManager.loadValueMap("system_dictionary_213", areasExpertiseItem);
		areasExpertiseItem.setWidth("*");
		
		

		setItems(supplierNameItem,areasExpertiseItem,createTimeStartItem, createTimeEndItem, employeeIdItem);
		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
