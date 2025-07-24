package com.pomplatform.client.shift.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.shift.datasource.CDManageShiftTime;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ManageShiftTimeSearchForm extends SearchForm
{


	private final TextItem shiftTimeNameItem;

	public ManageShiftTimeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDManageShiftTime.getInstance());
		shiftTimeNameItem = new TextItem("shiftTimeName", "时段名称");
		shiftTimeNameItem.setWidth("*");

		setItems(shiftTimeNameItem);

		setNumCols(3);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
