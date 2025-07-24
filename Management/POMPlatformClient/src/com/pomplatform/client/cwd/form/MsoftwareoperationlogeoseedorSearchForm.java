package com.pomplatform.client.cwd.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.cwd.datasource.CDMsoftwareoperationlogeoseedor;

public class MsoftwareoperationlogeoseedorSearchForm extends SearchForm
{


	private final SelectItem operationTypeItem;
	private final SelectItem softwareTypeItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final PickTreeItem departmentIdItem;

	public MsoftwareoperationlogeoseedorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMsoftwareoperationlogeoseedor.getInstance());
		operationTypeItem = new SelectItem("operationType", "操作类型");
		operationTypeItem.setWidth("*");
		operationTypeItem.setValueMap((LinkedHashMap)getDataSource().getField("operationType").getValueMap());
		softwareTypeItem = new SelectItem("softwareType", "软件类型");
		softwareTypeItem.setWidth("*");
		softwareTypeItem.setValueMap((LinkedHashMap)getDataSource().getField("softwareType").getValueMap());
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		departmentIdItem = new PickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setWidth("*");

		setItems(operationTypeItem, softwareTypeItem, employeeNoItem, employeeNameItem, departmentIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
