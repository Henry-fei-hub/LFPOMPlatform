package com.pomplatform.client.salaryexceptions.form;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.salaryexceptions.datasource.DSOnSalaryExceptions;

public class OnSalaryExceptionsUpdateForm extends AbstractWizadPage
{


	private final TextItem personnelBusinessIdItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	private final TextItem reasonItem;
	private final TextItem remarkItem;
	private final DateTimeItem createTimeItem;
	PersonnelBusinesDetailSalaryExceptionUpdate salaryexception = new PersonnelBusinesDetailSalaryExceptionUpdate();
	public OnSalaryExceptionsUpdateForm() {
		VLayout mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		VLayout topLayout = new VLayout();
		topLayout.setWidth100();
		topLayout.setHeight("15%");
		VLayout buttonLayout = new VLayout();
		buttonLayout.setWidth100();
		buttonLayout.setHeight("70%");
		DSOnSalaryExceptions ds = DSOnSalaryExceptions.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "人事业务编码");
		personnelBusinessIdItem.setDisabled(true);
		personnelBusinessIdItem.setRequired(true);
		IsIntegerValidator personnelBusinessIdValidator = new IsIntegerValidator();
		personnelBusinessIdItem.setValidators(personnelBusinessIdValidator);
		personnelBusinessIdItem.setTextBoxStyle("customInputTextStyle");
		personnelBusinessIdItem.setHidden(true);
		__formItems.add(personnelBusinessIdItem);
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		employeeIdItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(employeeIdItem);
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		employeeNoItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(employeeNoItem);
		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setDisabled(true);
		departmentIdItem.setTextBoxStyle("customInputTextStyle");
		departmentIdItem.setWidth("*");
		__formItems.add(departmentIdItem);
		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setHidden(true);
		__formItems.add(companyIdItem);
		reasonItem = new TextItem("reason", "申请缘由");
		reasonItem.setHidden(true);
		__formItems.add(reasonItem);
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setHidden(true);
		__formItems.add(remarkItem);
		createTimeItem = new DateTimeItem("createTime", "起草时间");
		createTimeItem.setHidden(false);
		createTimeItem.setWidth("*");
		createTimeItem.setDisabled(true);
		createTimeItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(createTimeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		topLayout.addMember(__form);

		buttonLayout.addMember(salaryexception);
		mainLayout.addMember(topLayout);
		mainLayout.addMember(buttonLayout);
		addMember(mainLayout);
		setPageMode(PAGE_MODE_UPDATE);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		salaryexception.reloadDetailTableData(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSOnSalaryExceptions.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		Map<String,List<Map<String,Object>>> map = salaryexception.getValuesAsMap();
		List<Map<String,Object>> list = map.get("detailSalaryException");
		for (int i = 0;i < list.size();i++) {
			if(BaseHelpUtils.isNullOrEmpty(list.get(i).get("remark"))) {
				SC.say("请备注您申请的原因，此处不能为空");
				return false;
			}
			if(BaseHelpUtils.isNullOrEmpty(list.get(i).get("actuallyDeduction"))) {
				SC.say("请备注您申请补回的金额，此处不能为空");
				return false;
			}
			BigDecimal attendanceDeduction =BaseHelpUtils.getBigDecimalValue(list.get(i).get("attendanceDeduction")).abs();
			BigDecimal   actuallyDeduction=BaseHelpUtils.getBigDecimalValue(list.get(i).get("actuallyDeduction"));
			
			int a=actuallyDeduction.compareTo(attendanceDeduction);
			int zero=actuallyDeduction.compareTo(BigDecimal.ZERO);
			if(a > 0) {
				SC.say("审批修改的申请补回金额不能大于考情扣除金额");
				return false;
			}
			if(zero < 0) {
				SC.say("审批修改的申请补回金额不能为负数");
				return false;
			}
			
		}
		if(BaseHelpUtils.isNullOrEmpty(list) && list.size() == 0) {
			SC.say("请勾选要申请的工资异常数据");
			return false;
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map<String,Object> values = __form.getValues();
		values.putAll(salaryexception.getValuesAsMap());
		return values;
	}

}
