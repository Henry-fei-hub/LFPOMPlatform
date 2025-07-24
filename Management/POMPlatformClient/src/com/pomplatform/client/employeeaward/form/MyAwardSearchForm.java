package com.pomplatform.client.employeeaward.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeeaward.datasource.CDMemployeeAward;
import java.util.Date;

public class MyAwardSearchForm extends SearchForm {

    private final SelectItem yearsItem;
    private final SelectItem startMonthItem;
    private final SelectItem endMonthItem;
    private final SelectItem employeeIdItem;

    public MyAwardSearchForm() {
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
        endMonthItem.setValue(d.getMonth() + 2);
        endMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
        employeeIdItem = new SelectItem("employeeId", "职员编码");
        employeeIdItem.hide();
        employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));

        setItems(yearsItem, startMonthItem, endMonthItem, employeeIdItem);

        setNumCols(6);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
