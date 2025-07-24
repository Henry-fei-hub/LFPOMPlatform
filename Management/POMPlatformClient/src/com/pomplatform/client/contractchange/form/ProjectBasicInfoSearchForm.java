package com.pomplatform.client.contractchange.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contractchange.datasource.CDProjectBasicInfo;

public class ProjectBasicInfoSearchForm extends SearchForm
{


	private final SelectItem contractIdItem;

	public ProjectBasicInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDProjectBasicInfo.getInstance());
		contractIdItem = new SelectItem("contractId", "合同编码");
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdItem);
		setItems(contractIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
