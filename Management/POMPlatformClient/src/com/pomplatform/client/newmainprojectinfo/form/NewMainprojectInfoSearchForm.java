package com.pomplatform.client.newmainprojectinfo.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.newmainprojectinfo.datasource.CDNewMainprojectInfo;

public class NewMainprojectInfoSearchForm extends SearchForm {

    private final TextItem projectCodeItem;
    private final TextItem projectNameItem;
    private final SelectItem projectBaseOnItem;
    private final CheckboxItem hasContractItem;

    public NewMainprojectInfoSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDNewMainprojectInfo.getInstance());
        projectCodeItem = new TextItem("projectCode", "项目编号");
        projectCodeItem.setWidth("*");
        projectNameItem = new TextItem("projectName", "项目名称");
        projectNameItem.setWidth("*");
        projectBaseOnItem = new SelectItem("projectBaseOn", "立项依据");
        projectBaseOnItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));
        projectBaseOnItem.setWidth("*");
        hasContractItem = new CheckboxItem("hasContract", "是否有合同");

        setItems(projectCodeItem, projectNameItem, projectBaseOnItem, hasContractItem);

        setNumCols(8);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
