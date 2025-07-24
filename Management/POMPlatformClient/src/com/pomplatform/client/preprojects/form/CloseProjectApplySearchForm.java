package com.pomplatform.client.preprojects.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.preprojects.datasource.CDCloseProjectApply;

public class CloseProjectApplySearchForm extends SearchForm
{


	private final TextItem preProjectIdItem;

	public CloseProjectApplySearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCloseProjectApply.getInstance());
		preProjectIdItem = new TextItem("preProjectId", "主键编码");

		setItems(preProjectIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
