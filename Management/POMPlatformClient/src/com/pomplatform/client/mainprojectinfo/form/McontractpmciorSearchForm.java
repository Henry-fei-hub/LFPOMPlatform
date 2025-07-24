package com.pomplatform.client.mainprojectinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.mainprojectinfo.datasource.CDMcontractpmcior;

public class McontractpmciorSearchForm extends SearchForm
{


	private final TextItem contractIdItem;
	private final TextItem infoCodeItem;

	public McontractpmciorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcontractpmcior.getInstance());
		contractIdItem = new TextItem("contractId", "主订单编码");
		infoCodeItem = new TextItem("infoCode", "信息编号");

		setItems(contractIdItem, infoCodeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
