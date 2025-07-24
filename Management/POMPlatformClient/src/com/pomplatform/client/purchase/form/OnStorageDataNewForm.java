package com.pomplatform.client.purchase.form;

import java.util.Date;
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

public class OnStorageDataNewForm extends AbstractWizadPage
{


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

	public OnStorageDataNewForm() {
		DSOnStorageData ds = DSOnStorageData.getInstance();
		__form.setWidth100();
		__form.setHeight100();
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
		storageAreaIdItem.setValueMap(KeyValueManager.getValueMap("storage_areas"));
		__formItems.add(storageAreaIdItem);
		storageAreaIdItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int id = BaseHelpUtils.getIntValue(event.getValue());
				if(id > 0) {
					//根据地区去加载地区编码
					Map<String,Object> params = new HashMap<>();
					params.put("storageAreaId",id);
	        	    DBDataSource.callOperation("ST_StorageArea","find",params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								Record[] records = dsResponse.getData();
								if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
									Record re = records[0];
									//获取序列号
									int serialNumber = BaseHelpUtils.getIntValue(re.getAttribute("serialNumber"));
									serialNumber++;
									serialNumberValue = serialNumber;
									//获取地区编码
									String areaCode = BaseHelpUtils.getString(re.getAttribute("areaCode"));
									//生成仓库编码=地区编码+序列号
									String serialNumberStr = serialNumber+"";
									while (serialNumberStr.length() < 3) {
										serialNumberStr = "0"+serialNumberStr;
									}
									String storageCode = areaCode+serialNumberStr;
									storageCodeItem.setValue(storageCode);
								}
								
							}
						}
	        	    	
	        	    });
				}
			}
		});
		
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
		isEnabledItem.setHidden(true);
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
		manager.setDataSource(DSOnStorageData.getInstance());
		manager.addMember(__form);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public java.util.Map getValuesAsMap() {
		Map values = __form.getValues();
		values.put("createEmployeeId",ClientUtil.getEmployeeId());
		values.put("createTime",new Date());
		if(serialNumberValue > 0) {
			values.put("serialNumber",serialNumberValue);
		}
		return values;
	}

	private int serialNumberValue = 0;

}
