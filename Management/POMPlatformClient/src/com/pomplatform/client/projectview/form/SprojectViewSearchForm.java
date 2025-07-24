package com.pomplatform.client.projectview.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.pomplatform.client.projectview.datasource.CDSprojectView;

public class SprojectViewSearchForm extends SearchForm {

    private final TextItem projectIdItem;

    public SprojectViewSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSprojectView.getInstance());
        projectIdItem = new TextItem("projectId", "项目编码");
        projectIdItem.setWidth("*");
        projectIdItem.hide();
        setItems(projectIdItem);

        setNumCols(4);
    }

}
