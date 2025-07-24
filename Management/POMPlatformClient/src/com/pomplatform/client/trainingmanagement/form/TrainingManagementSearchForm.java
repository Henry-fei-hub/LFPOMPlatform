package com.pomplatform.client.trainingmanagement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.trainingmanagement.datasource.CDTrainingManagement;

public class TrainingManagementSearchForm extends SearchForm
{


	private final TextItem trainingManagementIdItem;
	private final TextItem subjectItem;
	private final DateTimeItem createTimeItem;
	private final DateTimeItem startTimeItem;
	private final DateTimeItem endTimeItem;
	private final PickTreeItem departmentIdItem;
	private final TextItem createPersonIdItem;
	private final SelectItem employeeIdItem;
	private final TextItem courseScoreItem;
	private final TextItem compereItem;

	public TrainingManagementSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDTrainingManagement.getInstance());
		trainingManagementIdItem = new TextItem("trainingManagementId", "主键编码");
		trainingManagementIdItem.setWidth("*");
		subjectItem = new TextItem("subject", "主题");
		subjectItem.setWidth("*");

		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setHidden(true);
		createTimeItem.setWidth("*");
		createTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, createTimeItem);
			}
		});

		startTimeItem = new DateTimeItem("startTime", "开始时间");
		startTimeItem.setWidth("*");
		startTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startTimeItem);
			}
		});
		endTimeItem = new DateTimeItem("endTime", "结束时间");
		endTimeItem.setWidth("*");
		endTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endTimeItem);
			}
		});
		departmentIdItem = new PickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments", "0"));
		createPersonIdItem = new TextItem("createPersonId", "创建人");
		createPersonIdItem.setWidth("*");
		employeeIdItem = new SelectItem("employeeId", "员工");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		courseScoreItem = new TextItem("courseScore", "课程分数");
		courseScoreItem.setWidth("*");
		compereItem = new TextItem("compere", "主持人");
		compereItem.setWidth("*");

		setItems(trainingManagementIdItem, subjectItem, createTimeItem, departmentIdItem, createPersonIdItem, employeeIdItem, courseScoreItem, compereItem,startTimeItem,endTimeItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
