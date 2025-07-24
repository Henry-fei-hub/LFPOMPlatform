package com.pomplatform.client.analysisemployee.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.analysisemployee.datasource.CDEmployeeProjectAnalysis;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;

public class EmployeeProjectAnalysisSearchForm extends SearchForm
{


	private final ComboBoxItem plateIdItem;
	private final IPickTreeItem departmentIdItem;
	private final TextItem employeeNameItem;
	private final SelectItem isbusyItem;

	public EmployeeProjectAnalysisSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeProjectAnalysis.getInstance());
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setChangeOnKeypress(false);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdItem.setWidth("*");
		plateIdItem.setAllowEmptyValue(false);
		//如果拥有查看所有的权限
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.EMPLOYEE_PROJECT_ANALYSIS_ALL_PLATE)){
			plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		//如果只拥有查看自己管理部门的权限
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.EMPLOYEE_PROJECT_ANALYSIS_SOME_PLATE)){
			  String plateIds = PomPlatformClientUtil.getRolePlateId();
              String[] arr = plateIds.split(",");
              if(arr.length > 0){
                  plateIdItem.setDefaultValue(arr[0]);
               }
              RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
		}
		
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		
		isbusyItem = new SelectItem("isbusy", "状态");
		isbusyItem.setWidth("*");
		isbusyItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_140"));
		
		setItems(plateIdItem, employeeNameItem, isbusyItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
