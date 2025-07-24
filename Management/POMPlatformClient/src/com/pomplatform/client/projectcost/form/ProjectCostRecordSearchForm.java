package com.pomplatform.client.projectcost.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.projectcost.datasource.CDProjectCostRecord;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class ProjectCostRecordSearchForm extends SearchForm {

	private final ComboBoxItem designTeamItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;
	private final ComboBoxItem employeeIdItem;
	private final ComboBoxItem departmentIdItem;

	public ProjectCostRecordSearchForm() {
		final String plateIds = PomPlatformClientUtil.getRolePlateId();
		setWidth100();
		setHeight100();
		setDataSource(CDProjectCostRecord.getInstance());
		designTeamItem = new ComboBoxItem("designTeam", "主办设计团队");
		designTeamItem.setWidth("*");
		designTeamItem.setValueMap(KeyValueManager.getValueMap("departments"));
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		startDateItem = new DateTimeItem("startDate", "开始时间");
		startDateItem.setWidth("*");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateTimeItem("endDate", "结束时间");
		endDateItem.setWidth("*");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});
		employeeIdItem = new ComboBoxItem("employeeId", "报销人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		departmentIdItem = new ComboBoxItem("departmentId", "报销部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));

		setItems(designTeamItem, projectCodeItem, projectNameItem, startDateItem, endDateItem, employeeIdItem, departmentIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
