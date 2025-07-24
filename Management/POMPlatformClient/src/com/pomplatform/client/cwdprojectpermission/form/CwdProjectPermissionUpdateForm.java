package com.pomplatform.client.cwdprojectpermission.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.management.datasource.DSSelectGridEmployeeValue;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.cwdprojectpermission.datasource.DSCwdProjectPermission;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.grid.ListGridField;

public class CwdProjectPermissionUpdateForm extends AbstractWizadPage
{


	private final TextItem cwdProjectPermissionIdItem;
	private final ComboBoxItem employeeIdItem;
	private final SelectItem permissionTypeItem;
	private final SelectItem operatePersonItem;
	private final DateTimeItem createTimeItem;

	public CwdProjectPermissionUpdateForm() {
		DSCwdProjectPermission ds = DSCwdProjectPermission.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		cwdProjectPermissionIdItem = new TextItem("cwdProjectPermissionId", "主键编码");
		cwdProjectPermissionIdItem.setDisabled(true);
		cwdProjectPermissionIdItem.setRequired(true);
		cwdProjectPermissionIdItem.setHidden(true);
		IsIntegerValidator cwdProjectPermissionIdValidator = new IsIntegerValidator();
		cwdProjectPermissionIdItem.setValidators(cwdProjectPermissionIdValidator);
		__formItems.add(cwdProjectPermissionIdItem);
		
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
		__formItems.add(employeeIdItem);

		permissionTypeItem = new SelectItem("permissionType", "CDC项目查看权限");
		permissionTypeItem.setWidth("*");
		permissionTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_238"));
		__formItems.add(permissionTypeItem);
		
		operatePersonItem = new SelectItem("operatePerson", "操作人");
		operatePersonItem.setWidth("*");
		operatePersonItem.setCanEdit(false);
		operatePersonItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(operatePersonItem);
		
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setWidth("*");
		createTimeItem.setCanEdit(false);
		__formItems.add(createTimeItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSCwdProjectPermission.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
