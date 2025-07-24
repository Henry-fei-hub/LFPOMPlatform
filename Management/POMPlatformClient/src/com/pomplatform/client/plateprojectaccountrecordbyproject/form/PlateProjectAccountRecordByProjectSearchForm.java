package com.pomplatform.client.plateprojectaccountrecordbyproject.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.plateprojectaccountrecordbyproject.datasource.CDPlateProjectAccountRecordByProject;

public class PlateProjectAccountRecordByProjectSearchForm extends SearchForm
{


	private final SelectItem plateIdItem;
	private final TextItem recordYearItem;
	private final TextItem recordMonthItem;
	private final TextItem contractCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;

	public PlateProjectAccountRecordByProjectSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPlateProjectAccountRecordByProject.getInstance());
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.hide();
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		recordYearItem = new TextItem("recordYear", "年份");
		recordYearItem.hide();
		recordMonthItem = new TextItem("recordMonth", "月份");
		recordMonthItem.hide();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");

		setItems(plateIdItem, recordYearItem, recordMonthItem, contractCodeItem, projectCodeItem, projectNameItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
