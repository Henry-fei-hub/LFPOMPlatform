package com.pomplatform.client.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.client.specialdeduction.datasource.DSSspecialdeductionrecordsssor;

public class SspecialdeductionrecordsssorNewForm extends AbstractWizadPage
{


	private final TextItem specialDeductionRecordNameItem;
	private final TextItem amountItem;
	private final TextItem numItem;
	private final SelectItem specialDeductionTypeItem;
	private final TextItem specialDeductionTimeItem;
	private final SelectItem specialDeductionEducationItem;
	private final TextItem educationAmountItem;
	private final SelectItem specialDeductionSupOldItem;
	private final TextItem supOldAmountItem;
	private final CheckboxItem isEnableItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
/*	private final DateTimeItem createDateItem;
	private final TextItem processTypeItem;
	private final TextItem employeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem deparmentIdItem;
	private final TextItem companyIdItem;*/
	private final TextItem reasonItem;
	private final TextItem remarkItem;

	public SspecialdeductionrecordsssorNewForm() {
		DSSspecialdeductionrecordsssor ds = DSSspecialdeductionrecordsssor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		specialDeductionRecordNameItem = new TextItem("specialDeductionRecordName", "名字");
		specialDeductionRecordNameItem.setWidth("*");
		specialDeductionRecordNameItem.setRequired(true);
		IsStringValidator specialDeductionRecordNameValidator = new IsStringValidator();
		LengthRangeValidator specialDeductionRecordNameLengthValidator = new LengthRangeValidator();
		specialDeductionRecordNameLengthValidator.setMax(64);
		specialDeductionRecordNameItem.setValidators(specialDeductionRecordNameValidator, specialDeductionRecordNameLengthValidator);
		__formItems.add(specialDeductionRecordNameItem);
		amountItem = new TextItem("amount", "基数");
		amountItem.setWidth("*");
		__formItems.add(amountItem);
		numItem = new TextItem("num", "个数");
		__formItems.add(numItem);
		specialDeductionTypeItem = new SelectItem("specialDeductionType", "类型");
		specialDeductionTypeItem.setWidth("*");
		specialDeductionTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_215"));
		__formItems.add(specialDeductionTypeItem);
		specialDeductionTimeItem = new TextItem("specialDeductionTime", "最长时间跨度");
		specialDeductionTimeItem.setWidth("*");
		specialDeductionTimeItem.hide();
		__formItems.add(specialDeductionTimeItem);
		specialDeductionEducationItem = new SelectItem("specialDeductionEducation", "教育类型");
		specialDeductionEducationItem.setWidth("*");
		specialDeductionEducationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_216"));
		__formItems.add(specialDeductionEducationItem);
		educationAmountItem = new TextItem("educationAmount", "教育金额");
		educationAmountItem.setWidth("*");
		__formItems.add(educationAmountItem);
		specialDeductionSupOldItem = new SelectItem("specialDeductionSupOld", "是否独生");
		specialDeductionSupOldItem.setWidth("*");
		specialDeductionSupOldItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));
		__formItems.add(specialDeductionSupOldItem);
		supOldAmountItem = new TextItem("supOldAmount", "赡养老人金额");
		supOldAmountItem.setWidth("*");
		__formItems.add(supOldAmountItem);
		startDateItem = new DateItem("startDate", "有效开始日期");
		startDateItem.setWidth("*");
		__formItems.add(startDateItem);
		endDateItem = new DateItem("endDate", "有效结束日期");
		endDateItem.setWidth("*");
		__formItems.add(endDateItem);
		isEnableItem = new CheckboxItem("isEnable", "是否可用");
		isEnableItem.setWidth("*");
		__formItems.add(isEnableItem);
/*		employeIdItem = new TextItem("employeId", "申请人");
		employeIdItem.setWidth("*");
		__formItems.add(employeIdItem);
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		__formItems.add(employeeNoItem);
		deparmentIdItem = new TextItem("deparmentId", "部门");
		deparmentIdItem.setWidth("*");
		__formItems.add(deparmentIdItem);
		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		__formItems.add(companyIdItem);*/
		reasonItem = new TextItem("reason", "原因");
		reasonItem.setWidth("*");
		__formItems.add(reasonItem);
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(8);
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
		manager.setDataSource(DSSspecialdeductionrecordsssor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
