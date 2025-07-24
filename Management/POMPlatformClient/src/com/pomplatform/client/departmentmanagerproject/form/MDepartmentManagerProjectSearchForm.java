package com.pomplatform.client.departmentmanagerproject.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.departmentmanagerproject.datasource.CDMDepartmentManagerProject;

public class MDepartmentManagerProjectSearchForm extends SearchForm {

    private final TextItem employeeIdItem;
    private final SelectItem projectTypeItem;

    public MDepartmentManagerProjectSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDMDepartmentManagerProject.getInstance());
        employeeIdItem = new TextItem("employeeId", "员工编码");
        employeeIdItem.setWidth("*");
        employeeIdItem.hide();
        projectTypeItem = new SelectItem("projectType", "项目类型");
        projectTypeItem.setWidth("*");
        projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        setItems(employeeIdItem, projectTypeItem);

        setNumCols(2);
    }

}
