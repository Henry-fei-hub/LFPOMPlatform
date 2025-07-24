package com.pomplatform.client.projectintegraltransferrecord.form;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.projectintegraltransferrecord.datasource.CDMprojectintegraltransferrecord;

public class MprojectintegraltransferrecordSearchForm extends SearchForm {

    private final ComboBoxItem fromProjectIdItem;
    private final ComboBoxItem toProjectIdItem;
    private final ComboBoxItem plateIdItem;
    private final ComboBoxItem plateEmployeeIdItem;

    public MprojectintegraltransferrecordSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDMprojectintegraltransferrecord.getInstance());
        fromProjectIdItem = new ComboBoxItem("fromProjectId", "目标项目");
        fromProjectIdItem.setWidth("*");
        fromProjectIdItem.setChangeOnKeypress(false);
//        fromProjectIdItem.setValueMap(KeyValueManager.getValueMap("projects"));
        KeyValueManager.loadValueMap("projects",fromProjectIdItem);
        toProjectIdItem = new ComboBoxItem("toProjectId", "归属项目");
        toProjectIdItem.setWidth("*");
        toProjectIdItem.setChangeOnKeypress(false);
        KeyValueManager.loadValueMap("projects",toProjectIdItem);
//        toProjectIdItem.setValueMap(KeyValueManager.getValueMap("projects"));
        plateIdItem = new ComboBoxItem("plateId", "板块");
        plateIdItem.setWidth("*");
        plateIdItem.setChangeOnKeypress(false);
        plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        plateEmployeeIdItem = new ComboBoxItem("plateEmployeeId", "板块负责人");
        plateEmployeeIdItem.setWidth("*");
        plateEmployeeIdItem.setChangeOnKeypress(false);
        plateEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
        int roleID = ClientUtil.getRoleId();
        //如果不是高管的角色，则隐藏板块和板块负责人搜索
        if(roleID != RoleDefinition.ROLE_MANAGEMENT_TEAM){
            plateIdItem.hide();
            plateEmployeeIdItem.hide();
        }

        setItems(fromProjectIdItem, toProjectIdItem, plateIdItem, plateEmployeeIdItem);

        setNumCols(4);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
