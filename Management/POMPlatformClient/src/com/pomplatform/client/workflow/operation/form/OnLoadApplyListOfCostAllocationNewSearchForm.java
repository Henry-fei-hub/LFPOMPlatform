package com.pomplatform.client.workflow.operation.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.workflow.operation.datasource.CDOnLoadApplyListOfCostAllocationNew;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadApplyListOfCostAllocationNewSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final TextItem employeeIdItem;

	public OnLoadApplyListOfCostAllocationNewSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadApplyListOfCostAllocationNew.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.setHidden(true);
		employeeIdItem = new TextItem("employeeId", "创建人");
		employeeIdItem.setHidden(true);
		setItems(processTypeItem, employeeIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
