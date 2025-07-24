package com.pomplatform.client.bonuspayment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.bonuspayment.datasource.CDbonusSummaryDetail;

public class bonusSummaryDetailSearchForm extends SearchForm
{


/*	private final DateItem firststartItem;
	private final DateItem firstendItem;
	private final DateItem secondstartItem;
	private final DateItem secondendItem;
	private final DateItem thirdstartItem;
	private final DateItem thirdendItem;
	private final DateItem fourthstartItem;
	private final DateItem fourthendItem;
	private final TextItem plateIdItem;
	*/
	private final SelectItem yearItem;

	public bonusSummaryDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDbonusSummaryDetail.getInstance());
/*		firststartItem = new DateItem("firststart", "发放年月");
		firststartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, firststartItem);
			}
		});
		firstendItem = new DateItem("firstend", "发放年月");
		firstendItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, firstendItem);
			}
		});
		secondstartItem = new DateItem("secondstart", "发放年月");
		secondstartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, secondstartItem);
			}
		});
		secondendItem = new DateItem("secondend", "发放年月");
		secondendItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, secondendItem);
			}
		});
		thirdstartItem = new DateItem("thirdstart", "发放年月");
		thirdstartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, thirdstartItem);
			}
		});
		thirdendItem = new DateItem("thirdend", "发放年月");
		thirdendItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, thirdendItem);
			}
		});
		fourthstartItem = new DateItem("fourthstart", "发放年月");
		fourthstartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, fourthstartItem);
			}
		});
		fourthendItem = new DateItem("fourthend", "发放年月");
		fourthendItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, fourthendItem);
			}
		});
		plateIdItem = new TextItem("plateId", "业务部门");*/

		Date d = new Date();
		yearItem = new SelectItem("year", "年份");
		yearItem.setValue(d.getYear()+1900);
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		
		setItems(yearItem);

		setNumCols(18);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
