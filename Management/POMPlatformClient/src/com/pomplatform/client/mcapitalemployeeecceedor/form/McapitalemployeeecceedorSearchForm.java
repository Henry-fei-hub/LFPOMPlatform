package com.pomplatform.client.mcapitalemployeeecceedor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.mcapitalemployeeecceedor.datasource.CDMcapitalemployeeecceedor;

public class McapitalemployeeecceedorSearchForm extends SearchForm
{


	private final TextItem capitalEmployeeIdItem;
	private final TextItem capitalIdItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNameItem;
	private final TextItem departmentIdItem;

	public McapitalemployeeecceedorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcapitalemployeeecceedor.getInstance());
		capitalEmployeeIdItem = new TextItem("capitalEmployeeId", "主键");
		capitalIdItem = new TextItem("capitalId", "回款编码");
		employeeIdItem = new TextItem("employeeId", "员工主键");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		departmentIdItem = new TextItem("departmentId", "部门");

		setItems(capitalEmployeeIdItem, capitalIdItem, employeeIdItem, employeeNameItem, departmentIdItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
