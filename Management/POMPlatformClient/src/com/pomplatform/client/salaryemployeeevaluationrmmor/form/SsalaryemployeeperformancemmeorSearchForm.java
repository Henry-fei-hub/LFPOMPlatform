package com.pomplatform.client.salaryemployeeevaluationrmmor.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.salaryemployeeevaluationrmmor.datasource.CDSsalaryemployeeperformancemmeor;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class SsalaryemployeeperformancemmeorSearchForm extends SearchForm
{


	private final DateItem minHappenDateItem;
	private final DateItem maxHappenDateItem;
	private final TextItem employeeNoItem;
	private final TextItem salaryEmployeePerformanceIdItem;
	private final ComboBoxItem employeeIdItem;
	private final SelectItem plateIdItem;
	private final SelectItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final SelectItem statusItem;
	private final TextItem shouldDaysItem;
	private final TextItem factDaysItem;
	private final TextItem yearItem;
	private final TextItem monthItem;
	private final TextItem gradeItem;
	private final TextItem proportionItem;
	private final TextItem workingCoefficientItem;
	private final TextItem actualPerformancePayItem;

	public SsalaryemployeeperformancemmeorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSsalaryemployeeperformancemmeor.getInstance());
		minHappenDateItem = new DateItem("minHappenDate", "最早发生日期");
		minHappenDateItem.setWidth("*");
		minHappenDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minHappenDateItem);
			}
		});
		maxHappenDateItem = new DateItem("maxHappenDate", "最晚发生日期");
		maxHappenDateItem.setWidth("*");
		maxHappenDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxHappenDateItem);
			}
		});
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		salaryEmployeePerformanceIdItem = new TextItem("salaryEmployeePerformanceId", "主键");
		salaryEmployeePerformanceIdItem.hide();
		
		employeeIdItem = new ComboBoxItem("employeeId", "员工");
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		plateIdItem = new SelectItem("plateId", "业务部门编码");
		plateIdItem.setWidth("*");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		departmentIdItem = new SelectItem("departmentId", "所属部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		statusItem = new SelectItem("status", "员工状态");
		statusItem.setWidth("*");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));
		shouldDaysItem = new TextItem("shouldDays", "应到天数");
		shouldDaysItem.hide();
		shouldDaysItem.setWidth("*");
		factDaysItem = new TextItem("factDays", "实到天数");
		factDaysItem.hide();
		yearItem = new TextItem("year", "年");
		yearItem.setWidth("*");
		yearItem.hide();
		monthItem = new TextItem("month", "月");
		monthItem.setWidth("*");
		monthItem.hide();
		
		gradeItem = new TextItem("grade", "等级");
		gradeItem.hide();
		proportionItem = new TextItem("proportion", "比例");
		proportionItem.hide();
		workingCoefficientItem = new TextItem("workingCoefficient", "工作系数");
		workingCoefficientItem.hide();
		actualPerformancePayItem = new TextItem("actualPerformancePay", "实发绩效");
		actualPerformancePayItem.hide();

		setItems(minHappenDateItem, maxHappenDateItem, employeeNoItem, salaryEmployeePerformanceIdItem, employeeIdItem, plateIdItem, departmentIdItem, companyIdItem, statusItem, shouldDaysItem, factDaysItem, yearItem, monthItem, gradeItem, proportionItem, workingCoefficientItem, actualPerformancePayItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
