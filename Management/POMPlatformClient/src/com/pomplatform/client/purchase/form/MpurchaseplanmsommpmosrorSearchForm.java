package com.pomplatform.client.purchase.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.purchase.datasource.CDMpurchaseplanmsommpmosror;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class MpurchaseplanmsommpmosrorSearchForm extends SearchForm {

	private final TextItem operatorIdItem;
	private final DateItem minPurchaseDateItem;
	private final DateItem maxPurchaseDateItem;
	private final TextItem personInChargeItem;
	private final TextItem mainProjectIdItem;
	private final TextItem oriPersonnelBusinessIdItem;
	private final TextItem supplierIdItem;
	private final TextItem remarkItem;
	private final TextItem projectNameItem;
	private final SelectItem projectCodeItem;
	private final TextItem supplierNameItem;
	private final SelectItem dealStatusItem;

	public MpurchaseplanmsommpmosrorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMpurchaseplanmsommpmosror.getInstance());
		operatorIdItem = new TextItem("operatorId", "操作人(指派人)");
		operatorIdItem.hide();

		minPurchaseDateItem = new DateItem("minPurchaseDate", "最早采购日期");
		minPurchaseDateItem.setWidth("*");
		minPurchaseDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minPurchaseDateItem);
			}
		});
		maxPurchaseDateItem = new DateItem("maxPurchaseDate", "最晚采购日期");
		maxPurchaseDateItem.setWidth("*");
		maxPurchaseDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxPurchaseDateItem);
			}
		});
		personInChargeItem = new TextItem("personInCharge", "负责人");
		personInChargeItem.hide();

		mainProjectIdItem = new TextItem("mainProjectId", "大项目主键");
		mainProjectIdItem.hide();

		oriPersonnelBusinessIdItem = new TextItem("oriPersonnelBusinessId", "源流程业务主键");
		oriPersonnelBusinessIdItem.hide();

		supplierIdItem = new TextItem("supplierId", "供应商主键");
		supplierIdItem.hide();

		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");

		projectCodeItem = new SelectItem("projectCode", "项目编号");
		projectCodeItem.hide();
		
		supplierNameItem = new TextItem("supplierName", "供应商名称");
		supplierNameItem.setWidth("*");
		
		dealStatusItem = new SelectItem("dealStatus", "处理状态");
		dealStatusItem.setWidth("*");
		dealStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_207"));

		setItems(operatorIdItem, minPurchaseDateItem, maxPurchaseDateItem, personInChargeItem, mainProjectIdItem,
				oriPersonnelBusinessIdItem, supplierIdItem, remarkItem, projectNameItem, projectCodeItem,
				supplierNameItem, dealStatusItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
