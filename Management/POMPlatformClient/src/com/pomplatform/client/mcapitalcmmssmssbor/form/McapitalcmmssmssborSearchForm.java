package com.pomplatform.client.mcapitalcmmssmssbor.form;

import java.util.Date;
import java.util.LinkedHashMap;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.mcapitalcmmssmssbor.datasource.CDMcapitalcmmssmssbor;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class McapitalcmmssmssborSearchForm extends SearchForm
{


	private final DateTimeItem minHappenDateItem;
	private final DateTimeItem maxHappenDateItem;
	private final SelectItem selfNameItem;
	private final TextItem selfBankAccountItem;
	private final TextItem bankAddressItem;

	public McapitalcmmssmssborSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcapitalcmmssmssbor.getInstance());
		minHappenDateItem = new DateTimeItem("minHappenDate", "最早发生日期");
		minHappenDateItem.setWidth("*");
		minHappenDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minHappenDateItem);
//				if(null != val){minHappenDateItem.setValue(val);}
			}
		});
		
		maxHappenDateItem = new DateTimeItem("maxHappenDate", "最晚发生日期");
		maxHappenDateItem.setWidth("*");
		maxHappenDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
//				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxHappenDateItem);
				if(null != val){
					val.setHours(23);
					val.setMinutes(59);
					val.setSeconds(59);
					maxHappenDateItem.setValue(val);
				}
			}
		});
		
		selfNameItem = new SelectItem("selfName", "内部公司(收款方)");
		selfNameItem.setWidth("*");
		selfNameItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.BANK_CAPITALS_CHECK_ALL) && ClientUtil.checkIsHavePermission(ERPPermissionStatic.BANK_CAPITALS_CHECK_MY_COMPANY)){
			String companyShortName = PomPlatformClientUtil.getCompanyShortName();
			final LinkedHashMap<String, String> companyMap = KeyValueManager.getValueMap("system_dictionary_69");
			for(String key : companyMap.keySet()){
				if(companyMap.get(key).indexOf(companyShortName) >= 0){
					selfNameItem.setDefaultValue(key);
					break;
				}
			}
			selfNameItem.addChangeHandler(new ChangeHandler() {
				
				@Override
				public void onChange(ChangeEvent event) {
					if(null != event.getValue()){
						String companyShortName = PomPlatformClientUtil.getCompanyShortName();
						String companyName = companyMap.get(event.getValue().toString());
						if(null != companyName && null != companyShortName){
							if(companyName.indexOf(companyShortName) < 0){
								SC.say("对不起，您没有查看"+companyName+"数据的权限");
								event.cancel();
							}
						}else{
							event.cancel();
						}
					}else{
						SC.say("对不起，您没有查看银行资金对账所有数据的权限");
						event.cancel();
					}
				}
			});
		}
		
		selfBankAccountItem = new TextItem("selfBankAccount", "银行账号(收款方)");
		selfBankAccountItem.setWidth("*");
		
		bankAddressItem = new TextItem("bankAddress", "银行名称");
		bankAddressItem.setWidth("*");
		setItems(minHappenDateItem, maxHappenDateItem, selfNameItem, selfBankAccountItem, bankAddressItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
