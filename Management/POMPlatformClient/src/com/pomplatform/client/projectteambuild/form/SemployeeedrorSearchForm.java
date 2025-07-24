package com.pomplatform.client.projectteambuild.form;

import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.pomplatform.client.projectteambuild.datasource.CDSemployeeedror;

public class SemployeeedrorSearchForm extends SearchForm {

    private final TextItem employeeNameItem;
    private final IPickTreeItem departmentIdItem;
    private final SelectItem roleIdItem;
    private final SelectItem gradeIdItem;

    public SemployeeedrorSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSemployeeedror.getInstance());
        employeeNameItem = new TextItem("employeeName", "职员");
        employeeNameItem.setWidth("*");
        departmentIdItem = new IPickTreeItem("departmentId", "部门");
        departmentIdItem.setWidth("*");
        departmentIdItem.setCanSelectParentItems(true);
        departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
//        departmentIdItem.hide();
        roleIdItem = new SelectItem("roleId", "角色");
        roleIdItem.setWidth("*");
//        roleIdItem.setValueMap(KeyValueManager.getValueMap("roles"));
        KeyValueManager.loadValueMap("roles",roleIdItem);
        gradeIdItem = new SelectItem("gradeId", "等级");
        gradeIdItem.setWidth("*");
        gradeIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));

        setItems(employeeNameItem,gradeIdItem,departmentIdItem);

        setNumCols(6);
    }

}
