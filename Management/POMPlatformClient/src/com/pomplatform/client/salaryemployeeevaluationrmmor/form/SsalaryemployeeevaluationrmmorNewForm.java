package com.pomplatform.client.salaryemployeeevaluationrmmor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.salaryemployeeevaluationrmmor.datasource.DSSsalaryemployeeevaluationrmmor;

public class SsalaryemployeeevaluationrmmorNewForm extends AbstractWizadPage
{


	private final SelectItem employeeIdItem;
	private final TextItem yearItem;
	private final TextItem monthItem;
	private final TextItem gradeItem;
	private final DateItem happenDateItem;
	private final TextItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	private final TextItem remarkItem;

	public SsalaryemployeeevaluationrmmorNewForm() {
		DSSsalaryemployeeevaluationrmmor ds = DSSsalaryemployeeevaluationrmmor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		employeeIdItem = new SelectItem("employeeId", "员工主键");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(employeeIdItem);
		yearItem = new TextItem("year", "年份");
		__formItems.add(yearItem);
		monthItem = new TextItem("month", "月份");
		__formItems.add(monthItem);
		gradeItem = new TextItem("grade", "grade");
		__formItems.add(gradeItem);
		happenDateItem = new DateItem("happenDate", "绩效发生时间");
		__formItems.add(happenDateItem);
		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		__formItems.add(operateEmployeeIdItem);
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		__formItems.add(operateTimeItem);
		remarkItem = new TextItem("remark", "备注");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSsalaryemployeeevaluationrmmor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
