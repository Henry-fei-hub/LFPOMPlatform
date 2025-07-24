package com.pomplatform.client.bonuspayment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.bonuspayment.datasource.CDbonusSummary;

public class bonusSummarySearchForm extends SearchForm
{


/*	private final DateItem firstStartItem;
	private final DateItem firstEndItem;
	private final DateItem secondStartItem;
	private final DateItem secondEndItem;
	private final DateItem thirdStartItem;
	private final DateItem thirdEndItem;
	private final DateItem fourthStartItem;
	private final DateItem fourthEndItem;*/
	private final ComboBoxItem plateIdItem;
	private final SelectItem yearItem;

	public bonusSummarySearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDbonusSummary.getInstance());
		/*firstStartItem = new DateItem("firstStart", "第一季度开始时间");
		firstStartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, firstStartItem);
			}
		});
		firstEndItem = new DateItem("firstEnd", "第一季度结束");
		firstEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, firstEndItem);
			}
		});
		secondStartItem = new DateItem("secondStart", "第二季度开始");
		secondStartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, secondStartItem);
			}
		});
		secondEndItem = new DateItem("secondEnd", "第二季度结束");
		secondEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, secondEndItem);
			}
		});
		thirdStartItem = new DateItem("thirdStart", "第三季度开始");
		thirdStartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, thirdStartItem);
			}
		});
		thirdEndItem = new DateItem("thirdEnd", "第三季度结束");
		thirdEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, thirdEndItem);
			}
		});
		fourthStartItem = new DateItem("fourthStart", "第四季度开始");
		fourthStartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, fourthStartItem);
			}
		});
		fourthEndItem = new DateItem("fourthEnd", "第四季度结束");
		fourthEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, fourthEndItem);
			}
		});*/
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		
		Date d = new Date();
		yearItem = new SelectItem("year", "年份");
		yearItem.setValue(d.getYear()+1900);
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));

		setItems(plateIdItem,yearItem);

		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
