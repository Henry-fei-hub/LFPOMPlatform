package com.pomplatform.client.mainprojectinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.mainprojectinfo.datasource.DSMmainprojectclientccmor;

public class MmainprojectclientccmorGroupname1New extends AbstractWizadPage {

    private final TextItem mainProjectIdItem;
    private final TextItem clientIdItem;
    private final TextItem clientNameItem;
    private final TextItem clientPhoneItem;
    private final TextItem clientCompanyItem;
    private final TextItem clientAddressItem;
    private final TextItem clientJobItem;
    private final TextItem clientWeixinItem;
    private final TextItem clientQqItem;
    private final TextItem clientEmailItem;
    private final SelectItem clientRoleItem;

    public MmainprojectclientccmorGroupname1New() {
        DSMmainprojectclientccmor ds = DSMmainprojectclientccmor.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        mainProjectIdItem = new TextItem("mainProjectId", "主项目编码");
        mainProjectIdItem.setWidth("*");
        mainProjectIdItem.setRequired(true);
        mainProjectIdItem.hide();
        IsIntegerValidator mainProjectIdValidator = new IsIntegerValidator();
        mainProjectIdItem.setValidators(mainProjectIdValidator);
        __formItems.add(mainProjectIdItem);
        clientIdItem = new TextItem("clientId", "客户编码");
        clientIdItem.setWidth("*");
        clientIdItem.setRequired(true);
        clientIdItem.hide();
        IsIntegerValidator clientIdValidator = new IsIntegerValidator();
        clientIdItem.setValidators(clientIdValidator);
        __formItems.add(clientIdItem);
        clientNameItem = new TextItem("clientName", "姓名");
        clientNameItem.setWidth("*");
        __formItems.add(clientNameItem);
        clientPhoneItem = new TextItem("clientPhone", "手机");
        clientPhoneItem.setWidth("*");
        __formItems.add(clientPhoneItem);
        clientCompanyItem = new TextItem("clientCompany", "单位名称");
        clientCompanyItem.setWidth("*");
        __formItems.add(clientCompanyItem);
        clientAddressItem = new TextItem("clientAddress", "单位地址");
        clientAddressItem.setWidth("*");
        __formItems.add(clientAddressItem);
        clientJobItem = new TextItem("clientJob", "职务");
        clientJobItem.setWidth("*");
        __formItems.add(clientJobItem);
        clientWeixinItem = new TextItem("clientWeixin", "微信");
        clientWeixinItem.setWidth("*");
        __formItems.add(clientWeixinItem);
        clientQqItem = new TextItem("clientQq", "QQ");
        clientQqItem.setWidth("*");
        __formItems.add(clientQqItem);
        clientEmailItem = new TextItem("clientEmail", "邮箱");
        clientEmailItem.setWidth("*");
        __formItems.add(clientEmailItem);
        clientRoleItem = new SelectItem("clientRole", "联系人角色");
        clientRoleItem.setValueMap((LinkedHashMap) ds.getField("clientRole").getValueMap());
        __formItems.add(clientRoleItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(2);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        setName("客户信息");
        addMember(__form);
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) {
            __form.editRecord(getRecord());
        } else {
            __form.editNewRecord();
        }
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSMmainprojectclientccmor.getInstance());
        manager.addMember(__form);
    }

    @Override
    public Map getValuesAsMap() {
        return __form.getValues();
    }

}
