package com.pomplatform.client.employeeawardtotal.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeeaward.datasource.CDMemployeeAward;

public class MemployeeAwardTotalSearchForm extends SearchForm {

    private final SelectItem yearsItem;
    private final SelectItem startMonthItem;
    private final SelectItem endMonthItem;
    private final SelectItem employeeIdItem;
    private final ComboBoxItem plateIdItem;
    private final IPickTreeItem departmentIdItem;
    private final TextItem employeeNameItem;

    public MemployeeAwardTotalSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDMemployeeAward.getInstance());
        Date d = new Date();
        yearsItem = new SelectItem("years", "年份");
        yearsItem.setValue(2016);
        yearsItem.setWidth("*");
        yearsItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
        startMonthItem = new SelectItem("startMonth", "开始月份");
        startMonthItem.setWidth("*");
        startMonthItem.setValue(d.getMonth() + 1);
        startMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
        endMonthItem = new SelectItem("endMonth", "截止月份");
        endMonthItem.setWidth("*");
        endMonthItem.setValue(d.getMonth() + 1);
        endMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
        employeeIdItem = new SelectItem("employeeId", "职员编码");
        employeeIdItem.hide();
        employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
        
        departmentIdItem = new IPickTreeItem("departmentId", "部门");
        departmentIdItem.hide();
        departmentIdItem.setWidth("*");
        departmentIdItem.setCanSelectParentItems(true);
        departmentIdItem.setValueTree(KeyValueManager.getTree("project_departments"));
        employeeNameItem = new TextItem("employeeNameValue", "员工姓名");
        employeeNameItem.setWidth("*");

        setItems(yearsItem, startMonthItem, endMonthItem, employeeIdItem, plateIdItem, departmentIdItem, employeeNameItem);

        setNumCols(6);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
