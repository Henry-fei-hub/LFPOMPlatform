package com.pomplatform.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.specialdeduction.datasource.CDSspecialdeductiontypessor;

public class SspecialdeductiontypessorSearchForm extends SearchForm
{


	private final TextItem specialDeductionTypeNameItem;
	private final TextItem specialDeductionTypeIdItem;

	public SspecialdeductiontypessorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSspecialdeductiontypessor.getInstance());
		specialDeductionTypeNameItem = new TextItem("specialDeductionTypeName", "个税专项扣除类型名称");
		specialDeductionTypeIdItem = new TextItem("specialDeductionTypeId", "id");

		setItems(specialDeductionTypeNameItem, specialDeductionTypeIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
