package com.pomplatform.client.contract.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contract.datasource.CDContractDistributionChild;

public class ContractDistributionChildSearchForm extends SearchForm
{


	private final TextItem contractIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem businessTypeItem;
	private final TextItem plateIdItem;

	public ContractDistributionChildSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDContractDistributionChild.getInstance());
		contractIdItem = new TextItem("contractId", "合同编码");
		startDateItem = new DateItem("startDate", "提成的时间");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateItem("endDate", "提成的时间");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});
		businessTypeItem = new TextItem("businessType", "业态");
		plateIdItem = new TextItem("plateId", "归属部门");

		setItems(contractIdItem, startDateItem, endDateItem, businessTypeItem, plateIdItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
