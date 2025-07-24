package com.pomplatform.client.function.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.pomplatform.client.function.datasource.CDSfunctionffor;

public class SfunctionfforSearchForm extends SearchForm {

    private final TextItem functionNameItem;
    private final TextItem functionCodeItem;

    public SfunctionfforSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSfunctionffor.getInstance());
        functionNameItem = new TextItem("functionName", "功能名称");
        functionNameItem.setWidth("*");
        functionCodeItem = new TextItem("functionCode", "功能编号");
        functionCodeItem.setWidth("*");

        setItems(functionCodeItem,functionNameItem);

        setNumCols(4);
    }

}
