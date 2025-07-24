package com.pomplatform.client.costallocation.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.costallocation.datasource.CDCostAllocationApply;

public class CostAllocationApplySearchForm extends SearchForm
{


	private final TextItem resetCostIdItem;

	public CostAllocationApplySearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCostAllocationApply.getInstance());
		resetCostIdItem = new TextItem("resetCostId", "成本重新归集表编码");

		setItems(resetCostIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
