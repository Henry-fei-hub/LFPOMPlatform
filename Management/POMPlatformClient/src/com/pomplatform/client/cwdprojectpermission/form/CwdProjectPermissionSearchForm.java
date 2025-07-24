package com.pomplatform.client.cwdprojectpermission.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.management.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.cwdprojectpermission.datasource.CDCwdProjectPermission;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGridField;

public class CwdProjectPermissionSearchForm extends SearchForm
{


	private final ComboBoxItem employeeIdItem;
	private final SelectItem permissionTypeItem;
	private final ComboBoxItem operatePersonItem;

	public CwdProjectPermissionSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCwdProjectPermission.getInstance());
		
		ListGridField employeeIdField = new ListGridField("employeeId");
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		KeyValueManager.loadValueMap("all_departments",departmentIdField);
		
        //只查询出在职的员工
        Criteria employeeCondition = new Criteria();
        employeeCondition.addCriteria("status", 0);
        
		employeeIdItem = new ComboBoxItem("employeeId", "职员");
		employeeIdItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setValueField(employeeIdField.getName());
		employeeIdItem.setDisplayField(employeeNameField.getName());
		employeeIdItem.setPickListFields(departmentIdField, employeeNoField, employeeNameField);
		employeeIdItem.setPickListWidth(500);
		employeeIdItem.setPickListCriteria(employeeCondition);
		employeeIdItem.setWidth("*");
		
		permissionTypeItem = new SelectItem("permissionType", "CDC项目查看权限");
		permissionTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_238"));
		permissionTypeItem.setWidth("*");
		
		operatePersonItem = new ComboBoxItem("operatePerson", "操作人");
		operatePersonItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		operatePersonItem.setChangeOnKeypress(false);
		operatePersonItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		operatePersonItem.setValueField(employeeIdField.getName());
		operatePersonItem.setDisplayField(employeeNameField.getName());
		operatePersonItem.setPickListFields(departmentIdField, employeeNoField, employeeNameField);
		operatePersonItem.setPickListWidth(500);
		operatePersonItem.setPickListCriteria(employeeCondition);
		operatePersonItem.setWidth("*");

		setItems(employeeIdItem, permissionTypeItem, operatePersonItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
