package com.pomplatform.client.bank.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.bank.datasource.CDBankManager;

public class BankManagerSearchForm extends SearchForm
{


	private final TextItem bankNameItem;

	public BankManagerSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDBankManager.getInstance());
		bankNameItem = new TextItem("bankName", "银行名称");

		setItems(bankNameItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
