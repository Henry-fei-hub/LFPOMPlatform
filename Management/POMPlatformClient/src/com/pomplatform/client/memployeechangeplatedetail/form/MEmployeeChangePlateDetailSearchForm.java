package com.pomplatform.client.memployeechangeplatedetail.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.memployeechangeplatedetail.datasource.CDMEmployeeChangePlateDetail;

public class MEmployeeChangePlateDetailSearchForm extends SearchForm {

    private final SelectItem yearItem;
    private final SelectItem startMonthItem;
    private final SelectItem endMonthItem;
    private final SelectItem inPlateIdItem;
    private final SelectItem outPlateIdItem;
    private final TextItem employeeNoItem;
    private final ComboBoxItem employeeIdItem;

    public MEmployeeChangePlateDetailSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDMEmployeeChangePlateDetail.getInstance());
        yearItem = new SelectItem("year", "年份");
        yearItem.setWidth("*");
        yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
        startMonthItem = new SelectItem("startMonth", "开始月份");
        startMonthItem.setWidth("*");
        startMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
        endMonthItem = new SelectItem("endMonth", "截止月份");
        endMonthItem.setWidth("*");
        endMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
        inPlateIdItem = new SelectItem("inPlateId", "转入业务部门");
        inPlateIdItem.setWidth("*");
        inPlateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        outPlateIdItem = new SelectItem("outPlateId", "转出业务部门");
        outPlateIdItem.setWidth("*");
        outPlateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        employeeNoItem = new TextItem("employeeNo", "工号");
        employeeNoItem.setWidth("*");
        employeeIdItem = new ComboBoxItem("employeeId", "姓名");
        employeeIdItem.setWidth("*");
        employeeIdItem.setChangeOnKeypress(false);
        employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));

        setItems(employeeNoItem, yearItem, startMonthItem, endMonthItem, employeeIdItem, inPlateIdItem, outPlateIdItem);

        setNumCols(8);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
