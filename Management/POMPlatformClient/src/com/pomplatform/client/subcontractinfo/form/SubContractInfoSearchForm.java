package com.pomplatform.client.subcontractinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.subcontractinfo.datasource.CDSubContractInfo;

public class SubContractInfoSearchForm extends SearchForm
{


	private final SelectItem parentIdItem;

	public SubContractInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSubContractInfo.getInstance());
		parentIdItem = new SelectItem("parentId", "主合同");
                parentIdItem.setWidth("*");
                parentIdItem.hide();
//		parentIdItem.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", parentIdItem);

		setItems(parentIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
