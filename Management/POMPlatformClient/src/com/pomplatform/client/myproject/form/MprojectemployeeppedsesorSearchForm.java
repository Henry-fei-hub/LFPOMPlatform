package com.pomplatform.client.myproject.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.myproject.datasource.CDMprojectemployeeppedsesor;

public class MprojectemployeeppedsesorSearchForm extends SearchForm {

    private final TextItem projectIdItem;
    private final TextItem employeeIdItem;
    private final SelectItem designPhaseItem;
    private final DateItem startDateItem;
    private final DateItem endDateItem;
    private final SelectItem statusItem;

    public MprojectemployeeppedsesorSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDMprojectemployeeppedsesor.getInstance());
        projectIdItem = new TextItem("projectId", "项目编码");
        projectIdItem.setWidth("*");
        projectIdItem.hide();
        employeeIdItem = new TextItem("employeeId", "员工编码");
        employeeIdItem.setWidth("*");
        employeeIdItem.hide();
        designPhaseItem = new SelectItem("designPhase", "设计阶段");
        designPhaseItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));
        startDateItem = new DateItem("startDate", "开始日期");
        startDateItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                Date val = (Date) event.getValue();
                com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
            }
        });
        endDateItem = new DateItem("endDate", "结束日期");
        endDateItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                Date val = (Date) event.getValue();
                com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
            }
        });
        statusItem = new SelectItem("status", "状态");
        statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_5"));

        setItems(projectIdItem, employeeIdItem, designPhaseItem, startDateItem, endDateItem, statusItem);

        setNumCols(2);
    }

}
