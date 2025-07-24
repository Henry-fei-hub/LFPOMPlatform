package com.pomplatform.client.attachment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.attachment.datasource.CDOnAttachmentLinkInvoices;

public class OnAttachmentLinkInvoicesSearchForm extends SearchForm
{


	private final TextItem personnelBusinessIdItem;
	private final TextItem contractIdItem;

	public OnAttachmentLinkInvoicesSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnAttachmentLinkInvoices.getInstance());
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "流程主表编码");
		contractIdItem = new TextItem("contractId", "主订单编码");

		setItems(personnelBusinessIdItem, contractIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
