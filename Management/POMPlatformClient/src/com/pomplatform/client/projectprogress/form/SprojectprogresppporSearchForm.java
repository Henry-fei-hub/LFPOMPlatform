package com.pomplatform.client.projectprogress.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectprogress.datasource.CDSprojectprogrespppor;

public class SprojectprogresppporSearchForm extends SearchForm {

    private final TextItem projectProgressIdItem;
    private final TextItem projectIdItem;
    private final TextItem projectManageIdItem;
    private final SelectItem designPhaseItem;

    public SprojectprogresppporSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSprojectprogrespppor.getInstance());
        projectProgressIdItem = new TextItem("projectProgressId", "项目进度编码");
        projectProgressIdItem.setWidth("*");
        projectIdItem = new TextItem("projectId", "项目编码");
        projectIdItem.setWidth("*");
        projectManageIdItem = new TextItem("projectManageId", "项目负责人编码");
        projectManageIdItem.setWidth("*");
        designPhaseItem = new SelectItem("designPhase", "设计阶段");
        designPhaseItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

        setItems(projectProgressIdItem, projectIdItem, projectManageIdItem, designPhaseItem);

        setNumCols(2);
    }

}
