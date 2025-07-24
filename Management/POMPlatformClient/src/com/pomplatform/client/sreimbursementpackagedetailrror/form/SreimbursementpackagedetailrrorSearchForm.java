package com.pomplatform.client.sreimbursementpackagedetailrror.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sreimbursementpackagedetailrror.datasource.CDSreimbursementpackagedetailrror;

public class SreimbursementpackagedetailrrorSearchForm extends SearchForm
{


	private final TextItem reimbursementPackageDetailIdItem;
	private final TextItem reimbursementPackageIdItem;

	public SreimbursementpackagedetailrrorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSreimbursementpackagedetailrror.getInstance());
		reimbursementPackageDetailIdItem = new TextItem("reimbursementPackageDetailId", "报销打包汇总详情表编码");
		reimbursementPackageIdItem = new TextItem("reimbursementPackageId", "报销打包表编码");

		setItems(reimbursementPackageDetailIdItem, reimbursementPackageIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
