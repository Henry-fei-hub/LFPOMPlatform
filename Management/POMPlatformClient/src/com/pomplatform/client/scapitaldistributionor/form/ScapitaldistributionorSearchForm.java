package com.pomplatform.client.scapitaldistributionor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.scapitaldistributionor.datasource.CDScapitaldistributionor;

public class ScapitaldistributionorSearchForm extends SearchForm
{


	private final TextItem capitalDistributionIdItem;

	public ScapitaldistributionorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDScapitaldistributionor.getInstance());
		capitalDistributionIdItem = new TextItem("capitalDistributionId", "主键");

		setItems(capitalDistributionIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
