package com.pomplatform.client.projectemployeeadvanceeachpersondetail.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectemployeeadvanceeachpersondetail.datasource.CDProjectEmployeeAdvanceEachPersonDetail;

public class ProjectEmployeeAdvanceEachPersonDetailSearchForm extends SearchForm
{


	private final SelectItem projectIdItem;
	private final SelectItem employeeIdItem;

	public ProjectEmployeeAdvanceEachPersonDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDProjectEmployeeAdvanceEachPersonDetail.getInstance());
		projectIdItem = new SelectItem("projectId", "补贴项目");
//		KeyValueManager.loadValueMap("projects",projectIdItem);
		KeyValueManager.loadValueMap("projects", projectIdItem);
		employeeIdItem = new SelectItem("employeeId", "补贴成员");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));

		setItems(projectIdItem, employeeIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
