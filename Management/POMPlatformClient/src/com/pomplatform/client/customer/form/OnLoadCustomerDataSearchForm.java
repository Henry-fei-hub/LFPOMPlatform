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
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class OnLoadCustomerDataSearchForm extends SearchForm
{

	private final TextItem customerNameItem;
	private final TextItem companyAddressItem;
	private final SelectItem customerTypeItem;
	private final SelectItem customerLevelItem;
	private final ComboBoxItem reportEmployeeIdItem;
	private final SelectItem typeItem;
	private final CheckboxItem isSureItem;
	private final CheckboxItem isWarehousItem;
	private final CheckboxItem isApplyQuoteItem;
	private final SelectItem companyProvinceItem;
	private final SelectItem companyCityItem;

	public OnLoadCustomerDataSearchForm() {
		setWidth100();
		setHeight100();
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		companyAddressItem = new TextItem("companyAddress", "客户地址");
		companyAddressItem.setWidth("*");
		customerTypeItem = new SelectItem("customerType", "客户类型");
		customerTypeItem.setWidth("*");
		customerTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_151"));
		customerLevelItem = new SelectItem("customerLevel", "客户等级");
		customerLevelItem.setWidth("*");
		customerLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_145"));
		reportEmployeeIdItem = new ComboBoxItem("reportEmployeeId", "报备人员");
		reportEmployeeIdItem.setWidth("*");
		reportEmployeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		reportEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
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
		typeItem = new SelectItem("type", "客户分类");
		typeItem.setWidth("*");
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_159"));
		isSureItem = new CheckboxItem("isSure", "是否确认");
		isWarehousItem = new CheckboxItem("isWarehous", "是否入库");
		isApplyQuoteItem = new CheckboxItem("isApplyQuote", "是否已提供战略报价");
		setItems(customerNameItem, companyAddressItem, customerTypeItem, customerLevelItem, reportEmployeeIdItem,typeItem, companyProvinceItem, companyCityItem, isSureItem, isWarehousItem, isApplyQuoteItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
