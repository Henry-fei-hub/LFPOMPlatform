package com.pomplatform.client.onenewaccountstransationsinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.onenewaccountstransationsinfo.datasource.CDOneNewAccountsTransationsInfo;

public class OneNewAccountsTransationsInfoSearchForm extends SearchForm
{


	private final TextItem accountIdItem;

	public OneNewAccountsTransationsInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOneNewAccountsTransationsInfo.getInstance());
		accountIdItem = new TextItem("accountId", "关联账户编码");

		setItems(accountIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
