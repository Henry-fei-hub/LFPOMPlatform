package com.pomplatform.client.contract.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.pomplatform.client.contract.datasource.CDScontractccor;

public class ScontractccorSearchForm extends SearchForm {

    private final TextItem contractNameItem;
    private final TextItem contractCodeItem;

    public ScontractccorSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDScontractccor.getInstance());
        contractNameItem = new TextItem("contractName", "合同名称");
        contractNameItem.setWidth("*");
        contractCodeItem = new TextItem("contractCode", "合同编号");
        contractCodeItem.setWidth("*");

        setItems(contractNameItem, contractCodeItem);

        setNumCols(4);
    }

}
