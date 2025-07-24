package com.pomplatform.client.getprojectbycontract.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.getprojectbycontract.datasource.CDGetProjectByContract;

public class GetProjectByContractSearchForm extends SearchForm
{


	private final SelectItem contractCodeItem;

	public GetProjectByContractSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDGetProjectByContract.getInstance());
		contractCodeItem = new SelectItem("contractCode", "合同名称");
//		contractCodeItem.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractCodeItem);

		setItems(contractCodeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
