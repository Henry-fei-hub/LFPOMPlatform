package com.pomplatform.client.employeemoneymanagespeemmepemmor.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource.CDCapitalprojectSearch;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class CapitalprojectSearchSearchForm extends SearchForm
{


	private final TextItem contractCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem departmentIdItem;
	private final TextItem projectIdItem;
	private final TextItem plateIdItem;

	public CapitalprojectSearchSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCapitalprojectSearch.getInstance());
		contractCodeItem = new TextItem("contractCode", "订单编号");
		contractCodeItem.setWidth("*");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "订单名称");
		projectNameItem.setWidth("*");
		departmentIdItem = new TextItem("departmentId", "归属部门");
		departmentIdItem.setHidden(true);
		projectIdItem = new TextItem("projectId", "项目编码");
		projectIdItem.setHidden(true);
		plateIdItem = new TextItem("plateId", "板块");
		plateIdItem.setHidden(true);

		setItems(contractCodeItem, projectCodeItem, projectNameItem, departmentIdItem, projectIdItem, plateIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
