package com.pomplatform.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.specialdeduction.datasource.DSSspecialdeductionrecordsssor;

public class SspecialdeductionrecordsssorUpdateForm extends AbstractWizadPage
{


	private final TextItem specialDeductionRecordIdItem;
	private final ComboBoxItem employeIdItem;
	private final TextItem employeeNameItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem processTypeItem;
	private final TextItem deparmentIdItem;
	private final SelectItem plateIdItem;
	private final SelectItem companyIdItem;
	private final SelectItem documentTypeItem;
	private final TextItem identificationNumberItem;
	private final TextItem phoneItem;
	private final TextItem taxpayerRegistrationNumberItem;
	private final TextItem addressItem;
	private final TextItem emailItem;
	private final TextItem withholdIdItem;
	private final TextItem withholdNameItem;
	private final TextItem withholdRegistrationNumberItem;
	private final SelectItem spouseSituationItem;
	private final TextItem spouseNameItem;
	private final SelectItem spouseDocumentTypeItem;
	private final TextItem spouseIdentificationNumberItem;
	private final DateTimeItem createDateItem;
	private final CheckboxItem isEnableItem;
	private final TextItem remarkItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public SspecialdeductionrecordsssorUpdateForm() {
		DSSspecialdeductionrecordsssor ds = DSSspecialdeductionrecordsssor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		specialDeductionRecordIdItem = new TextItem("specialDeductionRecordId", "id");
		specialDeductionRecordIdItem.hide();
		specialDeductionRecordIdItem.setDisabled(true);
		specialDeductionRecordIdItem.setRequired(true);
		IsIntegerValidator specialDeductionRecordIdValidator = new IsIntegerValidator();
		specialDeductionRecordIdItem.setValidators(specialDeductionRecordIdValidator);
		__formItems.add(specialDeductionRecordIdItem);
		
		employeIdItem = new ComboBoxItem("employeId", shouldNotBeNull+"纳税人");
		employeIdItem.setWidth("*");
		employeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeIdItem.setChangeOnKeypress(false);
		employeIdItem.setRequired(true);
		employeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		IsIntegerValidator employeIdValidator = new IsIntegerValidator();
		employeIdItem.setValidators(employeIdValidator);
		__formItems.add(employeIdItem);
		
		employeeNameItem = new TextItem("employeeName", "纳税人姓名");
		employeeNameItem.hide();
		__formItems.add(employeeNameItem);
		
		startDateItem = new DateItem("startDate", "有效开始时间");
		startDateItem.hide();
		__formItems.add(startDateItem);
		endDateItem = new DateItem("endDate", "有效结束时间");
		endDateItem.hide();
		__formItems.add(endDateItem);
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		__formItems.add(processTypeItem);
		deparmentIdItem = new TextItem("deparmentId", "部门");
		deparmentIdItem.hide();
		__formItems.add(deparmentIdItem);
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		__formItems.add(plateIdItem);
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		__formItems.add(companyIdItem);
		documentTypeItem = new SelectItem("documentType", shouldNotBeNull+"身份证件类型");
		documentTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_222"));
		documentTypeItem.setRequired(true);
		IsIntegerValidator documentTypeValidator = new IsIntegerValidator();
		documentTypeItem.setValidators(documentTypeValidator);
		__formItems.add(documentTypeItem);
		identificationNumberItem = new TextItem("identificationNumber", shouldNotBeNull+"纳税人身份证件号码");
		identificationNumberItem.setRequired(true);
		IsStringValidator identificationNumberValidator = new IsStringValidator();
		LengthRangeValidator identificationNumberLengthValidator = new LengthRangeValidator();
		identificationNumberLengthValidator.setMax(64);
		identificationNumberItem.setValidators(identificationNumberValidator, identificationNumberLengthValidator);
		__formItems.add(identificationNumberItem);
		phoneItem = new TextItem("phone", shouldNotBeNull+"手机号码");
		phoneItem.setRequired(true);
		IsIntegerValidator phoneValidator = new IsIntegerValidator();
		phoneItem.setValidators(ValidateUtils.mobileValidator());
		__formItems.add(phoneItem);
		taxpayerRegistrationNumberItem = new TextItem("taxpayerRegistrationNumber", "纳税人识别号");
		__formItems.add(taxpayerRegistrationNumberItem);
		addressItem = new TextItem("address", "联系地址");
		__formItems.add(addressItem);
		emailItem = new TextItem("email", "邮箱");
		emailItem.setValidators(ValidateUtils.emailValidator());
		__formItems.add(emailItem);
		withholdIdItem = new TextItem("withholdId", "扣缴义务人id");
		withholdIdItem.hide();
		__formItems.add(withholdIdItem);
		withholdNameItem = new TextItem("withholdName", "扣缴义务人名称");
		__formItems.add(withholdNameItem);
		withholdRegistrationNumberItem = new TextItem("withholdRegistrationNumber", "扣缴义务人纳税人识别号");
		__formItems.add(withholdRegistrationNumberItem);
		spouseSituationItem = new SelectItem("spouseSituation", shouldNotBeNull+"配偶情况");
		spouseSituationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));
		__formItems.add(spouseSituationItem);
		spouseNameItem = new TextItem("spouseName", "配偶名称");
		__formItems.add(spouseNameItem);
		spouseDocumentTypeItem = new SelectItem("spouseDocumentType", "配偶身份证件类型");
		spouseDocumentTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_222"));
		__formItems.add(spouseDocumentTypeItem);
		spouseIdentificationNumberItem = new TextItem("spouseIdentificationNumber", "配偶身份证件号码");
		__formItems.add(spouseIdentificationNumberItem);
		createDateItem = new DateTimeItem("createDate", "创建时间");
		createDateItem.hide();
		__formItems.add(createDateItem);
		isEnableItem = new CheckboxItem("isEnable", "是否可用");
		__formItems.add(isEnableItem);
		remarkItem = new TextItem("remark", "备注");
		__formItems.add(remarkItem);

		
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
		manager.setDataSource(DSSspecialdeductionrecordsssor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(BaseHelpUtils.isNullOrEmpty(employeIdItem.getValue())) {
			SC.warn("提示","纳税人不能为空");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(documentTypeItem.getValue())) {
			SC.warn("提示","身份证类型不能为空");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(identificationNumberItem.getValue())) {
			SC.warn("提示","身份证号码不能为空");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(phoneItem.getValue())) {
			SC.warn("提示","手机号码不能为空");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(spouseSituationItem.getValue())) {
			SC.warn("提示","配偶情况不能为空");
			return false;
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
