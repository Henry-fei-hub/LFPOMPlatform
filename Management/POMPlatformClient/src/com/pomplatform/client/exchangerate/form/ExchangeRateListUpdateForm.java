package com.pomplatform.client.exchangerate.form;

import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.exchangerate.datasource.DSExchangeRateList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class ExchangeRateListUpdateForm extends AbstractWizadPage
{


	private final TextItem exchangeRateIdItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final SelectItem currencyIdItem;
	private final TextItem exchangeRateItem;
	private final SelectItem operatorItem;

	public ExchangeRateListUpdateForm() {
		DSExchangeRateList ds = DSExchangeRateList.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		exchangeRateIdItem = new TextItem("exchangeRateId", "汇率表编码");
		exchangeRateIdItem.setDisabled(true);
		exchangeRateIdItem.setRequired(true);
		exchangeRateIdItem.hide();
		IsIntegerValidator exchangeRateIdValidator = new IsIntegerValidator();
		exchangeRateIdItem.setValidators(exchangeRateIdValidator);
		__formItems.add(exchangeRateIdItem);
		
		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		__formItems.add(yearItem);
		
		monthItem = new SelectItem("month", "月份");
		monthItem.setWidth("*");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		__formItems.add(monthItem);
		
		currencyIdItem = new SelectItem("currencyId", "货币种类");
		currencyIdItem.setWidth("*");
		currencyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));
		__formItems.add(currencyIdItem);
		
		exchangeRateItem = new TextItem("exchangeRate", "汇率");
		exchangeRateItem.setWidth("*");
		__formItems.add(exchangeRateItem);
		
		operatorItem = new SelectItem("operator", "最后一个操作者");
		operatorItem.hide();
		__formItems.add(operatorItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
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
		manager.setDataSource(DSExchangeRateList.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(yearItem.getValue() == null){
			SC.say("请选择年份");
			return false;
		}
		if(monthItem.getValue() == null){
			SC.say("请选择月份");
			return false;
		}
		if(currencyIdItem.getValue() == null){
			SC.say("请选择货币种类");
			return false;
		}
		if(exchangeRateItem.getValue() == null){
			SC.say("请填写汇率");
			return false;
		}
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map map = __form.getValues();
		map.put("operator", ClientUtil.getUserId());
		return map;
	}

}
