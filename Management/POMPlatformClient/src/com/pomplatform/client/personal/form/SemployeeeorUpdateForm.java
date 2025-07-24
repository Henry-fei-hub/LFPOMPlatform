package com.pomplatform.client.personal.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.personal.datasource.DSSemployeeeor;

public class SemployeeeorUpdateForm extends AbstractWizadPage {

    private final TextItem employeeNoItem;
    private final TextItem employeeNameItem;
    private final SelectItem departmentIdItem;
    private final SelectItem roleIdItem;
    private final SelectItem gradeIdItem;
    private final TextItem mobileItem;
    private final TextItem phoneItem;
    private final TextItem qqItem;
    private final TextItem emailItem;
    private final TextItem photoItem;
    private final TextItem addressItem;
    private final SelectItem plateIdItem;

    public SemployeeeorUpdateForm() {
        __form = new DynamicForm();
        DSSemployeeeor ds = DSSemployeeeor.getInstance();
        __form.setWidth100();
        __form.setHeight100();

        employeeNoItem = new TextItem("employeeNo", "登陆名");
        employeeNoItem.setWidth("*");
        employeeNoItem.setRequired(true);
        IsStringValidator employeeNoValidator = new IsStringValidator();
        LengthRangeValidator employeeNoLengthValidator = new LengthRangeValidator();
        employeeNoLengthValidator.setMax(64);
        employeeNoItem.setValidators(employeeNoValidator, employeeNoLengthValidator);
        employeeNameItem = new TextItem("employeeName", "员工姓名");
        employeeNameItem.setWidth("*");
        employeeNameItem.setRequired(true);
        IsStringValidator employeeNameValidator = new IsStringValidator();
        LengthRangeValidator employeeNameLengthValidator = new LengthRangeValidator();
        employeeNameLengthValidator.setMax(64);
        employeeNameItem.setValidators(employeeNameValidator, employeeNameLengthValidator);
        departmentIdItem = new SelectItem("departmentId", "角色");
        departmentIdItem.setWidth("*");
        departmentIdItem.setValueMap((LinkedHashMap) ds.getField("departmentId").getValueMap());
        roleIdItem = new SelectItem("roleId", "部门编码");
        roleIdItem.setWidth("*");
        roleIdItem.setValueMap((LinkedHashMap) ds.getField("roleId").getValueMap());
        gradeIdItem = new SelectItem("gradeId", "等级");
        gradeIdItem.setWidth("*");
        gradeIdItem.setValueMap((LinkedHashMap) ds.getField("gradeId").getValueMap());
        mobileItem = new TextItem("mobile", "手机");
        mobileItem.setWidth("*");
        phoneItem = new TextItem("phone", "电话");
        phoneItem.setWidth("*");
        qqItem = new TextItem("qq", "QQ");
        qqItem.setWidth("*");
        emailItem = new TextItem("email", "邮箱");
        emailItem.setWidth("*");
        photoItem = new TextItem("photo", "头像");
        photoItem.setWidth("*");
        addressItem = new TextItem("address", "家庭地址");
        addressItem.setWidth("*");
        plateIdItem = new SelectItem("plateId", "业务部门");
        plateIdItem.setWidth("*");
        plateIdItem.setValueMap((LinkedHashMap) ds.getField("plateId").getValueMap());

        __form.setItems(employeeNoItem, employeeNameItem, departmentIdItem, roleIdItem, gradeIdItem, mobileItem, phoneItem, qqItem, emailItem, photoItem, addressItem, plateIdItem);

        __form.setDataSource(ds);
        __form.setNumCols(4);
        setPageMode(PAGE_MODE_UPDATE);
        addMember(__form);
    }

    @Override
    public Map<String, FormItem> getItems() {
        Map<String, FormItem> res = new HashMap<>();
        res.put("employeeNo", employeeNoItem);
        res.put("employeeName", employeeNameItem);
        res.put("departmentId", departmentIdItem);
        res.put("roleId", roleIdItem);
        res.put("gradeId", gradeIdItem);
        res.put("mobile", mobileItem);
        res.put("phone", phoneItem);
        res.put("qq", qqItem);
        res.put("email", emailItem);
        res.put("photo", photoItem);
        res.put("address", addressItem);
        res.put("plateId", plateIdItem);
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
        manager.setDataSource(DSSemployeeeor.getInstance());
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
