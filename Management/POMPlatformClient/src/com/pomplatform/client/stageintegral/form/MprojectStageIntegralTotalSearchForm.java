package com.pomplatform.client.stageintegral.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.stageintegral.datasource.CDMprojectStageIntegralTotal;

public class MprojectStageIntegralTotalSearchForm extends SearchForm
{


	private final TextItem proejctIdItem;

	public MprojectStageIntegralTotalSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMprojectStageIntegralTotal.getInstance());
		proejctIdItem = new TextItem("proejctId", "项目");
		proejctIdItem.setWidth("*");

		setItems(proejctIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
