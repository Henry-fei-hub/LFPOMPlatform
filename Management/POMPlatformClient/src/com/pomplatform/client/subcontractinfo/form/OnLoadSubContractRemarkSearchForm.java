package com.pomplatform.client.subcontractinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.subcontractinfo.datasource.CDOnLoadSubContractRemark;

public class OnLoadSubContractRemarkSearchForm extends SearchForm
{


	private final TextItem contractIdItem;

	public OnLoadSubContractRemarkSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadSubContractRemark.getInstance());
		contractIdItem = new TextItem("contractId", "主订单编码");

		setItems(contractIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
