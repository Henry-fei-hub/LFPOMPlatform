package com.pomplatform.client.exchangerate.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.exchangerate.datasource.CDExchangeRateList;

public class ExchangeRateListSearchForm extends SearchForm
{


	private final SelectItem currencyIdItem;
	private final DateItem exchangeDateItem;

	public ExchangeRateListSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDExchangeRateList.getInstance());
		currencyIdItem = new SelectItem("currencyId", "货币类型");
		currencyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));
		
		exchangeDateItem = new DateItem("exchangeDate", "兑换日期");
		exchangeDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, exchangeDateItem);
			}
		});

		setItems(currencyIdItem, exchangeDateItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
