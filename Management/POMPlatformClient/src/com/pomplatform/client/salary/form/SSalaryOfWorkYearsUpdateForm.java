package com.pomplatform.client.salary.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.project.datasource.DSSprojectccpor;
import com.pomplatform.client.salary.datasource.DSSalaryOfWorkYears;
import com.pomplatform.client.salary.datasource.DSSalaryOfWorkYearsUpdate;

public class SSalaryOfWorkYearsUpdateForm extends AbstractWizadPage {

    private final TextItem employeeIdItem;
    private final TextItem employeeNoItem;
    private final TextItem employeeNameItem;
    private final TextItem yearItem;
    private final SelectItem monthItem;
    private final TextItem workMoneyItem;
    
    public SSalaryOfWorkYearsUpdateForm() {
        __form = new DynamicForm();
        DSSalaryOfWorkYearsUpdate ds = DSSalaryOfWorkYearsUpdate.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        employeeIdItem = new TextItem("employeeId", "员工编码");
        employeeIdItem.setWidth("*");
        employeeIdItem.setDisabled(true);
        employeeIdItem.setRequired(true);
        employeeIdItem.hide();
        
        employeeNoItem = new TextItem("employeeNo", "员工编号");
        employeeNoItem.setWidth("*");
        employeeNoItem.disable();
        
        employeeNameItem = new TextItem("employeeName", "员工姓名");
        employeeNameItem.setWidth("*");
        employeeNameItem.disable();
        
        yearItem = new TextItem("year", "年份");
        yearItem.setWidth("*");
        yearItem.disable();
        
        monthItem = new SelectItem("month", "月份");
        monthItem.setWidth("*");
        monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
        
        workMoneyItem = new TextItem("workMoney", "工龄工资");
        workMoneyItem.setWidth("*");
        
        __form.setItems(employeeIdItem,employeeNoItem,employeeNameItem,yearItem,monthItem,workMoneyItem);
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        setPageMode(PAGE_MODE_UPDATE);
        addMember(__form);
    }

    @Override
    public Map<String, FormItem> getItems() {
        Map<String, FormItem> res = new HashMap<>();
        res.put("employeeId", employeeIdItem);
        res.put("year", yearItem);
        res.put("month", monthItem);
        res.put("workMoney", workMoneyItem);
        return res;
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) {
            __form.editRecord(getRecord());
        }
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSSalaryOfWorkYearsUpdate.getInstance());
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

    private final DynamicForm __form;

}
