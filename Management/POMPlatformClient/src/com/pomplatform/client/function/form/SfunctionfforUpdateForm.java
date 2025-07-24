package com.pomplatform.client.function.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.function.datasource.DSSfunctionffor;

public class SfunctionfforUpdateForm extends AbstractWizadPage {

    private final TextItem functionIdItem;
    private final TextItem functionCodeItem;
    private final TextItem parentIdItem;
    private final TextItem functionNameItem;
    private final TextItem applicationIdItem;
    private final TextItem functionTypeItem;
    private final TextItem privilegeTypeItem;
    private final CheckboxItem enabledItem;

    public SfunctionfforUpdateForm() {
        __form = new DynamicForm();
        DSSfunctionffor ds = DSSfunctionffor.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        functionIdItem = new TextItem("functionId", "功能编码");
        functionIdItem.setWidth("*");
        functionIdItem.setDisabled(true);
        functionIdItem.setRequired(true);
        IsIntegerValidator functionIdValidator = new IsIntegerValidator();
        functionIdItem.setValidators(functionIdValidator);
        functionCodeItem = new TextItem("functionCode", "功能编号");
        functionCodeItem.setWidth("*");
        parentIdItem = new TextItem("parentId", "上级功能");
        parentIdItem.setWidth("*");
        parentIdItem.hide();
        functionNameItem = new TextItem("functionName", "功能名称");
        functionNameItem.setWidth("*");
        applicationIdItem = new TextItem("applicationId", "应用系统代码");
        applicationIdItem.setWidth("*");
        applicationIdItem.hide();
        functionTypeItem = new TextItem("functionType", "功能类型");
        functionTypeItem.setWidth("*");
        functionTypeItem.hide();
        privilegeTypeItem = new TextItem("privilegeType", "数据权限类型");
        privilegeTypeItem.setWidth("*");
        privilegeTypeItem.hide();
        enabledItem = new CheckboxItem("enabled", "是否有效");

        __form.setItems(functionIdItem, functionCodeItem, parentIdItem, functionNameItem, applicationIdItem, functionTypeItem, privilegeTypeItem, enabledItem);

        __form.setDataSource(ds);
        __form.setNumCols(4);
        setPageMode(PAGE_MODE_UPDATE);
        addMember(__form);
    }

    @Override
    public Map<String, FormItem> getItems() {
        Map<String, FormItem> res = new HashMap<String, FormItem>();
        res.put("functionId", functionIdItem);
        res.put("functionCode", functionCodeItem);
        res.put("parentId", parentIdItem);
        res.put("functionName", functionNameItem);
        res.put("applicationId", applicationIdItem);
        res.put("functionType", functionTypeItem);
        res.put("privilegeType", privilegeTypeItem);
        res.put("enabled", enabledItem);
        return res;
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) {
            __form.editRecord(getRecord());
        }
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSSfunctionffor.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        return __form.getValues();
    }

    private DynamicForm __form;

}
