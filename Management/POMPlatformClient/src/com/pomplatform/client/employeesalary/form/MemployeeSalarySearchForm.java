package com.pomplatform.client.employeesalary.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeesalary.datasource.CDMemployeeSalary;
import java.util.Date;

public class MemployeeSalarySearchForm extends SearchForm {

    private final TextItem employeeNameItem;
    private final SelectItem yearsItem;
    private final SelectItem startMonthItem;
    private final SelectItem endMonthItem;
    private final SelectItem employeeIdItem;
    private final SelectItem plateIdItem;
    private final IPickTreeItem departmentIdItem;

    public MemployeeSalarySearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDMemployeeSalary.getInstance());
        Date d = new Date();
        yearsItem = new SelectItem("years", "年份");
        yearsItem.setValue(2017);
        yearsItem.setWidth("*");
        yearsItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
        startMonthItem = new SelectItem("startMonth", "开始月份");
        startMonthItem.setWidth("*");
        startMonthItem.setValue(d.getMonth() + 1);
        startMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
        endMonthItem = new SelectItem("endMonth", "截止月份");
        endMonthItem.setWidth("*");
        endMonthItem.setValue(d.getMonth() + 2);
        endMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
        employeeIdItem = new SelectItem("employeeId", "职员编码");
        employeeIdItem.hide();
        employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
        plateIdItem = new SelectItem("plateId", "板块");
        plateIdItem.setWidth("*");
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        departmentIdItem = new IPickTreeItem("departmentId", "部门");
        departmentIdItem.setWidth("*");
        departmentIdItem.setValueField("treeId");
        departmentIdItem.setCanSelectParentItems(true);
        departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
        employeeNameItem = new TextItem("employeeName", "员工姓名");
        employeeNameItem.setWidth("*");

        setItems(yearsItem, startMonthItem, endMonthItem, employeeIdItem, plateIdItem, departmentIdItem,employeeNameItem);

        setNumCols(6);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
