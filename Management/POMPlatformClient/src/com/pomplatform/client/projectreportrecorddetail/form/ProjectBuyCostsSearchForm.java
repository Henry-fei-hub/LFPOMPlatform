package com.pomplatform.client.projectreportrecorddetail.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectreportrecorddetail.datasource.CDProjectBuyCosts;

public class ProjectBuyCostsSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem projectNameItem;
	private final SelectItem statusItem;
	private final TextItem projectIdItem;

	public ProjectBuyCostsSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDProjectBuyCosts.getInstance());
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		
		statusItem = new SelectItem("status", "项目状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));
		statusItem.setWidth("*");
		
		projectIdItem = new TextItem("projectId", "项目编码");
		projectIdItem.hide();

		setItems(contractCodeItem, projectNameItem, statusItem, projectIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
