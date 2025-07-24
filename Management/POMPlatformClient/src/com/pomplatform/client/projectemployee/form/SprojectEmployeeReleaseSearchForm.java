package com.pomplatform.client.projectemployee.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectemployee.datasource.CDSprojectemployeepdsor;

public class SprojectEmployeeReleaseSearchForm extends SearchForm {

    private final TextItem projectIdItem;
    private final SelectItem designPhaseItem;
    private final DateItem startDateItem;
    private final DateItem endDateItem;
    private final SelectItem statusItem;

    public SprojectEmployeeReleaseSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSprojectemployeepdsor.getInstance());
        projectIdItem = new TextItem("projectId", "项目编码");
        projectIdItem.setWidth("*");
        projectIdItem.hide();
        designPhaseItem = new SelectItem("designPhase", "设计阶段");
        designPhaseItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));
        startDateItem = new DateItem("startDate", "开始日期");
        startDateItem.hide();
        startDateItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                Date val = (Date) event.getValue();
                com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
            }
        });
        endDateItem = new DateItem("endDate", "结束日期");
        endDateItem.hide();
        endDateItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                Date val = (Date) event.getValue();
                com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
            }
        });
        statusItem = new SelectItem("status", "状态");
        statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_5"));
        statusItem.hide();
        setItems(projectIdItem, startDateItem, endDateItem, designPhaseItem, statusItem);
        setNumCols(2);
    }

}
