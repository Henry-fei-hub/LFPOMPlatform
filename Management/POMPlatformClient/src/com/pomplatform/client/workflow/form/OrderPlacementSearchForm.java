package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDOrderPlacement;

public class OrderPlacementSearchForm extends SearchForm
{


	private final TextItem orderInfoIdItem;

	public OrderPlacementSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOrderPlacement.getInstance());
		orderInfoIdItem = new TextItem("orderInfoId", "订单信息编码");

		setItems(orderInfoIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
