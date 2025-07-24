package com.pomplatform.client.projectsuredaterecord.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectsuredaterecord.datasource.CDProjectSureDateRecord;

public class ProjectSureDateRecordSearchForm extends SearchForm
{


	private final SelectItem plateIdItem;
	private final TextItem projectNameItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public ProjectSureDateRecordSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDProjectSureDateRecord.getInstance());
		plateIdItem = new SelectItem("plateId", "部门");
		plateIdItem.setWidth("*");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateItem("endDate", "结束日期");
		endDateItem.setWidth("*");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});

		setItems(plateIdItem, projectNameItem, startDateItem, endDateItem);

		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
