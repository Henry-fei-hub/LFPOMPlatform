package com.pomplatform.client.mainprojectinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.mainprojectinfo.datasource.CDMmainprojectclientccmor;

public class MmainprojectclientccmorSearchForm extends SearchForm {

    private final SelectItem clientRoleItem;
    private final TextItem mainProjectIdItem;
    private final TextItem nameItem;

    public MmainprojectclientccmorSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDMmainprojectclientccmor.getInstance());
        nameItem = new TextItem("clientName", "姓名");
        nameItem.setWidth("*");
        clientRoleItem = new SelectItem("clientRole", "联系人角色");
        clientRoleItem.setWidth("*");
        clientRoleItem.setValueMap((LinkedHashMap) getDataSource().getField("clientRole").getValueMap());
        mainProjectIdItem = new TextItem("mainProjectId", "主项目编码");
        mainProjectIdItem.setWidth("*");
        mainProjectIdItem.hide();

        setItems(nameItem, clientRoleItem, mainProjectIdItem);

        setNumCols(4);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

}
