package com.pomplatform.client.employeeaccountrecordeeppccmmpebor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeeaccountrecordeeppccmmpebor.datasource.CDMemployeeaccountrecordeeppccmmpebor;

public class MemployeeaccountrecordeeppccmmpeborSearchForm extends SearchForm
{


	private final DateItem minRecordDateItem;
	private final DateItem maxRecordDateItem;
	private final TextItem plateIdItem;
	private final SelectItem employeeIdItem;
	private final TextItem businessTypeIdItem;

	public MemployeeaccountrecordeeppccmmpeborSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMemployeeaccountrecordeeppccmmpebor.getInstance());
		minRecordDateItem = new DateItem("minRecordDate", "开始日期");
		minRecordDateItem.setWidth("*");
		minRecordDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minRecordDateItem);
			}
		});
		maxRecordDateItem = new DateItem("maxRecordDate", "结束日期");
		maxRecordDateItem.setWidth("*");
		maxRecordDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxRecordDateItem);
			}
		});
		plateIdItem = new TextItem("plateId", "业务部门ID");
		plateIdItem.hide();
		employeeIdItem = new SelectItem("employeeId", "员工");
		employeeIdItem.hide();
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		businessTypeIdItem = new TextItem("businessTypeId", "类型");
		businessTypeIdItem.hide();

		setItems(minRecordDateItem, maxRecordDateItem, plateIdItem, employeeIdItem, businessTypeIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
