package com.pomplatform.client.customer.form;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class OnLoadCompetitionUnitsDataSearchForm extends SearchForm
{
	
	private final TextItem areaNameItem;
	private final TextItem nameItem;
	private final TextItem addressItem;
	private final SelectItem companyProvinceItem;
	private final SelectItem companyCityItem;

	public OnLoadCompetitionUnitsDataSearchForm() {
		setWidth100();
		setHeight100();
		areaNameItem = new TextItem("areaName", "区域");
		areaNameItem.setWidth("*");
		nameItem = new TextItem("name", "名称");
		nameItem.setWidth("*");
		addressItem = new TextItem("address", "地址");
		addressItem.setWidth("*");
		companyProvinceItem = new SelectItem("companyProvince", "省份");
		companyProvinceItem.setWidth("*");
		companyProvinceItem.setValueMap(KeyValueManager.getValueMap("provinces_names"));
        companyProvinceItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Map<String,Object> provinceMap = new HashMap<>();
        	    provinceMap.put("optType", "getCityNames");
        	    provinceMap.put("province", companyProvinceItem.getValue());
        	    DBDataSource.callOperation("EP_PreProjectProcess", provinceMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record[] cityRecords = dsResponse.getData();
							LinkedHashMap<String, String> cityMap = new LinkedHashMap<>();
							for(Record e : cityRecords){
								cityMap.put(e.getAttribute("allName"), e.getAttribute("allName"));
							}
							companyCityItem.setValueMap(cityMap);
						}
					}
        	    	
        	    });
			}
		});
		companyCityItem = new SelectItem("companyCity", "城市");
		companyCityItem.setWidth("*");
		setItems(areaNameItem,nameItem,addressItem, companyProvinceItem, companyCityItem);

		setNumCols(11);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
