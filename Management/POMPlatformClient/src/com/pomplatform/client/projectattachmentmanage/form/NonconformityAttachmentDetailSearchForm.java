package com.pomplatform.client.projectattachmentmanage.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectattachmentmanage.datasource.CDNonconformityAttachmentDetail;

public class NonconformityAttachmentDetailSearchForm extends SearchForm
{


	private final TextItem projectIdItem;

	public NonconformityAttachmentDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDNonconformityAttachmentDetail.getInstance());
		projectIdItem = new TextItem("projectId", "项目订单id");

		setItems(projectIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
