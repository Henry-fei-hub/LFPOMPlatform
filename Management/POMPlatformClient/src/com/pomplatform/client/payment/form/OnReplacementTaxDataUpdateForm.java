package com.pomplatform.client.payment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.payment.datasource.DSOnReplacementTaxData;

public class OnReplacementTaxDataUpdateForm extends AbstractWizadPage
{


	private final TextItem replacementTaxIdItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final TextItem companyIdItem;
	private final TextItem plateIdItem;
	private final TextItem departmentIdItem;
	private final DateItem recordDateItem;
	private final TextItem replacementTaxItem;
	private final CheckboxItem isSendedItem;

	public OnReplacementTaxDataUpdateForm() {
		DSOnReplacementTaxData ds = DSOnReplacementTaxData.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		replacementTaxIdItem = new TextItem("replacementTaxId", "主键编码");
		replacementTaxIdItem.setRequired(true);
		IsIntegerValidator replacementTaxIdValidator = new IsIntegerValidator();
		replacementTaxIdItem.setValidators(replacementTaxIdValidator);
		__formItems.add(replacementTaxIdItem);
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
		replacementTaxItem = new TextItem("replacementTax", "补发个税");
		__formItems.add(replacementTaxItem);
		isSendedItem = new CheckboxItem("isSended", "是否发放");
		__formItems.add(isSendedItem);

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
		manager.setDataSource(DSOnReplacementTaxData.getInstance());
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
