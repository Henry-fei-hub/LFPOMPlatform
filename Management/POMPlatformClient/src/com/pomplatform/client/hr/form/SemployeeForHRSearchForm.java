package com.pomplatform.client.hr.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.hr.datasource.CDSemployeeForHR;

public class SemployeeForHRSearchForm extends SearchForm {

    private final ComboBoxItem plateIdItem;
    private final SelectItem dutyIdItem;
    private final TextItem employeeNoItem;
    private final TextItem employeeNameItem;
    private final SelectItem departmentIdItem;
    private final SelectItem roleIdItem;
    private final SelectItem gradeIdItem;
    private final SelectItem statusItem;
    private final CheckboxItem isDepartmentItem;
    private final SelectItem genderItem;

    public SemployeeForHRSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSemployeeForHR.getInstance());
        plateIdItem = new ComboBoxItem("plateId", "板块");
        plateIdItem.setChangeOnKeypress(false);
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        dutyIdItem = new SelectItem("dutyId", "职位名称");
        dutyIdItem.setValueMap(KeyValueManager.getValueMap("duties"));
        employeeNoItem = new TextItem("employeeNo", "员工编号");
        employeeNoItem.setWidth("*");
        employeeNameItem = new TextItem("employeeName", "员工姓名");
        employeeNameItem.setWidth("*");
        departmentIdItem = new SelectItem("departmentId", "角色编码");
        departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
        roleIdItem = new SelectItem("roleId", "部门编码");
//        roleIdItem.setValueMap(KeyValueManager.getValueMap("roles"));
        KeyValueManager.loadValueMap("roles",roleIdItem);
        gradeIdItem = new SelectItem("gradeId", "等级");
        gradeIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));
        statusItem = new SelectItem("status", "状态");
        statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));
        isDepartmentItem = new CheckboxItem("isDepartment", "是否为部门负责人");
        genderItem = new SelectItem("gender", "性别");
        genderItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));

        setItems(plateIdItem, dutyIdItem, employeeNoItem, employeeNameItem, departmentIdItem, roleIdItem, gradeIdItem, statusItem, isDepartmentItem, genderItem);

        setNumCols(4);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
