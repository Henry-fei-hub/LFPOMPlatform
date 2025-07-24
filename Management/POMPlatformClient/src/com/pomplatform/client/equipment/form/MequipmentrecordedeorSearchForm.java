package com.pomplatform.client.equipment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.equipment.datasource.CDMequipmentrecordedeor;

public class MequipmentrecordedeorSearchForm extends SearchForm
{


	private final TextItem equipmentIdItem;

	public MequipmentrecordedeorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMequipmentrecordedeor.getInstance());
		equipmentIdItem = new TextItem("equipmentId", "物品id");

		setItems(equipmentIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
