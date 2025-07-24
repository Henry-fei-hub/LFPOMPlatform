package com.pomplatform.client.project.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.project.datasource.CDOnRevenueSureWarn;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnRevenueSureWarnSearchForm extends SearchForm
{

	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final SelectItem plateIdItem;

	public OnRevenueSureWarnSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnRevenueSureWarn.getInstance());
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		//如果拥有查查所有部门的权限
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REVENUE_SURE_WARN_CHECK_ALL)) {
			plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		}else{//查看自己管理部门的权限
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			String[] arr = plateIds.split(",");
			if(arr.length > 0){
				plateIdItem.setDefaultValue(arr[0]);
			}
			RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
		}

		setItems(employeeNoItem, employeeNameItem, plateIdItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
