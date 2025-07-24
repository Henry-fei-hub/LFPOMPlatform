package com.pomplatform.client.contractmessage.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contractmessage.datasource.CDOnLoadContractMessageDetail;

public class OnLoadContractMessageDetailSearchForm extends SearchForm
{


	private final TextItem remarkItem;
	private final TextItem contractMessageDetailIdItem;
	private final TextItem contractMessageIdItem;
	private final TextItem contractIdItem;

	public OnLoadContractMessageDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadContractMessageDetail.getInstance());
		remarkItem = new TextItem("remark", "消息推送人员");
		contractMessageDetailIdItem = new TextItem("contractMessageDetailId", "id");
		contractMessageIdItem = new TextItem("contractMessageId", "父id");
		contractIdItem = new TextItem("contractId", "合同id");

		setItems(remarkItem, contractMessageDetailIdItem, contractMessageIdItem, contractIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
