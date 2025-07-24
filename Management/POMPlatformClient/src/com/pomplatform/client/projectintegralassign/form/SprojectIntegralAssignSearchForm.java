package com.pomplatform.client.projectintegralassign.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectintegralassign.datasource.CDSprojectIntegralAssign;

public class SprojectIntegralAssignSearchForm extends SearchForm {

    private final ComboBoxItem projectIdItem;
    private final ComboBoxItem employeeIdItem;
    private final ComboBoxItem plateIdItem;

    public SprojectIntegralAssignSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDSprojectIntegralAssign.getInstance());
        plateIdItem = new ComboBoxItem("plateId", "业务部门");
        plateIdItem.setWidth("*");
        plateIdItem.setChangeOnKeypress(false);
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        projectIdItem = new ComboBoxItem("projectId", "项目");
        projectIdItem.setWidth("*");
        projectIdItem.setChangeOnKeypress(false);
//        KeyValueManager.loadValueMap("projects",projectIdItem);
        KeyValueManager.loadValueMap("projects", projectIdItem);
        employeeIdItem = new ComboBoxItem("employeeId", "人员");
        employeeIdItem.setWidth("*");
        employeeIdItem.setChangeOnKeypress(false);
        employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
        setItems(plateIdItem,projectIdItem, employeeIdItem);

        setNumCols(6);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
