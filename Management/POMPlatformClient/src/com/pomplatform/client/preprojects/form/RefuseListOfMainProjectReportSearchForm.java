package com.pomplatform.client.preprojects.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.preprojects.datasource.CDRefuseListOfMainProjectReport;
import com.pomplatform.client.preprojects.datasource.CDRefuseListOfPreProjectReport;

public class RefuseListOfMainProjectReportSearchForm extends SearchForm
{

	private final TextItem processTypeItem;
	private final TextItem processStatusItem;
	private final TextItem projectNameItem;
	private final SelectItem projectTypeItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;
	private final SelectItem employeeIdItem;

	public RefuseListOfMainProjectReportSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDRefuseListOfPreProjectReport.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.setHidden(true);
		
		processStatusItem = new TextItem("processStatus", "流程状态");
		processStatusItem.setHidden(true);
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		
		projectTypeItem = new SelectItem("projectType", "项目业态");
//		projectTypeItem.setValueMap(KeyValueManager.getValueMap("pre_business_type"));
		KeyValueManager.loadValueMap("pre_business_type",projectTypeItem);
		projectTypeItem.setWidth("*");
		
		startDateItem = new DateTimeItem("startDate", "开始时间");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		
		endDateItem = new DateTimeItem("endDate", "截止时间");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		
		employeeIdItem = new SelectItem("employeeId", "创建人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setHidden(true);

		setItems(processTypeItem, processStatusItem, projectNameItem, projectTypeItem, startDateItem, endDateItem, employeeIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
