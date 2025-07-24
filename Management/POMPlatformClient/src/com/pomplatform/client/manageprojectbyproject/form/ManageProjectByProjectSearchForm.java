package com.pomplatform.client.manageprojectbyproject.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.manageprojectbyproject.datasource.CDManageProjectByProject;

public class ManageProjectByProjectSearchForm extends SearchForm
{


	private final SelectItem plateIdItem;
	private final TextItem recordYearItem;
	private final TextItem recordMonthItem;
	private final TextItem manageProjectNameItem;

	public ManageProjectByProjectSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDManageProjectByProject.getInstance());
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.hide();
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		recordYearItem = new TextItem("recordYear", "年份");
		recordYearItem.hide();
		recordMonthItem = new TextItem("recordMonth", "月份");
		recordMonthItem.hide();
		manageProjectNameItem = new TextItem("manageProjectName", "项目名称");
		manageProjectNameItem.setWidth("*");

		setItems(plateIdItem, recordYearItem, recordMonthItem, manageProjectNameItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
