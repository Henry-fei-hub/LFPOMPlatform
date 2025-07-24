package com.pomplatform.client.settlement.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.settlement.datasource.CDMprojectppor;

public class MprojectpporSearchForm extends SearchForm {

	private final SelectItem projectIdItem;

	public MprojectpporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMprojectppor.getInstance());
		projectIdItem = new SelectItem("projectId", "项目编码");
//		KeyValueManager.loadValueMap("projects",projectIdItem);
		KeyValueManager.loadValueMap("projects",projectIdItem);
		setItems(projectIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
