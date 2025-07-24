package com.pomplatform.client.selectgrid.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.selectgrid.datasource.CDSelectGridReceiveUnitValue;

public class SelectGridReceiveUnitValueSearchForm extends SearchForm
{


	private final TextItem receiveUnitManageIdItem;
	private final TextItem originItem;
	private final TextItem receiveUnitItem;
	private final TextItem bankNameItem;
	private final TextItem receiveUnitAddressItem;

	public SelectGridReceiveUnitValueSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSelectGridReceiveUnitValue.getInstance());
		receiveUnitManageIdItem = new TextItem("receiveUnitManageId", "主键编码");
		originItem = new TextItem("origin", "来源");
		receiveUnitItem = new TextItem("receiveUnit", "收款单位");
		bankNameItem = new TextItem("bankName", "开户行");
		receiveUnitAddressItem = new TextItem("receiveUnitAddress", "收款单位所在地");

		setItems(receiveUnitManageIdItem, originItem, receiveUnitItem, bankNameItem, receiveUnitAddressItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
