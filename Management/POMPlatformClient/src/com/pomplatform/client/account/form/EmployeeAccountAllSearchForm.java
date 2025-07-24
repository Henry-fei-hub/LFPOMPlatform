package com.pomplatform.client.account.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class EmployeeAccountAllSearchForm extends SearchForm {

	private final ComboBoxItem plateIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;

	public EmployeeAccountAllSearchForm() {
		setWidth100();
		setHeight100();
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setChangeOnKeypress(false);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		//查看所有部门的数据
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PERSONAL_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA)){
			plateIdItem.setDefaultValue(ClientUtil.getPlateId());
			plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.PERSONAL_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA)){
			String plateIds = PomPlatformClientUtil.getRolePlateId();
			String[] arr = plateIds.split(",");
			if(arr.length > 0){
				plateIdItem.setDefaultValue(arr[0]);
			}
			RoleDefinition.setPlateItemValueMap(plateIdItem,plateIds);
		}
		
		startDateItem = new DateItem("startDate", "开始时间");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);  
		endDateItem = new DateItem("endDate", "截止时间");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);  
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		employeeNameItem = new TextItem("employeeName", "姓名");
		employeeNameItem.setWidth("*");

		setItems(plateIdItem, startDateItem, endDateItem, employeeNoItem, employeeNameItem);
		setNumCols(11);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
