package com.pomplatform.client.projectcost.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectcost.datasource.CDSprojectcostpcor;

public class SprojectcostpcorSearchForm extends SearchForm {

    private final TextItem projectIdItem;
    private final SelectItem costTypeItem;

    public SprojectcostpcorSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSprojectcostpcor.getInstance());
        projectIdItem = new TextItem("projectId", "项目编码");
        projectIdItem.setWidth("*");
        projectIdItem.hide();
        costTypeItem = new SelectItem("costType", "费用类型");
        costTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_9"));

        setItems(projectIdItem, costTypeItem);

        setNumCols(2);
    }

}
