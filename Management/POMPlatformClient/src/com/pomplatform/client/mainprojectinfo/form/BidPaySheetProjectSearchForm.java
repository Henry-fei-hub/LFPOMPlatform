package com.pomplatform.client.mainprojectinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.mainprojectinfo.datasource.CDBidPaySheetProject;

public class BidPaySheetProjectSearchForm extends SearchForm
{


	private final TextItem personnelBusinessIdItem;

	public BidPaySheetProjectSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDBidPaySheetProject.getInstance());
		personnelBusinessIdItem = new TextItem("personnelBusinessId", "人事业务编码");

		setItems(personnelBusinessIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
