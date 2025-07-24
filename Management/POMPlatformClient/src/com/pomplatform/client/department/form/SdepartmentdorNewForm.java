package com.pomplatform.client.department.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.department.datasource.DSSdepartmentdor;

public class SdepartmentdorNewForm extends AbstractWizadPage {

    private final TextItem departmentNameItem;
    private final TextItem abbreviationItem;
    private final ComboBoxItem managerIdItem;
    private final ComboBoxItem parentIdItem;

    public SdepartmentdorNewForm() {
        DSSdepartmentdor ds = DSSdepartmentdor.getInstance();
        __form.setWidth100();
        __form.setHeight100();
        departmentNameItem = new TextItem("departmentName", "部门名称");
        departmentNameItem.setWidth("*");
        departmentNameItem.setRequired(true);
        IsStringValidator departmentNameValidator = new IsStringValidator();
        LengthRangeValidator departmentNameLengthValidator = new LengthRangeValidator();
        departmentNameLengthValidator.setMax(64);
        departmentNameItem.setValidators(departmentNameValidator, departmentNameLengthValidator);
        __formItems.add(departmentNameItem);
        abbreviationItem = new TextItem("abbreviation", "部门名称缩写");
        abbreviationItem.setWidth("*");
        __formItems.add(abbreviationItem);
        managerIdItem = new ComboBoxItem("managerId", "部门负责人");
        managerIdItem.setWidth("*");
        managerIdItem.setChangeOnKeypress(false);
        managerIdItem.setValueMap((LinkedHashMap) ds.getField("managerId").getValueMap());
        __formItems.add(managerIdItem);
        parentIdItem = new ComboBoxItem("parentId", "上级部门");
        parentIdItem.setWidth("*");
        parentIdItem.setDefaultValue(1);
        parentIdItem.setChangeOnKeypress(false);
        parentIdItem.setValueMap((LinkedHashMap) ds.getField("parentId").getValueMap());
        __formItems.add(parentIdItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
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
        manager.setDataSource(DSSdepartmentdor.getInstance());
        manager.addMember(__form);
    }

    @Override
    public java.util.Map getValuesAsMap() {
        return __form.getValues();
    }

}
