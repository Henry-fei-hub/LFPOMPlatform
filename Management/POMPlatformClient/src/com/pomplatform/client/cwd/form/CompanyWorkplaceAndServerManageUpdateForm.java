package com.pomplatform.client.cwd.form;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.cwd.datasource.DSCompanyWorkplaceAndServerManage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class CompanyWorkplaceAndServerManageUpdateForm extends AbstractWizadPage
{


	private final TextItem companyWorkplaceIdItem;
	private final ComboBoxItem companyIdItem;
	private final TextItem workplaceNameItem;
	private final ComboBoxItem countryIdItem;
	private final ComboBoxItem provinceIdItem;
	private final ComboBoxItem cityIdItem;
	private final TextItem workplaceDirItem;
	private final SelectItem workplaceTypeItem;
	private final CheckboxItem hasInitItem;
	private final CheckboxItem activeItem;

	public CompanyWorkplaceAndServerManageUpdateForm() {
		DSCompanyWorkplaceAndServerManage ds = DSCompanyWorkplaceAndServerManage.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		companyWorkplaceIdItem = new TextItem("companyWorkplaceId", "工作场所编码");
		companyWorkplaceIdItem.setDisabled(true);
		companyWorkplaceIdItem.setRequired(true);
		IsIntegerValidator companyWorkplaceIdValidator = new IsIntegerValidator();
		companyWorkplaceIdItem.setValidators(companyWorkplaceIdValidator);
		companyWorkplaceIdItem.hide();
		__formItems.add(companyWorkplaceIdItem);
		
		companyIdItem = new ComboBoxItem("companyId", "公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("companies"));
		__formItems.add(companyIdItem);
		
		workplaceNameItem = new TextItem("workplaceName", "工作场所名称");
		workplaceNameItem.setWidth("*");
		__formItems.add(workplaceNameItem);
		
		workplaceDirItem = new TextItem("workplaceDir", "工作目录");
		workplaceDirItem.setWidth("*");
		__formItems.add(workplaceDirItem);
		
		workplaceTypeItem = new SelectItem("workplaceType", "工作场所类型");
		workplaceTypeItem.setWidth("*");
		workplaceTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_186"));
		__formItems.add(workplaceTypeItem);
		
		countryIdItem = new ComboBoxItem("countryId", "国家");
		countryIdItem.setValueMap(KeyValueManager.getValueMap("countries"));
		countryIdItem.setChangeOnKeypress(false);
		countryIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		countryIdItem.setWidth("*");
		countryIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()) {
					provinceIdItem.clearValue();
					cityIdItem.clearValue();
					Map<String, Object> params = new HashMap<>();
					params.put("countryId", event.getValue());
					DBDataSource.callOperation("ST_Province", "find", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							Record[] records = dsResponse.getData();
							if(null != records && records.length > 0) {
								LinkedHashMap<String, String> values = new LinkedHashMap<>();
								for (Record record : records) {
									values.put(record.getAttribute("provinceId"), record.getAttribute("provinceNameCn"));
								}
								provinceIdItem.setValueMap(values);
							}else {
								provinceIdItem.setValueMap(new LinkedHashMap<>());
							}
						}
					});
					cityIdItem.setValueMap(new LinkedHashMap<>());
				}
			}
		});
		__formItems.add(countryIdItem);
		
		provinceIdItem = new ComboBoxItem("provinceId", "省份");
		provinceIdItem.setWidth("*");
		provinceIdItem.setChangeOnKeypress(false);
		provinceIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		provinceIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()) {
					cityIdItem.clearValue();
					Map<String, Object> params = new HashMap<>();
					params.put("provinceId", event.getValue());
					DBDataSource.callOperation("ST_City", "find", params, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							Record[] records = dsResponse.getData();
							if(null != records && records.length > 0) {
								LinkedHashMap<String, String> values = new LinkedHashMap<>();
								for (Record record : records) {
									values.put(record.getAttribute("cityId"), record.getAttribute("cityNameCn"));
								}
								cityIdItem.setValueMap(values);
							}else {
								cityIdItem.setValueMap(new LinkedHashMap<>());
							}
						}
					});
				}
			}
		});
		__formItems.add(provinceIdItem);
		
		cityIdItem = new ComboBoxItem("cityId", "城市");
		cityIdItem.setWidth("*");
		cityIdItem.setChangeOnKeypress(false);
		cityIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(cityIdItem);
		
		hasInitItem = new CheckboxItem("hasInit", "是否初始化完成");
		__formItems.add(hasInitItem);
		
		activeItem = new CheckboxItem("active", "是否有效");
		__formItems.add(activeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		Record record = getRecord();
		if(record != null) {
			__form.editRecord(record);
		}
		if(null == record.getAttributeAsObject("cityId")) {
			provinceIdItem.setValueMap(new LinkedHashMap<>());
		}else {
			Map<String, Object> params = new HashMap<>();
			params.put("countryId", record.getAttributeAsObject("cityId"));
			DBDataSource.callOperation("ST_Province", "find", params, new DSCallback() {
				
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					Record[] records = dsResponse.getData();
					if(null != records && records.length > 0) {
						LinkedHashMap<String, String> values = new LinkedHashMap<>();
						for (Record record : records) {
							values.put(record.getAttribute("provinceId"), record.getAttribute("provinceNameCn"));
						}
						provinceIdItem.setValueMap(values);
					}
				}
			});
		}
		if(null == record.getAttributeAsObject("provinceId")) {
			cityIdItem.setValueMap(new LinkedHashMap<>());
		}else {
			Map<String, Object> params = new HashMap<>();
			params.put("provinceId", record.getAttributeAsObject("provinceId"));
			DBDataSource.callOperation("ST_City", "find", params, new DSCallback() {
				
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					Record[] records = dsResponse.getData();
					if(null != records && records.length > 0) {
						LinkedHashMap<String, String> values = new LinkedHashMap<>();
						for (Record record : records) {
							values.put(record.getAttribute("cityId"), record.getAttribute("cityNameCn"));
						}
						cityIdItem.setValueMap(values);
					}
				}
			});
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSCompanyWorkplaceAndServerManage.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(null == companyIdItem.getValue() || ClientUtil.isNullOrEmpty(KeyValueManager.getValue("companies", companyIdItem.getValue().toString()))) {
			SC.say("请选择公司");
			return false;
		}
		if(null == workplaceNameItem.getValue()) {
			SC.say("请填写该工作场所的名称");
			return false;
		}
		if(null == workplaceDirItem.getValue()) {
			SC.say("请填写该工作场所的工作目录");
			return false;
		}
		if(null == workplaceTypeItem.getValue()) {
			SC.say("请选择工作场所类型");
			return false;
		}
		if(null != countryIdItem.getValue() && ClientUtil.isNullOrEmpty(KeyValueManager.getValue("countries", countryIdItem.getValue().toString()))) {
			SC.say("请选择该工作场所所在的国家");
			return false;
		}
		if(null != provinceIdItem.getValue() && ClientUtil.isNullOrEmpty(KeyValueManager.getValue("states", provinceIdItem.getValue().toString()))) {
			SC.say("请选择该工作场所所在的省份");
			return false;
		}
		if(null != cityIdItem.getValue() && ClientUtil.isNullOrEmpty(KeyValueManager.getValue("cities", cityIdItem.getValue().toString()))) {
			SC.say("请选择该工作场所所在的城市");
			return false;
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
