package com.pomplatform.client.contract.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contract.datasource.CDContractDistributionMonthlyDetail;

public class ContractDistributionMonthlyDetailSearchForm extends SearchForm
{


	private final ComboBoxItem plateIdItem;
	private final TextItem businessTypeIdItem;
	private final DateItem yearItem;
	private final DateItem monthItem;

	public ContractDistributionMonthlyDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractDistributionMonthlyDetail.getInstance());
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setChangeOnKeypress(false);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		businessTypeIdItem = new TextItem("businessTypeId", "类型");
		yearItem = new DateItem("year", "年份");
		yearItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, yearItem);
			}
		});
		monthItem = new DateItem("month", "月份");
		monthItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, monthItem);
			}
		});

		setItems(plateIdItem, businessTypeIdItem, yearItem, monthItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
