package com.pomplatform.client.company.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.company.datasource.CDCompanyIntegralSubcontract;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class CompanyIntegralSubcontractSearchForm extends SearchForm {

	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final SelectItem businessTypeItem;
	private final SelectItem projectTypeItem;
	private final ComboBoxItem departmentIdItem;
	private final TextItem subContractCodeItem;
	private final TextItem subContractNameItem;

	public CompanyIntegralSubcontractSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCompanyIntegralSubcontract.getInstance());
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		startDateItem.hide();

		endDateItem = new DateItem("endDate", "截止日期");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});
		endDateItem.hide();

		businessTypeItem = new SelectItem("businessType", "业务类别");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		businessTypeItem.hide();

		projectTypeItem = new SelectItem("projectType", "项目类别");
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		projectTypeItem.hide();

		departmentIdItem = new ComboBoxItem("departmentId", "承接部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		departmentIdItem.setChangeOnKeypress(false);
		departmentIdItem.hide();

		subContractCodeItem = new TextItem("subContractCode", "订单编号");
		subContractCodeItem.setWidth("*");

		subContractNameItem = new TextItem("subContractName", "订单名称");
		subContractNameItem.setWidth("*");

		setItems(startDateItem, endDateItem, businessTypeItem, projectTypeItem, departmentIdItem, subContractCodeItem,
				subContractNameItem);

		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
