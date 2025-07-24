package com.pomplatform.client.projectperformance.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectperformance.datasource.CDProjectPerformanceDetail;

public class ProjectPerformanceDetailSearchForm extends SearchForm
{


	private final SelectItem employeeIdItem;
	private final SelectItem contractIdItem;
	private final SelectItem projectIdItem;
	private final TextItem performanceFlagItem;
	private final SelectItem businessTypeItem;

	public ProjectPerformanceDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDProjectPerformanceDetail.getInstance());
		employeeIdItem = new SelectItem("employeeId", "职员");
//		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdItem);
		contractIdItem = new SelectItem("contractId", "合同编码");
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdItem);
		projectIdItem = new SelectItem("projectId", "项目编码");
		KeyValueManager.loadValueMap("projects",projectIdItem);
		performanceFlagItem = new TextItem("performanceFlag", "绩效类型");
		businessTypeItem = new SelectItem("businessType", "业务类型");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));

		setItems(employeeIdItem, contractIdItem, projectIdItem, performanceFlagItem, businessTypeItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
