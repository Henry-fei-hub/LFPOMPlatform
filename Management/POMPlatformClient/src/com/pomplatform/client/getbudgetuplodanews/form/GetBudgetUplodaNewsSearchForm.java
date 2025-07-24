package com.pomplatform.client.getbudgetuplodanews.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.getbudgetuplodanews.datasource.CDGetBudgetUplodaNews;

public class GetBudgetUplodaNewsSearchForm extends SearchForm
{


	private final TextItem budgetManagementIdItem;
	private final TextItem fileIdItem;

	public GetBudgetUplodaNewsSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDGetBudgetUplodaNews.getInstance());
		budgetManagementIdItem = new TextItem("budgetManagementId", "主键id");
		fileIdItem = new TextItem("fileId", "附件编码");

		setItems(budgetManagementIdItem, fileIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
