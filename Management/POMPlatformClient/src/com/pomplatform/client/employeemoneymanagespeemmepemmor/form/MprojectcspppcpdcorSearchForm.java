package com.pomplatform.client.employeemoneymanagespeemmepemmor.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource.CDMprojectcspppcpdcor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class MprojectcspppcpdcorSearchForm extends SearchForm {

	private final TextItem projectIdItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem contractCodeItem;
	private final TextItem plateIdItem;
	private final ComboBoxItem departmentIdItem;
	private final TextItem contractIdItem;

	public MprojectcspppcpdcorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMprojectcspppcpdcor.getInstance());
		projectIdItem = new TextItem("projectId", "项目编码");
		projectIdItem.hide();
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");

		projectNameItem = new TextItem("projectName", "订单名称");
		projectNameItem.setWidth("*");

		contractCodeItem = new TextItem("contractCode", "订单编号");
		contractCodeItem.setWidth("*");
		plateIdItem = new TextItem("plateId", "板块");
		plateIdItem.hide();
		departmentIdItem = new ComboBoxItem("departmentId", "归属部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));

		contractIdItem = new TextItem("contractId", "合同编码");
		contractIdItem.hide();

		setItems(projectIdItem, projectCodeItem, projectNameItem, contractCodeItem, plateIdItem, departmentIdItem,
				contractIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
