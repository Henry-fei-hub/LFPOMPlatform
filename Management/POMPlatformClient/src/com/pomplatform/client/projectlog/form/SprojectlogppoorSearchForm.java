package com.pomplatform.client.projectlog.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectlog.datasource.CDSprojectlogppoor;

public class SprojectlogppoorSearchForm extends SearchForm {

    private final TextItem projectLogIdItem;
    private final TextItem projectIdItem;
    private final TextItem operateIdItem;
    private final TextItem departmentIdItem;
    private final TextItem managerIdItem;
    private final SelectItem designPhaseItem;
    private final TextItem logTypeItem;

    public SprojectlogppoorSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSprojectlogppoor.getInstance());
        projectLogIdItem = new TextItem("projectLogId", "项目日志编码");
        projectLogIdItem.setWidth("*");
        projectLogIdItem.hide();
        projectIdItem = new TextItem("projectId", "项目");
        projectIdItem.setWidth("*");
        projectIdItem.hide();
        operateIdItem = new TextItem("operateId", "操作人");
        operateIdItem.setWidth("*");
        operateIdItem.hide();
        departmentIdItem = new TextItem("departmentId", "归属部门");
        departmentIdItem.setWidth("*");
        departmentIdItem.hide();
        managerIdItem = new TextItem("managerId", "板块负责人");
        managerIdItem.setWidth("*");
        managerIdItem.hide();
        designPhaseItem = new SelectItem("designPhase", "设计阶段");
        designPhaseItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));
        logTypeItem = new TextItem("logType", "日志类型");
        logTypeItem.setWidth("*");
        logTypeItem.hide();

        setItems(projectLogIdItem, projectIdItem, operateIdItem, departmentIdItem, managerIdItem, designPhaseItem, logTypeItem);

        setNumCols(2);
    }

}
