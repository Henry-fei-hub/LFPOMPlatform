package com.pomplatform.client.projectstages.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.projectstages.datasource.CDSprojectstagecor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class SprojectstagecorSearchForm extends SearchForm
{


	private final TextItem contractIdItem;

	public SprojectstagecorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSprojectstagecor.getInstance());
		contractIdItem = new TextItem("contractId", "合同id");

		setItems(contractIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
