package com.pomplatform.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.specialdeduction.datasource.CDSspecialdeductiondetailor;

public class SspecialdeductiondetailorSearchForm extends SearchForm
{


	private final TextItem parentIdItem;
	private final SelectItem yearItem;
	private final SelectItem specialDeductionTypeIdItem;

	public SspecialdeductiondetailorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSspecialdeductiondetailor.getInstance());
		parentIdItem = new TextItem("parentId", "父id");
		parentIdItem.hide();
		Date d = new Date();
		yearItem = new SelectItem("year", "扣除年度");
		yearItem.setValue(d.getYear()+1900);
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		specialDeductionTypeIdItem = new SelectItem("specialDeductionTypeId", "专项类型");
		specialDeductionTypeIdItem.setWidth("*");
		specialDeductionTypeIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_223"));
		setItems(parentIdItem, yearItem, specialDeductionTypeIdItem);

		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
