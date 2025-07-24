package com.pomplatform.client.mcontractreceivableiicor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.mcontractreceivableiicor.datasource.CDMcontractreceivableiicor;

public class McontractreceivableiicorSearchForm extends SearchForm
{


	private final TextItem invoiceApplyIdItem;
	private final TextItem contractIdItem;

	public McontractreceivableiicorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcontractreceivableiicor.getInstance());
		invoiceApplyIdItem = new TextItem("invoiceApplyId", "申请发票表ID");
		contractIdItem = new TextItem("contractId", "合同id");

		setItems(invoiceApplyIdItem, contractIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
