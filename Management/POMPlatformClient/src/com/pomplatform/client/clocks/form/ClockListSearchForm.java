package com.pomplatform.client.clocks.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValue;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.clocks.datasource.CDClockList;

public class ClockListSearchForm extends SearchForm
{


	private final TextItem deviceNameItem;
	private final TextItem aliasItem;
	private final SelectItem clockTypeIdItem;
	private final TextItem snItem;

	public ClockListSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDClockList.getInstance());
		deviceNameItem = new TextItem("deviceName", "设备名称");
		deviceNameItem.setWidth("*");
		
		aliasItem = new TextItem("alias", "设备别名");
		aliasItem.setWidth("*");
		
		clockTypeIdItem = new SelectItem("clockTypeId", "设备类型");
		clockTypeIdItem.setWidth("*");
		clockTypeIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_87"));
		
		snItem = new TextItem("sn", "序列号");
		snItem.setWidth("*");
		
		setItems(snItem, deviceNameItem, aliasItem, clockTypeIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
