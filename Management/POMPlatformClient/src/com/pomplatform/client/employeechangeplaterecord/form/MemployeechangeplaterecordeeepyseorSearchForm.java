package com.pomplatform.client.employeechangeplaterecord.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeechangeplaterecord.datasource.CDMemployeechangeplaterecordeeepyseor;

public class MemployeechangeplaterecordeeepyseorSearchForm extends SearchForm {

    private final TextItem employeeNoItem;
    private final ComboBoxItem employeeIdItem;
    private final ComboBoxItem plateIdItem;
    private final SelectItem yearItem;
    private final SelectItem startMonthItem;
    private final SelectItem endMonthItem;

    public MemployeechangeplaterecordeeepyseorSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDMemployeechangeplaterecordeeepyseor.getInstance());
        employeeNoItem = new TextItem("employeeNo", "工号");
        employeeNoItem.setWidth("*");
        employeeIdItem = new ComboBoxItem("employeeId", "姓名");
        employeeIdItem.setWidth("*");
        employeeIdItem.setChangeOnKeypress(false);
        employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
        yearItem = new SelectItem("year", "年份");
        yearItem.setWidth("*");
        yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
        startMonthItem = new SelectItem("startMonth", "开始月份");
        startMonthItem.setWidth("*");
        startMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
        endMonthItem = new SelectItem("endMonth", "截止月份");
        endMonthItem.setWidth("*");
        endMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));

        setItems(employeeNoItem, employeeIdItem, plateIdItem, yearItem, startMonthItem, endMonthItem);

        setNumCols(6);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
