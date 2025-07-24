package com.pomplatform.client.capitaldsitributionemployee.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.capitaldsitributionemployee.datasource.CDMemployeeaccountrecordespemmor;

public class MemployeeaccountrecordespemmorSearchForm extends SearchForm
{


	private final TextItem plateIdItem;
	private final SelectItem employeeIdItem;
	private final DateItem minRecordDateItem;
	private final DateItem maxRecordDateItem;

	public MemployeeaccountrecordespemmorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMemployeeaccountrecordespemmor.getInstance());
		plateIdItem = new TextItem("plateId", "所在业务部门");
		employeeIdItem = new SelectItem("employeeId", "职员编码");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		minRecordDateItem = new DateItem("minRecordDate", "最早日期");
		minRecordDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, minRecordDateItem);
			}
		});
		maxRecordDateItem = new DateItem("maxRecordDate", "最晚日期");
		maxRecordDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, maxRecordDateItem);
			}
		});

		setItems(plateIdItem, employeeIdItem, minRecordDateItem, maxRecordDateItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
