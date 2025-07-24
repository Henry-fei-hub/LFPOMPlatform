package com.pomplatform.client.sreimbursementpackagesummaryrror.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sreimbursementpackagesummaryrror.datasource.CDSreimbursementpackagesummaryrror;

public class SreimbursementpackagesummaryrrorSearchForm extends SearchForm
{


	private final TextItem reimbursementPackageSummaryIdItem;
	private final TextItem reimbursementPackageIdItem;

	public SreimbursementpackagesummaryrrorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSreimbursementpackagesummaryrror.getInstance());
		reimbursementPackageSummaryIdItem = new TextItem("reimbursementPackageSummaryId", "报销打包汇总表编码");
		reimbursementPackageIdItem = new TextItem("reimbursementPackageId", "报销打包表编码");

		setItems(reimbursementPackageSummaryIdItem, reimbursementPackageIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
