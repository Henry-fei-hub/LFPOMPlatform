package com.pomplatform.client.personal.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.pomplatform.client.personal.datasource.CDSemployeeeor;

public class SemployeeeorSearchForm extends SearchForm {

    private final TextItem employeeIdItem;

    public SemployeeeorSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSemployeeeor.getInstance());
        employeeIdItem = new TextItem("employeeId", "员工编码");
        employeeIdItem.setWidth("*");

        setItems(employeeIdItem);

        setNumCols(4);
    }

}
