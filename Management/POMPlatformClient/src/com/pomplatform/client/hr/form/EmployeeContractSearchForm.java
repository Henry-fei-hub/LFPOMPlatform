package com.pomplatform.client.hr.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.hr.datasource.CDSemployeeForHR;

public class EmployeeContractSearchForm extends SearchForm {

    private final TextItem employeeNoItem;
    private final TextItem employeeNameItem;
    private final IPickTreeItem departmentIdItem;
    private final SelectItem statusItem;
    private final DateItem onboardDateItem;

    public EmployeeContractSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSemployeeForHR.getInstance());
        employeeNoItem = new TextItem("employeeNo", "员工编号");
        employeeNoItem.setWidth("*");
        
        employeeNameItem = new TextItem("employeeName", "员工姓名");
        employeeNameItem.setWidth("*");
        
        departmentIdItem = new IPickTreeItem("departmentId", "所属部门");
        departmentIdItem.setCanSelectParentItems(true);
        departmentIdItem.setValueField("treeId");
        departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
        departmentIdItem.setWidth("*");
        
        statusItem = new SelectItem("status", "状态");
        statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));
        statusItem.setWidth("*");
        
        onboardDateItem =  new DateItem("onboardDate","入职日期");
        onboardDateItem.setWidth("*");
        onboardDateItem.setUseTextField(true);
        onboardDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
        
        setItems(employeeNoItem, employeeNameItem, departmentIdItem,statusItem,onboardDateItem);

        setNumCols(10);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
