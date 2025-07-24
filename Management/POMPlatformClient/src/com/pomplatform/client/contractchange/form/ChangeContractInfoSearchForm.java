package com.pomplatform.client.contractchange.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contractchange.datasource.CDChangeContractInfo;

public class ChangeContractInfoSearchForm extends SearchForm
{


	private final SelectItem contractIdItem;
	private final TextItem flagItem;

	public ChangeContractInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDChangeContractInfo.getInstance());
		contractIdItem = new SelectItem("contractId", "合同编码");
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdItem);
		flagItem = new TextItem("flag", "状态");

		setItems(contractIdItem, flagItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
