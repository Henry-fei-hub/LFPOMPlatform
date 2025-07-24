package com.pomplatform.client.sprocessbilllistpppor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sprocessbilllistpppor.datasource.CDSprocessbilllistpppor;

public class SprocessbilllistppporSearchForm extends SearchForm
{


	private final TextItem processBillListIdItem;
	private final TextItem processInstanceIdItem;
	private final TextItem processTypeItem;
	private final TextItem businessIdItem;
	private final TextItem payForItem;
	private final TextItem employeeOrCompanyIdItem;

	public SprocessbilllistppporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSprocessbilllistpppor.getInstance());
		processBillListIdItem = new TextItem("processBillListId", "主键");
		processInstanceIdItem = new TextItem("processInstanceId", "流程实例编码");
		processTypeItem = new TextItem("processType", "流程类型");
		businessIdItem = new TextItem("businessId", "业务Id");
		payForItem = new TextItem("payFor", "1 员工  2收款单位");
		employeeOrCompanyIdItem = new TextItem("employeeOrCompanyId", "员工或者收款单位Id");

		setItems(processBillListIdItem, processInstanceIdItem, processTypeItem, businessIdItem, payForItem, employeeOrCompanyIdItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
