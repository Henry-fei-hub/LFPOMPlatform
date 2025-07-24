package com.pomplatform.client.threadtask.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.threadtask.datasource.CDSthreadtaskmanagemmmor;

public class SthreadtaskmanagemmmorSearchForm extends SearchForm {

	private final DateTimeItem minBeginTimeItem;
	private final DateTimeItem maxBeginTimeItem;
	private final DateTimeItem minEndTimeItem;
	private final DateTimeItem maxEndTimeItem;
	private final DateTimeItem minCreateTimeItem;
	private final DateTimeItem maxCreateTimeItem;
	private final TextItem errorMsgItem;
	private final TextItem remarkItem;
	private final TextItem threadTaskManageIdItem;
	private final SelectItem taskTypeItem;
	private final SelectItem statusItem;
	private final ComboBoxItem operatorItem;
	private final SelectItem operationTypeItem;

	public SthreadtaskmanagemmmorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSthreadtaskmanagemmmor.getInstance());
		minBeginTimeItem = new DateTimeItem("minBeginTime", "最早开始时间");
		minBeginTimeItem.hide();
		minBeginTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minBeginTimeItem);
			}
		});
		maxBeginTimeItem = new DateTimeItem("maxBeginTime", "最晚开始时间");
		maxBeginTimeItem.hide();
		maxBeginTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxBeginTimeItem);
			}
		});
		minEndTimeItem = new DateTimeItem("minEndTime", "最早结束时间");
		minEndTimeItem.hide();
		minEndTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minEndTimeItem);
			}
		});
		maxEndTimeItem = new DateTimeItem("maxEndTime", "最晚结束时间");
		maxEndTimeItem.hide();
		maxEndTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxEndTimeItem);
			}
		});
		minCreateTimeItem = new DateTimeItem("minCreateTime", "最早创建时间");
		minCreateTimeItem.hide();
		minCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCreateTimeItem);
			}
		});
		maxCreateTimeItem = new DateTimeItem("maxCreateTime", "最晚创建时间");
		maxCreateTimeItem.hide();
		maxCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCreateTimeItem);
			}
		});

		errorMsgItem = new TextItem("errorMsg", "错误信息");
		errorMsgItem.setWidth("*");

		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");

		threadTaskManageIdItem = new TextItem("threadTaskManageId", "任务ID");
		threadTaskManageIdItem.setWidth("*");

		taskTypeItem = new SelectItem("taskType", "任务类型");
		taskTypeItem.setWidth("*");
		taskTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_166"));

		statusItem = new SelectItem("status", "任务状态");
		statusItem.setWidth("*");
		;
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_165"));

		operatorItem = new ComboBoxItem("operator", "操作人");
		operatorItem.setValueMap(KeyValueManager.getValueMap("employees"));
		operatorItem.setChangeOnKeypress(false);
		operatorItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		operatorItem.setWidth("*");

		operationTypeItem = new SelectItem("operationType", "操作类型");
		operationTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_167"));
		operationTypeItem.setWidth("*");

		setItems(minBeginTimeItem, maxBeginTimeItem, minEndTimeItem, maxEndTimeItem, minCreateTimeItem,
				maxCreateTimeItem, threadTaskManageIdItem, taskTypeItem, statusItem, operatorItem, operationTypeItem,
				errorMsgItem, remarkItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
