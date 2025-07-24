package com.pomplatform.client.myinvite.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.myinvite.datasource.CDMprojectemployeeppedor;

public class MprojectemployeeppedorSearchForm extends SearchForm {

    private final TextItem projectIdItem;
    private final TextItem employeeIdItem;
    private final SelectItem designPhaseItem;

    public MprojectemployeeppedorSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDMprojectemployeeppedor.getInstance());
        projectIdItem = new TextItem("projectId", "项目编码");
        projectIdItem.setWidth("*");
        projectIdItem.hide();
        employeeIdItem = new TextItem("employeeId", "员工编码");
        employeeIdItem.setWidth("*");
        employeeIdItem.hide();
        designPhaseItem = new SelectItem("designPhase", "设计阶段");
        designPhaseItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

        setItems(projectIdItem, employeeIdItem, designPhaseItem);

        setNumCols(2);
    }

}
