package com.pomplatform.client.projectStageStorage.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectStageStorage.datasource.CDSprojectstagestoragepor;

public class SprojectstagestorageporSearchForm extends SearchForm
{


	private final TextItem projectStageStorageIdItem;

	public SprojectstagestorageporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSprojectstagestoragepor.getInstance());
		projectStageStorageIdItem = new TextItem("projectStageStorageId", "id");

		setItems(projectStageStorageIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
