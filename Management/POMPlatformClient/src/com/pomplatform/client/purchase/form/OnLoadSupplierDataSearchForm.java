package com.pomplatform.client.purchase.form;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.purchase.datasource.CDOnLoadSupplierData;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class OnLoadSupplierDataSearchForm extends SearchForm
{

	private final TextItem supplierCodeItem;
	private final TextItem supplierNameItem;
	private final ComboBoxItem supplierTypeItem;
	private final ComboBoxItem supplierLevelItem;
	private final ComboBoxItem logisticsTypeItem;
	private final TextItem majorContactPersonItem;
	private final ComboBoxItem countryItem;
	private final ComboBoxItem provinceItem;
	private final ComboBoxItem cityItem;
	private final TextItem addressItem;

	public OnLoadSupplierDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadSupplierData.getInstance());
		supplierCodeItem = new TextItem("supplierCode", "供应商编号");
		supplierCodeItem.setWidth("*");
		
		supplierNameItem = new TextItem("supplierName", "供应商名称");
		supplierNameItem.setWidth("*");
		
		supplierTypeItem = new ComboBoxItem("supplierType", "供应商类型");
		supplierTypeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		supplierTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_187"));
		supplierTypeItem.setWidth("*");
		
		supplierLevelItem = new ComboBoxItem("supplierLevel", "供应商级");
		supplierLevelItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		supplierLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_188"));
		supplierLevelItem.setWidth("*");
		
		logisticsTypeItem = new ComboBoxItem("logisticsType", "物流方式");
		logisticsTypeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		logisticsTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_189"));
		logisticsTypeItem.setWidth("*");
		
		majorContactPersonItem = new TextItem("majorContactPerson", "主要联系人");
		majorContactPersonItem.setWidth("*");
		
		countryItem = new ComboBoxItem("country", "供应商所在国家");
		countryItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		countryItem.setValueMap(KeyValueManager.getValueMap("countries"));
		countryItem.setWidth("*");
		
		provinceItem = new ComboBoxItem("province", "供应商所在省份");
		provinceItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		provinceItem.setValueMap(KeyValueManager.getValueMap("provinces"));
		provinceItem.setWidth("*");
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
		
		cityItem = new ComboBoxItem("city", "供应商所在城市");
		cityItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		cityItem.setWidth("*");
		
		addressItem = new TextItem("address", "供应商详细地址");
		addressItem.setWidth("*");

		setItems(supplierCodeItem, supplierNameItem, supplierTypeItem, supplierLevelItem, logisticsTypeItem, majorContactPersonItem, countryItem, provinceItem, cityItem, addressItem);

		setNumCols(11);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
