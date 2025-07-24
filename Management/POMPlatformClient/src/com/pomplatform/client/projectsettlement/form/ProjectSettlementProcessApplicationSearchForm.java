package com.pomplatform.client.projectsettlement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectsettlement.datasource.CDProjectSettlementProcessApplication;

public class ProjectSettlementProcessApplicationSearchForm extends SearchForm
{


	private final TextItem settlementIdItem;

	public ProjectSettlementProcessApplicationSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDProjectSettlementProcessApplication.getInstance());
		settlementIdItem = new TextItem("settlementId", "结算代码");

		setItems(settlementIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
