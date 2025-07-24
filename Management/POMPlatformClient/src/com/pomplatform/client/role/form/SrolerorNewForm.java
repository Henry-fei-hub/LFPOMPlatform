package com.pomplatform.client.role.form;

import com.delicacy.client.data.KeyValueManager;
import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.role.datasource.DSSroleror;

public class SrolerorNewForm extends AbstractWizadPage {

    private final TextItem roleNameItem;
    private final TextItem applicationIdItem;
    private final SelectItem roleTypeItem;
    private final CheckboxItem enabledItem;

    public SrolerorNewForm() {
        __form = new DynamicForm();
        DSSroleror ds = DSSroleror.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        roleNameItem = new TextItem("roleName", "角色名称");
        roleNameItem.setWidth("*");
        applicationIdItem = new TextItem("applicationId", "应用系统代码");
        applicationIdItem.setWidth("*");
        applicationIdItem.hide();
        roleTypeItem = new SelectItem("roleType", "角色类型");
        roleTypeItem.setWidth("*");
        roleTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_10"));
        enabledItem = new CheckboxItem("enabled", "是否有效");
        enabledItem.hide();

        __form.setItems(roleNameItem, applicationIdItem, roleTypeItem, enabledItem);

        __form.setDataSource(ds);
        __form.setNumCols(4);
        addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
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
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSSroleror.getInstance());
        manager.addMember(__form);
    }

    @Override
    public Map<String, FormItem> getItems() {
        Map<String, FormItem> res = new HashMap<String, FormItem>();
        res.put("roleName", roleNameItem);
        res.put("applicationId", applicationIdItem);
        res.put("roleType", roleTypeItem);
        res.put("enabled", enabledItem);
        return res;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        return __form.getValues();
    }

    private DynamicForm __form;

}
