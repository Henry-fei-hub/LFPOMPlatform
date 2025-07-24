package com.pomplatform.client.role.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.pomplatform.client.role.datasource.CDSroleror;

public class SrolerorSearchForm extends SearchForm {

    private final TextItem roleNameItem;

    public SrolerorSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSroleror.getInstance());
        roleNameItem = new TextItem("roleName", "角色名称");
        roleNameItem.setWidth("*");

        setItems(roleNameItem);

        setNumCols(2);
    }

}
