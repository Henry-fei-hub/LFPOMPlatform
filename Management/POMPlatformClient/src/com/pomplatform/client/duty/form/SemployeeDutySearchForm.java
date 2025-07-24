package com.pomplatform.client.duty.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.pomplatform.client.duty.datasource.CDSemployeeDuty;

public class SemployeeDutySearchForm extends SearchForm {

    private final TextItem dutyNameItem;
    private final TextItem dutyIdItem;

    public SemployeeDutySearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSemployeeDuty.getInstance());
        dutyNameItem = new TextItem("dutyName", "职位名称");
        dutyNameItem.setWidth("*");
        dutyIdItem = new TextItem("dutyId", "职位");
        dutyIdItem.setWidth("*");
        dutyIdItem.hide();

        setItems(dutyNameItem, dutyIdItem);

        setNumCols(2);
    }

}
