package com.pomplatform.client.sprojectintegralsumrecordpymor.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sprojectintegralsumrecordpymor.datasource.CDSprojectintegralsumrecordpymor;

public class SprojectintegralsumrecordpymorSearchForm extends SearchForm {

    private final SelectItem plateIdItem;
    private final SelectItem yearItem;
    private final SelectItem startMonthItem;
    private final SelectItem endMonthItem;

    public SprojectintegralsumrecordpymorSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSprojectintegralsumrecordpymor.getInstance());
        plateIdItem = new SelectItem("plateId", "版块ID");
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        plateIdItem.hide();
        yearItem = new SelectItem("year", "年份");
        yearItem.setWidth("*");
        yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
        startMonthItem = new SelectItem("startMonth", "开始月份");
        startMonthItem.setWidth("*");
        startMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
        endMonthItem = new SelectItem("endMonth", "截止月份");
        endMonthItem.setWidth("*");
        endMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));

        setItems(plateIdItem, yearItem, startMonthItem, endMonthItem);

        setNumCols(6);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
