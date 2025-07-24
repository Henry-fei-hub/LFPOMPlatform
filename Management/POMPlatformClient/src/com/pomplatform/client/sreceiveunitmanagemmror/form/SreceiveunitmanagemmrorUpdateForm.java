package com.pomplatform.client.sreceiveunitmanagemmror.form;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.sreceiveunitmanagemmror.datasource.DSSreceiveunitmanagemmror;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class SreceiveunitmanagemmrorUpdateForm extends AbstractWizadPage {

	private final TextItem receiveUnitManageIdItem;
	private final TextItem receiveUnitItem;
	private final TextItem bankAccountItem;
	private final TextItem bankNameItem;
	private final TextItem receiveUnitAddressItem;
	private final TextItem operateEmployeeIdItem;
	private final DateTimeItem operateTimeItem;
	private final TextItem originItem;
	private final ComboBoxItem provinceItem;
	private final ComboBoxItem cityItem;
	private final TextItem bankAddressItem;
	private final TextItem receiveUnitPhoneItem;
	private final TextItem swiftCodeItem;
	private final ComboBoxItem countryIdItem;
	private final TextItem countryCodeItem;
	private final TextItem passportItem;
	private final ComboBoxItem bankIdItem;
	private final SelectItem accountTypeItem;
	private final SelectItem voucherTypeItem;
	private final SelectItem supplierTypeItem;

	public SreceiveunitmanagemmrorUpdateForm() {
		DSSreceiveunitmanagemmror ds = DSSreceiveunitmanagemmror.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		receiveUnitManageIdItem = new TextItem("receiveUnitManageId", "主键编码");
		receiveUnitManageIdItem.setDisabled(true);
		receiveUnitManageIdItem.setRequired(true);
		receiveUnitManageIdItem.hide();
		IsIntegerValidator receiveUnitManageIdValidator = new IsIntegerValidator();
		receiveUnitManageIdItem.setValidators(receiveUnitManageIdValidator);
		__formItems.add(receiveUnitManageIdItem);

		receiveUnitItem = new TextItem("receiveUnit", "收款单位");
		receiveUnitItem.setRequired(true);
		receiveUnitItem.setWidth("*");
		__formItems.add(receiveUnitItem);
		
		receiveUnitAddressItem = new TextItem("receiveUnitAddress", "收款单位所在地");
		receiveUnitAddressItem.setRequired(true);
		receiveUnitAddressItem.setWidth("*");
		__formItems.add(receiveUnitAddressItem);

		bankAccountItem = new TextItem("bankAccount", "银行账号");
		bankAccountItem.setRequired(true);
		bankAccountItem.setWidth("*");
		bankAccountItem.setValidators(ValidateUtils.bankAccountValidator());
		__formItems.add(bankAccountItem);
		
		bankIdItem = new ComboBoxItem("bankId", "银行");
		bankIdItem.setChangeOnKeypress(false);
		bankIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		bankIdItem.setValueMap(KeyValueManager.getValueMap("banks"));
		KeyValueManager.loadValueMap("banks",bankIdItem);
		bankIdItem.setRequired(true);
		bankIdItem.setWidth("*");
		__formItems.add(bankIdItem);

		bankNameItem = new TextItem("bankName", "开户行(支行)<font color='red'>填写内容如:XX银行XX支行</font>");
		bankNameItem.setRequired(true);
		bankNameItem.setWidth("*");
		__formItems.add(bankNameItem);
		
		bankAddressItem = new TextItem("bankAddress", "开户行所在详细地址");
		bankAddressItem.setRequired(true);
		bankAddressItem.hide();
		bankAddressItem.setWidth("*");
		__formItems.add(bankAddressItem);

		operateEmployeeIdItem = new TextItem("operateEmployeeId", "操作人");
		operateEmployeeIdItem.hide();
		__formItems.add(operateEmployeeIdItem);
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		operateTimeItem.hide();
		__formItems.add(operateTimeItem);
		originItem = new TextItem("origin", "来源");
		originItem.hide();
		__formItems.add(originItem);
		
		provinceItem = new ComboBoxItem("province", "开户行所在省");
		provinceItem.setRequired(true);
		provinceItem.setValueMap(KeyValueManager.getValueMap("provinces"));
		provinceItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		provinceItem.setChangeOnKeypress(false);
		provinceItem.setWidth("*");
		__formItems.add(provinceItem );
		provinceItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				cityItem.clearValue();
				if(null != event.getValue()){
					Object value = event.getValue();
					Map<String, Object> condition = new HashMap<>();
				    condition.put("parentId", value);
				    DBDataSource.callOperation("ST_Area", "find", condition, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								LinkedHashMap<String, Object> params = new LinkedHashMap<>();
								Record [] records = dsResponse.getData();
								for (int i = 0; i < records.length; i++) {
									params.put(records[i].getAttribute("areaId"), records[i].getAttribute("areaName"));
								}
								cityItem.setValueMap(params);
							}
							
						}
					});
				}else{
					cityItem.setValueMap(new LinkedHashMap<>());
				}
				
			}
		});
		
		cityItem = new ComboBoxItem("city", "开户行所在市");
		cityItem.setRequired(true);
		cityItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		cityItem.setChangeOnKeypress(false);
		cityItem.setWidth("*");
		__formItems.add(cityItem);
		
		accountTypeItem = new SelectItem("accountType", "收款方银行类型");
		accountTypeItem.setWidth("*");
		accountTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_171"));
		__formItems.add(accountTypeItem);
		accountTypeItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				int accountType = BaseHelpUtils.getIntValue(event.getValue());
				if(accountType == 1){
					receiveUnitPhoneItem.hide();
					swiftCodeItem.hide();
					countryIdItem.hide();
					countryCodeItem.hide();
					passportItem.hide();
				}else if(accountType == 2){
					receiveUnitPhoneItem.show();
					swiftCodeItem.show();
					countryIdItem.show();
					countryCodeItem.show();
					passportItem.show();
				}
				
			}
		});
		
		receiveUnitPhoneItem = new TextItem("receiveUnitPhone", "收款方电话");
		receiveUnitPhoneItem.setWidth("*");
		receiveUnitPhoneItem.setRequired(true);
		__formItems.add(receiveUnitPhoneItem);
		
		swiftCodeItem = new TextItem("swiftCode", "SWIFT CODE");
		swiftCodeItem.setWidth("*");
		swiftCodeItem.setRequired(true);
		__formItems.add(swiftCodeItem);
		
		countryIdItem = new ComboBoxItem("countryId", "收款人常驻国家（地区）");
		countryIdItem.setRequired(true);
		countryIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		countryIdItem.setChangeOnKeypress(false);
		countryIdItem.setWidth("*");
		countryIdItem.setValueMap(KeyValueManager.getValueMap("countries"));
		countryIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				int countryId = BaseHelpUtils.getIntValue(event.getValue());
				Map<String, Object> params = new HashMap<>();
				params.put("countryId", countryId);
				DBDataSource.callOperation("ST_Country", "findUsingKey", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record [] records = dsResponse.getData();
							if(records.length > 0){
								countryCodeItem.setValue(records[0].getAttribute("code"));
							}
						}
						
					}
				});
				
			}
		});
		__formItems.add(countryIdItem);
		
		countryCodeItem = new TextItem("countryCode", "收款人常驻国家（地区）代码");
		countryCodeItem.setRequired(true);
		countryCodeItem.setWidth("*");
		countryCodeItem.disable();
		__formItems.add(countryCodeItem);
		
		passportItem = new TextItem("passport", "护照");
		passportItem.setRequired(true);
		passportItem.setWidth("*");
		__formItems.add(passportItem);

		voucherTypeItem = new SelectItem("voucherType", "凭证类型");
		voucherTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_227"));
		voucherTypeItem.setWidth("*");
		__formItems.add(voucherTypeItem);
		
		supplierTypeItem = new SelectItem("supplierType", "供应商类型");
		supplierTypeItem.setWidth("*");
		supplierTypeItem.setRequired(true);
		KeyValueManager.loadValueMap("system_dictionary_237", supplierTypeItem);
		__formItems.add(supplierTypeItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if (getRecord() != null){
			Record record = getRecord();
			int accountType = record.getAttributeAsInt("accountType");
			if(accountType == 1){
				receiveUnitPhoneItem.hide();
				swiftCodeItem.hide();
				countryIdItem.hide();
				countryCodeItem.hide();
				passportItem.hide();
			}else if(accountType == 2){
				receiveUnitPhoneItem.show();
				swiftCodeItem.show();
				countryIdItem.show();
				countryCodeItem.show();
				passportItem.show();
			}
			__form.editRecord(record);
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSreceiveunitmanagemmror.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(!__form.validate()){
			SC.say("请按系统提示修改信息");
			return false;
		}
		int departmentId = ClientUtil.getDepartmentId();
		if (departmentId == 10){//财务部添加不进行检测
			return true;
		}
		//非财务部检测
		String bankId = BaseHelpUtils.getString(bankIdItem.getDisplayValue());
		String bankName = BaseHelpUtils.getString(bankNameItem.getValue());
		boolean b = bankName.startsWith(bankId);//判断输入的收款单位是否已选择银行开头
		if (bankId != "招商银行"){
			if (b){
				boolean f1 = bankName.endsWith("分行");
				boolean f2 = bankName.endsWith("支行");
				boolean f3 = bankName.endsWith("营业部");
				boolean f4 = bankName.endsWith("分理处");
				if (f1 || f2 || f3 || f4){
					return true;
				}else {
					SC.say("请填写正确的开户行名称");
					return  false;
				}
			}else{
				SC.say("请填写正确的开户行名称");
				return  false;
			}
		}else{
			return true;
		}
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

}
