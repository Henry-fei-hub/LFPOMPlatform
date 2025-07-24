package com.pomplatform.client.employeenew.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeenew.datasource.CDSemployeeNew;

public class SemployeeNewSearchForm extends SearchForm {

    private final ComboBoxItem plateIdItem;
    private final SelectItem dutyIdItem;
    private final TextItem employeeNoItem;
    private final TextItem employeeNameItem;
    private final IPickTreeItem departmentIdItem;
    private final SelectItem roleIdItem;
    private final SelectItem gradeIdItem;
    private final SelectItem statusItem;
    private final CheckboxItem isDepartmentItem;
    private final SelectItem genderItem;

    public SemployeeNewSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSemployeeNew.getInstance());
        plateIdItem = new ComboBoxItem("plateId", "板块");
        plateIdItem.setWidth("*");
        plateIdItem.setChangeOnKeypress(false);
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        dutyIdItem = new SelectItem("dutyId", "职位名称");
        dutyIdItem.setWidth("*");
        dutyIdItem.setValueMap(KeyValueManager.getValueMap("duties"));
        employeeNoItem = new TextItem("employeeNo", "员工编号");
        employeeNoItem.setWidth("*");
        employeeNameItem = new TextItem("employeeName", "员工姓名");
        employeeNameItem.setWidth("*");
        departmentIdItem = new IPickTreeItem("departmentId", "部门");
        departmentIdItem.setWidth("*");
        departmentIdItem.setCanSelectParentItems(true);
        departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
        roleIdItem = new SelectItem("roleId", "角色");
        roleIdItem.setWidth("*");
//        roleIdItem.setValueMap(KeyValueManager.getValueMap("roles"));
        KeyValueManager.loadValueMap("roles",roleIdItem);
        gradeIdItem = new SelectItem("gradeId", "等级");
        gradeIdItem.setWidth("*");
        gradeIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));
        statusItem = new SelectItem("status", "状态");
        statusItem.setWidth("*");
        statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));
        isDepartmentItem = new CheckboxItem("isDepartment", "是否为部门负责人");
        isDepartmentItem.setWidth("*");
        genderItem = new SelectItem("gender", "性别");
        genderItem.setWidth("*");
        genderItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));

        setItems(plateIdItem, dutyIdItem, employeeNoItem, employeeNameItem, departmentIdItem, roleIdItem, gradeIdItem, statusItem, isDepartmentItem, genderItem);

        setNumCols(10);
    }

}
