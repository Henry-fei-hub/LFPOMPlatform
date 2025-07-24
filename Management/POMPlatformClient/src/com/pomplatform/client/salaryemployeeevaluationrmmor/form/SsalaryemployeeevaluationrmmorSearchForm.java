package com.pomplatform.client.salaryemployeeevaluationrmmor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.salaryemployeeevaluationrmmor.datasource.CDSsalaryemployeeevaluationrmmor;

public class SsalaryemployeeevaluationrmmorSearchForm extends SearchForm {

	private final TextItem remarkItem;
	private final DateTimeItem minOperateTimeItem;
	private final DateTimeItem maxOperateTimeItem;
	private final DateItem minHappenDateItem;
	private final DateItem maxHappenDateItem;
	private final TextItem salaryEmployeeEvaluationIdItem;
	private final ComboBoxItem employeeIdItem;
	private final TextItem yearItem;
	private final TextItem monthItem;
	private final SelectItem gradeItem;
	private final TextItem operateEmployeeIdItem;

	public SsalaryemployeeevaluationrmmorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSsalaryemployeeevaluationrmmor.getInstance());
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		remarkItem.hide();

		minOperateTimeItem = new DateTimeItem("minOperateTime", "最早操作时间");
		minOperateTimeItem.setWidth("*");
		minOperateTimeItem.hide();
		minOperateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minOperateTimeItem);
			}
		});
		maxOperateTimeItem = new DateTimeItem("maxOperateTime", "最晚操作时间");
		maxOperateTimeItem.hide();
		maxOperateTimeItem.setWidth("*");
		maxOperateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxOperateTimeItem);
			}
		});
		minHappenDateItem = new DateItem("minHappenDate", "最早绩效发生时间");
		minHappenDateItem.setWidth("*");
		minHappenDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minHappenDateItem);
			}
		});
		maxHappenDateItem = new DateItem("maxHappenDate", "最晚绩效发生时间");
		maxHappenDateItem.setWidth("*");
		maxHappenDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxHappenDateItem);
			}
		});
		salaryEmployeeEvaluationIdItem = new TextItem("salaryEmployeeEvaluationId", "主键");
		salaryEmployeeEvaluationIdItem.hide();
		employeeIdItem = new ComboBoxItem("employeeId", "员工");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		yearItem = new TextItem("year", "年份");
		yearItem.hide();
		monthItem = new TextItem("month", "月份");
		monthItem.hide();
		gradeItem = new SelectItem("grade", "等级");
		gradeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_99"));
		gradeItem.setWidth("*");
		
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		operateEmployeeIdItem.hide();

		setItems(remarkItem, minOperateTimeItem, maxOperateTimeItem, minHappenDateItem, maxHappenDateItem,
				salaryEmployeeEvaluationIdItem, employeeIdItem, yearItem, monthItem, gradeItem, operateEmployeeIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
