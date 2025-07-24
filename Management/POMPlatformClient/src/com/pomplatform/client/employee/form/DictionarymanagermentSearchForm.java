package com.pomplatform.client.employee.form;

import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class DictionarymanagermentSearchForm extends SearchForm {

    private final TextItem dicTypeIdItem;

    public DictionarymanagermentSearchForm() {

        dicTypeIdItem = new TextItem("dicTypeId" , "下拉数据名称");

        setItems(dicTypeIdItem);
    }
}
