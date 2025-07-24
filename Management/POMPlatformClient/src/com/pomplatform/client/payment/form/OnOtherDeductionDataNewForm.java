package com.pomplatform.client.payment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.payment.datasource.DSOnOtherDeductionData;

public class OnOtherDeductionDataNewForm extends AbstractWizadPage
{


	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final TextItem companyIdItem;
	private final TextItem plateIdItem;
	private final TextItem departmentIdItem;
	private final DateItem recordDateItem;
	private final TextItem otherDeductionItem;
	private final CheckboxItem isSendedItem;

	public OnOtherDeductionDataNewForm() {
		DSOnOtherDeductionData ds = DSOnOtherDeductionData.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		employeeIdItem = new TextItem("employeeId", "员工id");
		__formItems.add(employeeIdItem);
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setRequired(true);
		IsStringValidator employeeNoValidator = new IsStringValidator();
		LengthRangeValidator employeeNoLengthValidator = new LengthRangeValidator();
		employeeNoLengthValidator.setMax(64);
		employeeNoItem.setValidators(employeeNoValidator, employeeNoLengthValidator);
		__formItems.add(employeeNoItem);
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setRequired(true);
		IsStringValidator employeeNameValidator = new IsStringValidator();
		LengthRangeValidator employeeNameLengthValidator = new LengthRangeValidator();
		employeeNameLengthValidator.setMax(64);
		employeeNameItem.setValidators(employeeNameValidator, employeeNameLengthValidator);
		__formItems.add(employeeNameItem);
		companyIdItem = new TextItem("companyId", "归属公司");
		__formItems.add(companyIdItem);
		plateIdItem = new TextItem("plateId", "业务部门");
		__formItems.add(plateIdItem);
		departmentIdItem = new TextItem("departmentId", "部门");
		__formItems.add(departmentIdItem);
		recordDateItem = new DateItem("recordDate", "日期");
		__formItems.add(recordDateItem);
		otherDeductionItem = new TextItem("otherDeduction", "其他扣除");
		__formItems.add(otherDeductionItem);
		isSendedItem = new CheckboxItem("isSended", "是否发放");
		__formItems.add(isSendedItem);

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
		manager.setDataSource(DSOnOtherDeductionData.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
