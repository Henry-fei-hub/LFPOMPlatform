package com.pomplatform.client.mcapitalcmmssmssbor.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.mcapitalcmmssmssbor.datasource.CDScapitalssmor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class ScapitalssmorSearchForm extends SearchForm {

	private final TextItem selfNameItem;
	private final TextItem selfBankAccountItem;
	private final DateTimeItem minHappenDateItem;
	private final DateTimeItem maxHappenDateItem;

	public ScapitalssmorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDScapitalssmor.getInstance());
		selfNameItem = new TextItem("selfName", "内部公司");
		selfNameItem.setWidth("*");
		selfNameItem.hide();

		selfBankAccountItem = new TextItem("selfBankAccount", "银行账号");
		selfBankAccountItem.setWidth("*");
		selfBankAccountItem.setDisabled(true);

		minHappenDateItem = new DateTimeItem("minHappenDate", "最小发生日期");
		minHappenDateItem.setDisabled(true);
		minHappenDateItem.setWidth("*");
		// minHappenDateItem.hide();
		minHappenDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minHappenDateItem);
			}
		});
		maxHappenDateItem = new DateTimeItem("maxHappenDate", "最大发生日期");
		maxHappenDateItem.setDisabled(true);
		maxHappenDateItem.setWidth("*");
		// maxHappenDateItem.hide();
		maxHappenDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxHappenDateItem);
			}
		});

		setItems(selfNameItem, selfBankAccountItem, minHappenDateItem, maxHappenDateItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
