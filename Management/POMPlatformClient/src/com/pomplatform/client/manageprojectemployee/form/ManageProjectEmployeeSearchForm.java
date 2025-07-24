package com.pomplatform.client.manageprojectemployee.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.manageprojectemployee.datasource.CDManageProjectEmployee;

public class ManageProjectEmployeeSearchForm extends SearchForm
{


	private final SelectItem manageProjectIdItem;
	private final SelectItem employeeIdItem;

	public ManageProjectEmployeeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDManageProjectEmployee.getInstance());
		manageProjectIdItem = new SelectItem("manageProjectId", "管理项目");
//		manageProjectIdItem.setValueMap(KeyValueManager.getValueMap("manage_projects"));
		KeyValueManager.loadValueMap("manage_projects", manageProjectIdItem);
		employeeIdItem = new SelectItem("employeeId", "发放成员");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));

		setItems(manageProjectIdItem, employeeIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
