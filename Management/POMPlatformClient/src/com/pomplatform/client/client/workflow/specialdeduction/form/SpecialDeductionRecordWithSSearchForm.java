package com.pomplatform.client.client.workflow.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.client.workflow.specialdeduction.datasource.CDSpecialDeductionRecordWithS;

public class SpecialDeductionRecordWithSSearchForm extends SearchForm
{


	private final TextItem employeIdItem;

	public SpecialDeductionRecordWithSSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSpecialDeductionRecordWithS.getInstance());
		employeIdItem = new TextItem("employeId", "纳税人id");

		setItems(employeIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
