package com.pomplatform.client.leavetype.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.leavetype.datasource.CDLinkOfLeaveTypeAndArea;

public class LinkOfLeaveTypeAndProvinceSearchForm extends SearchForm
{


	private final TextItem leaveTypeIdItem;

	public LinkOfLeaveTypeAndProvinceSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDLinkOfLeaveTypeAndArea.getInstance());
		leaveTypeIdItem = new TextItem("leaveTypeId", "请假类型编码");

		setItems(leaveTypeIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
