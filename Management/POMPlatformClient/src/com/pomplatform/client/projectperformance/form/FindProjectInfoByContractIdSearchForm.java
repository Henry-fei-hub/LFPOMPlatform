package com.pomplatform.client.projectperformance.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectperformance.datasource.CDFindProjectInfoByContractId;

public class FindProjectInfoByContractIdSearchForm extends SearchForm
{


	private final SelectItem contractIdItem;

	public FindProjectInfoByContractIdSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDFindProjectInfoByContractId.getInstance());
		contractIdItem = new SelectItem("contractId", "合同");
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdItem);

		setItems(contractIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
