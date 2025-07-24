package com.pomplatform.client.projectsettlement.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectsettlement.datasource.CDOnLoadProjectSettlementEmployees;

public class OnLoadProjectSettlementEmployeesSearchForm extends SearchForm
{


	private final TextItem projectIdItem;
	private final TextItem employeeIdItem;

	public OnLoadProjectSettlementEmployeesSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadProjectSettlementEmployees.getInstance());
		projectIdItem = new TextItem("projectId", "项目编码");
		employeeIdItem = new TextItem("employeeId", "创建人");

		setItems(projectIdItem, employeeIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
