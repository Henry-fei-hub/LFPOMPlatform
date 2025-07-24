package com.pomplatform.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.specialdeduction.datasource.DSSspecialdeductionsepor;

public class SspecialdeductionseporNewForm extends AbstractWizadPage
{


	private final TextItem specialDeductionIdItem;
	private final ComboBoxItem employeIdItem;
	private final TextItem plateIdItem;
	private final TextItem companyIdItem;
	private final SelectItem documentTypeItem;
	private final TextItem identificationNumberItem;
	private final TextItem phoneItem;
	private final TextItem taxpayerRegistrationNumberItem;
	private final TextItem addressItem;
	private final TextItem emailItem;
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
	
	public SspecialdeductionseporNewForm() {
		DSSspecialdeductionsepor ds = DSSspecialdeductionsepor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		specialDeductionIdItem = new TextItem("specialDeductionId", "id");
		specialDeductionIdItem.setRequired(true);
		specialDeductionIdItem.hide();
		IsIntegerValidator specialDeductionIdValidator = new IsIntegerValidator();
		specialDeductionIdItem.setValidators(specialDeductionIdValidator);
		__formItems.add(specialDeductionIdItem);
		employeIdItem = new ComboBoxItem("employeId", shouldNotBeNull+"纳税人");
		employeIdItem.setWidth("*");
		employeIdItem.setRequired(true);
		employeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				SC.debugger();
				Map condition = new HashMap();
				int intValue = BaseHelpUtils.getIntValue(event.getValue());
				condition.put("employeeId", intValue);
				condition.put("status", 0);
				DBDataSource.callOperation("ST_Employee", "find", condition, new DSCallback(){
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							SC.debugger();
							Record[] records = dsResponse.getData();
							Record record2 = records[0];
							plateIdItem.setValue(BaseHelpUtils.getIntValue(record2.getAttribute("plateId")));
							companyIdItem.setValue(BaseHelpUtils.getIntValue(record2.getAttribute("companyId")));
							__form.redraw();
						}else {
							plateIdItem.setValue("");
							companyIdItem.setValue("");
							__form.redraw();
						}
					}
				});
			}
		});
		employeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		IsIntegerValidator employeIdValidator = new IsIntegerValidator();
		employeIdItem.setValidators(employeIdValidator);
		__formItems.add(employeIdItem);
		plateIdItem = new TextItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setCanEdit(false);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		__formItems.add(plateIdItem);
		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setCanEdit(false);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		__formItems.add(companyIdItem);
		documentTypeItem = new SelectItem("documentType", shouldNotBeNull+"身份证件类型");
		documentTypeItem.setRequired(true);
		documentTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_222"));
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
		IsStringValidator phoneValidator = new IsStringValidator();
		LengthRangeValidator phoneLengthValidator = new LengthRangeValidator();
		phoneLengthValidator.setMax(32);
		phoneItem.setValidators(phoneValidator, phoneLengthValidator);
		__formItems.add(phoneItem);
		taxpayerRegistrationNumberItem = new TextItem("taxpayerRegistrationNumber", "纳税人识别号");
		__formItems.add(taxpayerRegistrationNumberItem);
		addressItem = new TextItem("address", "联系地址");
		__formItems.add(addressItem);
		emailItem = new TextItem("email", "邮箱");
		__formItems.add(emailItem);
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
		isEnableItem.hide();
		__formItems.add(isEnableItem);
		remarkItem = new TextItem("remark", "备注");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(8);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
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
		}else {
			int spouseSituation = BaseHelpUtils.getIntValue(spouseSituationItem.getValue());
			if(spouseSituation==0) {
				if(BaseHelpUtils.isNullOrEmpty(spouseNameItem.getValue())) {
					SC.warn("提示","配偶姓名不能为空");
					return false;
				}
				if(BaseHelpUtils.isNullOrEmpty(spouseDocumentTypeItem.getValue())) {
					SC.warn("提示","配偶身份证类型不能为空");
					return false;
				}
				if(BaseHelpUtils.isNullOrEmpty(spouseIdentificationNumberItem.getValue())) {
					SC.warn("提示","配偶身份证号码不能为空");
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSspecialdeductionsepor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
