package com.pomplatform.client.aboutcontractsrecord.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.aboutcontractsrecord.datasource.CDAboutContractsRecord;

public class AboutContractsRecordSearchForm extends SearchForm
{


	private final TextItem infoCodeItem;
	private final TextItem contractIdItem;

	public AboutContractsRecordSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAboutContractsRecord.getInstance());
		infoCodeItem = new TextItem("infoCode", "信息编号");
		contractIdItem = new TextItem("contractId", "合同编码");

		setItems(infoCodeItem, contractIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
