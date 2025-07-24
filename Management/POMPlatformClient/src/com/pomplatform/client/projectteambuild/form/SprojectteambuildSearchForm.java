package com.pomplatform.client.projectteambuild.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectteambuild.datasource.CDSprojectteambuild;

public class SprojectteambuildSearchForm extends SearchForm
{


	private final TextItem projectIdItem;
	private final TextItem departmentIdItem;
	private final TextItem designPhaseItem;
	private final TextItem projectLevelItem;

	public SprojectteambuildSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSprojectteambuild.getInstance());
		projectIdItem = new TextItem("projectId", "项目编码");
		projectIdItem.setWidth("*");
		departmentIdItem = new TextItem("departmentId", "归属部门");
		departmentIdItem.setWidth("*");
		designPhaseItem = new TextItem("designPhase", "设计阶段");
		designPhaseItem.setWidth("*");
		projectLevelItem = new TextItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");

		setItems(projectIdItem, departmentIdItem, designPhaseItem, projectLevelItem);

		setNumCols(4);
	}

}
