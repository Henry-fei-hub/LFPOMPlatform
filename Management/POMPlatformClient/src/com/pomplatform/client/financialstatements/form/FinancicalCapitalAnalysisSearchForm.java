package com.pomplatform.client.financialstatements.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.financialstatements.datasource.CDFinancicalCapitalAnalysis;

public class FinancicalCapitalAnalysisSearchForm extends SearchForm {

	private final SelectItem companyIdItem;
	
	private final DateTimeItem beginDateItem;
	
	private final DateTimeItem endDateItem;

	public FinancicalCapitalAnalysisSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDFinancicalCapitalAnalysis.getInstance());
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setMultiple(true);

		beginDateItem = new DateTimeItem("beginDate", "项目开始日期");
		beginDateItem.setWidth("*");
		beginDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, beginDateItem);
			}
		});
		endDateItem = new DateTimeItem("endDate", "项目结束日期");
		endDateItem.setWidth("*");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				if (val == null) {
					return;
				}
				val.setHours(23);
				val.setMinutes(59);
				val.setSeconds(59);
				endDateItem.setValue(val);
			}
		});

		setItems(companyIdItem, beginDateItem, endDateItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
