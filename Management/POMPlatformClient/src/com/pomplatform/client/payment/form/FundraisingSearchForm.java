package com.pomplatform.client.payment.form;

import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectteambuild.datasource.CDSemployeeedror;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

import java.util.Date;

public class FundraisingSearchForm extends SearchForm {

    private final ComboBoxItem employeeIdItem;
    private final ComboBoxItem plateIdItem;
    private final DateTimeItem startDateItem;
    private final DateTimeItem endDateItem;

    public FundraisingSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSemployeeedror.getInstance());

        employeeIdItem = new ComboBoxItem("employeeId", "职员姓名");
        employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
        employeeIdItem.setWidth("*");

        plateIdItem = new ComboBoxItem("plateId" , "业务部门");
        plateIdItem.setWidth("*");
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        startDateItem = new DateTimeItem("startDate", "开始时间");
        startDateItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                Date val = (Date) event.getValue();
                com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
            }
        });
        startDateItem.setWidth("*");

        endDateItem = new DateTimeItem("endDate", "结束时间");
        endDateItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                Date val = (Date) event.getValue();
                com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
            }
        });
        endDateItem.setWidth("*");

        setItems(employeeIdItem , plateIdItem , startDateItem ,endDateItem);

        setNumCols(8);
    }

}
