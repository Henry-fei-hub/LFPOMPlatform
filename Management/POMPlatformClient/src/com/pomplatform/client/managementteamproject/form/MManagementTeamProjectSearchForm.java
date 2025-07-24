package com.pomplatform.client.managementteamproject.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.managementteamproject.datasource.CDMManagementTeamProject;

public class MManagementTeamProjectSearchForm extends SearchForm {

    private final ComboBoxItem projectIdItem;
    private final IPickTreeItem departmentIdItem;
    private final SelectItem projectTypeItem;
    private final SelectItem statusItem;
    private final TextItem projectNameItem;

    public MManagementTeamProjectSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDMManagementTeamProject.getInstance());
        projectNameItem = new TextItem("projectName", "项目名称");
        projectNameItem.setWidth("*");
        projectIdItem = new ComboBoxItem("projectId", "项目名称");
        projectIdItem.setWidth("*");
        projectIdItem.setChangeOnKeypress(false);
        projectIdItem.hide();
        KeyValueManager.loadValueMap("projects",projectIdItem);
        departmentIdItem = new IPickTreeItem("departmentId", "归属部门");
        departmentIdItem.setWidth("*");
        departmentIdItem.setCanSelectParentItems(true);
        departmentIdItem.setValueTree(KeyValueManager.getTree("project_departments"));
        projectTypeItem = new SelectItem("projectType", "项目类型");
        projectTypeItem.setWidth("*");
        projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        statusItem = new SelectItem("status", "项目状态");
        statusItem.setWidth("*");
        statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));

        setItems(projectNameItem,projectIdItem, departmentIdItem, projectTypeItem, statusItem);

        setNumCols(4);
    }

}
