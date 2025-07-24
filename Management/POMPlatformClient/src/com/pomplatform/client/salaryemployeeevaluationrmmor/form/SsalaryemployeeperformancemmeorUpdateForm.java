package com.pomplatform.client.salaryemployeeevaluationrmmor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.salaryemployeeevaluationrmmor.datasource.DSSsalaryemployeeperformancemmeor;

public class SsalaryemployeeperformancemmeorUpdateForm extends AbstractWizadPage
{


	private final TextItem salaryEmployeePerformanceIdItem;
	private final TextItem employeeNoItem;
	private final SelectItem employeeIdItem;
	private final TextItem plateIdItem;
	private final SelectItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final SelectItem statusItem;
	private final TextItem monthPayItem;
	private final TextItem basicProportionStrItem;
	private final TextItem basicProportionItem;
	private final TextItem monthBasicPayItem;
	private final TextItem monthPerformancePayItem;
	private final TextItem shouldDaysItem;
	private final TextItem factDaysItem;
	private final TextItem yearItem;
	private final TextItem monthItem;
	private final DateItem happenDateItem;
	private final DateTimeItem createTimeItem;
	private final TextItem gradeItem;
	private final TextItem proportionItem;
	private final TextItem workingCoefficientItem;
	private final TextItem actualPerformancePayItem;

	public SsalaryemployeeperformancemmeorUpdateForm() {
		DSSsalaryemployeeperformancemmeor ds = DSSsalaryemployeeperformancemmeor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		salaryEmployeePerformanceIdItem = new TextItem("salaryEmployeePerformanceId", "主键");
		salaryEmployeePerformanceIdItem.setDisabled(true);
		salaryEmployeePerformanceIdItem.setRequired(true);
		IsIntegerValidator salaryEmployeePerformanceIdValidator = new IsIntegerValidator();
		salaryEmployeePerformanceIdItem.setValidators(salaryEmployeePerformanceIdValidator);
		__formItems.add(salaryEmployeePerformanceIdItem);
		employeeNoItem = new TextItem("employeeNo", "工号");
		__formItems.add(employeeNoItem);
		employeeIdItem = new SelectItem("employeeId", "员工主键");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(employeeIdItem);
		plateIdItem = new TextItem("plateId", "业务部门");
		__formItems.add(plateIdItem);
		departmentIdItem = new SelectItem("departmentId", "所属部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		__formItems.add(departmentIdItem);
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		__formItems.add(companyIdItem);
		statusItem = new SelectItem("status", "员工状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));
		__formItems.add(statusItem);
		monthPayItem = new TextItem("monthPay", "月薪");
		__formItems.add(monthPayItem);
		basicProportionStrItem = new TextItem("basicProportionStr", "基本比例");
		__formItems.add(basicProportionStrItem);
		basicProportionItem = new TextItem("basicProportion", "基本比例");
		__formItems.add(basicProportionItem);
		monthBasicPayItem = new TextItem("monthBasicPay", "月基本工资");
		__formItems.add(monthBasicPayItem);
		monthPerformancePayItem = new TextItem("monthPerformancePay", "月绩效工资");
		__formItems.add(monthPerformancePayItem);
		shouldDaysItem = new TextItem("shouldDays", "应到天数");
		__formItems.add(shouldDaysItem);
		factDaysItem = new TextItem("factDays", "实到天数");
		__formItems.add(factDaysItem);
		yearItem = new TextItem("year", "年");
		__formItems.add(yearItem);
		monthItem = new TextItem("month", "月");
		__formItems.add(monthItem);
		happenDateItem = new DateItem("happenDate", "发生日期");
		__formItems.add(happenDateItem);
		createTimeItem = new DateTimeItem("createTime", "创建日期");
		__formItems.add(createTimeItem);
		gradeItem = new TextItem("grade", "等级");
		__formItems.add(gradeItem);
		proportionItem = new TextItem("proportion", "比例");
		__formItems.add(proportionItem);
		workingCoefficientItem = new TextItem("workingCoefficient", "工作系数");
		__formItems.add(workingCoefficientItem);
		actualPerformancePayItem = new TextItem("actualPerformancePay", "实发绩效");
		__formItems.add(actualPerformancePayItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSsalaryemployeeperformancemmeor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
