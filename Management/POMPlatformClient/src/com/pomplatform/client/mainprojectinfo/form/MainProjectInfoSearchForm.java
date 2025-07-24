package com.pomplatform.client.mainprojectinfo.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.mainprojectinfo.datasource.CDMainProjectInfo;

public class MainProjectInfoSearchForm extends SearchForm {

    private final ComboBoxItem projectCodeItem;
    private final SelectItem projectBaseOnItem;
    private final CheckboxItem hasContractItem;

    public MainProjectInfoSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDMainProjectInfo.getInstance());
        projectCodeItem = new ComboBoxItem("projectCode", "项目名称");
        projectCodeItem.setWidth("*");
        projectCodeItem.setChangeOnKeypress(false);
//        projectCodeItem.setValueMap(KeyValueManager.getValueMap("main_projects"));
        KeyValueManager.loadValueMap("main_projects",projectCodeItem);
        projectBaseOnItem = new SelectItem("projectBaseOn", "立项依据");
        projectBaseOnItem.setWidth("*");
        projectBaseOnItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));
        hasContractItem = new CheckboxItem("hasContract", "是否有合同");

        setItems(projectCodeItem, projectBaseOnItem, hasContractItem);

        setNumCols(6);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
