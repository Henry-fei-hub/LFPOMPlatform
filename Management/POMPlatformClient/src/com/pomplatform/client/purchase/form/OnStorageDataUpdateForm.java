package com.pomplatform.client.purchase.form;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.purchase.datasource.DSOnStorageData;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class OnStorageDataUpdateForm extends AbstractWizadPage
{


	private final TextItem storageIdItem;
	private final TextItem storageCodeItem;
	private final TextItem storageNameItem;
	private final SelectItem storageTypeItem;
	private final SelectItem storageAreaIdItem;
	private final ComboBoxItem countryItem;
	private final ComboBoxItem provinceItem;
	private final ComboBoxItem cityItem;
	private final TextItem addressItem;
	private final ComboBoxItem contactEmployeeIdItem;
	private final TextItem contactPhoneItem;
	private final TextItem parentIdItem;
	private final TextItem createEmployeeIdItem;
	private final DateTimeItem createTimeItem;
	private final CheckboxItem isEnabledItem;
	private final TextAreaItem remarkItem;

	public OnStorageDataUpdateForm() {
		DSOnStorageData ds = DSOnStorageData.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		storageIdItem = new TextItem("storageId", "主键编码");
		storageIdItem.setDisabled(true);
		storageIdItem.setRequired(true);
		storageIdItem.setHidden(true);
		IsIntegerValidator storageIdValidator = new IsIntegerValidator();
		storageIdItem.setValidators(storageIdValidator);
		__formItems.add(storageIdItem);
		storageCodeItem = new TextItem("storageCode", "仓库编号");
		storageCodeItem.setWidth("*");
		storageCodeItem.setDisabled(true);
		__formItems.add(storageCodeItem);
		
		storageNameItem = new TextItem("storageName", "仓库名称");
		storageNameItem.setWidth("*");
		__formItems.add(storageNameItem);
		
		storageTypeItem = new SelectItem("storageType", "仓库类型");
		storageTypeItem.setWidth("*");
		storageTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_209"));
		__formItems.add(storageTypeItem);
		
		storageAreaIdItem = new SelectItem("storageAreaId", "地区");
		storageAreaIdItem.setWidth("*");
		storageAreaIdItem.setDisabled(true);
		storageAreaIdItem.setValueMap(KeyValueManager.getValueMap("storage_areas"));
		__formItems.add(storageAreaIdItem);
		
		countryItem = new ComboBoxItem("country", "所在国家");
		countryItem.setWidth("*");
		countryItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		countryItem.setValueMap(KeyValueManager.getValueMap("countries"));
		__formItems.add(countryItem);
		
		provinceItem = new ComboBoxItem("province", "所在省份");
		provinceItem.setWidth("*");
		provinceItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		provinceItem.setValueMap(KeyValueManager.getValueMap("provinces"));
		provinceItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int id = BaseHelpUtils.getIntValue(event.getValue());
				if(id > 0) {
					//根据省份id去检索该省份下的城市，并封装数据
					Map<String,Object> params = new HashMap<>();
					params.put("parentId",id);
	        	    DBDataSource.callOperation("ST_Area","find",params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								Record[] cityRecords = dsResponse.getData();
								LinkedHashMap<String, String> cityMap = new LinkedHashMap<>();
								for(Record e : cityRecords){
									cityMap.put(e.getAttribute("areaId"), e.getAttribute("allName"));
								}
								cityItem.setValueMap(cityMap);
							}
						}
	        	    	
	        	    });
				}
			}
		});
		__formItems.add(provinceItem);
		
		cityItem = new ComboBoxItem("city", "所在城市");
		cityItem.setWidth("*");
		cityItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(cityItem);
		
		addressItem = new TextItem("address", "详细地址");
		addressItem.setWidth("*");
		__formItems.add(addressItem);
		
		contactEmployeeIdItem = new ComboBoxItem("contactEmployeeId", "联系人");
		contactEmployeeIdItem.setWidth("*");
		contactEmployeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		contactEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employee_list"));
		__formItems.add(contactEmployeeIdItem);
		
		contactPhoneItem = new TextItem("contactPhone", "联系电话");
		contactPhoneItem.setWidth("*");
		__formItems.add(contactPhoneItem);
		
		parentIdItem = new TextItem("parentId", "父级id");
		parentIdItem.setHidden(true);
		__formItems.add(parentIdItem);
		
		createEmployeeIdItem = new TextItem("createEmployeeId", "创建人");
		createEmployeeIdItem.setHidden(true);
		__formItems.add(createEmployeeIdItem);
		
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setHidden(true);
		__formItems.add(createTimeItem);
		
		isEnabledItem = new CheckboxItem("isEnabled", "是否可用");
		isEnabledItem.setWidth("*");
		__formItems.add(isEnabledItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setStartRow(true);
		remarkItem.setWidth("*");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
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
		manager.setDataSource(DSOnStorageData.getInstance());
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
