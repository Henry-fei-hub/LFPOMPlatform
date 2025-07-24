package com.pomplatform.client.employeemoneymanagespeemmepemmor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource.CDMcapitaldistributionlinkdepartmentdcor;

public class McapitaldistributionlinkdepartmentdcorSearchForm extends SearchForm
{


	private final TextItem capitalIdItem;

	public McapitaldistributionlinkdepartmentdcorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcapitaldistributionlinkdepartmentdcor.getInstance());
		capitalIdItem = new TextItem("capitalId", "收款主键(手动分配回款使用)");

		setItems(capitalIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
